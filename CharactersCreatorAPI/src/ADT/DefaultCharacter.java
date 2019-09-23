package ADT;

import abstraction.ACharacter;
import abstraction.AWeapon;
import abstraction.AAppearance;
import abstraction.IBuild;
import abstraction.IPrototype;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Class used to make an implementation of a default ACharacter
 * @author Fabricio Ceciliano
 * @author Carlos Esquivel
 * @author Marco Gamboa
 * @author Diego Murillo
 * @see ACharacter
 */
public class DefaultCharacter extends ACharacter {

   /**
    * Creates a default character with the default information from its parent.
    */
    public DefaultCharacter() {}

    /**
     * Creates a character with the specified information.
     * @param name Character's name.
     * @param appearance Character's TreeMap containing the level and the corresponding string list of appearances.
     * @param currentHealthPoints Character's current health points.
     * @param maxHealthPoints Character's max health points.
     * @param hitsPerUnit Character's hits per unit of time value.
     * @param level Character's level.
     * @param tiles Character's spaciousness in a space unit. 
     * @param unlockLevel Character's unlock level.
     * @param cost Character's cost.
     * @param weapons Character's arraylist containing it's weapons.
     * @param coordinateX Character's X coordinate used in a space unit.
     * @param coordinateY Character's Y coordinate used in a space unit.
     */
    public DefaultCharacter(String name, TreeMap<Integer, AAppearance> appearance, int currentHealthPoints, int maxHealthPoints, int hitsPerUnit, int level, int tiles, int unlockLevel, int cost, ArrayList<AWeapon> weapons, int coordinateX, int coordinateY) {
        super(name, appearance, currentHealthPoints, maxHealthPoints, hitsPerUnit, level, tiles, unlockLevel, cost, weapons, coordinateX, coordinateY);
    }  

    /**
     * Method used to employ a weapon in a character.
     * @param weapon The weapon that will be used.
     * @param character The character who is going to be affected by the weapon.
     */
    @Override
    public void useWeapon(AWeapon weapon, ACharacter character) {
        weapon.use(character);
    }

    /**
     * Method used to employ in a Character a AWeapon from a specific index.
     * @param index The index of the weapon in the character's weapons arraylist.
     * @param character The character who is going to be affected by the weapon.
     * @throws IndexOutOfBoundsException If index is not in the weapons list bounds.
     */
    @Override
    public void useWeapon(int index, ACharacter character) throws IndexOutOfBoundsException {
        getWeapons().get(index).use(character);
    }

    /**
     * Method used to damage the character.
     * @param damage The damage the character will receive.
     */
    @Override
    public void takeDamage(int damage) {
        setCurrentHealthPoints(getCurrentHealthPoints() - damage);
    }

    /**
     * Method used to cure the character.
     * @param healthPoints The health points the character will receive.
     */
    @Override
    public void takeHealth(int healthPoints) {
        setCurrentHealthPoints(getCurrentHealthPoints() + healthPoints);
    }

    /**
     * Method used to level up the character.
     */
    @Override
    public void levelUp() {
        setLevel(getLevel() + 1);
        setMaxHealthPoints(getMaxHealthPoints() + ((int)(0.12*getMaxHealthPoints())));
        setCurrentHealthPoints(getMaxHealthPoints());
        setCost(getCost()+ ((int)(0.12*getCost())));
        setHitsPerUnit(getHitsPerUnit()+ ((int)(0.5*getHitsPerUnit())));
        levelUpWeapons();
    }
    
    /**
     * Method used to level down the character.
     */
    @Override
    public void levelDown() {
        setLevel(getLevel() - 1);
        setMaxHealthPoints(getMaxHealthPoints() - ((int)(0.20*getMaxHealthPoints())));
        setCost(getCost() - ((int)(0.20*getCost())));
        setHitsPerUnit(getHitsPerUnit() - ((int)(0.20*getHitsPerUnit())));
        levelDownWeapons();
    }
    
    /**
     * Method used to level up the character weapons.
     */
    @Override
    public void levelUpWeapons() {
        for(AWeapon weapon : getWeapons()){
            weapon.levelUp();
        }
    }
    
    /**
     * Method used to level down the character weapons.
     */
    @Override
    public void levelDownWeapons() {
        for(AWeapon weapon : getWeapons()){
            weapon.levelDown();
        }
    }

    /**
     * method used to add a weapon to the character weapons list.
     * @param weapon The weapon that will be added.
     */
    @Override
    public void addWeapon(AWeapon weapon) {
        getWeapons().add(weapon);
    }

    /**
     * method used to delete a weapon from the character weapons list.
     * @param weapon The weapon that will be deleted.
     */
    @Override
    public void deleteWeapon(AWeapon weapon) {
        getWeapons().remove(weapon);
    }

    /**
     * Method used to remove a weapon from a specific index in the character's weapons list.
     * @param index The index of the weapon that will be removed.
     * @throws IndexOutOfBoundsException If the index is not in the character's weapons list bounds.
     */
    @Override
    public void deleteWeapon(int index) throws IndexOutOfBoundsException{
        if(index != 0)
            getWeapons().remove(index);
    }

