#! /bin/bash
echo "COMPILANDO ARCHIVO JFLEX"
java -jar jflex-full-1.8.2.jar Lexer/usuarios.jflex
echo "COMPILANDO ARCHIVO CUP"
java -jar java-cup-11b.jar Parser/usuarios.cup
echo "Eliminando Archivos Antiguos"
rm Lexer/userLexer.java~
rm Parser/parserUsuario.java
rm Parser/parserUsuarioSym.java
echo "Moviendo Archivos nuevos"
mv parserUsuario.java Parser/
mv parserUsuarioSym.java Parser/
echo "FIN DE PROCESOS"
