/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Datos.Datos;
import Dto.AdministradorDto;
import Dto.CarreraDto;
import LogicaDeNegocio.Administrador;

import Modelo.Modelo;
import Modelo.Modelos.ModeloAdministrador;
import Modelo.Modelos.ModeloCarrera;
import Modelo.Modelos.ModeloProfesor;
import Vista.VistaAdministrador;
import Vista.VistaCarrera;
import Vista.VistaInicio;
import Vista.VistaProfesor;
import java.io.IOException;
import java.time.LocalDate;
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
    ModeloProfesor modeloProfesor;
    ModeloCarrera modeloCarrera;
    
    //Vistas
    Vista.VistaAdministrador vistaAdministrador;
    Vista.VistaProfesor vistaProfesor;
    VistaCarrera vistaCarrera;
    //Controles
    ControlAdministrador controlAdministrador;
    ControlProfesor controlProfesor;
    ControlCarrera controlCarrera;
    
    public Control() {
    }

    public Control(VistaInicio vista, Modelo modelo) {        
        datos = new Datos();
         try {             
            ArrayList<AdministradorDto> administradoresDto= new ArrayList<>(datos.getLista(Datos.FICHERO_ADMINISTRADOR));
            ArrayList<CarreraDto> carrerasDto= new ArrayList<>(datos.getLista(Datos.FICHERO_CARRERA));
            
            AccesoDatos.AccesoDatosAdministrador.getInstance().setAdministradoresDto(administradoresDto);
            AccesoDatos.AccesoDatosCarrera.getInstance().setCarreraDto(carrerasDto);
            
        } catch (IOException ex) {
            Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex);
        }        
         AccesoDatos.AccesoDatosAdministrador.getInstance().getAll().forEach(x->System.out.println(x.getClave()));
        this.vista = vista;
        this.modelo = modelo;
        vista.setControl(this);
        vista.getPrincipal().getStage().show();
        validateMenus();
    }
       
    @Override
    public void handle(Event event) {
        
        if (event.getSource() instanceof MenuItem) {            
            MenuItem menuItem= (MenuItem) event.getSource();               
            switch(((MenuItem)event.getSource()).getId()){
                case "logOutMnuItm":                      
                    vista.getAlertDispatcher().setAlert(Alert.AlertType.WARNING, "Quiere desloguearse "+modelo.getLogged().getNombre()+"?", ButtonType.YES, ButtonType.CANCEL);
                    if (vista.getAlertDispatcher().getResult().get().equals(ButtonType.YES)) {                                                
                        modelo.LogOut();
                        modelo.setHandledTypeOfUser("null");
                        validateMenus();
                    }                    
                    break;
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
                case "mantenimientoCarreraMnuItm":
                    modeloCarrera = new ModeloCarrera();
                    vistaCarrera = new VistaCarrera();
                    controlCarrera = new ControlCarrera(modeloCarrera, vistaCarrera);
                    controlCarrera.setDatos(datos);
                    controlCarrera.setSuperControl(this);
                    break;
                case "mantenimientoProfesorMnuItm":
                    modeloProfesor = new ModeloProfesor();
                    vistaProfesor = new VistaProfesor();
                    controlProfesor = new ControlProfesor(modeloProfesor, vistaProfesor);
                    controlProfesor.setDatos(datos);
                    controlProfesor.setSuperControl(this);
                    break;
            }
        }
        else if (event.getSource() instanceof Button) {            
            switch(((Button)event.getSource()).getText()){
                case "LogIn":
                    modelo.setIdentification(vista.getLogInVista().getIdentificacionTxtId().getText());
                    modelo.setClave(vista.getLogInVista().getClaveTxtId().getText());
                    if (modelo.logIn()) {
                    vista.getAlertDispatcher().setAlert(Alert.AlertType.CONFIRMATION, "Bienvenido(a) "+modelo.getLogged().getNombre(), ButtonType.OK);                                            
                    validateMenus();
                    this.vista.getPrincipal().getStage().show();
                    this.vista.getLogInVista().getStage().hide();                       
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
    private void validateMenus(){
        validateMenuItems();
        vista.getPrincipal().getMenuBar().getMenus().stream().forEach(x->x.setDisable(false));
        String aux=modelo.getHandledTypeOfUser();
        if (aux.equals("null"))
            vista.getPrincipal().getMenuBar().getMenus().filtered(x->!x.getText().equals("LogIn")&&!x.getText().equals("Help")).forEach(x->x.setDisable(true));
        else if (aux.equals(LogicaDeNegocio.Administrador.class.toString())) 
            vista.getPrincipal().getMenuBar().getMenus().filtered(x->!x.getText().equals("Administrador")&&!x.getText().equals("Help")&&!x.getText().equals("LogIn")).forEach(x->x.setDisable(true));
        else if (aux.equals(LogicaDeNegocio.Estudiante.class.toString()))
            vista.getPrincipal().getMenuBar().getMenus().filtered(x->!x.getText().equals("Estudiante")&&!x.getText().equals("Help")&&!x.getText().equals("LogIn")).forEach(x->x.setDisable(true));
        else if (aux.equals(LogicaDeNegocio.Matriculador.class.toString()))
            vista.getPrincipal().getMenuBar().getMenus().filtered(x->!x.getText().equals("Matriculador")&&!x.getText().equals("Help")&&!x.getText().equals("LogIn")).forEach(x->x.setDisable(true));
        else if (aux.equals(LogicaDeNegocio.Profesor.class.toString()))
            vista.getPrincipal().getMenuBar().getMenus().filtered(x->!x.getText().equals("Profesor")&&!x.getText().equals("Help")&&!x.getText().equals("LogIn")).forEach(x->x.setDisable(true));
    }
    private void validateMenuItems(){
        vista.getPrincipal().getMenuBar().getMenus().filtered(x->x.getText().equals("LogIn")).stream().forEach(x->x.getItems().stream().forEach(y->y.setDisable(false)));
        String aux=modelo.getHandledTypeOfUser();
        if (aux.equals("null"))
            vista.getPrincipal().getMenuBar().getMenus().filtered(x->x.getText().equals("LogIn")).stream().forEach(x->x.getItems().stream().filter(y->y.getText().equals("LogOut")).forEach(y->y.setDisable(true)));
        else 
            vista.getPrincipal().getMenuBar().getMenus().filtered(x->x.getText().equals("LogIn")).stream().forEach(x->x.getItems().stream().filter(y->y.getText().equals("Como Administrador")||y.getText().equals("Como Estudiante")||y.getText().equals("Como Matriculador")||y.getText().equals("Como Profesor")).forEach(y->y.setDisable(true)));
            
    }
}
