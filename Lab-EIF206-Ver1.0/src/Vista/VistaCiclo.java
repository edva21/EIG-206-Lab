/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Vista.Forms.CicloFormVista;
import Vista.Principals.CicloPrincipalVista;

/**
 *
 * @author edva5
 */
public class VistaCiclo {
    private CicloFormVista form;
    private CicloPrincipalVista principal;
    private AlertDispatcher alertDispatcher;
    private Control.ControlCiclo control;

    public VistaCiclo() {
        form = new CicloFormVista();
        principal=new CicloPrincipalVista();
        alertDispatcher=new AlertDispatcher();
    }
    
    /**
     * @return the form
     */
    public CicloFormVista getForm() {
        return form;
    }

    /**
     * @param form the form to set
     */
    public void setForm(CicloFormVista form) {
        this.form = form;
    }

    /**
     * @return the principal
     */
    public CicloPrincipalVista getPrincipal() {
        return principal;
    }

    /**
     * @param principal the principal to set
     */
    public void setPrincipal(CicloPrincipalVista principal) {
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
    public Control.ControlCiclo getControl() {
        return control;
        
    }

    /**
     * @param control the control to set
     */
    public void setControl(Control.ControlCiclo control) {
        this.control = control;
        this.form.setControl(control);
        this.principal.setControl(control);
    }

    
}
