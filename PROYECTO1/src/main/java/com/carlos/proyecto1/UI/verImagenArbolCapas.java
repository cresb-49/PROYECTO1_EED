/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlos.proyecto1.UI;

import com.carlos.proyecto1.Exepciones.NullDataException;
import com.carlos.proyecto1.Graficacion.GraficarImagenYArbolCapas;
import com.carlos.proyecto1.Graficacion.ejecutarGraphviz;
import com.carlos.proyecto1.Graficacion.generarDotFile;
import com.carlos.proyecto1.Objetos.DatosPrograma;
import com.carlos.proyecto1.Objetos.Imagen;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author benjamin
 */
public class verImagenArbolCapas extends javax.swing.JInternalFrame {

    private DatosPrograma dataP;
    private ejecutarGraphviz ejec;
    private String pathImg;

    /**
     * Creates new form verImagenArbolCapas
     */
    public verImagenArbolCapas(DatosPrograma data) {
        initComponents();
        this.dataP = data;
        this.ejec = new ejecutarGraphviz();
        this.cargarCombo();
    }

    private void cargarCombo() {
        Object options[] = dataP.getImagenes().getArray();

        this.comboImagenes.removeAllItems();
        Imagen tmp = null;
        for (Object option : options) {
            tmp = (Imagen) option;
            this.comboImagenes.addItem(tmp.getId());
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        labelImagen = new javax.swing.JLabel();
        comboImagenes = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnGraficar = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldPath = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Imagen Y Arbol de Capas");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jScrollPane1.setViewportView(labelImagen);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Seleccione el id de imagen");

        btnGraficar.setText("Graficar");
        btnGraficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraficarActionPerformed(evt);
            }
        });

        btnMostrar.setText("Mostrar");
        btnMostrar.setEnabled(false);
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        jLabel2.setText("Ubicacion Imagen:");

        jTextFieldPath.setEditable(false);
        jTextFieldPath.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMostrar)
                            .addComponent(btnGraficar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(comboImagenes, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldPath, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(comboImagenes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGraficar)
                        .addGap(18, 18, 18)
                        .addComponent(btnMostrar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGraficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraficarActionPerformed
        // TODO add your handling code here:

        String id = this.comboImagenes.getItemAt(this.comboImagenes.getSelectedIndex());

        GraficarImagenYArbolCapas gr = new GraficarImagenYArbolCapas();
        String code = "", grap = "";
        grap = gr.obtenerDotFile(id, this.dataP);
        code = "digraph IMGSELECTED {\n" + grap + "}\n";

        if (grap == null) {
            code = null;
        }

        try {
            generarDotFile gen = new generarDotFile();
            gen.generarArchivo(code, "IMGSELECTED");
            pathImg = ejec.ejecutar("IMGSELECTED" + ".dot", "IMGSELECTED" + ".png");
            this.mostarPath();
            this.btnMostrar.setEnabled(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se puede procesar la imagen\n" + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnGraficarActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        // TODO add your handling code here:
        try {
            File file = new File(this.pathImg);
            Image icono = ImageIO.read(file);
            labelImagen.setIcon(new ImageIcon(icono));
            labelImagen.updateUI();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void mostarPath() {
        this.jTextFieldPath.setText(this.pathImg);
        JOptionPane.showMessageDialog(this, "Se genero con exito la imagen, puede copiar la ruta\n"
                                      + "o mostrar la imagen en el programa precionando el boton \"Mostrar\"");
        labelImagen.setIcon(null);
        labelImagen.updateUI();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGraficar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JComboBox<String> comboImagenes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldPath;
    private javax.swing.JLabel labelImagen;
    // End of variables declaration//GEN-END:variables
}
