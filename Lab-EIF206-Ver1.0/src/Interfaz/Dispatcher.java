/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;


import Control.Control;
import Modelo.Modelo;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author edva5
 */
public class Dispatcher {

    /**
     * @return the interfazEstudiante
     */
    public InterfazEstudiante getInterfazEstudiante() {
        return (InterfazEstudiante) interfazEstudiante;
    }

    /**
     * @param interfazEstudiante the interfazEstudiante to set
     */
    public void setInterfazEstudiante(myInterface interfazEstudiante) {
        this.interfazEstudiante = interfazEstudiante;
    }

    /**
     * @return the interfazActual
     */
    public myInterface getInterfazActual() {
        return interfazActual;
    }
    private myInterface interfazActual;
    private ArrayList<myInterface> interfaces;
    private myInterface interfazAdministrador;
    private myInterface interfazCarrera;
    private myInterface interfazCiclo;
    private myInterface interfazCurso;
    private myInterface interfazGrupo;
    private myInterface interfazEstudiante;
    private myInterface interfazMatriculador;
    private myInterface interfazNota;
    private myInterface interfazProfesor;
    private myInterface interfazMenuAdministrador;
    private myInterface interfazMenuEstudiante;
    private myInterface interfazMenuMatriculador;
    private myInterface interfazLogIn;
    public static String LOGIN="LogIn",MENUADMINISTRADOR="Menu Administrador",MENUESTUDIANTE="Menu Estudiante",MENUMATRICULADOR="Menu Matriculador",
            ADMINISTRADOR="Administrador",CARRERA="Carrera",CICLO="Cliclo",CURSO="Curso",GRUPO="Grupo",MATRICULADOR="Matriculador",NOTA="Nota",PROFESOR="Profesor",ESTUDIANTE="Estudiante";
    public Dispatcher() {
        interfazActual=null;
        interfaces=new ArrayList<myInterface>();
        interfaces.add(interfazLogIn);
        interfaces.add(interfazMenuMatriculador);
        interfaces.add(interfazMenuEstudiante);
        interfaces.add(interfazMenuAdministrador);
        interfaces.add(interfazProfesor);
        interfaces.add(interfazNota);
        interfaces.add(interfazMatriculador);
        interfaces.add(interfazGrupo);
        interfaces.add(interfazCurso);
        interfaces.add(interfazCiclo);
        interfaces.add(interfazCarrera);
        interfaces.add(interfazAdministrador);
    }
    public void dispatcherRequest(String Interface,Modelo modelo,Control control){
        switch(Interface){
            case "LogIn":                
                setInterfazLogIn(new InterfazLogIn());
                this.switchWindow(getInterfazLogIn(), modelo, control);
                break;
            case "Menu Administrador":
                setInterfazMenuAdministrador(new InterfazMenuAdministrador());
                this.switchWindow(getInterfazMenuAdministrador(), modelo, control);
                break;
            case "Menu Estudiante":
                setInterfazMenuEstudiante(new InterfazMenuEstudiante());
                this.switchWindow(getInterfazMenuEstudiante(), modelo, control);
                break;
            case "Menu Matriculador":
                setInterfazMenuMatriculador(new InterfazMenuMatriculador());
                this.switchWindow(getInterfazMenuMatriculador(), modelo, control);
                break;
            case "Administrador":
                setInterfazAdministrador(new InterfazAdministrador());
                this.switchWindow(getInterfazAdministrador(), modelo, control);
                break;
            case "Carrera":
                setInterfazCarrera(new InterfazCarrera());
                this.switchWindow(getInterfazCarrera(), modelo, control);
                break;
            case "Ciclo":
                setInterfazCiclo(new InterfazCiclo());
                this.switchWindow(getInterfazCiclo(), modelo, control);
                break;
            case "Curso":
                setInterfazCurso(new InterfazCurso());
                this.switchWindow(getInterfazCurso(), modelo, control);
                break;
            case "Grupo":
                setInterfazGrupo(new InterfazGrupo());
                this.switchWindow(getInterfazGrupo(), modelo, control);
                break;
            case "Matriculador":
                setInterfazMatriculador(new InterfazMatriculador());
                this.switchWindow(getInterfazMatriculador(), modelo, control);
                break;
            case "Nota":
                setInterfazNota(new InterfazNota());
                this.switchWindow(getInterfazNota(), modelo, control);
                break;
            case "Profesor":
                setInterfazProfesor(new InterfazProfesor());
                this.switchWindow(getInterfazProfesor(), modelo, control);
                break;
            case "Estudiante":
                setInterfazEstudiante(new InterfazEstudiante());
                this.switchWindow(getInterfazProfesor(), modelo, control);
                break;
        }
    }
    /**
     * @return the interfazAdministrador
     */
    public InterfazAdministrador getInterfazAdministrador() {
        return (InterfazAdministrador) interfazAdministrador;
    }

