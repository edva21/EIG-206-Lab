/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Principals;

import LogicaDeNegocio.Carrera;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 *
 * @author edva5
 */
public class CarreraPrincipalVista {   
    private Stage stage;
    private Parent root;
    private Scene scene;
    private Button agregarBtn;
    private Button eliminarBtn;
    private Button editarBtn;
    private TableView<Carrera> table;
    private ArrayList<TableColumn<Carrera,String>> admiTableColumns;
    public CarreraPrincipalVista() {
        admiTableColumns= new ArrayList<TableColumn<Carrera,String>>();
        stage = new Stage();
        try {
            this.root = FXMLLoader.load(getClass().getResource("/Vista/XFMLDocuments/AdministradorVista.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(CarreraPrincipalVista.class.getName()).log(Level.SEVERE, null, ex);
        }
        scene = new Scene(root);
        stage.setScene(scene);
        agregarBtn = (Button) root.lookup("#agregarBtn");
        eliminarBtn = (Button) root.lookup("#eliminarBtn");
        editarBtn = (Button) root.lookup("#editarBtn");
        table = (TableView<Carrera>) root.lookup("#table");               
    }
    /**
     * @return the stage
     */
    public Stage getStage() {
        return stage;
    }

    /**
     * @param stage the stage to set
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * @return the root
     */
    public Parent getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    public void setRoot(Parent root) {
        this.root = root;
    }

    /**
     * @return the scene
     */
    public Scene getScene() {
        return scene;
    }

    /**
     * @param scene the scene to set
     */
    public void setScene(Scene scene) {
        this.scene = scene;
    }

    /**
     * @return the agregarBtn
     */
    public Button getAgregarBtn() {
        return agregarBtn;
    }

    /**
     * @param agregarBtn the agregarBtn to set
     */
    public void setAgregarBtn(Button agregarBtn) {
        this.agregarBtn = agregarBtn;
    }

    /**
     * @return the eliminarBtn
     */
    public Button getEliminarBtn() {
        return eliminarBtn;
    }

    /**
     * @param eliminarBtn the eliminarBtn to set
     */
    public void setEliminarBtn(Button eliminarBtn) {
        this.eliminarBtn = eliminarBtn;
    }

    /**
     * @return the editarBtn
     */
    public Button getEditarBtn() {
        return editarBtn;
    }

    /**
     * @param editarBtn the editarBtn to set
     */
    public void setEditarBtn(Button editarBtn) {
        this.editarBtn = editarBtn;
    }

    /**
     * @return the table
     */
    public TableView<Carrera> getTable() {
        return table;
    }

    /**
     * @param table the table to set
     */
    public void setTable(TableView<Carrera> table) {
        this.table = table;
    }    
     /**
     * @return the admiTableColumns
     */
    public ArrayList<TableColumn<Carrera,String>> getAdmiTableColumns() {
        return admiTableColumns;
    }

    /**
     * @param admiTableColumns the admiTableColumns to set
     */
    public void setAdmiTableColumns(ArrayList<TableColumn<Carrera,String>> admiTableColumns) {
        this.admiTableColumns = admiTableColumns;
    }
}
