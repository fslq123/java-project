package com.fslq.day08.demogame;

public class DemoMain {
    public static void main(String[] args) {
        Hero hero=new Hero ("盖伦", new Skill () {//匿名内部类
            @Override
            public void Attsck() {
                System.out.println ("盖伦转转转");
            }
        });
//        Weapon weapon=new Weapon ("胜利之剑");
//        hero.setWeapon (weapon);
        hero.setWeapon (new Weapon ("胜利之剑"));
        hero.show ();
    }
}
