package com.example.dto;

import com.example.entity.User;
import com.example.entity.UserSkill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private int id;
    private String name;
    private String surname;
    private String password;
    private List<UserSkillDTO> skills;

public UserDTO(User u){
    this.id=u.getId();
    this.name=u.getName();
    this.surname=u.getSurname();
    List<UserSkillDTO> list=new ArrayList<>();
    List<UserSkill> userSkills=u.getUserSkillList();
    for(int i=0;i<userSkills.size();i++){
        UserSkill uSkill=userSkills.get(i);
        list.add(new UserSkillDTO(uSkill));
    }
    skills=list;
}
}
