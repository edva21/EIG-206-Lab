/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Vista.Forms.PersonaFormVista;
import Vista.Principals.ProfesorPrincipalVista;

/**
 *
 * @author edva5
 */
public class VistaProfesor {
    private PersonaFormVista form;
    private ProfesorPrincipalVista principal;
    private AlertDispatcher alertDispatcher;
    private Control.ControlProfesor control;
    public VistaProfesor() {
        form = new PersonaFormVista();
        principal = new ProfesorPrincipalVista();
        alertDispatcher = new AlertDispatcher();
    }
    /**
     * @return the form
     */
    public PersonaFormVista getForm() {
        return form;
    }

    /**
     * @param form the form to set
     */
    public void setForm(PersonaFormVista form) {
        this.form = form;
    }

    /**
     * @return the principal
     */
    public ProfesorPrincipalVista getPrincipal() {
        return principal;
    }

    /**
     * @param principal the principal to set
     */
    public void setPrincipal(ProfesorPrincipalVista principal) {
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
    public Control.ControlPadre getControl() {
        return control;
    }

    /**
     * @param control the control to set
     */
    public void setControl(Control.ControlProfesor control) {
        this.control = control;
        getForm().setControl(control);
        getPrincipal().setControl(control);
        
    }
    
    
 
}
