package com.bachelor.electives.service;

import com.bachelor.electives.entity.ElectiveEntity;
import com.bachelor.electives.exception.ElectiveAlreadyExistException;
import com.bachelor.electives.exception.ElectiveNotFoundException;
import com.bachelor.electives.repository.ElectiveRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public ElectiveEntity createElective(ElectiveEntity elective) throws ElectiveAlreadyExistException {
        if(electiveRepo.findByName(elective.getName()) != null) {
            throw new ElectiveAlreadyExistException("This elective already exist");
        }
        return electiveRepo.save(elective);
    }

    public Long deleteElective(Long id) {
        electiveRepo.deleteById(id);
        return id;
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
