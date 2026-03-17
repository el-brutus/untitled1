package FicherosCompra;

import java.io.*;
import java.util.*;

public class compra {
    private static Map<String, producto> productos = new HashMap<>();
    private static Set<producto> lista = new LinkedHashSet<>();


    public static void main(String[] args){

        String path = "C:\\Users\\raulm\\Documents\\GitHub\\producto.txt";
        Scanner sc = new Scanner(System.in);
        String opcion="";
        int cantidad;
        productos.put("AVENA", new producto("AVENA", 2.21));
        productos.put("GARBANZOS",new producto("GARBANZOS", 2.39));
        productos.put("TOMATE",new producto("TOMATE", 1.59));
        productos.put("JENGIBRE",new producto("JENGIBRE", 3.13));
        productos.put("QUINOA",new producto("QUINOA", 4.50));
        productos.put("GUISANTES", new producto("GUISANTES", 1.60));

       try {
           PrintWriter pw = new PrintWriter(path);
           pw.println("PRODUCTO\t PRECIO CANTIDAD SUBTOTAL");
           pw.println("---------------------------------");
           while (!opcion.equalsIgnoreCase("FIN")) {
               impproductos();
               System.out.print("Introduce un producto: ");
               opcion = sc.nextLine().toUpperCase();
               if (!opcion.equalsIgnoreCase("FIN")){
                   System.out.print("Introduce la cantidad: ");
                   cantidad = sc.nextInt();
                   sc.nextLine();
                   lista.add(productos.get(opcion));
                   productos.get(opcion).setCantidad(cantidad);
               }
           }

           for (producto producto:lista){
               if (producto.getNombre().length()<=6){
                   pw.println(producto.getNombre()+"\t\t"+ producto.getPrecio()+"\t"+ producto.getCantidad()+"\t"+producto.calculartotal());
               }else {
                   pw.println(producto.getNombre()+"\t"+ producto.getPrecio()+"\t"+ producto.getCantidad()+"\t"+producto.calculartotal());
               }
           }

           double preciofinal=0;
           for (producto producto : lista){
               preciofinal+= producto.calculartotal();
           }
           System.out.print("Introduce un codigo de descuento: ");
           String descuento=sc.nextLine();
           pw.println("---------------------------------");
           if (descuento.equalsIgnoreCase("PROMOECO")){

               pw.print("Descuento aplicado, ");
               preciofinal=preciofinal-(preciofinal*10/100);
           }else{
               System.out.println("Codigo introducido no valido. ");
           }
           pw.println("TOTAL:" + String.format("%.2f",preciofinal));

           pw.close();
           System.out.println("Saliendo del programa");
           System.out.println("Ticket imprimido: ");
           System.out.println();
           FileReader fr=new FileReader(path);
           BufferedReader br = new BufferedReader(fr);
           String cadena=br.readLine();
           while (cadena != null){
               System.out.println(cadena);
               cadena = br.readLine();
           }
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

