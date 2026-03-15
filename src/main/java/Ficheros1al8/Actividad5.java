package Ficheros1al8;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Actividad5 {
    public static void main(String[] args){
        String path = "C:\\Users\\raulm\\OneDrive\\Documentos\\GitHub/actividad5.txt";
        String pathord = "C:\\Users\\raulm\\OneDrive\\Documentos\\GitHub/actividad5ord.txt";

        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String cadena= br.readLine();
            ArrayList<String> lista= new ArrayList<>();
            while (cadena!=null){
                System.out.println(cadena);
                lista.add(cadena);
                cadena=br.readLine();
            }
            br.close();

            Collections.sort(lista);
            FileWriter fw = new FileWriter(pathord);
            PrintWriter pw = new PrintWriter(fw);

            for (String linea:lista){
                pw.println(linea);
            }
            pw.close();
            FileReader fr2 = new FileReader(pathord);
            BufferedReader br2 = new BufferedReader(fr2);
            String cadena2= br2.readLine();
            while (cadena2!=null){
                System.out.println(cadena2);
                cadena2=br2.readLine();
            }
            br2.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
