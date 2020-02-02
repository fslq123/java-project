package com.fslq.day08.demogame;

public class Hero {
    private String name;
    private Weapon weapon;
    private Skill skill;

    public Hero() {
    }

    public Hero(String name, Skill skill) {
        this.name = name;
        this.skill = skill;
    }

    public void show(){
        System.out.print("英雄："+name+" 武器："+weapon.getCode ()+" 技能：");
        skill.Attsck ();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}
