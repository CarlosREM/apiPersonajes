/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import ADT.CharacterPrototypeFactory;
import ADT.DefaultCharacter;
import ADT.DefaultCharacterAppearance;
import ADT.DefaultWeapon;
import ADT.DefaultWeaponAppearance;
import abstraction.AWeapon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import static java.lang.Thread.sleep;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import utils.CustomCmBx;
import utils.ImageHandler;
import view.SimulationTab;

/**
 *
 * @author Marco Gamboa
 * @author Carlos Esquivel
 */
public class SimulationController implements ActionListener {
    SimulationTab screen;
    ImageHandler imgHandler;
    Thread simulationThread;
    
    private DefaultCharacter playerCharacter;
    private DefaultCharacter computerCharacter;
    private DefaultWeapon computerWeapon;
    
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
        screen.btnStart.addActionListener(this);
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
        
        screen.cmBxPlayerWeapon.setModel(new DefaultComboBoxModel());
        screen.cmBxPlayerWeapon.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED &
                    screen.cmBxPlayerWeapon.getItemCount() > 0) {
                    AWeapon weapon = playerCharacter.getWeapons().get(screen.cmBxPlayerWeapon.getSelectedIndex());
                    loadWeaponAppearance(screen.lblPlayerWeapon, weapon);
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

        screen.cmBxComWeapon.setModel(new DefaultComboBoxModel());
        screen.cmBxComWeapon.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED &
                    screen.cmBxComWeapon.getItemCount() > 0) {
                    AWeapon weapon = computerCharacter.getWeapons().get(screen.cmBxComWeapon.getSelectedIndex());
                    loadWeaponAppearance(screen.lblComWeapon, weapon);
                }
           }
        });
    }  
    
    private void loadPlayerChar () {
        abstraction.ACharacter character = (abstraction.ACharacter) CharacterPrototypeFactory.getPrototype((String) screen.cmBxPlayerChar.getSelectedItem());
        playerCharacter =  new DefaultCharacter(character.getName(), character.getAppearances(),
                                                character.getMaxHealthPoints(), character.getMaxHealthPoints(),
                                                character.getHitsPerUnit(), character.getLevel(), character.getTiles(),
                                                character.getUnlockLevel(), character.getCost(), character.getWeapons(),
                                                0, 0);
        loadCharAppearance(screen.lblPlayerImage, playerCharacter, DefaultCharacterAppearance.codes.DEFAULT);
        
        screen.txtPlayerHP.setText(String.valueOf(playerCharacter.getMaxHealthPoints()));
        
        screen.cmBxPlayerWeapon.removeAllItems();
        for (AWeapon weapon : playerCharacter.getWeapons()) {
            screen.cmBxPlayerWeapon.addItem(weapon.getName());
        }
    }
    
    private void loadComputerChar () {
        abstraction.ACharacter character = (abstraction.ACharacter) CharacterPrototypeFactory.getPrototype((String) screen.cmBxComChar.getSelectedItem());
        computerCharacter =  new DefaultCharacter(character.getName(), character.getAppearances(),
                                                  character.getMaxHealthPoints(), character.getMaxHealthPoints(),
                                                  character.getHitsPerUnit(), character.getLevel(), character.getTiles(),
                                                  character.getUnlockLevel(), character.getCost(), character.getWeapons(),
                                                  0, 0);
        loadCharAppearance(screen.lblComputerImage, computerCharacter, DefaultCharacterAppearance.codes.DEFAULT);
        
        screen.txtComHP.setText(String.valueOf(computerCharacter.getMaxHealthPoints()));

        screen.cmBxComWeapon.removeAllItems();
        for (AWeapon weapon : computerCharacter.getWeapons()) {
            screen.cmBxComWeapon.addItem(weapon.getName());
        }
    }
    
    private void loadCharAppearance(javax.swing.JLabel lbl, abstraction.ACharacter character, DefaultCharacterAppearance.codes appearance) {
        try {
            lbl.setText("");
            String imageURL = character.getAppearance(character.getLevel()).getLook(appearance);
            lbl.setIcon(imgHandler.createImageicon(imageURL, lbl.getWidth(), lbl.getHeight()));   
        }
        catch(NullPointerException ex) {
            lbl.setIcon(null);
            lbl.setText("No sprites found");
        }
    }
    
    private void loadWeaponAppearance(javax.swing.JLabel lbl, AWeapon weapon) {
        try {
            lbl.setText("");
            String imageURL = weapon.getAppearance(weapon.getLevel()).getLook(DefaultWeaponAppearance.codes.DEFAULT);
            lbl.setIcon(imgHandler.createImageicon(imageURL, lbl.getWidth(), lbl.getHeight()));   
        }
        catch(NullPointerException ex) {
            lbl.setIcon(null);
            lbl.setText("No sprites found");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "START":
                if (screen.cmBxPlayerChar.getSelectedIndex() < 0 || screen.cmBxComChar.getSelectedIndex() < 0) {
                    JOptionPane.showMessageDialog(screen, "Both players must select a Character", "Start Simulation", JOptionPane.ERROR_MESSAGE);  
                    break;
                }
                screen.cmBxPlayerChar.setEnabled(false);
                screen.cmBxComChar.setEnabled(false);
                screen.btnStart.setEnabled(false);
                screen.btnStop.setEnabled(true);
                screen.btnPlayerAttack.setEnabled(true);
                screen.cmBxComWeapon.setEnabled(false);
                
                int weaponIndex = screen.cmBxComWeapon.getSelectedIndex();
                computerWeapon = (DefaultWeapon) computerCharacter.getWeapons().get(weaponIndex);
                
                screen.writeCombatLog("Combat has started!\n");
                screen.writeCombatLog("Select a weapon to attack!");
                break;
                
            case "STOP":
                loadPlayerChar();
                loadComputerChar();
                screen.clearCombatLog();

                screen.cmBxPlayerChar.setEnabled(true);
                screen.cmBxComChar.setEnabled(true);
                screen.btnStart.setEnabled(true);
                screen.btnStop.setEnabled(false);
                screen.btnPlayerAttack.setEnabled(false);
                screen.cmBxComWeapon.setEnabled(true);
                break;
                
            case "Attack":
                simulationThread = new Thread() {
                    @Override
                    public void run(){
                        try {
                            screen.btnPlayerAttack.setEnabled(false);
                            turnSimulation();
                        }
                        catch(Exception ex) {}
                    }
                };
                simulationThread.start();
                break;
                
            default:
                throw new UnsupportedOperationException("Not supported.");
        }
    }
    
    private void turnSimulation() throws InterruptedException {
        playerTurn();
        sleep(1000);
        if (!simulationThread.isInterrupted() & computerCharacter.getCurrentHealthPoints() <= 0) {
            screen.writeCombatLog("PLAYER:"+playerCharacter.getName()+" has won!");
            loadCharAppearance(screen.lblPlayerImage, playerCharacter, DefaultCharacterAppearance.codes.DEFAULT);
            return;
        }
        
        if (!simulationThread.isInterrupted()) computerTurn();
        sleep(1000);
        if (!simulationThread.isInterrupted() & playerCharacter.getCurrentHealthPoints() <= 0) {
            screen.writeCombatLog("COM:"+computerCharacter.getName()+" has won!");
            loadCharAppearance(screen.lblComputerImage, computerCharacter, DefaultCharacterAppearance.codes.DEFAULT);
            return;
        }
        
        if (!simulationThread.isInterrupted()) setPlayerDefaultAppearance();
        if (!simulationThread.isInterrupted()) setComputerDefaultAppearance();
        
        screen.writeCombatLog("Select a Weapon to attack!");
        screen.btnPlayerAttack.setEnabled(true);
    }
    
    private void playerTurn() {
        loadCharAppearance(screen.lblPlayerImage, playerCharacter, DefaultCharacterAppearance.codes.ATTACK);
        
        int weaponIndex = screen.cmBxPlayerWeapon.getSelectedIndex();
        DefaultWeapon playerWeapon = (DefaultWeapon) playerCharacter.getWeapons().get(weaponIndex);
        playerCharacter.useWeapon(playerWeapon, computerCharacter);
        int damage = playerWeapon.getDamage()*playerWeapon.getHitPerUnit();
        screen.writeCombatLog("PLAYER:"+playerCharacter.getName() + " attacks COM:"+computerCharacter.getName()
                             +" with "+playerWeapon.getName()+" "+playerWeapon.getHitPerUnit()+" times, dealing "+damage+" damage!");
        
        screen.txtComHP.setText(String.valueOf(computerCharacter.getCurrentHealthPoints()));
        loadCharAppearance(screen.lblComputerImage, computerCharacter, DefaultCharacterAppearance.codes.HURT);
    }
    
    private void computerTurn() {
        loadCharAppearance(screen.lblComputerImage, computerCharacter, DefaultCharacterAppearance.codes.ATTACK);
        
        computerCharacter.useWeapon(computerWeapon, playerCharacter);
        int damage = computerWeapon.getDamage()*computerWeapon.getHitPerUnit();
        screen.writeCombatLog("COM:"+computerCharacter.getName() + " attacks PLAYER:"+playerCharacter.getName()
                             +" with "+computerWeapon.getName()+" "+computerWeapon.getHitPerUnit()+" times, dealing "+damage+" damage!\n");
        
        screen.txtPlayerHP.setText(String.valueOf(playerCharacter.getCurrentHealthPoints()));
        loadCharAppearance(screen.lblPlayerImage, playerCharacter, DefaultCharacterAppearance.codes.HURT);
    }
    
    private void setPlayerDefaultAppearance() {
        if (playerCharacter.getCurrentHealthPoints() <= playerCharacter.getMaxHealthPoints() / 3)
            loadCharAppearance(screen.lblPlayerImage, playerCharacter, DefaultCharacterAppearance.codes.LOWHEALTH);
        else
            loadCharAppearance(screen.lblPlayerImage, playerCharacter, DefaultCharacterAppearance.codes.DEFAULT);
    }
    
    private void setComputerDefaultAppearance() {
        if (computerCharacter.getCurrentHealthPoints() <= computerCharacter.getMaxHealthPoints() / 3)
            loadCharAppearance(screen.lblComputerImage, computerCharacter, DefaultCharacterAppearance.codes.LOWHEALTH);
        else
            loadCharAppearance(screen.lblComputerImage, computerCharacter, DefaultCharacterAppearance.codes.DEFAULT);
    }
    
    public void clear() {
        if (simulationThread != null & simulationThread.isAlive())
            simulationThread.interrupt();
        screen.clear();
        playerCharacter = null;
        computerCharacter = null;
        computerWeapon = null;
    }
}
