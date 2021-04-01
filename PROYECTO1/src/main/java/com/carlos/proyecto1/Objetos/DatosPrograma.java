package com.carlos.proyecto1.Objetos;

import com.carlos.proyecto1.ED.*;

public class DatosPrograma {
    private AVL arbolCapas;
    private ListaDobleEnlazadaCircular imagenes;
    private AVL usuarios;
    
    public DatosPrograma() {
        this.arbolCapas = new AVL();
        this.imagenes = new ListaDobleEnlazadaCircular();
        this.usuarios = new AVL();
    }

    public AVL getArbolCapas() {
        return arbolCapas;
    }

    public void setArbolCapas(AVL arbolCapas) {
        this.arbolCapas = arbolCapas;
    }

    public ListaDobleEnlazadaCircular getImagenes() {
        return imagenes;
    }

    public void setImagenes(ListaDobleEnlazadaCircular imagenes) {
        this.imagenes = imagenes;
    }

    public AVL getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(AVL usuarios) {
        this.usuarios = usuarios;
    }
}
