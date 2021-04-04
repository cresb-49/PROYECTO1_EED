package com.carlos.proyecto1.ED;

import com.carlos.proyecto1.Exepciones.CloneNodeException;
import com.carlos.proyecto1.Objetos.Capa;
import com.carlos.proyecto1.Objetos.parametrosGraphviz;
import com.carlos.proyecto1.Objetos.usuario;

/**
 * CLASE ARBOL BINARIO DE BUSQUEDA, ESTABLECE LAS ACCIONES DE LOS OBJETOS
 * NodoArbol
 *
 * @author benjamin
 */
public class AVL {

    private NodoArbol raiz;
    private int cantidad=0;

    public AVL() {
    }

    public AVL(NodoArbol raiz) {
        this.raiz = raiz;
    }

    public int getCantidad() {
        return cantidad;
    }
    
    public void agregar(NodoArbol nodo) throws CloneNodeException {
        if (this.raiz == null) {
            this.raiz = nodo;
            System.out.println("Se agrego con exito el dato con tag: " + nodo.getTag());
        } else {
            this.agregarNodo(this.raiz, nodo);
        }
    }

    private void agregarNodo(NodoArbol padre, NodoArbol nuevo) throws CloneNodeException {
        if (nuevo.getTag().compareTo(padre.getTag()) > 0) {

            if (padre.getDerecha() == null) {
                padre.setDerecha(nuevo);
                nuevo.setPadre(padre);
                System.out.println("Se agrego con exito el dato con tag: " + nuevo.getTag());
                this.cantidad++;
            } else {
                this.agregarNodo(padre.getDerecha(), nuevo);
            }

            int factor = this.alturaArbol(padre.getDerecha()) - this.alturaArbol(padre.getIzquierda());
            padre.setFactorEquilibrio(factor);
            if (factor == 2) {

                System.out.println("El nodo: " + padre.getTag() + " necesita balanceo a la derecha");
                if (((padre.getDerecha() == null) ? 1 : padre.getDerecha().getFactorEquilibrio()) < 0) {
                    System.out.println("Vuelta doble izquierda");
                    this.vueltaDobleIzquierda(padre);

                } else {
                    System.out.println("Vuelta simple izquierda");
                    this.vueltaSimpleIzquierda(padre);
                }
            }else if (factor == -2) {
                System.out.println("El nodo: " + padre.getTag() + " necesita balanceo a la izquierda");

                if (((padre.getIzquierda() == null) ? -1 : padre.getIzquierda().getFactorEquilibrio()) > 0) {
                    System.out.println("Vuelta doble derecha");
                    this.vueltaDobleDerecha(padre);
                } else {
                    System.out.println("Vuelta simple derecha");
                    this.vueltaSimpleDerecha(padre);
                }

            }

        } else if (nuevo.getTag().compareTo(padre.getTag()) < 0) {

            if (padre.getIzquierda() == null) {
                padre.setIzquierda(nuevo);
                nuevo.setPadre(padre);
                System.out.println("Se agrego con exito el dato con tag: " + nuevo.getTag());
                this.cantidad++;
            } else {
                this.agregarNodo(padre.getIzquierda(), nuevo);
            }

            int factor = this.alturaArbol(padre.getDerecha()) - this.alturaArbol(padre.getIzquierda());
            padre.setFactorEquilibrio(factor);
            
            if (factor == 2) {
                System.out.println("El nodo: " + padre.getTag() + " necesita balanceo a la derecha");
                if (((padre.getDerecha() == null) ? 1 : padre.getDerecha().getFactorEquilibrio()) < 0) {
                    System.out.println("Vuelta doble izquierda");
                    this.vueltaDobleIzquierda(padre);
                } else {
                    System.out.println("Vuelta simple izquierda");
                    this.vueltaSimpleIzquierda(padre);
                }

            }else if (factor == -2) {
                System.out.println("El nodo: " + padre.getTag() + " necesita balanceo a la izquierda");
                if (((padre.getIzquierda() == null) ? -1 : padre.getIzquierda().getFactorEquilibrio()) > 0) {
                    System.out.println("Vuelta doble derecha");
                    this.vueltaDobleDerecha(padre);
                } else {
                    System.out.println("Vuelta simple derecha");
                    this.vueltaSimpleDerecha(padre);
                }
            }

        } else {
            throw new CloneNodeException("Ya existe un nodo con tag: " + nuevo.getTag());
        }
    }

