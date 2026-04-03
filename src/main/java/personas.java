import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Scanner;

public class personas {
    static Connection cnx;
    static Scanner sc = new Scanner(System.in);
    static {
        try {
            cnx = getConnexion();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Connection getConnexion() throws SQLException {
        String url = "jdbc:mariadb://localhost:3306/sistema_reservas";
        String user = "root";
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }
    public static void main(String[] args){

    }
    static void listarrecursos() throws SQLException {
        Statement stm = cnx.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * from recurso");
        while (rs.next()){
            int id =rs.getInt("id_recurso");
            String nombre = rs.getString("nombre");
            String descripcion= rs.getString("descripcion");
            String ubicacion=rs.getString("ubicacion");
            int capacidad=rs.getInt("capacidad");
            System.out.println(id+"\t"+nombre+"\t"+descripcion+"\t"+ubicacion+"\t"+capacidad);
        }
    }
    static void altarecurso() throws  SQLException{
        sc.nextLine();
        PreparedStatement ps = cnx.prepareStatement(
                "INSERT INTO recurso (nombre, decripcion, ubicacion, capacidad) VALUES (?,?,?,?)");
        sc.nextLine();
        System.out.print("Introduce el nombre del recurso: ");
        String nombre=sc.nextLine();
        System.out.println();
        System.out.print("Introduce una descripcion: ");
        String descripcion=sc.nextLine();
        System.out.println();
        System.out.print("Introduce la ubicacion: ");
        String ubicacion=sc.nextLine();
        System.out.println();
        System.out.print("Introduce la capacidad: ");
        int capacidad=sc.nextInt();
        ps.setString(1, nombre);
        ps.setString(2, descripcion);
        ps.setString(3, ubicacion);
        ps.setInt(4, capacidad);
        ps.executeUpdate();
        ps.close();

    }
    static void bajarecurso() throws  SQLException{
        sc.nextLine();
        PreparedStatement ps1 = cnx.prepareStatement("DELETE FROM personas WHERE id = ?");
        System.out.println("Dar de baja un recurso");
        System.out.print("Introduce el id del recurso: ");
        int id=sc.nextInt();
        ps1.setInt(1,id);
        ps1.executeUpdate();
        ps1.close();
    }
}
