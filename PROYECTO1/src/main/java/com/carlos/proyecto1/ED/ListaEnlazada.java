package com.carlos.proyecto1.ED;

import com.carlos.proyecto1.Exepciones.CloneNodeException;

public class ListaEnlazada {

    private Nodo raiz;

    public ListaEnlazada() {

    }

    public void add(Nodo nodo) throws CloneNodeException{

        if (this.buscar(nodo.getTag()) == null) {
            if (raiz == null) {
                raiz = nodo;
            } else {
                Nodo tmp = raiz;
                while (tmp.getSiguiente() != null) {
                    tmp = tmp.getAnterior();
                }
                tmp.setSiguiente(nodo);
            }
        } else {
            throw new CloneNodeException("Ya existe un elemento con la tag: " + nodo.getTag());
        }

    }

    public void imprimirLista() {
        Nodo tmp = raiz;
        System.out.println("--------------------------");
        while (tmp != null) {
            System.out.println(tmp.imprimirNodoSimple());
            tmp = tmp.getSiguiente();
        }
        System.out.println("--------------------------");
    }

    public Nodo buscar(String tag) {
        Nodo tmp = this.raiz;
        if (tmp != null) {
            do {
                if (tmp.getTag().equals(tag)) {
                    return tmp;
                }
                tmp = tmp.getSiguiente();
            } while (tmp != null);
        }
        return null;
    }
}
