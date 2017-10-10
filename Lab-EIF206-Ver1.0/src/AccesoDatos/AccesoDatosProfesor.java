/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Dto.ProfesorDto;
import LogicaDeNegocio.Profesor;
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
public class AccesoDatosProfesor {
private static AccesoDatosProfesor INSTANCE;
    private Comparator<Profesor> COMPARATOR;
    private ObservableList<Profesor> listaProfesores;       
     private AccesoDatosProfesor(){         
         listaProfesores= FXCollections.observableArrayList();
         COMPARATOR= new Comparator<Profesor>() {
             @Override
             public int compare(Profesor o1, Profesor o2) {
                 return o1.getCedulaOPassaporte().compareTo(o2.getCedulaOPassaporte());
             }
         };
     }
     
     public static AccesoDatosProfesor getInstance(){
         if (INSTANCE==null) 
             INSTANCE=new AccesoDatosProfesor();
         return INSTANCE;
     }
       
    public void insertar(Profesor c) {
        listaProfesores.add(c);
        listaProfesores.sort(COMPARATOR);
        
    }
    public void modificar(Profesor c) {
        int aux=listaProfesores.indexOf(get(c.getCedulaOPassaporte()));
        listaProfesores.remove(aux);
        listaProfesores.add(aux, c);
        
    }
    
    public void eliminar(Object o) {
        if (o instanceof Profesor) 
            listaProfesores.remove((Profesor)o);
        else if (o instanceof String) {
            listaProfesores.remove(get(o));
        }            
    }    
    public Profesor get(Object o) {    
    int pisition=buscar(o);
        if (listaProfesores.isEmpty()||pisition<0) 
            return null;
        else          
            return listaProfesores.get(pisition);
    }
    private int buscar(Object o) {                        
        if (listaProfesores.size()>999)
            return Collections.binarySearch(listaProfesores, new Profesor(o.toString()), COMPARATOR);
        else{
            for(Profesor p:listaProfesores){
                if (p.getCedulaOPassaporte().equals(o.toString())) 
                    return listaProfesores.indexOf(p);
            }
            return -1;
        } 
    }    
    public ObservableList<Profesor> getAll() {
        return listaProfesores;
    }
    /*public void setProfesores(ArrayList<Profesor> list) {
        listaProfesores.addAll(list);
    }*/

    /**
     *
     * @param list
     */
    public void setProfesoresDto(ArrayList<ProfesorDto> list) {
        listaProfesores.clear();
        if (!list.isEmpty()) {
            list.stream().forEach(x->insertar(new Profesor(x)));
        }
        
    }
}