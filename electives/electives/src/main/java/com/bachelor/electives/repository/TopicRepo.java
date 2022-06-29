package com.bachelor.electives.repository;

import com.bachelor.electives.entity.TopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepo extends JpaRepository<TopicEntity, Long> {
}
