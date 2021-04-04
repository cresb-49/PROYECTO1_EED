package com.carlos.proyecto1.ED;

import com.carlos.proyecto1.Exepciones.CloneNodeException;
import com.carlos.proyecto1.Exepciones.InvalidIndexException;
import com.carlos.proyecto1.Exepciones.InvalidStructureException;
import com.carlos.proyecto1.Objetos.parametrosGraphviz;

public class MatrizDispersa {

    NodoMatriz principal;

    private int tamX;
    private int tamY;

    public MatrizDispersa() {
        principal = new NodoMatriz(0, 0, null);
        tamX = 0;
        tamY = 0;
    }

    public NodoMatriz getPrincipal() {
        return principal;
    }

    /**
     * Metodo general para agregar un valor a la matriz dispersa
     *
     * @param X
     * @param Y
     * @param contenido
     */
    public void agregarNodo(int X, int Y, Object contenido) throws InvalidIndexException, CloneNodeException, InvalidStructureException {

        if (X <= 0 || Y <= 0) {
            if (X < 0) {
                throw new InvalidIndexException("No se pueden ingresar un cordenada negativa en X");
            } else if (X == 0) {
                throw new InvalidIndexException("No se pueden ingresar un cordenada X con valor de 0");
            }
            if (Y < 0) {
                throw new InvalidIndexException("No se pueden ingresar un cordenada negativa en Y");
            } else if (Y == 0) {
                throw new InvalidIndexException("No se pueden ingresar un cordenada Y con valor de 0");
            }
        } else {
            NodoMatriz refX = this.existeEncabezadoX(X);
            NodoMatriz refY = this.existeEncabezadoY(Y);

            if (this.existeEncabezadoX(X) == null) {
                this.crearEnbezadoX(X);
                refX = this.existeEncabezadoX(X);
            }
            if (this.existeEncabezadoY(Y) == null) {
                this.crearEnbezadoY(Y);
                refY = this.existeEncabezadoY(Y);
            }

            if (this.buscarY(refX, Y) == null) {
                NodoMatriz nuevo = new NodoMatriz(X, Y, contenido);
                this.insertarX(refX, nuevo);
                this.insertarY(refY, nuevo);
                System.out.println("Se ingreso con exito el valor en la coordenada (" + X + "," + Y + ") en la matriz");
                if (X > tamX) {
                    tamX = X;
                }
                if (Y > tamY) {
                    tamY = Y;
                }

            } else {
                throw new CloneNodeException("Ya existe un valor en la coordenada (" + X + "," + Y + ") en la matriz");
            }

        }
    }

    /**
     * Inserta un nodo en una fila en base a la cabecera de variable X y el
     * nuevo nodo
     *
     * @param cabezaX
     * @param nuevo
     */
    private void insertarX(NodoMatriz cabezaX, NodoMatriz nuevo) throws InvalidStructureException {
        NodoMatriz tmp = cabezaX;

        boolean insertado = false;

        while (tmp.getSiguienteY() != null) {
            if (nuevo.getY() < tmp.getSiguienteY().getY()) {
                if (nuevo.getY() > tmp.getY()) {
                    this.insertarAdelanteY(tmp, nuevo);
                    insertado = true;
                    break;
                } else {
                    throw new InvalidStructureException("Error en formacion de matriz en columnas");
                }
            }
            tmp = tmp.getSiguienteY();
        }
        if (!insertado) {
            insertarAdelanteY(tmp, nuevo);
        }
    }

    /**
     * Inserta un nodo en una fila en base a la cabecera de variable y y el
     * nuevo nodo
     *
     * @param cabezaY
     * @param nuevo
     */
    private void insertarY(NodoMatriz cabezaY, NodoMatriz nuevo) throws InvalidStructureException {
        NodoMatriz tmp = cabezaY;
        boolean insertado = false;

        while (tmp.getSiguienteX() != null) {
            if (nuevo.getX() < tmp.getSiguienteX().getX()) {
                if (nuevo.getX() > tmp.getX()) {
                    this.insertarAdelanteX(tmp, nuevo);
                    insertado = true;
                    break;
                } else {
                    throw new InvalidStructureException("Error en formacion de matriz en filas");
                }
            }
            tmp = tmp.getSiguienteX();
        }
        if (!insertado) {
            insertarAdelanteX(tmp, nuevo);
        }
    }

