/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import LogicaDeNegocio.Matriculador;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author edva5
 */
public class AccesoDatosMatriculador {
    private static AccesoDatosMatriculador instance;
     private ArrayList<Matriculador> listaMatriculadores;    
    static Comparator<Matriculador> MatriculadorCOMPARATOR;

    private AccesoDatosMatriculador() {
    }
    public static AccesoDatosMatriculador getInstance(){
        if (instance==null)
            instance= new AccesoDatosMatriculador();
        return instance;
    }
    public void insertar(Matriculador c) {
        listaMatriculadores.add(c);        
    }
    public void modificar(Matriculador c) {
        eliminar(c);
        insertar(c);
    }
    
    public void eliminar(Matriculador c) {
        
    }    
    public Matriculador get(Object o) {
        return null;
    }
    
    public List<Matriculador> getAll() {
        return listaMatriculadores;
    }
    public List<Matriculador> getAll(Object o) {
        return null;
    }
}
