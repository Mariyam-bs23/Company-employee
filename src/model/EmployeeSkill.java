package model;

import enums.SkillType;

public class EmployeeSkill {
    private SkillType skill;
    private int proficiency;
    @Override
    public String toString() {
        return "EmployeeSkill{" +
                "skill='" + skill + '\'' +
                ", proficiency=" + proficiency +
                '}' + "\n";
    }

    public void setSkill(SkillType skill) {this.skill = skill;}

    public SkillType getSkill() {
        return skill;
    }
    public void setProficiency(int proficiency) {
        this.proficiency = validateProficiency(proficiency);
    }
    public int getProficiency() {
        return proficiency;
    }
    private int validateProficiency(int proficiency) {
        if (proficiency < 0) {
            return 0;
        } else if (proficiency > 5) {
            return 5;
        } else {
            return proficiency;
        }
    }
}
