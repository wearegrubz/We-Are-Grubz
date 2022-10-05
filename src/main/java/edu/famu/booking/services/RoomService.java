package edu.famu.booking.services;
import edu.famu.booking.models.parse.Room;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.parse4j.Parse;
import org.parse4j.ParseException;
import org.parse4j.ParseQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {
    protected final Log logger = LogFactory.getLog(this.getClass()); //used to write to the console

    public ArrayList<Room> retrieveRooms()
    {

        logger.info(Parse.isIsRootMode());
        final ArrayList<Room> rooms = new ArrayList<>();

        ParseQuery<Room> query = ParseQuery.getQuery(Room.class);
        try {
            List<Room> list = query.find();
            for (Room p : list) {
                //logger.info(p.toString()); //use if you want to see your products in the console
                rooms.add(p);
            }
        }
        catch(Exception e)
        {
            logger.error("Error occurred", e);
        }
        logger.info(rooms.size());
        return rooms;
    }

    public Room getRoomById(String id)
    {
        Room room = null;

        //defines the query for the product class
        ParseQuery<Room> query = ParseQuery.getQuery(Room.class);

        try{
            room = query.get(id); //gets a single record based on objectId
        }catch (ParseException e)
        {
            e.printStackTrace();
        }

        return room;
    }

}
