/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Vista.Forms.CarreraFormVista;
import Vista.Principals.CarreraPrincipalVista;

/**
 *
 * @author edva5
 */
public class VistaCarrera {
    private CarreraFormVista form;
    private CarreraPrincipalVista principal;
    private AlertDispatcher alertDispatcher;
    private Control.ControlCarrera control;
    public VistaCarrera() {
        form = new CarreraFormVista();
        principal = new CarreraPrincipalVista();
        alertDispatcher = new AlertDispatcher();
    }
    /**
     * @return the form
     */
    public CarreraFormVista getForm() {
        return form;
    }

    /**
     * @param form the form to set
     */
    public void setForm(CarreraFormVista form) {
        this.form = form;
    }

    /**
     * @return the principal
     */
    public CarreraPrincipalVista getPrincipal() {
        return principal;
    }

    /**
     * @param principal the principal to set
     */
    public void setPrincipal(CarreraPrincipalVista principal) {
        this.principal = principal;
    }

    /**
     * @return the alertDispatcher
     */
    public AlertDispatcher getAlertDispatcher() {
        return alertDispatcher;
    }

    /**
     * @param alertDispatcher the alertDispatcher to set
     */
    public void setAlertDispatcher(AlertDispatcher alertDispatcher) {
        this.alertDispatcher = alertDispatcher;
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
        getForm().setControl(control);
        getPrincipal().setControl(control);
        
    }
    
}
