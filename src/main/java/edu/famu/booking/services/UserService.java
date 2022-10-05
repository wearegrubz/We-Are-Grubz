package edu.famu.booking.services;
import edu.famu.booking.models.parse.Hotel;
import edu.famu.booking.models.parse.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.parse4j.Parse;
import org.parse4j.ParseException;
import org.parse4j.ParseQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    protected final Log logger = LogFactory.getLog(this.getClass()); //used to write to the console

    public ArrayList<User> retrieveUsers(Optional<String> sort)
    {

        logger.info(Parse.isIsRootMode());
        final ArrayList<User> users = new ArrayList<>();

        ParseQuery<User> query = ParseQuery.getQuery(User.class);
        List<User> list = null;

        try {
            if(sort.isPresent()) {
                if(sort.equals("asc")){
                    list = query.addAscendingOrder("id").find();
                } else if (sort.equals("dsc")) {
                    list = query.addDescendingOrder("id").find();
                }
            }
            else{
                list = query.find();
            }
            for (User p : list) {
                //logger.info(p.toString()); //use if you want to see your products in the console
                users.add(p);
            }
        }
        catch(Exception e)
        {
            logger.error("Error occurred", e);
        }
        logger.info(users.size());
        return users;
    }

    public User getUserById(String id)
    {
        User user = null;

        //defines the query for the product class
        ParseQuery<User> query = ParseQuery.getQuery(User.class);

        try{
            user = query.get(id); //gets a single record based on objectId
        }catch (ParseException e)
        {
            e.printStackTrace();
        }

        return user;
    }

}