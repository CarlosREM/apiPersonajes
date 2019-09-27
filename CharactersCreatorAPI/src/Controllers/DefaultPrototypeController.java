package Controllers;
import ADT.WeaponPrototypeFactory;
import ADT.CharacterPrototypeFactory;
import Json.JsonLoader;
import Json.JsonSaver;
import java.util.ArrayList;
import abstraction.ACharacter;
import abstraction.AWeapon;
import java.io.IOException;

/**
 * Class used to manage the default prototype implementation.
 * @author Fabricio Ceciliano
 * @author Carlos Esquivel
 * @author Marco Gamboa
 * @author Diego Murillo
 */
public class DefaultPrototypeController {
    
     /**
     * Static method used to load the default prototypes from a Json file to the corresponding Character and Weapon prototype factory.
     * @see CharacterPrototypeFactory
     * @see WeaponPrototypeFactory
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
     * Static method to load the character prototypes into the CharacterPrototypeFactory through a file.
     * @param strFile The path of the file containing the prototypes.
     * @see CharacterPrototypeFactory
     */
    public static void loadCharacterPrototypes(String strFile){
        JsonLoader loader = new JsonLoader();
        ArrayList<ACharacter> characters = (ArrayList<ACharacter>) loader.loadCustomCharacters(strFile);
        for (ACharacter c:characters){
            CharacterPrototypeFactory.addPrototype(c.getName(), c);
        }    
    }  
    
    /**
     * Static method to load the weapons prototypes into the WeaponPrototypeFactory through a file.
     * @param strFile The path of the file containing the prototypes.
     * @see WeaponPrototypeFactory
     */
    public static void loadWeaponPrototypes(String strFile){
        JsonLoader loader = new JsonLoader();
        ArrayList<AWeapon> weapons = (ArrayList<AWeapon>) loader.loadCustomWeapon(strFile);
        for (AWeapon w:weapons){
            WeaponPrototypeFactory.addPrototype(w.getName(), w);
        }   
    } 
    
    /**
     * Static method to export to a JSON file the info of all characters stored in the prototype factory.
     * @param directory The desired directory to used to realize the export operation.
     * @throws IOException If the directory doesn't exists.
     */
    public static void exportCharacterPrototypes(String directory) throws IOException{
        String path = DefaultFilesController.createCharacterJson(directory);
        JsonSaver saver = new JsonSaver();
        saver.saveCustomCharacters((ArrayList<ACharacter>) CharacterPrototypeFactory.getAllCharacters(),path);
    }
    
    /**
     * Static method to export to a JSON file the info of all weapons stored in the prototype factory.
     * @param directory The desired directory to used to realize the export operation.
     * @throws IOException If the directory doesn't exists.
     */
    public static void exportWeaponPrototypes(String directory)throws IOException{
        String path = DefaultFilesController.createWeaponJson(directory);
        JsonSaver saver = new JsonSaver();
        saver.saveCustomWeapons((ArrayList<AWeapon>) WeaponPrototypeFactory.getAllWeapons(),path);
    }
}
