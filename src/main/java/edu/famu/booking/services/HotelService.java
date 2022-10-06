package edu.famu.booking.services;
import edu.famu.booking.models.parse.Hotel;
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
public class HotelService {
    protected final Log logger = LogFactory.getLog(this.getClass()); //used to write to the console

    public ArrayList<Hotel> retrieveHotels(String sort)
    {
        logger.info(Parse.isIsRootMode());
        final ArrayList<Hotel> hotels = new ArrayList<>();

        ParseQuery<Hotel> query = ParseQuery.getQuery(Hotel.class);
        List<Hotel> list = null;

        try {

            if(sort.equals("asc")){
                list = query.orderByAscending("cheapestPrice").find();
            } else if (sort.equals("dsc")) {
                list = query.orderByDescending("cheapestPrice").find();
            }

            for (Hotel p : list) {
                //logger.info(p.toString()); //use if you want to see your products in the console
                hotels.add(p);
            }
        }
        catch(Exception e)
        {
            logger.error("Error occurred", e);
        }
        logger.info(hotels.size());
        return hotels;
    }



    public Hotel getHotelById(String id)
    {
        Hotel hotel = null;

        //defines the query for the product class
        ParseQuery<Hotel> query = ParseQuery.getQuery(Hotel.class);

        try{
            hotel = query.get(id); //gets a single record based on objectId
        }catch (ParseException e)
        {
            e.printStackTrace();
        }

        return hotel;
    }

}
