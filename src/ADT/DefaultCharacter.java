/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

import abstraction.ACharacter;
import abstraction.AWeapon;
import abstraction.IAppearance;
import abstraction.IPrototype;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Fabricio Ceciliano
 */
public class DefaultCharacter extends ACharacter {

    public DefaultCharacter() {}

    public DefaultCharacter(String name, HashMap<Integer, IAppearance> appearance, int currentHealthPoints, int maxHealthPoints, int hitsPerUnit, int level, int tiles, int unlockLevel, int cost, ArrayList<AWeapon> weapons) {
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
        setMaxHealthPoint(getMaxHealthPoint() + ((int)(0.12*getMaxHealthPoint())));
        setCurrentHealthPoints(getMaxHealthPoint());
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
        setMaxHealthPoint(getMaxHealthPoint() - ((int)(0.20*getMaxHealthPoint())));
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
    public void deleteWeapon(int index)  throws IndexOutOfBoundsException{
        if(index != 0)
            getWeapons().remove(index);
    }

    @Override
    public IPrototype deepClone() {
        ArrayList<AWeapon> newWeapons = new ArrayList<>();
        HashMap<Integer,IAppearance> newAppearances = new HashMap<>();
        
        for(AWeapon weapon:getWeapons()){
            newWeapons.add((AWeapon) weapon.deepClone());
        }
        for(Integer i : getAppearances().keySet()){
            newAppearances.put(i, getAppearances().get(i).deepClone());
        }
        
        return new DefaultCharacter(getName(),newAppearances,getCurrentHealthPoints(),getMaxHealthPoint(),
                                    getHitsPerUnit(),getLevel(),getTiles(),getUnlockLevel(),getCost(), newWeapons);
    }
}
