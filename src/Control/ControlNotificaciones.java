package Control;

import Modelo.Excel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Danny Jimenez
 */
public class ControlNotificaciones {
    private static Excel usuarios = new Excel();

    /**
     *
     */
    public ControlNotificaciones() {
    }

    /**
     *
     * @return
     */
    public static Excel getUsuarios() {
        return usuarios;
    }

    /**
     *
     * @param usuarios
     */
    public static void setUsuarios(Excel usuarios) {
        ControlNotificaciones.usuarios = usuarios;
    }
    
    /**
     *
     * @param nombre
     * @param numero
     * @param correo
     */
    public static void agregarUsuaro(String nombre, String numero, String correo){
        Pattern ptNombre = Pattern.compile("[A-Za-z]* [A-Za-z]*");
        Matcher mtNombre = ptNombre.matcher(nombre);
        Pattern ptCelular = Pattern.compile("[0-9]{4}-[0-9]{4}");
        Pattern ptCorreo = Pattern.compile("");
        
        
    }
    
    
}
