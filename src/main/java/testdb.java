import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class testdb {
    public static void main(String[] args){
        String url ="jdbc:mariadb://localhost:3306/demo_java";
        String user="root";
        String password="";
        try {
            Connection cnx= DriverManager.getConnection(url,user,password);
            System.out.println("Estado de la conexion");
            System.out.println(cnx.isClosed()?"cerrada":"abierta");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
