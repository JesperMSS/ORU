/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrumxp;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author Anton
 */
public class SeSvarPåSkickadeFörfrågningar extends javax.swing.JFrame {

    private static String userID;
    private static InfDB idb;

    private DefaultTableModel tableModel;
    private DefaultTableModel model;
    private DefaultTableModel model2;

    public SeSvarPåSkickadeFörfrågningar(InfDB idb, String userID) {
        initComponents();
        this.userID = userID;
        this.idb = idb;

        model = (DefaultTableModel) jTableMöten.getModel();
        model2 = (DefaultTableModel) jTable2.getModel();
        hämtaMöten();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tbxBTN = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableMöten = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 22)); // NOI18N
        jLabel1.setText("Välj möte att se status på");

        tbxBTN.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        tbxBTN.setText("Tillbaka");
        tbxBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbxBTNActionPerformed(evt);
            }
        });

        jTableMöten.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Datum", "Start Tid", "Slut Tid", "Info"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableMöten.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMötenMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableMöten);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Förnamn", "Tillgänglighet"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(105, 105, 105))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(tbxBTN)
                        .addGap(237, 237, 237))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(tbxBTN)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbxBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbxBTNActionPerformed
        new MötesMeny(idb, userID).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_tbxBTNActionPerformed

    private void jTableMötenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMötenMouseClicked
        //Hämtar mötestatus vid valt möte. 
        int row = jTableMöten.getSelectedRow();
        int column = 0;

        String datum = jTableMöten.getModel().getValueAt(row, column).toString();
        column++;
        String startTid = jTableMöten.getModel().getValueAt(row, column).toString();
        column++;
        String slutTid = jTableMöten.getModel().getValueAt(row, column).toString();
        column++;
        String info = jTableMöten.getModel().getValueAt(row, column).toString();
        
        model2.setRowCount(0);
        
        System.out.println(datum);
        System.out.println(startTid);
        System.out.println(slutTid);
        System.out.println(info);

        String fragaMeetingID = "select meeting_id from meeting where datum = '" + datum + "' and Start_Time = '" + startTid
                + "' and End_Time = '" + slutTid + "' and info = '" + info + "';";
        try {
            String meetingID = idb.fetchSingle(fragaMeetingID);
            System.out.println(meetingID);

            String fragaUserID = "select userID from förfrågningar where meeting_ID = " + meetingID;

            ArrayList<String> userIDs = new ArrayList<String>();
            userIDs = idb.fetchColumn(fragaUserID);
            System.out.println(userIDs);

            for (String user : userIDs) {
                String förnamn = "Select förnamn from users where userID = " + user;
                String svarFörnamn = idb.fetchSingle(förnamn);
                System.out.println(svarFörnamn);
                String jaNej = "select kommer from förfrågningar where userID = " + user;
                String svarJaNej = idb.fetchSingle(jaNej);
                System.out.println(svarJaNej);
                if (svarJaNej.equals("J")) {
                    svarJaNej = "Kommer";
                }
                if (svarJaNej.equals("N")) {
                    svarJaNej = "Kommer inte";
                }
                if (svarJaNej.equals("q")) {
                    svarJaNej = "Ej besvarad";
                }

                model2.insertRow(jTable2.getRowCount(), new Object[]{svarFörnamn, svarJaNej});
            }

        } catch (InfException ex) {
            Logger.getLogger(SeSvarPåSkickadeFörfrågningar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTableMötenMouseClicked

    private void hämtaMöten() {
        // Hämtar tillgängliga möten
        ArrayList<String> mötesLista = new ArrayList<String>();
        try {

            String fragaMeetingID = "Select meeting_ID from meeting Where userID = " + userID + ";";
            System.out.println(fragaMeetingID);
            mötesLista = idb.fetchColumn(fragaMeetingID);

            for (String möte : mötesLista) {
                String fragaDatum = "SELECT Datum FROM meeting WHERE meeting_ID = " + möte + ";";
                String fragaStartTid = "SELECT Start_Time FROM meeting WHERE meeting_ID = " + möte + ";";
                String fragaSlutTid = "SELECT End_Time FROM meeting WHERE meeting_ID = " + möte + ";";
                String fragaInfo = "SELECT info FROM meeting WHERE meeting_ID = " + möte + ";";
                String test = idb.fetchSingle(fragaInfo);
                System.out.println(test);
                model.insertRow(jTableMöten.getRowCount(), new Object[]{idb.fetchSingle(fragaDatum), idb.fetchSingle(fragaStartTid),
                    idb.fetchSingle(fragaSlutTid), idb.fetchSingle(fragaInfo)});

            }
        } catch (InfException ex) {
            Logger.getLogger(HomeScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
            java.util.logging.Logger.getLogger(SeSvarPåSkickadeFörfrågningar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeSvarPåSkickadeFörfrågningar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeSvarPåSkickadeFörfrågningar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeSvarPåSkickadeFörfrågningar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SeSvarPåSkickadeFörfrågningar(idb, userID).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTableMöten;
    private javax.swing.JButton tbxBTN;
    // End of variables declaration//GEN-END:variables
}
