package com.carlos.proyecto1.ED;

public class Pila {
    private Nodo raiz;

    /**
     * Estructura de datos que alamacena sin la necesidad de un indice
     * la hacia los datos yace en el nodo
     */
    public Pila(){

    }

    /**
     * Inicializa la pila con un objeto al inicio
     */
    public Pila(Object objeto) {
        Nodo nuevo = new Nodo(objeto);
        this.raiz = nuevo;
    }

    /**
     * Agrega un nuevo objeto a la pila
     * @param objeto Objeto a agregar a la pila
     */
    public void push(Object objeto){
        Nodo nodo = new Nodo(objeto);
        if(this.raiz==null){
            this.raiz=nodo;
        }else{
            nodo.setSiguiente(this.raiz);
            this.raiz = nodo;
        }
    }

    /**
     * Retorna el objeto superior en la pila sin sacarlo
     * @return
     */
    public Object peek(){
        return this.raiz.getContenido();
    }

    /**
     * Retorna el objeto superior en la pila, sacandolo de la pila
     * @return
     */
    public Object pop(){
        Nodo tmp = this.raiz;
        this.raiz=tmp.getSiguiente();
        Object cont = tmp.getContenido();
        tmp=null;
        return cont;
    }

    public void imprimirPila(){
        if(this.raiz==null){

        }else{
            System.out.println("-----------------------");
            Nodo tmp = this.raiz;
            while (tmp!=null) {
                System.out.println(tmp.getContenido().toString());
                tmp = tmp.getSiguiente();
            }
            System.out.println("-----------------------");
        }
    }
}
