package ADT;

import abstraction.AAppearance;
import java.util.ArrayList;
import java.util.List;

/**
 * Class used to make an implementation of an AAppearance to a Default Character
 * @author Fabricio Ceciliano
 * @author Carlos Esquivel
 * @author Marco Gamboa
 * @author Diego Murillo
 * @see AAppearance
 * @see DefaultCharacter
 */
public class DefaultCharacterAppearance extends AAppearance{
    
    /**
     * Creates a default character appearance with the default information from its parent.
     */
    public DefaultCharacterAppearance() {
        super();
    }
    
    /**
     * Creates a default character appearance with the specified information.
     * @param looks String list of images, one for each scenario listed in the corresponding enum. 
     */
    public DefaultCharacterAppearance(List<String> looks) {
        for(String look: looks){
            String newLook = look;
            getLooks().add(newLook);
        }
    }

    /**
     * Enum that contains the different scenarios of the default character appearance.
     */
    public static enum codes {
        DEFAULT,ATTACK,DEFEND,WALK,LOWHEALTH,HURT;
    }

    /**
    * Method to realize a deep clone of the DefaultCharacterAppearance.
     * @return A DefaultCharacterAppearance object with the same information as the current DefaultCharacterAppearance
     */
    @Override
    public AAppearance deepClone() {
        List<String> newLooks = new ArrayList<>();
        getLooks().forEach((s) -> {
            newLooks.add(s);
        });
        return new DefaultCharacterAppearance(newLooks);
    }
}
