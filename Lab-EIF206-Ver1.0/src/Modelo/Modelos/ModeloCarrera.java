/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Modelos;

import LogicaDeNegocio.Carrera;
import Vista.AlertDispatcher;
import java.util.ArrayList;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

/**
 *
 * @author edva5
 */
public class ModeloCarrera {
    public ModeloCarrera() {
    }
    public boolean validateTableSelection(TableView<Carrera> table){
        if (table.getSelectionModel().isEmpty())
            return false;       
        if (table.getSelectionModel().selectedItemProperty().getValue()==null)
            return false;      
        else   return true;
    }
    public String getValidateTableSelectionMessage(TableView<Carrera> table){
        if (table.getSelectionModel().isEmpty())
            return "Tabla Vacia";
        if (table.getSelectionModel().getSelectedItem()==null)
            return "Ningun Administrador Seleccionado";
        else return "Something Went Wrong" ;
    }
    public boolean AlertResponse(AlertDispatcher alertDispatcher){
        if (alertDispatcher.getResult().equals(ButtonType.YES))
            return true;
        else
            return false;
    }
    public boolean eliminar(Carrera c){
        if (c==null)
            return false;        
        else if (AccesoDatos.AccesoDatosCarrera.getInstance().get(c.getCodigo())==null) 
            return false;
        else
        {
            AccesoDatos.AccesoDatosCarrera.getInstance().eliminar(c.getCodigo());
            return true;
        }
    }
    public boolean agregar(Carrera c){
        if (c==null)
            return false;        
        else if (AccesoDatos.AccesoDatosCarrera.getInstance().get(c.getCodigo())!=null) 
            return false;
        else if (!validateCarrera(c)) 
            return false;            
        else
        {
            AccesoDatos.AccesoDatosCarrera.getInstance().insertar(c);
            return true;
        }
    }
    public boolean modificar(Carrera c){
        if (c==null)
            return false;        
        else if (AccesoDatos.AccesoDatosCarrera.getInstance().get(c.getCodigo())==null) 
            return false;
        else if (!validateCarrera(c)) 
            return false;            
        else
        {
            AccesoDatos.AccesoDatosCarrera.getInstance().modificar(c);
            return true;
        }
    }
    public String eliminarResponse(Carrera c){
        if (c==null)
            return "Objeto a Eliminar esta Vacio";        
        else if (AccesoDatos.AccesoDatosAdministrador.getInstance().get(c.getCodigo())==null) 
            return "Objeto a Eliminar no esta en base de Datos";        
        else
            return "No hay Problema";
    }
    public String agregarResponse(Carrera c){
        if (c==null)
            return "Se esta Intentando Ingresar un dato vacio";
        else if (AccesoDatos.AccesoDatosAdministrador.getInstance().get(c.getCodigo())!=null) 
            return "Existe un Usuario en base de datos con la misma identificacion";
        else if (!validateCarrera(c)) 
        {
            String aux="Los espacios ";            
            aux=aux+"NO pueden quedar vacios";
            return aux;
        }        
        else
            return "No hay Problema";
    }
    public String modificarResponse(Carrera c){
        if (c==null)
            return "Se esta Intentando Ingresar un dato vacio";        
        else if (validateCarrera(c)) 
        {
            String aux="Los espacios: ";        
            aux=aux+"NO pueden quedar vacios";
            return aux;
        }        
        else
            return "No hay Problema";
    }
    public void setTableColumnsNames(ArrayList<TableColumn<Carrera,String>> columns){
        for (int i = 0; i < Carrera.getClassNames().length; i++) {
            columns.add(new TableColumn<Carrera, String>(Carrera.getClassNames()[i]));   //Add names to Columns' headers
            OrderTableViewInfo(columns.get(i),Carrera.getClassNames()[i]);            
        }
    }
    private void OrderTableViewInfo(TableColumn<Carrera, String> tablecolumn,String columnName){
        switch(columnName){//Depending on the Header's Name, it assings a specific value of the object to a specific column
                case Carrera.ATRIBUTO_CODIGO:                        
                tablecolumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Carrera, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<Carrera, String> p) {
                        // p.getValue() returns the Person instance for a particular TableView row
                        return new ReadOnlyObjectWrapper<>(p.getValue().getCodigo());
                    }
                });            
                    break;
                case Carrera.ATRIBUTO_NOMBRE:                        
                tablecolumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Carrera, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<Carrera, String> p) {
                        // p.getValue() returns the Person instance for a particular TableView row
                        return new ReadOnlyObjectWrapper<>(p.getValue().getNombre());
                    }
                });            
                    break;
                case Carrera.ATRIBUTO_TITULO:                        
                tablecolumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Carrera, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<Carrera, String> p) {
                        // p.getValue() returns the Person instance for a particular TableView row
                        return new ReadOnlyObjectWrapper<>(p.getValue().getTitulo());
                    }
                });            
                    break;               
            }
    }
    private boolean validateCarrera(Carrera c){
        if (c==null)
            return false;
        else if (c.getCodigo().equals(""))
            return false;
        else if (c.getNombre().equals(""))
            return false;
        else if (c.getTitulo().equals(""))
            return false;
        else return true;
    }
}
