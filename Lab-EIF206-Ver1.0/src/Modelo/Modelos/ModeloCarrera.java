/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Modelos;

import LogicaDeNegocio.Carrera;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
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
     public String getValidateTableSelectionMessage(TableView<Carrera> table){
        if (table.getSelectionModel().isEmpty())
            return "Tabla Vacia";
        if (table.getSelectionModel().getSelectedItem()==null)
            return "Ningun Carrera Seleccionado";
        else return "Something Went Wrong" ;
    }
    public boolean validateTableSelection(TableView<Carrera> table){
        if (table.getSelectionModel().isEmpty())
            return false;       
         if (table.getSelectionModel().getSelectedItem()==null)
            return false;      
         else   return true;
    }
    public void OrderTableViewInfo(TableColumn<Carrera, String> tablecolumn,String columnName){
        switch(columnName){//Depending on the Header's Name, it assings a specific value of the object to a specific column
                case Carrera.ATRIBUTO_CODIGO:                        
                tablecolumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Carrera, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<Carrera, String> p) {                        
                        return new ReadOnlyObjectWrapper<>(p.getValue().getCodigo());
                    }
                });            
                    break;                
                    case Carrera.ATRIBUTO_NOMBRE:                        
                tablecolumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Carrera, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<Carrera, String> p) {                        
                        return new ReadOnlyObjectWrapper<>(p.getValue().getNombre());
                    }
                });            
                    break;
                    case Carrera.ATRIBUTO_TITULO:                        
                tablecolumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Carrera, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<Carrera, String> p) {                        
                        return new ReadOnlyObjectWrapper<>(p.getValue().getTitulo());
                    }
                });            
                    break;
            }
    }
    public boolean eliminar(Carrera a){
        if (a==null)
            return false;        
        else if (AccesoDatos.AccesoDatosCarrera.getInstance().get(a.getCodigo())==null) 
            return false;
        else
        {
            AccesoDatos.AccesoDatosCarrera.getInstance().eliminar(a.getCodigo());
            return true;
        }
    }
    public boolean agregar(Carrera a){
        if (a==null)
            return false;        
        else if (AccesoDatos.AccesoDatosCarrera.getInstance().get(a.getCodigo())!=null) 
            return false;
        else if (a.getCodigo().length()==0||a.getNombre().length()==0||a.getTitulo().length()==0||a.getNombre().length()==0) 
            return false;            
        else
        {
            AccesoDatos.AccesoDatosCarrera.getInstance().insertar(a);
            return true;
        }
    }
    public boolean modificar(Carrera a){
        if (a==null)
            return false;        
        else if (AccesoDatos.AccesoDatosCarrera.getInstance().get(a.getCodigo())==null) 
            return false;
        else if (a.getCodigo().length()==0||a.getNombre().length()==0||a.getTitulo().length()==0||a.getNombre().length()==0) 
            return false;            
        else
        {
            AccesoDatos.AccesoDatosCarrera.getInstance().modificar(a);
            return true;
        }
    }
    public String eliminarResponse(Carrera a){
        if (a==null)
            return "Objeto a Eliminar esta Vacio";        
        else if (AccesoDatos.AccesoDatosAdministrador.getInstance().get(a.getCodigo())==null) 
            return "Objeto a Eliminar no esta en base de Datos";        
        else
            return "No hay Problema";
    }
    public String agregarResponse(Carrera a){
        if (a==null)
            return "Se esta Intentando Ingresar un dato vacio";
        else if (AccesoDatos.AccesoDatosAdministrador.getInstance().get(a.getCodigo())!=null) 
            return "Existe un Usuario en base de datos con la misma identificacion";
        else if (a.getCodigo().length()==0||a.getNombre().length()==0||a.getTitulo().length()==0) 
        {
            String aux="Los espacios: ";
            if (a.getCodigo().equals(""))
                aux=aux+"Codigo, ";
            if (a.getCursos().equals(""))
                aux=aux+"Curso, ";
            if (a.getTitulo().equals(""))
                aux=aux+"Titulo, ";            
            aux=aux+"NO pueden quedar vacios";
            return aux;
        }        
        else
            return "No hay Problema";
    }
    public String modificarResponse(Carrera a){
        if (a==null)
            return "Se esta Intentando Ingresar un dato vacio";        
        else if (a.getCodigo().length()==0||a.getNombre().length()==0||a.getTitulo().length()==0) 
        {
            String aux="Los espacios: ";
            if (a.getCodigo().equals(""))
                aux=aux+"Codigo, ";
            if (a.getCursos().equals(""))
                aux=aux+"Curso, ";
            if (a.getTitulo().equals(""))
                aux=aux+"Titulo, ";            
            aux=aux+"NO pueden quedar vacios";
            return aux;
        }        
        else
            return "No hay Problema";
    }
}
