/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Datos.Datos;
import Dto.AdministradorDto;
import LogicaDeNegocio.Administrador;
import Modelo.Modelos.ModeloAdministrador;
import Vista.Forms.AdministradorFormVista;
import Vista.Principals.AdministradorPrincipalVista;
import Vista.VistaAdministrador;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.stage.WindowEvent;


import javafx.util.Callback;
import lab.eif206.ver1.pkg0.NewFXMain;



//import javax.swing.admiTable.TableColumn;

/**
 *
 * @author edva5
 */
public class ControlAdministrador implements EventHandler{
    
    
    private Datos datos;
    private ModeloAdministrador modelo;    
    private VistaAdministrador vista;  
    /**
     *
     * @param stage
     */
    public ControlAdministrador(ModeloAdministrador modelo,VistaAdministrador vista){
        datos = new Datos();
        this.modelo = modelo;
        this.vista = vista;
        this.vista.setControl(this);
        
        try {
            ArrayList<AdministradorDto> administradoresDto= new ArrayList<>(datos.getLista(Datos.FICHERO_ADMINISTRADOR));
            AccesoDatos.AccesoDatosAdministrador.getInstance().setAdministradoresDto(administradoresDto);
            
        } catch (IOException ex) {
            Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex);
        }        
                                                  
        for (int i = 0; i < Administrador.getClassNames().length; i++) {
            vista.getPrincipal().getAdmiTableColumns().add(new TableColumn<Administrador, String>(Administrador.getClassNames()[i]));   //Add names to Columns' headers
            modelo.OrderTableViewInfo(this.vista.getPrincipal().getAdmiTableColumns().get(i),Administrador.getClassNames()[i]);            
        }
        
        vista.getPrincipal().getAdmiTableColumns().stream().forEach(x->this.vista.getPrincipal().getTable().getColumns().add(x));                                                                 
        this.vista.getPrincipal().getTable().setItems(AccesoDatos.AccesoDatosAdministrador.getInstance().getAll());        
        this.vista.getPrincipal().getStage().show();
                                
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
                        this.vista.getForm().fillFormDiabled(this.vista.getPrincipal().getTable().getSelectionModel().getSelectedItem());
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
                    ArrayList<AdministradorDto> administradorDtos = new ArrayList<AdministradorDto>();
                    AccesoDatos.AccesoDatosAdministrador.getInstance().getAll().stream().forEach(x->administradorDtos.add(new AdministradorDto(x)));
                    datos.guardarDatos(administradorDtos);
                }            
        }
    }

   

    

   
    
    
}
