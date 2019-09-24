/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Json;

import abstraction.AWeapon;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.util.List;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.CLASS,
        include = JsonTypeInfo.As.PROPERTY,
        property = "@class"
)
public class JSONWeaponHolder {
    List<AWeapon> weapons;
    
    public JSONWeaponHolder(){}

    public JSONWeaponHolder(List<AWeapon> weapons) {
        this.weapons = weapons;
    }

    public List<AWeapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<AWeapon> weapons) {
        this.weapons = weapons;
    }

   
    
    
}
