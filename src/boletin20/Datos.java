/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin20;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;


/**
 *
 * @author jdominguezmartinan
 */
public class Datos
{
    Scanner sc; // empregaremos un obxeto de tipo scanner para poder recorrer o fiheiro
    ArrayList<Libros>libreria=new ArrayList();
    Libros libro=null; // obxeto para almacenar un libro
    
    //metodo para engadir libros ao ficheiro 
    public void engadir(){
        try
        {
            PrintWriter ficheiroLibros=new PrintWriter(new FileWriter(new File("libros.txt"),true));
            String titulo=JOptionPane.showInputDialog("Escribe o titulo do libro");
            String autor=JOptionPane.showInputDialog("escribe o autor do libro");
            Float prezo=Float.parseFloat(JOptionPane.showInputDialog("inserte o prezo do libro"));
            int cantidade=Integer.parseInt(JOptionPane.showInputDialog("inserte a cantidade de libros"));
            ficheiroLibros.println(titulo+","+autor+","+prezo+","+cantidade+"\n");
            
            
            
        } catch(IOException ex)
        {
            System.out.println("erro ao ler o arquivo");
        }
    }
    
    // metodo para visualizar todos os libros da nosa libreria
    public void visualizar(){
        String linea; // variable para almacenar os datos de cada linea
            String[]datos=new String[4];// Array para almacenar cada un dos datos que temos en cada unha das lineas
            
        try
        {  
            sc=new Scanner(new File("libros.txt"));
            while (sc.hasNextLine()) //percorremos todas as lineas do ficheiro
            {
                linea = sc.nextLine(); // almacenamos en Linea cada unha das lineas do ficheiro
                datos = linea.split(","); // indicamos separador coma e metemos cad unha das partes no array 
               libro = new Libros(datos[0],datos[1],Float.parseFloat(datos[2]),Integer.parseInt(datos[3])); // creamos o obxeto libro
               libreria.add(libro);
                
            }
            JOptionPane.showMessageDialog(null,libro.imprimirLibreria(libreria)); // imprimimos en pantalla a información
        } catch(FileNotFoundException ex)
        {
            System.out.println("non se pudo acceder a información");
        }
    }
    
}
