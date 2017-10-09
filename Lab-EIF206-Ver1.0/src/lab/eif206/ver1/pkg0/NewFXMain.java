/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.eif206.ver1.pkg0;

import Control.Control;
import Control.ControlAdministrador;
import Modelo.Modelo;
import Modelo.Modelos.ModeloAdministrador;
import Vista.Inicio.LogInVista;
import Vista.Inicio.PrimeraEscenaVista;
import Vista.VistaAdministrador;
import Vista.VistaInicio;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author edva5
 */
public class NewFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {        
        
        Vista.VistaInicio vista = new VistaInicio();
        Modelo modelo = new Modelo();
        Control control = new Control(vista, modelo);
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
