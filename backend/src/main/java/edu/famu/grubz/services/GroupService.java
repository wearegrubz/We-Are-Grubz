package edu.famu.grubz.services;

import edu.famu.grubz.models.parse.Group;
import edu.famu.grubz.models.serializable.SerializableGroup;
import org.springframework.stereotype.Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.parse4j.Parse;
import org.parse4j.ParseException;
import org.parse4j.ParseQuery;

import java.util.ArrayList;
import java.util.List;

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

}
