#! /bin/bash
echo "COMPILANDO ARCHIVO JFLEX"
java -jar jflex-full-1.8.2.jar Lexer/imagenes.jflex
echo "COMPILANDO ARCHIVO CUP"
java -jar java-cup-11b.jar Parser/imagenes.cup
echo "Eliminando Archivos Antiguos"
rm Lexer/imagenLexer.java~
rm Parser/parserImagenes.java
rm Parser/parserImagenesSym.java
echo "Moviendo Archivos nuevos"
mv parserImagenes.java Parser/
mv parserImagenesSym.java Parser/
echo "FIN DE PROCESOS"
