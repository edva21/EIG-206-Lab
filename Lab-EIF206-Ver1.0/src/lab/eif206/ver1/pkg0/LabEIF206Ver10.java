/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.eif206.ver1.pkg0;

import AccesoDatos.AccesoDatoAdministrador;
import Control.AdministradorControl;
import Interfaz.AdministradorVista;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author edva5
 */
public class LabEIF206Ver10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //JOptionPane.showMessageDialog(null, "Hola Mundo","Prblem Lodaing",JOptionPane.PLAIN_MESSAGE);        
        AccesoDatos.AccesoDatoAdministrador modelo= new AccesoDatoAdministrador();
        Interfaz.AdministradorVista vista= new AdministradorVista();
        Control.AdministradorControl Control = new AdministradorControl(modelo, vista);
        vista.setVisible(true);
        //create a frame
        
    }
    
}
