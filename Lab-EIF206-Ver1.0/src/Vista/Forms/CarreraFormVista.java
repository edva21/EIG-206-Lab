/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Forms;

import LogicaDeNegocio.Carrera;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author edva5
 */
public class CarreraFormVista {

    
 
    private Control.ControlCarrera control;
    private Stage stage;
    private Parent root;
    private Scene scene;
    private Button yesBtn,eliminarBtn,noBtn;
    private TextField codigoTxtFld,nombreTxtFld,tituloTxtFld;
    public CarreraFormVista() {
        try {
            root = FXMLLoader.load(getClass().getResource("/Vista/XFMLDocuments/CarreraFormVista.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(CarreraFormVista.class.getName()).log(Level.SEVERE, null, ex);
        }
        scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        codigoTxtFld = (TextField) root.lookup("#codigoTxtFld");
        nombreTxtFld = (TextField) root.lookup("#nombreTxtFld");
        tituloTxtFld = (TextField) root.lookup("#tituloTxtFld");
        yesBtn = (Button) root.lookup("#yesBtn");
        noBtn = (Button) root.lookup("#noBtn");
        eliminarBtn=(Button) root.lookup("#eliminarBtn");
        stage.initStyle(StageStyle.UNDECORATED);
    }
        public void fillForm(Carrera a){    
        setAllTextIeldsEnable(true);
        codigoTxtFld.setText(a.getCodigo());
        codigoTxtFld.setEditable(false);
        tituloTxtFld.setText(a.getTitulo());
        nombreTxtFld.setText(a.getNombre());
    }    
    public void setAllTextIeldsEnable(boolean b){
        codigoTxtFld.setEditable(b);        
        tituloTxtFld.setEditable(b);
        nombreTxtFld.setEditable(b);
    }
    public void clearForm(){    
        setAllTextIeldsEnable(true);
        codigoTxtFld.setText("");        
        tituloTxtFld.setText("");
        nombreTxtFld.setText("");
    }    
    public Carrera getForm(){    
        setAllTextIeldsEnable(true);        
        return new Carrera(codigoTxtFld.getText(), tituloTxtFld.getText(),nombreTxtFld.getText());
    }    
      /**
     * @return the control
     */
    public Control.ControlCarrera getControl() {
        return control;
    }

    /**
     * @param control the control to set
     */
    public void setControl(Control.ControlCarrera control) {
        this.control = control;
        yesBtn.setOnAction(control);
        noBtn.setOnAction(control);
        getEliminarBtn().setOnAction(control);
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
     * @return the tituloTxtFld
     */
    public TextField getTituloTxtFld() {
        return tituloTxtFld;
    }

    /**
     * @param tituloTxtFld the tituloTxtFld to set
     */
    public void setTituloTxtFld(TextField tituloTxtFld) {
        this.tituloTxtFld = tituloTxtFld;
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
    
}
