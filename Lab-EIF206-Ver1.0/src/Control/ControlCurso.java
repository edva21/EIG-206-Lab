/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Datos.Datos;
import Dto.CursoDto;
import LogicaDeNegocio.Carrera;
import LogicaDeNegocio.Curso;
import Modelo.Modelos.ModeloCurso;
import Vista.VistaCurso;
import java.util.ArrayList;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.WindowEvent;
import javafx.util.Callback;

/**
 *
 * @author edva5
 */
public class ControlCurso extends ControlPadre {
      private Control superControl;
    private Datos datos;
    private ModeloCurso modelo;    
    private VistaCurso vista;  
    //private ChangeListener<Curso> changeListener;
    /**
     *
     * @param stage
     */
    public ControlCurso(ModeloCurso modelo,VistaCurso vista){
        
        this.modelo = modelo;
        this.vista = vista;
        this.vista.setControl(this);        
        modelo.setTableColumnsNames(vista.getPrincipal().getAdmiTableColumns());
        vista.getPrincipal().getAdmiTableColumns().stream().forEach(x->this.vista.getPrincipal().getTable().getColumns().add(x));                                                                 
        this.vista.getPrincipal().getTable().setItems(AccesoDatos.AccesoDatosCurso.getInstance().getAll());        
        this.vista.getPrincipal().getStage().show();   
        this.vista.getForm().getCarreraCmbBx().setCellFactory(new Callback<ListView<Carrera>,ListCell<Carrera>>() {
            @Override
            public ListCell<Carrera> call(ListView<Carrera> param) {
                return new ListCell<Carrera>(){
                    @Override
                    protected void updateItem(Carrera item, boolean empty) {
                        super.updateItem(item, empty); //To change body of generated methods, choose Tools | Templates.
                        
                        if (!empty)
                            setText(item.getNombre());                        
                        else
                            setText("");                        
                    }

                    

                   
                    
                };
                
            }
        });
        /*this.vista.getForm().getCarreraCmbBx().setCellFactory(new Callback<ComboBox<Carrera>,ObservableValue<String>>(){
            @Override
            public ObservableValue<String> call(ComboBox<Carrera> param) {
                return new ReadOnlyObjectWrapper<>(param.getValue().getNombre());
            }
            
        });*/
        
        this.vista.getForm().getCarreraCmbBx().setItems(AccesoDatos.AccesoDatosCarrera.getInstance().getAll());
        
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
    public ModeloCurso getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(ModeloCurso modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the vista
     */
    public VistaCurso getVista() {
        return vista;
    }

    /**
     * @param vista the vista to set
     */
    public void setVista(VistaCurso vista) {
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
            ArrayList<CursoDto> ciclosDtos = new ArrayList<CursoDto>();
            AccesoDatos.AccesoDatosCurso.getInstance().getAll().stream().forEach(x->ciclosDtos.add(new CursoDto(x)));
            datos.guardarDatos(ciclosDtos,Datos.FICHERO_CURSO);
            vista.getPrincipal().getStage().hide();
            superControl.vista.getPrincipal().getStage().show();
            }
                        
                         
        }       
    }
    private Curso getForm(){
        Curso aux = new Curso();
        aux.setNombre(this.vista.getForm().getNombreTxtFld().getText());
        aux.setCodigo(this.vista.getForm().getCodigoTxtFld().getText());
        aux.setCreditos(Integer.parseInt(this.vista.getForm().getCreditosSpnnr().getValue().toString()));
        aux.setHorasSemanales(Integer.parseInt(this.vista.getForm().getHorasSpnnr().getValue().toString()));
        aux.setCarreras((Carrera) this.vista.getForm().getCarreraCmbBx().getSelectionModel().getSelectedItem());
        return aux;
    }
    private void fillForm(Curso c){
        this.vista.getForm().getNombreTxtFld().setText(c.getNombre());
        this.vista.getForm().getCodigoTxtFld().setText(c.getCodigo());
        this.vista.getForm().getCreditosSpnnr().setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,12,c.getCreditos()));
        this.vista.getForm().getHorasSpnnr().setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,24,c.getHorasSemanales()));
        this.vista.getForm().getCarreraCmbBx().getSelectionModel().select(c.getCarreras());
    }
}
