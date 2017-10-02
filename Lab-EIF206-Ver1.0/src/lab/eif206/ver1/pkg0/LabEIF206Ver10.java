/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.eif206.ver1.pkg0;


import Control.ControlIntrfzAdmin;
import Interfaz.InterfazAdministrador;
import LogicaDeNegocio.Administrador;
import Modelo.Modelos.ModeloAdministrador;
import java.time.LocalDate;


/**
 *
 * @author edva5
 */
public class LabEIF206Ver10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AccesoDatos.AccesoDatosAdministrador.getInstance().insertar(new Administrador("116240021", "Eddy", "dad", "sada", "sda", "sss", "eer", LocalDate.now()));
        AccesoDatos.AccesoDatosAdministrador.getInstance().insertar(new Administrador("116240022", "Eddy", "dad", "sada", "sda", "sss", "eer", LocalDate.now()));
        AccesoDatos.AccesoDatosAdministrador.getInstance().insertar(new Administrador("116240023", "Eddy", "dad", "sada", "sda", "sss", "eer", LocalDate.now()));
        AccesoDatos.AccesoDatosAdministrador.getInstance().insertar(new Administrador("116240024", "Eddy", "dad", "sada", "sda", "sss", "eer", LocalDate.now()));
        AccesoDatos.AccesoDatosAdministrador.getInstance().insertar(new Administrador("116240025", "Eddy", "dad", "sada", "sda", "sss", "eer", LocalDate.now()));
        ControlIntrfzAdmin controlIntrfzAdmin = new ControlIntrfzAdmin(new InterfazAdministrador(),new ModeloAdministrador());
        
    }
    
}
