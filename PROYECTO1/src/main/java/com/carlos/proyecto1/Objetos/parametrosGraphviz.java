package com.carlos.proyecto1.Objetos;

public class parametrosGraphviz {
    private String modeloNodo;
    private String declaraciones;
    private String relaciones;

    public parametrosGraphviz() {
        this.modeloNodo="";
        this.declaraciones="";
        this.relaciones="";
    }
    
    public void agregarDeclaracion(String declaracion){
        this.declaraciones = this.declaraciones + declaracion+"\n";
    }
    public void agregarRelacion(String relacion){
        this.relaciones = this.relaciones + relacion +"\n";
    }
    public void agregarModelo(String modelo){
        this.modeloNodo = this.modeloNodo + modelo +"\n";
    }

    public String getModeloNodo() {
        return modeloNodo;
    }

    public String getDeclaraciones() {
        return declaraciones;
    }

    public String getRelaciones() {
        return relaciones;
    }
    
}
