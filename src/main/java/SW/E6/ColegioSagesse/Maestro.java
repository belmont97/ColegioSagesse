package SW.E6.ColegioSagesse;

public class Maestro {
    private String name;
    private String rfc;
    private String curp;
    private String address;
    private String materia;
    private int ID;
    private int edad;
    private int phone;

    public Maestro() {
        this.name = "";
        ID = 0;
    }

    public Maestro(String name, int iD) {
        this.name = name;
        ID = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public Maestro(String name, String rfc, String curp, String address, String materia, int iD, int edad, int phone) {
        this.name = name;
        this.rfc = rfc;
        this.curp = curp;
        this.address = address;
        this.materia = materia;
        ID = iD;
        this.edad = edad;
        this.phone = phone;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
    
}
