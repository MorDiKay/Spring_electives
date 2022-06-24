package com.bachelor.electives.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    private List<UserEntity> users;

    public RoleEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
