package Ficheros1al8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Actividad8 {
    public static void main(String[] args){
        String path= "C:\\Users\\raulm\\Documents\\GitHub\\Actividad8.txt";
        System.out.print("Introduce una palabra a buscar: ");
        Scanner sc = new Scanner(System.in);
        String palabra = sc.nextLine();
        int palabras=0;
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String caracter = br.readLine();
            while (caracter != null){
                if (caracter.toUpperCase().indexOf(palabra.toUpperCase())!=-1){
                    palabras++;
                }
                caracter = br.readLine();

            }
            br.close();
            if (palabras==0){
                System.out.println("La palabra no ha sido encontrada");
            }
            if (palabras!=0) {
                System.out.println("La palabra: " + palabra + " ha sido encontrada: " + palabras + " veces");
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
