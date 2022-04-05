package com.SpringBoot.CousreApiApp;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
class TopicController {
    @Autowired
    private TopicService topicservice;

    @RequestMapping("/topics")
    List<Topics> getAllTopics() {
        return topicservice.getAllTopics();
    }

    @RequestMapping("/topics/{id}")
    public Topics getTopic(@PathVariable String id) {
        return topicservice.getTopic(id);
    }

    public void addTopic(@RequestBody Topics topic) {
        topicservice.addTopic(topic);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    public void updateTopic(@RequestBody Topics topic, @PathVariable String id) {
        topicservice.updateTopic(id, topic);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    public void deleteTopic(@PathVariable String id) {
        topicservice.deleteTopic(id);
    }
}

