package edu.famu.grubz.controllers;

import edu.famu.grubz.services.GroupService;
import edu.famu.grubz.services.YelpService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/yelp")
public class YelpController {
    private YelpService yelpService;

    public YelpController(YelpService groupService) {
        this.yelpService = yelpService;
    }
}
