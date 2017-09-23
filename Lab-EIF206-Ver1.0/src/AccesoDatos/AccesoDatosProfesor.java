/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import LogicaDeNegocio.Profesor;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author edva5
 */
public class AccesoDatosProfesor {
    private static AccesoDatosProfesor instance;
     private ArrayList<Profesor> listaProfesores;    
    static Comparator<Profesor> ProfesorCOMPARATOR;

    private AccesoDatosProfesor() {
    }
    public static AccesoDatosProfesor getInstance(){
        if (instance==null)
            instance= new AccesoDatosProfesor();
        return instance;
    }
    public void insertar(Profesor c) {
        listaProfesores.add(c);
        
    }
    public void modificar(Profesor c) {
        eliminar(c);
        insertar(c);
    }
    
    public void eliminar(Profesor c) {
        
    }    
    public Profesor get(Object o) {
        return null;
    }
    
    public List<Profesor> getAll() {
        return listaProfesores;
    }
    public List<Profesor> getAll(Object o) {
        return null;
    }
}
