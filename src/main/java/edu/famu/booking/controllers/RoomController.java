package edu.famu.booking.controllers;
import edu.famu.booking.models.parse.Room;
import edu.famu.booking.services.RoomService;
import edu.famu.booking.models.serializable.SerializableRoom;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController //identified this class a controller used for REST API class.
@RequestMapping("/api/v1/hotel") //sets up the base url for all calls to methods in this file

public class RoomController {

    private RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    //get all
    @GetMapping("/") //sets the path to this method
    public ArrayList<SerializableRoom> getRooms() {
        ArrayList<SerializableRoom> rooms = new ArrayList<>();

        //Convert the Parse Product object to a POJO Product object that can be serialized by Spring
        ArrayList<Room> list = roomService.retrieveRooms();
        for(Room p : list)
        {
            rooms.add(p.getSerializable());
        }
        return rooms;
    }

    //get only one based on object id
    @GetMapping("/find/{id}")
    public SerializableRoom getProductById(@PathVariable String id){
        return roomService.getRoomById(id).getSerializable();
    }

}
