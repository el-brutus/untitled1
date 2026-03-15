package Ficheros1al8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Actividad7 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre del archivo sin extension: ");
        String nombre= sc.nextLine();
        String path = "C:\\Users\\raulm\\OneDrive\\Documentos\\GitHub\\"+nombre+".txt";
        try{
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String cadena = br.readLine();
            while (cadena != null){
                System.out.println(cadena);
                cadena = br.readLine();
            }
            br.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
