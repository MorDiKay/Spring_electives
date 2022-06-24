package com.bachelor.electives.service;

import com.bachelor.electives.entity.ElectiveEntity;
import com.bachelor.electives.entity.TopicEntity;
import com.bachelor.electives.exceptions.ElectiveNotFoundException;
import com.bachelor.electives.repository.ElectiveRepo;
import com.bachelor.electives.repository.TopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ElectiveService {

    @Autowired
    private ElectiveRepo electiveRepo;

    public Iterable<ElectiveEntity> findAllByTopicId(Long id) throws ElectiveNotFoundException {
        Iterable<ElectiveEntity> electives = electiveRepo.findElectivesByTopicId(id);
        if (electives == null) {
            throw new ElectiveNotFoundException("Electives don't exists");
        }
        return electives;
    }

    /*public ArrayList<ElectiveEntity> findAllByTopicId(Long topicId) {
        ElectiveEntity electiveEntity = (ElectiveEntity) electiveRepo.findAll();
        ArrayList<ElectiveEntity> electiveEntities = new ArrayList<>();
        if(electiveEntity.getId().equals(topicId)) {
            electiveEntities.add(electiveEntity);
        }
        return electiveEntities;
    }*/
}
