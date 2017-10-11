/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Principals;

import Control.ControlAdministrador;
import LogicaDeNegocio.Administrador;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 *
 * @author edva5
 */
public class AdministradorPrincipalVista {

    private ControlAdministrador control;
    private Stage stage;
    private Parent root;
    private Scene scene;
    private Button agregarBtn;
    private TableView<Administrador> table;
    
    private ArrayList<TableColumn<Administrador,String>> admiTableColumns;
    private Alert alert;
    public AdministradorPrincipalVista() {
        
        admiTableColumns= new ArrayList<>();
        try {
            this.root = FXMLLoader.load(getClass().getResource("/Vista/XFMLDocuments/AdministradorVista.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ControlAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        scene = new Scene(getRoot());
        stage = new Stage();
        stage.setScene(scene);
        
        agregarBtn=(Button) root.lookup("#agregarBtn");        
        table=(TableView<Administrador>) root.lookup("#table");
        
        
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
 

    /**
     * @return the table
     */
    public TableView<Administrador> getTable() {
        return table;
    }

    /**
     * @param table the table to set
     */
    public void setTable(TableView<Administrador> table) {
        this.table = table;
    }
    /**
     * @return the admiTableColumns
     */
    public ArrayList<TableColumn<Administrador,String>> getAdmiTableColumns() {
        return admiTableColumns;
    }

    /**
     * @param admiTableColumns the admiTableColumns to set
     */
    public void setAdmiTableColumns(ArrayList<TableColumn<Administrador,String>> admiTableColumns) {
        this.admiTableColumns = admiTableColumns;        
    }
    /**
     * @return the control
     */
    public ControlAdministrador getControl() {
        return control;
    }

    /**
     * @param control the control to set
     */
    public void setControl(ControlAdministrador control) {
        this.control = control;        
        agregarBtn.setOnAction(control);        
        stage.setOnCloseRequest(control);
        this.table.setOnMouseClicked(control);
        
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
     * @return the alet
     */
    public Alert getAlert() {
        return alert;
    }

    /**
     * @param <error>
     * @param alet the alet to set
     */
    
}
