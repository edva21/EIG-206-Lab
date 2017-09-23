/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import LogicaDeNegocio.Administrador;
import LogicaDeNegocio.Carrera;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author edva5
 */
public class AccesoDatosCarrera {
    private static AccesoDatosCarrera instance;
    private ArrayList<Carrera> listaCarreras;    
    static Comparator<Carrera> CarreraCOMPARATOR;

    private AccesoDatosCarrera() {
    }
    
    public void insertar(Carrera c) {
        listaCarreras.add(c);
        
    }
    /**
     * @return the instance
     */
    public static AccesoDatosCarrera getInstance() {
        if (instance==null) 
            instance = new AccesoDatosCarrera();
        return instance;
    }
    
    public void modificar(Carrera c) {
        eliminar(c);
        insertar(c);
    }
    
    public void eliminar(Carrera c) {
        
    }    
    public Administrador getCarrera(Object o) {
        return null;
    }
    
    public List<Carrera> getAllCarreras() {
        return listaCarreras;
    }                
}
