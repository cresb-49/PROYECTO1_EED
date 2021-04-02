package com.carlos.proyecto1.Graficacion;

import com.carlos.proyecto1.ED.AVL;
import com.carlos.proyecto1.Objetos.parametrosGraphviz;

public class ObtenerGraficoAVL {

    public ObtenerGraficoAVL() {
    }
    public String GraficoAVL(AVL arbol){
        
        if(arbol!=null){
            if(!arbol.isEmpty()){
                parametrosGraphviz graph = arbol.obtenerGrafico();
                return graph.getModeloNodo() + graph.getDeclaraciones() + graph.getRelaciones();
            }
        }
        return null;
    }
    
}
