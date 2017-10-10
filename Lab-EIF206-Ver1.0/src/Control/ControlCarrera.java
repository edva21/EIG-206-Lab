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
import javafx.stage.WindowEvent;

/**
 *
 * @author edva5
 */
public class ControlCarrera implements EventHandler{    
    private Modelo.Modelos.ModeloCarrera modelo;    
    private Vista.VistaCarrera vista;  
    private Datos datos;
    public ControlCarrera(ModeloCarrera modelo, VistaCarrera vista) {        
        this.modelo= modelo;
        this.vista = vista;
        for (int i = 0; i < Carrera.getAtributesNames().length; i++) {
            vista.getPrincipal().getAdmiTableColumns().add(new TableColumn<Carrera, String>(Carrera.getAtributesNames()[i]));
            modelo.OrderTableViewInfo(vista.getPrincipal().getAdmiTableColumns().get(i), Carrera.getAtributesNames()[i]);
        }
        vista.getPrincipal().getTable().getColumns().addAll(vista.getPrincipal().getAdmiTableColumns());
        vista.getPrincipal().getTable().setItems(AccesoDatos.AccesoDatosCarrera.getInstance().getAll());
        vista.getPrincipal().getStage().show();
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
    @Override
    public void handle(Event event) {
      if (event instanceof ActionEvent) {
            if (event.getSource() instanceof Button) {
                switch(((Button)event.getSource()).getText()){                    
                    case "Agregar":                        
                        this.vista.getPrincipal().getStage().hide();
                        this.vista.getForm().getYesBtn().setText("Guardar");
                        this.vista.getForm().clearForm();
                        this.vista.getForm().getStage().show();
                        break;
                    case "Editar":
                        if (modelo.validateTableSelection(this.vista.getPrincipal().getTable())) {
                        this.vista.getPrincipal().getStage().close();
                        this.vista.getForm().getYesBtn().setText("Modificar");
                        this.vista.getForm().clearForm();
                        this.vista.getForm().fillForm(this.vista.getPrincipal().getTable().getSelectionModel().getSelectedItem());
                        this.vista.getForm().getStage().show();
                        }
                        else
                            this.vista.getAlertDispatcher().setAlert(Alert.AlertType.ERROR, modelo.getValidateTableSelectionMessage(this.vista.getPrincipal().getTable()), ButtonType.OK);
                        break;
                    case"Remover":
                        if (modelo.validateTableSelection(this.vista.getPrincipal().getTable())) {
                        this.vista.getPrincipal().getStage().close();
                        this.vista.getForm().getYesBtn().setText("Eliminar");
                        this.vista.getForm().clearForm();                        
                        this.vista.getForm().fillForm(this.vista.getPrincipal().getTable().getSelectionModel().getSelectedItem());
                        this.vista.getForm().setAllTextIeldsEnable(false);
                        this.vista.getForm().getStage().show();
                        }
                        else
                            this.vista.getAlertDispatcher().setAlert(Alert.AlertType.ERROR, modelo.getValidateTableSelectionMessage(this.vista.getPrincipal().getTable()), ButtonType.OK);
                        break;
                    case "Guardar":           
                        if (!modelo.agregar(vista.getForm().getForm()))
                            this.vista.getAlertDispatcher().setAlert(Alert.AlertType.ERROR, modelo.agregarResponse(vista.getForm().getForm()), ButtonType.OK);                                                
                        else{
                            vista.getForm().getStage().close();
                            vista.getPrincipal().getStage().show();
                            }
                        break;
                    case "Modificar":                        
                        if (!modelo.modificar(vista.getForm().getForm()))
                            this.vista.getAlertDispatcher().setAlert(Alert.AlertType.ERROR, modelo.modificarResponse(vista.getForm().getForm()), ButtonType.OK);                        
                        else
                        {
                            vista.getForm().getStage().close();
                            vista.getPrincipal().getStage().show();
                        }                        
                        break;
                    case "Eliminar":                        
                        if (!modelo.eliminar(vista.getForm().getForm()))
                            this.vista.getAlertDispatcher().setAlert(Alert.AlertType.ERROR, modelo.eliminarResponse(vista.getForm().getForm()), ButtonType.OK);                        
                        else
                        {
                            vista.getForm().getStage().close();
                            vista.getPrincipal().getStage().show();
                        }                        
                        break;
                    case "Cancelar":  
                        vista.getForm().getStage().close();
                        vista.getPrincipal().getStage().show();
                        break;
                }
            }
        }
        else if (event instanceof WindowEvent) {           
            
                if (((WindowEvent)event).getEventType().equals(WindowEvent.WINDOW_CLOSE_REQUEST)) {                        
                    ArrayList<CarreraDto> carrerasDtos = new ArrayList<CarreraDto>();
                    AccesoDatos.AccesoDatosCarrera.getInstance().getAll().stream().forEach(x->carrerasDtos.add(new CarreraDto(x)));
                    getDatos().guardarDatos(carrerasDtos);
                }            
        }
    }
    
}
