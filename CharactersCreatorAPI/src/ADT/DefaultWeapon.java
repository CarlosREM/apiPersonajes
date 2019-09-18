/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

import abstraction.ACharacter;
import abstraction.AWeapon;
import abstraction.IAppearance;
import abstraction.IBuild;
import abstraction.IPrototype;
import java.util.TreeMap;

/**
 *
 * @author Fabricio Ceciliano
 */
public class DefaultWeapon extends AWeapon{

    public DefaultWeapon(){
        super();
    }
    
    public DefaultWeapon(String name, int range, int damage, int level, int areaOfEffect, int hitPerUnit, TreeMap<Integer,IAppearance> appearances, int unlockLevel) {
        super(name, range, damage, level, areaOfEffect, hitPerUnit, appearances, unlockLevel);
    }

    @Override
    public void use(ACharacter character) {
        character.takeDamage(getDamage()*getHitPerUnit());
    }

    @Override
    public void levelUp() {
        setDamage(getDamage() + ((int)(0.15*getDamage())));
        setLevel(getLevel() + 1);
        setHitPerUnit(getHitPerUnit() + ((int)(0.10*getHitPerUnit())));
    }

    @Override
    public void levelDown() {
        setDamage(getDamage() - ((int)(0.15*getDamage())));
        setLevel(getLevel() - 1);
        setHitPerUnit(getHitPerUnit() - ((int)(0.10*getHitPerUnit())));
    }

    @Override
    public IPrototype deepClone() {
        TreeMap<Integer,IAppearance> newAppearances = new TreeMap<>();
        
        for(Integer i : getAppearances().keySet()){
            newAppearances.put(i, getAppearances().get(i).deepClone());
        }
        return new DefaultWeapon(getName(),getRange(),getDamage(),getLevel(),getAreaOfEffect(),getHitPerUnit(),newAppearances, getUnlockLevel());
    }
    
    public static class DefaultWeaponBuilder implements IBuild<AWeapon>{
        private String name = "Melee" ;
        private int range = 1;
        private int damage = 1;
        private int level = 1;
        private int areaOfEffect = 1;
        private int hitPerUnit = 1;
        private TreeMap<Integer,IAppearance> appearances = new TreeMap<>();
        private int unlockLevel = 1;

        public DefaultWeaponBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public DefaultWeaponBuilder setRange(int range) {
            this.range = range;
            return this;
        }

        public DefaultWeaponBuilder setDamage(int damage) {
            this.damage = damage;
            return this;
        }

        public DefaultWeaponBuilder setLevel(int level) {
            this.level = level;
            return this;
        }

        public DefaultWeaponBuilder setAreaOfEffect(int areaOfEffect) {
            this.areaOfEffect = areaOfEffect;
            return this;
        }

        public DefaultWeaponBuilder setHitPerUnit(int hitPerUnit) {
            this.hitPerUnit = hitPerUnit;
            return this;
        }

        public DefaultWeaponBuilder setAppearances(TreeMap<Integer, IAppearance> appearances) {
            this.appearances = appearances;
            return this;
        }
        
        public DefaultWeaponBuilder addAppearance(int level, IAppearance appearance) {
            if(this.appearances.containsKey(level))
                this.appearances.replace(level, appearance);
            else
                this.appearances.put(level, appearance);
            return this;
        }

        public DefaultWeaponBuilder setUnlockLevel(int unlockLevel) {
            this.unlockLevel = unlockLevel;
            return this;
        }
        
        @Override
        public AWeapon build() {
            return new DefaultWeapon(name, range, damage, level, areaOfEffect, hitPerUnit, appearances, unlockLevel);
        }
        
    }
}
