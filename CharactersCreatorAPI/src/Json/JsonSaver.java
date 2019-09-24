package Json;

import ADT.DefaultCharacter;
import abstraction.ACharacter;
import abstraction.AWeapon;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Fabricio Ceciliano
 * @author Carlos Esquivel
 * @author Marco Gamboa
 * @author Diego Murillo
 */
public class JsonSaver {
    private ObjectMapper mapper = new ObjectMapper();
    
    
    
    /**
     * Saves a single ACharacter in a custom json file
     * @param value The ACharacter that will save
     * @param strFile A String with the Json file path of the custom characters
     */
    public void saveCustomCharacter(ACharacter value,String strFile){
        File file = new File(strFile);
        
        try {
            JSONCharacterHolder newHolder = mapper.readValue(file, new TypeReference<JSONCharacterHolder>(){});
            
            
            
            newHolder.getCharacters().add(value);
            
            mapper.writeValue(file, newHolder);
            
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }
    
    /**
     * Saves an arrayList of ACharacters in a custom json file
     * @param values The arrayList of ACharacters that will save 
     * @param strFile A String with the Json file path of the custom characters
     */
    public void saveCustomCharacters(ArrayList<ACharacter> values,String strFile){ 
        for(int i=0;i<values.size();i++){
            saveCustomCharacter(values.get(i), strFile);
        }
    }

    /**
     * Saves a single AWeapon in a custom json file
     * @param value The AWeapon that will save
     * @param strFile A String with the Json file path of the custom weapons
     */
    public void saveCustomWeapon(AWeapon value,String strFile){   
        File file = new File(strFile);
        
        try {
            JSONWeaponHolder newHolder = mapper.readValue(file, new TypeReference<JSONWeaponHolder>(){});
            
            
            
            newHolder.getWeapons().add(value);
            
            mapper.writeValue(file, newHolder);
            
        } catch (IOException e) {
            e.printStackTrace();
        }       
    }
    
    /**
     * Saves an arrayList of AWeapons in a custom json file
     * @param values The arrayList of AWeapons that will save 
     * @param strFile A String with the Json file path of the custom weapons
     */
    public void saveCustomWeapons(ArrayList<AWeapon> values,String strFile){
        for(int i=0;i<values.size();i++){
            saveCustomWeapon(values.get(i), strFile);
        }
    }
}