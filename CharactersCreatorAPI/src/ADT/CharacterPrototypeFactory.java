/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

import Json.JsonLoader;
import abstraction.ACharacter;
import abstraction.IPrototype;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Fabricio Ceciliano
 */
public class CharacterPrototypeFactory {
    private static final HashMap<String, IPrototype> prototypes = new HashMap<>();
    
    public static IPrototype getPrototype(String prototypeName){
        return prototypes.get(prototypeName).deepClone();
    }
    
    public static void addPrototype(String prototypeName, IPrototype prototype){
        prototypes.put(prototypeName,prototype);
    }
    
    
    
    public static List<IPrototype> getPrototypes(int quantity, String prototypeName){
        List<IPrototype> prototypesList = new ArrayList<>();
        for(int i=0; i<quantity; i++){
            prototypesList.add(getPrototype(prototypeName).deepClone());
        }
        return prototypesList;
    }
    public static List<String> getKeys(){
        return new ArrayList( prototypes.keySet());
    }
}
