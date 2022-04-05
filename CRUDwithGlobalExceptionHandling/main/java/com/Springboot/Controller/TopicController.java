package com.Springboot.Controller;
import java.util.*;

import com.Springboot.Entity.Topics;
import com.Springboot.Service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
class TopicController {
    @Autowired
    private TopicService topicservice;

    @GetMapping(value = "/topics", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<Topics>> getAllTopics()
    {
        List<Topics> getalltopics = topicservice.getAllTopics();
        return new ResponseEntity<List<Topics>>(getalltopics, HttpStatus.OK);
    }

    @GetMapping("/topics/{id}")
    public ResponseEntity<?> getTopic(@PathVariable String id)
    {
        ResponseEntity<Topics> response = null;
        Topics gettopic;
        gettopic = topicservice.getTopic(id);
        return ResponseEntity.ok().body(gettopic);
    }

    @PostMapping(value = "/topics",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> addTopic(@RequestBody Topics topic)
    {
        topicservice.addTopic(topic);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/topics/{id}")
    public ResponseEntity<Void> updateTopic(@RequestBody Topics topic,@PathVariable String id)
    {
        topicservice.updateTopic(id,topic);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/topics/{id}")
    public ResponseEntity<Void> deleteTopic(@PathVariable String id)
    {
        topicservice.deleteTopic(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
