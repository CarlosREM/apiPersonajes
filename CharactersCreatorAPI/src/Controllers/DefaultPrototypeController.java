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
     * Static method used to load the default prototypes from a Json file to the corresponding Character or Weapon prototype factory.
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
     * 
     * @param strFile 
     */
    public static void loadCharacterPrototypes(String strFile){
        JsonLoader loader = new JsonLoader();
        ArrayList<ACharacter> characters = (ArrayList<ACharacter>) loader.loadCustomCharacters(strFile);
        for (ACharacter c:characters){
            CharacterPrototypeFactory.addPrototype(c.getName(), c);
        }    
    }  
    
    /**
     * 
     * @param strFile 
     */
    public static void loadWeaponPrototypes(String strFile){
        JsonLoader loader = new JsonLoader();
        ArrayList<AWeapon> weapons = (ArrayList<AWeapon>) loader.loadCustomWeapon(strFile);
        for (AWeapon w:weapons){
            WeaponPrototypeFactory.addPrototype(w.getName(), w);
        }   
    } 
}
