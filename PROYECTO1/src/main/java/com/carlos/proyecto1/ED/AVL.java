package com.carlos.proyecto1.ED;

import com.carlos.proyecto1.Exepciones.CloneNodeException;
import com.carlos.proyecto1.Exepciones.NotFoundNodeException;
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
    private int cantidad = 0;

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

                if (padre.getDerecha() != null) {
                    factor = this.alturaArbol(padre.getDerecha().getDerecha()) - this.alturaArbol(padre.getDerecha().getIzquierda());
                    padre.getDerecha().setFactorEquilibrio(factor);
                }

                if (((padre.getDerecha() == null) ? 1 : padre.getDerecha().getFactorEquilibrio()) < 0) {
                    System.out.println("Vuelta doble izquierda");
                    this.vueltaDobleIzquierda(padre);

                } else {
                    System.out.println("Vuelta simple izquierda");
                    this.vueltaSimpleIzquierda(padre);
                }
            } else if (factor == -2) {
                System.out.println("El nodo: " + padre.getTag() + " necesita balanceo a la izquierda");

                if (padre.getIzquierda() != null) {
                    factor = this.alturaArbol(padre.getIzquierda().getDerecha()) - this.alturaArbol(padre.getIzquierda().getIzquierda());
                    padre.getIzquierda().setFactorEquilibrio(factor);
                }

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
                if (padre.getDerecha() != null) {
                    factor = this.alturaArbol(padre.getDerecha().getDerecha()) - this.alturaArbol(padre.getDerecha().getIzquierda());
                    padre.getDerecha().setFactorEquilibrio(factor);
                }
                if (((padre.getDerecha() == null) ? 1 : padre.getDerecha().getFactorEquilibrio()) < 0) {
                    System.out.println("Vuelta doble izquierda");
                    this.vueltaDobleIzquierda(padre);
                } else {
                    System.out.println("Vuelta simple izquierda");
                    this.vueltaSimpleIzquierda(padre);
                }

            } else if (factor == -2) {
                System.out.println("El nodo: " + padre.getTag() + " necesita balanceo a la izquierda");
                if (padre.getIzquierda() != null) {
                    factor = this.alturaArbol(padre.getIzquierda().getDerecha()) - this.alturaArbol(padre.getIzquierda().getIzquierda());
                    padre.getIzquierda().setFactorEquilibrio(factor);
                }
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
     *
     * @return
     */
    public Object[] AVLtoArrayInOrden() {
        Object array[] = new Object[this.cantidad + 1];
        Cola data = new Cola();

        this.recuperarDataInOrden(this.raiz, data);
        int cont = 0;
        while (!data.isEmpty()) {
            array[cont] = data.tomar();
            cont++;
        }
        return array;
    }

    /**
     * Recupera los datos del arbol de manera Post Orden
     *
     * @return
     */
    public Object[] AVLtoArrayPostOrden() {
        Object array[] = new Object[this.cantidad + 1];
        Cola data = new Cola();

        this.recuperarDataPostOrden(this.raiz, data);
        int cont = 0;
        while (!data.isEmpty()) {
            array[cont] = data.tomar();
            cont++;
        }
        return array;
    }

    /**
     * Recupera los datos del Arbol de manera Pre Orden
     *
     * @return
     */
    public Object[] AVLtoArrayPreOrden() {
        Object array[] = new Object[this.cantidad + 1];
        Cola data = new Cola();

        this.recuperarDataPreOrden(this.raiz, data);
        int cont = 0;
        while (!data.isEmpty()) {
            array[cont] = data.tomar();
            cont++;
        }
        return array;
    }

    private void recuperarDataInOrden(NodoArbol nodo, Cola data) {
        if (nodo.getIzquierda() != null) {
            this.recuperarDataInOrden(nodo.getIzquierda(), data);
        }
        data.agregar(nodo.getContenido());
        if (nodo.getDerecha() != null) {
            this.recuperarDataInOrden(nodo.getDerecha(), data);
        }

    }

    private void recuperarDataPostOrden(NodoArbol nodo, Cola data) {
        if (nodo.getIzquierda() != null) {
            this.recuperarDataPostOrden(nodo.getIzquierda(), data);
        }
        if (nodo.getDerecha() != null) {
            this.recuperarDataPostOrden(nodo.getDerecha(), data);
        }
        data.agregar(nodo.getContenido());
    }

    private void recuperarDataPreOrden(NodoArbol nodo, Cola data) {
        data.agregar(nodo.getContenido());
        if (nodo.getIzquierda() != null) {
            this.recuperarDataPreOrden(nodo.getIzquierda(), data);
        }
        if (nodo.getDerecha() != null) {
            this.recuperarDataPreOrden(nodo.getDerecha(), data);
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

    /**
     * Metodo publico que recibe solamente el tag del arbol
     *
     * @param tag
     */
    public void eliminar(String tag) throws NotFoundNodeException {
        this.eliminar(this.raiz, tag);
    }

    private void eliminar(NodoArbol nodo, String tag) throws NotFoundNodeException {
        NodoArbol candidato = null;
        if (nodo == null) {
            throw new NotFoundNodeException("No existe un nodo con tag \"" + tag + "\"");
        } else if (nodo.getTag().equals(tag)) {

            if (nodo == this.raiz) {
                NodoArbol izquierdo = nodo.getIzquierda();
                NodoArbol derecha = nodo.getDerecha();

                if (nodo.getIzquierda() == null && nodo.getDerecha() == null) {

                    System.out.println("Eliminacion simple");
                    this.raiz = candidato;
                    this.cantidad--;

                } else if (nodo.getIzquierda() == null && nodo.getDerecha() != null) {

                    System.out.println("Se hace cambia por el nodo derecho del eliminado");
                    candidato = nodo.getDerecha();
                    candidato.setPadre(null);
                    this.raiz = candidato;
                    System.out.println("Se elimino con exito el nodo: " + tag);
                    this.cantidad--;

                } else if (nodo.getIzquierda() != null && nodo.getDerecha() == null) {
                    System.out.println("Buscados el ultimo nodo a la derecha del lado izquierdo");
                    candidato = this.recupearUltimoDerecha(this.raiz.getIzquierda());
                    System.out.println("Candidato remplazo: " + candidato.getTag());
                    //Actualizamos los nodos de izquierda y derecha del eliminado
                    izquierdo = nodo.getIzquierda();
                    derecha = nodo.getDerecha();
                    candidato.setDerecha(derecha);
                    candidato.setIzquierda(izquierdo);
                    this.raiz = candidato;
                    System.out.println("Se elimino con exito el nodo: " + tag);
                    this.cantidad--;

                } else if (nodo.getIzquierda() != null && nodo.getDerecha() != null) {
                    System.out.println("Buscados el ultimo nodo a la derecha del lado izquierdo");
                    candidato = this.recupearUltimoDerecha(this.raiz.getIzquierda());
                    System.out.println("Candidato remplazo: " + candidato.getTag());
                    //Actualizamos los nodos de izquierda y derecha del eliminado
                    izquierdo = nodo.getIzquierda();
                    derecha = nodo.getDerecha();
                    candidato.setDerecha(derecha);
                    candidato.setIzquierda(izquierdo);
                    this.raiz = candidato;
                    System.out.println("Se elimino con exito el nodo: " + tag);
                    this.cantidad--;
                }
            } else {
                System.out.println("Encontre el nodo a eliminar: " + tag);
                NodoArbol padre = nodo.getPadre();
                NodoArbol izquierdo = nodo.getIzquierda();
                NodoArbol derecha = nodo.getDerecha();

                if (nodo.getIzquierda() == null && nodo.getDerecha() == null) {
                    System.out.println("Eliminacion simple");
                    if (padre.getIzquierda() == nodo) {
                        padre.setIzquierda(null);
                        nodo.setPadre(null);
                        System.out.println("Se elimino con exito el nodo: " + tag);
                        this.cantidad--;
                    } else if (padre.getDerecha() == nodo) {
                        padre.setDerecha(null);
                        nodo.setPadre(null);
                        System.out.println("Se elimino con exito el nodo: " + tag);
                        this.cantidad--;
                    }
                } else if (nodo.getIzquierda() == null && nodo.getDerecha() != null) {
                    System.out.println("Se hace cambia por el nodo derecho del eliminado");
                    if (padre.getIzquierda() == nodo) {
                        nodo.setPadre(null);
                        padre.setIzquierda(derecha);
                        System.out.println("Se elimino con exito el nodo: " + tag);
                        this.cantidad--;
                    } else if (padre.getDerecha() == nodo) {
                        nodo.setPadre(null);
                        padre.setDerecha(derecha);
                        System.out.println("Se elimino con exito el nodo: " + tag);
                        this.cantidad--;
                    }
                } else if (nodo.getIzquierda() != null && nodo.getDerecha() == null) {
                    System.out.println("Buscados el ultimo nodo a la derecha del lado izquierdo");
                    candidato = this.recupearUltimoDerecha(nodo.getIzquierda());
                    System.out.println("Candidato remplazo: " + candidato.getTag());
                    //Actualizamos los nodos de izquierda y derecha del eliminado
                    izquierdo = nodo.getIzquierda();
                    derecha = nodo.getDerecha();
                    if (padre.getIzquierda()==(nodo)) {
                        nodo.setPadre(null);
                        padre.setIzquierda(candidato);
                        candidato.setDerecha(derecha);
                        candidato.setIzquierda(izquierdo);
                        System.out.println("Se elimino con exito el nodo: " + tag);
                        this.cantidad--;
                    } else if (padre.getDerecha()==(nodo)) {
                        nodo.setPadre(null);
                        padre.setDerecha(candidato);
                        candidato.setDerecha(derecha);
                        candidato.setIzquierda(izquierdo);
                        System.out.println("Se elimino con exito el nodo: " + tag);
                        this.cantidad--;
                    }
                } else if (nodo.getIzquierda() != null && nodo.getDerecha() != null) {
                    System.out.println("Buscados el ultimo nodo a la derecha del lado izquierdo");
                    candidato = this.recupearUltimoDerecha(nodo.getIzquierda());
                    System.out.println("Candidato remplazo: " + candidato.getTag());
                    //Actualizamos los nodos de izquierda y derecha del eliminado
                    izquierdo = nodo.getIzquierda();
                    derecha = nodo.getDerecha();
                    if (padre.getIzquierda()==(nodo)) {
                        nodo.setPadre(null);
                        padre.setIzquierda(candidato);
                        candidato.setDerecha(derecha);
                        candidato.setIzquierda(izquierdo);
                        System.out.println("Se elimino con exito el nodo: " + tag);
                        this.cantidad--;
                    } else if (padre.getDerecha()==(nodo)) {
                        nodo.setPadre(null);
                        padre.setDerecha(candidato);
                        candidato.setDerecha(derecha);
                        candidato.setIzquierda(izquierdo);
                        System.out.println("Se elimino con exito el nodo: " + tag);
                        this.cantidad--;
                    }
                }
            }

            if (candidato != null) {
                int factor = this.alturaArbol(candidato.getDerecha()) - this.alturaArbol(candidato.getIzquierda());
                System.out.println("Factor de nodo: " + candidato.getTag() + " es: " + factor);

                if (factor == 2) {
                    System.out.println("El nodo: " + candidato.getTag() + " necesita balanceo a la derecha");
                    if (candidato.getDerecha() != null) {
                        factor = this.alturaArbol(candidato.getDerecha().getDerecha()) - this.alturaArbol(candidato.getDerecha().getIzquierda());
                        candidato.getDerecha().setFactorEquilibrio(factor);
                    }
                    if (((candidato.getDerecha() == null) ? 1 : candidato.getDerecha().getFactorEquilibrio()) < 0) {
                        System.out.println("Vuelta doble izquierda");
                        this.vueltaDobleIzquierda(candidato);
                    } else {
                        System.out.println("Vuelta simple izquierda");
                        this.vueltaSimpleIzquierda(candidato);
                    }

                } else if (factor == -2) {
                    System.out.println("El nodo: " + candidato.getTag() + " necesita balanceo a la izquierda");
                    if (candidato.getIzquierda() != null) {
                        factor = this.alturaArbol(candidato.getIzquierda().getDerecha()) - this.alturaArbol(candidato.getIzquierda().getIzquierda());
                        candidato.getIzquierda().setFactorEquilibrio(factor);
                    }
                    if (((candidato.getIzquierda() == null) ? -1 : candidato.getIzquierda().getFactorEquilibrio()) > 0) {
                        System.out.println("Vuelta doble derecha");
                        this.vueltaDobleDerecha(candidato);
                    } else {
                        System.out.println("Vuelta simple derecha");
                        this.vueltaSimpleDerecha(candidato);
                    }
                }

            }

        } else if (tag.compareTo(nodo.getTag()) > 0) {
            this.eliminar(nodo.getDerecha(), tag);
            int factor = this.alturaArbol(nodo.getDerecha()) - this.alturaArbol(nodo.getIzquierda());
            System.out.println("Factor de nodo: " + nodo.getTag() + " es: " + factor);
            if (factor == 2) {
                System.out.println("El nodo: " + nodo.getTag() + " necesita balanceo a la derecha");
                if (nodo.getDerecha() != null) {
                    factor = this.alturaArbol(nodo.getDerecha().getDerecha()) - this.alturaArbol(nodo.getDerecha().getIzquierda());
                    nodo.getDerecha().setFactorEquilibrio(factor);
                }
                if (((nodo.getDerecha() == null) ? 1 : nodo.getDerecha().getFactorEquilibrio()) < 0) {
                    System.out.println("Vuelta doble izquierda");
                    this.vueltaDobleIzquierda(nodo);
                } else {
                    System.out.println("Vuelta simple izquierda");
                    this.vueltaSimpleIzquierda(nodo);
                }

            } else if (factor == -2) {
                System.out.println("El nodo: " + nodo.getTag() + " necesita balanceo a la izquierda");
                if (nodo.getIzquierda() != null) {
                    factor = this.alturaArbol(nodo.getIzquierda().getDerecha()) - this.alturaArbol(nodo.getIzquierda().getIzquierda());
                    nodo.getIzquierda().setFactorEquilibrio(factor);
                }
                if (((nodo.getIzquierda() == null) ? -1 : nodo.getIzquierda().getFactorEquilibrio()) > 0) {
                    System.out.println("Vuelta doble derecha");
                    this.vueltaDobleDerecha(nodo);
                } else {
                    System.out.println("Vuelta simple derecha");
                    this.vueltaSimpleDerecha(nodo);
                }
            }
        } else if (tag.compareTo(nodo.getTag()) < 0) {
            this.eliminar(nodo.getIzquierda(), tag);
            int factor = this.alturaArbol(nodo.getDerecha()) - this.alturaArbol(nodo.getIzquierda());
            System.out.println("Factor de nodo: " + nodo.getTag() + " es: " + factor);
            if (factor == 2) {
                System.out.println("El nodo: " + nodo.getTag() + " necesita balanceo a la derecha");
                if (nodo.getDerecha() != null) {
                    factor = this.alturaArbol(nodo.getDerecha().getDerecha()) - this.alturaArbol(nodo.getDerecha().getIzquierda());
                    nodo.getDerecha().setFactorEquilibrio(factor);
                }
                if (((nodo.getDerecha() == null) ? 1 : nodo.getDerecha().getFactorEquilibrio()) < 0) {
                    System.out.println("Vuelta doble izquierda");
                    this.vueltaDobleIzquierda(nodo);
                } else {
                    System.out.println("Vuelta simple izquierda");
                    this.vueltaSimpleIzquierda(nodo);
                }

            } else if (factor == -2) {
                System.out.println("El nodo: " + nodo.getTag() + " necesita balanceo a la izquierda");
                if (nodo.getIzquierda() != null) {
                    factor = this.alturaArbol(nodo.getIzquierda().getDerecha()) - this.alturaArbol(nodo.getIzquierda().getIzquierda());
                    nodo.getIzquierda().setFactorEquilibrio(factor);
                }
                if (((nodo.getIzquierda() == null) ? -1 : nodo.getIzquierda().getFactorEquilibrio()) > 0) {
                    System.out.println("Vuelta doble derecha");
                    this.vueltaDobleDerecha(nodo);
                } else {
                    System.out.println("Vuelta simple derecha");
                    this.vueltaSimpleDerecha(nodo);
                }
            }
        } else {
            throw new NotFoundNodeException("No existe un nodo con tag \"" + tag + "\"");
        }
    }

    private NodoArbol recupearUltimoDerecha(NodoArbol nodo) {
        if (nodo.getDerecha() == null) {
            NodoArbol padre = nodo.getPadre();
            if (padre.getDerecha() == nodo) {
                padre.setDerecha(nodo.getIzquierda());
            } else if (padre.getIzquierda() == nodo) {
                padre.setIzquierda(nodo.getIzquierda());
            }
            return nodo;
        } else {
            return this.recupearUltimoDerecha(nodo.getDerecha());
        }
    }

    public boolean isEmpty() {
        if (this.raiz == null) {
            return true;
        } else {
            return false;
        }
    }
}
