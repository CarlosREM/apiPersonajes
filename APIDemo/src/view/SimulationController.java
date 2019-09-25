/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import ADT.CharacterPrototypeFactory;
import abstraction.ACharacter;
import ADT.DefaultCharacterAppearance;
import ADT.DefaultWeaponAppearance;
import abstraction.AWeapon;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultComboBoxModel;
import utils.CustomCmBx;
import utils.ImageHandler;

/**
 *
 * @author Marco Gamboa
 */
public class SimulationController implements ActionListener {
    SimulationTab screen;
    ImageHandler imgHandler;
    
    private ACharacter playerCharacter;
    private ACharacter computerCharacter;
    
    public void setcmBxModelCharacters(DefaultComboBoxModel cmBxModel) {
        screen.cmBxPlayerChar.setModel(new CustomCmBx.Model(cmBxModel));
        screen.cmBxPlayerChar.setSelectedIndex(-1);
        screen.cmBxComChar.setModel(new CustomCmBx.Model(cmBxModel));
        screen.cmBxComChar.setSelectedIndex(-1);
        
    }
    
    
    public SimulationController(SimulationTab screen) {
        this.screen = screen;
        this.imgHandler = new ImageHandler();
        setupListeners();
    }
    
    private void setupListeners() {
        screen.btnReady.addActionListener(this);
        screen.btnStop.addActionListener(this);
        screen.btnPlayerAttack.addActionListener(this);   
        
        screen.cmBxPlayerChar.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    loadPlayerChar();
                }
           }
        });
        
        screen.cmBxComChar.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    loadComputerChar();
                }
           }
        });
    }  
    
    private void loadPlayerChar () {
        playerCharacter = (ACharacter) CharacterPrototypeFactory.getPrototype((String) screen.cmBxPlayerChar.getSelectedItem()).deepClone();
        loadCharAppearance(screen.lblPlayerImage, playerCharacter);
        
        screen.txtPlayerHP.setText(String.valueOf(playerCharacter.getMaxHealthPoints()));
        
        DefaultComboBoxModel<String> cmBxModelCharWeapons = new DefaultComboBoxModel<>();
        for (AWeapon weapon : playerCharacter.getWeapons()) {
            cmBxModelCharWeapons.addElement(weapon.getName());
        }
        screen.cmBxPlayerWeapon.setModel(cmBxModelCharWeapons);
    }
    
    private void loadComputerChar () {
        computerCharacter = (ACharacter) CharacterPrototypeFactory.getPrototype((String) screen.cmBxComChar.getSelectedItem()).deepClone();
        loadCharAppearance(screen.lblComputerImage, computerCharacter);
        
        screen.txtComHP.setText(String.valueOf(computerCharacter.getMaxHealthPoints()));

        DefaultComboBoxModel<String> cmBxModelCharWeapons = new DefaultComboBoxModel<>();
        for (AWeapon weapon : computerCharacter.getWeapons()) {
            cmBxModelCharWeapons.addElement(weapon.getName());
        }
        screen.cmBxComWeapon.setModel(cmBxModelCharWeapons);
    }
    
    private void loadCharAppearance(javax.swing.JLabel lbl, ACharacter character) {
        String imageURL = character.getAppearance(character.getLevel()).getLook(DefaultCharacterAppearance.codes.DEFAULT);
        lbl.setIcon(imgHandler.createImageicon(imageURL, lbl.getWidth(), lbl.getHeight()));   
    }
    
    private void loadWeaponAppearance(javax.swing.JLabel lbl, AWeapon weapon) {
       String imageURL = weapon.getAppearance(weapon.getLevel()).getLook(DefaultWeaponAppearance.codes.DEFAULT);
       lbl.setIcon(imgHandler.createImageicon(imageURL, lbl.getWidth(), lbl.getHeight()));   
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "Attack":
                System.out.println("hola");
                break;
            default:
                throw new UnsupportedOperationException("Not supported.");
        }
    }

}
