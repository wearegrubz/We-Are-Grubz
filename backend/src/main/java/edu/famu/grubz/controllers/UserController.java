package edu.famu.grubz.controllers;

import edu.famu.grubz.models.parse.User;
import edu.famu.grubz.models.serializable.SerializableUser;
import edu.famu.grubz.services.UserService;
import org.parse4j.ParseUser;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = {"/"}) //sets the path to this method
    public ArrayList<SerializableUser> getUserList() {
        ArrayList<SerializableUser> users = new ArrayList<>();

        //Convert the Parse Product object to a POJO Product object that can be serialized by Spring
        ArrayList<SerializableUser> list = userService.retrieveUsers();
        for(SerializableUser p : list)
        {
            users.add(p);
        }
        return users;
    }

    @GetMapping("/find/{id}")
    public SerializableUser getUserById(@PathVariable String id){
        return userService.getUserById(id);
    }

    @PostMapping("/")
    public String createUser(@RequestBody SerializableUser user){
        return userService.addUser(user);
    }
}
