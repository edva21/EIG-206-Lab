/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Datos.Datos;
import Dto.AdministradorDto;
import Dto.CarreraDto;
import Dto.CicloDto;
import Dto.CursoDto;
import Dto.MatriculadorDto;
import LogicaDeNegocio.Administrador;

import Modelo.Modelo;
import Modelo.Modelos.ModeloAdministrador;
import Modelo.Modelos.ModeloCarrera;
import Modelo.Modelos.ModeloCiclo;
import Modelo.Modelos.ModeloCurso;
import Modelo.Modelos.ModeloEstudiante;
import Modelo.Modelos.ModeloMatriculador;
import Modelo.Modelos.ModeloProfesor;
import Vista.VistaAdministrador;
import Vista.VistaCarrera;
import Vista.VistaCiclo;
import Vista.VistaCurso;
import Vista.VistaEstudiante;
import Vista.VistaInicio;
import Vista.VistaMatriculador;
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
    ModeloMatriculador modeloMatriculador;
    ModeloEstudiante modeloEstudiante;
    ModeloCarrera modeloCarrera;
    ModeloCiclo modeloCiclo;
    ModeloCurso modeloCurso;
    
    //Vistas
    Vista.VistaAdministrador vistaAdministrador;
    Vista.VistaProfesor vistaProfesor;
    VistaMatriculador vistaMatriculador;
    Vista.VistaEstudiante vistaEstudiante;
    VistaCarrera vistaCarrera;
    VistaCiclo vistaCiclo;
    Vista.VistaCurso vistaCurso;
    //Controles
    ControlAdministrador controlAdministrador;
    ControlProfesor controlProfesor;
    ControlMatriculador controlMatriculador;
    ControlEstudiante controlEstudiante;
    ControlCarrera controlCarrera;
    ControlCiclo controlCiclo;
    ControlCurso controlCurso;
    
    public Control() {
    }

    public Control(VistaInicio vista, Modelo modelo) {        
        datos = new Datos();
         try {
             ArrayList<Dto.EstudianteDto> estudiantesDto= new ArrayList<>(datos.getLista(Datos.FICHERO_ESTUDIANTE));
            ArrayList<Dto.ProfesorDto> profesoresDto= new ArrayList<>(datos.getLista(Datos.FICHERO_PROFESOR));
            ArrayList<MatriculadorDto> matriculadoresDto= new ArrayList<>(datos.getLista(Datos.FICHERO_MATRICULADOR));
            ArrayList<AdministradorDto> administradoresDto= new ArrayList<>(datos.getLista(Datos.FICHERO_ADMINISTRADOR));
            ArrayList<CarreraDto> carrerasDto= new ArrayList<>(datos.getLista(Datos.FICHERO_CARRERA));
            ArrayList<CicloDto> ciclosDto= new ArrayList<>(datos.getLista(Datos.FICHERO_CICLO));
            ArrayList<CursoDto> cursosDto= new ArrayList<>(datos.getLista(Datos.FICHERO_CURSO));
            
            AccesoDatos.AccesoDatosProfesor.getInstance().setProfesoresDto(profesoresDto);
            AccesoDatos.AccesoDatosMatriculador.getInstance().setMatriculadoresDto(matriculadoresDto);
            AccesoDatos.AccesoDatosAdministrador.getInstance().setAdministradoresDto(administradoresDto);
            AccesoDatos.AccesoDatosEstudiante.getInstance().setEstudianteesDto(estudiantesDto);
            AccesoDatos.AccesoDatosCarrera.getInstance().setCarreraDto(carrerasDto);
            AccesoDatos.AccesoDatosCiclo.getInstance().setCicloesDto(ciclosDto);
            AccesoDatos.AccesoDatosCurso.getInstance().setCursoesDto(cursosDto);
          
            
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
                case "mantenimientoMatriculadorMnuItm":
                    modeloMatriculador = new ModeloMatriculador();
                    vistaMatriculador= new VistaMatriculador();
                    controlMatriculador = new ControlMatriculador(modeloMatriculador, vistaMatriculador);
                    controlMatriculador.setDatos(datos);
                    controlMatriculador.setSuperControl(this);
                    break;
                case "mantenimientoEstudianteMnuItm":
                    modeloEstudiante = new ModeloEstudiante();
                    vistaEstudiante = new VistaEstudiante();
                    controlEstudiante = new ControlEstudiante(modeloEstudiante, vistaEstudiante);
                    controlEstudiante.setDatos(datos);
                    controlEstudiante.setSuperControl(this);
                    break;
                case "mantenimientoCicloMnuItm":
                    modeloCiclo = new ModeloCiclo();
                    vistaCiclo = new VistaCiclo();
                    controlCiclo = new ControlCiclo(modeloCiclo,vistaCiclo);
                    controlCiclo.setDatos(datos);
                    controlCiclo.setSuperControl(this);
                    break;
                case "mantenimientoCursoMnuItm":
                    modeloCurso = new ModeloCurso();
                    vistaCurso = new VistaCurso();
                    controlCurso = new ControlCurso(modeloCurso,vistaCurso);
                    controlCurso.setDatos(datos);
                    controlCurso.setSuperControl(this);
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
