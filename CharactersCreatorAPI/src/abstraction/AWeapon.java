/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstraction;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.util.TreeMap;

/**
 *
 * @author Fabricio Ceciliano
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.CLASS,
        include = JsonTypeInfo.As.PROPERTY,
        property = "@class"
)
public abstract class AWeapon implements IPrototype, ILookable{
    private String name = "Melee" ;
    private int range = 1;
    private int damage = 1;
    private int level = 1;
    private int areaOfEffect = 1;
    private int hitPerUnit = 1;
    private TreeMap<Integer,AAppearance> appearances = new TreeMap<>();
    private int unlockLevel = 1;
    
    public AWeapon(){
        
    }

    public AWeapon(String name, int range, int damage, int level, int areaOfEffect, int hitPerUnit, TreeMap<Integer,AAppearance> appearances, int unlockLevel) {
        this.name = name;
        this.range = range;
        this.damage = damage;
        this.level = level;
        this.areaOfEffect = areaOfEffect;
        this.hitPerUnit = hitPerUnit;
        this.appearances = appearances;
        this.unlockLevel = unlockLevel;
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

    public int getUnlockLevel() {
        return unlockLevel;
    }
    public void setUnlockLevel(int unlockLevel) {
        this.unlockLevel = unlockLevel;
    }
    
    @Override
    public AAppearance getAppearance(int level) {
        return appearances.floorEntry(level).getValue();
    }
    @Override
    public void setAppearance(int level, AAppearance appearance) {
        if(this.appearances.containsKey(level))
            this.appearances.replace(level, appearance);
        else
            this.appearances.put(level, appearance);
    }
    
    @Override
    public TreeMap<Integer, AAppearance> getAppearances() {
        return appearances;
    }
    
    public abstract void use(ACharacter character);
    public abstract void levelUp();
    public abstract void levelDown();
}
