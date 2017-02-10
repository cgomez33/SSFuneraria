package si_funeraria;

import entidades.SfmCliente;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;
import Controladore.SfmClienteController;
import java.util.ArrayList;
import java.util.Iterator;

public class log_in extends javax.swing.JFrame {

    public log_in() {
        initComponents();
        ImageIcon usuario = new ImageIcon("src/Imagenes/Registrar.png");
        Icon icono = new ImageIcon(usuario.getImage().getScaledInstance(lblUs.getWidth(), lblUs.getHeight(), Image.SCALE_DEFAULT));
        lblUs.setIcon(icono);
        this.repaint();

        ImageIcon ingreso = new ImageIcon("src/Imagenes/ingreso.png");
        Icon icon = new ImageIcon(ingreso.getImage().getScaledInstance(btnIngreso.getWidth(), btnIngreso.getHeight(), Image.SCALE_DEFAULT));
        btnIngreso.setIcon(icon);
        this.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        place_Holder1 = new si_funeraria.JCTextField();
        place_Holder2 = new si_funeraria.JCTextField();
        place_Holder3 = new si_funeraria.JCTextField();
        lblUsuario = new javax.swing.JPanel();
        btnIngreso = new javax.swing.JButton();
        lblUs = new javax.swing.JLabel();
        jcUsuario = new si_funeraria.JCTextField();
        jcContra = new si_funeraria.JCTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Log_in", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N

        btnIngreso.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnIngreso.setBorder(null);
        btnIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresoActionPerformed(evt);
            }
        });

        jcUsuario.setPlaceholder("Escriba el nombre de usuario ");

        jcContra.setPlaceholder("Contraseña");

        javax.swing.GroupLayout lblUsuarioLayout = new javax.swing.GroupLayout(lblUsuario);
        lblUsuario.setLayout(lblUsuarioLayout);
        lblUsuarioLayout.setHorizontalGroup(
            lblUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblUsuarioLayout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(lblUs, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lblUsuarioLayout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(lblUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jcUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addComponent(jcContra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(lblUsuarioLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(btnIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );
        lblUsuarioLayout.setVerticalGroup(
            lblUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblUsuarioLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblUs, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jcUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jcContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresoActionPerformed
        Interfaz abrir = new Interfaz();
        abrir.setVisible(true);
        abrir.setLocationRelativeTo(null);
        this.dispose();
        SfmClienteController helper = new SfmClienteController();
        SfmCliente sfmCliente = new SfmCliente();
        sfmCliente.setCedula("304660255");
        sfmCliente.setApellidos("gomez");
        sfmCliente.setNombre("cristian");
        sfmCliente.setDireccion("dir");
        //helper.create(sfmCliente);
        for (SfmCliente a : helper.listarclientes()) {

            System.out.println(a.getNombre()+ "," + a.getApellidos());
        }
    }//GEN-LAST:event_btnIngresoActionPerformed

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
            java.util.logging.Logger.getLogger(log_in.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(log_in.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(log_in.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(log_in.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new log_in().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngreso;
    private si_funeraria.JCTextField jcContra;
    private si_funeraria.JCTextField jcUsuario;
    private javax.swing.JLabel lblUs;
    private javax.swing.JPanel lblUsuario;
    private si_funeraria.JCTextField place_Holder1;
    private si_funeraria.JCTextField place_Holder2;
    private si_funeraria.JCTextField place_Holder3;
    // End of variables declaration//GEN-END:variables

}
