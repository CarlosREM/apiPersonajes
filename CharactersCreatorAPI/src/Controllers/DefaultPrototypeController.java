/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import ADT.DefaultCharacter;
import ADT.DefaultCharacterAppearance;
import ADT.DefaultWeapon;
import ADT.DefaultWeaponAppearance;
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
        ArrayList<ACharacter> a = (ArrayList<ACharacter>) loader.loadDefaultCharacters();
        ArrayList<AWeapon> b = (ArrayList<AWeapon>) loader.loadDefaultWeapons();
    }
    public static void loadCharacterPrototypes(String strFile){
        JsonLoader loader = new JsonLoader();
        ArrayList<ACharacter> a = (ArrayList<ACharacter>) loader.loadCustomCharacters(strFile);
    }  
    public static void loadWeaponPrototypes(String strFile){
        JsonLoader loader = new JsonLoader();
        ArrayList<AWeapon> a = (ArrayList<AWeapon>) loader.loadCustomWeapon(strFile);
    } 
    
    
}
