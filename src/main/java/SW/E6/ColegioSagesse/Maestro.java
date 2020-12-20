package SW.E6.ColegioSagesse;

public class Maestro {
    private int ID;
    private String name;
    private String rfc;
    private String curp;
    private String imparte;
    private String grado;
    private String materia;
    private String address;
    private String edad;
    private String phone;
    private String email;

    public Maestro() {
        this.name = "";
        ID = 0;
    }

    public Maestro(String name, int iD) {
        this.name = name;
        ID = iD;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Maestro(int iD, String name, String rfc, String curp, String imparte, String grado, String materia,
            String address, String edad, String phone, String email) {
        this.ID = iD;
        this.name = name;
        this.rfc = rfc;
        this.curp = curp;
        this.imparte = imparte;
        this.grado = grado;
        this.materia = materia;
        this.address = address;
        this.edad = edad;
        this.phone = phone;
        this.email = email;
    }
    
}
