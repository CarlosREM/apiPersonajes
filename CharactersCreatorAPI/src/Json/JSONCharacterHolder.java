/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Json;

import abstraction.ACharacter;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.util.List;


@JsonTypeInfo(
        use = JsonTypeInfo.Id.CLASS,
        include = JsonTypeInfo.As.PROPERTY,
        property = "@class"
)
public class JSONCharacterHolder {
    List<ACharacter> characters;
    
    public JSONCharacterHolder(){
        
    }

    public JSONCharacterHolder(List<ACharacter> characters) {
        this.characters = characters;
    }

    public List<ACharacter> getCharacters() {
        return characters;
    }

    public void setCharacters(List<ACharacter> characters) {
        this.characters = characters;
    }
}
