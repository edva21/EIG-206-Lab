/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Forms;

import Control.ControlAdministrador;
import LogicaDeNegocio.Carrera;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author edva5
 */
public class CursoForm {

    private Control.ControlPadre control;
    private Parent root;
    private Stage stage;
    private Scene scene;
    private TextField codigoTxtFld,nombreTxtFld;
    private Spinner creditosSpnnr,horasSpnnr;
    private ComboBox<Carrera> carreraCmbBx;
    private Button yesBtn,noBtn,eliminarBtn;

    public CursoForm() {
        try {
            this.root = FXMLLoader.load(getClass().getResource("/Vista/XFMLDocuments/CursoForm.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ControlAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }   
        scene = new Scene(getRoot());
        codigoTxtFld = (TextField) root.lookup("#codigoTxtFld");
        nombreTxtFld = (TextField) root.lookup("#nombreTxtFld");
        creditosSpnnr = (Spinner) root.lookup("#creditosSpnnr");
        horasSpnnr = (Spinner) root.lookup("#horasSpnnr");
        carreraCmbBx = (ComboBox) root.lookup("#carreraCmbBx");
        yesBtn=(Button) root.lookup("#yesBtn");
        noBtn=(Button) root.lookup("#noBtn");
        eliminarBtn=(Button) root.lookup("#eliminarBtn");
        stage = new Stage();
        stage.setScene(scene);
    }
    /**
     * @return the control
     */
    public Control.ControlPadre getControl() {
        return control;
    }

    /**
     * @param control the control to set
     */
    public void setControl(Control.ControlPadre control) {
        this.control = control;
        noBtn.setOnAction(control);
        eliminarBtn.setOnAction(control);
        yesBtn.setOnAction(control);
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
     * @return the nombreTxtFld
     */
    public TextField getNombreTxtFld() {
        return nombreTxtFld;
    }

    /**
     * @param nombreTxtFld the nombreTxtFld to set
     */
    public void setNombreTxtFld(TextField nombreTxtFld) {
        this.nombreTxtFld = nombreTxtFld;
    }

    /**
     * @return the creditosSpnnr
     */
    public Spinner getCreditosSpnnr() {
        return creditosSpnnr;
    }

    /**
     * @param creditosSpnnr the creditosSpnnr to set
     */
    public void setCreditosSpnnr(Spinner creditosSpnnr) {
        this.creditosSpnnr = creditosSpnnr;
    }

    /**
     * @return the horasSpnnr
     */
    public Spinner getHorasSpnnr() {
        return horasSpnnr;
    }

    /**
     * @param horasSpnnr the horasSpnnr to set
     */
    public void setHorasSpnnr(Spinner horasSpnnr) {
        this.horasSpnnr = horasSpnnr;
    }

    /**
     * @return the carreraCmbBx
     */
    public ComboBox getCarreraCmbBx() {
        return carreraCmbBx;
    }

    /**
     * @param carreraCmbBx the carreraCmbBx to set
     */
    public void setCarreraCmbBx(ComboBox carreraCmbBx) {
        this.carreraCmbBx = carreraCmbBx;
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
    public void clearForm(){
        codigoTxtFld.setText("");
        nombreTxtFld.setText("");
        creditosSpnnr.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,12,3));
        horasSpnnr.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,24,1));
        carreraCmbBx.getSelectionModel().selectFirst();
    }
}
