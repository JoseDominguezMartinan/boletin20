/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin_20;

import javax.swing.JOptionPane;

/**
 *
 * @author jose
 */
public class Boletin_20
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        Datos obxDatos=new Datos();
        int op;
        String[]botones={"engadir","consultar","visualizar","borrar","modificar","sair"};
        op=JOptionPane.showOptionDialog(null,"Libreria Daniel Castelao","Seleccione opción"
                ,JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,botones,null);
        switch(op){
            case 0:
                obxDatos.engadir();
                break;
            case 1:
                obxDatos.consultar();
                break;
            case 2:
               obxDatos.visualizar();
               break;
            case 3:
                obxDatos.borrarLibro();
                break;
            case 4:
            obxDatos.modificarLibro();
            break;
            default:
                System.out.println("opción non valida");
        }
    }
    
}
