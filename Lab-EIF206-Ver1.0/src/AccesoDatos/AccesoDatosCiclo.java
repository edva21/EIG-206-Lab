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
    private static AccesoDatosCiclo instance;
     private ArrayList<Ciclo> listaCiclos;    
    static Comparator<Ciclo> CicloCOMPARATOR;

    private AccesoDatosCiclo() {
    }
    public static AccesoDatosCiclo getInstance(){
        if (instance==null)
            instance= new AccesoDatosCiclo();
        return instance;
    }
    
    public void insertar(Ciclo c) {
        listaCiclos.add(c);        
    }
    public void modificar(Ciclo c) {
        eliminar(c);
        insertar(c);
    }
    
    public void eliminar(Ciclo c) {
        
    }    
    public Ciclo get(Object o) {
        return null;
    }
    
    public List<Ciclo> getAll() {
        return listaCiclos;
    }         
    public List<Ciclo> getAll(Object o) {
        return null;
    }
}
