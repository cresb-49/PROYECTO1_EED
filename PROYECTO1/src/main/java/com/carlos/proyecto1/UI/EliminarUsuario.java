/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlos.proyecto1.UI;

import com.carlos.proyecto1.Exepciones.NotFoundNodeException;
import com.carlos.proyecto1.Objetos.DatosPrograma;
import com.carlos.proyecto1.Objetos.usuario;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 *
 * @author benjamin
 */
public class EliminarUsuario extends javax.swing.JInternalFrame {

    private final DatosPrograma datosP;

    /**
     * Creates new form EliminarUsuario
     */
    public EliminarUsuario(DatosPrograma datosP) {
        initComponents();
        this.datosP = datosP;
        this.cargarComboUsuarios();
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
        jComboUsuarios = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Eliminar Usuario");

        jLabel1.setText("Usuario:");

        jComboUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboUsuariosActionPerformed(evt);
            }
        });

        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jComboUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboUsuariosActionPerformed

    }//GEN-LAST:event_jComboUsuariosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String user = this.jComboUsuarios.getItemAt(this.jComboUsuarios.getSelectedIndex());
        try {
            if (JOptionPane.showConfirmDialog(this, "Esta seguro de eliminar al usuario \'" + user + "\' del sistema") == JOptionPane.YES_OPTION) {
                this.datosP.getUsuarios().eliminar(user);
                JOptionPane.showMessageDialog(this, "Se elimino con exito el usuario \"" + user + "\", del sistema");
                this.cargarComboUsuarios();
            } else {
                JOptionPane.showMessageDialog(this, "No se elimino al usuario \"" + user + "\", del sistema");
            }
        } catch (NotFoundNodeException | HeadlessException e) {
            JOptionPane.showMessageDialog(this, "No se puede eliminar al usuario \"" + user + "\", ya no existe en el sistema");
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboUsuarios;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    private void cargarComboUsuarios() {
        if (this.datosP.getUsuarios().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay usuarios en el sistema");
            this.jButton1.setEnabled(false);
        } else {
            this.jComboUsuarios.removeAllItems();
            Object[] array = datosP.getUsuarios().AVLtoArrayInOrden();
            usuario user = null;
            for (Object object : array) {
                user = (usuario) object;
                jComboUsuarios.addItem(user.getUser());
            }
            this.jButton1.setEnabled(true);
        }
    }
}