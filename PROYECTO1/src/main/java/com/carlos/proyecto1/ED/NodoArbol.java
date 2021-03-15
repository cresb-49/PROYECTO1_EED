package com.carlos.proyecto1.ED;

public class NodoArbol {

    private int asignacion;
    private Object contenido;

    private NodoArbol izquierda;
    private NodoArbol derecha;

    public NodoArbol() {
    }

    public NodoArbol(int asignacion, Object contenido) {
        this.asignacion = asignacion;
        this.contenido = contenido;
    }

    public int getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(int asignacion) {
        this.asignacion = asignacion;
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

    public void agregarNodo(NodoArbol nodo) {
        if (nodo.getAsignacion()>this.asignacion) {
            if (this.derecha == null) {
                this.derecha = nodo;
            } else {
                this.derecha.agregarNodo(nodo);
            }
        } else {
            if (this.izquierda == null) {
                this.izquierda = nodo;
            } else {
                this.izquierda.agregarNodo(nodo);
            }
        }
    }
    
    public NodoArbol buscarNodo(int asignacion){
        NodoArbol tmp=null;
        if(this.asignacion == asignacion){
            tmp =this;
        }else{
            if(asignacion>this.asignacion){
                if(this.derecha!=null){
                    tmp = this.derecha.buscarNodo(asignacion);
                }
            }else{
                if(this.izquierda!=null){
                    tmp = this.izquierda.buscarNodo(asignacion);
                }
            }
        }
        return tmp;
    }
    

    @Override
    public String toString() {
        return "NodoArbol{" + "asignacion=" + asignacion + ", contenido=" + contenido + ", izquierda=" + izquierda + ", derecha=" + derecha + '}';
    }
}
