package Ficheros1al8;

import java.io.*;

public class Actividad4 {
    public static void main(String[] args){
        String path = "C:/Users/raulm/Documents/GitHub/actividad4.txt";
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String cadena = br.readLine();
            while (cadena != null){
                cadena = cadena.replace(" ", "");
                cadena = cadena.toUpperCase();
                System.out.print(cadena);
                cadena= br.readLine();
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
