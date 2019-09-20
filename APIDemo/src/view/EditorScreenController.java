/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import utils.*;
import ADT.CharacterPrototypeFactory;
import ADT.DefaultCharacter;
import ADT.DefaultCharacterAppearance;
import ADT.DefaultWeapon;
import ADT.DefaultWeaponAppearance;
import ADT.WeaponPrototypeFactory;
import Controllers.DefaultPrototypeController;
import abstraction.ACharacter;
import abstraction.AWeapon;
import abstraction.AAppearance;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.TreeMap;
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
    private final ImageHandler imgHandler;
    
    private DefaultComboBoxModel<String> cmBxModelCharClasses;
    private DefaultComboBoxModel<String> cmBxModelWeaponClasses;
    private DefaultListModel<String> listModelClassWeapons;
    
    private ArrayList<AWeapon> weaponList = new ArrayList<>();
    private TreeMap<Integer, AAppearance> charSprites = new TreeMap<>();
    private TreeMap<Integer, AAppearance> weaponSprites = new TreeMap<>();
    
    
    public EditorScreenController() {
        screen = new EditorScreen();
        imgHandler = new ImageHandler();
        
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
        
        DefaultComboBoxModel<String> charAppearance = new DefaultComboBoxModel();
        for (DefaultCharacterAppearance.codes appearance : DefaultCharacterAppearance.codes.values()) {
            charAppearance.addElement(appearance.name());
        }
        screen.cmBxCharAppearance.setModel(charAppearance);
        screen.cmBxCharAppearanceLvl.setModel(new DefaultComboBoxModel());

        
        DefaultComboBoxModel<String> weaponAppearance = new DefaultComboBoxModel();
        for (DefaultWeaponAppearance.codes appearance : DefaultWeaponAppearance.codes.values()) {
            weaponAppearance.addElement(appearance.name());
        }
        screen.cmBxWeaponAppearance.setModel(weaponAppearance);
        screen.cmBxWeaponAppearanceLvl.setModel(new DefaultComboBoxModel());
    }
    
    private void loadCharClassInfo (){
        String CharName = screen.cmBxCharClassSelect.getSelectedItem().toString();
        ACharacter character = (ACharacter) CharacterPrototypeFactory.getPrototype(CharName);
 
        screen.txtCharClassName.setText(character.getName());
        screen.setCharHealth(character.getMaxHealthPoints());
        screen.setCharCost(character.getCost());
        screen.setCharHits(character.getHitsPerUnit());
        screen.setCharTiles(character.getTiles());
        screen.setCharStartLvl(character.getLevel());
        screen.setCharUnlockLvl(character.getUnlockLevel());
        
        screen.lblCharSpritePreview.setIcon(null);
        screen.cmBxCharAppearance.setSelectedIndex(0);
        screen.cmBxCharAppearanceLvl.setModel(new DefaultComboBoxModel());
        try {
            boolean loadImg = false;
            for (int key : character.getAppearances().keySet()) {
                screen.cmBxCharAppearanceLvl.addItem(String.valueOf(key));
                if (!loadImg) {
                    String strImage = character.getAppearance(key).getLook(DefaultCharacterAppearance.codes.DEFAULT);
                    screen.lblCharSpritePreview.setIcon(imgHandler.createImageicon(strImage,
                                                        screen.lblCharSpritePreview.getWidth(),
                                                        screen.lblCharSpritePreview.getHeight())
                    );
                    loadImg = true;
                }
            }
        }
        catch(Exception ex) {}
        
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
        screen.setWeaponDmg(weapon.getDamage());
        screen.setWeaponRange(weapon.getRange());
        screen.setWeaponHits(weapon.getHitPerUnit());       
        screen.setWeaponAOE(weapon.getAreaOfEffect());
        screen.setWeaponStartLvl(weapon.getLevel());
        screen.setWeaponUnlockLvl(weapon.getUnlockLevel());
        
        screen.lblWeaponSpritePreview.setIcon(null);
        screen.cmBxWeaponAppearance.setSelectedIndex(0);
        screen.cmBxWeaponAppearanceLvl.setModel(new DefaultComboBoxModel());
        try {
            boolean loadImg = false;
            for (int key : weapon.getAppearances().keySet()) {
                screen.cmBxWeaponAppearanceLvl.addItem(String.valueOf(key));
                if (!loadImg) {
                    String strImage = weapon.getAppearance(key).getLook(DefaultWeaponAppearance.codes.DEFAULT);
                    screen.lblWeaponSpritePreview.setIcon(imgHandler.createImageicon(strImage,
                                                        screen.lblWeaponSpritePreview.getWidth(),
                                                        screen.lblWeaponSpritePreview.getHeight())
                    );
                    loadImg = true;
                }
            }
        }
        catch(Exception ex) {}
    }
        
    public ACharacter captureCharClassInput(){
        String name = screen.txtCharClassName.getText();
        int health = screen.getCharHealth(),   
            cost = screen.getCharCost(),
            hits = screen.getCharHits(), 
            tiles = screen.getCharTiles(),   
            level = screen.getCharStartLvl(),
            unlockLevel = screen.getCharUnlockLvl();
            
       return new DefaultCharacter.DefaultCharacterBuilder()
               .setName(name)
               .setMaxHealthPoints(health)
               .setCost(cost)
               .setHitsPerUnit(hits)
               .setTiles(tiles)
               .setLevel(level)
               .setUnlockLevel(unlockLevel)
               .setWeapons(weaponList)
               .setAppearances(charSprites)
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
                .setAppearances(weaponSprites)
                .build();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedOption,
            selectedIndex;
        String path;
        AWeapon newWeapon;
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
                path = loadJSONFile();
                if (path != null) {
                    try {
                        DefaultPrototypeController.loadCharacterPrototypes(path);
                    }
                    catch(Exception ex) {
                        JOptionPane.showMessageDialog(screen, "Error: JSON file doesn't contain Character info",
                                                     "Error - JSON File Parse", JOptionPane.ERROR_MESSAGE);
                    }
                }
                break;
                
            case ">":
                String weaponKey = screen.listWeapons.getSelectedValue();
                listModelClassWeapons.addElement(weaponKey);
                newWeapon = (AWeapon) WeaponPrototypeFactory.getPrototype(weaponKey);
                weaponList.add(newWeapon);
                break;
                
            case "X":
                selectedIndex = screen.listClassWeapons.getSelectedIndex();
                listModelClassWeapons.remove(selectedIndex);
                weaponList.remove(selectedIndex);
                break;
                
            case "Add New Character Appearance":
                new AppearanceDialogController(this, screen, AppearanceDialogController.CHARACTER_MODE);
                break;
                
            case "Delete Character Appearance":
                deleteCharAppearance();
                break;
                
            case "Export JSON Character Data":
                System.out.println(e.getActionCommand());
                                
                JOptionPane.showMessageDialog(screen, "JSON Exported succesfuly",
                                              "Info - Exported JSON", JOptionPane.INFORMATION_MESSAGE);
                break;
                
            case "Save Character Class":
                SaveCharClass();
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
                path = loadJSONFile();
                if (path != null) {
                    try {
                        DefaultPrototypeController.loadWeaponPrototypes(path);
                    }
                    catch(Exception ex) {
                        JOptionPane.showMessageDialog(screen, "Error: JSON file doesn't contain Weapon info",
                                                     "Error - JSON File Parse", JOptionPane.ERROR_MESSAGE);
                    }
                }
                break;
                
            case "Add New Weapon Appearance":
                new AppearanceDialogController(this, screen, AppearanceDialogController.WEAPON_MODE);
                break;
                
            case "Delete Weapon Appearance":
                deleteWeaponAppearance();
                break;
                
            case "Export JSON Weapon Data":
                System.out.println(e.getActionCommand());
                
                JOptionPane.showMessageDialog(screen, "JSON Exported succesfuly",
                                              "Info - Exported JSON", JOptionPane.INFORMATION_MESSAGE);
                break;
                
            case "Save Weapon Class":
                SaveWeaponClass();
                break;
        }
    }
    
    private String loadJSONFile() {
        int result =
                JOptionPane.showOptionDialog(screen, "Current classes may be overwritten. Proceed?",
                                             "Load JSON File", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
                                             null, null, null);
        if (result == JOptionPane.NO_OPTION)
            return null;
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileFilter("json", "JSON File"));
        result = fileChooser.showOpenDialog(screen);
        if (result == JFileChooser.APPROVE_OPTION) {
            System.out.println("File directory: "+fileChooser.getSelectedFile().getAbsolutePath());
            return fileChooser.getSelectedFile().getAbsolutePath();
        }
        return null;
    }
    
    private void SaveCharClass() {
        ACharacter newChar = captureCharClassInput();
        try {
            CharacterPrototypeFactory.getPrototype(newChar.getName());
            int selectedOption = JOptionPane.showOptionDialog(screen, "Char class already exists. Overwrite?",
            "Save CharClass", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
            if (selectedOption == JOptionPane.NO_OPTION)
                return;
            }
        catch(Exception ex) {
            cmBxModelCharClasses.addElement(newChar.getName());
        }
        CharacterPrototypeFactory.addPrototype(newChar.getName(), newChar);
    }
    
    private void SaveWeaponClass() {
        AWeapon newWeapon = captureWeaponClassInput();
        try {
            WeaponPrototypeFactory.getPrototype(newWeapon.getName());
            int selectedOption = JOptionPane.showOptionDialog(screen, "Weapon class already exists. Overwrite?",
            "Save WeaponClass", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
            if (selectedOption == JOptionPane.NO_OPTION)
                return;
            }
        catch(Exception ex) {
            cmBxModelWeaponClasses.addElement(newWeapon.getName());
        }
        WeaponPrototypeFactory.addPrototype(newWeapon.getName(), newWeapon);
    }
    
    public boolean checkCharAppearance(int level) {
        return charSprites.containsKey(level);
    }
    
    public boolean checkWeaponAppearance(int level) {
        return weaponSprites.containsKey(level);
    }
    
    public void addCharAppearance(int level, AAppearance newAppearance) {
        if (!charSprites.containsKey(level))
            screen.cmBxCharAppearanceLvl.addItem(String.valueOf(level));
        charSprites.put(level, newAppearance);
    }
    
    public void addWeaponAppearance(int level, AAppearance newAppearance) {
        if (!weaponSprites.containsKey(level))
            screen.cmBxWeaponAppearanceLvl.addItem(String.valueOf(level));
        weaponSprites.put(level, newAppearance);
    }
    
    private void loadCharAppearance() {
        
    }
    
    private void loadWeaponAppearance() {
        
    }
    
    private void deleteCharAppearance() {      
        if (screen.cmBxCharAppearanceLvl.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(screen, "No appearance selected.", "Delete Character Appearance", JOptionPane.ERROR_MESSAGE); ;
            return;
        }
        
        int selectedOption =
                JOptionPane.showOptionDialog(screen, "The selected level and every Appearance associated will be deleted. Proceed?",
                                                     "Delete Character Appearance", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
                                                     null, null, null);
        if (selectedOption == JOptionPane.YES_OPTION) {
            int selectedIndex = screen.cmBxCharAppearanceLvl.getSelectedIndex();
            selectedOption = Integer.parseInt((String) screen.cmBxCharAppearanceLvl.getSelectedItem());
            screen.cmBxCharAppearanceLvl.removeItemAt(selectedIndex);
            charSprites.remove(selectedOption);
                   
            screen.cmBxCharAppearanceLvl.setSelectedIndex(-1);
            screen.lblCharSpritePreview.setIcon(null);
        }
    }
    
    private void deleteWeaponAppearance() {
        if (screen.cmBxWeaponAppearanceLvl.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(screen, "No appearance selected.", "Delete Weapon Appearance", JOptionPane.ERROR_MESSAGE); ;
            return;
        }
                
        int selectedOption =
                JOptionPane.showOptionDialog(screen, "The selected level and every Appearance associated will be deleted. Proceed?",
                                                     "Delete Weapon Appearance", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
                                                     null, null, null);
        if (selectedOption == JOptionPane.YES_OPTION) {
            int selectedIndex = screen.cmBxWeaponAppearanceLvl.getSelectedIndex();
            selectedOption = Integer.parseInt((String) screen.cmBxWeaponAppearanceLvl.getSelectedItem());
            screen.cmBxWeaponAppearanceLvl.removeItemAt(selectedIndex);
            charSprites.remove(selectedOption);
                    
            screen.cmBxWeaponAppearanceLvl.setSelectedIndex(-1);
            screen.lblWeaponSpritePreview.setIcon(null);
        }
    }
}
