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
import com.carlos.proyecto1.Objetos.parametrosGraphviz;
import com.carlos.proyecto1.UI.FramePrincipal;
import java.util.logging.Level;
import java.util.logging.Logger;

public class main {

    public static void main(String[] args) {
        
       FramePrincipal principal = new FramePrincipal();
       
       /*
        try {
            MatrizDispersa matirz = new MatrizDispersa();
            
            matirz.agregarNodo(1, 1, "color");
            matirz.agregarNodo(2, 2, "color");
            matirz.agregarNodo(3, 3, "color");
            matirz.agregarNodo(4, 4, "color");
            matirz.agregarNodo(5, 5, "color");
            
            matirz.imprimirEncabezadosX();
            matirz.imprimirEncabezadosY();
            
            /*
            Se ingreso con exito el valor en la coordenada (1,1) en la matriz
            Se ingreso con exito el valor en la coordenada (2,2) en la matriz
            Se ingreso con exito el valor en la coordenada (3,3) en la matriz
            Se ingreso con exito el valor en la coordenada (4,4) en la matriz
            Se ingreso con exito el valor en la coordenada (5,5) en la matriz
            *//*
                
        } catch (Exception e) {
            e.printStackTrace();
        }
       
       
       /*
        try {
            AVL avl = new AVL();
            
            avl.agregar(new NodoArbol("userY","userY"));
            avl.agregar(new NodoArbol("userA","userA"));
            avl.agregar(new NodoArbol("userB","userB"));
            avl.agregar(new NodoArbol("userM","userM"));
            
            
            avl.agregar(new NodoArbol("40","40"));
            avl.agregar(new NodoArbol("50","50"));
            avl.agregar(new NodoArbol("20","20"));
            avl.agregar(new NodoArbol("60","60"));
            avl.agregar(new NodoArbol("30","30"));
            avl.agregar(new NodoArbol("10","10"));
            avl.agregar(new NodoArbol("15","15"));
            avl.agregar(new NodoArbol("12","12"));
            
            
            
            avl.inOrden();
            parametrosGraphviz g = avl.obtenerGrafico();
            String code = g.getModeloNodo()+g.getDeclaraciones()+g.getRelaciones();
            System.out.println(code);
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       
     
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
