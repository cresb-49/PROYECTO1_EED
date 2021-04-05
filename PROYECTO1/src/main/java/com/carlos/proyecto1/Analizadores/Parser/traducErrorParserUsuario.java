package com.carlos.proyecto1.Analizadores.Parser;

import static com.carlos.proyecto1.Analizadores.Parser.parserUsuarioSym.*;

public class traducErrorParserUsuario {

    public traducErrorParserUsuario() {
    }
    
    public String tokenEsperado(int id){
        switch(id){
            case COMA:
                return "\",\"";
            case DOT_COMA:
                return "\";\"";
            case D_DOT:
                return "\":\"";
            case ID:
                return "Id de imagen";
            case USER:
                return "Nombre de Usuario";
            default:
                return "";
        }
    }
}
