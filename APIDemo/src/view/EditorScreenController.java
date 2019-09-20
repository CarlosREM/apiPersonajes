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
import abstraction.AWeapon;
import java.awt.event.ActionEvent;
import utils.FileFilter;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos Esquivel
 */
public class EditorScreenController implements java.awt.event.ActionListener {
    
    private final EditorScreen screen;
    
    private DefaultComboBoxModel<String> cmBxModelCharClasses;
    private DefaultComboBoxModel<String> cmBxModelWeaponClasses;
    private DefaultListModel<String> listModelClassWeapons;
    
    private ArrayList<AWeapon> weaponList = new ArrayList<>();
    
    
    public EditorScreenController() {
        screen = new EditorScreen();
        
        setupActionListeners();
        loadItems();

        screen.setVisible(true);
    }

    private void setupActionListeners() {
        screen.btnLoadCharClass.addActionListener(this);
        screen.btnCharImportJson.addActionListener(this);
        screen.btnLoadWeaponClass.addActionListener(this);
        screen.btnWeaponImportJson.addActionListener(this);
        screen.btnAddCharAppearance.addActionListener(this);
        screen.btnDelCharAppearance.addActionListener(this);
        screen.btnAddWeaponAppearance.addActionListener(this);
        screen.btnDelWeaponAppearance.addActionListener(this);
        screen.btnAddWeapon.addActionListener(this);
        screen.btnDelWeapon.addActionListener(this);
        screen.btnCharExportJson.addActionListener(this);
        screen.btnCharSaveClass.addActionListener(this);
        screen.btnCharCreateObject.addActionListener(this);
        screen.btnWeaponExportJson.addActionListener(this);
        screen.btnSaveWeapon.addActionListener(this);
    }
    
    private void loadItems() {
        cmBxModelCharClasses = new DefaultComboBoxModel(CharacterPrototypeFactory.getKeys().toArray());
        screen.cmBxCharClassSelect.setModel(cmBxModelCharClasses);
        
        cmBxModelWeaponClasses = new DefaultComboBoxModel(WeaponPrototypeFactory.getKeys().toArray());
        screen.cmBxWeaponClassSelect.setModel(cmBxModelWeaponClasses);
        screen.listWeapons.setModel(cmBxModelWeaponClasses);
        
        //listModelWeapons = (DefaultListModel<String>) screen.listWeapons.getModel();
        
        listModelClassWeapons = new DefaultListModel();
        screen.listClassWeapons.setModel(listModelClassWeapons);
    }
    
    private void loadCharClassInfo (){
        String CharName = screen.cmBxCharClassSelect.getSelectedItem().toString();
        ACharacter character = (ACharacter) CharacterPrototypeFactory.getPrototype(CharName);
 
        screen.txtCharClassName.setText(character.getName());
        screen.spnCharHealth.setValue(character.getMaxHealthPoints());
        screen.spnCharCost.setValue(character.getCost());
        screen.spnCharHits.setValue(character.getHitsPerUnit());
        screen.spnCharTiles.setValue(character.getTiles());
        screen.spnCharStartLvl.setValue(character.getLevel());
        screen.spnCharUnlockLvl.setValue(character.getUnlockLevel());
        
        ImageLoader imgloader = new ImageLoader();
        try {
            String strImage = character.getAppearance(1).getLook(DefaultCharacterAppearance.codes.DEFAULT);
            screen.lblCharSpritePreview.setIcon(imgloader.createImageicon(strImage,
                                                screen.lblCharSpritePreview.getWidth(),
                                                screen.lblCharSpritePreview.getHeight())
            );
        }
        catch(Exception ex) {
            System.out.println("Sorry esta madre no tiene sprites");
        }
        
        weaponList = new ArrayList();
        listModelClassWeapons = new DefaultListModel<>();
        for (AWeapon weapon : character.getWeapons()) {
            weaponList.add(weapon);
            listModelClassWeapons.addElement(weapon.getName());
        }
        screen.listClassWeapons.setModel(listModelClassWeapons);
       
    }
        
    private void loadWeaponClassInfo () {
        String CharName = screen.cmBxWeaponClassSelect.getSelectedItem().toString();
        AWeapon weapon = (AWeapon) WeaponPrototypeFactory.getPrototype(CharName);
 
        screen.txtWeaponClassName.setText(weapon.getName());
        screen.spnWeaponDmg.setValue(weapon.getDamage());
        screen.spnWeaponRange.setValue(weapon.getRange());
        screen.spnWeaponHits.setValue(weapon.getHitPerUnit());       
        screen.spnWeaponAOE.setValue(weapon.getAreaOfEffect());
        screen.spnWeaponStartLvl.setValue(weapon.getLevel());
        screen.spnWeaponUnlockLvl.setValue(weapon.getUnlockLevel());
        
        ImageLoader imgloader = new ImageLoader();
        String strImage = weapon.getAppearance(1).getLook(DefaultCharacterAppearance.codes.DEFAULT);
        screen.lblWeaponSpritePreview.setIcon(imgloader.createImageicon(strImage,
                                            screen.lblCharSpritePreview.getWidth(),
                                            screen.lblCharSpritePreview.getHeight())
        );
    }
        
