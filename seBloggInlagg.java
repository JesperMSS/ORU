/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrumxp;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author adamnorman
 */
public class seBloggInlagg extends javax.swing.JFrame {

    DefaultTableModel model;
    private static InfDB idb;
    private static String id;
    private static String userID;

    /**
     * Creates new form seBloggInlaggMeny
     */
    public seBloggInlagg(InfDB idb, String userID) {

        initComponents();
        this.idb = idb;
        this.userID = userID;
        model = (DefaultTableModel) jTable1.getModel();
        hamtaInlagg();

    }

    private void hamtaInlagg() {
        // Metod som hämtar blogginlägg
        int i = 1;

        try {

            String antal = idb.fetchSingle("select count(*) from inlagg");

            int x = Integer.parseInt(antal);
            while (i <= x + 1) {
                String titel = "SELECT TITEL FROM INLAGG WHERE INLAGGID = " + i;
                String anvandare = "SELECT ANVANDARE FROM INLAGG WHERE INLAGGID = " + i;
                String kategori = "SELECT KATEGORI FROM INLAGG WHERE INLAGGID = " + i;
                String blogg = "SELECT BLOGG FROM INLAGG WHERE INLAGGID = " + i;
                String id = "SELECT INLAGGID FROM INLAGG WHERE INLAGGID = " + i;
                System.out.println(i);
                model.insertRow(model.getRowCount(), new Object[]{idb.fetchSingle(titel), idb.fetchSingle(anvandare),
                    idb.fetchSingle(kategori), idb.fetchSingle(blogg), idb.fetchSingle(id)});
                i++;
            }
        } catch (InfException ex) {
            Logger.getLogger(seBloggInlagg.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jCombo = new javax.swing.JComboBox<>();
        jButtonSortera = new javax.swing.JButton();
        jLabelBlogg = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Titel", "Anvandare", "Kategori", "Blogg", "Inlägg ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jCombo.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alla bloggar", "Utbildnings bloggen", "Informella bloggen", "Forsknings bloggen" }));

        jButtonSortera.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButtonSortera.setText("Sortera");
        jButtonSortera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSorteraActionPerformed(evt);
            }
        });

        jLabelBlogg.setFont(new java.awt.Font("Arial Black", 0, 22)); // NOI18N
        jLabelBlogg.setText("Bloggen");

        jButton1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButton1.setText("Tillbaka");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabelBlogg)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonSortera)
                    .addComponent(jButton1)
                    .addComponent(jCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabelBlogg, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSortera)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(396, 396, 396))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // Öppnar inlägget användaren klickar på. 
        int index = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        String id = model.getValueAt(index, 4).toString();

        new SeInlagg(idb, id, userID).setVisible(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButtonSorteraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSorteraActionPerformed
        // Sorterar blogginlägg efter bloggtyp.
        ((DefaultTableModel) jTable1.getModel()).setRowCount(0);
        String koll = null;
        int i = 1;
        try {
            if (jCombo.getSelectedItem().toString().equals("Forsknings bloggen")) {
                String antal = idb.fetchSingle("select count(*) from inlagg");
                int x = Integer.parseInt(antal);
                while (i <= x + 1) {
                    String titel = "SELECT TITEL FROM INLAGG WHERE INLAGGID = " + i + " AND BLOGG = 'Forsknings bloggen'";
                    String anvandare = "SELECT ANVANDARE FROM INLAGG WHERE INLAGGID = " + i + " AND BLOGG = 'Forsknings bloggen'";
                    String kategori = "SELECT KATEGORI FROM INLAGG WHERE INLAGGID = " + i + " AND BLOGG = 'Forsknings bloggen'";
                    String blogg = "SELECT BLOGG FROM INLAGG WHERE INLAGGID = " + i + " AND BLOGG = 'Forsknings bloggen'";
                    String id = "SELECT INLAGGID FROM INLAGG WHERE INLAGGID = " + i + " AND BLOGG = 'Forsknings bloggen'";
                    koll = idb.fetchSingle(titel); // kontrollerar så det inte är nullvärde
                    if (koll != null) {
                        model.insertRow(model.getRowCount(), new Object[]{idb.fetchSingle(titel), idb.fetchSingle(anvandare),
                            idb.fetchSingle(kategori), idb.fetchSingle(blogg), idb.fetchSingle(id)});
                    }
                    i++;
                }

            }
            if (jCombo.getSelectedItem().toString().equals("Informella bloggen")) {
                String antal = idb.fetchSingle("select count(*) from inlagg");
                int x = Integer.parseInt(antal);
                while (i <= x + 1) {
                    String titel = "SELECT TITEL FROM INLAGG WHERE INLAGGID = " + i + " AND BLOGG = 'Informella bloggen'";
                    String anvandare = "SELECT ANVANDARE FROM INLAGG WHERE INLAGGID = " + i + " AND BLOGG = 'Informella bloggen'";
                    String kategori = "SELECT KATEGORI FROM INLAGG WHERE INLAGGID = " + i + " AND BLOGG = 'Informella bloggen'";
                    String blogg = "SELECT BLOGG FROM INLAGG WHERE INLAGGID = " + i + " AND BLOGG = 'Informella bloggen'";
                    String id = "SELECT INLAGGID FROM INLAGG WHERE INLAGGID = " + i + " AND BLOGG = 'Informella bloggen'";
                    koll = idb.fetchSingle(titel); // kontrollerar så det inte är nullvärde
                    if (koll != null) {
                        model.insertRow(model.getRowCount(), new Object[]{idb.fetchSingle(titel), idb.fetchSingle(anvandare),
                            idb.fetchSingle(kategori), idb.fetchSingle(blogg), idb.fetchSingle(id)});
                    }
                    i++;
                }

            }
            if (jCombo.getSelectedItem().toString().equals("Utbildnings bloggen")) {
                String antal = idb.fetchSingle("select count(*) from inlagg");
                int x = Integer.parseInt(antal);
                while (i <= x + 1) {
                    String titel = "SELECT TITEL FROM INLAGG WHERE INLAGGID = " + i + " AND BLOGG = 'Utbildnings bloggen'";
                    String anvandare = "SELECT ANVANDARE FROM INLAGG WHERE INLAGGID = " + i + " AND BLOGG = 'Utbildnings bloggen'";
                    String kategori = "SELECT KATEGORI FROM INLAGG WHERE INLAGGID = " + i + " AND BLOGG = 'Utbildnings bloggen'";
                    String blogg = "SELECT BLOGG FROM INLAGG WHERE INLAGGID = " + i + " AND BLOGG = 'Utbildnings bloggen'";
                    String id = "SELECT INLAGGID FROM INLAGG WHERE INLAGGID = " + i + " AND BLOGG = 'Utbildnings bloggen'";
                    koll = idb.fetchSingle(titel); // kontrollerar så det inte är nullvärde
                    if (koll != null) {
                        model.insertRow(model.getRowCount(), new Object[]{idb.fetchSingle(titel), idb.fetchSingle(anvandare),
                            idb.fetchSingle(kategori), idb.fetchSingle(blogg), idb.fetchSingle(id)});
                    }
                    i++;
                }
            }
            if (jCombo.getSelectedItem().toString().equals("Alla bloggar")) {
                hamtaInlagg();
            }

        } catch (InfException ex) {
            Logger.getLogger(seBloggInlagg.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButtonSorteraActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new BloggMeny(idb, userID).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(seBloggInlagg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(seBloggInlagg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(seBloggInlagg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(seBloggInlagg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new seBloggInlagg(idb, userID).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonSortera;
    private javax.swing.JComboBox<String> jCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelBlogg;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
