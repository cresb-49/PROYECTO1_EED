package com.carlos.proyecto1.ED;

/**
 * CLASE ARBOL BINARIO DE BUSQUEDA, ESTABLECE LAS ACCIONES DE LOS OBJETOS NodoArbol
 * @author benjamin
 */
public class ABB {
    private NodoArbol raiz;

    public ABB() {
    }

    public ABB(NodoArbol raiz) {
        this.raiz = raiz;
    }
    
    public void agregarNodo(NodoArbol nodo){
        if(raiz==null){
            raiz=nodo;
        }else{
            raiz.agregarNodo(nodo);
        }
    }
    
    public NodoArbol buscarNodo(int asignacion){
        return raiz.buscarNodo(asignacion);
    }
    
}
