package com.carlos.proyecto1.ED;

public class Cola {
    private Nodo raiz;

    /**
     * Inicializa la cola vacia
     */
    public Cola(){

    }

    /**
     * Inicializa la cola con un objeto
     * @param objeto
     */
    public Cola(Object objeto){
        Nodo nuevo = new Nodo(objeto);
        this.raiz = nuevo;
    }
    
    public void agregar(Object objeto){
        Nodo nuevo = new Nodo(objeto);
        if(raiz == null){
            this.raiz = nuevo;
        }else{
            this.agregarNodo(this.raiz, nuevo);
        }
    }

    private void agregarNodo(Nodo referencia,Nodo nuevo){
        if(referencia.getSiguiente()==null){
            referencia.setSiguiente(nuevo);
        }else{
            this.agregarNodo(referencia.getSiguiente(), nuevo);
        }
    }

    public Object tomar(){
        if(raiz==null){
            return null;
        }else{
            Nodo tmp = raiz;
            raiz = tmp.getSiguiente();
            Object cont = tmp.getContenido();
            tmp=null;
            return cont;
        }
    }

    /**
     * Retorna el inicio de la cola sin sacarlo
     * @return
     */
    public Object inicio(){
        return this.raiz.getContenido();
    }

    public void imprimirCola(){
        if(raiz==null){
            System.out.println("Cola vacia");
        }else{
            System.out.println("-----------------------");
            Nodo tmp = raiz;
            while (tmp!=null) {
                System.out.println(tmp.getContenido().toString());
                tmp = tmp.getSiguiente();
            }
            System.out.println("-----------------------");
        }
    }
    
}
