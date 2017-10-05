/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Vista.Forms.AdministradorFormVista;
import Vista.Principals.AdministradorPrincipalVista;

/**
 *
 * @author edva5
 */
public class VistaAdministrador {
    private AdministradorFormVista form;
    private AdministradorPrincipalVista principal;
    private AlertDispatcher alertDispatcher;
    private Control.ControlAdministrador control;
    public VistaAdministrador() {
        form = new AdministradorFormVista();
        principal = new AdministradorPrincipalVista();
        alertDispatcher = new AlertDispatcher();
    }
    /**
     * @return the form
     */
    public AdministradorFormVista getForm() {
        return form;
    }

    /**
     * @param form the form to set
     */
    public void setForm(AdministradorFormVista form) {
        this.form = form;
    }

    /**
     * @return the principal
     */
    public AdministradorPrincipalVista getPrincipal() {
        return principal;
    }

    /**
     * @param principal the principal to set
     */
    public void setPrincipal(AdministradorPrincipalVista principal) {
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
    public Control.ControlAdministrador getControl() {
        return control;
    }

    /**
     * @param control the control to set
     */
    public void setControl(Control.ControlAdministrador control) {
        this.control = control;
        getForm().setControl(control);
        getPrincipal().setControl(control);
        
    }
    
    
    
}
