/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Vista.Forms.CursoForm;
import Vista.Principals.CursoPrincipalVista;

/**
 *
 * @author edva5
 */
public class VistaCurso {
        private CursoForm form;
    private CursoPrincipalVista principal;
    private AlertDispatcher alertDispatcher;
    private Control.ControlCurso control;

    public VistaCurso() {
        form = new CursoForm();
        principal=new CursoPrincipalVista();
        alertDispatcher=new AlertDispatcher();
    }
    
    /**
     * @return the form
     */
    public CursoForm getForm() {
        return form;
    }

    /**
     * @param form the form to set
     */
    public void setForm(CursoForm form) {
        this.form = form;
    }

    /**
     * @return the principal
     */
    public CursoPrincipalVista getPrincipal() {
        return principal;
    }

    /**
     * @param principal the principal to set
     */
    public void setPrincipal(CursoPrincipalVista principal) {
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
    public Control.ControlCurso getControl() {
        return control;
        
    }

    /**
     * @param control the control to set
     */
    public void setControl(Control.ControlCurso control) {
        this.control = control;
        this.form.setControl(control);
        this.principal.setControl(control);
    }

}
