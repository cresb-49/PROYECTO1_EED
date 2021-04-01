package com.carlos.proyecto1;

//import com.carlos.proyecto1.ED.*;
import com.carlos.proyecto1.ED.AVL;
import com.carlos.proyecto1.ED.ListaDobleEnlazada;
import com.carlos.proyecto1.ED.ListaDobleEnlazadaCircular;
import com.carlos.proyecto1.ED.MatrizDispersa;
import com.carlos.proyecto1.ED.Nodo;
import com.carlos.proyecto1.ED.NodoArbol;
import com.carlos.proyecto1.Exepciones.CloneNodeException;
import com.carlos.proyecto1.Exepciones.InvalidIndexException;
import com.carlos.proyecto1.Exepciones.InvalidStructureException;
import com.carlos.proyecto1.Graficacion.GraficarImagen;
import com.carlos.proyecto1.UI.FramePrincipal;
import java.util.logging.Level;
import java.util.logging.Logger;

public class main {

    public static void main(String[] args) {
        
       FramePrincipal principal = new FramePrincipal();
        
         /*
        try {
            GraficarImagen imagen = new GraficarImagen();
            MatrizDispersa matriz = new MatrizDispersa();
            matriz.agregarNodo(1, 1, "#FF0303");
            matriz.agregarNodo(2, 1, "#FF0303");
            matriz.agregarNodo(3, 1, "#03FFA3");
            matriz.agregarNodo(5, 1, "#03FFA3");
            matriz.agregarNodo(1, 4, "#FF0303");
            matriz.agregarNodo(3, 5, "#03FFA3");
            matriz.agregarNodo(2, 5, "#FF0303");
            matriz.agregarNodo(5, 3, "#03FFA3");
            
            System.out.println(imagen.obtenerImagen(matriz));
            
        } catch (InvalidIndexException ex) {
            System.out.println(ex.getMessage());
        } catch (CloneNodeException ex) {
            System.out.println(ex.getMessage());
        } catch (InvalidStructureException ex) {
            System.out.println(ex.getMessage());
        }
        */

    }

}
