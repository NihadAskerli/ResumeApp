/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author ASUS
 */
@Data
@Entity
@Table
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "country_name")
    private String name;
    @Column(name = "nationality")

    private String nationality;
    
    @OneToMany(mappedBy = "nationality")
    private List<User> userList;
    
    @OneToMany(mappedBy = "birthPlace")
    private List<User> userList1;
}
