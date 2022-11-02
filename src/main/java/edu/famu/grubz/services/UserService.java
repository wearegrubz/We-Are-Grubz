package edu.famu.grubz.services;

import edu.famu.grubz.models.parse.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.parse4j.Parse;
import org.parse4j.ParseQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    protected final Log logger = LogFactory.getLog(this.getClass()); //used to write to the console

    public ArrayList<User> retrieveUsers()
    {
        logger.info(Parse.isIsRootMode());
        final ArrayList<User> users = new ArrayList<>();

        ParseQuery<User> query = ParseQuery.getQuery(User.class);

        try {
            List<User> list = query.find();
            for (User p : list) {
                logger.info(p.toString()); //use if you want to see your products in the console
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
}