    /**
     * @param interfazAdministrador the interfazAdministrador to set
     */
    public void setInterfazAdministrador(InterfazAdministrador interfazAdministrador) {
        this.interfazAdministrador = interfazAdministrador;
    }

    /**
     * @return the interfazCarrera
     */
    public InterfazCarrera getInterfazCarrera() {
        return (InterfazCarrera) interfazCarrera;
    }

    /**
     * @param interfazCarrera the interfazCarrera to set
     */
    public void setInterfazCarrera(InterfazCarrera interfazCarrera) {
        this.interfazCarrera = interfazCarrera;
    }

    /**
     * @return the interfazCiclo
     */
    public InterfazCiclo getInterfazCiclo() {
        return (InterfazCiclo) interfazCiclo;
    }

    /**
     * @param interfazCiclo the interfazCiclo to set
     */
    public void setInterfazCiclo(InterfazCiclo interfazCiclo) {
        this.interfazCiclo = interfazCiclo;
    }

    /**
     * @return the interfazCurso
     */
    public InterfazCurso getInterfazCurso() {
        return (InterfazCurso) interfazCurso;
    }

    /**
     * @param interfazCurso the interfazCurso to set
     */
    public void setInterfazCurso(InterfazCurso interfazCurso) {
        this.interfazCurso = interfazCurso;
    }

    /**
     * @return the interfazGrupo
     */
    public InterfazGrupo getInterfazGrupo() {
        return (InterfazGrupo) interfazGrupo;
    }

    /**
     * @param interfazGrupo the interfazGrupo to set
     */
    public void setInterfazGrupo(InterfazGrupo interfazGrupo) {
        this.interfazGrupo = interfazGrupo;
    }

    /**
     * @return the interfazMatriculador
     */
    public InterfazMatriculador getInterfazMatriculador() {
        return (InterfazMatriculador) interfazMatriculador;
    }

    /**
     * @param interfazMatriculador the interfazMatriculador to set
     */
    public void setInterfazMatriculador(InterfazMatriculador interfazMatriculador) {
        this.interfazMatriculador = interfazMatriculador;
    }

    /**
     * @return the interfazNota
     */
    public InterfazNota getInterfazNota() {
        return (InterfazNota) interfazNota;
    }

    /**
     * @param interfazNota the interfazNota to set
     */
    public void setInterfazNota(InterfazNota interfazNota) {
        this.interfazNota = interfazNota;
    }

    /**
     * @return the interfazProfesor
     */
    public InterfazProfesor getInterfazProfesor() {
        return (InterfazProfesor) interfazProfesor;
    }

    /**
     * @param interfazProfesor the interfazProfesor to set
     */
    public void setInterfazProfesor(InterfazProfesor interfazProfesor) {
        this.interfazProfesor = interfazProfesor;
    }

    /**
     * @return the interfazMenuAdministrador
     */
    public InterfazMenuAdministrador getInterfazMenuAdministrador() {
        return (InterfazMenuAdministrador) interfazMenuAdministrador;
    }

    /**
     * @param interfazMenuAdministrador the interfazMenuAdministrador to set
     */
    public void setInterfazMenuAdministrador(InterfazMenuAdministrador interfazMenuAdministrador) {
        this.interfazMenuAdministrador = interfazMenuAdministrador;
    }

    /**
     * @return the interfazMenuEstudiante
     */
    public InterfazMenuEstudiante getInterfazMenuEstudiante() {
        return (InterfazMenuEstudiante) interfazMenuEstudiante;
    }

    /**
     * @param interfazMenuEstudiante the interfazMenuEstudiante to set
     */
    public void setInterfazMenuEstudiante(InterfazMenuEstudiante interfazMenuEstudiante) {
        this.interfazMenuEstudiante = interfazMenuEstudiante;
    }

    /**
     * @return the interfazMenuMatriculador
     */
    public InterfazMenuMatriculador getInterfazMenuMatriculador() {
        return (InterfazMenuMatriculador) interfazMenuMatriculador;
    }

    /**
     * @param interfazMenuMatriculador the interfazMenuMatriculador to set
     */
    public void setInterfazMenuMatriculador(InterfazMenuMatriculador interfazMenuMatriculador) {
        this.interfazMenuMatriculador = interfazMenuMatriculador;
    }

    /**
     * @return the interfazLogIn
     */
    public InterfazLogIn getInterfazLogIn() {
        return (InterfazLogIn) interfazLogIn;
    }

    /**
     * @param interfazLogIn the interfazLogIn to set
     */
    public void setInterfazLogIn(InterfazLogIn interfazLogIn) {
        this.interfazLogIn = interfazLogIn;
    }    
    private void switchWindow(myInterface i,Modelo modelo,Control control){
        if (interfazActual!=null) {            
            interfazActual.dispose();
            interfazActual=null;
            interfaces.stream().forEach(x->x=null);
        }
        interfazActual=null;        
        i.setControl(control);
        i.setModelo(modelo);
        i.setVisible(true);
        interfazActual=null;
    }
    
}
