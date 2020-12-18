package SW.E6.ColegioSagesse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class metodosJorge {
    public static List<Maestro> getMaestros() {
        PreparedStatement stm = null;
        Connection con = null;
        ResultSet rs = null;
        List<Maestro> resultado = new ArrayList<>();
        con = Conexion.getConection();
        try{
            String sql = "SELECT NoTrabajador, Nombre FROM MAESTRO";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            if(rs!=null){
                while (rs.next()) {               // Situar el cursor 
                    Maestro mtr = new Maestro(rs.getString(2), rs.getInt(1));
                    resultado.add(mtr);
                }
            }else{
                System.out.println("Datos no encontrados"); 
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
        con = Conexion.getConection();
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
        PreparedStatement stm = null;
        Connection con = null;
        ResultSet rs = null;
        Maestro mtro = new Maestro();
        con = Conexion.getConection();
        try{
            String sql = "SELECT * FROM maestro WHERE NoTrabajador=?";
            stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if(rs!=null){ 
                while (rs.next()) {  
                    mtro = new Maestro(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getInt(10), rs.getString(11));
                }
            }else{
                System.out.println("Datos no encontrados");
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
        con = Conexion.getConection();
        try{
            String sql = "UPDATE maestro SET Nombre=?, RFC=?, Curp=?, Imparte=?, Grado=?, NombreMateria=?, Direccion=?, Edad=?, No_Telefono=?, CorreoInstitucional=? WHERE NoTrabajador=?";
            stm = con.prepareStatement(sql);
            stm.setString(1, mtr.getName());
            stm.setString(2, mtr.getRfc());
            stm.setString(3, mtr.getCurp());
            stm.setString(4, mtr.getImparte());
            stm.setInt(5, mtr.getGrado());
            stm.setString(6, mtr.getMateria());
            stm.setString(7, mtr.getAddress());
            stm.setInt(8, mtr.getEdad());
            stm.setInt(9, mtr.getPhone());
            stm.setString(10, mtr.getEmail());
            stm.setInt(11, mtr.getID());
            if(stm.executeUpdate()>0){
                msj = "Maestro modificado";
            }else{
                msj = "Maestro no modificado";
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
    public static List<Maestro> getMaestrosPublico(int id) {
        PreparedStatement stm = null;
        Connection con = null;
        ResultSet rs = null;
        List<Maestro> resultado = new ArrayList<>();
        con = Conexion.getConection();
        try{
            String sql = "SELECT * FROM MAESTRO WHERE Grado=?";
            stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if(rs!=null){
                while (rs.next()) {               // Situar el cursor 
                    Maestro mtr = new Maestro(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getInt(10), rs.getString(11));
                    resultado.add(mtr);
                }
            }else{
                System.out.println("Datos no encontrados");
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

    public String guardarMaestro(Maestro maestro){
        String validacion = "";
        PreparedStatement stm = null;
        ResultSet  rs = null;
        Connection conexion = Conexion.getConection();
        try {
            String consulta = "INSERT INTO maestro ( NoTrabajador,  Nombre, RFC, Curp, Imparte, Grado, NombreMateria, Direccion, Edad, No_Telefono, CorreoInstitucional) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            stm = conexion.prepareStatement(consulta);
            stm.setInt(1, maestro.getID());
            stm.setString(2, maestro.getName() );
            stm.setString(3, maestro.getRfc() );
            stm.setString(4, maestro.getCurp() );
            stm.setString(5, maestro.getImparte() );
            stm.setInt(6, maestro.getGrado() );
            stm.setString(7, maestro.getMateria() );
            stm.setString(8, maestro.getAddress() );
            stm.setInt(9, maestro.getEdad() );
            stm.setInt(10, maestro.getPhone() );
            stm.setString(11, maestro.getEmail() );
           if(stm.executeUpdate()> 0 )
                validacion = "Se agregó un maestro";
           else
                validacion = "Error al agregar maestro";
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }finally{
            if(rs != null){
                try{
                    rs.close();
                }catch(SQLException sqle){
                    System.out.println(sqle.getMessage());
                }
                rs = null;
            }
            if(stm != null){
                try{
                    stm.close();
                }catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
                stm = null;
            }
            try {
                conexion.close();
                System.out.println("Cerrando conexion");
            } catch (Exception cone) {
               System.out.println(cone.getMessage());
            }
        }
        return validacion;
    }
}
