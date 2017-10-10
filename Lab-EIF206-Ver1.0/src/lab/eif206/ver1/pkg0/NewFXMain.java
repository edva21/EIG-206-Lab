/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.eif206.ver1.pkg0;

import Control.Control;
import Control.ControlAdministrador;
import LogicaDeNegocio.Administrador;
import Modelo.Modelo;
import Modelo.Modelos.ModeloAdministrador;
import Vista.Inicio.LogInVista;
import Vista.Inicio.PrimeraEscenaVista;
import Vista.VistaAdministrador;
import Vista.VistaInicio;
import java.time.LocalDate;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author edva5
 */
public class NewFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {                
    VistaInicio  inicio= new VistaInicio();
    Modelo modelo = new Modelo();
    Control control= new Control(inicio, modelo);
                        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
