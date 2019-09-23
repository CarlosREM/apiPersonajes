/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import ADT.CharacterPrototypeFactory;
import ADT.DefaultWeaponAppearance;
import abstraction.ACharacter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import ADT.DefaultCharacterAppearance;
import utils.ImageHandler;

/**
 *
 * @author Marco Gamboa
 */
public class SimulationController implements ActionListener {
    Simulation screen;
    ImageHandler imgHandler;
    
    private ACharacter character;
    
    public SimulationController() {
        this.screen = new Simulation();//screen;
        setupActionListeners();
    }
    
    private void setupActionListeners() {
        screen.btnPlayerAttack.addActionListener(this);   
    }  
    
    private void loadCharClassInfo (){
        //screen.lblPlayerImage

        loadCharAppearance();
                  

    }
    
    private void loadCharAppearance() {
       String imageURL = character.getAppearance(character.getLevel()).getLook(DefaultCharacterAppearance.codes.DEFAULT);
       screen.lblCharSpritePreview.setIcon(imgHandler.createImageicon(imageURL,
                                            screen.lblCharSpritePreview.getWidth(),
                                            screen.lblCharSpritePreview.getHeight()));
       screen.lblCharSpritePreview1.setIcon(imgHandler.createImageicon(imageURL,
                                            screen.lblCharSpritePreview1.getWidth(),
                                            screen.lblCharSpritePreview1.getHeight()));       
    }   
    
    private void loadWeaponAppearance() {
       screen.cbxWeapons.getSelectedItem();
       String imageURL = character.getAppearance(character.getLevel()).getLook(DefaultCharacterAppearance.codes.DEFAULT);
       screen.lblCharSpritePreview.setIcon(imgHandler.createImageicon(imageURL,
                                            screen.lblCharSpritePreview.getWidth(),
                                            screen.lblCharSpritePreview.getHeight()));
       screen.lblCharSpritePreview1.setIcon(imgHandler.createImageicon(imageURL,
                                            screen.lblCharSpritePreview1.getWidth(),
                                            screen.lblCharSpritePreview1.getHeight()));       
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
    public static void main(String args[]) {
       SimulationController s = new SimulationController();
       s.screen.setVisible(true);
    }
}
