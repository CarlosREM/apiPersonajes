/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import ADT.WeaponPrototypeFactory;
import ADT.CharacterPrototypeFactory;
import Json.JsonLoader;
import java.util.ArrayList;
import abstraction.ACharacter;
import abstraction.AWeapon;

/**
 *
 * @author Marco Gamboa
 */
public class DefaultPrototypeController {
    public static void loadDefaultPrototypes(){
        JsonLoader loader = new JsonLoader();
        ArrayList<ACharacter> characters = (ArrayList<ACharacter>) loader.loadDefaultCharacters();
        ArrayList<AWeapon> weapons = (ArrayList<AWeapon>) loader.loadDefaultWeapons();
        for (ACharacter c:characters){
            CharacterPrototypeFactory.addPrototype(c.getName(), c);
        }
        for (AWeapon w:weapons){
            WeaponPrototypeFactory.addPrototype(w.getName(), w);
        }        
    }
    public static void loadCharacterPrototypes(String strFile){
        JsonLoader loader = new JsonLoader();
        ArrayList<ACharacter> characters = (ArrayList<ACharacter>) loader.loadCustomCharacters(strFile);
        for (ACharacter c:characters){
            CharacterPrototypeFactory.addPrototype(c.getName(), c);
        }    
    }  
    public static void loadWeaponPrototypes(String strFile){
        JsonLoader loader = new JsonLoader();
        ArrayList<AWeapon> weapons = (ArrayList<AWeapon>) loader.loadCustomWeapon(strFile);
        for (AWeapon w:weapons){
            WeaponPrototypeFactory.addPrototype(w.getName(), w);
        }   
    } 
}