    /**
     * Retorna el encabezado de una columna, devuelve null si no existe dicho
     * encabezado
     *
     * @param X
     * @return
     */
    private NodoMatriz existeEncabezadoX(int X) {

        NodoMatriz tmp = this.principal;

        while (tmp != null) {
            if (tmp.getX() == X) {
                return tmp;
            }
            tmp = tmp.getSiguienteX();
        }

        return null;
    }

    /**
     * Retorna el encabezado de una fila, devuelve null si no existe dicho
     * encabezado
     *
     * @param Y
     * @return
     */
    private NodoMatriz existeEncabezadoY(int Y) {

        NodoMatriz tmp = this.principal;

        while (tmp != null) {

            if (tmp.getY() == Y) {
                return tmp;
            }
            tmp = tmp.getSiguienteY();
        }

        return null;
    }

    /**
     * Crea el encabezado en la variable X de la matriz dispersa
     *
     * @param X
     */
    private void crearEnbezadoX(int X) {
        NodoMatriz tmp = this.principal;
        boolean insertado = false;

        while (tmp.getSiguienteX() != null) {
            if (X < tmp.getSiguienteX().getX()) {
                if (X > tmp.getX()) {
                    this.insertarAdelanteX(tmp, new NodoMatriz(X, 0, null));
                    insertado = true;
                    break;
                } else {
                    System.out.println("Error en matriz eje X");
                }
            }
            tmp = tmp.getSiguienteX();
        }
        if (!insertado) {
            insertarAdelanteX(tmp, new NodoMatriz(X, 0, null));
        }

    }

    /**
     * Crea el encabezado en la variable Y de la matriz dispersa
     *
     * @param Y
     */
    private void crearEnbezadoY(int Y) {
        NodoMatriz tmp = this.principal;
        boolean insertado = false;

        while (tmp.getSiguienteY() != null) {
            if (Y < tmp.getSiguienteY().getY()) {
                if (Y > tmp.getY()) {
                    this.insertarAdelanteY(tmp, new NodoMatriz(0, Y, null));
                    insertado = true;
                    break;
                } else {
                    System.out.println("Error en matriz eje Y");
                }
            }
            tmp = tmp.getSiguienteY();
        }
        if (!insertado) {
            insertarAdelanteY(tmp, new NodoMatriz(0, Y, null));
        }

    }

    /**
     * Inserta un nodo adelante de nodo base en X
     *
     * @param nodo
     * @param nuevo
     */
    private void insertarAdelanteX(NodoMatriz nodo, NodoMatriz nuevo) {
        NodoMatriz nodoSig = nodo.getSiguienteX();
        nodo.setSiguienteX(nuevo);
        nuevo.setAnteriorX(nodo);
        nuevo.setSiguienteX(nodoSig);

        if (nodoSig != null) {
            nodoSig.setAnteriorX(nuevo);
        }

    }

    /**
     * Inserta un nodo delante del nodo base en Y
     *
     * @param nodo nodo base
     * @param nuevo nuevo nodo
     */
    private void insertarAdelanteY(NodoMatriz nodo, NodoMatriz nuevo) {
        NodoMatriz nodoSig = nodo.getSiguienteY();
        nodo.setSiguienteY(nuevo);
        nuevo.setAnteriorY(nodo);
        nuevo.setSiguienteY(nodoSig);

        if (nodoSig != null) {
            nodoSig.setAnteriorY(nuevo);
        }

    }

    /**
     * Imprime los encabezados de la variable X
     */
    public void imprimirEncabezadosX() {
        NodoMatriz tmp = this.principal;
        System.out.println("----------X-----------");

        do {
            System.out.print(tmp.getX());
            tmp = tmp.getSiguienteX();

            if (tmp != null) {
                System.out.print(" , ");
            } else {
                System.out.println("");
            }

        } while (tmp != null);

        System.out.println("-----------X----------");
    }

