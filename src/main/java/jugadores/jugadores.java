package jugadores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class jugadores {
    public static void main(String[] args){
        String path="C:\\Users\\raulm\\OneDrive\\Documentos\\GitHub\\jugadores.txt";
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String cadena= br.readLine();
            while (cadena != null) {
                String[] partes = cadena.split(";");
                if (partes.length>2) {
                    String info = partes[partes.length - 1];

                    if (info.contains("CV")) {
                        String nombre = partes[2];
                        System.out.println(nombre);
                    }
                }
                cadena = br.readLine();
            }

        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
