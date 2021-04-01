package com.carlos.proyecto1.Objetos;

import com.carlos.proyecto1.ED.MatrizDispersa;

public class Capa {
    private String id;
    private MatrizDispersa contenido;

    public Capa() {
        
    }

    public Capa(String id, MatrizDispersa contenido) {
        this.id = id;
        this.contenido = contenido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MatrizDispersa getContenido() {
        return contenido;
    }

    public void setContenido(MatrizDispersa contenido) {
        this.contenido = contenido;
    }
    
    @Override
    public String toString() {
        return "Capa{" + "id=" + id + '}';
    }
}
