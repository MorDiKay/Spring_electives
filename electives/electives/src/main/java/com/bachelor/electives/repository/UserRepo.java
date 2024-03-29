package com.bachelor.electives.repository;

import com.bachelor.electives.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity, Long> {

    UserEntity findByLogin(String login);
}
