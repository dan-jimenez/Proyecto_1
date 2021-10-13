/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author kevin
 */
public class Excel {
    private String nombreArchivo;
    private String hoja;
    private String[] header;
    private String[][] datos;
    private ArrayList<ArrayList<String>> datosLeidos;
    
    /**
     *
     */
    public Excel() {
    }

    /**
     *
     * @param nombreArchivo
     * @param hoja
     * @param header
     * @param datos
     */
    public Excel(String nombreArchivo, String hoja, String[] header, String[][] datos) {
        this.nombreArchivo = nombreArchivo+".xlsx";
        this.hoja = hoja;
        this.header = header;
        this.datos = datos;
    }
    
    /**
     *
     * @return
     */
    public String getNombreArchivo() {
        return nombreArchivo;
    }

    /**
     *
     * @param nombreArchivo
     */
    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    /**
     *
     * @return
     */
    public String getHoja() {
        return hoja;
    }

    /**
     *
     * @param hoja
     */
    public void setHoja(String hoja) {
        this.hoja = hoja;
    }

    /**
     *
     * @return
     */
    public String[] getHeader() {
        return header;
    }

    /**
     *
     * @param header
     */
    public void setHeader(String[] header) {
        this.header = header;
    }

    /**
     *
     * @return
     */
    public String[][] getDatos() {
        return datos;
    }

    /**
     *
     * @param datos
     */
    public void setDatos(String[][] datos) {
        this.datos = datos;
    }
    
    /**
     *
     * @param nombreExcel
     */
    public void LeerExcel(String nombreExcel){
        try(FileInputStream file = new FileInputStream(new File(nombreExcel))){
            //Leer archivo de Excel
            XSSFWorkbook libro = new XSSFWorkbook(file);
            // Obtener la hoja que se va a leer
            XSSFSheet sheet = libro.getSheetAt(0);
            // Obtener todas las filas de la hoja de Excel
            Iterator<Row> rowIterator = sheet.iterator();
            
            Row row;
            // Se recorre cada fila hasta el final
            while(rowIterator.hasNext()) {
                row = rowIterator.next();
                // Se obtienen las celdas por fila
                Iterator<Cell> cellIterator = row.cellIterator();
                Cell cell;
                // Se recorre cada celda
                while(cellIterator.hasNext()) {
                    // Se obtiene la celda en especifico y se imprime
                    cell = cellIterator.next();
                    System.out.print(cell.getStringCellValue()+ " - ");
                }
                System.out.println("");
            }
            
        } catch(Exception e) {
            e.getMessage();
        }
    }
    
    /**
     *
     * @param nombreArchivo
     * @param hoja
     * @param header
     * @param datos
     */
    public void EscribirExcel(String nombreArchivo, String hoja, String[] header, String[][] datos) {
        XSSFWorkbook libro = new XSSFWorkbook();
        XSSFSheet hoja1 = libro.createSheet(hoja);
        
        // Generar los datos para el documento
        for(int i = 0 ; i <= datos.length ; i++) {
            XSSFRow row = hoja1.createRow(i); // Se crea la fila
            for(int j = 0 ; j < header.length ; j++) {
                if(i == 0) { // Para la cabecera
                    XSSFCell cell = row.createCell(j); // Se crean las celdas pra la cabecera
                    cell.setCellValue(header[j]); // Se aniade el contenido
                } else {
                    XSSFCell cell = row.createCell(j); // Se crean las celdas para el contenido
                    cell.setCellValue(datos[i - 1][j]); // Se aniade el contenido
                }
            }
        }   
        // Crear el archivo
        try (OutputStream fileOut = new FileOutputStream(nombreArchivo)){
            System.out.println("SE CREO EL EXCEL");
            libro.write(fileOut);
        } catch(IOException e) {
        }
    }   
    
    /**
     *
     * @param archivo
     */
    public void TrasladarExcel(String archivo){ 
        ArrayList<String> fila = new ArrayList(); 
        datosLeidos = new ArrayList();
        
        try(FileInputStream file = new FileInputStream(new File(archivo))){
            //Leer archivo de Excel
            XSSFWorkbook libro = new XSSFWorkbook(file);
            // Obtener la hoja que se va a leer
            XSSFSheet sheet = libro.getSheetAt(0);
            // Obtener todas las filas de la hoja de Excel
            Iterator<Row> rowIterator = sheet.iterator();
            
            Row row;
            // Se recorre cada fila hasta el final
            while(rowIterator.hasNext()) {
                row = rowIterator.next();
                // Se obtienen las celdas por fila
                Iterator<Cell> cellIterator = row.cellIterator();
                Cell cell;
                // Se recorre cada celda
                while(cellIterator.hasNext()) {
                    // Se obtiene la celda en especifico y se imprime
                    cell = cellIterator.next();
                    fila.add(cell.getStringCellValue());
                }
                datosLeidos.add(fila);
                fila = new ArrayList();
            }
            
        } catch(Exception e) {
            e.getMessage();
        }
    }

    /**
     *
     * @return
     */
    public ArrayList<ArrayList<String>> getDatosLeidos() {
        return datosLeidos;
    }
    
    /**
     *
     * @param lista
     */
    public void imprimirLista(ArrayList lista){ 
            int count=0; 
            while(count<lista.size()){ 
                System.out.println(lista.get(count)); 
                count++; 
            } 
        }
                
    
    
    
    
}