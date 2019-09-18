/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

import abstraction.AAppearance;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fabricio Ceciliano
 */
public class DefaultCharacterAppearance extends AAppearance{
    

    public DefaultCharacterAppearance(List<String> looks) {
        for(String look: looks){
            String newLook = look;
            getLooks().add(newLook);
        }
        
    }

    public DefaultCharacterAppearance() {
    }


    
    public static enum codes {
        DEFAULT,ATTACK,DEFEND,WALK,LOWHEALTH,HURT;
    }

    @Override
    public AAppearance deepClone() {
        List<String> newLooks = new ArrayList<>();
        getLooks().forEach((s) -> {
            newLooks.add(s);
        });
        return new DefaultCharacterAppearance(newLooks);
    }
}
