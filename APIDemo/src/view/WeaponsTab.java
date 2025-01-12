package view;

import java.awt.Color;

/**
 *
 * @author Carlos Esquivel
 */
public class WeaponsTab extends javax.swing.JPanel {

    /**
     * Creates new form WeaponsTabPanel
     */
    public WeaponsTab() {
        initComponents();
        this.setBackground(Color.DARK_GRAY);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        chkBxWeaponHits = new javax.swing.JCheckBox();
        spnWeaponHits = new javax.swing.JSpinner();
        spnWeaponStartLvl = new javax.swing.JSpinner();
        javax.swing.JPanel pnlWeaponSpritePreview = new javax.swing.JPanel();
        lblWeaponSpritePreview = new javax.swing.JLabel();
        chkBxWeaponStartLvl = new javax.swing.JCheckBox();
        chkBxWeaponUnlockLvl = new javax.swing.JCheckBox();
        spnWeaponUnlockLvl = new javax.swing.JSpinner();
        javax.swing.JLabel lblWeaponAppearance = new javax.swing.JLabel();
        spnWeaponAOE = new javax.swing.JSpinner();
        cmBxWeaponAppearance = new javax.swing.JComboBox<>();
        chkBxWeaponAOE = new javax.swing.JCheckBox();
        javax.swing.JSeparator jSeparator3 = new javax.swing.JSeparator();
        chkBxWeaponRange = new javax.swing.JCheckBox();
        javax.swing.JLabel lblWeaponAppareanceLvl = new javax.swing.JLabel();
        spnWeaponRange = new javax.swing.JSpinner();
        cmBxWeaponAppearanceLvl = new javax.swing.JComboBox<>();
        btnSaveWeapon = new javax.swing.JButton();
        btnAddWeaponAppearance = new javax.swing.JButton();
        javax.swing.JLabel lblWeaponClassSelect = new javax.swing.JLabel();
        btnDelWeaponAppearance = new javax.swing.JButton();
        btnWeaponImportJson = new javax.swing.JButton();
        javax.swing.JLabel lblWeaponClass = new javax.swing.JLabel();
        btnWeaponExportJson = new javax.swing.JButton();
        cmBxWeaponClassSelect = new javax.swing.JComboBox<>();
        btnLoadWeaponClass = new javax.swing.JButton();
        javax.swing.JSeparator jSeparator4 = new javax.swing.JSeparator();
        javax.swing.JLabel lblWeaponAttributes = new javax.swing.JLabel();
        javax.swing.JLabel lblWeaponClassName = new javax.swing.JLabel();
        txtWeaponClassName = new javax.swing.JTextField();
        chkBxWeaponDmg = new javax.swing.JCheckBox();
        spnWeaponDmg = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setBackground(new java.awt.Color(51, 51, 51));
        setForeground(new java.awt.Color(204, 204, 204));

        chkBxWeaponHits.setBackground(new java.awt.Color(51, 51, 51));
        chkBxWeaponHits.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        chkBxWeaponHits.setForeground(new java.awt.Color(204, 204, 204));
        chkBxWeaponHits.setSelected(true);
        chkBxWeaponHits.setText("Hits per Time unit:");
        chkBxWeaponHits.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkBxWeaponHitsItemStateChanged(evt);
            }
        });

        spnWeaponHits.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        spnWeaponStartLvl.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        pnlWeaponSpritePreview.setBackground(new java.awt.Color(51, 51, 51));
        pnlWeaponSpritePreview.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sprite Preview", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18), new java.awt.Color(204, 204, 204))); // NOI18N
        pnlWeaponSpritePreview.setMaximumSize(new java.awt.Dimension(250, 250));
        pnlWeaponSpritePreview.setPreferredSize(new java.awt.Dimension(250, 250));
        pnlWeaponSpritePreview.setLayout(new java.awt.BorderLayout());
        pnlWeaponSpritePreview.add(lblWeaponSpritePreview, java.awt.BorderLayout.CENTER);

        chkBxWeaponStartLvl.setBackground(new java.awt.Color(51, 51, 51));
        chkBxWeaponStartLvl.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        chkBxWeaponStartLvl.setForeground(new java.awt.Color(204, 204, 204));
        chkBxWeaponStartLvl.setSelected(true);
        chkBxWeaponStartLvl.setText("Starting Level:");
        chkBxWeaponStartLvl.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkBxWeaponStartLvlItemStateChanged(evt);
            }
        });

        chkBxWeaponUnlockLvl.setBackground(new java.awt.Color(51, 51, 51));
        chkBxWeaponUnlockLvl.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        chkBxWeaponUnlockLvl.setForeground(new java.awt.Color(204, 204, 204));
        chkBxWeaponUnlockLvl.setSelected(true);
        chkBxWeaponUnlockLvl.setText("Unlocking Level:");
        chkBxWeaponUnlockLvl.setToolTipText("");
        chkBxWeaponUnlockLvl.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkBxWeaponUnlockLvlItemStateChanged(evt);
            }
        });

        spnWeaponUnlockLvl.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        lblWeaponAppearance.setBackground(new java.awt.Color(51, 51, 51));
        lblWeaponAppearance.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblWeaponAppearance.setForeground(new java.awt.Color(204, 204, 204));
        lblWeaponAppearance.setText("Appearance:");

        spnWeaponAOE.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        chkBxWeaponAOE.setBackground(new java.awt.Color(51, 51, 51));
        chkBxWeaponAOE.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        chkBxWeaponAOE.setForeground(new java.awt.Color(204, 204, 204));
        chkBxWeaponAOE.setSelected(true);
        chkBxWeaponAOE.setText("Area of Effect:");
        chkBxWeaponAOE.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkBxWeaponAOEItemStateChanged(evt);
            }
        });

        jSeparator3.setForeground(new java.awt.Color(187, 187, 187));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator3.setPreferredSize(new java.awt.Dimension(10, 50));

        chkBxWeaponRange.setBackground(new java.awt.Color(51, 51, 51));
        chkBxWeaponRange.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        chkBxWeaponRange.setForeground(new java.awt.Color(204, 204, 204));
        chkBxWeaponRange.setSelected(true);
        chkBxWeaponRange.setText("Attack Range:");
        chkBxWeaponRange.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkBxWeaponRangeItemStateChanged(evt);
            }
        });

        lblWeaponAppareanceLvl.setBackground(new java.awt.Color(51, 51, 51));
        lblWeaponAppareanceLvl.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblWeaponAppareanceLvl.setForeground(new java.awt.Color(204, 204, 204));
        lblWeaponAppareanceLvl.setText("Level:");

        spnWeaponRange.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        btnSaveWeapon.setBackground(new java.awt.Color(51, 51, 51));
        btnSaveWeapon.setForeground(new java.awt.Color(204, 204, 204));
        btnSaveWeapon.setText("Save Weapon Class");

        btnAddWeaponAppearance.setBackground(new java.awt.Color(51, 51, 51));
        btnAddWeaponAppearance.setForeground(new java.awt.Color(204, 204, 204));
        btnAddWeaponAppearance.setText("Add New Weapon Appearance");

        lblWeaponClassSelect.setBackground(new java.awt.Color(51, 51, 51));
        lblWeaponClassSelect.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblWeaponClassSelect.setForeground(new java.awt.Color(204, 204, 204));
        lblWeaponClassSelect.setText("Select a class:");

        btnDelWeaponAppearance.setBackground(new java.awt.Color(51, 51, 51));
        btnDelWeaponAppearance.setForeground(new java.awt.Color(204, 204, 204));
        btnDelWeaponAppearance.setText("Delete Weapon Appearance");

        btnWeaponImportJson.setBackground(new java.awt.Color(51, 51, 51));
        btnWeaponImportJson.setForeground(new java.awt.Color(204, 204, 204));
        btnWeaponImportJson.setText("Import JSON Weapon Data");

        lblWeaponClass.setBackground(new java.awt.Color(51, 51, 51));
        lblWeaponClass.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblWeaponClass.setForeground(new java.awt.Color(204, 204, 204));
        lblWeaponClass.setText("Weapon class");

        btnWeaponExportJson.setBackground(new java.awt.Color(51, 51, 51));
        btnWeaponExportJson.setForeground(new java.awt.Color(204, 204, 204));
        btnWeaponExportJson.setText("Export JSON Weapon Data");

        btnLoadWeaponClass.setBackground(new java.awt.Color(51, 51, 51));
        btnLoadWeaponClass.setForeground(new java.awt.Color(204, 204, 204));
        btnLoadWeaponClass.setText("Load Weapon Class Info");
        btnLoadWeaponClass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jSeparator4.setForeground(new java.awt.Color(187, 187, 187));

        lblWeaponAttributes.setBackground(new java.awt.Color(51, 51, 51));
        lblWeaponAttributes.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblWeaponAttributes.setForeground(new java.awt.Color(204, 204, 204));
        lblWeaponAttributes.setText("Attributes");

        lblWeaponClassName.setBackground(new java.awt.Color(51, 51, 51));
        lblWeaponClassName.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblWeaponClassName.setForeground(new java.awt.Color(204, 204, 204));
        lblWeaponClassName.setText("Weapon name:");

        txtWeaponClassName.setBackground(new java.awt.Color(51, 51, 51));
        txtWeaponClassName.setForeground(new java.awt.Color(204, 204, 204));
        txtWeaponClassName.setToolTipText("Class Name");

        chkBxWeaponDmg.setBackground(new java.awt.Color(51, 51, 51));
        chkBxWeaponDmg.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        chkBxWeaponDmg.setForeground(new java.awt.Color(204, 204, 204));
        chkBxWeaponDmg.setSelected(true);
        chkBxWeaponDmg.setText("Weapon Damage:");
        chkBxWeaponDmg.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkBxWeaponDmgItemStateChanged(evt);
            }
        });

        spnWeaponDmg.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setForeground(new java.awt.Color(205, 205, 205));
        jButton1.setText("Clear Screen");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnWeaponExportJson, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSaveWeapon, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblWeaponClassName)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtWeaponClassName))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(chkBxWeaponHits, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(chkBxWeaponDmg, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(spnWeaponDmg, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                                .addComponent(spnWeaponHits)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(chkBxWeaponStartLvl, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(spnWeaponStartLvl, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chkBxWeaponAOE, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(chkBxWeaponRange, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(chkBxWeaponUnlockLvl, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spnWeaponRange, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spnWeaponAOE, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spnWeaponUnlockLvl, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblWeaponClass)
                            .addComponent(lblWeaponAttributes)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblWeaponClassSelect)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnLoadWeaponClass, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                                    .addComponent(cmBxWeaponClassSelect, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(btnWeaponImportJson, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlWeaponSpritePreview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAddWeaponAppearance, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDelWeaponAppearance, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblWeaponAppearance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblWeaponAppareanceLvl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cmBxWeaponAppearanceLvl, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmBxWeaponAppearance, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblWeaponClass)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblWeaponClassSelect)
                        .addGap(8, 8, 8)
                        .addComponent(cmBxWeaponClassSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLoadWeaponClass)
                            .addComponent(btnWeaponImportJson))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblWeaponAttributes)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblWeaponClassName)
                            .addComponent(txtWeaponClassName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chkBxWeaponDmg)
                            .addComponent(spnWeaponRange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkBxWeaponRange)
                            .addComponent(spnWeaponDmg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spnWeaponHits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkBxWeaponHits)
                            .addComponent(spnWeaponAOE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkBxWeaponAOE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spnWeaponStartLvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkBxWeaponStartLvl)
                            .addComponent(spnWeaponUnlockLvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkBxWeaponUnlockLvl)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlWeaponSpritePreview, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmBxWeaponAppearanceLvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblWeaponAppareanceLvl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmBxWeaponAppearance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblWeaponAppearance))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddWeaponAppearance)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelWeaponAppearance))
                    .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveWeapon)
                    .addComponent(btnWeaponExportJson)
                    .addComponent(jButton1))
                .addContainerGap(12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void chkBxWeaponHitsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkBxWeaponHitsItemStateChanged
        spnWeaponHits.setEnabled(chkBxWeaponHits.isSelected());
    }//GEN-LAST:event_chkBxWeaponHitsItemStateChanged

    private void chkBxWeaponStartLvlItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkBxWeaponStartLvlItemStateChanged
        spnWeaponStartLvl.setEnabled(chkBxWeaponStartLvl.isSelected());
    }//GEN-LAST:event_chkBxWeaponStartLvlItemStateChanged

    private void chkBxWeaponUnlockLvlItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkBxWeaponUnlockLvlItemStateChanged
        spnWeaponUnlockLvl.setEnabled(chkBxWeaponUnlockLvl.isSelected());
    }//GEN-LAST:event_chkBxWeaponUnlockLvlItemStateChanged

    private void chkBxWeaponAOEItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkBxWeaponAOEItemStateChanged
        spnWeaponAOE.setEnabled(chkBxWeaponAOE.isSelected());
    }//GEN-LAST:event_chkBxWeaponAOEItemStateChanged

    private void chkBxWeaponRangeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkBxWeaponRangeItemStateChanged
        spnWeaponRange.setEnabled(chkBxWeaponRange.isSelected());
    }//GEN-LAST:event_chkBxWeaponRangeItemStateChanged

    private void chkBxWeaponDmgItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkBxWeaponDmgItemStateChanged
        spnWeaponDmg.setEnabled(chkBxWeaponDmg.isSelected());
    }//GEN-LAST:event_chkBxWeaponDmgItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        clear();
    }//GEN-LAST:event_jButton1ActionPerformed

    public int getWeaponDmg() {
        int out = 0;
        if (chkBxWeaponDmg.isSelected())
            out = (int) spnWeaponDmg.getValue();
        return out;
    }
    public void setWeaponDmg(int value) {
        spnWeaponDmg.setValue(value);
        chkBxWeaponDmg.setSelected(value != 0);
    }
    
    public int getWeaponRange() {
        int out = 0;
        if (chkBxWeaponRange.isSelected())
            out = (int) spnWeaponRange.getValue();
        return out;
    }
    public void setWeaponRange(int value) {
        spnWeaponRange.setValue(value);
        chkBxWeaponRange.setSelected(value != 0);
    }
    
    public int getWeaponHits() {
        int out = 0;
        if (chkBxWeaponHits.isSelected())
            out = (int) spnWeaponHits.getValue();
        return out;
    }
    public void setWeaponHits(int value) {
        spnWeaponHits.setValue(value);
        chkBxWeaponHits.setSelected(value != 0);
    }
    
    public int getWeaponAOE() {
        int out = 0;
        if (chkBxWeaponAOE.isSelected())
            out = (int) spnWeaponAOE.getValue();
        return out;
    }
    public void setWeaponAOE(int value) {
        spnWeaponAOE.setValue(value);
        chkBxWeaponAOE.setSelected(value != 0);
    }
    
    public int getWeaponStartLvl() {
        int out = 0;
        if (chkBxWeaponStartLvl.isSelected())
            out = (int) spnWeaponStartLvl.getValue();
        return out;
    }
    public void setWeaponStartLvl(int value) {
        spnWeaponStartLvl.setValue(value);
        chkBxWeaponStartLvl.setSelected(value != 0);
    }
    
    public int getWeaponUnlockLvl() {
        int out = 0;
        if (chkBxWeaponUnlockLvl.isSelected())
            out = (int) spnWeaponUnlockLvl.getValue();
        return out;
    }
    public void setWeaponUnlockLvl(int value) {
        spnWeaponUnlockLvl.setValue(value);
        chkBxWeaponUnlockLvl.setSelected(value != 0);
    }
    
        public void clear() {
        txtWeaponClassName.setText("");
        setWeaponDmg(1);
        setWeaponRange(1);
        setWeaponHits(1);
        setWeaponAOE(1);
        setWeaponStartLvl(1);
        setWeaponUnlockLvl(1);
        lblWeaponSpritePreview.setIcon(null);
        cmBxWeaponAppearanceLvl.removeAllItems();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAddWeaponAppearance;
    public javax.swing.JButton btnDelWeaponAppearance;
    public javax.swing.JButton btnLoadWeaponClass;
    public javax.swing.JButton btnSaveWeapon;
    public javax.swing.JButton btnWeaponExportJson;
    public javax.swing.JButton btnWeaponImportJson;
    public javax.swing.JCheckBox chkBxWeaponAOE;
    public javax.swing.JCheckBox chkBxWeaponDmg;
    public javax.swing.JCheckBox chkBxWeaponHits;
    public javax.swing.JCheckBox chkBxWeaponRange;
    public javax.swing.JCheckBox chkBxWeaponStartLvl;
    public javax.swing.JCheckBox chkBxWeaponUnlockLvl;
    public javax.swing.JComboBox<String> cmBxWeaponAppearance;
    public javax.swing.JComboBox<String> cmBxWeaponAppearanceLvl;
    public javax.swing.JComboBox<String> cmBxWeaponClassSelect;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel lblWeaponSpritePreview;
    public javax.swing.JSpinner spnWeaponAOE;
    public javax.swing.JSpinner spnWeaponDmg;
    public javax.swing.JSpinner spnWeaponHits;
    public javax.swing.JSpinner spnWeaponRange;
    public javax.swing.JSpinner spnWeaponStartLvl;
    public javax.swing.JSpinner spnWeaponUnlockLvl;
    public javax.swing.JTextField txtWeaponClassName;
    // End of variables declaration//GEN-END:variables
}
