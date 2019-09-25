package ADT;

import abstraction.ACharacter;
import abstraction.AWeapon;
import abstraction.AAppearance;
import abstraction.IBuild;
import abstraction.IPrototype;
import java.util.TreeMap;

/**
 * Class used to make an implementation of a default AWeapon
 * @author Fabricio Ceciliano
 * @author Carlos Esquivel
 * @author Marco Gamboa
 * @author Diego Murillo
 * @see AWeapon
 */
public class DefaultWeapon extends AWeapon{

    /**
     * Creates a weapon with the default information from its parent.
     */
    public DefaultWeapon(){
        super();
    }
    
    /**
     * Creates a weapon with the specified information.
     * @param name The weapon name.
     * @param range The weapon use range.
     * @param damage The weapon damage.
     * @param level The weapon starting level.
     * @param areaOfEffect The weapon area of effect in a space unit.
     * @param hitPerUnit The weapon's hits per unit of time.
     * @param appearances Weapon's TreeMap containing the level and the corresponding string list of appearances.
     * @param unlockLevel The level at which weapon will be unlock.
     */
    public DefaultWeapon(String name, int range, int damage, int level, int areaOfEffect, int hitPerUnit, TreeMap<Integer,AAppearance> appearances, int unlockLevel) {
        super(name, range, damage, level, areaOfEffect, hitPerUnit, appearances, unlockLevel);
    }

    /**
     * Method used to employ the weapon in a character.
     * @param character The character that will be affected by the weapon.
     */
    @Override
    public void use(ACharacter character) {
        character.takeDamage(getDamage()*getHitPerUnit());
    }

    /**
     * Method to level up the weapon.
     */
    @Override
    public void levelUp() {
        setDamage(getDamage() + ((int)(0.15*getDamage())));
        setLevel(getLevel() + 1);
        setHitPerUnit(getHitPerUnit() + ((int)(0.10*getHitPerUnit())));
    }

    /**
     * Method to level down the weapon.
     */
    @Override
    public void levelDown() {
        setDamage(getDamage() - ((int)(0.15*getDamage())));
        setLevel(getLevel() - 1);
        setHitPerUnit(getHitPerUnit() - ((int)(0.10*getHitPerUnit())));
    }

    /**
     * Method to realize a deep clone of the DefaultWeapon object.
     * @return The new cloned DefaultWeapon.
     */
    @Override
    public IPrototype deepClone() {
        TreeMap<Integer,AAppearance> newAppearances = new TreeMap<>();
        
        for(Integer i : getAppearances().keySet()){
            newAppearances.put(i, (AAppearance) getAppearances().get(i).deepClone());
        }
        return new DefaultWeapon(getName(),getRange(),getDamage(),getLevel(),getAreaOfEffect(),getHitPerUnit(),newAppearances, getUnlockLevel());
    }
    
    @Override
    public String toString() {
        return getName() + " Lvl. "+getLevel();
    }
    
    /**
     * Inner class used to implements the Builder and creates a new Default Weapon.
     */
    public static class DefaultWeaponBuilder implements IBuild<AWeapon>{
        private String name = "Melee" ;
        private int range = 1;
        private int damage = 1;
        private int level = 1;
        private int areaOfEffect = 1;
        private int hitPerUnit = 1;
        private TreeMap<Integer,AAppearance> appearances = new TreeMap<>();
        private int unlockLevel = 1;

        /**
         * Sets the weapon's name.
         * @param name A string containing the new weapon's name.
         * @return A DefaultWeaponBuilder containing the setted name.
         */
        public DefaultWeaponBuilder setName(String name) {
            this.name = name;
            return this;
        }

        /**
         * Sets the weapon's use range.
         * @param range An int containing the weapon's new use range.
         * @return A DefaultWeaponBuilder containing the setted range.
         */
        public DefaultWeaponBuilder setRange(int range) {
            this.range = range;
            return this;
        }

        /**
         * Sets the weapon damage amount.
         * @param damage An int containing the weapon's new damage amount.
         * @return A DefaultWeaponBuilder containing the setted damage.
         */
        public DefaultWeaponBuilder setDamage(int damage) {
            this.damage = damage;
            return this;
        }

        /**
         * Sets the weapon level.
         * @param level The weapon's new level.
         * @return A DefaultWeaponBuilder containing the setted leel.
         */
        public DefaultWeaponBuilder setLevel(int level) {
            this.level = level;
            return this;
        }

        /**
         * Sets the weapon area of effect in a space unit.
         * @param areaOfEffect The weapon's new area of effect in a space unit.
         * @return A DefaultWeaponBuilder containing the setted area of effect.
         */
        public DefaultWeaponBuilder setAreaOfEffect(int areaOfEffect) {
            this.areaOfEffect = areaOfEffect;
            return this;
        }

        /**
         * Sets the weapon's hits per unit of time.
         * @param hitPerUnit The weapon's new hits per unit of time.
         * @return A DefaultWeaponBuilder containing the setted hits per unit of time.
         */
        public DefaultWeaponBuilder setHitPerUnit(int hitPerUnit) {
            this.hitPerUnit = hitPerUnit;
            return this;
        }

        /**
         * Sets the specific appearances.
         * @param appearances The weapon's new appearances.
         * @return A DefaultWeaponBuilder containing the setted appearances TreeMap.
         */
        public DefaultWeaponBuilder setAppearances(TreeMap<Integer, AAppearance> appearances) {
            this.appearances = appearances;
            return this;
        }
        
        /**
         * Sets the specific appearance in the specified level. If the appearance already exists, it's replace.
         * @param level The level to link the appearance.
         * @param appearance The new weapon's appearance.
         * @return A DefaultWeaponBuilder containing the added appearance.
         */
        public DefaultWeaponBuilder addAppearance(int level, AAppearance appearance) {
            if(this.appearances.containsKey(level))
                this.appearances.replace(level, appearance);
            else
                this.appearances.put(level, appearance);
            return this;
        }

        /**
         * Sets the weapon unlock level.
         * @param unlockLevel The new level at which weapon will be unlock.
         * @return A DefaultWeaponBuilder containing the setted unlock level.
         */
        public DefaultWeaponBuilder setUnlockLevel(int unlockLevel) {
            this.unlockLevel = unlockLevel;
            return this;
        }
        
        /**
         * Method to make the build of the DefaultWeapon object.
         * @return A DefaultWeapon object with all the attributes that were set.
         */
        @Override
        public AWeapon build() {
            return new DefaultWeapon(name, range, damage, level, areaOfEffect, hitPerUnit, appearances, unlockLevel);
        }
        
    }
}
