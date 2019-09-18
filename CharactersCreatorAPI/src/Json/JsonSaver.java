/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Json;

/**
 *
 * @author Marco Gamboa
 */
import abstraction.ACharacter;
import abstraction.AWeapon;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonSaver {
    private ObjectMapper mapper = new ObjectMapper();
    
    
    public void saveCustomCharacter(ACharacter value,String strFile){
        try{
            File file = new File(getClass().getResource(strFile).toURI());
            try {

                List<ACharacter> arr = mapper.readValue(file, List.class);
                arr.add(value);
                mapper.writeValue(file, arr);
                System.out.println(arr.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }   
        }catch (URISyntaxException ex){
            Logger.getLogger(JsonLoader.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    public void saveCustomCharacters(ArrayList<ACharacter> values,String strFile){
        for(int i=0;i<values.size();i++){
            saveCustomCharacter(values.get(i), strFile);
        }
    }

    public void saveCustomWeapon(AWeapon value,String strFile){   
        try{
            File file = new File(getClass().getResource(strFile).toURI());
            try {
                List<AWeapon> arr = mapper.readValue(file, List.class);
                arr.add(value);
                mapper.writeValue(file, arr);
                System.out.println(arr.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }   
        }catch (URISyntaxException ex){
            Logger.getLogger(JsonLoader.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    public void saveCustomWeapons(ArrayList<AWeapon> values,String strFile){
        for(int i=0;i<values.size();i++){
            saveCustomWeapon(values.get(i), strFile);
        }
    }
              
}