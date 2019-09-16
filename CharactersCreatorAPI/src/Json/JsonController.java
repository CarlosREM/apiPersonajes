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
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonController {
    private ObjectMapper mapper = new ObjectMapper();
    private File file;

    public JsonController(String fileName) {
        this.file = new File(fileName);
    }
    
    public void initialize(){
         try {
            ArrayList<ACharacter> arr= new ArrayList();
            
            mapper.writeValue(file, arr);
        } catch (IOException e) {
            e.printStackTrace();
        }      
    }
    
    public void putObject(ACharacter value){         
        try {
            List<ACharacter> arr = mapper.readValue(file, List.class);
            arr.add(value);
            mapper.writeValue(file, arr);
        } catch (IOException e) {
            e.printStackTrace();
        }    
    }
    public List<ACharacter> getObjects(){
        try {
             return mapper.readValue(file, new TypeReference<List<ACharacter>>(){});
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }       
       
    }
}