    private void vueltaDobleDerecha(NodoArbol nodo) {
        if (nodo == this.raiz) {
            NodoArbol nuevaRaiz = this.raiz.getIzquierda().getDerecha();

            NodoArbol b = this.raiz.getIzquierda();
            NodoArbol IC = nuevaRaiz.getIzquierda();
            NodoArbol DC = nuevaRaiz.getDerecha();

            nuevaRaiz.setDerecha(this.raiz);
            nuevaRaiz.setIzquierda(b);

            b.setDerecha(IC);
            this.raiz.setIzquierda(DC);
            nuevaRaiz.setPadre(null);
            this.raiz = nuevaRaiz;

        } else {
            NodoArbol P = nodo.getPadre();

            NodoArbol b = nodo.getIzquierda();
            NodoArbol c = b.getDerecha();
            NodoArbol IC = c.getIzquierda();
            NodoArbol DC = c.getDerecha();

            if (P.getDerecha() == nodo) {
                P.setDerecha(c);
            } else {
                P.setIzquierda(c);
            }

            c.setIzquierda(b);
            c.setDerecha(nodo);
            b.setDerecha(IC);
            nodo.setIzquierda(DC);

        }
    }

    private void vueltaDobleIzquierda(NodoArbol nodo) {
        if (nodo == this.raiz) {
            NodoArbol nuevaRaiz = this.raiz.getDerecha().getIzquierda();
            
            NodoArbol b = this.raiz.getDerecha();
            NodoArbol IC = nuevaRaiz.getIzquierda();
            NodoArbol DC = nuevaRaiz.getDerecha();
            
            nuevaRaiz.setDerecha(b);
            nuevaRaiz.setIzquierda(this.raiz);
            
            b.setIzquierda(DC);
            this.raiz.setDerecha(IC);
            
            nuevaRaiz.setPadre(null);
            this.raiz = nuevaRaiz;
            
        } else {
            NodoArbol P = nodo.getPadre();
            
            NodoArbol b = nodo.getDerecha();
            NodoArbol c = b.getIzquierda();
            
            NodoArbol IC = c.getIzquierda();
            NodoArbol DC = c.getDerecha();
            
            if (P.getDerecha() == nodo) {
                P.setDerecha(c);
            } else {
                P.setIzquierda(c);
            }
            
            c.setDerecha(b);
            c.setIzquierda(nodo);
            b.setIzquierda(DC);
            nodo.setDerecha(IC);
        }
    }

    private void vueltaSimpleDerecha(NodoArbol nodo) {

        if (nodo == this.raiz) {
            NodoArbol nuevaRaiz = this.raiz.getIzquierda();
            nuevaRaiz.setPadre(null);
            NodoArbol a = nuevaRaiz.getDerecha();
            this.raiz.setIzquierda(a);
            nuevaRaiz.setDerecha(this.raiz);
            this.raiz = nuevaRaiz;
        } else {
            NodoArbol P = nodo.getPadre();
            NodoArbol b = nodo.getIzquierda();
            NodoArbol e = b.getDerecha();

            if (P.getDerecha() == nodo) {
                P.setDerecha(b);
            } else {
                P.setIzquierda(b);
            }
            
            b.setDerecha(nodo);
            nodo.setIzquierda(e);
        }
    }

    private void vueltaSimpleIzquierda(NodoArbol nodo) {

        if (nodo == this.raiz) {
            NodoArbol nuevaRaiz = this.raiz.getDerecha();
            nuevaRaiz.setPadre(null);
            NodoArbol a = nuevaRaiz.getIzquierda();
            this.raiz.setDerecha(a);
            nuevaRaiz.setIzquierda(this.raiz);
            this.raiz = nuevaRaiz;
        } else {
            NodoArbol P = nodo.getPadre();
            NodoArbol b = nodo.getDerecha();
            NodoArbol e = b.getIzquierda();
            
            if (P.getDerecha() == nodo) {
                P.setDerecha(b);
            } else {
                P.setIzquierda(b);
            }
            
            b.setIzquierda(nodo);
            nodo.setDerecha(e);
        }
    }

    private int alturaArbol(NodoArbol nodo) {
        int izquierda = 0, derecha = 0;
        if (nodo != null) {
            if (nodo.getIzquierda() != null) {
                izquierda = alturaArbol(nodo.getIzquierda());
            }
            if (nodo.getDerecha() != null) {
                derecha = alturaArbol(nodo.getDerecha());
            }
            return ((izquierda < derecha) ? derecha : izquierda) + 1;
        }
        return 0;
    }

    public NodoArbol buscarNodo(String tag) {
        NodoArbol nodo = null;
        nodo = this.buscarNodo(this.raiz, tag);
        return nodo;
    }

    private NodoArbol buscarNodo(NodoArbol nodo, String tag) {
        NodoArbol tmp = null;
        if (nodo != null) {
            if (tag.compareTo(nodo.getTag()) > 0) {
                tmp = this.buscarNodo(nodo.getDerecha(), tag);
            } else if (tag.compareTo(nodo.getTag()) < 0) {
                tmp = this.buscarNodo(nodo.getIzquierda(), tag);
            } else if (tag.compareTo(nodo.getTag()) == 0) {
                tmp = nodo;
            }
        }
        return tmp;
    }

    public void inOrden() {
        this.inOrden(raiz);
        System.out.println("");
    }

    private void inOrden(NodoArbol nodo) {
        if (nodo.getIzquierda() != null) {
            this.inOrden(nodo.getIzquierda());
        }
        System.out.print(nodo.imprimirNodo());
        if (nodo.getDerecha() != null) {
            this.inOrden(nodo.getDerecha());
        }
    }

