/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.eif206.ver1.pkg0;


import Control.ControlIntrfzAdmin;
import Datos.Datos;
import Interfaz.InterfazAdministrador;
import LogicaDeNegocio.Administrador;
import Modelo.Modelos.ModeloAdministrador;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author edva5
 */
public class LabEIF206Ver10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {                
        InterfazAdministrador interfazAdministrador = new InterfazAdministrador();
        ModeloAdministrador modelo = new ModeloAdministrador();
        try {
            ControlIntrfzAdmin controlIntrfzAdmin = new ControlIntrfzAdmin(interfazAdministrador, modelo);
        } catch (IOException ex) {
            Logger.getLogger(LabEIF206Ver10.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LabEIF206Ver10.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
