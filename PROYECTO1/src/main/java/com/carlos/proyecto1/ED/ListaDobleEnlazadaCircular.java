package com.carlos.proyecto1.ED;

import com.carlos.proyecto1.Exepciones.CloneNodeException;
import com.carlos.proyecto1.Exepciones.NotFoundNodeException;
import com.carlos.proyecto1.Objetos.Capa;
import com.carlos.proyecto1.Objetos.Imagen;
import com.carlos.proyecto1.Objetos.parametrosGraphviz;

public class ListaDobleEnlazadaCircular {

    private Nodo raiz;

    public ListaDobleEnlazadaCircular() {
    }

    /**
     * Agrega los objetos en orden en base al index del nodo
     *
     * @param nuevo
     */
    public void addOrden(Nodo nuevo) throws CloneNodeException{
        if (raiz == null) {
            raiz = nuevo;
            raiz.setSiguiente(raiz);
            raiz.setAnterior(raiz);
        } else {
            Nodo busqueda = this.buscar(nuevo.getTag());
            if (busqueda == null) {
                Nodo tmp = raiz;
                boolean insertado = false;
                do {
                    if (nuevo.getTag().compareTo(tmp.getSiguiente().getTag()) < 0) {
                        if (nuevo.getTag().compareTo(tmp.getTag()) > 0) {
                            insertarAdelante(tmp, nuevo);
                            insertado = true;
                            break;
                        } else if (nuevo.getTag().compareTo(tmp.getTag()) < 0) {
                            insertarPrimero(nuevo);
                            insertado = true;
                            break;
                        }
                    }
                    tmp = tmp.getSiguiente();
                } while (tmp != this.raiz);

                if (!insertado) {
                    insertarUltimo(nuevo);
                }
            } else {
                throw new CloneNodeException("Ya existe elemento con la etiqueta: " + nuevo.getTag());
            }

        }
    }
    
    public boolean isEmpty(){
        if(this.raiz==null){
            return true;
        }else{
            return false;
        }
    }
    
    private void insertarAdelante(Nodo base, Nodo nuevo) {
        Nodo tmp = base.getSiguiente();
        base.setSiguiente(nuevo);
        nuevo.setAnterior(base);
        nuevo.setSiguiente(tmp);
        tmp.setAnterior(nuevo);
    }

    private void insertarPrimero(Nodo nuevo) {
        nuevo.setSiguiente(this.raiz);
        nuevo.setAnterior(this.raiz.getAnterior());
        this.raiz.getAnterior().setSiguiente(nuevo);
        this.raiz.setAnterior(nuevo);
        this.raiz = nuevo;
    }

    private void insertarUltimo(Nodo nuevo) {
        Nodo ant = this.raiz.getAnterior();
        nuevo.setSiguiente(this.raiz);
        nuevo.setAnterior(ant);
        ant.setSiguiente(nuevo);
        this.raiz.setAnterior(nuevo);
    }

    public void imprimir() {
        Nodo tmp = this.raiz;
        System.out.println("--------------------------");
        do {
            System.out.println(tmp.imprimirNodo());
            tmp = tmp.getSiguiente();
        } while (tmp != this.raiz);
        System.out.println("--------------------------");
    }

    public Nodo buscar(String tag) {
        Nodo tmp2 = this.raiz;
        if (tmp2 != null) {
            do {
                if (tmp2.getTag().equals(tag)) {
                    return tmp2;
                }
                tmp2 = tmp2.getSiguiente();
            } while (tmp2 != this.raiz);
        }
        return null;
    }

    public void eliminar(String tag) throws NotFoundNodeException{
        if (this.buscar(tag) != null) {
            boolean eliminado = false;
            Nodo tmp = this.raiz;
            do {
                if (tmp.getTag().equals(tag)) {
                    if (tmp == this.raiz) {
                        Nodo ant = this.raiz.getAnterior();
                        Nodo sig = this.raiz.getSiguiente();
                        ant.setSiguiente(sig);
                        sig.setAnterior(ant);
                        this.raiz = sig;
                        eliminado = true;
                    } else {
                        Nodo ant = tmp.getAnterior();
                        Nodo sig = tmp.getSiguiente();
                        ant.setSiguiente(sig);
                        sig.setAnterior(ant);
                        eliminado = true;
                    }
                }
                tmp = tmp.getSiguiente();
            } while (!eliminado);
        } else {
            throw new NotFoundNodeException("No existe un elemento con el tag: " + tag);
        }
    }
    
    public parametrosGraphviz obtenerGrafico() {
        parametrosGraphviz params = new parametrosGraphviz();
        params.agregarModelo("node[shape = box,height=.1];");
        if (this.raiz != null) {
            this.GenerarDot(params, this.raiz);
        }
        return params;
    }
    
    private void GenerarDot(parametrosGraphviz parametros,Nodo nodo){
        String name ="";
        String tagNode = "";
        do {
            
            if(nodo.getContenido() instanceof Imagen){
                name = "Imagen";
                name = name + ((Imagen)nodo.getContenido()).getId();
                tagNode = "IMG";
            }
            parametros.agregarDeclaracion("nodeLC"+tagNode+ nodo.getTag() + "[label = \"" + name + "\",group=1];");
            parametros.agregarConfRank("nodeLC"+tagNode+ nodo.getTag()+";");
            parametros.agregarRelacion("\"nodeLC"+tagNode+ nodo.getTag()+"\" -> \"nodeLC"+tagNode+ nodo.getSiguiente().getTag()+"\";");
            parametros.agregarRelacion("\"nodeLC"+tagNode+ nodo.getTag()+"\" -> \"nodeLC"+tagNode+ nodo.getAnterior().getTag()+"\";");
            
            
            nodo = nodo.getSiguiente();
        } while (nodo!=this.raiz);
        parametros.agregarRankReiniciar();
        
    }
    
    
    
    public String obtenerGraficoCapas() {
        parametrosGraphviz params = new parametrosGraphviz();
        if (this.raiz != null) {
            return this.GenerarDotCapas(this.raiz);
        }
        return "";
    }
    
    private String GenerarDotCapas(Nodo nodo){
        String tmpCode = "";
        parametrosGraphviz paramsTmp;
                
        do {
            
            if(nodo.getContenido() instanceof Imagen){
                ListaDobleEnlazada tmpCapa = ((Imagen)nodo.getContenido()).getCapas();
                
                if(!tmpCapa.isEmpty()){
                    paramsTmp = tmpCapa.obtenerGrafico(nodo.getTag());
                    Nodo tmpNodo = tmpCapa.getRaiz();
                    paramsTmp.agregarRelacion("\"nodeLC"+"IMG"+ nodo.getTag()+"\" -> \"nodeLED"+nodo.getTag()+"CP"+ tmpNodo.getTag()+"\";");
                    paramsTmp.agregarRankReiniciar();
                    tmpCode  = tmpCode + "subgraph {\n"+ paramsTmp.getModeloNodo()+paramsTmp.getDeclaraciones()+paramsTmp.getRelaciones()+"}\n";
                }
            }
            
            nodo = nodo.getSiguiente();
        } while (nodo!=this.raiz);
        
        return tmpCode;
    }
    
    
    
}
