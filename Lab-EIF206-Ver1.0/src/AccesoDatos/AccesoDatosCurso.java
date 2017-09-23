/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import LogicaDeNegocio.Curso;
import LogicaDeNegocio.Grupo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author edva5
 */
public class AccesoDatosCurso {
    private static AccesoDatosCurso instance;
     private ArrayList<Curso> listaCursos;        
    static Comparator<Curso> CursoCOMPARATOR;

    private AccesoDatosCurso() {
    }
    /**
     * @return the instance
     */
    public static AccesoDatosCurso getInstance() {
        if (instance==null)
            instance= new AccesoDatosCurso();
        return instance;
    }
    
       
    public void insertar(Curso c) {
        listaCursos.add(c);
        
    }
    public void modificar(Curso c) {
        eliminar(c);
        insertar(c);
    }
    
    public void eliminar(Curso c) {
        
    }    
    public Curso get(Object o) {
        return null;
    }
    
    public List<Curso> getAll() {
        return listaCursos;
    }
    public List<Curso> getAll(Object o) {
        return null;
    }
   
}
