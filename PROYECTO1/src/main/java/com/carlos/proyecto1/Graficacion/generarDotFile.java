package com.carlos.proyecto1.Graficacion;

import com.carlos.proyecto1.Exepciones.NullDataException;
import static java.awt.SystemColor.text;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class generarDotFile {

    public generarDotFile() {

    }
    
    public void generarArchivo(String code, String nombre) throws IOException, NullDataException {
        if (code == null) {
            throw new NullDataException("No existen datos para Graficar");
        } else {
            if (code.isEmpty()) {
                throw new NullDataException("No existen datos para Graficar");
            } else {
                BufferedWriter bw = new BufferedWriter(new FileWriter(nombre + ".dot", false));
                bw.write(code);
                bw.close();
            }
        }

    }
}
