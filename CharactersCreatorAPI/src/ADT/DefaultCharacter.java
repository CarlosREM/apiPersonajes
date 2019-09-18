/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

import abstraction.ACharacter;
import abstraction.AWeapon;
import abstraction.AAppearance;
import abstraction.IBuild;
import abstraction.IPrototype;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 *
 * @author Fabricio Ceciliano
 */

public class DefaultCharacter extends ACharacter {

   
    public DefaultCharacter() {}

    public DefaultCharacter(String name, TreeMap<Integer, AAppearance> appearance, int currentHealthPoints, int maxHealthPoints, int hitsPerUnit, int level, int tiles, int unlockLevel, int cost, ArrayList<AWeapon> weapons) {
        super(name, appearance, currentHealthPoints, maxHealthPoints, hitsPerUnit, level, tiles, unlockLevel, cost, weapons);
    }  

    @Override
    public void useWeapon(AWeapon weapon, ACharacter character) {
        weapon.use(character);
    }

    @Override
    public void useWeapon(int index, ACharacter character) throws IndexOutOfBoundsException {
        getWeapons().get(index).use(character);
    }

    @Override
    public void takeDamage(int damage) {
        setCurrentHealthPoints(getCurrentHealthPoints() - damage);
    }

    @Override
    public void takeHealth(int healthPoints) {
        setCurrentHealthPoints(getCurrentHealthPoints() + healthPoints);
    }

    @Override
    public void levelUp() {
        setLevel(getLevel() + 1);
        setMaxHealthPoints(getMaxHealthPoints() + ((int)(0.12*getMaxHealthPoints())));
        setCurrentHealthPoints(getMaxHealthPoints());
        setCost(getCost()+ ((int)(0.12*getCost())));
        setHitsPerUnit(getHitsPerUnit()+ ((int)(0.5*getHitsPerUnit())));
        levelUpWeapons();
    }
    
    @Override
    public void levelUpWeapons() {
        for(AWeapon weapon : getWeapons()){
            weapon.levelUp();
        }
    }
    
    @Override
    public void levelDownWeapons() {
        for(AWeapon weapon : getWeapons()){
            weapon.levelDown();
        }
    }

    @Override
    public void levelDown() {
        setLevel(getLevel() - 1);
        setMaxHealthPoints(getMaxHealthPoints() - ((int)(0.20*getMaxHealthPoints())));
        setCost(getCost() - ((int)(0.20*getCost())));
        setHitsPerUnit(getHitsPerUnit() - ((int)(0.20*getHitsPerUnit())));
        levelDownWeapons();
    }

    @Override
    public void addWeapon(AWeapon weapon) {
        getWeapons().add(weapon);
    }

    @Override
    public void deleteWeapon(AWeapon weapon) {
        getWeapons().remove(weapon);
    }

    @Override
    public void deleteWeapon(int index) throws IndexOutOfBoundsException{
        if(index != 0)
            getWeapons().remove(index);
    }

    @Override
    public IPrototype deepClone() {
        ArrayList<AWeapon> newWeapons = new ArrayList<>();
        TreeMap<Integer,AAppearance> newAppearances = new TreeMap<>();
        
        for(AWeapon weapon:getWeapons()){
            newWeapons.add((AWeapon) weapon.deepClone());
        }
        for(Integer i : getAppearances().keySet()){
            newAppearances.put(i, (AAppearance) getAppearances().get(i).deepClone());
        }
        
        return new DefaultCharacter(getName(),newAppearances,getCurrentHealthPoints(),getMaxHealthPoints(),
                                    getHitsPerUnit(),getLevel(),getTiles(),getUnlockLevel(),getCost(), newWeapons);
    }

    @Override
    public void move(int x, int y) {
        setCoordinateX(x);
        setCoordinateY(y);
    }
    public static class DefaultCharacterBuilder implements IBuild <ACharacter>{
        private String name = "Average Joe";
        private TreeMap<Integer,AAppearance> appearances = new TreeMap<>();
        private int currentHealthPoints = 100;
        private int maxHealthPoints = 100;
        private int hitsPerUnit = 5;
        private int level = 1;
        private int tiles = 1;
        private int unlockLevel = 1;
        private int cost = 1;
        private ArrayList<AWeapon> weapons = new ArrayList<>();
        private int coordinateX;
        private int coordinateY;

        public DefaultCharacterBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public DefaultCharacterBuilder setAppearances(TreeMap<Integer, AAppearance> appearances) {
            this.appearances = appearances;
            return this;
        }

        public DefaultCharacterBuilder setCurrentHealthPoints(int currentHealthPoints) {
            this.currentHealthPoints = currentHealthPoints;
            return this;
        }

        public DefaultCharacterBuilder setMaxHealthPoints(int maxHealthPoints) {
            this.maxHealthPoints = maxHealthPoints;
            return this;
        }

        public DefaultCharacterBuilder setHitsPerUnit(int hitsPerUnit) {
            this.hitsPerUnit = hitsPerUnit;
            return this;
        }

        public DefaultCharacterBuilder setLevel(int level) {
            this.level = level;
            return this;
        }

        public DefaultCharacterBuilder setTiles(int tiles) {
            this.tiles = tiles;
            return this;
        }

        public DefaultCharacterBuilder setUnlockLevel(int unlockLevel) {
            this.unlockLevel = unlockLevel;
            return this;
        }

        public DefaultCharacterBuilder setCost(int cost) {
            this.cost = cost;
            return this;
        }

        public DefaultCharacterBuilder setWeapons(ArrayList<AWeapon> weapons) {
            this.weapons = weapons;
            return this;
        }
        
        public DefaultCharacterBuilder addWeapon(AWeapon weapon) {
            this.weapons.add(weapon);
            return this;
        }
        
        public DefaultCharacterBuilder deleteWeapon(AWeapon weapon) {
            this.weapons.remove(weapon);
            return this;
        }

        public DefaultCharacterBuilder deleteWeapon(int index) throws IndexOutOfBoundsException{
            if(index != 0)
                weapons.remove(index);
            return this;
        }
        
        public DefaultCharacterBuilder addAppearance(int level, AAppearance appearance) {
            if(this.appearances.containsKey(level))
                this.appearances.replace(level, appearance);
            else
                this.appearances.put(level, appearance);
            return this;
        }
        
        public DefaultCharacterBuilder setCoordinateX(int coordinateX) {
            this.coordinateX = coordinateX;
            return this;
        }
        
        public DefaultCharacterBuilder setCoordinateY(int coordinateY) {
            this.coordinateY = coordinateY;
            return this;
        }
        
        
                
        @Override
        public ACharacter build() {
            return new DefaultCharacter(name, appearances, currentHealthPoints, maxHealthPoints, hitsPerUnit, level, tiles, unlockLevel, cost, weapons);
       
        }
    }
}
