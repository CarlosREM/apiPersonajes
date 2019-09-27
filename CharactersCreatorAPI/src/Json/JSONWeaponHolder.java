package Json;

import abstraction.AWeapon;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.util.List;

/**
 * Class used to encapsulates the AWeapon list to save them on JSON files.
 * @author Fabricio Ceciliano
 * @author Carlos Esquivel
 * @author Marco Gamboa
 * @author Diego Murillo
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.CLASS,
        include = JsonTypeInfo.As.PROPERTY,
        property = "@class"
)
public class JSONWeaponHolder {
    List<AWeapon> weapons;
    
    /**
     * Method to create a new JSONWeaponHolder object.
     */
    public JSONWeaponHolder(){}

    /**
     * Method to create a new JSONWeaponHolder object with the specified information.
     * @param weapons An AWeapon list.
     */
    public JSONWeaponHolder(List<AWeapon> weapons) {
        this.weapons = weapons;
    }

    /**
     * Gets the AWeapon list.
     * @return A List of AWeapon.
     */
    public List<AWeapon> getWeapons() {
        return weapons;
    }

    /**
     * Sets the AWeapon list.
     * @param weapons The new AWeapon list.
     */
    public void setWeapons(List<AWeapon> weapons) {
        this.weapons = weapons;
    }
}
