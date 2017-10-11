/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Vista.Forms.PersonaFormVista;
import Vista.Principals.EstudiantePrincipalVista;

/**
 *
 * @author edva5
 */
public class VistaEstudiante {
     private PersonaFormVista form;
    private EstudiantePrincipalVista principal;
    private AlertDispatcher alertDispatcher;
    private Control.ControlEstudiante control;
    public VistaEstudiante() {
        form = new PersonaFormVista();
        principal = new EstudiantePrincipalVista();
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
    public EstudiantePrincipalVista getPrincipal() {
        return principal;
    }

    /**
     * @param principal the principal to set
     */
    public void setPrincipal(EstudiantePrincipalVista principal) {
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
    public void setControl(Control.ControlEstudiante control) {
        this.control = control;
        getForm().setControl(control);
        getPrincipal().setControl(control);
        
    }
    
    
 
}
