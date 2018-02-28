/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin_20;

import java.util.ArrayList;

/**
 *
 * @author jose
 */
public class Libros {
     String nome;
    String autor;
    Float precio;
    int unidades;

    public Libros()
    {
    }

    public Libros(String nome,String autor,Float precio,int unidades)
    {
        this.nome = nome;
        this.autor = autor;
        this.precio = precio;
        this.unidades = unidades;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getAutor()
    {
        return autor;
    }

    public void setAutor(String autor)
    {
        this.autor = autor;
    }

    public Float getPrecio()
    {
        return precio;
    }

    public void setPrecio(Float precio)
    {
        this.precio = precio;
    }

    public int getUnidades()
    {
        return unidades;
    }

    public void setUnidades(int unidades)
    {
        this.unidades = unidades;
    }

    @Override
    public String toString()
    {
        
        return "\n"+"nome: "+nome+" autor: "+autor+" precio: "+precio+"€"+" unidades: "+unidades;
    }
    // ao imprimir o arrayList co toString, imprimimos a visualizacion do array con corchetes, polo tanto para que sala a lista de libros completa sen corchetes
    //facemos o seguinte metodo, asi aparecenos a informacion limpa
    
    public String imprimirLibreria(ArrayList<Libros> lib)
    {
        String datosArray = "";
    for (Libros elemento:lib) {
        datosArray += elemento;
       
    }
    return datosArray;
    }
}