    /**
     * Imprime los encabezados de la variable Y
     */
    public void imprimirEncabezadosY() {
        NodoMatriz tmp = this.principal;
        System.out.println("----------Y-----------");

        do {
            System.out.print(tmp.getY());
            tmp = tmp.getSiguienteY();

            if (tmp != null) {
                System.out.print(" , ");
            } else {
                System.out.println("");
            }

        } while (tmp != null);

        System.out.println("-----------Y----------");
    }

    /**
     * Obtiene el contenido de la matriz en al cordenada x y asignada Devolvera
     * nulo si no hay contenido adentro
     *
     * @param X
     * @param Y
     * @return
     */
    public Object buscar(int X, int Y) {
        NodoMatriz tmp = this.existeEncabezadoX(X);
        if (tmp == null) {
            return null;
        } else {
            tmp = this.buscarY(tmp, Y);
            return ((tmp == null) ? null : tmp.getContenido());
        }
    }

    /**
     * Retorna el valro del nodo cabecera en Y
     *
     * @param cabezaX
     * @param Y
     * @return
     */
    private NodoMatriz buscarY(NodoMatriz cabezaX, int Y) {
        NodoMatriz tmp = cabezaX;
        while (tmp != null) {
            if (tmp.getY() == Y) {
                return tmp;
            }
            tmp = tmp.getSiguienteY();
        }
        return null;
    }

    /**
     * Retorna el largo de la matriz en coredena X
     *
     * @return
     */
    public int getTamX() {
        return tamX;
    }

    /**
     * Retorna el largo de la matriz en cordendad Y
     *
     * @return
     */
    public int getTamY() {
        return tamY;
    }

    /**
     * Obtiene un copia exacta de los valores que contiene la matriz
     *
     * @return
     */
    public MatrizDispersa obtenerCopia() throws CloneNodeException, InvalidStructureException, InvalidIndexException {
        MatrizDispersa copia = new MatrizDispersa();

        NodoMatriz tmp = this.principal.getSiguienteX();
        NodoMatriz tmp2 = null;

        while (tmp != null) {
            tmp2 = tmp.getSiguienteY();
            while (tmp2 != null) {
                copia.agregarNodo(tmp2.getX(), tmp2.getY(), tmp2.getContenido());
                tmp2 = tmp2.getSiguienteY();
            }
            tmp = tmp.getSiguienteX();
        }
        return copia;
    }

    /**
     * Este metodo toma otra matriz dispersa y sobre escribe la matriz en la
     * cual se ejecuta el metodo
     *
     * @param matriz
     */
    public void mergeMatriz(MatrizDispersa matriz) throws InvalidStructureException {
        NodoMatriz tmp = matriz.getPrincipal().getSiguienteX();
        NodoMatriz tmp2 = null;

        while (tmp != null) {
            tmp2 = tmp.getSiguienteY();
            while (tmp2 != null) {
                this.ingresarNodo(tmp2.getX(), tmp2.getY(), tmp2.getContenido());
                tmp2 = tmp2.getSiguienteY();
            }
            tmp = tmp.getSiguienteX();
        }
    }

    /**
     * Este metodo toma los valores de cordenadas y contenido y sobreescribe la
     * matriz Se utiliza en el metodo de mergeMatriz
     *
     * @param X
     * @param Y
     * @param contenido
     */
    private void ingresarNodo(int X, int Y, Object contenido) throws InvalidStructureException {
        NodoMatriz refX = this.existeEncabezadoX(X);
        NodoMatriz refY = this.existeEncabezadoY(Y);

        if (this.existeEncabezadoX(X) == null) {
            this.crearEnbezadoX(X);
            refX = this.existeEncabezadoX(X);
        }
        if (this.existeEncabezadoY(Y) == null) {
            this.crearEnbezadoY(Y);
            refY = this.existeEncabezadoY(Y);
        }

        NodoMatriz nodoMa = this.buscarY(refX, Y);

        if (nodoMa == null) {
            NodoMatriz nuevo = new NodoMatriz(X, Y, contenido);
            this.insertarX(refX, nuevo);
            this.insertarY(refY, nuevo);
            System.out.println("Se imgreso con exito el valor en la coordenada (" + X + "," + Y + ") en la matriz");
            if (X > tamX) {
                tamX = X;
            }
            if (Y > tamY) {
                tamY = Y;
            }
        } else {
            nodoMa.setContenido(contenido);
            System.out.println("Sobre escribi el nodo (" + X + "," + Y + ") en la matriz");
        }
    }

