package Ficheros1al8;

import java.io.FileReader;
import java.io.IOException;

public class Actividad6 {
    public static void main(String[] args){
        String path= "C:\\Users\\raulm\\OneDrive\\Documentos\\GitHub\\Actividad6.txt";
        int vocales=0;
        int numeros=0;
        int consonantes=0;
        try {
            FileReader fr = new FileReader(path);
            int caracter;
            while ((caracter= fr.read()) != -1){
                char c = (char) caracter;
                char letra = Character.toLowerCase(c);
                if (Character.isDigit(c)){
                    numeros++;
                } else if (letra >= 'a' && letra <='z') {
                    if (letra== 'a' ||letra=='e' || letra=='i'||letra=='o'||letra=='u'){
                        vocales++;
                    }else{
                        consonantes++;
                    }
                }
            }
            
            System.out.println(numeros);
            System.out.println(vocales);
            System.out.println(consonantes);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
