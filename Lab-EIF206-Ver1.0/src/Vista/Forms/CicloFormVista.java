/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Forms;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author edva5
 */
public class CicloFormVista {

     private Control.ControlCiclo control;
    private Stage stage;
    private Parent root;
    private Scene scene;
    private ComboBox comboBox;
    private TextField codigoTxtFld;
    private Button yesBtn,eliminarBtn,noBtn;
    private DatePicker inicioDtPckr,conclucionDtPckr;

    public CicloFormVista() {
        try {
            root = FXMLLoader.load(getClass().getResource("/Vista/XFMLDocuments/CicloForm.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(CicloFormVista.class.getName()).log(Level.SEVERE, null, ex);
        }
        scene = new Scene(getRoot());
        codigoTxtFld=(TextField) root.lookup("#codigoTxtFld");
        eliminarBtn=(Button) root.lookup("#eliminarBtn");
        yesBtn=(Button) root.lookup("#yesBtn");
        noBtn=(Button) root.lookup("#noBtn");
        inicioDtPckr=(DatePicker) root.lookup("#inicioDtPckr");
        conclucionDtPckr=(DatePicker) root.lookup("#conclucionDtPckr");
        comboBox = (ComboBox) root.lookup("#comboBox");
        comboBox.getItems().clear();
        comboBox.getItems().add("I");
        comboBox.getItems().add("II");
        comboBox.getSelectionModel().selectFirst();
        stage = new Stage();
        stage.setScene(scene);
        
    }
    public void clearForm(){
        codigoTxtFld.setEditable(true);
        codigoTxtFld.setText("");
        inicioDtPckr.setValue(null);
        conclucionDtPckr.setValue(null);
        getComboBox().getSelectionModel().selectFirst();
    }
    /**
     * @return the control
     */
    public Control.ControlCiclo getControl() {
        return control;
    }

    /**
     * @param control the control to set
     */
    public void setControl(Control.ControlCiclo control) {
        this.control = control;
        noBtn.setOnAction(control);
        yesBtn.setOnAction(control);
        eliminarBtn.setOnAction(control);        
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
     * @return the codigoTxtFld
     */
    public TextField getCodigoTxtFld() {
        return codigoTxtFld;
    }

    /**
     * @param codigoTxtFld the codigoTxtFld to set
     */
    public void setCodigoTxtFld(TextField codigoTxtFld) {
        this.codigoTxtFld = codigoTxtFld;
    }

    /**
     * @return the yesBtn
     */
    public Button getYesBtn() {
        return yesBtn;
    }

    /**
     * @param yesBtn the yesBtn to set
     */
    public void setYesBtn(Button yesBtn) {
        this.yesBtn = yesBtn;
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
     * @return the noBtn
     */
    public Button getNoBtn() {
        return noBtn;
    }

    /**
     * @param noBtn the noBtn to set
     */
    public void setNoBtn(Button noBtn) {
        this.noBtn = noBtn;
    }

    /**
     * @return the inicioDtPckr
     */
    public DatePicker getInicioDtPckr() {
        return inicioDtPckr;
    }

    /**
     * @param inicioDtPckr the inicioDtPckr to set
     */
    public void setInicioDtPckr(DatePicker inicioDtPckr) {
        this.inicioDtPckr = inicioDtPckr;
    }

    /**
     * @return the conclucionDtPckr
     */
    public DatePicker getConclucionDtPckr() {
        return conclucionDtPckr;
    }

    /**
     * @param conclucionDtPckr the conclucionDtPckr to set
     */
    public void setConclucionDtPckr(DatePicker conclucionDtPckr) {
        this.conclucionDtPckr = conclucionDtPckr;
    }       
    
    /**
     * @return the comboBox
     */
    public ComboBox getComboBox() {
        return comboBox;
    }

    /**
     * @param comboBox the comboBox to set
     */
    public void setComboBox(ComboBox comboBox) {
        this.comboBox = comboBox;
    }
}
