package com.carlos.proyecto1.ED;

public class ListaDobleEnlazada {

    private Nodo raiz;

    public ListaDobleEnlazada() {
    }

    public ListaDobleEnlazada(Nodo raiz) {
        this.raiz = raiz;
    }

    public void agregar(Nodo nuevo) {
        if (this.raiz == null) {
            this.raiz = nuevo;
        } else {
            if (this.buscar(nuevo.getTag()) == null) {
                Nodo tmp = this.raiz;
                while (tmp != null) {
                    if (tmp.getSiguiente() == null) {
                        tmp.setSiguiente(nuevo);
                        nuevo.setAnterior(tmp);
                    }
                    tmp = tmp.getSiguiente();
                }
            } else {
                System.out.println("Ya existe un elemento con tag: " + nuevo.getTag());
            }
        }
    }

    public Nodo buscar(String tag) {
        Nodo tmp = this.raiz;
        if (tmp != null) {
            while (tmp != null) {
                if (tmp.getTag().equals(tag)) {
                    return tmp;
                }
                tmp = tmp.getSiguiente();
            }
        }
        return null;
    }

    public void eliminar(String tag) {

        if (this.buscar(tag) != null) {
            Nodo tmp = this.raiz;
            boolean eliminado = false;
            while (!eliminado) {

                if (tmp.getTag().equals(tag)) {
                    if (tmp == this.raiz) {
                        Nodo ant = this.raiz.getAnterior();
                        Nodo sig = this.raiz.getSiguiente();
                        sig.setAnterior(ant);
                        this.raiz = sig;
                    } else {
                        Nodo ant = tmp.getAnterior();
                        Nodo sig = tmp.getSiguiente();
                        ant.setSiguiente(sig);
                        sig.setAnterior(ant);
                    }
                }

                tmp = tmp.getSiguiente();
            }
        } else {
            System.out.println("No existe un elemento con tag: " + tag);
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

}
