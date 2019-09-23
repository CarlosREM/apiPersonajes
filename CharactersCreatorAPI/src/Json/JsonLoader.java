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
     * 
     * @return 
     */
    public List<ACharacter> loadDefaultCharacters(){    
        InputStream defaultFile = getClass().getResourceAsStream("/resources/defaultCharacters.json"); //getResource("/resources/defaultCharacters.json").toExternalForm());
        String json = null;

        try(Scanner scanner = new Scanner(defaultFile, StandardCharsets.UTF_8.name())){
            json = scanner.useDelimiter("\\A").next();
        }
        try {
            return mapper.readValue(json, new TypeReference<List<ACharacter>>(){});
        } catch (IOException ex) {
            Logger.getLogger(JsonLoader.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    /**
     * 
     * @return 
     */
    public List<AWeapon> loadDefaultWeapons(){
        InputStream defaultFile = getClass().getResourceAsStream("/resources/defaultWeapons.json"); //getResource("/resources/defaultCharacters.json").toExternalForm());
        String json = null;

        try(Scanner scanner = new Scanner(defaultFile, StandardCharsets.UTF_8.name())){
            json = scanner.useDelimiter("\\A").next();
        }
        try {

            return mapper.readValue(json, new TypeReference<List<AWeapon>>(){});
        } catch (IOException ex) {
            Logger.getLogger(JsonLoader.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }            
    }
    
    /**
     * 
     * @param strFile
     * @return 
     */
    public List<ACharacter> loadCustomCharacters(String strFile){
        File file = new File(strFile);
        try {
             return mapper.readValue(file, new TypeReference<List<ACharacter>>(){});
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }   
    
    }
    
    /**
     * 
     * @param strFile
     * @return 
     */
    public List<AWeapon> loadCustomWeapon(String strFile){
        File file = new File(strFile);
        try {
             return mapper.readValue(file, new TypeReference<List<AWeapon>>(){});
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
