/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Dto.EstudianteDto;
import LogicaDeNegocio.Estudiante;
import LogicaDeNegocio.Estudiante;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author edva5
 */
public class AccesoDatosEstudiante {
private static AccesoDatosEstudiante INSTANCE;
    private Comparator<Estudiante> COMPARATOR;
    private ObservableList<Estudiante> listaEstudiantees;       
     private AccesoDatosEstudiante(){         
         listaEstudiantees= FXCollections.observableArrayList();
         COMPARATOR= new Comparator<Estudiante>() {
             @Override
             public int compare(Estudiante o1, Estudiante o2) {
                 return o1.getCedulaOPassaporte().compareTo(o2.getCedulaOPassaporte());
             }
         };
     }
     
     public static AccesoDatosEstudiante getInstance(){
         if (INSTANCE==null) 
             INSTANCE=new AccesoDatosEstudiante();
         return INSTANCE;
     }
       
    public void insertar(Estudiante c) {
        listaEstudiantees.add(c);
        listaEstudiantees.sort(COMPARATOR);
        
    }
    public void modificar(Estudiante c) {
        int aux=listaEstudiantees.indexOf(get(c.getCedulaOPassaporte()));
        listaEstudiantees.remove(aux);
        listaEstudiantees.add(aux, c);
        
    }
    
    public void eliminar(Object o) {
        if (o instanceof Estudiante) 
            listaEstudiantees.remove((Estudiante)o);
        else if (o instanceof String) {
            listaEstudiantees.remove(get(o));
        }            
    }    
    public Estudiante get(Object o) {    
    int pisition=buscar(o);
        if (listaEstudiantees.isEmpty()||pisition<0) 
            return null;
        else          
            return listaEstudiantees.get(pisition);
    }
    private int buscar(Object o) {                        
        if (listaEstudiantees.size()>999)
            return Collections.binarySearch(listaEstudiantees, new Estudiante(o.toString()), COMPARATOR);
        else{
            for(Estudiante e:listaEstudiantees){
                if (e.getCedulaOPassaporte().equals(o.toString())) 
                    return listaEstudiantees.indexOf(e);
            }
            return -1;
        } 
    }    
    public ObservableList<Estudiante> getAll() {
        return listaEstudiantees;
    }
    /*public void setEstudiantees(ArrayList<Estudiante> list) {
        listaEstudiantees.addAll(list);
    }*/

    /**
     *
     * @param list
     */
    public void setEstudianteesDto(ArrayList<EstudianteDto> list) {
        listaEstudiantees.clear();
        if (!list.isEmpty()) {
            list.stream().forEach(x->insertar(new Estudiante(x)));
        }
        
    }
}