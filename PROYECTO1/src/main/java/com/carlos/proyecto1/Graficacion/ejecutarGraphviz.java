package com.carlos.proyecto1.Graficacion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ejecutarGraphviz {

    public ejecutarGraphviz() {
    }

    public String ejecutar(String pathDotCode, String name) throws IOException {
        Process p = Runtime.getRuntime().exec(new String[]{"dot", "-Tpng", pathDotCode, "-o", name});
        File archivo = new File(name);
        return archivo.getAbsolutePath();
    }

}
