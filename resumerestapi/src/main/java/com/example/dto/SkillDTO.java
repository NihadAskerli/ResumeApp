package com.example.dto;

import com.example.entity.Skill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkillDTO {
    private Integer id;
    private String name;

    public SkillDTO(Skill skill) {
        this.id = skill.getId();
        this.name=skill.getName();
    }
}
