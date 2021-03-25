package com.carlos.proyecto1.ED;

public class Nodo {
    private String tag;
    private Object contenido;
    
    private Nodo anterior;
    private Nodo siguiente;

    public Nodo() {
    }

    public Nodo(String tag, Object contenido) {
        this.tag = tag;
        this.contenido = contenido;
    }

    public Nodo(Object contenido){
        this.contenido=contenido;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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
    
    public String imprimirNodo(){
        return "Nodo{" + "tag=" + tag + ", contenido=" + contenido + ", anterior=" + anterior.getTag() + ", siguiente=" + siguiente.getTag() + '}';
    }
    
    public String imprimirNodoSimple(){
        return "Nodo{" + "tag=" + tag + ", contenido=" + contenido + ", siguiente=" + ((siguiente ==null)?"null":siguiente.getTag()) + '}';
    }

    @Override
    public String toString() {
        return "Nodo{" + "tag=" + tag + ", contenido=" + contenido + ", anterior=" + anterior + ", siguiente=" + siguiente + '}';
    }

    
}
