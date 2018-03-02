/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin_20;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jose
 */
public class Datos {

    Scanner sc;

    PrintWriter escribir;

    ArrayList<Libros> libreria = new ArrayList();

    Libros libro = null; // obxeto para almacenar un libro
    String linea; // variable para almacenar os datos de cada linea

    //metodo para engadir libros ao ficheiro 
    public void engadir() {

        String titulo = JOptionPane.showInputDialog("Inserta o titulo do libro");

        String autor = JOptionPane.showInputDialog("inserte o autor do libro");

        float precio = Float.parseFloat(JOptionPane.showInputDialog("inserte o precio do libro"));

        int cantidade = Integer.parseInt(JOptionPane.showInputDialog("inserte o numero de libros"));

        try {

            File fich = new File("libros.txt");

            escribir = new PrintWriter(new FileWriter(fich, true));
            libro = new Libros(titulo, autor, precio, cantidade);

            escribir.println(libro.nome + "," + libro.autor + "," + libro.precio + "," + libro.unidades);

        } catch (FileNotFoundException ex) {

            System.out.println("Error de escritura" + ex);

        } catch (IOException ex) {

            System.out.println("Error de escritura" + ex);

        } finally {

            escribir.close();

        }

    }

    // metodo para visualizar todos os libros da nosa libreria
    public void visualizar() {

        String[] datos = new String[4];// Array para almacenar cada un dos datos que temos en cada unha das lineas

        try {

            sc = new Scanner(new File("libros.txt"));

            while (sc.hasNextLine()) //percorremos todas as lineas do ficheiro
            {

                linea = sc.nextLine(); // almacenamos en Linea cada unha das lineas do ficheiro

                datos = linea.split(","); // indicamos separador coma e metemos cad unha das partes no array 

                libro = new Libros(datos[0], datos[1], Float.parseFloat(datos[2]), Integer.parseInt(datos[3])); // creamos o obxeto libro

                libreria.add(libro);

            }
            sc.close();

            JOptionPane.showMessageDialog(null, libro.imprimirLibreria(libreria)); // imprimimos en pantalla a información

        } catch (FileNotFoundException ex) {

            System.out.println("non se pudo acceder a información");

        }

    }

    public void consultar() {
        String linea; // variable para almacenar os datos de cada linea
        String[] datos = new String[4];// Array para almacenar cada un dos datos que temos en cada unha das lineas

        try {
            boolean marcador = false; // para indicar se hay alguna coincidencia ou non 
            String titulo = JOptionPane.showInputDialog("escriba o titulo do libro a consultar");
            sc = new Scanner(new File("libros.txt"));
            while (sc.hasNextLine()) {

                linea = sc.nextLine();
                datos = linea.split(",");
                libro = new Libros(datos[0], datos[1], Float.parseFloat(datos[2]), Integer.parseInt(datos[3]));
                System.out.println(libro);
                if (titulo.equalsIgnoreCase(libro.getNome())) {
                    JOptionPane.showMessageDialog(null, "o prezo do libro é " + datos[2] + "€");
                    marcador = true;
                    System.out.println(marcador);
                    break;
                } else {
                    libro = null;
                }
            }
            if (marcador == false) {
                JOptionPane.showMessageDialog(null, "libro non atopado");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("ficheiro non atopado");

        } finally {
            sc.close();
        }

    }

    public void borrarLibro() {
        BufferedReader lectura = null;
        // para borrar elementos necesitamos un ficheiro auxiliar
        File ficheiro1 = new File("libros.txt");
        File ficheiro2 = new File("libros2.txt");
        boolean lineas;
        try {

            lectura = new BufferedReader(new FileReader("libros.txt"));
            PrintWriter escribir2 = new PrintWriter(new FileWriter(ficheiro2, true));
            while ((lineas = lectura.readLine() != null)) {
                String enStock = linea;
                System.out.println(linea);
                if (enStock.contains("0") != true)// si contiene el numero cero damos por echo que se trata del stock porque la libreria no tiene ningun libro a coste cero
                {
                    escribir.println(enStock);
                }
            }
            lectura.close();
            escribir2.close();
            ficheiro1.delete();
            ficheiro2.renameTo(ficheiro1);

        } catch (FileNotFoundException ex) {
            System.out.println("error" + ex);
        } catch (IOException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                lectura.close();
            } catch (IOException ex) {
                System.out.println("error" + ex);

            }
        }
    }

    public void modificarLibro() {

        File ficheiro1 = new File("libros.txt");

        File ficheiro2 = new File("libros2.txt");

        try {

            String titulo = JOptionPane.showInputDialog("Inserte o titulo do libro");

            float precio = Float.parseFloat(JOptionPane.showInputDialog("Introduza o novo precio"));

        
            final BufferedReader lectura = new BufferedReader(new FileReader("libros.txt"));

            escribir = new PrintWriter(new FileWriter(ficheiro2, true));

            while ((linea = lectura.readLine()) != null) {

                String ben = linea;

                if (ben.contains(titulo) != true) {

                    escribir.println(ben);

                } else {

                    //Separamos la linea por comas
                    String[] datos = ben.split("\\s*,\\s*");

                    ben= datos[0] + ", " + datos[1] + ", " + datos[2] + ": " + datos[3];

                    escribir.println(ben);

                    ben = "";
                   
               

                }

            }

            lectura.close();

            escribir.close();

            ficheiro1.delete();

            
         ficheiro2.renameTo(ficheiro1);


        } catch (FileNotFoundException ex) {

            System.out.println("Error " + ex);

        } catch (IOException ex) {

            System.out.println("Error " + ex);

        }

    }



}
