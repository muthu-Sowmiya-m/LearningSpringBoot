package com.SpringBoot.HttpMethodsandErrorCodes;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService
{
    List <Topics> topics =  new ArrayList<>(Arrays.asList(
            new Topics("1","Java","Learning Java"),
            new Topics("2","Spring","Learn Spring Framework"),
            new Topics("3","Spring Boot","Learn Spring Boot")));


    public List<Topics> getAllTopics()
    {
        return topics;
    }

    public Topics getTopic(String id)
    {
        return topics.stream().filter(t -> t.getid().equals(id)).findFirst().get();
    }

    public void addTopic(Topics topic)
    {
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
