package com.SpringBoot.HttpMethodsandErrorCodes;
import java.util.*;

import com.SpringBoot.HttpMethodsandErrorCodes.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
class TopicController
{
    @Autowired
    private TopicService topicservice;

    @GetMapping(value = "/topics", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<Topics>> getAllTopics()
    {
        List<Topics> getalltopics = topicservice.getAllTopics();
        return new ResponseEntity<List<Topics>>(getalltopics, HttpStatus.OK);
    }

    @GetMapping("/topics/{id}")
    public ResponseEntity<Topics> getTopic(@PathVariable String id)
    {
        ResponseEntity<Topics> response = null;
        Topics gettopic;
        if (id.equals("Null"))
        {
            return new ResponseEntity<Topics>(HttpStatus.BAD_REQUEST);
        }
        else
        {
            gettopic = topicservice.getTopic(id);
            response = new ResponseEntity<Topics>(gettopic, HttpStatus.OK);
        }
        return response;
    }

    @PostMapping(value = "/topics",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Void> addTopic(@RequestBody Topics topic)
    {
        topicservice.addTopic(topic);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/topics/{id}")
    public ResponseEntity<Void> updateTopic(@RequestBody Topics topic,@PathVariable String id)
    {
        topicservice.updateTopic(id,topic);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/topics/{id}")
    public ResponseEntity<Void> deleteTopic(@PathVariable String id)
    {
        topicservice.deleteTopic(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

}
