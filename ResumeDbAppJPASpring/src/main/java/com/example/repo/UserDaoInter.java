package com.example.repo;

import com.example.entity.User;

import java.util.List;

public interface UserDaoInter {
    public List<User> getAll(String name, String surname, Integer nationalityId);

}
