package edu.famu.grubz.controllers;

import edu.famu.grubz.models.parse.Group;
import edu.famu.grubz.models.serializable.SerializableGroup;
import edu.famu.grubz.services.GroupService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

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

    @CrossOrigin(origins="*")
    @GetMapping("/find/{id}")
    public SerializableGroup getGroupById(@PathVariable String id){
        return groupService.getGroupById(id).getSerializable();
    }

    @CrossOrigin(origins="*")
    @PostMapping("/")
    public String createGroup(@RequestBody SerializableGroup group){
        return groupService.addGroup(group);
    }

    @CrossOrigin(origins="*")
    @PostMapping("/add/member/{group-id}")
    public String addMember(@RequestBody Map<String, Object> member, @PathVariable("group-id") String groupId){

        return groupService.addMemberToGroup(member, groupId);
    }

    @CrossOrigin(origins="*")
    @GetMapping("/recommendation/{group-id}")
    public Object getRecommendation(@PathVariable("group-id") String groupId){

        return groupService.retrieveReccomendation(groupId);
    }

}
