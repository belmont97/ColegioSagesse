package SW.E6.ColegioSagesse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    //Conexion de BD local
    private static String  url ="jdbc:mysql://localhost:3306/colegio?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false";
    
    private static String driverName = "com.mysql.cj.jdbc.Driver";
    private static String user = "root";
    private static String password = "";
    private static Connection conection = null;


    //Conexion de BD remota (en nube)
    /*private static String  url ="jdbc:mysql://www.db4free.net/:3306/colegiosag?serverTimezone=UTC&useLegacyDatetimeCode=false";
    
    private static String driverName = "com.mysql.cj.jdbc.Driver";
    private static String user = "srgato";
    private static String password = "Xbox3605";
    private static Connection conection = null;*/

    public static Connection getConection(){
        try {
            Class.forName(driverName);
            conection = DriverManager.getConnection(url, user, password);
            System.out.println("Succes conection");
        }catch (SQLException sqle){
            System.out.println("Failed to create the database connection");
            sqle.printStackTrace();
        }catch (ClassNotFoundException cnfe){
            System.out.println("Driver not found");
        }
            return conection;
    }

}
