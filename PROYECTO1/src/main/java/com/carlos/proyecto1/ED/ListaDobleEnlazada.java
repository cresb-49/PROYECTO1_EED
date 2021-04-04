package com.carlos.proyecto1.ED;

import com.carlos.proyecto1.Exepciones.CloneNodeException;
import com.carlos.proyecto1.Exepciones.NotFoundNodeException;
import com.carlos.proyecto1.Objetos.Capa;
import com.carlos.proyecto1.Objetos.parametrosGraphviz;

public class ListaDobleEnlazada {

    private Nodo raiz;

    public ListaDobleEnlazada() {
    }

    public ListaDobleEnlazada(Nodo raiz) {
        this.raiz = raiz;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void agregar(Nodo nuevo) throws CloneNodeException {
        if (this.raiz == null) {
            this.raiz = nuevo;
        } else {
            if (this.buscar(nuevo.getTag()) == null) {
                Nodo tmp = this.raiz;

                while (tmp != null) {
                    if (tmp.getSiguiente() == null) {
                        tmp.setSiguiente(nuevo);
                        nuevo.setAnterior(tmp);
                        break;
                    }
                    tmp = tmp.getSiguiente();
                }
            } else {
                throw new CloneNodeException("Ya existe un elemento con tag: " + nuevo.getTag());
            }
        }
    }

    public Nodo buscar(String tag) {
        if (this.raiz != null) {
            Nodo tmp = this.raiz;
            if (tmp != null) {
                while (tmp != null) {
                    if (tmp.getTag().equals(tag)) {
                        return tmp;
                    }
                    tmp = tmp.getSiguiente();
                }
            }
        }
        return null;
    }

    public void eliminar(String tag) throws NotFoundNodeException {

        if (this.buscar(tag) != null) {
            Nodo tmp = this.raiz;
            boolean eliminado = false;
            while (!eliminado) {

                if (tmp.getTag().equals(tag)) {
                    if (tmp == this.raiz) {
                        Nodo ant = this.raiz.getAnterior();
                        Nodo sig = this.raiz.getSiguiente();
                        if(sig!=null){
                            sig.setAnterior(ant);
                        }
                        this.raiz = sig;
                        eliminado= true;
                        break;
                    } else {
                        Nodo ant = tmp.getAnterior();
                        Nodo sig = tmp.getSiguiente();
                        ant.setSiguiente(sig);
                        if(sig!=null){
                            sig.setAnterior(ant);
                        }
                        eliminado= true;
                        break;
                    }
                }

                tmp = tmp.getSiguiente();
            }
        } else {
            throw new NotFoundNodeException("No existe un elemento con tag: " + tag);
        }
    }

    public void imprimirLista() {
        Nodo tmp = raiz;
        System.out.println("--------------------------");
        while (tmp != null) {
            System.out.println(tmp.imprimirNodoSimple());
            tmp = tmp.getSiguiente();
        }
        System.out.println("--------------------------");
    }

    public boolean isEmpty() {
        if (this.raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    public parametrosGraphviz obtenerGrafico(String fatherImage) {
        parametrosGraphviz params = new parametrosGraphviz();
        params.agregarModelo("node[shape = ellipse,height=.1];");
        if (this.raiz != null) {
            this.GenerarDot(params, this.raiz,fatherImage);
        }
        return params;
    }

    private void GenerarDot(parametrosGraphviz parametros, Nodo nodo,String fatherImage) {
        String name = "";
        String tagNode = "";
        do {

            if (nodo.getContenido() instanceof Capa) {
                name = "Capa";
                name = name + ((Capa) nodo.getContenido()).getId();
                tagNode = "CP";
            }
            parametros.agregarDeclaracion("nodeLED" +fatherImage+ tagNode + nodo.getTag() + "[label = \"" + name + "\"];");
            if (nodo.getSiguiente() != null) {
                parametros.agregarRelacion("\"nodeLED"+fatherImage + tagNode + nodo.getTag() + "\" -> \"nodeLED"+fatherImage + tagNode + nodo.getSiguiente().getTag() + "\";");
            }
            if (nodo.getAnterior() != null) {
                parametros.agregarRelacion("\"nodeLED"+fatherImage + tagNode + nodo.getTag() + "\" -> \"nodeLED"+fatherImage + tagNode + nodo.getAnterior().getTag() + "\";");
            }

            nodo = nodo.getSiguiente();
        } while (nodo != null);
        parametros.agregarRankReiniciar();
    }

    @Override
    public String toString() {
        return "ListaDobleEnlazada{" + "raiz=" + raiz.imprimirNodo() + '}';
    }
}
