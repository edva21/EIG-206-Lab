/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author edva5
 */
public class AlertDispatcher {
    private Alert alert;
    private Optional<ButtonType> result;
    public AlertDispatcher() {
    }
    
    public void setAlert(Alert.AlertType alertType,String contentText,ButtonType buttonType) {
        this.alert = new Alert(alertType, contentText, buttonType);        
        setResult(alert.showAndWait());
    }
    public void setAlert(Alert.AlertType alertType,String contentText,ButtonType buttonType,ButtonType buttonType2) {
        this.alert = new Alert(alertType, contentText, buttonType,buttonType2);        
        setResult(alert.showAndWait());
    }
    /**
     * @return the result
     */
    public Optional<ButtonType> getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(Optional<ButtonType> result) {
        this.result = result;
    }    
}
