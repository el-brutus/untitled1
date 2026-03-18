package jugadores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class jugadores {
    public static void main(String[] args){
        String path="C:\\Users\\raulm\\Documents\\GitHub\\jugadores.txt";
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String cadena = br.readLine();
            int opcion = 0;
            boolean salida=false;
            while (cadena != null){
                String partes[]= cadena.split(";");
                while (salida) {
                    try {
                        System.out.println("Introduce una opcion");
                        switch (opcion) {

                            case 1:
                                if (partes.length > 2) {
                                    String info = partes[partes.length - 1];
                                    if (info.contains("CV")) {
                                        String nombre = partes[2];
                                        System.out.println(nombre);
                                    }
                                }
                            case 2:
                                if (partes.length > 2) {
                                    String info = partes[partes.length - 1];
                                    if (info.contains("H")) {
                                        String nombre = partes[2];
                                        System.out.println(nombre);
                                    }
                                }
                            case 0:
                                salida = true;
                            default:
                                System.out.println("Esta no es una opcion valida introduce otra.");
                        }
                    }catch (Exception e){
                        System.out.println("Opcion no valida.");
                    }
                }
                cadena= br.readLine();
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
