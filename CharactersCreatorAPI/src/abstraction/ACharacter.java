package abstraction;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Abstract class used to implements characters.
 * @author Fabricio Ceciliano
 * @author Carlos Esquivel
 * @author Marco Gamboa
 * @author Diego Murillo
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.CLASS,
        include = JsonTypeInfo.As.PROPERTY,
        property = "@class"
)
public abstract class ACharacter implements IPrototype, ILookable{
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
    private int coordinateX = 0;
    private int coordinateY = 0;

    /**
     *  Creates a character with the default information.
     */
    public ACharacter(){
        
    }
    
    /**
     * Creates a character with the specified information.
     * @param name Character's name.
     * @param appearances Character's TreeMap containing the level and the corresponding string list of appearances.
     * @param currentHealthPoints Character's current health points.
     * @param maxHealthPoints Character's max health points.
     * @param hitsPerUnit Character's hits per unit of time value.
     * @param level Character's level.
     * @param tiles Character's spaciousness in a space unit. 
     * @param unlockLevel Character's unlock level.
     * @param cost Character's cost.
     * @param weapons Character's arraylist containing it's weapons.
     * @param coorditateX Character's X coordinate used in a space unit.
     * @param coorditateY Character's Y coordinate used in a space unit.
     */
    public ACharacter(String name, TreeMap<Integer,AAppearance> appearances, int currentHealthPoints, int maxHealthPoints, int hitsPerUnit, int level, int tiles, int unlockLevel, int cost, ArrayList<AWeapon> weapons,int coorditateX,int coorditateY) {
        this.name = name;
        for(Integer i: appearances.keySet()){
            this.appearances.put(i, (AAppearance) appearances.get(i).deepClone());
        }
        this.currentHealthPoints = currentHealthPoints;
        this.maxHealthPoints = maxHealthPoints;
        this.hitsPerUnit = hitsPerUnit;
        this.level = level;
        this.tiles = tiles;
        this.unlockLevel = unlockLevel;
        this.cost = cost;
        for(AWeapon weapon: weapons){
            this.weapons.add((AWeapon)weapon.deepClone());
        }
        this.weapons = weapons;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    /**
     * Gets the character's name.
     * @return A string containing the character's name.
     */
    public String getName() {
        return name;
    }
    /**
     * Sets the character's name.
     * @param name The character's new name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the character's current health points.
     * @return An int containing the character's current health points.
     */
    public int getCurrentHealthPoints() {
        return currentHealthPoints;
    }
    /**
     * Sets the current character's health points.
     * @param currentHealthPoints The character's new health points.
     */
    public void setCurrentHealthPoints(int currentHealthPoints) {
        this.currentHealthPoints = currentHealthPoints;
    }

    /**
     * Gets the character's max health points.
     * @return An int containing the character's max health points.
     */
    public int getMaxHealthPoints() {
        return maxHealthPoints;
    }
    /**
     * Sets the character's max health points.
     * @param maxHealthPoints The character's new max health points.
     */
    public void setMaxHealthPoints(int maxHealthPoints) {
        this.maxHealthPoints = maxHealthPoints;
    }

    /**
     * Gets the character's hits per unit of time.
     * @return An int containing the character's hits per unit of time.
     */
    public int getHitsPerUnit() {
        return hitsPerUnit;
    }
    /**
     * Sets the character's hits per unit of time.
     * @param hitsPerUnit The character's new hits per unit of time.
     */
    public void setHitsPerUnit(int hitsPerUnit) {
        this.hitsPerUnit = hitsPerUnit;
    }

    /**
     * Gets the character's current level.
     * @return An int containing the character's current level.
     */
    public int getLevel() {
        return level;
    }
    /**
     * Sets the character's level.
     * @param level The character's new level.
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Gets the character's spaciousness in a space unit. 
     * @return An int containing the character's spaciousness in a space unit. 
     */
    public int getTiles() {
        return tiles;
    }
    /**
     * Sets the character's spaciousness in a space unit. 
     * @param tiles The character's new spaciousness in a space unit. 
     */
    public void setTiles(int tiles) {
        this.tiles = tiles;
    }

    /**
     * Gets the character's unlock level.
     * @return An int containing the character's unlock level.
     */
    public int getUnlockLevel() {
        return unlockLevel;
    }
    /**
     * Sets the character's unlock level.
     * @param unlockLevel The character's new unlock level.
     */
    public void setUnlockLevel(int unlockLevel) {
        this.unlockLevel = unlockLevel;
    }

    /**
     * Gets the character's cost.
     * @return An int containing the character's cost.
     */
    public int getCost() {
        return cost;
    }
    /**
     * Sets the character's cost.
     * @param cost The character's new cost.
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * Gets the character's weapons.
     * @return An AWeapon arraylist of the character's weapons.
     * @see AWeapon
     */
    public ArrayList<AWeapon> getWeapons() {
        return weapons;
    }
    /**
     * Sets the character's weapons.
     * @param weapons The character's new weapons.
     */
    public void setWeapons(ArrayList<AWeapon> weapons) {
        this.weapons = weapons;
    }

    /**
     * Gets the character's X coordinate used in a space unit.
     * @return A int containing the character's X coordinate used in a space unit.
     */
    public int getCoordinateX() {
        return coordinateX;
    }
    /**
     * Sets the character's X coordinate used in a space unit.
     * @param coordinateX The character's new X coordinate used in a space unit.
     */
    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    /**
     * Gets the character's Y coordinate used in a space unit.
     * @return An int containing the character's Y coordinate used in a space unit.
     */
    public int getCoordinateY() {
        return coordinateY;
    }
    /**
     * Sets the character's Y coordinate used in a space unit.
     * @param coordinateY The character's new Y coordinate used in a space unit.
     */
    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }
    
