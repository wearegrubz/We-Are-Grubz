package edu.famu.grubz.services;

import edu.famu.grubz.models.Taste;
import edu.famu.grubz.models.parse.Group;
import edu.famu.grubz.models.serializable.SerializableGroup;
import org.json.JSONArray;
import org.parse4j.ParseObject;
import org.springframework.stereotype.Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.parse4j.Parse;
import org.parse4j.ParseException;
import org.parse4j.ParseQuery;

import java.util.*;

@Service
public class GroupService {

    protected final Log logger = LogFactory.getLog(this.getClass()); //used to write to the console

    public ArrayList<Group> retrieveGroups()
    {
        logger.info(Parse.isIsRootMode());
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
        logger.info(groups.size());
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
        logger.info("service is running");
        String message = null; //message we will return to the user

        Group group = this.getGroupById(groupID);

        ArrayList<String> userIds = group.getUserIds();

        userIds.add(userID);

        logger.info(userIds);

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

        logger.info(tastes);
        logger.info(taste);

        JSONArray items = new JSONArray();

        for(Object c : tastes)
            items.put(c);

        items.put(taste);

        logger.info(items);

        ParseQuery<Group> query = ParseQuery.getQuery(Group.class);

        try {
            gp = query.get(groupID);
            //logger.info(groupID)
            logger.info(gp);
            gp.put("tastes", items);
            //gp.add("tastes", taste);
            gp.save();
            message = "Taste added to group";

        } catch (ParseException e) {
            e.printStackTrace();
            message = "Error adding taste to group. " + e.getMessage(); // failure message
        }

        return message;
    }


}
