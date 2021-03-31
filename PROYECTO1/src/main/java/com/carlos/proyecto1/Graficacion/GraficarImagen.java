package com.carlos.proyecto1.Graficacion;

import com.carlos.proyecto1.ED.MatrizDispersa;
import com.carlos.proyecto1.ED.NodoMatriz;

public class GraficarImagen {

    public GraficarImagen() {
    }

    /**
     * Obtiene una imagen resultante de procesar los colores guardados en una
     * matriz dispersa en lenguaje DOT de graphviz
     *
     * @param matriz
     * @return
     */
    public String obtenerImagen(MatrizDispersa matriz) {
        String code = "",tmpCode="";
        NodoMatriz tmp = matriz.getPrincipal().getSiguienteY();
        String[] fila = null;
        int tamY = 1;

        code = code + "digraph imagen{\n"
                + "    image[shape=none, margin=0,label=<\n"
                + "    <TABLE BORDER=\"0\" CELLBORDER=\"0\" CELLSPACING=\"0\" CELLPADDING=\"15\">\n";

        while (tmp != null) {
            
            
            if(tamY==tmp.getY()){
                fila = this.obtenerfila(tmp, matriz.getTamX());
                tmp = tmp.getSiguienteY();
                tamY++;
            }else{
                fila = this.filaVacia(matriz.getTamX());
                tamY++;
            }
            
            tmpCode="       <TR>\n";
            for (String cont : fila) {
                tmpCode = tmpCode +"            <TD BGCOLOR=\""+(((cont == null) ? "#FFFFFF" : cont))+"\">   </TD>\n";
            }
            tmpCode=tmpCode+"       </TR>\n";
            code = code + tmpCode;
        }

        code = code + "    </TABLE>>];\n"
                + "}";

        return code;
    }

    /**
     * Obtiene un arreglo de una fila de una matriz dispersa
     *
     * @param cabeceraY
     * @param X
     * @return
     */
    private String[] obtenerfila(NodoMatriz cabeceraY, int X) {
        String fila[] = new String[X];
        NodoMatriz varX = cabeceraY.getSiguienteX();
        while (varX != null) {

            fila[varX.getX() - 1] = varX.getContenido().toString();
            varX = varX.getSiguienteX();
        }
        return fila;
    }
    
    /**
     * Obtiene un fila vacia de una matriz
     * @param X
     * @return 
     */
    private String[] filaVacia(int X) {
        String fila[] = new String[X];
        return fila;
    }
}
