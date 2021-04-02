package com.carlos.proyecto1.Graficacion;

import com.carlos.proyecto1.ED.ListaDobleEnlazadaCircular;
import com.carlos.proyecto1.ED.Pila;
import com.carlos.proyecto1.Objetos.parametrosGraphviz;

public class obtenerGraficoImagenes {
    public String GraficoImagenes(ListaDobleEnlazadaCircular listaImagenes){
        if(listaImagenes!=null){
            if(!listaImagenes.isEmpty()){
                parametrosGraphviz graph = listaImagenes.obtenerGrafico();
                String rank ="";
                Pila tmp = graph.getRanks();
                while (!tmp.isEmpty()) {                    
                    rank = rank + (String)tmp.pop();
                }
                
                String subsGraphs = "";
                
                subsGraphs = listaImagenes.obtenerGraficoCapas();
                
                return "subgraph {\n"+ graph.getModeloNodo()+graph.getDeclaraciones()+rank+graph.getRelaciones()+"}\n"+subsGraphs;
            }
        }
        return null;
    }
}
