package com.bachelor.electives.repository;

import com.bachelor.electives.entity.TopicEntity;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepo extends CrudRepository<TopicEntity, Long> {
}
