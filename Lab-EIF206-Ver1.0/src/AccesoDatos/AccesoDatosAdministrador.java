/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import LogicaDeNegocio.Administrador;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sun.security.jca.GetInstance;

/**
 *
 * @author edva5
 */
public class AccesoDatosAdministrador {
    private Comparator<Administrador> COMPARATOR;
    private ObservableList<Administrador> listaAdministradores;   
    private static AccesoDatosAdministrador INSTANCE;
     private AccesoDatosAdministrador(){         
         listaAdministradores= FXCollections.observableArrayList();
         COMPARATOR= new Comparator<Administrador>() {
             @Override
             public int compare(Administrador o1, Administrador o2) {
                 return o1.getCedulaOPassaporte().compareTo(o2.getCedulaOPassaporte());
             }
         };
     }
     
     public static AccesoDatosAdministrador getInstance(){
         if (INSTANCE==null) 
             INSTANCE=new AccesoDatosAdministrador();
         return INSTANCE;
     }
       
    public void insertar(Administrador c) {
        listaAdministradores.add(c);
        listaAdministradores.sort(COMPARATOR);
        
    }
    public void modificar(Administrador c) {
        int aux=listaAdministradores.indexOf(get(c.getCedulaOPassaporte()));
        listaAdministradores.remove(aux);
        listaAdministradores.add(aux, c);
        
    }
    
    public void eliminar(Object o) {
        if (o instanceof Administrador) 
            listaAdministradores.remove((Administrador)o);
        else if (o instanceof String) {
            listaAdministradores.remove(get(o));
        }            
    }    
    public Administrador get(Object o) {    
    int pisition=buscar(o);
        if (listaAdministradores.isEmpty()||pisition<0) 
            return null;
        else          
            return listaAdministradores.get(pisition);
    }
    private int buscar(Object o) {                        
        return Collections.binarySearch(listaAdministradores, new Administrador(o.toString(), null, null, null, null, null, null, null), COMPARATOR);
    }
    private List<Administrador> buscar(Object nombre,Object cedula) {                        
        if (nombre==null&&cedula==null)
            return listaAdministradores;        
        else if (nombre!=null&&cedula==null)
            return listaAdministradores.stream().filter(x->x.getNombre().equals(nombre.toString())).collect(Collectors.toList());
        else if (nombre==null&&cedula!=null)
            return listaAdministradores.stream().filter(x->x.getCedulaOPassaporte().equals(cedula)).collect(Collectors.toList());
        else if (nombre!=null&&cedula!=null)
            return listaAdministradores.stream().filter(x->x.getCedulaOPassaporte().equals(cedula)&&x.getNombre().equals(nombre.toString())).collect(Collectors.toList());
        else return listaAdministradores;
    }
    public ObservableList<Administrador> getAll() {
        return listaAdministradores;
    }
    public void setAdministradores(ArrayList<Administrador> list) {
        listaAdministradores.addAll(list);
    }
}