    /**
     * Gets the chracter's appearance of the specified level.
     * @param level The level of the character's appearances.
     * @return The character's appearance of the specified level.
     * @see ILookable
     */
    @Override
    public AAppearance getAppearance(int level){
        return appearances.floorEntry(level).getValue();
    }
    
    /**
     * Sets the specific appearance in the specified level. If the appearance already exists, it's replace.
     * @param level The level to link the appearance.
     * @param appearance The new character's appearance.
     * @see ILookable
     */
    @Override
    public void setAppearance(int level, AAppearance appearance) {
        if(this.appearances.containsKey(level))
            this.appearances.replace(level, (AAppearance) appearance.deepClone());
        else
            this.appearances.put(level, (AAppearance) appearance.deepClone());
    }
    
    /**
     * Gets the character appearances.
     * @return A TreeMap containing the character appearances with its level.
     * @see ILookable
     */
    @Override
    public TreeMap<Integer,AAppearance> getAppearances() {
        return appearances;
    }

    /**
     * Abstract method used to employ a weapon in a character.
     * @param weapon The weapon that will be used.
     * @param character The character who is going to be affected by the weapon.
     */
    public abstract void useWeapon(AWeapon weapon, ACharacter character);
    
    /**
     * Abstract method used to employ in a Character a AWeapon from a specific index.
     * @param index The index of the AWeapon in the character's weapons arraylist.
     * @param character The character who is going to be affected by the weapon.
     * @throws IndexOutOfBoundsException If index is not in the AWeapon's list bounds.
     */
    public abstract void useWeapon(int index, ACharacter character) throws IndexOutOfBoundsException;
    
    /**
     * Abstract method used to damage the character.
     * @param damage The damage the character will receive.
     */
    public abstract void takeDamage(int damage);
    
    /**
     * Abstract method used to cure the character.
     * @param healthPoints The health points the character will receive.
     */
    public abstract void takeHealth(int healthPoints);
    
    /**
     * Abstract method used to level up a character.
     */
    public abstract void levelUp();
    
    /**
     * Abstract method used to level down a character.
     */
    public abstract void levelDown();
    
    /**
     * Abstract method used to add a weapon to the character weapons list.
     * @param weapon The weapon that will be added.
     */
    public abstract void addWeapon(AWeapon weapon);
    
    /**
     * Abstract method used to delete a weapon from the character's weapons list.
     * @param weapon The weapon that will be deleted.
     */
    public abstract void deleteWeapon(AWeapon weapon);
    
    /**
     * Abstract method used to remove a weapon from a specific index in the character's weapons list.
     * @param index The index of the weapon that will be removed.
     * @throws IndexOutOfBoundsException If the index is not in the ACharacter's weapons list bounds.
     */
    public abstract void deleteWeapon(int index) throws IndexOutOfBoundsException;
    
    /**
     * Abstract method used to level up the character's weapons.
     */
    public abstract void levelUpWeapons();
    
    /**
     * Abstract method used to level down the character's weapons.
     */
    public abstract void levelDownWeapons();
    
    /**
     * Abstract method used to move the character to another x,y position in a space unit.
     * @param x The new X coordinate.
     * @param y The new Y coordinate.
     */
    public abstract void move(int x, int y);
    
    
    @Override
    public abstract String toString();
}
