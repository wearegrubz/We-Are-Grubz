package edu.famu.grubz.services;

import edu.famu.grubz.models.parse.Group;
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

}
