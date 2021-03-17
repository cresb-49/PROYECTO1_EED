package com.carlos.proyecto1.ED;

public class ListaDobleEnlazadaCircular {
    private Nodo raiz;

    public ListaDobleEnlazadaCircular() {
    }
    
    /**
     * Agrega los objetos en orden en base al index del nodo
     * @param nuevo 
     */
    public void addOrden(Nodo nuevo){
        if(raiz==null){
            raiz = nuevo;
            raiz.setSiguiente(raiz);
            raiz.setAnterior(raiz);
        }else{
            Nodo temp = raiz;
            while (temp.getSiguiente()!=raiz) {                
                if(!(nuevo.getIndex()<temp.getIndex())){
                    this.insertarDerecha(temp, nuevo);
                    break;
                }
            }
            if(temp.getSiguiente()==raiz){
                this.insertarDerecha(temp, nuevo);
            }
        }
    }
    
    private void insertarDerecha(Nodo antiguo,Nodo nuevo){
        Nodo antiguo_Sig = antiguo.getSiguiente();
        nuevo.setAnterior(antiguo);
        antiguo.setSiguiente(nuevo);
        antiguo_Sig.setAnterior(nuevo);
    }
}
