/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import LogicaDeNegocio.Nota;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author edva5
 */
public class AccesoDatosNota {
    private static AccesoDatosNota instance;
    private ArrayList<Nota> listaNotas;    
    static Comparator<Nota> NotaCOMPARATOR;

    private AccesoDatosNota() {
    }
    public static AccesoDatosNota getInstance(){
        if (instance==null)
            instance = new AccesoDatosNota();
        return instance;
    }
    public void insertar(Nota c) {
        listaNotas.add(c);
        
    }
    public void modificar(Nota c) {
        eliminar(c);
        insertar(c);
    }
    
    public void eliminar(Nota c) {
        
    }    
    public Nota get(Object o) {
        return null;
    }
    
    public List<Nota> getAll() {
        return listaNotas;
    }
    public List<Nota> getAll(Object o) {
        return null;
    }
}
