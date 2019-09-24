package Json;

import abstraction.ACharacter;
import abstraction.AWeapon;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fabricio Ceciliano
 * @author Carlos Esquivel
 * @author Marco Gamboa
 * @author Diego Murillo
 */
public class JsonLoader {
    private static ObjectMapper mapper = new ObjectMapper();
    
    /**
     * Loads a json with default values for Characters
     * @return A list of ACharacteres with API's defaults 
     */
    public List<ACharacter> loadDefaultCharacters(){    
        InputStream defaultFile = getClass().getResourceAsStream("/resources/defaultCharacters.json"); //getResource("/resources/defaultCharacters.json").toExternalForm());
        String json = null;

        try(Scanner scanner = new Scanner(defaultFile, StandardCharsets.UTF_8.name())){
            json = scanner.useDelimiter("\\A").next();
        }
        try {
            JSONCharacterHolder newHolder = mapper.readValue(json, new TypeReference<JSONCharacterHolder>(){});
            return newHolder.getCharacters();
            
        } catch (IOException ex) {
            Logger.getLogger(JsonLoader.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    /**
     * Loads a json with default values for Weapons
     * @return A list of AWeapons with API's defaults 
     */
    public List<AWeapon> loadDefaultWeapons(){
        InputStream defaultFile = getClass().getResourceAsStream("/resources/defaultWeapons.json"); //getResource("/resources/defaultCharacters.json").toExternalForm());
        String json = null;

        try(Scanner scanner = new Scanner(defaultFile, StandardCharsets.UTF_8.name())){
            json = scanner.useDelimiter("\\A").next();
        }
        try {

            JSONWeaponHolder newHolder = mapper.readValue(json, new TypeReference<JSONWeaponHolder>(){});
            return newHolder.getWeapons();
        } catch (IOException ex) {
            Logger.getLogger(JsonLoader.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }            
    }
    
    /**
     * Loads a json with custom values for Characters
     * @param strFile The file path of the custom json of characters
     * @return A list of ACharacters with the custom characters 
     */
    public List<ACharacter> loadCustomCharacters(String strFile){
        File file = new File(strFile);
        try {
            JSONCharacterHolder newHolder = mapper.readValue(file, new TypeReference<JSONCharacterHolder>(){});
            return newHolder.getCharacters();
            
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }   
    
    }
    
    /**
     * Loads a json with custom values for Weapons
     * @param strFile The file path of the custom json of weapons
     * @return A list of AWeapons with the custom weapons
     */
    public List<AWeapon> loadCustomWeapon(String strFile){
        File file = new File(strFile);
        try {
            JSONWeaponHolder newHolder = mapper.readValue(file, new TypeReference<JSONWeaponHolder>(){});
            return newHolder.getWeapons();
             
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
