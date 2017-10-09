/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Dto.CursoDto;
import LogicaDeNegocio.Curso;
import LogicaDeNegocio.Grupo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author edva5
 */
public class AccesoDatosCurso {
private static AccesoDatosCurso INSTANCE;
    private Comparator<Curso> COMPARATOR;
    private ObservableList<Curso> listaCursos;       
     private AccesoDatosCurso(){         
         listaCursos= FXCollections.observableArrayList();
         COMPARATOR= new Comparator<Curso>() {
             @Override
             public int compare(Curso o1, Curso o2) {
                 return o1.getCodigo().compareTo(o2.getCodigo());
             }
         };
     }
     
     public static AccesoDatosCurso getInstance(){
         if (INSTANCE==null) 
             INSTANCE=new AccesoDatosCurso();
         return INSTANCE;
     }
       
    public void insertar(Curso c) {
        listaCursos.add(c);
        listaCursos.sort(COMPARATOR);
        
    }
    public void modificar(Curso c) {
        int aux=listaCursos.indexOf(get(c.getCodigo()));
        listaCursos.remove(aux);
        listaCursos.add(aux, c);
        
    }
    
    public void eliminar(Object o) {
        if (o instanceof Curso) 
            listaCursos.remove((Curso)o);
        else if (o instanceof String) {
            listaCursos.remove(get(o));
        }            
    }    
    public Curso get(Object o) {    
    int pisition=buscar(o);
        if (listaCursos.isEmpty()||pisition<0) 
            return null;
        else          
            return listaCursos.get(pisition);
    }
    private int buscar(Object o) {                        
        return Collections.binarySearch(listaCursos, new Curso(o.toString()), COMPARATOR);
    }    
    public ObservableList<Curso> getAll() {
        return listaCursos;
    }
    /*public void setCursoes(ArrayList<Curso> list) {
        listaCursos.addAll(list);
    }*/

    /**
     *
     * @param list
     */
    public void setCursoesDto(ArrayList<CursoDto> list) {
        listaCursos.clear();
        if (!list.isEmpty()) {
            list.stream().forEach(x->insertar(new Curso(x)));
        }
        
    }
}