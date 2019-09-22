package view;

import ADT.CharacterPrototypeFactory;
import ADT.DefaultCharacter;
import ADT.DefaultCharacterAppearance;
import ADT.WeaponPrototypeFactory;
import Controllers.DefaultPrototypeController;
import abstraction.AAppearance;
import abstraction.ACharacter;
import abstraction.AWeapon;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TreeMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import utils.FileFilter;
import utils.ImageHandler;

/**
 *
 * @author Carlos Esquivel
 */
public class CharactersController implements ActionListener {
    
    CharactersTabPanel screen;
    ImageHandler imgHandler;
    
    private DefaultComboBoxModel<String> cmBxModelCharClasses;
    private DefaultListModel<String> listModelClassWeapons;
    
    private ArrayList<AWeapon> weaponList = new ArrayList<>();
    private TreeMap<Integer, AAppearance> charSprites = new TreeMap<>();
    
    public void setWeaponList(DefaultComboBoxModel<String> listModelWeapons) {
        screen.listWeapons.setModel(listModelWeapons);
    }
    
    
    public CharactersController(CharactersTabPanel screen) {
        this.screen = screen;
        imgHandler = new ImageHandler();

        setupActionListeners();
        loadItems();
    }
    
    private void setupActionListeners() {
        screen.btnLoadCharClass.addActionListener(this);
        screen.btnCharImportJson.addActionListener(this);
        screen.btnAddCharAppearance.addActionListener(this);
        screen.btnDelCharAppearance.addActionListener(this);
        screen.btnAddWeapon.addActionListener(this);
        screen.btnDelWeapon.addActionListener(this);
        screen.btnCharExportJson.addActionListener(this);
        screen.btnCharSaveClass.addActionListener(this);
        screen.btnCharCreateObject.addActionListener(this);
    }
    
    private void loadItems() {
        cmBxModelCharClasses = new DefaultComboBoxModel(CharacterPrototypeFactory.getKeys().toArray());
        screen.cmBxCharClassSelect.setModel(cmBxModelCharClasses);
        
        listModelClassWeapons = new DefaultListModel<>();
        screen.listClassWeapons.setModel(listModelClassWeapons);
        
        DefaultComboBoxModel<String> charAppearance = new DefaultComboBoxModel();
        for (DefaultCharacterAppearance.codes appearance : DefaultCharacterAppearance.codes.values()) {
            charAppearance.addElement(appearance.name());
        }
        screen.cmBxCharAppearance.setModel(charAppearance);
        screen.cmBxCharAppearanceLvl.setModel(new DefaultComboBoxModel());

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
                new AppearanceDialogController(this, AppearanceDialogController.CHARACTER_MODE);
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
                
            default:
                throw new UnsupportedOperationException("Not supported.");
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
                                                              "Save CharClass", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
                                                              null, null, null);
            if (selectedOption == JOptionPane.NO_OPTION)
                return;
            }
        catch(HeadlessException ex) {
            cmBxModelCharClasses.addElement(newChar.getName());
        }
        CharacterPrototypeFactory.addPrototype(newChar.getName(), newChar);
    }
    
    public boolean checkCharAppearance(int level) {
        return charSprites.containsKey(level);
    }
    
    public void addCharAppearance(int level, AAppearance newAppearance) {
        if (!charSprites.containsKey(level))
            screen.cmBxCharAppearanceLvl.addItem(String.valueOf(level));
        charSprites.put(level, newAppearance);
    }
    
    private void loadCharAppearance() {
        
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
    
}