    public void postOrden() {
        this.postOrden(this.raiz);
        System.out.println("");
    }

    private void postOrden(NodoArbol nodo) {
        if (nodo.getIzquierda() != null) {
            this.postOrden(nodo.getIzquierda());
        }
        if (nodo.getDerecha() != null) {
            this.postOrden(nodo.getDerecha());
        }
        System.out.print(nodo.imprimirNodo());
    }

    public void preOrden() {
        this.preOrden(this.raiz);
        System.out.println("");
    }

    private void preOrden(NodoArbol nodo) {
        System.out.print(nodo.imprimirNodo());
        if (nodo.getIzquierda() != null) {
            this.preOrden(nodo.getIzquierda());
        }
        if (nodo.getDerecha() != null) {
            this.preOrden(nodo.getDerecha());
        }
    }

    public parametrosGraphviz obtenerGrafico() {
        parametrosGraphviz params = new parametrosGraphviz();
        params.agregarModelo("node[shape = record,height=.1];");
        if (this.raiz != null) {
            this.GenerarDot(params, this.raiz);
        }
        return params;
    }
   /**
    * Recupera los datos del arbol de manera In Orden
    * @return 
    */
    public Object[] AVLtoArrayInOrden(){
        Object array [] = new Object[this.cantidad+1];
        Cola data = new Cola();
        
        this.recuperarDataInOrden(this.raiz, data);
        int cont = 0;
        while (!data.isEmpty()) {
            array[cont]=data.tomar();
            cont++;
        }
        return array;
    }
   /**
    * Recupera los datos del arbol de manera Post Orden
    * @return 
    */
    public Object[] AVLtoArrayPostOrden(){
        Object array [] = new Object[this.cantidad+1];
        Cola data = new Cola();
        
        this.recuperarDataPostOrden(this.raiz, data);
        int cont = 0;
        while (!data.isEmpty()) {
            array[cont]=data.tomar();
            cont++;
        }
        return array;
    }
    /**
     * Recupera los datos del Arbol de manera Pre Orden
     * @return 
     */
    public Object[] AVLtoArrayPreOrden(){
        Object array [] = new Object[this.cantidad+1];
        Cola data = new Cola();
        
        this.recuperarDataPreOrden(this.raiz, data);
        int cont = 0;
        while (!data.isEmpty()) {
            array[cont]=data.tomar();
            cont++;
        }
        return array;
    }
    
    private void recuperarDataInOrden(NodoArbol nodo,Cola data) {
        if (nodo.getIzquierda() != null) {
            this.recuperarDataInOrden(nodo.getIzquierda(),data);
        }
        data.agregar(nodo.getContenido());
        if (nodo.getDerecha() != null) {
            this.recuperarDataInOrden(nodo.getDerecha(),data);
        }
        
    }
    
    
    private void recuperarDataPostOrden(NodoArbol nodo,Cola data) {
        if (nodo.getIzquierda() != null) {
            this.recuperarDataPostOrden(nodo.getIzquierda(),data);
        }
        if (nodo.getDerecha() != null) {
            this.recuperarDataPostOrden(nodo.getDerecha(),data);
        }
        data.agregar(nodo.getContenido());
    }
    
    
    private void recuperarDataPreOrden(NodoArbol nodo,Cola data) {
        data.agregar(nodo.getContenido());
        if (nodo.getIzquierda() != null) {
            this.recuperarDataPreOrden(nodo.getIzquierda(),data);
        }
        if (nodo.getDerecha() != null) {
            this.recuperarDataPreOrden(nodo.getDerecha(),data);
        }
    }
    
    
    private void GenerarDot(parametrosGraphviz parametros, NodoArbol nodo) {
        if (nodo.getIzquierda() != null) {
            this.GenerarDot(parametros, nodo.getIzquierda());
        }
        String name = "";

        if (nodo.getContenido() instanceof Capa) {
            name = "capa";
        }

        parametros.agregarDeclaracion("nodeAVL" + nodo.getTag() + "[label = \"<f0> |<f1> " + name + nodo.getTag() + "|<f2> \"];");

        if (nodo.getDerecha() != null) {
            parametros.agregarRelacion("\"nodeAVL" + nodo.getTag() + "\":f2 -> \"nodeAVL" + nodo.getDerecha().getTag() + "\":f1;");
        }
        if (nodo.getIzquierda() != null) {
            parametros.agregarRelacion("\"nodeAVL" + nodo.getTag() + "\":f0 -> \"nodeAVL" + nodo.getIzquierda().getTag() + "\":f1;");
        }

        if (nodo.getDerecha() != null) {
            this.GenerarDot(parametros, nodo.getDerecha());
        }
    }

    private void eliminar(String tag) {

    }

    public boolean isEmpty() {
        if (this.raiz == null) {
            return true;
        } else {
            return false;
        }
    }
}
