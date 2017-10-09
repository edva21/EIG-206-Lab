/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Dto.NotaDto;
import LogicaDeNegocio.Nota;
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
public class AccesoDatosNota {
private static AccesoDatosNota INSTANCE;
    private Comparator<Nota> COMPARATOR;
    private ObservableList<Nota> listaNotaes;       
     private AccesoDatosNota(){         
         listaNotaes= FXCollections.observableArrayList();
         COMPARATOR= new Comparator<Nota>() {
             @Override
             public int compare(Nota o1, Nota o2) {
                 return o1.getId().compareTo(o2.getId());
             }
         };
     }
     
     public static AccesoDatosNota getInstance(){
         if (INSTANCE==null) 
             INSTANCE=new AccesoDatosNota();
         return INSTANCE;
     }
       
    public void insertar(Nota c) {
        listaNotaes.add(c);
        listaNotaes.sort(COMPARATOR);
        
    }
    public void modificar(Nota c) {
        int aux=listaNotaes.indexOf(get(c.getId()));
        listaNotaes.remove(aux);
        listaNotaes.add(aux, c);
        
    }
    
    public void eliminar(Object o) {
        if (o instanceof Nota) 
            listaNotaes.remove((Nota)o);
        else if (o instanceof String) {
            listaNotaes.remove(get(o));
        }            
    }    
    public Nota get(Object o) {    
    int pisition=buscar(o);
        if (listaNotaes.isEmpty()||pisition<0) 
            return null;
        else          
            return listaNotaes.get(pisition);
    }
    private int buscar(Object o) {                        
        return Collections.binarySearch(listaNotaes, new Nota(o.toString()), COMPARATOR);
    }    
    public ObservableList<Nota> getAll() {
        return listaNotaes;
    }
    /*public void setNotaes(ArrayList<Nota> list) {
        listaNotaes.addAll(list);
    }*/

    /**
     *
     * @param list
     */
    public void setNotaesDto(ArrayList<NotaDto> list) {
        listaNotaes.clear();
        if (!list.isEmpty()) {
            list.stream().forEach(x->insertar(new Nota(x)));
        }
        
    }
}