/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlos.proyecto1.UI;

import com.carlos.proyecto1.ED.NodoArbol;
import com.carlos.proyecto1.Exepciones.CloneNodeException;
import com.carlos.proyecto1.Exepciones.NotFoundNodeException;
import com.carlos.proyecto1.Objetos.DatosPrograma;
import com.carlos.proyecto1.Objetos.usuario;
import java.awt.HeadlessException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author benjamin
 */
public class ModificarNombreUsuario extends javax.swing.JInternalFrame {

    private DatosPrograma datosP;

    /**
     * Creates new form ModificarNombreUsuario
     */
    public ModificarNombreUsuario(DatosPrograma datosP) {
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
        modificarUsuario = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        nuevoUsuario = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Modificar Nombre Usuario");

        jLabel1.setText("Usuario:");

        jComboUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboUsuariosActionPerformed(evt);
            }
        });

        modificarUsuario.setText("Modificar Nombre");
        modificarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarUsuarioActionPerformed(evt);
            }
        });

        jLabel2.setText("Nuevo Usuario:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1))
                    .addComponent(jLabel2))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nuevoUsuario)
                    .addComponent(jComboUsuarios, 0, 127, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(modificarUsuario)
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jComboUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nuevoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(modificarUsuario)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboUsuariosActionPerformed

    }//GEN-LAST:event_jComboUsuariosActionPerformed

    private void modificarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarUsuarioActionPerformed
        // TODO add your handling code here:
        String user = this.jComboUsuarios.getItemAt(this.jComboUsuarios.getSelectedIndex());
        String newUser = this.nuevoUsuario.getText();
        try {
            if (verificarUsuario(newUser)) {
                if (JOptionPane.showConfirmDialog(this, "Esta seguro de modificar el usuario \'" + user + "\' por \"" + newUser + "\"") == JOptionPane.YES_OPTION) {
                    usuario tmpUser = (usuario) this.datosP.getUsuarios().buscarNodo(user).getContenido();
                    if (tmpUser != null) {

                        this.datosP.getUsuarios().eliminar(user);
                        JOptionPane.showMessageDialog(this, "Se modifico con exito el usuario \"" + user + "\", del sistema");
                        tmpUser.setUser(newUser);
                        this.datosP.getUsuarios().agregar(new NodoArbol(newUser,tmpUser));
                        this.cargarComboUsuarios();
                        this.nuevoUsuario.setText("");
                    } else {
                        JOptionPane.showMessageDialog(this, "Error al recuperar al usuario \"" + user + "\", del sistema");
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "No se elimino al usuario \"" + user + "\", del sistema");
                }
            } else {
                JOptionPane.showMessageDialog(this, "El nombre \"" + newUser + "\", no es valido el nombre solo deben ser caracteres alfanumericos");
            }
        } catch (NotFoundNodeException | HeadlessException e) {
            JOptionPane.showMessageDialog(this, "No se puede eliminar al usuario \"" + user + "\", ya no existe en el sistema");
        } catch (CloneNodeException ex) {
            JOptionPane.showMessageDialog(this, "Ya existe un usuario \"" + newUser + "\", en el sistema");
        }
    }//GEN-LAST:event_modificarUsuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton modificarUsuario;
    private javax.swing.JTextField nuevoUsuario;
    // End of variables declaration//GEN-END:variables

    private void cargarComboUsuarios() {
        this.jComboUsuarios.removeAllItems();
        Object[] array = datosP.getUsuarios().AVLtoArrayInOrden();
        usuario user = null;
        for (Object object : array) {
            user = (usuario) object;
            jComboUsuarios.addItem(user.getUser());
        }
    }

    private boolean verificarUsuario(String userName) {
        Pattern pattern = Pattern.compile("^([a-zA-Z])+([0-9])*$");
        Matcher matcher = pattern.matcher(userName);
        boolean matchFound = matcher.find();
        if (matchFound) {
            return true;
        } else {
            return false;
        }
    }

}
