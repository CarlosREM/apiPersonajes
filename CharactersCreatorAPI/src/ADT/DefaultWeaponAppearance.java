package ADT;

import abstraction.AAppearance;
import java.util.ArrayList;
import java.util.List;

/**
 * Class used to make an implementation of an AAppearance to a Default Weapon
 * @author Fabricio Ceciliano
 * @author Carlos Esquivel
 * @author Marco Gamboa
 * @author Diego Murillo
 * @see AAppearance
 * @see DefaultWeapon
 */
public class DefaultWeaponAppearance extends AAppearance{
    
    /**
     * Creates a default weapon appearance with the default information from its parent.
     */
    public DefaultWeaponAppearance(){
        super();
    }

    /**
     * Creates a default weapon appearance with the specified information.
     * @param looks String list of images, one for each scenario listed in the corresponding enum. 
     */
    public DefaultWeaponAppearance(List<String> looks) {
        for(String look: looks){
            String newLook = look;
            getLooks().add(newLook);
        }
    }
    
    /**
     * Enum that contains the different scenarios of the default weapon appearance.
     */
    public static enum codes {
        DEFAULT;
    }

    /**
     * Method to realize a deep clone of the DefaultWeaponAppearance.
     * @return A DefaultWeaponAppearance object with the same information as the current DefaultWeaponAppearance
     */
    @Override
    public AAppearance deepClone() {
        List<String> newLooks = new ArrayList<>();
        getLooks().forEach((s) -> {
            newLooks.add(s);
        });
        return new DefaultWeaponAppearance(newLooks);
    }
}