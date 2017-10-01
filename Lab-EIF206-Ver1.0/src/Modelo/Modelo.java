/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import AccesoDatos.AccesoDatosGrupo;
import LogicaDeNegocio.Administrador;
import LogicaDeNegocio.Carrera;
import LogicaDeNegocio.Ciclo;
import LogicaDeNegocio.Curso;
import LogicaDeNegocio.Estudiante;
import LogicaDeNegocio.Grupo;
import LogicaDeNegocio.Matriculador;
import LogicaDeNegocio.Nota;
import LogicaDeNegocio.Profesor;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Stack;

/**
 *
 * @author edva5
 */
public class Modelo extends Observable{    
    private Stack<String> historialDeVentana;
    public Modelo() {
        historialDeVentana= new Stack<String>();        
    }
    /**
     * @return the historialDeVentana
     */
    public Stack<String> getHistorialDeVentana() {
        return historialDeVentana;
    }

    /**
     * @param historialDeVentana the historialDeVentana to set
     */
    public void setHistorialDeVentana(Stack<String> historialDeVentana) {
        this.historialDeVentana = historialDeVentana;
    }
    
    
    public void remove(Grupo grupo){        
        AccesoDatosGrupo.GetInstance().eliminar(grupo);
    }
    public void remove(Profesor profesor){
        AccesoDatos.AccesoDatosProfesor.getInstance().eliminar(profesor);
    }
    public void remove(Nota nota){
        AccesoDatos.AccesoDatosNota.getInstance().eliminar(nota);
    }
    public void remove(Matriculador matriculador){
        AccesoDatos.AccesoDatosMatriculador.getInstance().eliminar(matriculador);
    }
    public void remove(Estudiante estudiante){
        AccesoDatos.AccesoDatosEstudiante.getInstance().eliminar(estudiante);
    }
    public void remove(Curso curso){
        AccesoDatos.AccesoDatosCurso.getInstance().eliminar(curso);
    }
    public void remove(Ciclo ciclo){
        AccesoDatos.AccesoDatosCiclo.getInstance().eliminar(ciclo);
    }
    public void remove(Carrera carrera){
        AccesoDatos.AccesoDatosCarrera.getInstance().eliminar(carrera);
    }
    public void remove(Administrador administrador){
        AccesoDatos.AccesoDatosAdministrador.getInstance().eliminar(administrador);
    }
    /********************************************************************/
    public void update(Grupo grupo){
        AccesoDatos.AccesoDatosGrupo.GetInstance().modificar(grupo);
    }
    public void update(Profesor profesor){
        AccesoDatos.AccesoDatosProfesor.getInstance().modificar(profesor);
    }
    public void update(Nota nota){
        AccesoDatos.AccesoDatosNota.getInstance().modificar(nota);
    }
    public void update(Matriculador matriculador){
        AccesoDatos.AccesoDatosMatriculador.getInstance().modificar(matriculador);
    }
    public void update(Estudiante estudiante){
       // AccesoDatos.AccesoDatosEstudiante.getInstance().modificar(estudiante);
    }
    public void update(Curso curso){
        AccesoDatos.AccesoDatosCurso.getInstance().modificar(curso);
    }
    public void update(Ciclo ciclo){
        AccesoDatos.AccesoDatosCiclo.getInstance().modificar(ciclo);
    }
    public void update(Carrera carrera){
        AccesoDatos.AccesoDatosCarrera.getInstance().modificar(carrera);
    }
    public void update(Administrador administrador){
        AccesoDatos.AccesoDatosAdministrador.getInstance().modificar(administrador);
    }
/************************************************************************************************/
    public List<Profesor> getAllProfesores(){
        return AccesoDatos.AccesoDatosProfesor.getInstance().getAll();
    }
    public List<Nota> getAllNotas(){
        return AccesoDatos.AccesoDatosNota.getInstance().getAll();
    }
    public List<Matriculador> getAllMatriculadores(){
        return AccesoDatos.AccesoDatosMatriculador.getInstance().getAll();
    }
   /* public List<Estudiante> getAllEstudiantes(){
        return AccesoDatos.AccesoDatosEstudiante.getInstance().getAll();
    }*/
    public List<Curso> getAllCursos(){
        return AccesoDatos.AccesoDatosCurso.getInstance().getAll();
    }
    public List<Grupo> getAllGrupos(){
        return AccesoDatos.AccesoDatosGrupo.GetInstance().getAll();
    }
    public List<Ciclo> getAllCiclos(){
        return AccesoDatos.AccesoDatosCiclo.getInstance().getAll();
    }
    public List<Carrera> getAllCarreras(){
        return AccesoDatos.AccesoDatosCarrera.getInstance().getAll();
    }
    public List<Administrador> getAllAdministradores(){
        return AccesoDatos.AccesoDatosAdministrador.getInstance().getAll();
    }
/************************************************************************************************/    
    public Profesor getProfesor(Object o){
        return AccesoDatos.AccesoDatosProfesor.getInstance().get(o);
    }
    public Nota getNota(Object o){
        return AccesoDatos.AccesoDatosNota.getInstance().get(o);
    }
    public Matriculador getMatriculador(Object o){
        return AccesoDatos.AccesoDatosMatriculador.getInstance().get(o);
    }
    public Estudiante getEstudiante(int o){
        return AccesoDatos.AccesoDatosEstudiante.getInstance().get(o);
    }
    public Curso getCurso(Object o){
        return AccesoDatos.AccesoDatosCurso.getInstance().get(o);
    }
    public Grupo getGrupo(Object o){
        return AccesoDatos.AccesoDatosGrupo.GetInstance().get(o);
    }
    public Ciclo getCiclo(Object o){
        return AccesoDatos.AccesoDatosCiclo.getInstance().get(o);
    }
    public Carrera getCarrera(Object o){
        return AccesoDatos.AccesoDatosCarrera.getInstance().get(o);
    }
    public Administrador getAdministrador(Object o){
        return AccesoDatos.AccesoDatosAdministrador.getInstance().get(o);
    }
    public void set(Grupo grupo){
        AccesoDatos.AccesoDatosGrupo.GetInstance().insertar(grupo);
    }
    public void set(Profesor profesor){
        AccesoDatos.AccesoDatosProfesor.getInstance().insertar(profesor);
    }
    public void set(Nota nota){
        AccesoDatos.AccesoDatosNota.getInstance().insertar(nota);
    }
    public void set(Matriculador matriculador){
        AccesoDatos.AccesoDatosMatriculador.getInstance().insertar(matriculador);
    }
    public void set(Estudiante estudiante){
        AccesoDatos.AccesoDatosEstudiante.getInstance().insertar(estudiante);
    }
    public void set(Curso curso){
        AccesoDatos.AccesoDatosCurso.getInstance().insertar(curso);
    }
    public void set(Ciclo ciclo){
        AccesoDatos.AccesoDatosCiclo.getInstance().insertar(ciclo);
    }
    public void set(Carrera carrera){
        AccesoDatos.AccesoDatosCarrera.getInstance().insertar(carrera);
    }
    public void set(Administrador administrador){
        AccesoDatos.AccesoDatosAdministrador.getInstance().insertar(administrador);
    }
    
    /**
     * @return the accesoDatosAdministrador
     */    
    /***************************************************************************/
    public List<Profesor> getProfesores(Object o){
        return AccesoDatos.AccesoDatosProfesor.getInstance().getAll(o);
    }
    public List<Nota> getNotas(Object o){
        return AccesoDatos.AccesoDatosNota.getInstance().getAll(o);
    }
    public List<Matriculador> getMatriculadores(Object o){
        return AccesoDatos.AccesoDatosMatriculador.getInstance().getAll(o);
    }
    /*public List<Estudiante> getEstudiantes(Object o){
        return AccesoDatos.AccesoDatosEstudiante.getInstance().getAll(o);
    }
    public List<Curso> getCursos(Object o){
        return AccesoDatos.AccesoDatosCurso.getInstance().getAll(o);
    }*/
    public List<Grupo> getGrupos(Object o){
        return AccesoDatos.AccesoDatosGrupo.GetInstance().getAll(o);
    }
    public List<Ciclo> getCiclos(Object o){
        return AccesoDatos.AccesoDatosCiclo.getInstance().getAll(o);
    }
    public List<Carrera> getCarreras(Object o){
        return AccesoDatos.AccesoDatosCarrera.getInstance().getAll(o);
    }
    
}
