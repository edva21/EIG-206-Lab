/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;


import Dto.CarreraDto;
import LogicaDeNegocio.Carrera;
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
public class AccesoDatosCarrera {
private static AccesoDatosCarrera INSTANCE;
    private Comparator<Carrera> COMPARATOR;
    private ObservableList<Carrera> listaCarreraes;       
     private AccesoDatosCarrera(){         
         listaCarreraes= FXCollections.observableArrayList();
         COMPARATOR= new Comparator<Carrera>() {
             @Override
             public int compare(Carrera o1, Carrera o2) {
                 return o1.getCodigo().compareTo(o2.getCodigo());
             }
         };
     }
     
     public static AccesoDatosCarrera getInstance(){
         if (INSTANCE==null) 
             INSTANCE=new AccesoDatosCarrera();
         return INSTANCE;
     }
       
    public void insertar(Carrera c) {
        listaCarreraes.add(c);
        listaCarreraes.sort(COMPARATOR);
        
    }
    public void modificar(Carrera c) {
        int aux=listaCarreraes.indexOf(get(c.getCodigo()));
        listaCarreraes.remove(aux);
        listaCarreraes.add(aux, c);
        
    }
    
    public void eliminar(Object o) {
        if (o instanceof Carrera) 
            listaCarreraes.remove((Carrera)o);
        else if (o instanceof String) {
            listaCarreraes.remove(get(o));
        }            
    }    
    public Carrera get(Object o) {    
    int pisition=buscar(o);
        if (listaCarreraes.isEmpty()||pisition<0) 
            return null;
        else          
            return listaCarreraes.get(pisition);
    }
    private int buscar(Object o) {                        
        return Collections.binarySearch(listaCarreraes, new Carrera(o.toString()), COMPARATOR);
    }    
    public ObservableList<Carrera> getAll() {
        return listaCarreraes;
    }
    /*public void setCarreraes(ArrayList<Carrera> list) {
        listaCarreraes.addAll(list);
    }*/

    /**
     *
     * @param list
     */
    public void setCarreraDto(ArrayList<CarreraDto> list) {
        listaCarreraes.clear();
        if (!list.isEmpty()) {
            list.stream().forEach(x->insertar(new Carrera(x)));
        }
        
    }
}