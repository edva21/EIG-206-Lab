/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Datos.Datos;
import Modelo.Modelo;
import Vista.VistaInicio;
import java.io.IOException;
import java.util.EventListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

/**
 *
 * @author edva5
 */
public class Control implements EventHandler{
    Datos datos;
    VistaInicio vista;
    Modelo modelo;
    ControlAdministrador controlAdministrador;
    ControlCarrera controlCarrera;
    

    public Control() {
    }

    public Control(VistaInicio vista, Modelo modelo) {        
        this.vista = vista;
        this.modelo = modelo;
        vista.setControl(this);
        vista.getPrincipal().getStage().show();
    }
    
    

    @Override
    public void handle(Event event) {
        if (event.getSource() instanceof MenuItem) {
            switch(((MenuItem)event.getSource()).getId()){
                case "administradorMnuItm":    
                    System.out.println("Control.Control.handle() administradorMnuItm");
                    break;
                case "estudianteMnuItm":
                    System.out.println("Control.Control.handle() estudianteMnuItm");
                    break;
                case "matriculadorMnuItm":
                    System.out.println("Control.Control.handle() matriculadorMnuItm");
                    break;
                case "profesorMnuItm":
                    System.out.println("Control.Control.handle() profesorMnuItm");
                    break;
            }
        }
    }
        
    
}
