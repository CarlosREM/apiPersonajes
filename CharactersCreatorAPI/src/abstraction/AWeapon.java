package abstraction;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.util.TreeMap;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.CLASS,
        include = JsonTypeInfo.As.PROPERTY,
        property = "@class"
)

/**
 * Abstract class used to implements weapons.
 * @author Fabricio Ceciliano
 * @author Carlos Esquivel
 * @author Marco Gamboa
 * @author Diego Murillo
 */
public abstract class AWeapon implements IPrototype, ILookable{
    private String name = "Melee" ;
    private int range = 1;
    private int damage = 1;
    private int level = 1;
    private int areaOfEffect = 1;
    private int hitPerUnit = 1;
    private TreeMap<Integer,AAppearance> appearances = new TreeMap<>();
    private int unlockLevel = 1;
    
    /**
     * Creates a weapon with the default information.
     */
    public AWeapon(){
        
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

    /**
     * Gets the weapon's name.
     * @return A string containing the name of the weapon.
     */
    public String getName() {
        return name;
    }
    /**
     * Sets the weapon's name.
     * @param name A string containing the new weapon's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the weapon's use range.
     * @return An int containing the weapon's use range.
     */
    public int getRange() {
        return range;
    }
    /**
     * Sets the weapon's use range.
     * @param range An int containing the weapon's new use range.
     */
    public void setRange(int range) {
        this.range = range;
    }

    /**
     * Gets the weapon damage amount.
     * @return An int containin the weapon damage amount.
     */
    public int getDamage() {
        return damage;
    }
    /**
     * Sets the weapon damage amount.
     * @param damage An int containing the weapon's new damage amount.
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * Gets the weapon level.
     * @return An int containing the weapon level.
     */
    public int getLevel() {
        return level;
    }
    /**
     * Sets the weapon level.
     * @param level The weapon's new level.
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Gets the weapon area of effect in a space unit.
     * @return An int containing the weapon's area of effect in a space unit.
     */
    public int getAreaOfEffect() {
        return areaOfEffect;
    }
    /**
     * Sets the weapon area of effect in a space unit.
     * @param areaOfEffect The weapon's new area of effect in a space unit.
     */
    public void setAreaOfEffect(int areaOfEffect) {
        this.areaOfEffect = areaOfEffect;
    }

    /**
     * Gets the weapon's hits per unit of time.
     * @return An int containing the weapon's hits per unit of time.
     */
    public int getHitPerUnit() {
        return hitPerUnit;
    }
    /**
     * Sets the weapon's hits per unit of time.
     * @param hitPerUnit The new weapon's hits per unit of time.
     */
    public void setHitPerUnit(int hitPerUnit) {
        this.hitPerUnit = hitPerUnit;
    }

    /**
     * Gets the level at which weapon will be unlock.
     * @return An int containing the weapon unlock level.
     */
    public int getUnlockLevel() {
        return unlockLevel;
    }
    /**
     * Sets the weapon unlock level.
     * @param unlockLevel The new level at which weapon will be unlock.
     */
    public void setUnlockLevel(int unlockLevel) {
        this.unlockLevel = unlockLevel;
    }
    
    /**
     * Gets the appearance of a specific weapon level.
     * @param level The level of which you want to get the appearance.
     * @return An AAppearance of the specified weapon level
     * @see AAppearance
     */
    @Override
    public AAppearance getAppearance(int level) {
        return appearances.floorEntry(level).getValue();
    }
    
    /**
     * Sets the specific appearance in the specified level.
     * @param level The level to link the appearance.
     * @param appearance The new weapon's appearance.
     */
    @Override
    public void setAppearance(int level, AAppearance appearance) {
        if(this.appearances.containsKey(level))
            this.appearances.replace(level, appearance);
        else
            this.appearances.put(level, appearance);
    }
    
    /**
     * Gets the weapon appearances.
     * @return A TreeMap containing the weapon appearances with its level.
     */
    @Override
    public TreeMap<Integer, AAppearance> getAppearances() {
        return appearances;
    }
    
    /**
     * Abstract method used to employ the weapon in a character.
     * @param character The character that will be affected by the weapon.
     */
    public abstract void use(ACharacter character);
    
    /**
     * Abstract method to level up the weapon.
     */
    public abstract void levelUp();
    
    /**
     * Abstract method to level down the weapon.
     */
    public abstract void levelDown();
}
