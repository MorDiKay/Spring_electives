package com.bachelor.electives.service;

import com.bachelor.electives.entity.ElectiveEntity;
import com.bachelor.electives.entity.TopicEntity;
import com.bachelor.electives.exception.ElectiveAlreadyExistException;
import com.bachelor.electives.exception.ElectiveNotFoundException;
import com.bachelor.electives.repository.ElectiveRepo;
import com.bachelor.electives.repository.TopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectiveService {

    @Autowired
    private ElectiveRepo electiveRepo;

    @Autowired
    private TopicRepo topicRepo;

    public Iterable<ElectiveEntity> findAllByTopicId(Long id) throws ElectiveNotFoundException {
        Iterable<ElectiveEntity> electives = electiveRepo.findElectivesByTopicId(id);
        if (electives == null) {
            throw new ElectiveNotFoundException("Electives don't exists");
        }
        return electives;
    }

    public ElectiveEntity createElective(ElectiveEntity elective, Long topicId) throws ElectiveAlreadyExistException {
        if(electiveRepo.findByName(elective.getName()) != null) {
            throw new ElectiveAlreadyExistException("This elective already exist");
        }
        TopicEntity topic = topicRepo.findById(topicId).get();
        elective.setTopic(topic);
        return electiveRepo.save(elective);
    }

    public Long deleteElective(Long id) {
        electiveRepo.deleteById(id);
        return id;
    }

    public List<ElectiveEntity> getElective() {
        return electiveRepo.findAll();
    }

}
