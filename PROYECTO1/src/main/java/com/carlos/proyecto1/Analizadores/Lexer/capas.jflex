package com.carlos.proyecto1.Analizadores.Lexer;
import com.carlos.proyecto1.Analizadores.Parser.parserCapasSym;
import static com.carlos.proyecto1.Analizadores.Parser.parserCapasSym.*;
import com.carlos.proyecto1.ED.Cola;
import com.carlos.proyecto1.Tokens.token;
import java_cup.runtime.Symbol;

%%

/*segunda seccion, configuracion*/
%class capasLexer
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
  return new java_cup.runtime.Symbol(parserCapasSym.EOF);
%eofval}

/*EXPRECIONES REGULARES*/
LineTerminator = [\r|\n|\r\n]+
WhiteSpace = [ \t\n]+
numero = [0-9]+
hex = ([0-9]|[ABCDEF])
hex2 = ([0-9]|[abcdef])
colorHex = [#]({hex}{6}|{hex2}{6})

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
           //System.out.println("Llave apertura: "+yytext()+" Linea: "+(yyline+1)+" Columna: "+(yycolumn+1));
            return new Symbol (L_A,after_symbl.sym,0, new token(yytext(),yycolumn+1,yyline+1));
        }
    "}"
        {
            //System.out.println("Llave cierre: "+yytext()+" Linea: "+(yyline+1)+" Columna: "+(yycolumn+1));
            return new Symbol (L_C,after_symbl.sym,0, new token(yytext(),yycolumn+1,yyline+1));
        }
    ";"
        {
            //System.out.println("Punto y coma: "+yytext()+" Linea: "+(yyline+1)+" Columna: "+(yycolumn+1));
            return new Symbol (DOT_COM,after_symbl.sym,0, new token(yytext(),yycolumn+1,yyline+1));
        }
    ","
        {
            //System.out.println("Coma: "+yytext()+" Linea: "+(yyline+1)+" Columna: "+(yycolumn+1));
            return new Symbol (COM,after_symbl.sym,0, new token(yytext(),yycolumn+1,yyline+1));
        }
    {numero}
        {
            //System.out.println("Numero : "+yytext()+" Linea: "+(yyline+1)+" Columna: "+(yycolumn+1));
            return new Symbol (NUM,after_symbl.sym,0, new token(yytext(),yycolumn+1,yyline+1));
        }
    {colorHex}
        {
            //System.out.println("Color: "+yytext()+" Linea: "+(yyline+1)+" Columna: "+(yycolumn+1));
            return new Symbol (COLOR,after_symbl.sym,0, new token(yytext(),yycolumn+1,yyline+1));
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