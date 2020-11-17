package mx.uv.basededatos80688;

import java.sql.Conection;
import java.sql.SQLException;

public class Conexion {
    private static String  url ="jdbc:mysql://127.0.0.0:3306/ejemplo_simple?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false";
    
    private static String driverName = "com.mysql.cj.jdbc.Driver";
    private static String user = "root";
    private static String password = "";
    private static Conection conection = null;

    public static Conection getConection(){
        try {
            Class.forName(driverName);
            conection = DriverManager.getConection(url, user, password);
            System.out.println("Succes conection")
        }catch (SQLException sqle){
            System.out.println("Failed to create the database connection");
            sqle.printStackTrace();
        }catch (ClassNotFoundException cnfe){
            System.out.println("Driver not found")
        }
            return connection;
    }

}
