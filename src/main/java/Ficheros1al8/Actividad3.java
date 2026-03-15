package Ficheros1al8;

import java.io.*;

public class Actividad3 {
    public static void main(String[] args){
        String path = "C:/Users/raulm/Documents/GitHub/numprimos.txt";
        try {
            FileWriter fw= new FileWriter(path);
            PrintWriter bw = new PrintWriter(fw);
            for (int i = 0;i<500;i++){
                if (esprimo(i)){
                    bw.println(i);
                }
            }
            bw.close();
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String cadena = br.readLine();
            while (cadena != null){
                System.out.println(cadena);
                cadena=br.readLine();
            }
        }catch (IOException e){
            System.out.println(e);
        }

    }
    public static boolean esprimo(int n){
        if (n <= 1) return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
