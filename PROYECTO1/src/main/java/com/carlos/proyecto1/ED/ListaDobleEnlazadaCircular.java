package com.carlos.proyecto1.ED;

public class ListaDobleEnlazadaCircular {

    private Nodo raiz;

    public ListaDobleEnlazadaCircular() {
    }

    /**
     * Agrega los objetos en orden en base al index del nodo
     *
     * @param nuevo
     */
    public void addOrden(Nodo nuevo) {
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
                System.out.println("Ya existe elemento con la etiqueta: " + nuevo.getTag());
            }

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

    public void eliminar(String tag) {
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
            System.out.println("No existe un elemento con el tag: " + tag);
        }
    }
}
