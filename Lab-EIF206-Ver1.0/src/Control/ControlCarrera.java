/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Datos.Datos;
import Dto.CarreraDto;

import LogicaDeNegocio.Carrera;
import Modelo.Modelos.ModeloCarrera;
import Vista.VistaCarrera;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.input.MouseEvent;
import javafx.stage.WindowEvent;

/**
 *
 * @author edva5
 */
public class ControlCarrera extends ControlPadre{    
    private Control superControl;
    private Datos datos;
    private ModeloCarrera modelo;    
    private VistaCarrera vista;  
    //private ChangeListener<Carrera> changeListener;
    /**
     *
     * @param stage
     */
    public ControlCarrera(ModeloCarrera modelo,VistaCarrera vista){
        
        this.modelo = modelo;
        this.vista = vista;
        this.vista.setControl(this);        
        modelo.setTableColumnsNames(vista.getPrincipal().getAdmiTableColumns());
        vista.getPrincipal().getAdmiTableColumns().stream().forEach(x->this.vista.getPrincipal().getTable().getColumns().add(x));                                                                 
        this.vista.getPrincipal().getTable().setItems(AccesoDatos.AccesoDatosCarrera.getInstance().getAll());        
        this.vista.getPrincipal().getStage().show();                                
        
    } 
    
    /**
     * @return the superControl
     */
    public Control getSuperControl() {
        return superControl;
    }

    /**
     * @param superControl the superControl to set
     */
    public void setSuperControl(Control superControl) {
        this.superControl = superControl;
    }
    /**
     * @return the datos
     */
    public Datos getDatos() {
        return datos;
    }

    /**
     * @param datos the datos to set
     */
    public void setDatos(Datos datos) {
        this.datos = datos;
    }

    /**
     * @return the modelo
     */
    public ModeloCarrera getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(ModeloCarrera modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the vista
     */
    public VistaCarrera getVista() {
        return vista;
    }

    /**
     * @param vista the vista to set
     */
    public void setVista(VistaCarrera vista) {
        this.vista = vista;
    }            
    @Override
    public void handle(Event event) {
        if (event instanceof ActionEvent) {
            if (event.getSource() instanceof Button) {
                switch(((Button)event.getSource()).getText()){                    
                    case "Agregar":                        
                        this.getVista().getPrincipal().getStage().hide();
                        this.getVista().getForm().getEliminarBtn().setVisible(false);
                        this.getVista().getForm().getYesBtn().setText("Guardar");
                        this.getVista().getForm().clearForm();
                        this.getVista().getForm().getStage().show();
                        break;                                        
                    case "Guardar":           
                        if (!modelo.agregar(vista.getForm().getForm()))
                            this.getVista().getAlertDispatcher().setAlert(Alert.AlertType.ERROR, getModelo().agregarResponse(getVista().getForm().getForm()), ButtonType.OK);                                                
                        else{
                            getVista().getForm().getStage().close();
                            getVista().getPrincipal().getStage().show();                            
                            }
                        break;
                    case "Modificar":                        
                        if (!modelo.modificar(vista.getForm().getForm()))
                            this.getVista().getAlertDispatcher().setAlert(Alert.AlertType.ERROR, getModelo().modificarResponse(getVista().getForm().getForm()), ButtonType.OK);                        
                        else
                        {
                            getVista().getForm().getStage().close();
                            getVista().getPrincipal().getStage().show();
                        }                        
                        break;
                    case "Eliminar":                        
                        if (!modelo.eliminar(vista.getForm().getForm()))
                            this.getVista().getAlertDispatcher().setAlert(Alert.AlertType.ERROR, getModelo().eliminarResponse(getVista().getForm().getForm()), ButtonType.OK);                        
                        else
                        {
                            getVista().getForm().getStage().close();
                            getVista().getPrincipal().getStage().show();
                        }                        
                        break;
                    case "Cancelar":  
                        getVista().getForm().getStage().close();
                        getVista().getPrincipal().getStage().show();
                        break;
                }
            }
        }
        else if (event instanceof MouseEvent) {
            if (vista.getPrincipal().getTable().getSelectionModel().getSelectedItem()!=null&&((MouseEvent)event).getClickCount()==1) {                
                            this.getVista().getPrincipal().getStage().close();
                            this.getVista().getForm().getYesBtn().setText("Modificar");
                            this.getVista().getForm().getEliminarBtn().setVisible(true);
                            this.getVista().getForm().clearForm();
                            this.getVista().getForm().fillForm(this.getVista().getPrincipal().getTable().getSelectionModel().getSelectedItem());
                            this.getVista().getForm().getStage().show();
                            vista.getPrincipal().getTable().getSelectionModel().clearSelection();                            
                        }                                                       
        }
        else if (event instanceof WindowEvent) {                           
                        
            if (((WindowEvent)event).getEventType().equals(WindowEvent.WINDOW_CLOSE_REQUEST)) {                        
            ArrayList<CarreraDto> carrerasDtos = new ArrayList<CarreraDto>();
            AccesoDatos.AccesoDatosCarrera.getInstance().getAll().stream().forEach(x->carrerasDtos.add(new CarreraDto(x)));
            datos.guardarDatos(carrerasDtos,Datos.FICHERO_CARRERA);
            vista.getPrincipal().getStage().hide();
            superControl.vista.getPrincipal().getStage().show();
            }
                        
                         
        }       
    }
    
}
