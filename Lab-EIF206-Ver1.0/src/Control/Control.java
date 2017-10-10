/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Datos.Datos;
import Dto.AdministradorDto;

import Modelo.Modelo;
import Modelo.Modelos.ModeloAdministrador;
import Vista.VistaAdministrador;
import Vista.VistaInicio;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import lab.eif206.ver1.pkg0.NewFXMain;

/**
 *
 * @author edva5
 */
public class Control implements EventHandler{
    Datos datos;
    VistaInicio vista;
    Modelo modelo;
    //Modelos
    ModeloAdministrador modeloAdministrador;
    //Vistas
    Vista.VistaAdministrador vistaAdministrador;
    //Controles
    ControlAdministrador controlAdministrador;
    ControlCarrera controlCarrera;
    
    public Control() {
    }

    public Control(VistaInicio vista, Modelo modelo) {        
        datos = new Datos();
         try {
            ArrayList<AdministradorDto> administradoresDto= new ArrayList<>(datos.getLista(Datos.FICHERO_ADMINISTRADOR));
            AccesoDatos.AccesoDatosAdministrador.getInstance().setAdministradoresDto(administradoresDto);
            
        } catch (IOException ex) {
            Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex);
        }        
        this.vista = vista;
        this.modelo = modelo;
        vista.setControl(this);
        vista.getPrincipal().getStage().show();
        validateMenuIems();
    }
    
    

    @Override
    public void handle(Event event) {
        if (event.getSource() instanceof MenuItem) {
            switch(((MenuItem)event.getSource()).getId()){
                case "administradorMnuItm":  
                    this.vista.getPrincipal().getStage().hide();
                    this.vista.getLogInVista().getStage().show();                    
                    modelo.setHandledTypeOfUser(LogicaDeNegocio.Administrador.class.toString());
                    break;
                case "estudianteMnuItm":
                    this.vista.getPrincipal().getStage().hide();
                    this.vista.getLogInVista().getStage().show();                    
                    modelo.setHandledTypeOfUser(LogicaDeNegocio.Estudiante.class.toString());
                    break;
                case "matriculadorMnuItm":
                    this.vista.getPrincipal().getStage().hide();
                    this.vista.getLogInVista().getStage().show();                    
                    modelo.setHandledTypeOfUser(LogicaDeNegocio.Matriculador.class.toString());
                    break;
                case "profesorMnuItm":
                    this.vista.getPrincipal().getStage().hide();
                    this.vista.getLogInVista().getStage().show();                    
                    modelo.setHandledTypeOfUser(LogicaDeNegocio.Profesor.class.toString());
                    break;
                case "mantenimientoAdministradorMnuItm":
                    vista.getPrincipal().getStage().hide();
                    modeloAdministrador = new ModeloAdministrador();
                    vistaAdministrador = new VistaAdministrador();
                    controlAdministrador = new ControlAdministrador(modeloAdministrador, vistaAdministrador);
                    controlAdministrador.setDatos(datos);
                    controlAdministrador.setSuperControl(this);
                    System.out.println("Control.Control.handle() profesorMnuItm");
                    break;
            }
        }
        else if (event.getSource() instanceof Button) {
            switch(((Button)event.getSource()).getText()){
                case "LogIn":
                    modelo.setIdentification(vista.getLogInVista().getIdentificacionTxtId().getText());
                    modelo.setClave(vista.getLogInVista().getClaveTxtId().getText());
                    if (modelo.logIn()) {
                    vista.getAlertDispatcher().setAlert(Alert.AlertType.ERROR, "Bienvenido(a) "+modelo.getLogged().getNombre(), ButtonType.OK);                                            
                    this.vista.getPrincipal().getStage().show();
                    this.vista.getLogInVista().getStage().hide();   
                    validateMenuIems();
                    }
                    else                    
                        vista.getAlertDispatcher().setAlert(Alert.AlertType.ERROR, "Usuario o Contrasenha Incorrecta", ButtonType.OK);                                            
                    break;
                case "Cancelar":
                    this.vista.getPrincipal().getStage().show();
                    this.vista.getLogInVista().getStage().hide();  
                    modelo.setHandledTypeOfUser("null");
                    modelo.setLogged(null);
                    break;
            }
        }
    } 
    private void validateMenuIems(){
        String aux=modelo.getHandledTypeOfUser();
        if (aux.equals("null"))
            vista.getPrincipal().getMenuBar().getMenus().filtered(x->!x.getText().equals("LogIn")&&!x.getText().equals("Help")).forEach(x->x.setDisable(true));
        if (aux.equals(LogicaDeNegocio.Administrador.class.toString())) 
            vista.getPrincipal().getMenuBar().getMenus().filtered(x->!x.getText().equals("Administrador")&&!x.getText().equals("Help")&&!x.getText().equals("LogIn")).forEach(x->x.setDisable(true));
        if (aux.equals(LogicaDeNegocio.Estudiante.class.toString()))
            vista.getPrincipal().getMenuBar().getMenus().filtered(x->!x.getText().equals("Estudiante")&&!x.getText().equals("Help")&&!x.getText().equals("LogIn")).forEach(x->x.setDisable(true));
        if (aux.equals(LogicaDeNegocio.Matriculador.class.toString()))
            vista.getPrincipal().getMenuBar().getMenus().filtered(x->!x.getText().equals("Matriculador")&&!x.getText().equals("Help")&&!x.getText().equals("LogIn")).forEach(x->x.setDisable(true));
        if (aux.equals(LogicaDeNegocio.Profesor.class.toString()))
            vista.getPrincipal().getMenuBar().getMenus().filtered(x->!x.getText().equals("Profesor")&&!x.getText().equals("Help")&&!x.getText().equals("LogIn")).forEach(x->x.setDisable(true));
    }
}
