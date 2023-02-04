/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ASUS
 */
@Data
@Entity
@Table(name="users")
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="user_name")

    private String name;
    @Column(name="user_surname")
    private String surname;
    @Column(name="user_email")
    private String email;
    @Column(name="user_phone")
    private String phone;
    @Lob
    @Column(name="user_profileDescription")
    private String profileDescription;
    @Column(name="address")
    private String address;
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Column(name = "password")
    private String password;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @Column(name = "user_skilss")
    private List<UserSkill> userSkillList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @Column(name = "employeehistories")
    private List<EmploymentHistory> employmentHistoryList;
    @JoinColumn(name = "nationality_id", referencedColumnName = "id")
    @ManyToOne
    private Country nationality;
    @JoinColumn(name = "birthplace_id", referencedColumnName = "id")
    @ManyToOne
    private Country birthPlace;




}
