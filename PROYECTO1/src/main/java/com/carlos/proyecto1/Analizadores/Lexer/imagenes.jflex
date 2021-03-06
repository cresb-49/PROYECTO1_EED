package com.carlos.proyecto1.Analizadores.Lexer;
import com.carlos.proyecto1.Analizadores.Parser.parserImagenesSym;
import static com.carlos.proyecto1.Analizadores.Parser.parserImagenesSym.*;
import com.carlos.proyecto1.ED.Cola;
import com.carlos.proyecto1.Tokens.token;
import java_cup.runtime.Symbol;

%%

/*segunda seccion, configuracion*/
%class imagenLexer
%cup
/*%standalone*/
%unicode
%line
%column
%public
%{
    private Symbol after_symbl = new Symbol(0);
    private Symbol tmp_symbl = new Symbol(0);

    private Cola errores = new Cola();

%}

%eofval{
  return new java_cup.runtime.Symbol(parserImagenesSym.EOF);
%eofval}

/*EXPRECIONES REGULARES*/
LineTerminator = [\r|\n|\r\n]+
WhiteSpace = [ \t\n]+
numero = [0-9]+

%{
    private void error(String lexeme) {
        System.out.printf("Error lexico \"%s\" linea %d,  columna %d. \n", lexeme, yyline + 1, yycolumn + 1);
        errores.agregar(String.format("Error Lexico en el Texto: %s  linea %d, columna %d. Corrige e intenta de nuevo.", lexeme, yyline + 1, yycolumn + 1));
    }

    public Cola gerErrores(){
        return errores;
    }
    
%}

%%

/*LEXIX RULES*/
<YYINITIAL>{
    "{"
        {
            //System.out.println("Llave apertura: "+yytext());
            return new Symbol (L_A,after_symbl.sym,0, new token(yytext(),yycolumn+1,yyline+1));
        }
    "}"
        {
            //System.out.println("Lave Cierre: "+yytext());
            return new Symbol (L_C,after_symbl.sym,0, new token(yytext(),yycolumn+1,yyline+1));
        }
    ","
        {
            //System.out.println("Coma: "+yytext());
            return new Symbol (COM,after_symbl.sym,0, new token(yytext(),yycolumn+1,yyline+1));
        }
    {numero}
        {
            //System.out.println("Indentificador: "+yytext());
            return new Symbol (NUM,after_symbl.sym,0, new token(yytext(),yycolumn+1,yyline+1));
        }
    {LineTerminator}
        {
            /*Do nothing*/
        }
    {WhiteSpace}
        {
            /*Do nothing*/
        }
}
[^]     {
            error(yytext());
        }