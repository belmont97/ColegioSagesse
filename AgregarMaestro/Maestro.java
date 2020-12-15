package SW.E6.ColegioSagesse;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.mysql.cj.Query;
import com.mysql.cj.xdevapi.Statement;

import mx.uv.basededatos80688.Conexion;

public class Maestro {
    private String numeroDeTrabajador;
    private String nombre;
    private String curp;
    private String rfc;
    private String direccion;
    private String numeroCelular;
    private String correoInst;
    private String edad; 
    private String imparte;
    private String grado;
    private String nombreMateria;

    public static Boolean guardarMaestro(Maestro maestro){
        String consulta = "INSERT INTO MAESTRO VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        Boolean validacion = false;
        Connection conexion = Conexion.getConection();
        try {
            PreparedStatement presta = conexion.prepareStatement(consulta);
            presta.setString(1, maestro.getNumeroDeTrabajador() );
            presta.setString(2, maestro.getNombre() );
            presta.setString(3, maestro.getRfc() );
            presta.setString(4, maestro.getCurp() );
            presta.setString(5, maestro.getDireccion() );
            presta.setString(6, maestro.getEdad() );
            presta.setString(7, maestro.getNumeroCelular() );
            presta.setString(8, maestro.getCorreoInst() );
            presta.setString(9, maestro.getImparte() );
            presta.setString(10, maestro.getGrado() );
            presta.setString(11, maestro.getNombreMateria() );
            validacion = presta.execute();
            presta.close();
           
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }finally{
            try {
                if (!conexion.isClosed()){
                    conexion.close();
                }
            } catch (Exception e) {
               
            }
        }
       


        return validacion;
    }

    public String getNumeroDeTrabajador() {
        return numeroDeTrabajador;
    }

    public void setNumeroDeTrabajador(String numeroDeTrabajador) {
        this.numeroDeTrabajador = numeroDeTrabajador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getCorreoInst() {
        return correoInst;
    }

    public void setCorreoInst(String correoInst) {
        this.correoInst = correoInst;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getImparte() {
        return imparte;
    }

    public void setImparte(String imparte) {
        this.imparte = imparte;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }
}
