package FicherosCompra;

import java.io.*;
import java.util.Scanner;

public class compra {
    public static void main(String[] args){

        String path = "C:\\Users\\raulm\\OneDrive\\Documentos\\GitHub\\producto.txt";
        Scanner sc = new Scanner(System.in);
        String opcion="";
        int cantidad;
        double pavena=2.21;
        double pgarbanzo=2.39;
        double tomate=1.59;
        double jengibre=3.13;
        double quinoa=4.50;
        double guisantes=1.60;
       try {
           PrintWriter pw = new PrintWriter(path);

           while (!opcion.equalsIgnoreCase("FIN")) {
               impproductos();
               try {
                   System.out.println("Introduce un producto");
                   opcion = sc.nextLine();
                   if (opcion.equalsIgnoreCase("FIN")){
                      opcion="FIN";
                      break;
                   }
                   pw.print(opcion+" ");
                       System.out.println("Introduce la cantidad");
                       cantidad=sc.nextInt();
                       if (cantidad>0){
                           pw.print(cantidad);
                       }



                   pw.println();
                   sc.nextLine();
               } catch (Exception e) {
                   System.out.println("Esa no es una opcion valida.");
                   sc.nextLine();
               }
           }
           pw.close();
           System.out.println("Saliendo del programa");
       }catch (IOException e){
           System.out.println(e.getMessage());
       }
    }
    public static void impproductos(){
        System.out.println("------------------------------------------------");
        System.out.println("avena|garbanzos|tomate|jengibre|quinoa|guisantes");
        System.out.println("2,21 |   2,39  | 1,59 |  3,13  | 4,50 |   1,60  ");
        System.out.println("------------------------------------------------");
    }
}

