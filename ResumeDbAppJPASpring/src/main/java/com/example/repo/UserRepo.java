/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.repo;

import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User,Integer> {
    User findByEmailAndPassword(String email,String password);
    User findByEmail(String email);
    @Query("select u from User u where u.name=:name and u.surname=:surname and u.nationality.id=:nationalityId")
    List<User>findByNameAndSurnameAndNationality(String name,String surname,Integer nationalityId);

}

