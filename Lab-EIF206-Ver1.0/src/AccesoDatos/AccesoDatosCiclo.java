/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import LogicaDeNegocio.Administrador;
import LogicaDeNegocio.Ciclo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author edva5
 */
public class AccesoDatosCiclo {
     private ArrayList<Ciclo> listaCiclos;    
    static Comparator<Ciclo> CicloCOMPARATOR;
    public void insertar(Ciclo c) {
        listaCiclos.add(c);        
    }
    public void modificar(Ciclo c) {
        eliminar(c);
        insertar(c);
    }
    
    public void eliminar(Ciclo c) {
        
    }    
    public Administrador getCiclo(Object o) {
        return null;
    }
    
    public List<Ciclo> getAllCiclos() {
        return listaCiclos;
    }                
}
