package edu.famu.grubz.services;

import edu.famu.grubz.models.parse.User;
import edu.famu.grubz.models.serializable.SerializableUser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.parse4j.Parse;
import org.parse4j.ParseException;
import org.parse4j.ParseQuery;
import org.parse4j.ParseUser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    protected final Log logger = LogFactory.getLog(this.getClass()); //used to write to the console

    public ArrayList<SerializableUser> retrieveUsers()
    {
        logger.info(Parse.isIsRootMode());
        final ArrayList<SerializableUser> users = new ArrayList<>();

        ParseQuery<ParseUser> query = ParseQuery.getQuery(ParseUser.class);

        try {
            List<ParseUser> list = query.find();
            for (ParseUser p : list) {
                logger.info(p.toString()); //use if you want to see your products in the console
                users.add(new SerializableUser(p.getObjectId(), p.getString("name"), p.getUsername(), p.getEmail(), p.getString("password")));
            }
        }
        catch(Exception e)
        {
            logger.error("Error occurred", e);
        }
        logger.info(users.size());
        return users;
    }

    public SerializableUser getUserById(String id)
    {
        ParseUser user = null;

        //defines the query for the product class
        ParseQuery<ParseUser> query = ParseQuery.getQuery(ParseUser.class);

        try{
            user = query.get(id); //gets a single record based on objectId

        }catch (ParseException e)
        {
            e.printStackTrace();
            return null;
        }

        return new SerializableUser(user.getObjectId(), user.getString("name"), user.getUsername(), user.getEmail(), user.getString("password"));
    }

    public String addUser(SerializableUser user)
    {
        String message = ""; //message we will return to the user

        //REMAINING CODE GOES HERE
        User parseUser = new User(); //Parse Product Object

        //set the value of each of the fields
        parseUser.put("name", user.getName());
        parseUser.setUsername(user.getUsername());
        parseUser.setPassword(user.getPassword());
        parseUser.setEmail(user.getEmail());

        try {
            parseUser.signUp();
            message="User Created";
        } catch (ParseException e) {
            message = "Error creating user. " + e.getMessage();
            e.printStackTrace();
        }
        return message;
    }
}
