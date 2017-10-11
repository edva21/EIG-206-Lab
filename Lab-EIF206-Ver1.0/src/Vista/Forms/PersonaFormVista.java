/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Forms;

import Control.ControlAdministrador;
import LogicaDeNegocio.Administrador;
import LogicaDeNegocio.Estudiante;
import LogicaDeNegocio.Matriculador;
import LogicaDeNegocio.Profesor;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javafx.util.converter.LocalDateStringConverter;
import javax.swing.JOptionPane;

/**
 *
 * @author edva5
 */
public class PersonaFormVista {   

    private Control.ControlPadre control;
    private Parent root;
    private Stage stage;
    private Scene scene;
    private TextField emailTxtFld,telefonoTxtFld,apellido2TxtFld,apellido1TxtFld,nombreTxtFld,idTxtFld;
    private PasswordField claveTxtFld;
    private DatePicker datePicker;
    private Button yesBtn,noBtn,eliminarBtn;
    public PersonaFormVista() {
         try {
            this.root = FXMLLoader.load(getClass().getResource("/Vista/XFMLDocuments/AdministradorForm.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ControlAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }         
         scene= new Scene(root);
         stage = new Stage();         
         eliminarBtn=(Button) root.lookup("#eliminarBtn");
         yesBtn= (Button) root.lookup("#yesBtn");
         noBtn= (Button) root.lookup("#noBtn");
         claveTxtFld = (PasswordField) root.lookup("#claveTxtFld");
         idTxtFld=(TextField) root.lookup("#idTextField");
         emailTxtFld=(TextField) root.lookup("#emailTxtFld");
         telefonoTxtFld=(TextField) root.lookup("#telefonoTxtFld");
         apellido2TxtFld=(TextField) root.lookup("#apellido2TxtFld");
         apellido1TxtFld=(TextField) root.lookup("#apellido1TxtFld");
         nombreTxtFld=(TextField) root.lookup("#nombreTxtFld");
         datePicker = (DatePicker) root.lookup("#datePicker");
         datePicker.setEditable(false);
         
         noBtn.setText("Cancelar");                  
         stage.setScene(scene);
         stage.initStyle(StageStyle.UNDECORATED);
    }
    
    /**
     * @return the control
     */
    public ControlAdministrador getControl() {
        return (ControlAdministrador) control;
    }

    /**
     * @param control the control to set
     */
    public void setControl(Control.ControlPadre control) {
        this.control = control;
        
        yesBtn.setOnAction(control);
        noBtn.setOnAction(control);
        getEliminarBtn().setOnAction(control);
        stage.setOnCloseRequest(control);
    }

    /**
     * @return the yesBtn
     */
    
   
    public void clearForm(){        
        setAllTextIeldsEnable(true);        
         getIdTxtFld().setText("");
         getClaveTxtFld().setText("");
         getEmailTxtFld().setText("");         
         getTelefonoTxtFld().setText("");
         getApellido1TxtFld().setText("");
         getApellido2TxtFld().setText("");         
         getNombreTxtFld().setText("");
         getDatePicker().setDayCellFactory(new Callback<DatePicker, DateCell>(){
             @Override
             public DateCell call(DatePicker param) {
                 return new DateCell();
             }
         });
    }
    public void fillForm(Administrador a){    
        getIdTxtFld().setEditable(false);
        getIdTxtFld().setText(a.getCedulaOPassaporte());
        getClaveTxtFld().setText(a.getClave());
        getEmailTxtFld().setText(a.getEmail());         
        getTelefonoTxtFld().setText(a.getTelefono());
        getApellido1TxtFld().setText(a.getApellido1());
        getApellido2TxtFld().setText(a.getApellido2());         
        getNombreTxtFld().setText(a.getNombre());
        getDatePicker().setValue(a.getFechaNacimiento());
    }

    public void setAllTextIeldsEnable(boolean b){
        getIdTxtFld().setEditable(b);
        getClaveTxtFld().setEditable(b);
        getEmailTxtFld().setEditable(b);
        getTelefonoTxtFld().setEditable(b);
         getApellido1TxtFld().setEditable(b);
         getApellido2TxtFld().setEditable(b);
         getNombreTxtFld().setEditable(b);
         getDatePicker().setEditable(b);
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
     * @return the emailTxtFld
     */
    public TextField getEmailTxtFld() {
        return emailTxtFld;
    }

    /**
     * @param emailTxtFld the emailTxtFld to set
     */
    public void setEmailTxtFld(TextField emailTxtFld) {
        this.emailTxtFld = emailTxtFld;
    }

    /**
     * @return the telefonoTxtFld
     */
    public TextField getTelefonoTxtFld() {
        return telefonoTxtFld;
    }

    /**
     * @param telefonoTxtFld the telefonoTxtFld to set
     */
    public void setTelefonoTxtFld(TextField telefonoTxtFld) {
        this.telefonoTxtFld = telefonoTxtFld;
    }

    /**
     * @return the apellido2TxtFld
     */
    public TextField getApellido2TxtFld() {
        return apellido2TxtFld;
    }

    /**
     * @param apellido2TxtFld the apellido2TxtFld to set
     */
    public void setApellido2TxtFld(TextField apellido2TxtFld) {
        this.apellido2TxtFld = apellido2TxtFld;
    }

    /**
     * @return the apellido1TxtFld
     */
    public TextField getApellido1TxtFld() {
        return apellido1TxtFld;
    }

    /**
     * @param apellido1TxtFld the apellido1TxtFld to set
     */
    public void setApellido1TxtFld(TextField apellido1TxtFld) {
        this.apellido1TxtFld = apellido1TxtFld;
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
     * @return the claveTxtFld
     */
    public PasswordField getClaveTxtFld() {
        return claveTxtFld;
    }

    /**
     * @param claveTxtFld the claveTxtFld to set
     */
    public void setClaveTxtFld(PasswordField claveTxtFld) {
        this.claveTxtFld = claveTxtFld;
    }

    /**
     * @return the datePicker
     */
    public DatePicker getDatePicker() {
        return datePicker;
    }

    /**
     * @param datePicker the datePicker to set
     */
    public void setDatePicker(DatePicker datePicker) {
        this.datePicker = datePicker;
    }
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
     * @return the idTxtFld
     */
    public TextField getIdTxtFld() {
        return idTxtFld;
    }

    /**
     * @param idTxtFld the idTxtFld to set
     */
    public void setIdTxtFld(TextField idTxtFld) {
        this.idTxtFld = idTxtFld;
    }

}
