package jugadores;

import java.io.*;
import java.util.Scanner;

public class jugadores {
    public static void main(String[] args){
        String path="C:\\Users\\raulm\\OneDrive\\Documentos\\GitHub\\jugadores.txt";
        String pathCV="C:\\Users\\raulm\\OneDrive\\Documentos\\GitHub\\jugadoresCV.txt";
        String pathAl="C:\\Users\\raulm\\OneDrive\\Documentos\\GitHub\\alojados.txt";
        Scanner sc = new Scanner(System.in);
        try {

            int opcion;
            boolean salida=false;



                while (salida==false) {
                    System.out.println();
                    System.out.println("MENU DE OPCIONES");
                    System.out.println("----------------");
                    System.out.println("1 Guardar jugadores federados en la CV");
                    System.out.println("2 Guardad jugadores alojados en un hotel");
                    System.out.println("----------------");
                    System.out.println("Introduce una opcion: ");
                    opcion = sc.nextInt();
                    switch (opcion) {
                        case 1:
                            System.out.println("Guardando jugadores federados en la CV....");
                            PrintWriter pw=new PrintWriter(pathCV);
                            FileReader fr = new FileReader(path);
                            BufferedReader br = new BufferedReader(fr);
                            String cadena = br.readLine();
                            pw.println("Jugadores federados en la CV");
                            pw.println("RANK\t-- Nombre");
                            while (cadena != null) {
                                String partes[] = cadena.split(";");
                                if (partes.length > 2) {
                                    String info = partes[partes.length - 1];
                                    if (info.contains("CV")) {
                                        String nombre = partes[2];
                                        String rank = partes[0];
                                        pw.println(rank+"\t-- "+nombre);
                                    }
                                }
                                cadena = br.readLine();
                            }
                            System.out.println("Jugadores guardados");
                            pw.close();
                            br.close();
                            break;
                        case 2:
                            System.out.println("Guardando jugadores alojados en un hotel....");
                            PrintWriter pw2 = new PrintWriter(pathAl);
                            FileReader fr2 = new FileReader(path);
                            BufferedReader br2 = new BufferedReader(fr2);
                            String cadena2= br2.readLine();
                            pw2.println("Jugadores alojados en un hotel");
                            pw2.println("RANK\t-- Nombre");
                            while (cadena2 != null) {
                                String partes[] = cadena2.split(";");
                                if (partes.length > 2) {
                                    String info = partes[partes.length - 1];
                                    if (info.contains("H")) {
                                        String nombre = partes[2];
                                        String rank = partes[0];
                                        pw2.println(rank+"\t-- "+nombre);
                                    }
                                }
                                cadena2 = br2.readLine();
                            }
                            pw2.close();
                            br2.close();
                            System.out.println("Jugadores guardados");
                            break;
                        case 0:
                            salida=true;
                            break;
                        default:
                            System.out.println("Esa no es una opcion valida");
                            break;
                    }
                }

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
