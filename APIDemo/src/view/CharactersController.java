package view;

import ADT.CharacterPrototypeFactory;
import ADT.DefaultCharacter;
import ADT.DefaultCharacterAppearance;
import ADT.WeaponPrototypeFactory;
import Controllers.DefaultFilesController;
import Controllers.DefaultPrototypeController;
import abstraction.AAppearance;
import abstraction.ACharacter;
import abstraction.AWeapon;
import abstraction.IPrototype;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import utils.CustomCmBx;
import utils.FileFilter;
import utils.ImageHandler;


/**
 *
 * @author Carlos Esquivel
 */
public class CharactersController implements ActionListener {
    
    CharactersTab screen;
    ImageHandler imgHandler;
    
    private DefaultComboBoxModel<String> cmBxModelCharClasses;
    private DefaultListModel<String> listModelClassWeapons;
    
    private ArrayList<AWeapon> weaponList = new ArrayList<>();
    private TreeMap<Integer, AAppearance> charSprites = new TreeMap<>();
    
    public DefaultComboBoxModel<String> getCharClasses() {
        return cmBxModelCharClasses;
    }
    
    public void setWeaponList(DefaultComboBoxModel<String> listModelWeapons) {
        screen.listWeapons.setModel(listModelWeapons);
    }
    
    
    public CharactersController(CharactersTab screen) {
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
        screen.cmBxCharClassSelect.setModel(new CustomCmBx.Model(cmBxModelCharClasses));
        
        listModelClassWeapons = new DefaultListModel<>();
        screen.listClassWeapons.setModel(listModelClassWeapons);
        
        screen.cmBxCharAppearanceLvl.setModel(new DefaultComboBoxModel());
        screen.cmBxCharAppearanceLvl.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED & screen.cmBxCharAppearanceLvl.getSelectedIndex() > 1) {
                    screen.cmBxCharAppearance.setSelectedIndex(0);
                    loadCharAppearance();
                }
           }
        });
        
        DefaultComboBoxModel<String> charAppearance = new DefaultComboBoxModel();
        for (DefaultCharacterAppearance.codes appearance : DefaultCharacterAppearance.codes.values()) {
            charAppearance.addElement(appearance.name());
        }
        screen.cmBxCharAppearance.setModel(charAppearance);
        screen.cmBxCharAppearance.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    loadCharAppearance();
                }
            }
        });
    }

    private void reloadCmBxClasses() {
        cmBxModelCharClasses.removeAllElements();
        for (String key : CharacterPrototypeFactory.getKeys())
            cmBxModelCharClasses.addElement(key);
        screen.cmBxCharClassSelect.setModel(new CustomCmBx.Model(cmBxModelCharClasses));
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
        charSprites = character.getAppearances();
        screen.cmBxCharAppearanceLvl.setModel(new DefaultComboBoxModel());
        try {
            boolean loadImg = false;
            for (int key : character.getAppearances().keySet()) {
                screen.cmBxCharAppearanceLvl.addItem(String.valueOf(key));
                if (!loadImg) {
                    screen.cmBxCharAppearanceLvl.setSelectedIndex(0);
                    loadCharAppearance();
                    loadImg = true;
                }
            }
        }
        catch(Exception ex) {
            screen.lblCharSpritePreview.setText("No sprites found.");
        }
        
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
                if (screen.cmBxCharClassSelect.getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(screen, "No class selected.", "Load Character Class", JOptionPane.ERROR_MESSAGE);  
                    break;
                }
                selectedOption =
                        JOptionPane.showOptionDialog(screen, "The current information will be lost if you haven't saved. Proceed?",
                                                     "Load Character Class", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
                                                     null, null, null);
                if (selectedOption == JOptionPane.YES_OPTION)
                    loadCharClassInfo();
                break;
                
            case "Import JSON Character Data":
                path = loadJSONFile();
                if (path != null) {
                    try {
                        DefaultPrototypeController.loadCharacterPrototypes(path);
                        screen.clear();
                        reloadCmBxClasses();
                    }
                    catch(Exception ex) {
                        JOptionPane.showMessageDialog(screen, "Error: JSON file doesn't contain Character info",
                                                     "Import JSON Character Data", JOptionPane.ERROR_MESSAGE);
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
                new AppearanceDialogController(this);
                break;
                
            case "Delete Character Appearance":
                deleteCharAppearance();
                break;
                
            case "Export JSON Character Data":
                String directory = openDirectoryChooser();
                if(directory == null)
                    return;
                {
                    try {
                        DefaultPrototypeController.exportCharacterPrototypes(directory);
                    } catch (IOException ex) {
                        Logger.getLogger(CharactersController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                JOptionPane.showMessageDialog(screen, "JSON Exported succesfuly",
                                              "Export JSON Character Data", JOptionPane.INFORMATION_MESSAGE);
                break;
                
            case "Save Character Class":
                if (screen.txtCharClassName.getText().isEmpty())
                    JOptionPane.showMessageDialog(screen, "Class name must be filled.",
                                                 "Save Character Class", JOptionPane.ERROR_MESSAGE);
                else
                    SaveCharClass();
                break;
                
            case "Create Character Object":
                createCharObject();
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
        try {
            saveSprites();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(screen, "Error saving images.", "Save images", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ACharacter newChar = captureCharClassInput();
        try {
            CharacterPrototypeFactory.getPrototype(newChar.getName());
            int selectedOption = JOptionPane.showOptionDialog(screen, "Char class already exists. Overwrite?",
                                                              "Save CharClass", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
                                                              null, null, null);
            if (selectedOption == JOptionPane.NO_OPTION)
                return;
        }
        catch(NullPointerException ex) {
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
        int key = Integer.valueOf((String) screen.cmBxCharAppearanceLvl.getSelectedItem());
        String appearanceType = (String) screen.cmBxCharAppearance.getSelectedItem();
        String imageURL = charSprites.get(key).getLook(DefaultCharacterAppearance.codes.valueOf(appearanceType));

        screen.lblCharSpritePreview.setIcon(imgHandler.createImageicon(imageURL,
                                                                       screen.lblCharSpritePreview.getWidth(),
                                                                       screen.lblCharSpritePreview.getHeight()));
}
    
    private void deleteCharAppearance() {      
        if (screen.cmBxCharAppearanceLvl.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(screen, "No appearance selected.", "Delete Character Appearance", JOptionPane.ERROR_MESSAGE);
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
    
    private void saveSprites() throws IOException{
        for(AAppearance characterAppearance : charSprites.values()){
            List<String> newLooks = new ArrayList<>();
            for(String look : characterAppearance.getLooks()){
                newLooks.add(DefaultFilesController.saveImage(Paths.get(look)));
            }
            characterAppearance.setLooks(newLooks);
        } 
    }
    
    private String openDirectoryChooser(){
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Directory chooser");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        
        if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            return chooser.getSelectedFile().toString();
        }else{
            return null;
        }
    }
    
    private void createCharObject() {
        if (screen.txtCharClassName.getText().isEmpty()){
            JOptionPane.showMessageDialog(screen, "Character class name must be filled.", "Create Character Object", JOptionPane.ERROR_MESSAGE);  
            return;
        }
                    
        int quantity = (Integer) screen.spnObjQuantity.getValue();
        String prototypeName = screen.txtCharClassName.getText();
        try {
            List<IPrototype> charList = CharacterPrototypeFactory.getPrototypes(quantity, prototypeName);
            System.out.println("Created "+quantity+" "+prototypeName+" Objects:");
            for (IPrototype character : charList) {
                System.out.println("> "+character);
            }
            JOptionPane.showMessageDialog(screen, "Created "+quantity+" "+prototypeName+" objects succesfully",
                                         "Create Character Object", JOptionPane.INFORMATION_MESSAGE);  
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(screen, "Character class must be saved.", "Create Character Object", JOptionPane.ERROR_MESSAGE);

        }
    }
}
