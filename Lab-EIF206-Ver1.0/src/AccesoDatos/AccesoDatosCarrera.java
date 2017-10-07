/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;


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
    private ObservableList<Carrera> listaCarreras;       
     private AccesoDatosCarrera(){         
         listaCarreras= FXCollections.observableArrayList();
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
        listaCarreras.add(c);
        listaCarreras.sort(COMPARATOR);
        
    }
    public void modificar(Carrera c) {
        int aux=listaCarreras.indexOf(get(c.getCodigo()));
        listaCarreras.remove(aux);
        listaCarreras.add(aux, c);
        
    }
    
    public void eliminar(Object o) {
        if (o instanceof Carrera) 
            listaCarreras.remove((Carrera)o);
        else if (o instanceof String) {
            listaCarreras.remove(get(o));
        }            
    }    
    public Carrera get(Object o) {    
    int pisition=buscar(o);
        if (listaCarreras.isEmpty()||pisition<0) 
            return null;
        else          
            return listaCarreras.get(pisition);
    }
    private int buscar(Object o) {                        
        return Collections.binarySearch(listaCarreras, new Carrera(o.toString(), null, null), COMPARATOR);
    }    
    public ObservableList<Carrera> getAll() {
        return listaCarreras;
    }
    public void setCarreraes(ArrayList<Carrera> list) {
        listaCarreras.addAll(list);
    }

}
