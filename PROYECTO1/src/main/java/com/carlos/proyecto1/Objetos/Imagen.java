package com.carlos.proyecto1.Objetos;

import com.carlos.proyecto1.ED.ListaEnlazada;

public class Imagen {
    private int id;
    private ListaEnlazada capas;

    public Imagen() {
    }

    public Imagen(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ListaEnlazada getCapas() {
        return capas;
    }

    public void setCapas(ListaEnlazada capas) {
        this.capas = capas;
    }

    @Override
    public String toString() {
        return "Imagen{" + "id=" + id + ", capas=" + capas + '}';
    }
    
}
