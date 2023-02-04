package com.example.dto;

import com.example.entity.UserSkill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSkillDTO {
    private Integer id;
    private Integer power;
    private SkillDTO skill;
    public UserSkillDTO(UserSkill userSkill) {
        this.id = userSkill.getId();
        this.power = userSkill.getPower();
        this.skill = new SkillDTO(userSkill.getSkill());
    }


}
