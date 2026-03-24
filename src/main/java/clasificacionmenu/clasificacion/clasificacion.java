package clasificacionmenu.clasificacion;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class clasificacion {
    public static void main(String[] args){
        String path="src/main/java/clasificacionmenu/clasificacion/jugadores.txt";
        String pathCV="src/main/java/clasificacionmenu/clasificacion/jugadoresCV.txt";
        String pathAl="src/main/java/clasificacionmenu/clasificacion/alojados.txt";
        String pathex="src/main/java/clasificacionmenu/clasificacion/jugadoresexcel.txt";
        String pathcl="src/main/java/clasificacionmenu/clasificacion/clasificacion.txt";
        HashMap<String, String> jugadores= new HashMap<>();

        Scanner sc = new Scanner(System.in);
        try {
            PrintWriter pw = new PrintWriter(pathCV);
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String cadena;
            PrintWriter pw2 = new PrintWriter(pathAl);
            FileReader fr2 = new FileReader(path);
            BufferedReader br2 = new BufferedReader(fr2);
            String cadena2;
            FileReader fr3 = new FileReader(path);
            BufferedReader br3= new BufferedReader(fr3);
            String cadena3;
            while ((cadena3  = br3.readLine())!= null){
                String[] partes = cadena3.split(";");
                if (partes.length>2){
                    jugadores.put(partes[0],partes[2]);
                }
            }
            int opcion;
            boolean salida=false;
            while (salida==false) {
                System.out.println();
                System.out.println("MENU DE OPCIONES");
                System.out.println("----------------");
                System.out.println("1 Guardar jugadores federados en la CV");
                System.out.println("2 Guardad jugadores alojados en un hotel");
                System.out.println("3 Guardar clasificacion en un fichero");
                System.out.println("----------------");
                System.out.println("Introduce una opcion: ");
                try {
                    opcion = sc.nextInt();
                    switch (opcion) {
                        case 1:
                            System.out.println("Guardando jugadores federados en la CV....");

                            pw.println("Jugadores federados en la CV");
                            pw.println("RANK\t-- Nombre");
                            while ((cadena = br.readLine()) != null) {
                                String partes[] = cadena.split(";");
                                if (partes.length > 2) {
                                    String info = partes[partes.length - 1];
                                    if (info.contains("CV")) {
                                        String nombre = partes[2];
                                        String rank = partes[0];
                                        pw.println(rank + "\t-- " + nombre);
                                    }
                                }
                            }
                            System.out.println("Jugadores guardados");
                            pw.close();
                            br.close();
                            break;
                        case 2:
                            System.out.println("Guardando jugadores alojados en un hotel....");

                            pw2.println("Jugadores alojados en un hotel");
                            pw2.println("RANK\t-- Nombre");
                            while ((cadena2 = br2.readLine())!= null) {
                                String partes[] = cadena2.split(";");
                                if (partes.length > 2) {
                                    String info = partes[partes.length - 1];
                                    if (info.contains("H")) {
                                        String nombre = partes[2];
                                        String rank = partes[0];
                                        pw2.println(rank + "\t-- " + nombre);
                                    }
                                }
                            }
                            pw2.close();
                            br2.close();
                            System.out.println("Jugadores guardados");
                            break;
                        case 3:
                            FileReader fr4=new FileReader(pathex);
                            BufferedReader br4=new BufferedReader(fr4);
                            String cadena4;
                            PrintWriter pw3=new PrintWriter(pathcl);
                            System.out.println("Guardando clasificacion en un fichero...");
                            int posicion=-1;
                            while ((cadena4 = br4.readLine()) != null){
                                String[] partes = cadena4.split("\t");
                                if (partes.length>2){
                                    String rank = partes[1];
                                    String pts = partes[3];
                                    String fide = partes[partes.length-1];
                                    posicion++;
                                    if (jugadores.containsKey(rank)) {
                                        if (posicion == 0) {
                                            pw3.printf("%-10s %-34s %-10s %-5s%n", "Posicion", jugadores.get(rank), fide, pts);
                                        } else {
                                            pw3.printf("%-10s %-34s %-10s %-5s%n", posicion, jugadores.get(rank), fide, pts);
                                        }
                                    }
                                }
                            }
                            System.out.println("✔ Fichero guardado ✔");
                            pw3.close();
                            break;
                        case 0:
                            salida = true;
                            break;
                        default:
                            System.out.println("Esa opcion no es valida");
                    }
                }catch (Exception e){
                    sc.nextLine();
                    System.out.println("Esa no es una opcion valida");
                }
            }

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
