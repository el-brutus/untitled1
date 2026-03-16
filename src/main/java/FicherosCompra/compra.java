package FicherosCompra;

import java.io.*;
import java.util.*;

public class compra {
    private static Map productos = new HashMap<>();
    private static Set lista = new HashSet<>();
    private static void genproducto(){
        productos.put("AVENA",2.21);
        productos.put("GARBANZO",2.39);
        productos.put("TOMATE",1.59);
        productos.put("JENGIBRE",3.13);
        productos.put("QUINOA",4.50);
        productos.put("GUISANTES", 1.60);

    }
    public static void main(String[] args){

        String path = "C:\\Users\\raulm\\Documents\\GitHub\\producto.txt";
        Scanner sc = new Scanner(System.in);
        String opcion="";
        int cantidad;


       try {
           PrintWriter pw = new PrintWriter(path);
           pw.println("PRODUCTO PRECIO CANTIDAD SUBTOTAL");
           while (!opcion.equalsIgnoreCase("FIN")) {
               impproductos();
               try {
                   System.out.println("Introduce un producto");
                   opcion = sc.nextLine();
                   if (opcion.equalsIgnoreCase("FIN")){
                      opcion="FIN";
                      break;
                   }
                   pw.print(opcion+"\t");
                   opcion.toUpperCase();
                   productos.get(opcion);
                   pw.print(productos.get(opcion)+"\t");
                   System.out.println("Introduce la cantidad");
                   cantidad=sc.nextInt();
                   if (cantidad>0){
                       pw.print(cantidad+"\t");
                   }
                   pw.print(productos.get(opcion)*cantidad);
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
        System.out.println("-------------PRODUCTOS DISPONIBLES--------------");
        System.out.println("avena|garbanzos|tomate|jengibre|quinoa|guisantes");
        System.out.println("2,21 |   2,39  | 1,59 |  3,13  | 4,50 |   1,60  ");
        System.out.println("------------------------------------------------");
    }

}