    /**
     * Method to realize a deep clone of the character.
     * @return A cloned character with the same information as current character.
     */
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
                                    getHitsPerUnit(),getLevel(),getTiles(),getUnlockLevel(),getCost(),
                                    newWeapons, getCoordinateX(),getCoordinateY());
    }

    /**
     * Method used to move the character to another x,y position in a space unit.
     * @param x The new X coordinate.
     * @param y The new Y coordinate.
     */
    @Override
    public void move(int x, int y) {
        setCoordinateX(x);
        setCoordinateY(y);
    }
    
    /**
     * Inner class used to implements the Builder and creates a new Default Character.
     * @see IBuild
     */
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

       /**
        * Sets the character's name.
        * @param name The character's new name.
        * @return A DefaultCharacterBuilder containing the setted name.
        */
        public DefaultCharacterBuilder setName(String name) {
            this.name = name;
            return this;
        }

        /**
         * Sets the character appearances.
         * @param appearances The character's new appearances
         * @return A DefaultCharacterBuilder containing the setted appearances.
         */
        public DefaultCharacterBuilder setAppearances(TreeMap<Integer, AAppearance> appearances) {
            this.appearances = appearances;
            return this;
        }

        /**
         * Sets the current character's health points.
         * @param currentHealthPoints The character's new health points.
         * @return A DefaultCharacterBuilder containing the setted health points.
         */
        public DefaultCharacterBuilder setCurrentHealthPoints(int currentHealthPoints) {
            this.currentHealthPoints = currentHealthPoints;
            return this;
        }

        /**
         * Sets the character's max health points.
         * @param maxHealthPoints The character's new max health points.
         * @return A DefaultCharacterBuilder containing the setted max health points.
         */
        public DefaultCharacterBuilder setMaxHealthPoints(int maxHealthPoints) {
            this.maxHealthPoints = maxHealthPoints;
            return this;
        }

        /**
         * Sets the character's hits per unit of time.
         * @param hitsPerUnit The character's new hits per unit of time.
         * @return A DefaultCharacterBuilder containing the setted hits per unit of time.
         */
        public DefaultCharacterBuilder setHitsPerUnit(int hitsPerUnit) {
            this.hitsPerUnit = hitsPerUnit;
            return this;
        }

        /**
         * Sets the character's level.
         * @param level The character's new level.
         * @return A DefaultCharacterBuilder containing the setted level.
         */
        public DefaultCharacterBuilder setLevel(int level) {
            this.level = level;
            return this;
        }

        /**
         * Sets the character's spaciousness in a space unit. 
         * @param tiles The character's new spaciousness in a space unit. 
         * @return A DefaultCharacterBuilder containing the setted spaciousness.
         */
        public DefaultCharacterBuilder setTiles(int tiles) {
            this.tiles = tiles;
            return this;
        }

        /**
         * Sets the character's unlock level.
         * @param unlockLevel The character's new unlock level.
         * @return A DefaultCharacterBuilder containing the setted unlock level.
         */
        public DefaultCharacterBuilder setUnlockLevel(int unlockLevel) {
            this.unlockLevel = unlockLevel;
            return this;
        }

        /**
         * Sets the character's cost.
         * @param cost The character's new cost.
         * @return A DefaultCharacterBuilder containing the setted cost.
         */
        public DefaultCharacterBuilder setCost(int cost) {
            this.cost = cost;
            return this;
        }
        
        /**
         * Sets the character's weapons.
         * @param weapons The character's new weapons.
         * @return A DefaultCharacterBuilder containing the setted weapons.
         */
        public DefaultCharacterBuilder setWeapons(ArrayList<AWeapon> weapons) {
            this.weapons = weapons;
            return this;
        }
        
        /**
         * Adds a weapon to the default character weapons list.
         * @param weapon The weapon to be added.
         * @return A DefaultCharacterBuilder containing the added weapon.
         */
        public DefaultCharacterBuilder addWeapon(AWeapon weapon) {
            this.weapons.add(weapon);
            return this;
        }
        
        /**
         * Method used to delete a weapon from the default character's weapons list.
         * @param weapon The weapon that will be deleted.
         * @return A DefaultCharacterBuilder without the deleted weapon.
         */
        public DefaultCharacterBuilder deleteWeapon(AWeapon weapon) {
            this.weapons.remove(weapon);
            return this;
        }

        /**
         * Method used to remove a weapon from a specific index in the default character weapons list.
         * @param index The index of the weapon that will be removed.
         * @return A DefaultCharacterBuilder without the deleted weapon.
         * @throws IndexOutOfBoundsException If the index is not in the default character's weapons list bounds.
         */
        public DefaultCharacterBuilder deleteWeapon(int index) throws IndexOutOfBoundsException{
            if(index != 0)
                weapons.remove(index);
            return this;
        }
        
        /**
         * Adds the specific appearance in the specified level. If the appearance already exists, it's replace.
         * @param level The level to link the appearance.
         * @param appearance The new character's appearance.
         * @return A DefaultCharacterBuilder containing the added weapon.
         */
        public DefaultCharacterBuilder addAppearance(int level, AAppearance appearance) {
            if(this.appearances.containsKey(level))
                this.appearances.replace(level, appearance);
            else
                this.appearances.put(level, appearance);
            return this;
        }
        
        /**
         * Sets the character's X coordinate used in a space unit.
         * @param coordinateX The character's new X coordinate used in a space unit.
         * @return A DefaultCharacterBuilder containing the X coordinate.
         */
        public DefaultCharacterBuilder setCoordinateX(int coordinateX) {
            this.coordinateX = coordinateX;
            return this;
        }
        
        /**
         * Sets the character's Y coordinate used in a space unit.
         * @param coordinateY The character's new Y coordinate used in a space unit.
         * @return A DefaultCharacterBuilder containing the Y coordinate.
         */
        public DefaultCharacterBuilder setCoordinateY(int coordinateY) {
            this.coordinateY = coordinateY;
            return this;
        }
                
        /**
         * Method to make the build of the object.
         * @return A DefaultCharacter object with all the attributes that were set.
         */
        @Override
        public ACharacter build() {
            return new DefaultCharacter(name, appearances, currentHealthPoints, maxHealthPoints, hitsPerUnit, level, tiles, unlockLevel, cost, weapons, coordinateX, coordinateY);
        }
    }
}
