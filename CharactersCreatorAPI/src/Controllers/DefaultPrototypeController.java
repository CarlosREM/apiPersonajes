package Controllers;
import ADT.WeaponPrototypeFactory;
import ADT.CharacterPrototypeFactory;
import Json.JsonLoader;
import java.util.ArrayList;
import abstraction.ACharacter;
import abstraction.AWeapon;

/**
 *
 * @author Fabricio Ceciliano
 * @author Carlos Esquivel
 * @author Marco Gamboa
 * @author Diego Murillo
 */
public class DefaultPrototypeController {
    
    /**
     * Static method used to load the default prototypes from a Json file to the corresponding Characters or Weapon prototype factory.
     */
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
    
    /**
     * Static method used to load the custom prototypes from a Json file to the corresponding Character prototype factory.
     * @param strFile A String with the Json file path of the custom characters
     */
    public static void loadCharacterPrototypes(String strFile){
        JsonLoader loader = new JsonLoader();
        ArrayList<ACharacter> characters = (ArrayList<ACharacter>) loader.loadCustomCharacters(strFile);
        for (ACharacter c:characters){
            CharacterPrototypeFactory.addPrototype(c.getName(), c);
        }    
    }  
    
    /**
     * Static method used to load the custom prototypes from a Json file to the corresponding Weapon prototype factory.
     * @param strFile A String with the Json file path of the custom  weapons
     */
    public static void loadWeaponPrototypes(String strFile){
        JsonLoader loader = new JsonLoader();
        ArrayList<AWeapon> weapons = (ArrayList<AWeapon>) loader.loadCustomWeapon(strFile);
        for (AWeapon w:weapons){
            WeaponPrototypeFactory.addPrototype(w.getName(), w);
        }   
    } 
}
