package Ficheros1al8;

import java.io.*;

public class Actividad2 {
    public static void main(String[] args) {
        String path = "C:/Users/raulm/Documents/GitHub/numNaturales.txt";
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String cadena = br.readLine();
            while (cadena != null){
                System.out.println(cadena);
                cadena= br.readLine();
            }
            int resultado = obtenerSumaNumerosArchivo(path);
            System.out.println("El resultado es: "+ resultado);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static int obtenerSumaNumerosArchivo(String archivo){
        int suma = 0;
        String path = "C:/Users/raulm/Documents/GitHub/numNaturales.txt";
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String cadena;
            while ((cadena = br.readLine())  != null){
                int numero = Integer.parseInt(cadena);
                suma += numero;
            }
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return suma;
    }
}
