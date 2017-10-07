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
import javafx.util.Callback;

/**
 *
 * @author edva5
 */
public class ModeloCarrera {

    public ModeloCarrera() {
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
}
