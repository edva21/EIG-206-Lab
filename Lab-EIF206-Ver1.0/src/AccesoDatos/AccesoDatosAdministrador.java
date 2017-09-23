/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import LogicaDeNegocio.Administrador;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import sun.security.jca.GetInstance;

/**
 *
 * @author edva5
 */
public class AccesoDatosAdministrador {
    static Comparator<Administrador> AdministradorCOMPARATOR;
    private ArrayList<Administrador> listaAdministradores;   
    private static AccesoDatosAdministrador INSTANCE;
     private AccesoDatosAdministrador(){         
         listaAdministradores= new ArrayList<Administrador>();
         AdministradorCOMPARATOR= new Comparator<Administrador>() {
             @Override
             public int compare(Administrador o1, Administrador o2) {
                 return Integer.valueOf(o1.getCedula_o_passaporte()).compareTo(Integer.valueOf(o2.getCedula_o_passaporte()));
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
        
    }
    public void modificar(Administrador c) {
        eliminar(c);
        insertar(c);
    }
    
    public void eliminar(Administrador c) {
        
    }    
    public Administrador get(Object o) {
        return null;
    }
    
    public List<Administrador> getAll() {
        return listaAdministradores;
    }            
}
