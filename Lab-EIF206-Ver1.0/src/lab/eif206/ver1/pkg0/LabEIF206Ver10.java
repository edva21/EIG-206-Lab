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
        
/************************************************************************************/        
        Control control = new Control(modelo, dispatcher);
    }
    
}
