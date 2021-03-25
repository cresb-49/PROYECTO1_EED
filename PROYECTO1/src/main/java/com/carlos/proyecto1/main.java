package com.carlos.proyecto1;

//import com.carlos.proyecto1.ED.*;
import com.carlos.proyecto1.ED.AVL;
import com.carlos.proyecto1.ED.ListaDobleEnlazadaCircular;
import com.carlos.proyecto1.ED.Nodo;
import com.carlos.proyecto1.ED.NodoArbol;
import com.carlos.proyecto1.UI.FramePrincipal;

public class main {

    public static void main(String[] args) {
        //FramePrincipal principal = new FramePrincipal();
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
        
        
    }

}
