/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Modelos;


import LogicaDeNegocio.Ciclo;
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
public class ModeloCiclo {
    public ModeloCiclo() {
    }
    public boolean validateTableSelection(TableView<Ciclo> table){
        if (table.getSelectionModel().isEmpty())
            return false;       
        if (table.getSelectionModel().selectedItemProperty().getValue()==null)
            return false;      
        else   return true;
    }
    public String getValidateTableSelectionMessage(TableView<Ciclo> table){
        if (table.getSelectionModel().isEmpty())
            return "Tabla Vacia";
        if (table.getSelectionModel().getSelectedItem()==null)
            return "Ningun Ciclo Seleccionado";
        else return "Something Went Wrong" ;
    }
    public boolean AlertResponse(AlertDispatcher alertDispatcher){
        if (alertDispatcher.getResult().equals(ButtonType.YES))
            return true;
        else
            return false;
    }
    public boolean eliminar(Ciclo a){
        if (a==null)
            return false;        
        else if (AccesoDatos.AccesoDatosCiclo.getInstance().get(a.getCodigo())==null) 
            return false;
        else
        {
            AccesoDatos.AccesoDatosCiclo.getInstance().eliminar(a.getCodigo());
            return true;
        }
    }
    public boolean agregar(Ciclo a){
        if (a==null)
            return false;        
        else if (AccesoDatos.AccesoDatosCiclo.getInstance().get(a.getCodigo())!=null) 
            return false;
        else if (!validateCiclo(a)) 
            return false;            
        else
        {
            AccesoDatos.AccesoDatosCiclo.getInstance().insertar(a);
            return true;
        }
    }
    public boolean modificar(Ciclo a){
        if (a==null)
            return false;        
        else if (AccesoDatos.AccesoDatosCiclo.getInstance().get(a.getCodigo())==null) 
            return false;
        else if (!validateCiclo(a)) 
            return false;            
        else
        {
            AccesoDatos.AccesoDatosCiclo.getInstance().modificar(a);
            return true;
        }
    }
    public String eliminarResponse(Ciclo a){
        if (a==null)
            return "Objeto a Eliminar esta Vacio";        
        else if (AccesoDatos.AccesoDatosCiclo.getInstance().get(a.getCodigo())==null) 
            return "Objeto a Eliminar no esta en base de Datos";        
        else
            return "No hay Problema";
    }
    public String agregarResponse(Ciclo a){
        if (a==null)
            return "Se esta Intentando Ingresar un dato vacio";
        else if (AccesoDatos.AccesoDatosCiclo.getInstance().get(a.getCodigo())!=null) 
            return "Existe un Usuario en base de datos con la misma identificacion";
        else if (!validateCiclo(a)) 
        {
            String aux="Los espacios: ";
            
            aux=aux+"NO pueden quedar vacios";
            return aux;
        }        
        else
            return "No hay Problema";
    }
    public String modificarResponse(Ciclo a){
        if (a==null)
            return "Se esta Intentando Ingresar un dato vacio";        
        else if (validateCiclo(a)) 
        {
            String aux="Los espacios: ";          
            aux=aux+"NO pueden quedar vacios";
            return aux;
        }        
        else
            return "No hay Problema";
    }
    public void setTableColumnsNames(ArrayList<TableColumn<Ciclo,String>> columns){
        for (int i = 0; i < Ciclo.getClassNames().length; i++) {
            columns.add(new TableColumn<Ciclo, String>(Ciclo.getClassNames()[i]));   //Add names to Columns' headers
            OrderTableViewInfo(columns.get(i),Ciclo.getClassNames()[i]);            
        }
    }
    private void OrderTableViewInfo(TableColumn<Ciclo, String> tablecolumn,String columnName){
        switch(columnName){//Depending on the Header's Name, it assings a specific value of the object to a specific column
                case Ciclo.ATRIBUTTE_CODIGO:                        
                tablecolumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Ciclo, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<Ciclo, String> p) {
                        // p.getValue() returns the Person instance for a particular TableView row
                        return new ReadOnlyObjectWrapper<>(p.getValue().getCodigo());
                    }
                });            
                    break;
                case Ciclo.ATRIBUTTE_NUMERO:
                tablecolumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Ciclo, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<Ciclo, String> p) {
                        // p.getValue() returns the Person instance for a particular TableView row
                        return new ReadOnlyObjectWrapper<>(String.valueOf(p.getValue().getNumero()));
                    }
                });
                    break;
                case Ciclo.ATRIBUTTE_FECHA_INI:
                    tablecolumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Ciclo, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<Ciclo, String> p) {
                        // p.getValue() returns the Person instance for a particular TableView row
                        return new ReadOnlyObjectWrapper<>(p.getValue().getFechaIni().toString());
                    }
                });
                    break;            
                case Ciclo.ATRIBUTTE_FECHA_FIN:
                    tablecolumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Ciclo, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<Ciclo, String> p) {
                        // p.getValue() returns the Person instance for a parTableView row
                        return new ReadOnlyObjectWrapper<>(p.getValue().getFechaFin().toString());
                    }
                });
                    break;
                
            }
    }
    private boolean validateCiclo(Ciclo a){
        if (a==null)
            return false;        
        else if (a.getCodigo().equals(""))
            return false;
        else if (a.getNumero()<1||a.getNumero()>2)
            return false;
        else if (a.getFechaFin()==null)
            return false;
        else if (a.getFechaIni()==null)
            return false;
        else if (a.getFechaIni().isAfter(a.getFechaFin()))
            return false;        
        else return true;
    }
}
