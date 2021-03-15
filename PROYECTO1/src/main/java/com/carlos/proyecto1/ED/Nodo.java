package com.carlos.proyecto1.ED;

public class Nodo {
    private int index;
    private Object contenido;
    
    private Nodo anterior;
    private Nodo siguiente;

    public Nodo() {
    }

    public Nodo(int index, Object contenido) {
        this.index = index;
        this.contenido = contenido;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Object getContenido() {
        return contenido;
    }

    public void setContenido(Object contenido) {
        this.contenido = contenido;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "nodoLista{" + "index=" + index + ", contenido=" + contenido + ", anterior=" + anterior + ", siguiente=" + siguiente + '}';
    }
}
