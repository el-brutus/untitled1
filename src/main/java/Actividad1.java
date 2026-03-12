import java.io.*;

public class Actividad1 {
    public static void main(String[] args) {
        String path = "C:/Users/raulm/Documents/GitHub/numNaturales.txt";
        try {

            PrintWriter pw = new PrintWriter(path);
            for (int i = 0;i<=100;i++){
                pw.println(i);
            }
            pw.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