    public ACharacter captureCharClassInput(){
        String name = screen.txtCharClassName.getText();
        int health =        (Integer) screen.spnCharHealth.getValue(),   
            cost =          (Integer) screen.spnCharCost.getValue(),
            hits =          (Integer) screen.spnCharHits.getValue(), 
            tiles =         (Integer) screen.spnCharTiles.getValue(),   
            level =         (Integer) screen.spnCharStartLvl.getValue(),
            unlockLevel =   (Integer) screen.spnCharUnlockLvl.getValue();
            
       return new DefaultCharacter.DefaultCharacterBuilder()
               .setName(name)
               .setMaxHealthPoints(health)
               .setCost(cost)
               .setHitsPerUnit(hits)
               .setTiles(tiles)
               .setLevel(level)
               .setUnlockLevel(unlockLevel)
               .setWeapons(weaponList)
               .build();
    }
        
    public AWeapon captureWeaponClassInput() {
        String name = screen.txtWeaponClassName.getText();
        int damage =        (Integer) screen.spnWeaponDmg.getValue(),
            range =         (Integer) screen.spnWeaponRange.getValue(),   
            hits =          (Integer) screen.spnWeaponHits.getValue(),
            aoe =           (Integer) screen.spnWeaponAOE.getValue(),   
            level =         (Integer) screen.spnWeaponStartLvl.getValue(),
            unlockLevel =   (Integer) screen.spnWeaponUnlockLvl.getValue();
        return new DefaultWeapon.DefaultWeaponBuilder()
                .setName(name)
                .setDamage(damage)
                .setRange(range)
                .setHitPerUnit(hits)
                .setAreaOfEffect(aoe)
                .setLevel(level)
                .setUnlockLevel(unlockLevel)
                .build();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedOption;
        AWeapon newWeapon;
        ACharacter newCharacter;
        switch(e.getActionCommand()) {
            case "Load Character Class Info":
                selectedOption =
                        JOptionPane.showOptionDialog(screen, "The current information will be lost if you haven't saved. Proceed?",
                                                     "Load Character class info", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
                                                     null, null, null);
                if (selectedOption == JOptionPane.YES_OPTION)
                    loadCharClassInfo();
                break;
                
            case "Import JSON Character Data":
                loadJSONFile();
                break;
                
            case ">":
                String weaponKey = screen.listWeapons.getSelectedValue();
                listModelClassWeapons.addElement(weaponKey);
                newWeapon = (AWeapon) WeaponPrototypeFactory.getPrototype(weaponKey);
                weaponList.add(newWeapon);
                break;
                
            case "X":
                int index = screen.listClassWeapons.getSelectedIndex();
                listModelClassWeapons.remove(index);
                weaponList.remove(index);
                break;
                
            case "Add New Character Appearance":
                System.out.println(e.getActionCommand());
                break;
                
            case "Delete Selected Character Appearance":
                System.out.println(e.getActionCommand());
                break;
                
            case "Export JSON Character Data":
                System.out.println(e.getActionCommand());
                break;
                
            case "Save Character Class":
                newCharacter = captureCharClassInput();
                try {
                    CharacterPrototypeFactory.getPrototype(newCharacter.getName());
                }
                catch(Exception ex) {
                    cmBxModelCharClasses.addElement(newCharacter.getName());
                }
                CharacterPrototypeFactory.addPrototype(newCharacter.getName(), newCharacter);
                break;
                
            case "Create Character Object":
                System.out.println(e.getActionCommand());
                break;
                
            case "Load Weapon Class Info":
                selectedOption =
                        JOptionPane.showOptionDialog(screen, "The current information will be lost if you haven't saved. Proceed?",
                                                     "Load Weapon class info", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
                                                     null, null, null);
                if (selectedOption == JOptionPane.YES_OPTION)
                    loadWeaponClassInfo();
                break;
                
            case "Import JSON Weapon Data":
                loadJSONFile();
                break;
                
            case "Add New Weapon Appearance":
                System.out.println(e.getActionCommand());
                break;
                
            case "Delete Selected Weapon Appearance":
                System.out.println(e.getActionCommand());
                break;
                
            case "Export JSON Weapon Data":
                System.out.println(e.getActionCommand());
                break;
                
            case "Save Weapon Class":
                newWeapon = captureWeaponClassInput();
                try {
                    WeaponPrototypeFactory.getPrototype(newWeapon.getName());
                }
                catch(Exception ex) {
                    cmBxModelWeaponClasses.addElement(newWeapon.getName());
                }
                WeaponPrototypeFactory.addPrototype(newWeapon.getName(), newWeapon);
                break;
        }
    }
    
    private String loadJSONFile() {
        int result =
                JOptionPane.showOptionDialog(screen, "Current classes will be overwritten. Proceed?",
                                             "Load JSON File", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
                                             null, null, null);
        if (result == JOptionPane.NO_OPTION)
            return null;
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileFilter("json", "JSON File"));
        result = fileChooser.showOpenDialog(screen);
        if (result == JFileChooser.APPROVE_OPTION) {
            System.out.println("File directory: "+fileChooser.getSelectedFile().getAbsolutePath());
            return "";
        }
        return null;
    }
}
