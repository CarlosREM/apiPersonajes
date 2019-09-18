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
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonSaver {
    private ObjectMapper mapper = new ObjectMapper();
    
    
    public void saveCustomCharacter(ACharacter value,String strFile){
            File file = new File(strFile);
            try {

                List<ACharacter> arr = mapper.readValue(file, List.class);
                arr.add(value);
                mapper.writeValue(file, arr);
                System.out.println(arr.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }        
    }
    public void saveCustomCharacters(ArrayList<ACharacter> values,String strFile){
        for(int i=0;i<values.size();i++){
            saveCustomCharacter(values.get(i), strFile);
        }
    }

    public void saveCustomWeapon(AWeapon value,String strFile){   
            File file = new File(strFile);
            try {
                List<AWeapon> arr = mapper.readValue(file, List.class);
                arr.add(value);
                mapper.writeValue(file, arr);
                System.out.println(arr.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }   
    }
    public void saveCustomWeapons(ArrayList<AWeapon> values,String strFile){
        for(int i=0;i<values.size();i++){
            saveCustomWeapon(values.get(i), strFile);
        }
    }
}