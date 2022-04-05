package com.Springboot.Service;

import java.util.*;

import com.Springboot.Entity.Topics;
import com.Springboot.Exception.CustomException.InputException;
import com.Springboot.Exception.CustomException.ServiceException;
import org.springframework.stereotype.Service;


@Service
public class TopicService
{
List <Topics> topics = new ArrayList<>(Arrays.asList(
        new Topics("1","Java","Learning Java"),
        new Topics("2","Spring","Learn Spring Framework"),
        new Topics("3","Spring Boot","Learn Spring Boot")));

    public List<Topics> getAllTopics()
    {
        return topics;
    }

    public Topics getTopic(String id)
    {
        int i = Integer.valueOf(id);
        if (i == 0 || i > 10)
        {
            throw new ServiceException("The id is invalid..Use a valid id!!");
            //return ResponseEntity.badRequest().body("No records found");
        }
        return topics.stream().filter(t -> t.getid().equals(id)).findFirst().get();
    }


    public void addTopic(Topics topic)
    {
        if(topic.getName().isEmpty() || topic.getid().isEmpty())
        {
            throw new InputException("The name or Id of topic cannot be empty!!!");
        }
        topics.add(topic);
    }

    public void updateTopic(String id, Topics topic)
    {
        for(int i=0 ; i < topics.size();i++)
        {
            Topics t = topics.get(i);
            if(t.getid().equals(id))
            {
                topics.set(i,topic);
                return;
            }
        }
    }

    public void deleteTopic(String id)
    {
        topics.removeIf(t ->t.getid().equals(id));
    }
}
