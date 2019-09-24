package view;

import ADT.DefaultWeapon;
import ADT.DefaultWeaponAppearance;
import ADT.WeaponPrototypeFactory;
import Controllers.DefaultPrototypeController;
import abstraction.AAppearance;
import abstraction.AWeapon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import utils.FileFilter;
import utils.ImageHandler;

/**
 *
 * @author Carlos Esquivel
 */
public class WeaponsController implements ActionListener {
    
    WeaponsTab screen;
    ImageHandler imgHandler;
    
    private DefaultComboBoxModel<String> cmBxModelWeaponClasses;
    private TreeMap<Integer, AAppearance> weaponSprites = new TreeMap<>();
    
    
    public DefaultComboBoxModel<String> getWeaponClassesModel() { return cmBxModelWeaponClasses; }
    
    public WeaponsController(WeaponsTab screen) {
        this.screen = screen;
        imgHandler = new ImageHandler();
        
        setupActionListeners();
        loadItems();
    }
    
    private void setupActionListeners() {
        screen.btnLoadWeaponClass.addActionListener(this);
        screen.btnWeaponImportJson.addActionListener(this);
        screen.btnAddWeaponAppearance.addActionListener(this);
        screen.btnDelWeaponAppearance.addActionListener(this);
        screen.btnWeaponExportJson.addActionListener(this);
        screen.btnSaveWeapon.addActionListener(this);
    }
    
    private void loadItems() {
        cmBxModelWeaponClasses = new DefaultComboBoxModel(WeaponPrototypeFactory.getKeys().toArray());
        screen.cmBxWeaponClassSelect.setModel(cmBxModelWeaponClasses);
        
        DefaultComboBoxModel<String> weaponAppearance = new DefaultComboBoxModel();
        for (DefaultWeaponAppearance.codes appearance : DefaultWeaponAppearance.codes.values()) {
            weaponAppearance.addElement(appearance.name());
        }
        screen.cmBxWeaponAppearance.setModel(weaponAppearance);
        screen.cmBxWeaponAppearanceLvl.setModel(new DefaultComboBoxModel());
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
                    screen.lblWeaponSpritePreview.setText("");
                    screen.lblWeaponSpritePreview.setIcon(imgHandler.createImageicon(strImage,
                                                        screen.lblWeaponSpritePreview.getWidth(),
                                                        screen.lblWeaponSpritePreview.getHeight())
                    );
                    loadImg = true;
                }
            }
        }
        catch(Exception ex) {
            screen.lblWeaponSpritePreview.setText("No sprites found.");
        }
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
        int selectedOption;
        String path;
        switch(e.getActionCommand()) {
            case "Load Weapon Class Info":
                if (screen.cmBxWeaponClassSelect.getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(screen, "No class selected.", "Load Weapon Class", JOptionPane.ERROR_MESSAGE);  
                    break;
                }
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
                new AppearanceDialogController(this);
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
    
    public boolean checkWeaponAppearance(int level) {
        return weaponSprites.containsKey(level);
    }
    
    public void addWeaponAppearance(int level, AAppearance newAppearance) {
        if (!weaponSprites.containsKey(level))
            screen.cmBxWeaponAppearanceLvl.addItem(String.valueOf(level));
        weaponSprites.put(level, newAppearance);
    }
    
    private void loadWeaponAppearance() {
        
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
            weaponSprites.remove(selectedOption);
                    
            screen.cmBxWeaponAppearanceLvl.setSelectedIndex(-1);
            screen.lblWeaponSpritePreview.setIcon(null);
        }
    }
    
}
