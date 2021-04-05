package com.carlos.proyecto1.Analizadores.Parser;

import static com.carlos.proyecto1.Analizadores.Parser.parserImagenesSym.*;

public class traducErrorParserImagenes {

    public traducErrorParserImagenes() {
    }

    public String tokenEsperado(int id) {
        switch (id) {
            case COM:
                return "\",\"";
            case L_A:
                return "\"{\"";
            case L_C:
                return "\"}\"";
            case NUM:
                return "Id numerico";
            default:
                return "";
        }
    }
}
