package com.carlos.proyecto1.Objetos;

import com.carlos.proyecto1.ED.ListaDobleEnlazada;

public class usuario {
    private String user;
    private ListaDobleEnlazada imagenes;

    public usuario() {
    }

    public usuario(String user) {
        this.user = user;
    }

    public usuario(String user, ListaDobleEnlazada imagenes) {
        this.user = user;
        this.imagenes = imagenes;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public ListaDobleEnlazada getImagenes() {
        return imagenes;
    }

    public void setImagenes(ListaDobleEnlazada imagenes) {
        this.imagenes = imagenes;
    }

    @Override
    public String toString() {
        return "usuario{" + "user=" + user + ", imagenes=" + imagenes + '}';
    }
}
