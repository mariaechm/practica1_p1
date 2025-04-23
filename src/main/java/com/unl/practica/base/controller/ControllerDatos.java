package com.unl.practica.base.controller;


import java.io.BufferedReader;
import java.io.FileReader;

import com.unl.practica.base.controller.data_struct.list.LinkendList;
import com.unl.practica.base.controller.excepcion.ListEmptyException;


public class ControllerDatos {

    String rutaArchivo = "/home/maria/Escritorio/Estructura/unl-practica/src/data.txt";

    public static int[] cargarDatos(String rutaArchivo) throws Exception {
        BufferedReader contador = new BufferedReader(new FileReader(rutaArchivo));
        int total = 0;
        while (contador.readLine() != null) total++;
        contador.close();

        int[] datos = new int[total];
        BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo));
        String linea;
        int i = 0;
        while ((linea = lector.readLine()) != null) {
            datos[i] = Integer.parseInt(linea.trim());
            i++;
        }
        lector.close();
        return datos;
    }

    public static void numerosIguales(int[] datos) {
        int[] iguales = new int[datos.length];
        int[] contadores = new int[datos.length];
        int totalIguales = 0;
    
        for (int i = 0; i < datos.length; i++) {
            int actual = datos[i];
            boolean numContado = false;
    
            for (int k = 0; k < totalIguales; k++) {
                if (iguales[k] == actual) {
                    numContado = true;
                    break;
                }
            }
    
            if (!numContado) {
                int contador = 1;

                for (int j = i + 1; j < datos.length; j++) {
                    if (actual == datos[j]) {
                        contador++;
                    }
                }
        
                if (contador > 1) {
                    iguales[totalIguales] = actual;
                    contadores[totalIguales] = contador;
                    totalIguales++;
                }
            }
        }
    }
}


           