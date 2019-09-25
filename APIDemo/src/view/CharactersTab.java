package view;

import java.awt.Color;

/**
 *
 * @author Carlos Esquivel
 */
public class CharactersTab extends javax.swing.JPanel {

    /**
     * Creates new form CharactersTabPanel
     */
    public CharactersTab() {
        initComponents();
        this.setBackground(Color.DARK_GRAY);
        spnCharHealth.setBackground(Color.BLACK);
        spnCharHealth.setForeground(Color.BLACK);
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCharSaveClass = new javax.swing.JButton();
        javax.swing.JLabel lblWeaponClassSelect1 = new javax.swing.JLabel();
        chkBxCharHealth = new javax.swing.JCheckBox();
        btnCharImportJson = new javax.swing.JButton();
        spnCharHealth = new javax.swing.JSpinner();
        chkBxCharCost = new javax.swing.JCheckBox();
        spnCharCost = new javax.swing.JSpinner();
        chkBxCharHits = new javax.swing.JCheckBox();
        spnCharHits = new javax.swing.JSpinner();
        chkBxCharTiles = new javax.swing.JCheckBox();
        spnCharTiles = new javax.swing.JSpinner();
        chkBxCharStartLvl = new javax.swing.JCheckBox();
        javax.swing.JLabel lblCharAppearance = new javax.swing.JLabel();
        spnCharStartLvl = new javax.swing.JSpinner();
        javax.swing.JLabel lblCharAppareanceLvl = new javax.swing.JLabel();
        chkBxCharUnlockLvl = new javax.swing.JCheckBox();
        javax.swing.JLabel lblCharacterClass = new javax.swing.JLabel();
        spnCharUnlockLvl = new javax.swing.JSpinner();
        cmBxCharClassSelect = new javax.swing.JComboBox<>();
        btnDelCharAppearance = new javax.swing.JButton();
        btnLoadCharClass = new javax.swing.JButton();
        btnAddWeapon = new javax.swing.JButton();
        javax.swing.JSeparator jSeparator1 = new javax.swing.JSeparator();
        javax.swing.JScrollPane scrollWeapons = new javax.swing.JScrollPane();
        listWeapons = new javax.swing.JList<>();
        javax.swing.JSeparator jSeparator2 = new javax.swing.JSeparator();
        javax.swing.JLabel lblCharAttributes = new javax.swing.JLabel();
        javax.swing.JScrollPane scrollClassWeapons = new javax.swing.JScrollPane();
        listClassWeapons = new javax.swing.JList<>();
        javax.swing.JLabel lblCharClassName = new javax.swing.JLabel();
        txtCharClassName = new javax.swing.JTextField();
        pnlCharSpritePreview = new javax.swing.JPanel();
        lblCharSpritePreview = new javax.swing.JLabel();
        cmBxCharAppearance = new javax.swing.JComboBox<>();
        cmBxCharAppearanceLvl = new javax.swing.JComboBox<>();
        btnDelWeapon = new javax.swing.JButton();
        btnAddCharAppearance = new javax.swing.JButton();
        javax.swing.JLabel lblClassWeapons = new javax.swing.JLabel();
        btnCharCreateObject = new javax.swing.JButton();
        btnCharExportJson = new javax.swing.JButton();
        javax.swing.JLabel lblObjQuantity = new javax.swing.JLabel();
        spnObjQuantity = new javax.swing.JSpinner();

        btnCharSaveClass.setBackground(new java.awt.Color(51, 51, 51));
        btnCharSaveClass.setForeground(new java.awt.Color(204, 204, 204));
        btnCharSaveClass.setText("Save Character Class");

        lblWeaponClassSelect1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblWeaponClassSelect1.setForeground(new java.awt.Color(204, 204, 204));
        lblWeaponClassSelect1.setText("Select a class:");

        chkBxCharHealth.setBackground(new java.awt.Color(51, 51, 51));
        chkBxCharHealth.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        chkBxCharHealth.setForeground(new java.awt.Color(204, 204, 204));
        chkBxCharHealth.setSelected(true);
        chkBxCharHealth.setText("Max Health Points (HP):");
        chkBxCharHealth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkBxCharHealthItemStateChanged(evt);
            }
        });

        btnCharImportJson.setBackground(new java.awt.Color(51, 51, 51));
        btnCharImportJson.setForeground(new java.awt.Color(204, 204, 204));
        btnCharImportJson.setText("Import JSON Character Data");

        spnCharHealth.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        chkBxCharCost.setBackground(new java.awt.Color(51, 51, 51));
        chkBxCharCost.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        chkBxCharCost.setForeground(new java.awt.Color(204, 204, 204));
        chkBxCharCost.setSelected(true);
        chkBxCharCost.setText("Production Cost:");
        chkBxCharCost.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkBxCharCostItemStateChanged(evt);
            }
        });

        spnCharCost.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        chkBxCharHits.setBackground(new java.awt.Color(51, 51, 51));
        chkBxCharHits.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        chkBxCharHits.setForeground(new java.awt.Color(204, 204, 204));
        chkBxCharHits.setSelected(true);
        chkBxCharHits.setText("Hits per Time unit:");
        chkBxCharHits.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkBxCharHitsItemStateChanged(evt);
            }
        });

        spnCharHits.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        chkBxCharTiles.setBackground(new java.awt.Color(51, 51, 51));
        chkBxCharTiles.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        chkBxCharTiles.setForeground(new java.awt.Color(204, 204, 204));
        chkBxCharTiles.setSelected(true);
        chkBxCharTiles.setText("Tile Hitbox:");
        chkBxCharTiles.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkBxCharTilesItemStateChanged(evt);
            }
        });

        spnCharTiles.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        chkBxCharStartLvl.setBackground(new java.awt.Color(51, 51, 51));
        chkBxCharStartLvl.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        chkBxCharStartLvl.setForeground(new java.awt.Color(204, 204, 204));
        chkBxCharStartLvl.setSelected(true);
        chkBxCharStartLvl.setText("Starting Level:");
        chkBxCharStartLvl.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkBxCharStartLvlItemStateChanged(evt);
            }
        });

        lblCharAppearance.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblCharAppearance.setForeground(new java.awt.Color(204, 204, 204));
        lblCharAppearance.setText("Appearance:");

        spnCharStartLvl.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        lblCharAppareanceLvl.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblCharAppareanceLvl.setForeground(new java.awt.Color(204, 204, 204));
        lblCharAppareanceLvl.setText("Level:");

        chkBxCharUnlockLvl.setBackground(new java.awt.Color(51, 51, 51));
        chkBxCharUnlockLvl.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        chkBxCharUnlockLvl.setForeground(new java.awt.Color(204, 204, 204));
        chkBxCharUnlockLvl.setSelected(true);
        chkBxCharUnlockLvl.setText("Unlocking Level:");
        chkBxCharUnlockLvl.setToolTipText("");
        chkBxCharUnlockLvl.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkBxCharUnlockLvlItemStateChanged(evt);
            }
        });

        lblCharacterClass.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblCharacterClass.setForeground(new java.awt.Color(204, 204, 204));
        lblCharacterClass.setText("Character class");

        spnCharUnlockLvl.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        cmBxCharClassSelect.setBackground(new java.awt.Color(255, 255, 255));
        cmBxCharClassSelect.setForeground(new java.awt.Color(51, 51, 51));

        btnDelCharAppearance.setBackground(new java.awt.Color(51, 51, 51));
        btnDelCharAppearance.setForeground(new java.awt.Color(204, 204, 204));
        btnDelCharAppearance.setText("Delete Character Appearance");

        btnLoadCharClass.setBackground(new java.awt.Color(51, 51, 51));
        btnLoadCharClass.setForeground(new java.awt.Color(204, 204, 204));
        btnLoadCharClass.setText("Load Character Class Info");
        btnLoadCharClass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnAddWeapon.setBackground(new java.awt.Color(51, 51, 51));
        btnAddWeapon.setForeground(new java.awt.Color(204, 204, 204));
        btnAddWeapon.setText(">");
        btnAddWeapon.setEnabled(false);

        jSeparator1.setForeground(new java.awt.Color(187, 187, 187));

        listWeapons.setBackground(new java.awt.Color(51, 51, 51));
        listWeapons.setForeground(new java.awt.Color(204, 204, 204));
        listWeapons.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listWeapons.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listWeapons.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listWeaponsValueChanged(evt);
            }
        });
        scrollWeapons.setViewportView(listWeapons);

        jSeparator2.setForeground(new java.awt.Color(187, 187, 187));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setPreferredSize(new java.awt.Dimension(10, 50));

        lblCharAttributes.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblCharAttributes.setForeground(new java.awt.Color(204, 204, 204));
        lblCharAttributes.setText("Attributes");

        listClassWeapons.setBackground(new java.awt.Color(51, 51, 51));
        listClassWeapons.setForeground(new java.awt.Color(204, 204, 204));
        listClassWeapons.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listClassWeapons.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listClassWeapons.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listClassWeaponsValueChanged(evt);
            }
        });
        scrollClassWeapons.setViewportView(listClassWeapons);

        lblCharClassName.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblCharClassName.setForeground(new java.awt.Color(204, 204, 204));
        lblCharClassName.setText("Class name:");

        txtCharClassName.setBackground(new java.awt.Color(51, 51, 51));
        txtCharClassName.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCharClassName.setForeground(new java.awt.Color(204, 204, 204));
        txtCharClassName.setToolTipText("Class Name");

        pnlCharSpritePreview.setBackground(new java.awt.Color(51, 51, 51));
        pnlCharSpritePreview.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sprite Preview", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18), new java.awt.Color(204, 204, 204))); // NOI18N
        pnlCharSpritePreview.setForeground(new java.awt.Color(204, 204, 204));
        pnlCharSpritePreview.setMaximumSize(new java.awt.Dimension(250, 250));
        pnlCharSpritePreview.setPreferredSize(new java.awt.Dimension(250, 250));
        pnlCharSpritePreview.setLayout(new java.awt.BorderLayout());

        lblCharSpritePreview.setBackground(new java.awt.Color(255, 255, 255));
        lblCharSpritePreview.setForeground(new java.awt.Color(204, 204, 204));
        pnlCharSpritePreview.add(lblCharSpritePreview, java.awt.BorderLayout.CENTER);

        cmBxCharAppearance.setBackground(new java.awt.Color(255, 255, 255));
        cmBxCharAppearance.setForeground(new java.awt.Color(51, 51, 51));

        cmBxCharAppearanceLvl.setBackground(new java.awt.Color(255, 255, 255));
        cmBxCharAppearanceLvl.setForeground(new java.awt.Color(51, 51, 51));

        btnDelWeapon.setBackground(new java.awt.Color(51, 51, 51));
        btnDelWeapon.setForeground(new java.awt.Color(204, 204, 204));
        btnDelWeapon.setText("X");
        btnDelWeapon.setEnabled(false);

        btnAddCharAppearance.setBackground(new java.awt.Color(51, 51, 51));
        btnAddCharAppearance.setForeground(new java.awt.Color(204, 204, 204));
        btnAddCharAppearance.setText("Add New Character Appearance");

        lblClassWeapons.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblClassWeapons.setForeground(new java.awt.Color(204, 204, 204));
        lblClassWeapons.setText("Weapons:");

        btnCharCreateObject.setBackground(new java.awt.Color(51, 51, 51));
        btnCharCreateObject.setForeground(new java.awt.Color(204, 204, 204));
        btnCharCreateObject.setText("Create Character Object");

        btnCharExportJson.setBackground(new java.awt.Color(51, 51, 51));
        btnCharExportJson.setForeground(new java.awt.Color(204, 204, 204));
        btnCharExportJson.setText("Export JSON Character Data");

        lblObjQuantity.setForeground(new java.awt.Color(204, 204, 204));
        lblObjQuantity.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblObjQuantity.setText("Quantity:");

        spnObjQuantity.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblWeaponClassSelect1)
                                            .addComponent(lblCharAttributes)
                                            .addComponent(lblCharacterClass)
                                            .addComponent(lblClassWeapons)
                                            .addComponent(cmBxCharClassSelect, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnLoadCharClass, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(btnCharImportJson, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(45, 45, 45)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(lblCharClassName)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtCharClassName))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(chkBxCharHits, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(chkBxCharHealth, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(spnCharHealth, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(spnCharHits))))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(chkBxCharTiles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(chkBxCharCost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(chkBxCharUnlockLvl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(scrollWeapons, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(btnAddWeapon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(btnDelWeapon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(scrollClassWeapons, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(chkBxCharStartLvl, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(spnCharStartLvl, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spnCharCost, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spnCharTiles, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spnCharUnlockLvl, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlCharSpritePreview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCharAppareanceLvl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblCharAppearance, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmBxCharAppearanceLvl, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmBxCharAppearance, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnAddCharAppearance, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDelCharAppearance, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(spnObjQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCharExportJson)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCharSaveClass)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblObjQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCharCreateObject))))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(pnlCharSpritePreview, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmBxCharAppearanceLvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCharAppareanceLvl))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmBxCharAppearance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCharAppearance))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAddCharAppearance)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelCharAppearance)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCharacterClass)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblWeaponClassSelect1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmBxCharClassSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLoadCharClass)
                            .addComponent(btnCharImportJson))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCharAttributes)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCharClassName)
                            .addComponent(txtCharClassName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chkBxCharHealth)
                            .addComponent(spnCharCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkBxCharCost)
                            .addComponent(spnCharHealth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spnCharHits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkBxCharHits)
                            .addComponent(spnCharTiles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkBxCharTiles))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spnCharStartLvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkBxCharStartLvl)
                            .addComponent(spnCharUnlockLvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkBxCharUnlockLvl))
                        .addGap(18, 18, 18)
                        .addComponent(lblClassWeapons)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAddWeapon)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelWeapon)
                                .addGap(61, 126, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(scrollClassWeapons, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(scrollWeapons)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblObjQuantity)
                                        .addComponent(spnObjQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCharSaveClass)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnCharCreateObject)
                                        .addComponent(btnCharExportJson)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void chkBxCharHealthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkBxCharHealthItemStateChanged
        spnCharHealth.setEnabled(chkBxCharHealth.isSelected());
    }//GEN-LAST:event_chkBxCharHealthItemStateChanged

    private void chkBxCharCostItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkBxCharCostItemStateChanged
        spnCharCost.setEnabled(chkBxCharCost.isSelected());
    }//GEN-LAST:event_chkBxCharCostItemStateChanged

    private void chkBxCharHitsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkBxCharHitsItemStateChanged
        spnCharHits.setEnabled(chkBxCharHits.isSelected());
    }//GEN-LAST:event_chkBxCharHitsItemStateChanged

    private void chkBxCharTilesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkBxCharTilesItemStateChanged
        spnCharTiles.setEnabled(chkBxCharTiles.isSelected());
    }//GEN-LAST:event_chkBxCharTilesItemStateChanged

    private void chkBxCharStartLvlItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkBxCharStartLvlItemStateChanged
        spnCharStartLvl.setEnabled(chkBxCharStartLvl.isSelected());
    }//GEN-LAST:event_chkBxCharStartLvlItemStateChanged

    private void chkBxCharUnlockLvlItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkBxCharUnlockLvlItemStateChanged
        spnCharUnlockLvl.setEnabled(chkBxCharUnlockLvl.isSelected());
    }//GEN-LAST:event_chkBxCharUnlockLvlItemStateChanged

    private void listWeaponsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listWeaponsValueChanged
        btnAddWeapon.setEnabled(listWeapons.getSelectedIndex() > -1);
    }//GEN-LAST:event_listWeaponsValueChanged

    private void listClassWeaponsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listClassWeaponsValueChanged
        btnDelWeapon.setEnabled(listClassWeapons.getSelectedIndex() > -1);
    }//GEN-LAST:event_listClassWeaponsValueChanged

    public int getCharHealth() {
        int out = 0;
        if (chkBxCharHealth.isSelected())
            out = (int) spnCharHealth.getValue();
        return out;
    }
    public void setCharHealth(int value) {
        spnCharHealth.setValue(value);
        if (value == 0)
            chkBxCharHealth.setSelected(false);
    }
    
    public int getCharCost() {
        int out = 0;
        if (chkBxCharCost.isSelected())
            out = (int) spnCharCost.getValue();
        return out;
    }
    public void setCharCost(int value) {
        spnCharCost.setValue(value);
        if (value == 0)
            chkBxCharCost.setSelected(false);
    }
    
    public int getCharHits() {
        int out = 0;
        if (chkBxCharHits.isSelected())
            out = (int) spnCharHits.getValue();
        return out;
    }
    public void setCharHits(int value) {
        spnCharHits.setValue(value);
        if (value == 0)
            chkBxCharHits.setSelected(false);
    }

    public int getCharTiles() {
        int out = 0;
        if (chkBxCharTiles.isSelected())
            out = (int) spnCharTiles.getValue();
        return out;
    }
    public void setCharTiles(int value) {
        spnCharTiles.setValue(value);
        if (value == 0)
            chkBxCharTiles.setSelected(false);
    }
    
    public int getCharStartLvl() {
        int out = 0;
        if (chkBxCharStartLvl.isSelected())
            out = (int) spnCharStartLvl.getValue();
        return out;
    }
    public void setCharStartLvl(int value) {
        spnCharStartLvl.setValue(value);
        if (value == 0)
            chkBxCharStartLvl.setSelected(false);
    }
    
    public int getCharUnlockLvl() {
        int out = 0;
        if (chkBxCharUnlockLvl.isSelected())
            out = (int) spnCharUnlockLvl.getValue();
        return out;
    }
    public void setCharUnlockLvl(int value) {
        spnCharUnlockLvl.setValue(value);
        if (value == 0)
            chkBxCharUnlockLvl.setSelected(false);
    }
    
    public void clear() {
        txtCharClassName.setText("");
        setCharHealth(1);
        setCharCost(1);
        setCharHits(1);
        setCharTiles(1);
        setCharStartLvl(1);
        setCharUnlockLvl(1);
        lblCharSpritePreview.setIcon(null);
        cmBxCharAppearanceLvl.removeAllItems();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton btnAddCharAppearance;
    protected javax.swing.JButton btnAddWeapon;
    protected javax.swing.JButton btnCharCreateObject;
    protected javax.swing.JButton btnCharExportJson;
    protected javax.swing.JButton btnCharImportJson;
    protected javax.swing.JButton btnCharSaveClass;
    protected javax.swing.JButton btnDelCharAppearance;
    protected javax.swing.JButton btnDelWeapon;
    protected javax.swing.JButton btnLoadCharClass;
    protected javax.swing.JCheckBox chkBxCharCost;
    protected javax.swing.JCheckBox chkBxCharHealth;
    protected javax.swing.JCheckBox chkBxCharHits;
    protected javax.swing.JCheckBox chkBxCharStartLvl;
    protected javax.swing.JCheckBox chkBxCharTiles;
    protected javax.swing.JCheckBox chkBxCharUnlockLvl;
    protected javax.swing.JComboBox<String> cmBxCharAppearance;
    protected javax.swing.JComboBox<String> cmBxCharAppearanceLvl;
    protected javax.swing.JComboBox<String> cmBxCharClassSelect;
    protected javax.swing.JLabel lblCharSpritePreview;
    protected javax.swing.JList<String> listClassWeapons;
    protected javax.swing.JList<String> listWeapons;
    protected javax.swing.JPanel pnlCharSpritePreview;
    protected javax.swing.JSpinner spnCharCost;
    protected javax.swing.JSpinner spnCharHealth;
    protected javax.swing.JSpinner spnCharHits;
    protected javax.swing.JSpinner spnCharStartLvl;
    protected javax.swing.JSpinner spnCharTiles;
    protected javax.swing.JSpinner spnCharUnlockLvl;
    protected javax.swing.JSpinner spnObjQuantity;
    protected javax.swing.JTextField txtCharClassName;
    // End of variables declaration//GEN-END:variables
}
