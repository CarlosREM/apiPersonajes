package view;


/**
 *
 * @author Carlos Esquivel
 */
public class EditorScreen extends javax.swing.JFrame {
    
    javax.swing.JPanel contentPane = new javax.swing.JPanel();
    
    CharactersTabPanel charactersTab;
    WeaponsTabPanel weaponsTab;
    
    public CharactersTabPanel getCharactersTab() { return charactersTab; }
    public WeaponsTabPanel getWeaponsTab() { return weaponsTab; }
    
    public EditorScreen() {
        initComponents();
    }
    
    private void initComponents() {
        setTitle("Editor Screen test");
	//setResizable(false);
	setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 887, 661);
	contentPane = new javax.swing.JPanel();
	contentPane.setBorder(null);
	contentPane.setLayout(null);

        setContentPane(contentPane);
        
        javax.swing.JTabbedPane tabbedPane = new javax.swing.JTabbedPane();
        tabbedPane.setBounds(0, 0, 870, 614);
        charactersTab = new CharactersTabPanel();
        tabbedPane.add(charactersTab, "Characters");
        weaponsTab = new WeaponsTabPanel();
        tabbedPane.add(weaponsTab, "Weapons");
        contentPane.add(tabbedPane);
    }
    
}
