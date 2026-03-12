import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Actividad5 {
    public static void main(String[] args){
        String path = "C:/Users/raulm/Documents/GitHub/actividad5.txt";
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String cadena= br.readLine();
            while (cadena!=null){
                System.out.println(cadena);
                cadena=br.readLine();
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
