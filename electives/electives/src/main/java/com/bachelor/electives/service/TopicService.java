package com.bachelor.electives.service;

import com.bachelor.electives.entity.TopicEntity;
import com.bachelor.electives.exception.TopicNotFoundException;
import com.bachelor.electives.repository.TopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    @Autowired
    private TopicRepo topicRepo;

    public Iterable<TopicEntity> findAllElectives() throws TopicNotFoundException {
        Iterable<TopicEntity> topics = topicRepo.findAll();
        if(topicRepo == null) {
            throw new TopicNotFoundException("Topics don't exist");
        }
        return topics;
    }
}
