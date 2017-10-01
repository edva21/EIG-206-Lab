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
import sun.security.jca.GetInstance;

/**
 *
 * @author edva5
 */
public class AccesoDatosAdministrador {
    private Comparator<Administrador> COMPARATOR;
    private ArrayList<Administrador> listaAdministradores;   
    private static AccesoDatosAdministrador INSTANCE;
     private AccesoDatosAdministrador(){         
         listaAdministradores= new ArrayList<Administrador>();
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
        eliminar(c);
        insertar(c);
    }
    
    public void eliminar(Administrador c) {
        
    }    
    public Administrador get(Object o) {
        return listaAdministradores.get(Collections.binarySearch(listaAdministradores, new Administrador(o.toString(), null, null, null, null, null, null, null), COMPARATOR));
    }
    
    public List<Administrador> getAll() {
        return listaAdministradores;
    }         
    public List<Administrador> getAll(Object o) {
        return null;
    }
}
