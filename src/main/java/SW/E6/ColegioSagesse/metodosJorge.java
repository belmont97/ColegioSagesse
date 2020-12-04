package SW.E6.ColegioSagesse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class metodosJorge {
    private static Conexion conexion = new Conexion();
    public static List<Maestro> getMaestros() {
        PreparedStatement stm = null;
        Connection con = null;
        ResultSet rs = null;
        List<Maestro> resultado = new ArrayList<>();
        String msj = "";
        con = conexion.getConection();
        try{
            String sql = "SELECT NoTrabajador, Nombre FROM MAESTRO";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            if(rs!=null){
                //msj = msj + "<table class='table table-striped table-borderless table-hover'>";
                //msj = msj + "<thead><tr><th scope='col'>Maestro</th><th scope='col'>Modificar</th>";
                //msj = msj + "<th scope='col'>Eliminar</th></tr></thead><tbody>";
                while (rs.next()) {               // Situar el cursor 
                    //msj = msj + "<tr>";
                    //msj = msj + "<th scope='row'><a href='verInfo.php?id="+rs.getString(1)+"'>"+rs.getString(2)+"</a></th>";
                    //msj = msj + "<td><a class='btn btn-warning' href='modificar.php?id="+rs.getString(1)+"'><img src='../Bootstrap/iconos/pencil.svg'></a></td>";
                    //msj = msj + "<td><a class='btn btn-danger' href='eliminar.php?id="+rs.getString(1)+"'><img src='../Bootstrap/iconos/trashcan.svg'></a></td>";
                    //msj = msj + "</tr>";
                    //empnum = rs.getString(1);    // Obtener el valor de la primera columna
                    //phonenum = rs.getString(2);  // Obtener el valor de la primera columna
                    Maestro mtr = new Maestro(rs.getString(2), rs.getInt(1));
                    resultado.add(mtr);
                }
                //msj = msj + "</tbody></table>";
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
        return resultado;
    }
    public String delete(int numTrabajador){
        String msj = " ";
        PreparedStatement stm = null;
        Connection con = null;
        ResultSet rs = null;
        con = conexion.getConection();
        try{
            String sql = "DELETE FROM maestro WHERE NoTrabajador=?";
            stm = con.prepareStatement(sql);
            stm.setInt(1, numTrabajador);
            if(stm.executeUpdate()>0){
                msj = "Maestro eliminado";
            }else{
                msj = "Maestro no eliminado";
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
    public Maestro verInfoMtro(int id){
        String msj = " ";
        PreparedStatement stm = null;
        Connection con = null;
        ResultSet rs = null;
        Maestro mtro = new Maestro();
        con = conexion.getConection();
        try{
            String sql = "SELECT * FROM maestro WHERE NoTrabajador=?";
            stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if(rs!=null){ 
                while (rs.next()) {  
                    mtro = new Maestro(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(8), rs.getInt(1), rs.getInt(6), rs.getInt(7));
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
        return mtro;
    }
    public String update(Maestro mtr){
        String msj = " ";
        PreparedStatement stm = null;
        Connection con = null;
        ResultSet rs = null;
        con = conexion.getConection();
        try{
            String sql = "UPDATE maestro SET Nombre=?, RFC=?, Curp=?, Direccion=?, Edad=?, No_Telefono=?, Materia=? WHERE NoTrabajador=?";
            stm = con.prepareStatement(sql);
            stm.setString(1, mtr.getName());
            stm.setString(2, mtr.getRfc());
            stm.setString(3, mtr.getCurp());
            stm.setString(4, mtr.getAddress());
            stm.setInt(5, mtr.getEdad());
            stm.setInt(6, mtr.getPhone());
            stm.setString(7, mtr.getMateria());
            stm.setInt(8, mtr.getID());
            if(stm.executeUpdate()>0){
                msj = "Usuario eliminado";
            }else{
                msj = "Usuario no eliminado";
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
