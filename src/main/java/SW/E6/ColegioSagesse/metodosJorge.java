package SW.E6.ColegioSagesse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class metodosJorge {
    //private static Conexion conexion = new Conexion();
    public static String getMaestros() {
        PreparedStatement stm = null;
        Connection con = null;
        ResultSet rs = null;
        String msj = "";
        //con = conexion.getConnection();
        try{
            String sql = "SELECT * FROM usuarios";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            if(rs!=null){
                msj = msj + "<table class='table table-striped table-borderless table-hover'>";
                msj = msj + "<thead><tr><th scope='col'>Maestro</th><th scope='col'>Modificar</th><th scope='col'>Ver</th>";
                msj = msj + "<th scope='col'>Eliminar</th></tr></thead><tbody>";
                while (rs.next()) {               // Situar el cursor 
                    msj = msj + "<tr>";
                    msj = msj + "<th scope='row'><a href='hfhfhfhf'>Maestro 1</a></th>";
                    msj = msj + "<td><a class='btn btn-warning' href='editDino.php?id=1'><img src='Bootstrap/iconos/pencil.svg'></a></td>";
                    msj = msj + "<td><a class='btn btn-info' href='changePhoto.php?id=1' title='Cambiar imagen'><img src='Bootstrap/iconos/eye.svg'></a></td>";
                    msj = msj + "<td><a class='btn btn-danger' href='deleteDino.php?id=1'><img src='Bootstrap/iconos/trashcan.svg'></a></td>";
                    msj = msj + "</tr>";
                    //empnum = rs.getString(1);    // Obtener el valor de la primera columna
                    //phonenum = rs.getString(2);  // Obtener el valor de la primera columna
                }
            }else{
                msj = "Datos no encontrados";
            }
        }catch(Exception e){
            System.out.println("Error");
            e.printStackTrace();
        }finally{
            if(rs != null){
                try{
                    rs.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
                rs = null;
            }
            if(stm != null){
                try{
                    stm.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
                stm = null;
            }try{
                con.close();
                System.out.println("Closed connection");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return msj;
    }
}
