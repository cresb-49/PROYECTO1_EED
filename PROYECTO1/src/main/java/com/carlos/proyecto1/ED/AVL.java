package com.carlos.proyecto1.ED;

/**
 * CLASE ARBOL BINARIO DE BUSQUEDA, ESTABLECE LAS ACCIONES DE LOS OBJETOS
 * NodoArbol
 *
 * @author benjamin
 */
public class AVL {

    private NodoArbol raiz;

    public AVL() {
    }

    public AVL(NodoArbol raiz) {
        this.raiz = raiz;
    }

    public void agregar(NodoArbol nodo) {
        if (this.raiz == null) {
            this.raiz = nodo;
        } else {
            this.agregarNodo(this.raiz, nodo);
        }
    }

    private void agregarNodo(NodoArbol padre, NodoArbol nuevo) {
        if (nuevo.getTag().compareTo(padre.getTag()) > 0) {
            if (padre.getDerecha() == null) {
                padre.setDerecha(nuevo);
                nuevo.setPadre(padre);
            } else {
                this.agregarNodo(padre.getDerecha(), nuevo);
            }
            int factor = this.alturaArbol(padre.getDerecha()) - this.alturaArbol(padre.getIzquierda());
            padre.setFactorEquilibrio(factor);
            if (factor == 2) {
                //System.out.println("El nodo: " + padre.getTag() + " necesita balanceo a la derecha");
                this.vueltaSimpleDerecha(padre);

                if (((padre.getDerecha() == null) ? 1 : padre.getDerecha().getFactorEquilibrio()) < 0) {
                    //System.out.println("Vuelta doble derecha");
                } else {
                    //System.out.println("Vuelta simple derecha");
                }
            }
            if (factor == -2) {
                //System.out.println("El nodo: " + padre.getTag() + " necesita balanceo a la izquierda");
                this.vueltaSimpleIzquierda(padre);
                if (((padre.getDerecha() == null) ? -1 : padre.getDerecha().getFactorEquilibrio()) > 0) {
                    //System.out.println("Vuelta doble izquierda");
                } else {
                    //System.out.println("Vuelta simple izquierda");
                }
            }
        } else if (nuevo.getTag().compareTo(padre.getTag()) < 0) {
            if (padre.getIzquierda() == null) {
                padre.setIzquierda(nuevo);
                nuevo.setPadre(padre);
            } else {
                this.agregarNodo(padre.getIzquierda(), nuevo);
            }

            int factor = this.alturaArbol(padre.getDerecha()) - this.alturaArbol(padre.getIzquierda());
            if (factor == 2) {
                //System.out.println("El nodo: " + padre.getTag() + " necesita balanceo a la derecha");
                this.vueltaSimpleDerecha(padre);
            }
            if (factor == -2) {
                //System.out.println("El nodo: " + padre.getTag() + " necesita balanceo a la izquierda");
                this.vueltaSimpleIzquierda(padre);
            }
        } else {
            System.out.println("Ya existe un nodo con el mismo tag");
        }
    }

    private void vueltaSimpleDerecha(NodoArbol nodo) {
        NodoArbol tmp, tmp2;
        if (nodo.equals(this.raiz)) {
            tmp = this.raiz;
            tmp2 = tmp.getDerecha().getIzquierda();
            this.raiz = tmp.getDerecha();
            this.raiz.setPadre(null);
            this.raiz.setIzquierda(tmp);
            tmp.setDerecha(tmp2);
            tmp.setPadre(this.raiz);
            if (tmp2 != null) {
                tmp2.setPadre(tmp);
            }
        } else {
            NodoArbol padre = nodo.getPadre();
            tmp = nodo.getDerecha();
            tmp2 = tmp.getIzquierda();
            padre.setDerecha(tmp);
            tmp.setPadre(padre);
            tmp.setIzquierda(nodo);
            nodo.setPadre(tmp);
            nodo.setDerecha(tmp2);
            if (tmp2 != null) {
                tmp2.setPadre(nodo);
            }
        }
    }

    private void vueltaSimpleIzquierda(NodoArbol nodo) {
        NodoArbol tmp, tmp2;
        if (nodo.equals(this.raiz)) {
            tmp = this.raiz;
            tmp2 = tmp.getIzquierda().getDerecha();
            this.raiz = tmp.getIzquierda();
            this.raiz.setPadre(null);
            this.raiz.setDerecha(tmp);
            tmp.setIzquierda(tmp2);
            tmp.setPadre(this.raiz);
            if (tmp2 != null) {
                tmp2.setPadre(tmp);
            }
        } else {
            NodoArbol padre = nodo.getPadre();
            tmp = nodo.getIzquierda();
            tmp2 = tmp.getDerecha();
            padre.setIzquierda(tmp);
            tmp.setPadre(padre);
            tmp.setDerecha(nodo);
            nodo.setPadre(tmp);
            nodo.setIzquierda(tmp2);
            if (tmp2 != null) {
                tmp2.setPadre(nodo);
            }
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

}
