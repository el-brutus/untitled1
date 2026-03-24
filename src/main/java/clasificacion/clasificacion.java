package clasificacion;

import java.io.*;
import java.util.HashMap;

public class clasificacion {
    public static void main(String[] args){
        try {
            File path= new File("src/main/java/clasificacion/jugadores.txt");
            File path2=new File("src/main/java/clasificacion/jugadoresexcel.txt");
            File pathcl=new File("src/main/java/clasificacion/clasificacion.txt");
            HashMap<String, String> jugadores= new HashMap<>();
            FileReader fr = new FileReader(path);
            BufferedReader br= new BufferedReader(fr);
            String cadena;

            while ((cadena  = br.readLine())!= null){
                String[] partes = cadena.split(";");
                if (partes.length>2){
                    jugadores.put(partes[0],partes[2]);
                }
            }
            br.close();
            FileReader fr2=new FileReader(path2);
            BufferedReader br2=new BufferedReader(fr2);
            String cadena2;
            PrintWriter pw=new PrintWriter(pathcl);
            System.out.println("Guardando clasificacion en un fichero...");
            int posicion=-1;
            while ((cadena2 = br2.readLine()) != null){
                String[] partes = cadena2.split("\t");
                if (partes.length>2){
                    String rank = partes[1];
                    String pts = partes[3];
                    String fide = partes[partes.length-1];
                    posicion++;
                    if (jugadores.containsKey(rank)) {
                        if (posicion == 0) {
                            pw.printf("%-10s %-34s %-10s %-5s%n", "Posicion", jugadores.get(rank), fide, pts);
                        } else {
                            pw.printf("%-10s %-34s %-10s %-5s%n", posicion, jugadores.get(rank), fide, pts);
                        }
                    }
                }
            }
            System.out.println("✔ Fichero guardado ✔");
            pw.close();

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
