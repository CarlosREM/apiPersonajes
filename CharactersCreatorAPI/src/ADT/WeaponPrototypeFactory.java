/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

import Json.JsonLoader;
import abstraction.AWeapon;
import abstraction.IPrototype;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * @author Fabricio Ceciliano
 */
public class WeaponPrototypeFactory {
    private static final HashMap<String, IPrototype> prototypes = new HashMap<>();
    
    public static IPrototype getPrototype(String prototypeName){
        return prototypes.get(prototypeName).deepClone();
    }
    
    public static void addPrototype(String prototypeName, IPrototype prototype){
        prototypes.put(prototypeName,prototype);
    }
    
    public void loadDefaultPrototype(){
        JsonLoader loader = new JsonLoader();
        List<AWeapon> defaultWeapons = loader.loadDefaultWeapons();
        defaultWeapons.forEach((weapon) -> {
            addPrototype(weapon.getName(), weapon);
        });
    }
    
    public void loadCustomPrototype(String strFile){
        JsonLoader loader = new JsonLoader();
        List<AWeapon> customWeapons = loader.loadCustomWeapon(strFile);
        for(AWeapon weapon : customWeapons){
            addPrototype(weapon.getName(), weapon);
        }
    }
    
    public List<IPrototype> getPrototypes(int quantity, String prototypeName){
        List<IPrototype> prototypesList = new ArrayList<>();
        for(int i=0; i<quantity; i++){
            prototypesList.add(getPrototype(prototypeName));
        }
        return prototypesList;
    }
}