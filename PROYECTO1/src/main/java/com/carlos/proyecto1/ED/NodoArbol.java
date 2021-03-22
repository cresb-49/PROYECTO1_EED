package com.carlos.proyecto1.ED;

public class NodoArbol {

    private String tag;
    private Object contenido;

    private NodoArbol padre;
    private NodoArbol izquierda;
    private NodoArbol derecha;

    public NodoArbol() {
    }

    public NodoArbol(String tag, Object contenido) {
        this.tag = tag;
        this.contenido = contenido;
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

    public NodoArbol getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoArbol izquierda) {
        this.izquierda = izquierda;
    }

    public NodoArbol getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoArbol derecha) {
        this.derecha = derecha;
    }

    public NodoArbol getPadre() {
        return padre;
    }

    public void setPadre(NodoArbol padre) {
        this.padre = padre;
    }
    
    public String imprimirNodo(){
        return "{" + "tag=" + tag + ", contenido=" + contenido +", padre="+((padre==null)?"null":padre.getTag())+'}';
    }

    @Override
    public String toString() {
        return "NodoArbol{" + "tag=" + tag + ", contenido=" + contenido + ", padre=" + padre + ", izquierda=" + izquierda + ", derecha=" + derecha + '}';
    }

}
