/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstraction;

/**
 *
 * @author Fabricio Ceciliano
 */
public abstract class AWeapon implements IPrototype{
    private String name = "Melee" ;
    private int range = 1;
    private int damage = 1;
    private int level = 1;
    private int areaOfEffect = 1;
    private int hitPerUnit = 1;
    
    public AWeapon(){
        
    }

    public AWeapon(String name, int range, int damage, int level, int areaOfEffect, int hitPerUnit) {
        this.name = name;
        this.range = range;
        this.damage = damage;
        this.level = level;
        this.areaOfEffect = areaOfEffect;
        this.hitPerUnit = hitPerUnit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAreaOfEffect() {
        return areaOfEffect;
    }

    public void setAreaOfEffect(int areaOfEffect) {
        this.areaOfEffect = areaOfEffect;
    }

    public int getHitPerUnit() {
        return hitPerUnit;
    }

    public void setHitPerUnit(int hitPerUnit) {
        this.hitPerUnit = hitPerUnit;
    }
    
    public abstract void use(ACharacter character);
    public abstract void levelUp();
    public abstract void levelDown();
}
