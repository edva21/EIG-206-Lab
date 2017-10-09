/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Inicio;

import Control.Control;
import Control.ControlAdministrador;
import Modelo.Modelo;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author edva5
 */
public class LogInVista {
    private Control control;
    
    private Stage stage;
    private Parent root;
    private Scene scene;
    private Button logInBtn,cancelarBtn;
    private TextField identificacionTxtId,claveTxtId;

    public LogInVista() {
          
         try {
            this.root = FXMLLoader.load(getClass().getResource("/Vista/XFMLDocuments/LogInVista.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ControlAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        scene = new Scene(getRoot());
        identificacionTxtId=(TextField) root.lookup("#identificacionTxtId");
        claveTxtId=(TextField) root.lookup("#claveTxtId");
        logInBtn= (Button) root.lookup("#logInBtn");
        cancelarBtn= (Button) root.lookup("#cancelarBtn");
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
        this.cancelarBtn.setOnAction(control);
        this.logInBtn.setOnAction(control);
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
     * @return the logInBtn
     */
    public Button getLogInBtn() {
        return logInBtn;
    }

    /**
     * @param logInBtn the logInBtn to set
     */
    public void setLogInBtn(Button logInBtn) {
        this.logInBtn = logInBtn;
    }

    /**
     * @return the cancelarBtn
     */
    public Button getCancelarBtn() {
        return cancelarBtn;
    }

    /**
     * @param cancelarBtn the cancelarBtn to set
     */
    public void setCancelarBtn(Button cancelarBtn) {
        this.cancelarBtn = cancelarBtn;
    }

    /**
     * @return the identificacionTxtId
     */
    public TextField getIdentificacionTxtId() {
        return identificacionTxtId;
    }

    /**
     * @param identificacionTxtId the identificacionTxtId to set
     */
    public void setIdentificacionTxtId(TextField identificacionTxtId) {
        this.identificacionTxtId = identificacionTxtId;
    }

    /**
     * @return the claveTxtId
     */
    public TextField getClaveTxtId() {
        return claveTxtId;
    }

    /**
     * @param claveTxtId the claveTxtId to set
     */
    public void setClaveTxtId(TextField claveTxtId) {
        this.claveTxtId = claveTxtId;
    }
    
    
}
