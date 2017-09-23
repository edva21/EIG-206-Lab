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
     private ArrayList<Curso> listaCursos;        
    static Comparator<Curso> CursoCOMPARATOR;
       
    public void insertar(Curso c) {
        listaCursos.add(c);
        
    }
    public void modificar(Curso c) {
        eliminar(c);
        insertar(c);
    }
    
    public void eliminar(Curso c) {
        
    }    
    public Curso getCurso(Object o) {
        return null;
    }
    
    public List<Curso> getAllCursos() {
        return listaCursos;
    }
    /************************Grupo********************************/
    private ArrayList<Grupo> listaGrupos;    
    static Comparator<Grupo> GrupoCOMPARATOR;
       
    public void insertar(Grupo c) {
        listaGrupos.add(c);
        
    }
    public void modificar(Grupo c) {
        eliminar(c);
        insertar(c);
    }
    
    public void eliminar(Grupo c) {
        
    }    
    public Curso getGrupo(Object o) {
        return null;
    }
    
    public List<Grupo> getAllGrupos() {
        return listaGrupos;
    }
}
