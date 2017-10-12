/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Modelos;

import LogicaDeNegocio.Carrera;
import LogicaDeNegocio.Curso;
import Vista.AlertDispatcher;
import java.util.ArrayList;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

/**
 *
 * @author edva5
 */
public class ModeloCurso {
     public ModeloCurso() {
    }
    public boolean validateTableSelection(TableView<Curso> table){
        if (table.getSelectionModel().isEmpty())
            return false;       
        if (table.getSelectionModel().selectedItemProperty().getValue()==null)
            return false;      
        else   return true;
    }
    public String getValidateTableSelectionMessage(TableView<Curso> table){
        if (table.getSelectionModel().isEmpty())
            return "Tabla Vacia";
        if (table.getSelectionModel().getSelectedItem()==null)
            return "Ningun Curso Seleccionado";
        else return "Something Went Wrong" ;
    }
    public boolean AlertResponse(AlertDispatcher alertDispatcher){
        if (alertDispatcher.getResult().equals(ButtonType.YES))
            return true;
        else
            return false;
    }
    public boolean eliminar(Curso a){
        if (a==null)
            return false;        
        else if (AccesoDatos.AccesoDatosCurso.getInstance().get(a.getCodigo())==null) 
            return false;
        else
        {
            AccesoDatos.AccesoDatosCurso.getInstance().eliminar(a.getCodigo());
            return true;
        }
    }
    public boolean agregar(Curso a){
        if (a==null)
            return false;        
        else if (AccesoDatos.AccesoDatosCurso.getInstance().get(a.getCodigo())!=null) 
            return false;
        else if (!validateCurso(a)) 
            return false;            
        else
        {
            AccesoDatos.AccesoDatosCurso.getInstance().insertar(a);
            return true;
        }
    }
    public boolean modificar(Curso a){
        if (a==null)
            return false;        
        else if (AccesoDatos.AccesoDatosCurso.getInstance().get(a.getCodigo())==null) 
            return false;
        else if (!validateCurso(a)) 
            return false;            
        else
        {
            AccesoDatos.AccesoDatosCurso.getInstance().modificar(a);
            return true;
        }
    }
    public String eliminarResponse(Curso a){
        if (a==null)
            return "Objeto a Eliminar esta Vacio";        
        else if (AccesoDatos.AccesoDatosCurso.getInstance().get(a.getCodigo())==null) 
            return "Objeto a Eliminar no esta en base de Datos";        
        else
            return "No hay Problema";
    }
    public String agregarResponse(Curso a){
        if (a==null)
            return "Se esta Intentando Ingresar un dato vacio";
        else if (AccesoDatos.AccesoDatosCurso.getInstance().get(a.getCodigo())!=null) 
            return "Existe un Usuario en base de datos con la misma identificacion";
        else if (!validateCurso(a)) 
        {
            String aux="Los espacios: ";
            
            aux=aux+"NO pueden quedar vacios";
            return aux;
        }        
        else
            return "No hay Problema";
    }
    public String modificarResponse(Curso a){
        if (a==null)
            return "Se esta Intentando Ingresar un dato vacio";        
        else if (validateCurso(a)) 
        {
            String aux="Los espacios: ";          
            aux=aux+"NO pueden quedar vacios";
            return aux;
        }        
        else
            return "No hay Problema";
    }
    public void setTableColumnsNames(ArrayList<TableColumn<Curso,String>> columns){
        for (int i = 0; i < Curso.getClassNames().length; i++) {
            columns.add(new TableColumn<Curso, String>(Curso.getClassNames()[i]));   //Add names to Columns' headers
            OrderTableViewInfo(columns.get(i),Curso.getClassNames()[i]);            
        }
    }     
    private void OrderTableViewInfo(TableColumn<Curso, String> tablecolumn,String columnName){
        switch(columnName){//Depending on the Header's Name, it assings a specific value of the object to a specific column
                case Curso.ATRIBUTTE_CODIGO:                        
                tablecolumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Curso, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<Curso, String> p) {
                        // p.getValue() returns the Person instance for a particular TableView row
                        return new ReadOnlyObjectWrapper<>(p.getValue().getCodigo());
                    }
                });            
                    break;
                case Curso.ATRIBUTTE_CARRERA:
                tablecolumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Curso, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<Curso, String> p) {
                        // p.getValue() returns the Person instance for a particular TableView row
                        return new ReadOnlyObjectWrapper<>(String.valueOf(p.getValue().getCarreras().getNombre()));
                    }
                });
                    break;
                case Curso.ATRIBUTTE_CREDITOS:
                    tablecolumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Curso, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<Curso, String> p) {
                        // p.getValue() returns the Person instance for a particular TableView row
                        return new ReadOnlyObjectWrapper<>(String.valueOf(p.getValue().getCreditos()));
                    }
                });
                    break;            
                case Curso.ATRIBUTTE_HORAS_SEMANALES:
                    tablecolumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Curso, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<Curso, String> p) {
                        // p.getValue() returns the Person instance for a parTableView row
                        return new ReadOnlyObjectWrapper<>(String.valueOf(p.getValue().getHorasSemanales()));
                    }
                });
                    break;
                    case Curso.ATRIBUTTE_NOMBRE:
                    tablecolumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Curso, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<Curso, String> p) {
                        // p.getValue() returns the Person instance for a parTableView row
                        return new ReadOnlyObjectWrapper<>(String.valueOf(p.getValue().getNombre()));
                    }
                });
                    break;
                
            }
    }
    private boolean validateCurso(Curso a){
        if (a==null)
            return false;        
        else if (a.getCodigo().equals(""))
            return false;
        else if (a.getNombre().equals(""))
            return false;
        else if (a.getCreditos()<0) 
            return false;
        else if (a.getHorasSemanales()<0) 
            return false;
        else if (a.getCarreras()==null) 
            return false;
        else return true;
    }
}
