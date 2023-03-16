package com.bachelor.electives.service;

import com.bachelor.electives.entity.RoleEntity;
import com.bachelor.electives.entity.UserEntity;
import com.bachelor.electives.exception.UserAlreadyExistException;
import com.bachelor.electives.repository.RoleRepo;
import com.bachelor.electives.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    public UserEntity createUser(UserEntity user, Long roleId) throws UserAlreadyExistException {
        if(userRepo.findByLogin(user.getLogin()) != null) {
            throw new UserAlreadyExistException("This user already exist");
        }
        RoleEntity role = roleRepo.findById(roleId).get();
        user.setRole(role);
        return userRepo.save(user);
    }

    public Long deleteUser(Long id) {
        userRepo.deleteById(id);
        return id;
    }

    public List<UserEntity> getUser() {
        return userRepo.findAll();
    }

}
