package com.carlos.proyecto1;

//import com.carlos.proyecto1.ED.*;
import com.carlos.proyecto1.ED.AVL;
import com.carlos.proyecto1.ED.ListaDobleEnlazadaCircular;
import com.carlos.proyecto1.ED.MatrizDispersa;
import com.carlos.proyecto1.ED.Nodo;
import com.carlos.proyecto1.ED.NodoArbol;
import com.carlos.proyecto1.Exepciones.CloneNodeException;
import com.carlos.proyecto1.Exepciones.InvalidIndexException;
import com.carlos.proyecto1.Exepciones.InvalidStructureException;
import com.carlos.proyecto1.UI.FramePrincipal;
import java.util.logging.Level;
import java.util.logging.Logger;

public class main {

    public static void main(String[] args) {
        
        FramePrincipal principal = new FramePrincipal();
        /*
        try {
            
            
            ListaDobleEnlazadaCircular listaCircularDoble = new ListaDobleEnlazadaCircular();
            
            listaCircularDoble.addOrden(new Nodo("3", "3"));
            listaCircularDoble.imprimir();
            listaCircularDoble.addOrden(new Nodo("1", "1"));
            listaCircularDoble.imprimir();
            listaCircularDoble.addOrden(new Nodo("4", "4"));
            listaCircularDoble.imprimir();
            listaCircularDoble.addOrden(new Nodo("2", "2"));
            listaCircularDoble.imprimir();
            listaCircularDoble.eliminar("2");
            listaCircularDoble.imprimir();
            listaCircularDoble.addOrden(new Nodo("2", "2"));
            listaCircularDoble.imprimir();
            
            
            MatrizDispersa matriz = new MatrizDispersa();
            matriz.agregarNodo(1, 2, "12");
            matriz.agregarNodo(4, 3, "14");
            matriz.agregarNodo(2, 3, "16");
            matriz.agregarNodo(3, 3, "30");
            matriz.agregarNodo(1, 0, "40");

            MatrizDispersa copia = matriz.obtenerCopia();

            MatrizDispersa matriz2 = new MatrizDispersa();
            matriz2.agregarNodo(1, 2, "40");
            matriz2.agregarNodo(4, 3, "14");
            matriz2.agregarNodo(2, 3, "16");
            matriz2.agregarNodo(3, 3, "30");
            matriz2.agregarNodo(1, 1, "12");

            copia.mergeMatriz(matriz2);

            System.out.println("Busqueda: " + copia.buscar(1, 2));
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
