/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

import java.awt.Point;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import model.Poruka;
import model.User;
import operacije.Operacije;
import tabele.ModelTabeleUseri;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author vldmrk
 */
public class KlijentForma extends javax.swing.JFrame {

    private final User u;
    private Poruka poruka = null;

    /**
     * Creates new form KlijentForma
     *
     * @param u
     */
    public KlijentForma(User u) {
        this.u = u;
        initComponents();
        popuniTabelu();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButtonPosaljiSvima = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableUseri = new javax.swing.JTable();
        jButtonPosalji = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tekst:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButtonPosaljiSvima.setText("POSALJI SVIMA");
        jButtonPosaljiSvima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPosaljiSvimaActionPerformed(evt);
            }
        });

        jTableUseri.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableUseri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableUseriMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableUseri);

        jButtonPosalji.setText("Posalji");
        jButtonPosalji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPosaljiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonPosaljiSvima))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jButtonPosalji, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonPosalji)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonPosaljiSvima, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(222, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPosaljiSvimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPosaljiSvimaActionPerformed
        String tekst = jTextArea1.getText();
        Poruka p = new Poruka();
        p.setPosiljalac(u);
        p.setText(tekst);
        p.setVreme(new Date());
        KlijentskiZahtev kz = new KlijentskiZahtev(p, Operacije.POSALJI_SVIMA);
        Komunikacija.getInstance().posaljiZahtev(kz);
        JOptionPane.showMessageDialog(this, "PORUKA POSLATA SVIMA USPESNO", "POSLATO", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButtonPosaljiSvimaActionPerformed

    private void jTableUseriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableUseriMouseClicked
        Point p = evt.getPoint();
        int red = jTableUseri.rowAtPoint(p);
        ModelTabeleUseri mtu = (ModelTabeleUseri) jTableUseri.getModel();
        User primalac = mtu.getUseri().get(red);
        poruka = new Poruka();
        poruka.setPosiljalac(u);
        poruka.setPrimalac(primalac);
    }//GEN-LAST:event_jTableUseriMouseClicked

    private void jButtonPosaljiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPosaljiActionPerformed
        if (poruka == null) {
            JOptionPane.showMessageDialog(this, "NIJE IZABRAN PRIMALAC", "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }
        poruka.setText(jTextArea1.getText());
        poruka.setVreme(new Date());
        KlijentskiZahtev kz = new KlijentskiZahtev(poruka, Operacije.POSALJI);
        Komunikacija.getInstance().posaljiZahtev(kz);
        JOptionPane.showMessageDialog(this, "PORUKA POSLATA USPESNO", "POSLATO", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButtonPosaljiActionPerformed

    private void popuniTabelu() {
        KlijentskiZahtev kz = new KlijentskiZahtev(null, Operacije.VRATI_USERE);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        List<User> useri = (List<User>) so.getOdgovor();
        ModelTabeleUseri mtu = new ModelTabeleUseri(useri);
        jTableUseri.setModel(mtu);
    }

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonPosalji;
    private javax.swing.JButton jButtonPosaljiSvima;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableUseri;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
