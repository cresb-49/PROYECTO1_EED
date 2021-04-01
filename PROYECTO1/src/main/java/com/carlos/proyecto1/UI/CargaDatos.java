/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlos.proyecto1.UI;

import com.carlos.proyecto1.Analizadores.Lexer.capasLexer;
import com.carlos.proyecto1.Analizadores.Lexer.imagenLexer;
import com.carlos.proyecto1.Analizadores.Lexer.userLexer;
import com.carlos.proyecto1.Analizadores.Parser.parserCapas;
import com.carlos.proyecto1.Analizadores.Parser.parserImagenes;
import com.carlos.proyecto1.Analizadores.Parser.parserUsuario;
import com.carlos.proyecto1.ED.Pila;
import com.carlos.proyecto1.Objetos.DatosPrograma;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author benjamin
 */
public class CargaDatos extends javax.swing.JDialog {
    
    private DatosPrograma datosPrograma;
    /**
     * Creates new form cargaDatos
     */
    public CargaDatos(java.awt.Frame parent, boolean modal,DatosPrograma datosPrograma) {
        
        super(parent, modal);
        initComponents();
        this.datosPrograma = datosPrograma;
        validarCapas();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    private void validarCapas(){
        System.out.println("Valide Capas");
        if(this.datosPrograma.getArbolCapas().isEmpty()){
            this.btnCargarCapas.setEnabled(true);
        }else{
            this.btnCargarCapas.setEnabled(false);
            this.validarImagenes();
        }
    }
    
    private void validarImagenes(){
        System.out.println("Valide imagenes");
        if(this.datosPrograma.getImagenes().isEmpty()){
            this.btnCargarImg.setEnabled(true);
        }else{
            this.btnCargarImg.setEnabled(false);
            this.validarUsuarios();
        }
    }
    private void validarUsuarios(){
        System.out.println("Valide usuarios");
        if(this.datosPrograma.getUsuarios().isEmpty()){
            this.btnCargarUsers.setEnabled(true);
        }else{
            this.btnCargarUsers.setEnabled(false);
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

        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnCargarCapas = new javax.swing.JButton();
        btnCargarImg = new javax.swing.JButton();
        btnCargarUsers = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("Panel de Errores:");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setTabSize(3);
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        jLabel1.setText("Carge los archivos para el funcionamiento del programa en el siguiente orden:");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("1. Capas");

        jLabel3.setText("2. Imagenes");

        jLabel4.setText("3. Usuarios");

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnCargarCapas.setText("Cargar");
        btnCargarCapas.setEnabled(false);
        btnCargarCapas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarCapasActionPerformed(evt);
            }
        });

        btnCargarImg.setText("Cargar");
        btnCargarImg.setEnabled(false);
        btnCargarImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarImgActionPerformed(evt);
            }
        });

        btnCargarUsers.setText("Cargar");
        btnCargarUsers.setEnabled(false);
        btnCargarUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarUsersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCargarCapas)
                    .addComponent(btnCargarImg)
                    .addComponent(btnCargarUsers))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCargarCapas)
                .addGap(18, 18, 18)
                .addComponent(btnCargarImg)
                .addGap(18, 18, 18)
                .addComponent(btnCargarUsers)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setText("Panel de Carga:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(133, 133, 133))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel4))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargarCapasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarCapasActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo .cap", "cap");
        chooser.setFileFilter(filtro);
        int retorno = chooser.showOpenDialog(this);
        if(retorno == JFileChooser.APPROVE_OPTION){
            leerCapas(chooser.getSelectedFile());
        }
    }//GEN-LAST:event_btnCargarCapasActionPerformed

    private void btnCargarImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarImgActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo .im", "im");
        chooser.setFileFilter(filtro);
        int retorno = chooser.showOpenDialog(this);
        if(retorno == JFileChooser.APPROVE_OPTION){
            leerImagenes(chooser.getSelectedFile());
        }
    }//GEN-LAST:event_btnCargarImgActionPerformed

    private void btnCargarUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarUsersActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo .usr", "usr");
        chooser.setFileFilter(filtro);
        int retorno = chooser.showOpenDialog(this);
        if(retorno == JFileChooser.APPROVE_OPTION){
            leerUsuarios(chooser.getSelectedFile());
        }
    }//GEN-LAST:event_btnCargarUsersActionPerformed
    
    public void leerCapas(File archivo){
        System.out.println("You chose to open this file: " + archivo.getName());
        try {
            capasLexer lex = new capasLexer(new BufferedReader(new FileReader(archivo)));
            parserCapas parser = new parserCapas(lex);
            parser.parse();
            String tmp ="";
            
            if(parser.getErrores().isEmpty()){
                this.datosPrograma.setArbolCapas(parser.getArbolCapas());
                this.validarCapas();
                this.jTextArea1.setText("");
            }else{
                while (!parser.getErrores().isEmpty()) {                    
                    tmp = tmp + (String)parser.getErrores().pop()+"\n";
                }
                this.jTextArea1.setText(tmp);
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
    public void leerImagenes(File archivo){
        System.out.println("You chose to open this file: " + archivo.getName());
        
        try {
            imagenLexer lex = new imagenLexer(new BufferedReader(new FileReader(archivo)));
            parserImagenes parser = new parserImagenes(lex,this.datosPrograma.getArbolCapas());
            parser.parse();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        System.out.println("Ya termine la operacion");
    }
    
    public void leerUsuarios(File archivo){
        System.out.println("You chose to open this file: " + archivo.getName());
        try {
            userLexer lex = new userLexer(new BufferedReader(new FileReader(archivo)));
            parserUsuario parser = new parserUsuario(lex);
            parser.parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargarCapas;
    private javax.swing.JButton btnCargarImg;
    private javax.swing.JButton btnCargarUsers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
