package com.carlos.proyecto1.Graficacion;

import com.carlos.proyecto1.ED.MatrizDispersa;
import com.carlos.proyecto1.ED.Nodo;
import com.carlos.proyecto1.ED.NodoArbol;
import com.carlos.proyecto1.ED.Pila;
import com.carlos.proyecto1.Objetos.Capa;
import com.carlos.proyecto1.Objetos.DatosPrograma;
import com.carlos.proyecto1.Objetos.parametrosGraphviz;

public class GraficarMatrizDispersa {

    public GraficarMatrizDispersa() {
    }
    public String obtenerDotFile(String id,DatosPrograma dataP){
        String code ="";
        NodoArbol tmp = dataP.getArbolCapas().buscarNodo(id);
        if(tmp!=null){
            Capa tmpCapa = (Capa)tmp.getContenido();
            MatrizDispersa mtmp = tmpCapa.getContenido();
            parametrosGraphviz parametros = mtmp.obtenerGrafico();
            String ranks  = "";
            Pila tmpPila = parametros.getRanks();
            String cont = null;
            while (!tmpPila.isEmpty()) {
                cont = (String) tmpPila.pop();
                ranks = ranks + cont+"\n";
            }
            return parametros.getModeloNodo()+parametros.getDeclaraciones()+ranks+parametros.getRelaciones();
        }
        return null;
    }
}
