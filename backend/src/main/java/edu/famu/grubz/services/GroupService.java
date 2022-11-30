package edu.famu.grubz.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import edu.famu.grubz.models.Member;
import okhttp3.*;
import io.github.cdimascio.dotenv.Dotenv;
import edu.famu.grubz.models.parse.Group;
import edu.famu.grubz.models.serializable.SerializableGroup;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parse4j.ParseObject;
import org.springframework.stereotype.Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.parse4j.ParseException;
import org.parse4j.ParseQuery;
import java.io.IOException;
import java.util.*;

@Service
public class GroupService {

    protected final Log logger = LogFactory.getLog(this.getClass()); //used to write to the console

    private Dotenv dotenv = Dotenv.configure().filename("env").load();

    public ArrayList<Group> retrieveGroups()
    {
        final ArrayList<Group> groups = new ArrayList<>();

        ParseQuery<Group> query = ParseQuery.getQuery(Group.class);

        try {
            List<Group> list = query.find();
            for (Group p : list) {
                //logger.info(p.toString()); //use if you want to see your products in the console
                groups.add(p);
            }
        }
        catch(Exception e)
        {
            logger.error("Error occurred", e);
        }
        return groups;
    }

    public Group getGroupById(String id)
    {
        Group group = null;

        //defines the query for the product class
        ParseQuery<Group> query = ParseQuery.getQuery(Group.class);

        try{
            group = query.get(id); //gets a single record based on objectId
        }catch (ParseException e)
        {
            e.printStackTrace();
        }

        return group;
    }

    public String addGroup(SerializableGroup group)
    {
        String message; //message we will return to the user

        //REMAINING CODE GOES HERE
        Group parseGroup = new Group(); //Parse Product Object

        //set the value of each of the fields
        parseGroup.setHostId(group.getHostId());
        parseGroup.setMembers(group.getMembers());
        parseGroup.setLocation(group.getLocation());
        parseGroup.setRadius(group.getRadius());
        parseGroup.setTastes(group.getTastes());


        try {
            parseGroup.save(); //runs the query to insert the new value
            message = "Group Created"; //set success the return message

        } catch (ParseException e) {
            e.printStackTrace(); //print the error to the console.
            // set the error return message
            message = "Error creating group. " + e.getMessage();
        }
        return parseGroup.getObjectId();
    }

    private JSONArray updateTaste (String selection, Group group){

        ArrayList<String> tastes = group.getTastes();

        int start = selection.indexOf("[")+1;
        int end = selection.indexOf("]");
        String selection_str = selection.subSequence(start, end).toString();
        String[] selection_arr = selection_str.split(", ");
        for(String c : selection_arr){
            if(tastes.contains(c) == false){
                tastes.add(c);
            }
        }

        JSONArray list = new JSONArray();
        for(Object s : tastes)
            list.put(s);

        return list;
    }

    public String addMemberToGroup(Map<String, Object> member, String groupID)
    {
        String message = null; //message we will return to the user

        Group group = this.getGroupById(groupID);

        String selection = member.get("selections").toString();

        JSONArray updated_taste = this.updateTaste(selection, group);

        ArrayList<Member> members = group.getMembers();

        JSONArray items = new JSONArray();

        for(Object c : members)
            items.put(c);

        items.put(member);

        ParseQuery<Group> query = ParseQuery.getQuery(Group.class);

        logger.info(items);

        try {
            Group gp = query.get(groupID);
            gp.put("tastes", updated_taste);
            gp.put("members", items);
            gp.save();

            message = "Member added to group";

        } catch (ParseException e) {
            e.printStackTrace();
            message = "Error adding member to group. " + e.getMessage(); // failure message
        }

        return message;
    }




    private Request getYelpRequestHttp(Group group, String cuisine) {

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("https")
                .host("api.yelp.com")
                .addPathSegment("v3")
                .addPathSegment("businesses")
                .addPathSegment("search")
                .addQueryParameter("location", group.getLocation())
                .addQueryParameter("radius", Integer.toString(group.getRadius()))
                .addQueryParameter("limit", Integer.toString(50))
                .addQueryParameter("categories", cuisine)
                .addQueryParameter("sort_by", "rating")
                .build();


        Request requesthttp = new Request.Builder()
                .addHeader("Authorization", "Bearer " + dotenv.get("YELP_API_KEY"))
                .url(httpUrl)
                .build();

        return requesthttp;
    }

    private JSONArray shuffleReccomendations (JSONArray array) throws JSONException {
        // Implementing Fisher–Yates shuffle
        Random rnd = new Random();
        for (int i = array.length() - 1; i >= 0; i--)
        {
            int j = rnd.nextInt(i + 1);
            // Simple swap
            Object object = array.get(j);
            array.put(j, array.get(i));
            array.put(i, object);
        }
        return array;
    }

    public Object retrieveReccomendation(String groupId) {

        Response response = null;

        JSONObject entity = null;

        OkHttpClient client = new OkHttpClient();

        Group group = this.getGroupById((groupId));

        Request requesthttp = null;

        Set<String> seen = new HashSet<>();

        ArrayList<String> taste = group.getTastes();

        JSONArray reccomendations = new JSONArray();

        try{

            for(String cuisine : taste){

                requesthttp = this.getYelpRequestHttp(group, cuisine);

                response = client.newCall(requesthttp).execute();

                entity = new JSONObject(response.body().string());

                JSONArray c = entity.getJSONArray("businesses");

                int max = 5;

                for (int i = 0 ; i < c.length(); i++) {

                    JSONObject obj = c.getJSONObject(i);

                    if (seen.contains(obj.get("name").toString())){
                        max = max + 1;
                        continue;
                    }

                    if (i > max) break;

                    reccomendations.put(obj);

                    logger.info(obj.get("name").toString());
                    seen.add(obj.get("name").toString());
                }

            }

        }catch (IOException e) {
            e.printStackTrace();
        }

        reccomendations = this.shuffleReccomendations(reccomendations);

        Gson gson = new Gson();
        return gson.fromJson(reccomendations.toString(), Object.class);
    }

}


