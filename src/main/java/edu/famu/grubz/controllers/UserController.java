package edu.famu.grubz.controllers;

import edu.famu.grubz.models.parse.User;
import edu.famu.grubz.models.serializable.SerializableUser;
import edu.famu.grubz.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        ArrayList<User> list = userService.retrieveUsers();
        for(User p : list)
        {
            users.add(p.getSerializable());
        }
        return users;
    }
}
