/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Inicio;

import Control.Control;
import Modelo.Modelo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author edva5
 */
public class PrimeraEscenaVista {

    
    private Control control;
    private Modelo modelo;
    private Stage stage;
    private Parent root;
    private Scene scene;
    private MenuBar menuBar;    
    

    public PrimeraEscenaVista() {        
        
        try {
            this.root = FXMLLoader.load(getClass().getResource("/Vista/XFMLDocuments/PrimeraEscenaVista.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(PrimeraEscenaVista.class.getName()).log(Level.SEVERE, null, ex);
        }
        scene = new Scene(root);
        
        menuBar=(MenuBar) root.lookup("#menuBar");                                                
        stage = new Stage();
        stage.setScene(scene);
        
        
        
    }
    /**
     * @return the control
     */
    public Control getControl() {
        return control;
    }

    /**
     * @param control the control to set
     */
    public void setControl(Control control) {
        this.control = control;
        getMenuBar().getMenus().get(0).getItems().stream().forEach(x->x.setOnAction(control));
        getMenuBar().getMenus().stream().forEach(x->x.getItems().stream().forEach(y->y.setOnAction(control)));
    }
    
    /**
     * @return the modelo
     */
    public Modelo getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
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
     * @return the administradorMnuItm
     */    
    /**
     * @return the menuBar
     */
    public MenuBar getMenuBar() {
        return menuBar;
    }

    /**
     * @param menuBar the menuBar to set
     */
    public void setMenuBar(MenuBar menuBar) {
        this.menuBar = menuBar;
    }
    public ObservableList<Menu> getMenus() {
        return menuBar.getMenus();
    }
    public ObservableList<MenuItem> getMenuItems(String MenuTxt) {
        if (menuBar.getMenus().isEmpty())
            return (ObservableList<MenuItem>) new ArrayList<MenuItem>();
        else if (menuBar.getMenus().stream().anyMatch(x->x.getText().equals(MenuTxt)))
            return (ObservableList<MenuItem>) new ArrayList<MenuItem>(menuBar.getMenus().stream().filter(x->x.getText().equals(MenuTxt)).collect(Collectors.toList()));
        else
            return (ObservableList<MenuItem>) new ArrayList<MenuItem>();                
    }
}
