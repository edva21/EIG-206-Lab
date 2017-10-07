/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.eif206.ver1.pkg0;

import Control.ControlAdministrador;
import Datos.Datos;
import Modelo.Modelos.ModeloAdministrador;
import Vista.VistaAdministrador;
import Vista.VistaCarrera;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author edva5
 */
public class NewFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {        
        //Funciona
        ModeloAdministrador modelo = new ModeloAdministrador();
        Vista.VistaAdministrador vista = new VistaAdministrador();
        ControlAdministrador control = new ControlAdministrador(modelo,vista);
        
        
        /*VistaCarrera vistaCarrera = new Vista.VistaCarrera();
        vistaCarrera.getForm().getStage().show();*/
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
