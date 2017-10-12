/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Datos.Datos;
import Dto.CicloDto;
import LogicaDeNegocio.Ciclo;
import Modelo.Modelos.ModeloCiclo;
import Vista.VistaCiclo;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.stage.WindowEvent;

/**
 *
 * @author edva5
 */
public class ControlCiclo extends ControlPadre {
    private Control superControl;
    private Datos datos;
    private ModeloCiclo modelo;    
    private VistaCiclo vista;  
    //private ChangeListener<Ciclo> changeListener;
    /**
     *
     * @param stage
     */
    public ControlCiclo(ModeloCiclo modelo,VistaCiclo vista){
        
        this.modelo = modelo;
        this.vista = vista;
        this.vista.setControl(this);        
        modelo.setTableColumnsNames(vista.getPrincipal().getAdmiTableColumns());
        vista.getPrincipal().getAdmiTableColumns().stream().forEach(x->this.vista.getPrincipal().getTable().getColumns().add(x));                                                                 
        this.vista.getPrincipal().getTable().setItems(AccesoDatos.AccesoDatosCiclo.getInstance().getAll());        
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
    public ModeloCiclo getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(ModeloCiclo modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the vista
     */
    public VistaCiclo getVista() {
        return vista;
    }

    /**
     * @param vista the vista to set
     */
    public void setVista(VistaCiclo vista) {
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
                        if (!modelo.agregar(getForm()))
                            this.getVista().getAlertDispatcher().setAlert(Alert.AlertType.ERROR, getModelo().agregarResponse(getForm()), ButtonType.OK);                                                
                        else{
                            getVista().getForm().getStage().close();
                            getVista().getPrincipal().getStage().show();                            
                            }
                        break;
                    case "Modificar":                        
                        if (!modelo.modificar(getForm()))
                            this.getVista().getAlertDispatcher().setAlert(Alert.AlertType.ERROR, getModelo().modificarResponse(getForm()), ButtonType.OK);                        
                        else
                        {
                            getVista().getForm().getStage().close();
                            getVista().getPrincipal().getStage().show();
                        }                        
                        break;
                    case "Eliminar":                        
                        if (!modelo.eliminar(getForm()))
                            this.getVista().getAlertDispatcher().setAlert(Alert.AlertType.ERROR, getModelo().eliminarResponse(getForm()), ButtonType.OK);                        
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
                            fillForm(this.getVista().getPrincipal().getTable().getSelectionModel().getSelectedItem());
                            this.getVista().getForm().getStage().show();
                            vista.getPrincipal().getTable().getSelectionModel().clearSelection();                            
                        }                                                       
        }
        else if (event instanceof WindowEvent) {                           
                        
            if (((WindowEvent)event).getEventType().equals(WindowEvent.WINDOW_CLOSE_REQUEST)) {                        
            ArrayList<CicloDto> ciclosDtos = new ArrayList<CicloDto>();
            AccesoDatos.AccesoDatosCiclo.getInstance().getAll().stream().forEach(x->ciclosDtos.add(new CicloDto(x)));
            datos.guardarDatos(ciclosDtos,Datos.FICHERO_CICLO);
            vista.getPrincipal().getStage().hide();
            superControl.vista.getPrincipal().getStage().show();
            }
                        
                         
        }       
    }
    private Ciclo getForm(){
        Ciclo aux = new Ciclo();
        aux.setCodigo(this.vista.getForm().getCodigoTxtFld().getText());
        aux.setFechaIni(this.vista.getForm().getInicioDtPckr().getValue());
        aux.setFechaFin(this.vista.getForm().getConclucionDtPckr().getValue());
        switch(this.vista.getForm().getComboBox().getValue().toString()){
            case "I":
                aux.setNumero(1);
                break;
            case "II":
                aux.setNumero(2);
                break;
        }
        return aux;
    }
    private void fillForm(Ciclo c){
        this.vista.getForm().getCodigoTxtFld().setEditable(false);
        this.vista.getForm().getCodigoTxtFld().setText(c.getCodigo());
        this.vista.getForm().getInicioDtPckr().setValue(c.getFechaIni());
        this.vista.getForm().getConclucionDtPckr().setValue(c.getFechaFin());
        this.vista.getForm().getComboBox().getSelectionModel().select(c.getNumero()-1);
    }
}
