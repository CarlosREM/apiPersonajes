/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APIDemo;

import Controllers.DefaultPrototypeController;
import view.EditorScreen;
import view.CharactersController;
import view.WeaponsController;

/**
 * @author Carlos Esquivel
 * @author Marco Gamboa
 */
public class Main {
    public static void main(String[] args){
        DefaultPrototypeController.loadDefaultPrototypes();
        EditorScreen screen = new EditorScreen();
        CharactersController charController = new CharactersController(screen.getCharactersTab());
        WeaponsController weaponController = new WeaponsController(screen.getWeaponsTab());
        charController.setWeaponList(weaponController.getWeaponClassesModel());
        
        screen.setVisible(true);
    } 
}
