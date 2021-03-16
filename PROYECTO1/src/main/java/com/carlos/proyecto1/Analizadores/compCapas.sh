#! /bin/bash
echo "COMPILANDO ARCHIVO JFLEX"
java -jar jflex-full-1.8.2.jar Lexer/capas.jflex
echo "COMPILANDO ARCHIVO CUP"
java -jar java-cup-11b.jar Parser/capas.cup
echo "Eliminando Archivos Antiguos"
rm Lexer/capasLexer.java~
rm Parser/parserCapas.java
rm Parser/parserCapasSym.java
echo "Moviendo Archivos nuevos"
mv parserCapas.java Parser/
mv parserCapasSym.java Parser/
echo "FIN DE PROCESOS"
