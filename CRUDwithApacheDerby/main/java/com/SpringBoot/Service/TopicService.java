package com.SpringBoot.Service;

import com.SpringBoot.Entity.Topics;
import com.SpringBoot.Exception.CustomExceptions.InputException;
import com.SpringBoot.Exception.CustomExceptions.ServiceException;
import com.SpringBoot.Repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TopicService
{

    @Autowired
    private TopicRepository topicRepository;

    public Topics getTopic(String id)
    {
        int i = Integer.valueOf(id);
        if (i == 0 || i > 10)
        {
            throw new ServiceException("The id is invalid..Use a valid id!!");
        }
        Topics topic = topicRepository.findById(id).get();
        return topic;
    }

    public List<Topics> getAllTopics()
    {
        List <Topics> topics = new ArrayList<>();
        topicRepository.findAll()
                .forEach(topics::add);

        if(topics.isEmpty())
        {
            throw new ServiceException("No Topics in DB");
        }
        return topics;
    }

    public void addTopic(Topics topic)
    {
        if(topic.getName().isEmpty() ||topic.getId().isEmpty() )
        {
            throw new InputException("The Id or Name cannot be empty!!");
        }
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topics topic)
    {
        topicRepository.save(topic);
    }

    public void deleteTopic(String id)
    {
        topicRepository.deleteById(id);
    }
}
