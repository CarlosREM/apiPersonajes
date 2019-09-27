package ADT;

import abstraction.AWeapon;
import abstraction.IPrototype;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Class used as a factory of the different weapons prototypes.
 * @author Fabricio Ceciliano
 * @author Carlos Esquivel
 * @author Marco Gamboa
 * @author Diego Murillo
 */
public class WeaponPrototypeFactory {
    private static final HashMap<String, IPrototype> prototypes = new HashMap<>();
    
    /**
     * Static method to get a prototype from the HashMap by its name.
     * @param prototypeName The name of the prototype you want to get from the HashMap.
     * @return An IPrototype object of the weapon.
     */
    public static IPrototype getPrototype(String prototypeName){
        return prototypes.get(prototypeName).deepClone();
    }
    
    /**
     * Static method to insert a prototype into the HashMap.
     * @param prototypeName The name of the new prototype.
     * @param prototype The new prototype.
     */
    public static void addPrototype(String prototypeName, IPrototype prototype){
        prototypes.put(prototypeName,prototype);
    }
    
    /**
     * Static method to get a list of prototypes.
     * @param quantity The quantity of prototypes desired.
     * @param prototypeName The name of the prototype to insert in the list.
     * @return A list with the desired quantity of prototypes.
     */
    public static List<IPrototype> getPrototypes(int quantity, String prototypeName){
        List<IPrototype> prototypesList = new ArrayList<>();
        for(int i=0; i<quantity; i++){
            prototypesList.add(getPrototype(prototypeName));
        }
        return prototypesList;
    }
    
    /**
     * Static method to get the keys from the HashMap
     * @return A list with the key set from the HashMap of prototypes.
     */
    public static List<String> getKeys(){
        return new ArrayList( prototypes.keySet());
    }
    
    /**
     * Static method to get all the weapons stored in the prototype factory
     * @return A List of AWeapon containing all the weapons from the prototype factory
     */
    public static List<AWeapon> getAllWeapons(){
        List<AWeapon> prototypesList = new ArrayList<>();
        for(String key:prototypes.keySet()){
           prototypesList.add((AWeapon)getPrototype(key));
        }
        return prototypesList;
    }
}