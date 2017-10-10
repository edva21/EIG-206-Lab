/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import LogicaDeNegocio.Administrador;
import LogicaDeNegocio.Estudiante;
import LogicaDeNegocio.Matriculador;
import LogicaDeNegocio.Persona;
import LogicaDeNegocio.Profesor;



/**
 *
 * @author edva5
 */
public class Modelo{        
    private Persona logged;
    private String handledTypeOfUser,identification,clave;
    public Modelo() {
        handledTypeOfUser="null";
    }
    private boolean validateAdministradorLogIn(String cedulaPasaporte,String clave){
        Administrador a = AccesoDatos.AccesoDatosAdministrador.getInstance().get(cedulaPasaporte);
        if (a!=null)
        {
            if (a.getClave().equals(clave))
                logged=a;
            return a.getClave().equals(clave);
        }
        else
            return false;
    }
    private boolean validateEstudianteLogIn(String cedulaPasaporte,String clave){
        Estudiante e = AccesoDatos.AccesoDatosEstudiante.getInstance().get(cedulaPasaporte);
        if (e!=null)
            {
            if (e.getClave().equals(clave))
                logged=e;
            return e.getClave().equals(clave);
            }
        else
            return false;
    }
    private boolean validateMatriculadorLogIn(String cedulaPasaporte,String clave){
        Matriculador m = AccesoDatos.AccesoDatosMatriculador.getInstance().get(cedulaPasaporte);
        if (m!=null)
            {
            if (m.getClave().equals(clave))
                logged=m;
            return m.getClave().equals(clave);
            }
        else
            return false;
    }
    private boolean validateProfesorLogIn(String cedulaPasaporte,String clave){
        Profesor p = AccesoDatos.AccesoDatosProfesor.getInstance().get(cedulaPasaporte);
        if (p!=null)
            {
            if (p.getClave().equals(clave))
                logged=p;
            return p.getClave().equals(clave);
            }
        else
            return false;
    }
    /**
     * @return the logged
     */
    public Persona getLogged() {
        return logged;
    }

    /**
     * @param logged the logged to set
     */    
    public void setLogged(Persona logged) {
        this.logged = logged;
    }
    
    /**
     * @return the handledTypeOfUser
     */
    public String getHandledTypeOfUser() {
        return handledTypeOfUser;
    }

    /**
     * @param handledTypeOfUser the handledTypeOfUser to set
     */
    public void setHandledTypeOfUser(String handledTypeOfUser) {
        this.handledTypeOfUser = handledTypeOfUser;
    }
    public boolean logIn() {
        if (handledTypeOfUser.equals("null"))            
            return false;
        else if (handledTypeOfUser.equals(LogicaDeNegocio.Administrador.class.toString()))             
            return validateAdministradorLogIn(getIdentification(), getClave());
        else if (handledTypeOfUser.equals(LogicaDeNegocio.Estudiante.class.toString()))            
            return validateEstudianteLogIn(getIdentification(), getClave());
        else if (handledTypeOfUser.equals(LogicaDeNegocio.Matriculador.class.toString()))            
            return validateMatriculadorLogIn(getIdentification(), getClave());
        else if(handledTypeOfUser.equals(LogicaDeNegocio.Profesor.class.toString()))
            return validateAdministradorLogIn(getIdentification(), getClave());
        else return false;
    }
    
    /**
     * @return the identification
     */
    public String getIdentification() {
        return identification;
    }

    /**
     * @param identification the identification to set
     */
    public void setIdentification(String identification) {
        this.identification = identification;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

}
