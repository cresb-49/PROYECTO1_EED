package com.carlos.proyecto1.Objetos;

import com.carlos.proyecto1.ED.*;

public class Imagen {
    private String id;
    private ListaDobleEnlazada capas;

    public Imagen() {
    }

    public Imagen(String id, ListaDobleEnlazada capas) {
        this.id = id;
        this.capas = capas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ListaDobleEnlazada getCapas() {
        return capas;
    }

    public void setCapas(ListaDobleEnlazada capas) {
        this.capas = capas;
    }

    @Override
    public String toString() {
        return "Imagen{" + "id=" + id + ", capas=" + capas + '}';
    }
    
}
