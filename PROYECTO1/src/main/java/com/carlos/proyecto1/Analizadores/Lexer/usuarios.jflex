package com.carlos.proyecto1.Analizadores.Lexer;
import com.carlos.proyecto1.Analizadores.Parser.parserUsuarioSym;
import com.carlos.proyecto1.ED.Cola;
import java_cup.runtime.Symbol;
%%

/*segunda seccion, configuracion*/
%class userLexer
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
  return new java_cup.runtime.Symbol(parserUsuarioSym.EOF);
%eofval}

/*EXPRECIONES REGULARES*/
LineTerminator = [\r|\n|\r\n]+
WhiteSpace = [ \t\n]+


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