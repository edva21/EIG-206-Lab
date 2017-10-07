/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Datos.Datos;
import Modelo.Modelos.ModeloCarrera;
import Vista.VistaCarrera;

/**
 *
 * @author edva5
 */
public class ControlCarrera {    
    private Modelo.Modelos.ModeloCarrera modelo;    
    private Vista.VistaCarrera vista;  
    public ControlCarrera() {
        modelo= new ModeloCarrera();
        vista = new VistaCarrera();        
    }
    
}
