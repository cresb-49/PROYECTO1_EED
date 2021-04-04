/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlos.proyecto1.UI;

import com.carlos.proyecto1.Exepciones.NullDataException;
import com.carlos.proyecto1.Graficacion.GraficarImagenYArbolCapas;
import com.carlos.proyecto1.Graficacion.ObtenerGraficoAVL;
import com.carlos.proyecto1.Graficacion.ejecutarGraphviz;
import com.carlos.proyecto1.Graficacion.generarDotFile;
import com.carlos.proyecto1.Graficacion.obtenerGraficoImagenes;
import com.carlos.proyecto1.Objetos.DatosPrograma;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author benjamin
 */
public class FramePrincipal extends javax.swing.JFrame {

    private DatosPrograma datosProgrma;
    private ejecutarGraphviz ejec;

    /**
     * Creates new form framePrincipal
     */
    public FramePrincipal() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.ejec = new ejecutarGraphviz();
        this.datosProgrma = new DatosPrograma();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCargarArchivos = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuGenerarImagenes = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        listaImagenes = new javax.swing.JMenu();
        verArbolCapas = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        imagenArbolCapas = new javax.swing.JMenuItem();
        verArbolUsuarios = new javax.swing.JMenuItem();
        verListaImagenes = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout EscritorioLayout = new javax.swing.GroupLayout(Escritorio);
        Escritorio.setLayout(EscritorioLayout);
        EscritorioLayout.setHorizontalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 877, Short.MAX_VALUE)
        );
        EscritorioLayout.setVerticalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 475, Short.MAX_VALUE)
        );

        jMenuCargarArchivos.setText("Carga de Archivos");

        jMenuItem5.setText("Cargar");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenuCargarArchivos.add(jMenuItem5);

        jMenuBar1.add(jMenuCargarArchivos);

        jMenuGenerarImagenes.setText("Graficar Imagenes");

        jMenuItem1.setText("Recorrido Limitado");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuGenerarImagenes.add(jMenuItem1);

        jMenuItem3.setText("Por Capa");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenuGenerarImagenes.add(jMenuItem3);

        jMenuItem4.setText("Por Usuario");
        jMenuGenerarImagenes.add(jMenuItem4);

        jMenuItem10.setText("Imagen Predeterminada");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenuGenerarImagenes.add(jMenuItem10);

        jMenuBar1.add(jMenuGenerarImagenes);

        jMenu3.setText("Modificacion de Usuario");

        jMenuItem6.setText("Nuevo Usuario");
        jMenu3.add(jMenuItem6);

        jMenuItem7.setText("Agregar Imagen");
        jMenu3.add(jMenuItem7);

        jMenuItem8.setText("Eliminar Usuario");
        jMenu3.add(jMenuItem8);

        jMenuItem9.setText("Eliminar Imagen");
        jMenu3.add(jMenuItem9);

        jMenuBar1.add(jMenu3);

        listaImagenes.setText("Grafico de Estado de Memoria");

        verArbolCapas.setText("Arbol de Capas");
        verArbolCapas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verArbolCapasActionPerformed(evt);
            }
        });
        listaImagenes.add(verArbolCapas);

        jMenuItem2.setText("Ver una Capa");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        listaImagenes.add(jMenuItem2);

        imagenArbolCapas.setText("Imagen y Arbol de Capas");
        imagenArbolCapas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imagenArbolCapasActionPerformed(evt);
            }
        });
        listaImagenes.add(imagenArbolCapas);

        verArbolUsuarios.setText("Arbol de Usuarios");
        verArbolUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verArbolUsuariosActionPerformed(evt);
            }
        });
        listaImagenes.add(verArbolUsuarios);

        verListaImagenes.setText("Ver Lista Imagenes");
        verListaImagenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verListaImagenesActionPerformed(evt);
            }
        });
        listaImagenes.add(verListaImagenes);

        jMenuBar1.add(listaImagenes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Escritorio)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Escritorio)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        CargaDatos carga = new CargaDatos(this, true, this.datosProgrma);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void verArbolCapasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verArbolCapasActionPerformed
        // TODO add your handling code here:

        ObtenerGraficoAVL graphAVL = new ObtenerGraficoAVL();
        String grap = graphAVL.GraficoAVL(datosProgrma.getArbolCapas());
        String code = "digraph capasAVL {";
        code = code + grap;
        code = code + "}";

        if (grap == null) {
            code = null;
        }

        try {
            generarDotFile gen = new generarDotFile();
            gen.generarArchivo(code, "capasAVL");

            MostrarImagenes mostrar = new MostrarImagenes("Arbol de Capas",ejec.ejecutar("capasAVL.dot", "capasAVL.png"));
            Escritorio.add(mostrar);
            mostrar.show();

        } catch (NullDataException | IOException e) {
            JOptionPane.showMessageDialog(this, "No se puede escribir el archivo .dot para graphviz\n" + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_verArbolCapasActionPerformed

    private void verArbolUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verArbolUsuariosActionPerformed
        // TODO add your handling code here:
        ObtenerGraficoAVL graficoAVL = new ObtenerGraficoAVL();
        String grap = graficoAVL.GraficoAVL(datosProgrma.getUsuarios());
        String code = "digraph userAVL {";
        code = code + grap;
        code = code + "}";

        if (grap == null) {
            code = null;
        }
        
        try {
            generarDotFile gen = new generarDotFile();
            gen.generarArchivo(code, "userAVL");

            MostrarImagenes mostrar = new MostrarImagenes("Arbol de Usuarios",ejec.ejecutar("userAVL.dot", "userAVL.png"));
            Escritorio.add(mostrar);
            mostrar.show();

        } catch (NullDataException | IOException e) {
            JOptionPane.showMessageDialog(this, "No se puede escribir el archivo .dot para graphviz\n" + e.getMessage());
            e.printStackTrace();
        }
        
        
    }//GEN-LAST:event_verArbolUsuariosActionPerformed

    private void verListaImagenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verListaImagenesActionPerformed
        // TODO add your handling code here:
        obtenerGraficoImagenes graficoIMG = new obtenerGraficoImagenes();
        String grap = graficoIMG.GraficoImagenes(datosProgrma.getImagenes());
        String code = "digraph ImagenesLC {\n";
        code = code + grap;
        code = code + "}";

        if (grap == null) {
            code = null;
        }
        
        try {
            generarDotFile gen = new generarDotFile();
            gen.generarArchivo(code, "ImagenesLC");
            MostrarImagenes mostrar = new MostrarImagenes("Lista Imagenes",ejec.ejecutar("ImagenesLC.dot", "ImagenesLC.png"));
            Escritorio.add(mostrar);
            mostrar.show();

        } catch (NullDataException | IOException e) {
            JOptionPane.showMessageDialog(this, "No se puede escribir el archivo .dot para graphviz\n" + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_verListaImagenesActionPerformed

    private void imagenArbolCapasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imagenArbolCapasActionPerformed
        // TODO add your handling code here:
        if(datosProgrma.getImagenes().isEmpty()){
            JOptionPane.showMessageDialog(this, "No se puede escribir el archivo .dot para graphviz\n" + "No existen datos sobre imagenes");
        }else{
            verImagenArbolCapas img = new verImagenArbolCapas(this.datosProgrma);
            Escritorio.add(img);
            img.show();
        }
    }//GEN-LAST:event_imagenArbolCapasActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        if(datosProgrma.getArbolCapas().isEmpty()){
            JOptionPane.showMessageDialog(this,"No existen datos sobre capas en el programa");
        }else{
            mostarCapa capas = new mostarCapa(this.datosProgrma);
            Escritorio.add(capas);
            capas.show();
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        if(datosProgrma.getArbolCapas().isEmpty()){
            JOptionPane.showMessageDialog(this,"No existen datos sobre capas en el programa");
        }else{
            GenerarImagenRecorrido gen = new GenerarImagenRecorrido(this.datosProgrma);
            Escritorio.add(gen);
            gen.show();
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        if(datosProgrma.getArbolCapas().isEmpty()){
            JOptionPane.showMessageDialog(this,"No existen datos sobre capas en el programa");
        }else{
            GenerarImagenCapa gen = new GenerarImagenCapa(this.datosProgrma);
            Escritorio.add(gen);
            gen.show();
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        if(datosProgrma.getImagenes().isEmpty()){
            JOptionPane.showMessageDialog(this,"No existen datos sobre Imagenes en el programa");
        }else{
            GraficarImagenPrdeterminada gen = new GraficarImagenPrdeterminada(datosProgrma);
            Escritorio.add(gen);
            gen.show();
        }
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Escritorio;
    private javax.swing.JMenuItem imagenArbolCapas;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCargarArchivos;
    private javax.swing.JMenu jMenuGenerarImagenes;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenu listaImagenes;
    private javax.swing.JMenuItem verArbolCapas;
    private javax.swing.JMenuItem verArbolUsuarios;
    private javax.swing.JMenuItem verListaImagenes;
    // End of variables declaration//GEN-END:variables
}
