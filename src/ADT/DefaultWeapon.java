/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

import abstraction.ACharacter;
import abstraction.AWeapon;
import abstraction.IPrototype;

/**
 *
 * @author Fabricio Ceciliano
 */
public class DefaultWeapon extends AWeapon{

    public DefaultWeapon(){
        super();
    }
    
    public DefaultWeapon(String name, int range, int damage, int level, int areaOfEffect, int hitPerUnit) {
        super(name, range, damage, level, areaOfEffect, hitPerUnit);
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
        return new DefaultWeapon(getName(),getRange(),getDamage(),getLevel(),getAreaOfEffect(),getHitPerUnit());
    }
    
}
