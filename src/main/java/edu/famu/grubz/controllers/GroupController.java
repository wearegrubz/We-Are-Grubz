package edu.famu.grubz.controllers;

import edu.famu.grubz.models.parse.Group;
import edu.famu.grubz.models.serializable.SerializableGroup;
import edu.famu.grubz.services.GroupService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/group")
public class GroupController {

    private GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping(value = {"/"}) //sets the path to this method
    public ArrayList<SerializableGroup> getGroupList() {
        ArrayList<SerializableGroup> groups = new ArrayList<>();

        //Convert the Parse Product object to a POJO Product object that can be serialized by Spring
        ArrayList<Group> list = groupService.retrieveGroups();
        for(Group p : list)
        {
            groups.add(p.getSerializable());
        }
        return groups;
    }

}
