/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Json;

import abstraction.ACharacter;
import abstraction.AWeapon;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marco Gamboa
 */
public class JsonLoader {
    private ObjectMapper mapper = new ObjectMapper();
    
    public List<ACharacter> loadDefaultCharacters(){
        try {
            File defaultFile = new File(getClass().getResource("/resources/defaultCharacters.json").toURI());
            try {
                return mapper.readValue(defaultFile, new TypeReference<List<ACharacter>>(){});
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } catch (URISyntaxException ex) {      
            Logger.getLogger(JsonLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public List<AWeapon> loadDefaultWeapons(){
        try{
            File defaultFile = new File(getClass().getResource("/resources/defaultWeapon.json").toURI());
            try {
                return mapper.readValue(defaultFile, new TypeReference<List<AWeapon>>(){});
            } catch (IOException e) {
               e.printStackTrace();
               return null;
            }
        } catch (URISyntaxException ex) {      
            Logger.getLogger(JsonLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public List<ACharacter> loadCustomCharacters(String strFile){
        try{
            File file = new File(getClass().getResource(strFile).toURI());
            try {
                 return mapper.readValue(file, new TypeReference<List<ACharacter>>(){});
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }   
        }catch (URISyntaxException ex){
            Logger.getLogger(JsonLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    
    }
    public List<AWeapon> loadCustomWeapon(String strFile){
        try{
            File file = new File(getClass().getResource(strFile).toURI());
            try {
                 return mapper.readValue(file, new TypeReference<List<AWeapon>>(){});
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
         }catch (URISyntaxException ex){
            Logger.getLogger(JsonLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
      
}
