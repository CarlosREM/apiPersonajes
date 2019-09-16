/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

import abstraction.IAppearance;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fabricio Ceciliano
 */
public class DefaultWeaponAppearance implements IAppearance{
    private List<String> looks = new ArrayList<>(); 

    public DefaultWeaponAppearance(List<String> looks) {
        this.looks = looks;
    }
    
    public static enum codes {
        DEFAULT;
    }

    @Override
    public String getLook(Enum code) {
        return looks.get(code.ordinal());
    }

    @Override
    public IAppearance deepClone() {
        List<String> newLooks = new ArrayList<>();
        looks.forEach((s) -> {
            newLooks.add(s);
        });
        return new DefaultWeaponAppearance(newLooks);
    }
}