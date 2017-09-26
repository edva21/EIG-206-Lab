/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.eif206.ver1.pkg0;

import Modelo.Modelo;
import Control.Control;
import Interfaz.Dispatcher;
import Interfaz.InterfazCiclo;
import LogicaDeNegocio.Administrador;
import LogicaDeNegocio.Ciclo;
import java.time.LocalDate;
import java.time.Month;
import javafx.util.converter.LocalDateStringConverter;
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
        Dispatcher dispatcher=new Dispatcher();
        Modelo modelo=new Modelo();
        modelo.set(new Administrador("116240021", "Eddy", "Valverde", "Garro", "84444530", "edva5901112@gmail.com", "SeaSapo", LocalDate.now()));
        modelo.set(new Administrador("120042611", "Ydde", "Edrevlav", "Orrag", "03544448", "211095avde@gmail.com", "soap", LocalDate.now()));
        modelo.set(new Administrador("123456789", "Abcd", "Defgh", "Ijklm", "123456", "loco@gmail.com", "loco", LocalDate.now()));
        
        /************************************************************************************/        
        Control control = new Control(modelo, dispatcher);
    }
    
}
