package edu.famu.booking.controllers;
import edu.famu.booking.models.parse.User;
import edu.famu.booking.models.serializable.SerializableUser;
import edu.famu.booking.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Optional;

@RestController //identified this class a controller used for REST API class.
@RequestMapping("/api/v1/user") //sets up the base url for all calls to methods in this file

public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //get all
    @GetMapping(value = {"/", "{sort}/"})  //sets the path to this method
    public ArrayList<SerializableUser> getUsers(@PathVariable Optional<String> sort) {
        ArrayList<SerializableUser> users = new ArrayList<>();

        //Convert the Parse Product object to a POJO Product object that can be serialized by Spring
        ArrayList<User> list = userService.retrieveUsers(sort);
        for(User p : list)
        {
            users.add(p.getSerializable());
        }
        return users;
    }

    //get only one based on object id
    @GetMapping("/find/{id}")
    public SerializableUser getProductById(@PathVariable String id){
        return userService.getUserById(id).getSerializable();
    }

}
