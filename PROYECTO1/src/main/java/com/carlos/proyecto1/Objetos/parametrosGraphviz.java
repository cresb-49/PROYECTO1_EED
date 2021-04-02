package com.carlos.proyecto1.Objetos;

import com.carlos.proyecto1.ED.Pila;

public class parametrosGraphviz {
    private String modeloNodo;
    private String declaraciones;
    private String relaciones;
    private String rank;
    private Pila ranks;

    public parametrosGraphviz() {
        this.modeloNodo="";
        this.declaraciones="";
        this.relaciones="";
        this.rank="{ rank = same;";
        ranks = new Pila();
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
    
    public void agregarConfRank(String nodo){
        this.rank = this.rank + nodo;
    }
    
    public void agregarRankReiniciar(){
        this.rank = this.rank +"}\n";
        ranks.push(this.rank);
        this.rank="{ rank = same;";
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

    public Pila getRanks() {
        return ranks;
    }
    
    
}
