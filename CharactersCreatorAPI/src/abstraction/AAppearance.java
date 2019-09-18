/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstraction;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fabricio Ceciliano
 */

@JsonTypeInfo(
        use = Id.CLASS,
        include = As.PROPERTY,
        property = "@class"
)
public abstract class AAppearance implements IPrototype<AAppearance>{
    private List<String> looks = new ArrayList<>(); 

    public List<String> getLooks() {
        return looks;
    }

    public void setLooks(List<String> looks) {
        this.looks = looks;
    }
    
    
    public String getLook(Enum code) {
        return looks.get(code.ordinal());
    }
    
}
