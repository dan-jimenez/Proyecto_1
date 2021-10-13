
package Modelo;

/**
 *
 * @author kevin
 */
public class UsoDeExcell {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] header = new String[]{"NOMBRE","APELLIDO","CURSO"};
        
        String[][] data = new String[][]{
            {"Danny", "Jimenez","POO"},
            {"Natifpee","Duran","POO"},
            {"Kevin","Salazar","POO"}
        };
        
        Excel nuevo=new Excel("archivoPrueba2", "hoja1",header,data); //no es necesario agregar extension
        nuevo.EscribirExcel(nuevo.getNombreArchivo(),nuevo.getHoja(),nuevo.getHeader(), nuevo.getDatos());
        Excel viejo=new Excel(); //no es necesario agregar extension
        System.out.println("----------------------------------------");
        
        nuevo.LeerExcel("archivoPrueba2.xlsx");
        nuevo.LeerExcel(nuevo.getNombreArchivo());
    }
}
