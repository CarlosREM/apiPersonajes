/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import ADT.CharacterPrototypeFactory;
import ADT.DefaultCharacter;
import ADT.DefaultCharacterAppearance;
import ADT.DefaultWeapon;
import ADT.WeaponPrototypeFactory;
import Controllers.DefaultPrototypeController;
import abstraction.ACharacter;
import abstraction.ACharacter;
import abstraction.AWeapon;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

/**
 *
 * @author Carlos Esquivel
 */
public class EditorScreenController implements java.awt.event.ActionListener {
    
    private EditorScreen screen;
    
    public EditorScreenController() {
        screen = new EditorScreen();
        
        setupActionListeners();
        loadComboboxItems();

   
        screen.setVisible(true);
    }

    private void setupActionListeners() {
        screen.btnLoadCharClass.addActionListener(this);
        screen.btnLoadWeaponClass.addActionListener(this);
        screen.btnAddCharAppearance.addActionListener(this);
        screen.btnDelCharAppearance.addActionListener(this);
        screen.btnAddWeaponAppearance.addActionListener(this);
        screen.btnDelWeaponAppearance.addActionListener(this);
        screen.btnAddWeapon.addActionListener(this);
        screen.btnDelWeapon.addActionListener(this);
        screen.btnSaveCharClass.addActionListener(this);
        screen.btnCreateCharObject.addActionListener(this);
        screen.btnSaveWeapon.addActionListener(this);
    }
    
    private void loadComboboxItems() {
        
        screen.cmBxCharClassDefault.setModel(new DefaultComboBoxModel(CharacterPrototypeFactory.getKeys().toArray()));
        screen.cmBxWeaponClassDefault.setModel(new DefaultComboBoxModel(WeaponPrototypeFactory.getKeys().toArray()));
        loadCharClassInfo();   
        loadWeaponClassInfo();
        
    }
    private void loadCharClassInfo (){
        String CharName = screen.cmBxCharClassDefault.getSelectedItem().toString();
        ACharacter character = (ACharacter) CharacterPrototypeFactory.getPrototype(CharName);
 
        screen.txtCharClassName.setText(character.getName());
        screen.spnCharHealth.setValue(character.getMaxHealthPoints());
        screen.spnCharHits.setValue(character.getHitsPerUnit());
        screen.spnCharStartLvl.setValue(character.getLevel());
        screen.spnCharTiles.setValue(character.getTiles());
        screen.spnCharUnlockLvl.setValue(character.getUnlockLevel());
        screen.spnCharCost.setValue(character.getCost());
        ImageLoader imgloader = new ImageLoader();
        String strImage = character.getAppearance(1).getLook(DefaultCharacterAppearance.codes.DEFAULT);
        screen.lblCharSpritePreview.setIcon(imgloader.createImageicon(strImage));
        
        screen.listWeapons.setModel(new DefaultComboBoxModel(WeaponPrototypeFactory.getKeys().toArray()));
        DefaultListModel<String> strWeapons = new DefaultListModel<>();
        for (AWeapon weapon:character.getWeapons()){
            strWeapons.addElement(weapon.getName());
        }
        screen.listClassWeapons.setModel(strWeapons);
       
    }
        
    
        private void loadWeaponClassInfo (){
        String CharName = screen.cmBxWeaponClassDefault.getSelectedItem().toString();
        AWeapon weapon = (AWeapon) WeaponPrototypeFactory.getPrototype(CharName);
 
        screen.txtWeaponClassName.setText(weapon.getName());
        screen.spnWeaponStartLvl.setValue(weapon.getLevel());
        screen.spnWeaponUnlockLvl.setValue(weapon.getUnlockLevel());
        screen.spnWeaponAOE.setValue(weapon.getAreaOfEffect());
        screen.spnWeaponDmg.setValue(weapon.getDamage());
        screen.spnWeaponRange.setValue(weapon.getRange());
        screen.spnWeaponHits.setValue(weapon.getHitPerUnit());       
        
        ImageLoader imgloader = new ImageLoader();
        String strImage = weapon.getAppearance(1).getLook(DefaultCharacterAppearance.codes.DEFAULT);
        screen.lblWeaponSpritePreview.setIcon(imgloader.createImageicon(strImage));
        
    }
    public AWeapon captureWeaponClassInput(){
        DefaultWeapon character = new DefaultWeapon();
       /* String name = screen.txtWeaponClassName.getText();
        int level = screen.spnWeaponStartLvl.getValue(),
            unlockLevel = screen.spnWeaponUnlockLvl.getValue(),
            aoe = screen.spnWeaponAOE.getValue(),   
            damage = screen.spnWeaponDmg.getValue(),
            range = screen.spnWeaponRange.getValue(),   
            hits = screen.spnWeaponHits.getValue();     
        return null;*/
       return null;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "Load Character Class Info":
                loadCharClassInfo();
                break;
            case ">":
                
                break;
            case "X":
                
                break;
            case "Add New Character Appareance":
                
                break;
            case "Delete Selected Character Appearance":
                
                break;
            case "Save Character Class":
                
                break;
            case "Create Character Object":
                
                break;
            case "Load Weapon Class Info":
                loadWeaponClassInfo();
                break;
            case "Add New Weapon Appareance":
                
                break;
            case "Delete Selected Weapon Appearance":
                
                break;
            case "Save Weapon Class":
                
                break;
        }
    }
}
