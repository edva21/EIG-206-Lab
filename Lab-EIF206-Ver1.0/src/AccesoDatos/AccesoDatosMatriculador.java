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
     private ArrayList<Matriculador> listaMatriculadores;    
    static Comparator<Matriculador> MatriculadorCOMPARATOR;
    public void insertar(Matriculador c) {
        listaMatriculadores.add(c);        
    }
    public void modificar(Matriculador c) {
        eliminar(c);
        insertar(c);
    }
    
    public void eliminar(Matriculador c) {
        
    }    
    public Matriculador getMatriculador(Object o) {
        return null;
    }
    
    public List<Matriculador> getAllMatriculadores() {
        return listaMatriculadores;
    }
}
