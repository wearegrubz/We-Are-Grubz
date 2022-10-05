package edu.famu.booking.controllers;
import edu.famu.booking.models.parse.Hotel;
import edu.famu.booking.services.HotelService;
import edu.famu.booking.models.serializable.SerializableHotel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController //identified this class a controller used for REST API class.
@RequestMapping("/api/v1/hotel") //sets up the base url for all calls to methods in this file
public class HotelController {

    private HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    //get all
    @GetMapping("/") //sets the path to this method
    public ArrayList<SerializableHotel> getHotels() {
        ArrayList<SerializableHotel> rooms = new ArrayList<>();

        //Convert the Parse Product object to a POJO Product object that can be serialized by Spring
        ArrayList<Hotel> list = hotelService.retrieveHotels();
        for(Hotel p : list)
        {
            rooms.add(p.getSerializable());
        }
        return rooms;
    }

    //get only one based on object id
    @GetMapping("/find/{id}")
    public SerializableHotel getProductById(@PathVariable String id){
        return hotelService.getHotelById(id).getSerializable();
    }
}
