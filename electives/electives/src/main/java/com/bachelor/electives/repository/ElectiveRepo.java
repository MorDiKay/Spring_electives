package com.bachelor.electives.repository;

import com.bachelor.electives.entity.ElectiveEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ElectiveRepo extends JpaRepository<ElectiveEntity, Long> {

    @Query(value = "SELECT * FROM elective_entity WHERE topic_id = :topicId", nativeQuery = true)
    Iterable<ElectiveEntity> findElectivesByTopicId(Long topicId);
}
