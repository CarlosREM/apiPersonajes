/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import ADT.CharacterPrototypeFactory;
import ADT.DefaultCharacterAppearance;
import ADT.WeaponPrototypeFactory;
import Controllers.DefaultPrototypeController;
import abstraction.ACharacter;
import abstraction.ACharacter;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
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
        
        
    }
 
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "Load Character Class Info":
                
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
