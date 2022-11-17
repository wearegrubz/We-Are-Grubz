package edu.famu.grubz.services;

import com.google.gson.Gson;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.parser.JSONParser;
import okhttp3.*;
import io.github.cdimascio.dotenv.Dotenv;
import edu.famu.grubz.models.Taste;
import edu.famu.grubz.models.parse.Group;
import edu.famu.grubz.models.serializable.SerializableGroup;
import org.apache.http.client.methods.RequestBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import org.parse4j.ParseObject;
import org.springframework.boot.json.JsonParser;
import org.springframework.stereotype.Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.parse4j.Parse;
import org.parse4j.ParseException;
import org.parse4j.ParseQuery;


import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

@Service
public class GroupService {

    protected final Log logger = LogFactory.getLog(this.getClass()); //used to write to the console

    protected Dotenv dotenv = Dotenv.configure().filename("env").load();

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
        parseGroup.setUserIds(group.getUserIds());
        parseGroup.setLocation(group.getLocation());
        parseGroup.setRadius(group.getRadius());
        parseGroup.setTastes(group.getTastes());
        parseGroup.setRecommendations(group.getRecommendations());


        try {
            parseGroup.save(); //runs the query to insert the new value
            message = "Group Created"; //set success the return message

        } catch (ParseException e) {
            e.printStackTrace(); //print the error to the console.
            // set the error return message
            message = "Error creating group. " + e.getMessage();
        }
        return message;
    }

    public String addUserToGroup(String userID, String groupID)
    {
        String message = null; //message we will return to the user

        Group group = this.getGroupById(groupID);

        ArrayList<String> userIds = group.getUserIds();

        userIds.add(userID);

        ParseQuery<Group> query = ParseQuery.getQuery(Group.class);

        try {
            Group gp = query.get(groupID);
            gp.put("userIds", userIds);
            gp.save();

            message = "User added to group";

        } catch (ParseException e) {
            e.printStackTrace();
            message = "Error adding user to group. " + e.getMessage(); // failure message
        }

        return message;
    }

    public String addTasteToGroup(Map<String, Object> taste, String groupID)
    {
        String message = null; //message we will return to the user

        ParseObject gp = null;

        Group group = this.getGroupById(groupID);

        ArrayList<Taste> tastes = group.getTastes();

        JSONArray items = new JSONArray();

        for(Object c : tastes)
            items.put(c);

        items.put(taste);

        ParseQuery<Group> query = ParseQuery.getQuery(Group.class);

        try {
            gp = query.get(groupID);
            gp.put("tastes", items);
            gp.save();
            message = "Taste added to group";

        } catch (ParseException e) {
            e.printStackTrace();
            message = "Error adding taste to group. " + e.getMessage(); // failure message
        }

        return message;
    }

    private Set<String> analyzeTaste(Group group){

        Set<String> set = new HashSet<>();

        ArrayList<Taste> tastes = group.getTastes();

        for (Object c : tastes) {

            int start = c.toString().indexOf("[")+1;
            int end = c.toString().indexOf("]");
            String taste_str = c.toString().subSequence(start, end).toString();
            String[] taste_arr = taste_str.split(", ");
            for(String taste : taste_arr)
                set.add(taste);

        }
        return set;
    }

    protected Request getYelpRequestHttp(Group group, String cuisine) {

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

    public Object retrieveReccomendation(String groupId) {

        String message = null;

        Response response = null;

        JSONObject entity = null;

        OkHttpClient client = new OkHttpClient();

        Group group = this.getGroupById((groupId));

        Request requesthttp = null;

        Set<String> taste = this.analyzeTaste(group);

        JSONArray reccomendations = new JSONArray();

        try{

            for(String cuisine : taste){

                requesthttp = this.getYelpRequestHttp(group, cuisine);

                response = client.newCall(requesthttp).execute();

                entity = new JSONObject(response.body().string());

                JSONArray c = entity.getJSONArray("businesses");

                for (int i = 0 ; i < c.length(); i++) {

                    JSONObject obj = c.getJSONObject(i);
                    if (i > 5) break;
                    reccomendations.put(obj);
                }

            }

        }catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        return gson.fromJson(reccomendations.toString(), Object.class);

    }

}
