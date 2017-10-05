/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Datos.Datos;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.Stage;

/**
 *
 * @author edva5
 */
public class Control {
    Datos datos;
    ControlAdministrador controlAdministrador;
    public Control(Stage stage) throws IOException {
        datos = new Datos();
        try {
            AccesoDatos.AccesoDatosAdministrador.getInstance().setAdministradores(datos.getLista(Datos.FICHERO_ADMINISTRADOR));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        }
        //controlAdministrador = new ControlAdministrador(stage);
    }
    
}
