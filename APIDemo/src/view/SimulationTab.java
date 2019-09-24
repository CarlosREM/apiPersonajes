/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author carlo
 */
public class SimulationTab extends javax.swing.JPanel {

    /**
     * Creates new form Simulation
     */
    public SimulationTab() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPlayerAttack = new javax.swing.JButton();
        txtPlayerHP = new javax.swing.JTextField();
        javax.swing.JPanel pnlPlayerWeapon = new javax.swing.JPanel();
        lblPlayerWeapon = new javax.swing.JLabel();
        pnlComputerImage = new javax.swing.JPanel();
        lblComputerImage = new javax.swing.JLabel();
        javax.swing.JLabel lblPlayerChar = new javax.swing.JLabel();
        cmBxPlayerChar = new javax.swing.JComboBox<>();
        cmBxComChar = new javax.swing.JComboBox<>();
        javax.swing.JLabel lblComChar = new javax.swing.JLabel();
        pnlPlayerImage = new javax.swing.JPanel();
        lblPlayerImage = new javax.swing.JLabel();
        btnReady = new javax.swing.JButton();
        cmBxComWeapon = new javax.swing.JComboBox<>();
        btnStop = new javax.swing.JButton();
        javax.swing.JPanel pnlComWeapon = new javax.swing.JPanel();
        lblComWeapon = new javax.swing.JLabel();
        javax.swing.JScrollPane scrollCombatLog = new javax.swing.JScrollPane();
        txtCombatLog = new javax.swing.JTextArea();
        javax.swing.JLabel lblComHP = new javax.swing.JLabel();
        txtComHP = new javax.swing.JTextField();
        javax.swing.JLabel lblPlayerHP = new javax.swing.JLabel();
        cmBxPlayerWeapon = new javax.swing.JComboBox<>();

        btnPlayerAttack.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnPlayerAttack.setText("Attack");
        btnPlayerAttack.setEnabled(false);

        txtPlayerHP.setEditable(false);
        txtPlayerHP.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtPlayerHP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlayerHPActionPerformed(evt);
            }
        });

        pnlPlayerWeapon.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Weapon", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18))); // NOI18N
        pnlPlayerWeapon.setLayout(new java.awt.BorderLayout());
        pnlPlayerWeapon.add(lblPlayerWeapon, java.awt.BorderLayout.CENTER);

        pnlComputerImage.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Computer", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18))); // NOI18N
        pnlComputerImage.setMaximumSize(new java.awt.Dimension(250, 250));
        pnlComputerImage.setPreferredSize(new java.awt.Dimension(250, 250));
        pnlComputerImage.setLayout(new java.awt.BorderLayout());
        pnlComputerImage.add(lblComputerImage, java.awt.BorderLayout.CENTER);

        lblPlayerChar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblPlayerChar.setText("Player character:");

        lblComChar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblComChar.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblComChar.setText("Com. character:");

        pnlPlayerImage.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Player", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18))); // NOI18N
        pnlPlayerImage.setMaximumSize(new java.awt.Dimension(250, 250));
        pnlPlayerImage.setPreferredSize(new java.awt.Dimension(250, 250));
        pnlPlayerImage.setLayout(new java.awt.BorderLayout());
        pnlPlayerImage.add(lblPlayerImage, java.awt.BorderLayout.CENTER);

        btnReady.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnReady.setText("READY");
        btnReady.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadyActionPerformed(evt);
            }
        });

        cmBxComWeapon.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cmBxComWeapon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmBxComWeaponActionPerformed(evt);
            }
        });

        btnStop.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnStop.setText("STOP");
        btnStop.setEnabled(false);
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        pnlComWeapon.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Weapon", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18))); // NOI18N
        pnlComWeapon.setLayout(new java.awt.BorderLayout());
        pnlComWeapon.add(lblComWeapon, java.awt.BorderLayout.CENTER);

        txtCombatLog.setEditable(false);
        txtCombatLog.setColumns(20);
        txtCombatLog.setRows(5);
        scrollCombatLog.setViewportView(txtCombatLog);

        lblComHP.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblComHP.setText("HP");

        txtComHP.setEditable(false);
        txtComHP.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtComHP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtComHPActionPerformed(evt);
            }
        });

        lblPlayerHP.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblPlayerHP.setText("HP");

        cmBxPlayerWeapon.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cmBxPlayerWeapon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmBxPlayerWeaponActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlPlayerImage, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPlayerHP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPlayerHP, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnPlayerAttack, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblPlayerChar, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                    .addComponent(cmBxPlayerChar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmBxComChar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblComChar, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)))
                            .addComponent(btnReady, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnStop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblComHP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtComHP, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(126, 126, 126))
                            .addComponent(pnlComputerImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlPlayerWeapon, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(cmBxPlayerWeapon, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(scrollCombatLog)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmBxComWeapon, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlComWeapon, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pnlComputerImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblComHP)
                            .addComponent(txtComHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnlPlayerImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblComChar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmBxComChar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblPlayerChar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmBxPlayerChar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(btnReady, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPlayerHP)
                            .addComponent(txtPlayerHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPlayerAttack))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollCombatLog)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pnlComWeapon, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmBxComWeapon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlPlayerWeapon, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmBxPlayerWeapon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(119, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtPlayerHPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlayerHPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPlayerHPActionPerformed

    private void btnReadyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReadyActionPerformed

    private void cmBxComWeaponActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmBxComWeaponActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmBxComWeaponActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnStopActionPerformed

    private void txtComHPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtComHPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtComHPActionPerformed

    private void cmBxPlayerWeaponActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmBxPlayerWeaponActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmBxPlayerWeaponActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton btnPlayerAttack;
    protected javax.swing.JButton btnReady;
    protected javax.swing.JButton btnStop;
    protected javax.swing.JComboBox<String> cmBxComChar;
    protected javax.swing.JComboBox<String> cmBxComWeapon;
    protected javax.swing.JComboBox<String> cmBxPlayerChar;
    protected javax.swing.JComboBox<String> cmBxPlayerWeapon;
    protected javax.swing.JLabel lblComWeapon;
    protected javax.swing.JLabel lblComputerImage;
    protected javax.swing.JLabel lblPlayerImage;
    protected javax.swing.JLabel lblPlayerWeapon;
    protected javax.swing.JPanel pnlComputerImage;
    protected javax.swing.JPanel pnlPlayerImage;
    protected javax.swing.JTextField txtComHP;
    protected javax.swing.JTextArea txtCombatLog;
    protected javax.swing.JTextField txtPlayerHP;
    // End of variables declaration//GEN-END:variables
}
