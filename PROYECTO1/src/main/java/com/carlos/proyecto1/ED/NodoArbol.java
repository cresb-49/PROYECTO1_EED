package com.carlos.proyecto1.ED;

public class NodoArbol {

    private String tag;
    private Object contenido;

    private NodoArbol padre;
    private NodoArbol izquierda;
    private NodoArbol derecha;
    
    private int factorEquilibrio;

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
        if(this.izquierda !=null){
            this.izquierda.setPadre(this);
        }
    }

    public NodoArbol getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoArbol derecha) {
        this.derecha = derecha;
        if(this.derecha!=null){
            this.derecha.setPadre(this);
        }
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

    public int getFactorEquilibrio() {
        return factorEquilibrio;
    }

    public void setFactorEquilibrio(int factorEquilibrio) {
        this.factorEquilibrio = factorEquilibrio;
    }

    @Override
    public String toString() {
        return "NodoArbol{" + "tag=" + tag + ", contenido=" + contenido + ", padre=" + padre + ", izquierda=" + izquierda + ", derecha=" + derecha + ", factorEquilibrio=" + factorEquilibrio + '}';
    }
    
    

}
