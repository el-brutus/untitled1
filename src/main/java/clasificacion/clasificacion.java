package clasificacion;

import java.io.*;
import java.util.HashMap;

public class clasificacion {
    public static void main(String[] args){
        try {
            String path="C:\\Users\\raulm\\Documents\\GitHub\\jugadores.txt";
            String path2="C:\\Users\\raulm\\Documents\\GitHub\\jugadoresexcel.txt";
            String pathcl="C:\\Users\\raulm\\Documents\\GitHub\\clasificacion.txt";
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
            while ((cadena2 = br2.readLine()) != null){
                String[] partes = cadena2.split("\t");
                if (partes.length>2){
                    String rank = partes[1];
                    String pts = partes[3];
                    String fide = partes[partes.length-1];
                    if (jugadores.containsKey(rank)){
                        pw.printf("%-5s %-25s %-10s %-5s%n",
                                rank,
                                jugadores.get(rank),
                                fide,
                                pts);                    }
                }
            }
            pw.close();

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
