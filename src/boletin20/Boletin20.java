/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin20;

import javax.swing.JOptionPane;

/**
 *
 * @author jdominguezmartinan
 */
public class Boletin20
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
            case 2:
               obxDatos.visualizar();
        }
    }
    
}
