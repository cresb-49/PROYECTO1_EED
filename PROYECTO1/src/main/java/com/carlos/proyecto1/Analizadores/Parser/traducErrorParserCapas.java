package com.carlos.proyecto1.Analizadores.Parser;

import static com.carlos.proyecto1.Analizadores.Parser.parserCapasSym.*;

public class traducErrorParserCapas {

    public traducErrorParserCapas() {
    }

    public String tokenEsperado(int id) {
        switch (id) {
            case COLOR:
                return "Color Hexadesimal";
            case COM:
                return "\",\"";
            case DOT_COM:
                return "\";\"";
            case L_A:
                return "{";
            case L_C:
                return "}";
            case NUM:
                return "numero";
            default:
                return "";
        }
    }
}
