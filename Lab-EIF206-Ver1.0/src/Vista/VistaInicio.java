/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Control.Control;
import Vista.Inicio.LogInVista;
import Vista.Inicio.PrimeraEscenaVista;

/**
 *
 * @author edva5
 */
public class VistaInicio {
    private Control control;
    private LogInVista logInVista;
    private PrimeraEscenaVista principal; 

    public VistaInicio() {
        logInVista=new LogInVista();
        principal = new PrimeraEscenaVista();
    }
    
    /**
     * @return the control
     */
    public Control getControl() {
        return control;
    }

    /**
     * @param control the control to set
     */
    public void setControl(Control control) {
        this.control = control;
        this.logInVista.setControl(control);
        this.principal.setControl(control);
    }

    /**
     * @return the logInVista
     */
    public LogInVista getLogInVista() {
        return logInVista;
    }

    /**
     * @param logInVista the logInVista to set
     */
    public void setLogInVista(LogInVista logInVista) {
        this.logInVista = logInVista;
    }

    /**
     * @return the principal
     */
    public PrimeraEscenaVista getPrincipal() {
        return principal;
    }

    /**
     * @param principal the principal to set
     */
    public void setPrincipal(PrimeraEscenaVista principal) {
        this.principal = principal;
    }    
}
