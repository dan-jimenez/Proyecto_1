package Modelo;

public class User {

    private String nombre;
    private String cedula;
    private String correo;
    private Provincia provincia;

    public User(){}
    public User(String nom, String ced, String elCorreo, int prov)
    {
        this.nombre = nom;
        this.correo = elCorreo;
        this.cedula = ced;
        if(prov == 1)
        {
            this.provincia = Provincia.SANJOSE;
        }
        if(prov == 2)
        {
            this.provincia = Provincia.ALAJUELA;
        }
        if(prov == 3)
        {
            this.provincia = Provincia.CARTAGO;
        }
        if(prov == 4)
        {
            this.provincia = Provincia.HEREDIA;
        }
        if(prov == 5)
        {
            this.provincia = Provincia.GUANACASTE;
        }
        if(prov == 6)
        {
            this.provincia = Provincia.PUNTARENAS;
        }
        if(prov == 7)
        {
            this.provincia = Provincia.LIMON;
        }
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getCedula() {
        return cedula;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getCorreo() {
        return correo;
    }

    public void setProvincia(int prov) {
        if(prov == 1)
        {
            this.provincia = Provincia.SANJOSE;
        }
        if(prov == 2)
        {
            this.provincia = Provincia.ALAJUELA;
        }
        if(prov == 3)
        {
            this.provincia = Provincia.CARTAGO;
        }
        if(prov == 4)
        {
            this.provincia = Provincia.HEREDIA;
        }
        if(prov == 5)
        {
            this.provincia = Provincia.GUANACASTE;
        }
        if(prov == 6)
        {
            this.provincia = Provincia.PUNTARENAS;
        }
        if(prov == 7)
        {
            this.provincia = Provincia.LIMON;
        }
    }
    public Provincia getProvincia() {
        return provincia;
    }

    public String desglosar()
    {
        String line = "";
        line = line + " Nombre: " + getNombre();
        line = line + " - Cedula: " + getCedula();
        line = line + " - Correo: " + getCorreo();
        line = line + " - Reside en: " + getProvincia();
        return line;
    }

    public boolean verificar()
    {
        return false; //se supone que aqui si es nesesario veridfico que este bien el correo y la cedula y eso;
    }
}