    public parametrosGraphviz obtenerGrafico() {
        parametrosGraphviz params = new parametrosGraphviz();
        params.agregarModelo("node [shape=box];\n");
        this.generarDot(params);
        return params;
    }

    private void generarDot(parametrosGraphviz params) {
        NodoMatriz tmp = this.principal;
        NodoMatriz tmp2 = null;
        do {
            params.agregarDeclaracion("C" + tmp.getX() + "" + tmp.getY() + "[ label = \"" + ((tmp.getContenido() == null) ? tmp.getX() + "," + tmp.getY() : tmp.getContenido()) + "\", width = 1.5, group = " + (tmp.getX() + 1) + " ];");
            if (tmp.getAnteriorX() != null) {
                params.agregarRelacion("C" + tmp.getX() + "" + tmp.getY() + " -> C" + tmp.getAnteriorX().getX() + "" + tmp.getAnteriorX().getY() + ";");
            }
            if (tmp.getSiguienteX() != null) {
                params.agregarRelacion("C" + tmp.getX() + "" + tmp.getY() + " -> C" + tmp.getSiguienteX().getX() + "" + tmp.getSiguienteX().getY() + ";");
            }
            if (tmp.getAnteriorY() != null) {
                params.agregarRelacion("C" + tmp.getX() + "" + tmp.getY() + " -> C" + tmp.getAnteriorY().getX() + "" + tmp.getAnteriorY().getY() + ";");
            }
            if (tmp.getSiguienteY() != null) {
                params.agregarRelacion("C" + tmp.getX() + "" + tmp.getY() + " -> C" + tmp.getSiguienteY().getX() + "" + tmp.getSiguienteY().getY() + ";");
            }
            params.agregarConfRank("C" + tmp.getX() + "" + tmp.getY() + ";");
            tmp2 = tmp.getSiguienteX();
            do {
                params.agregarDeclaracion("C" + tmp2.getX() + "" + tmp2.getY() + "[ label = \"" + ((tmp2.getContenido() == null) ? tmp2.getX() + "," + tmp2.getY() : tmp2.getContenido()) + "\", width = 1.5, group = " + (tmp2.getX() + 1) + " ];");
                if (tmp2.getAnteriorX() != null) {
                    params.agregarRelacion("C" + tmp2.getX() + "" + tmp2.getY() + " -> C" + tmp2.getAnteriorX().getX() + "" + tmp2.getAnteriorX().getY() + ";");
                }
                if (tmp2.getSiguienteX() != null) {
                    params.agregarRelacion("C" + tmp2.getX() + "" + tmp2.getY() + " -> C" + tmp2.getSiguienteX().getX() + "" + tmp2.getSiguienteX().getY() + ";");
                }
                if (tmp2.getAnteriorY() != null) {
                    params.agregarRelacion("C" + tmp2.getX() + "" + tmp2.getY() + " -> C" + tmp2.getAnteriorY().getX() + "" + tmp2.getAnteriorY().getY() + ";");
                }
                if (tmp2.getSiguienteY() != null) {
                    params.agregarRelacion("C" + tmp2.getX() + "" + tmp2.getY() + " -> C" + tmp2.getSiguienteY().getX() + "" + tmp2.getSiguienteY().getY() + ";");
                }
                params.agregarConfRank("C" + tmp2.getX() + "" + tmp2.getY() + ";");
                tmp2 = tmp2.getSiguienteX();
            } while (tmp2 != null);
            params.agregarRankReiniciar();

            tmp = tmp.getSiguienteY();
        } while (tmp != null);
    }
}
