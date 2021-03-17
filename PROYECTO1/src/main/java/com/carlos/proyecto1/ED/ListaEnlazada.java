package com.carlos.proyecto1.ED;

public class ListaEnlazada {
    private Nodo raiz;

    public ListaEnlazada() {
        
    }
    
    public void add(Nodo nodo){
        if(raiz==null){
            raiz=nodo;
        }else{
            Nodo tmp = raiz;
            while (tmp.getSiguiente()!=null) {                
                tmp = tmp.getAnterior();
            }
            tmp.setSiguiente(nodo);
        }
    }
    
    public void imprimirLista(){
        Nodo tmp = raiz;
        System.out.println("--------------------------");
        while (tmp!=null) {            
            System.out.println(tmp.getContenido());
            tmp = tmp.getSiguiente();
        }
        System.out.println("--------------------------");
    }
}
