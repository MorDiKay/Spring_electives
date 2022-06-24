package com.bachelor.electives.repository;

import com.bachelor.electives.entity.ElectiveEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface ElectiveRepo extends CrudRepository<ElectiveEntity, Long> {

    @Query(value = "SELECT * FROM elective_entity WHERE topic_id = :topicId", nativeQuery = true)
    Iterable<ElectiveEntity> findElectivesByTopicId(Long topicId);
}
