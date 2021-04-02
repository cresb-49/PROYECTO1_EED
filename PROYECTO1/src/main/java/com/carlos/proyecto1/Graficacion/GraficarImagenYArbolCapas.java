package com.carlos.proyecto1.Graficacion;

import com.carlos.proyecto1.ED.ListaDobleEnlazadaCircular;
import com.carlos.proyecto1.ED.Nodo;
import com.carlos.proyecto1.Objetos.Capa;
import com.carlos.proyecto1.Objetos.DatosPrograma;
import com.carlos.proyecto1.Objetos.Imagen;
import com.carlos.proyecto1.Objetos.parametrosGraphviz;

public class GraficarImagenYArbolCapas {

    public GraficarImagenYArbolCapas() {
    }

    public void obtenerDotFile(String nameImage, DatosPrograma datos) {

        Nodo tmp = datos.getImagenes().buscar(nameImage);

        ObtenerGraficoAVL graficoAVL = new ObtenerGraficoAVL();
        String grap = graficoAVL.GraficoAVL(datos.getArbolCapas());
        String code = "subgraph {";
        code = code + grap;
        code = code + "}\n";

        if (grap == null) {
            code = null;
        }

        if (tmp != null && code != null) {
            parametrosGraphviz parametros = new parametrosGraphviz();
            Imagen img = (Imagen) tmp.getContenido();
            String name = "", name2 = "", tagNode = "";
            Nodo tmpNode = img.getCapas().getRaiz();
            code = code + "imagen" + img.getId() + "[shape = box,group = 1]\n"
                    + "{rank = same;imagen" + img.getId() + ";}";
            if (tmpNode != null) {

                parametros.agregarRelacion("imagen" + img.getId() + " -> \"nodeLED" + img.getId() + "CP" + tmpNode.getTag() + "\";");
            }

            while (tmpNode != null) {

                if (tmpNode.getContenido() instanceof Capa) {
                    name = "Capa";
                    name2 = ((Capa) tmpNode.getContenido()).getId();
                    name = name + name2;

                    tagNode = "CP";
                }
                parametros.agregarDeclaracion("nodeLED" + img.getId() + tagNode + tmpNode.getTag() + "[label = \"" + name + "\",group = 2];");
                parametros.agregarRelacion("nodeLED" + img.getId() + tagNode + tmpNode.getTag() + " -> \"nodeAVL" + name2 + "\":f1;");
                if (tmpNode.getSiguiente() != null) {
                    parametros.agregarRelacion("\"nodeLED" + img.getId() + tagNode + tmpNode.getTag() + "\" -> \"nodeLED" + img.getId() + tagNode + tmpNode.getSiguiente().getTag() + "\";");
                }

                tmpNode = tmpNode.getSiguiente();
            }

            code = code + "subgraph{\n" + parametros.getModeloNodo() + parametros.getDeclaraciones() + parametros.getRelaciones() + "}\n";

            System.out.println(code);

        }

    }
}
