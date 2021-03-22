package com.carlos.proyecto1;

//import com.carlos.proyecto1.ED.*;
import com.carlos.proyecto1.ED.AVL;
import com.carlos.proyecto1.ED.NodoArbol;
import com.carlos.proyecto1.UI.FramePrincipal;

public class main {

    public static void main(String[] args) {
        //FramePrincipal principal = new FramePrincipal();
        AVL arbol = new AVL();
        
        
        arbol.agregar(new NodoArbol("4","4"));
        arbol.preOrden();
        arbol.agregar(new NodoArbol("5","5"));
        arbol.preOrden();
        arbol.agregar(new NodoArbol("6","6"));
        arbol.preOrden();
        arbol.agregar(new NodoArbol("7","7"));
        arbol.preOrden();
        arbol.agregar(new NodoArbol("8","8"));
        arbol.preOrden();
        arbol.agregar(new NodoArbol("9","9"));
        arbol.preOrden();
        arbol.agregar(new NodoArbol("3","3"));
        arbol.preOrden();
        arbol.agregar(new NodoArbol("2","2"));
        arbol.preOrden();
        arbol.agregar(new NodoArbol("1","1"));
        arbol.preOrden();
        /*
        arbol.agregar(nodo4);
        arbol.agregar(nodo5);
        arbol.agregar(nodo6);
        
        
        arbol.inOrden();
        arbol.postOrden();
        arbol.preOrden();
         */
    }

}
