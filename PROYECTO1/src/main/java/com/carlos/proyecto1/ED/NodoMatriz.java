package com.carlos.proyecto1.ED;

public class NodoMatriz {
    private NodoMatriz siguienteX;
    private NodoMatriz anteriorX;
    private NodoMatriz siguienteY;
    private NodoMatriz anteriorY;
    private int X;
    private int Y;
    private Object contenido;

    public NodoMatriz(int X, int Y, Object contenido) {
        this.X = X;
        this.Y = Y;
        this.contenido = contenido;
    }

    public NodoMatriz() {
    }

    public NodoMatriz getSiguienteX() {
        return siguienteX;
    }

    public void setSiguienteX(NodoMatriz siguienteX) {
        this.siguienteX = siguienteX;
    }

    public NodoMatriz getAnteriorX() {
        return anteriorX;
    }

    public void setAnteriorX(NodoMatriz anteriorX) {
        this.anteriorX = anteriorX;
    }

    public NodoMatriz getSiguienteY() {
        return siguienteY;
    }

    public void setSiguienteY(NodoMatriz siguienteY) {
        this.siguienteY = siguienteY;
    }

    public NodoMatriz getAnteriorY() {
        return anteriorY;
    }

    public void setAnteriorY(NodoMatriz anteriorY) {
        this.anteriorY = anteriorY;
    }

    public int getX() {
        return X;
    }

    public void setX(int X) {
        this.X = X;
    }

    public int getY() {
        return Y;
    }

    public void setY(int Y) {
        this.Y = Y;
    }

    public Object getContenido() {
        return contenido;
    }

    public void setContenido(Object contenido) {
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        return "NodoMatriz{" + "siguienteX=" + siguienteX + ", anteriorX=" + anteriorX + ", siguienteY=" + siguienteY + ", anteriorY=" + anteriorY + ", X=" + X + ", Y=" + Y + ", contenido=" + contenido + '}';
    }
}
