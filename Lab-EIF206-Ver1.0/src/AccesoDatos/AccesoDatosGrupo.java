/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import LogicaDeNegocio.Curso;
import LogicaDeNegocio.Grupo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import sun.security.jca.GetInstance;

/**
 *
 * @author edva5
 */
public class AccesoDatosGrupo {
    private static AccesoDatosGrupo instance;
     private ArrayList<Grupo> listaGrupos;    
    static Comparator<Grupo> GrupoCOMPARATOR;

    private AccesoDatosGrupo() {
    }
       
    public static AccesoDatosGrupo GetInstance(){
        if (instance==null) 
            instance= new AccesoDatosGrupo();
        return instance;
    }
    public void insertar(Grupo c) {
        listaGrupos.add(c);
        
    }
    public void modificar(Grupo c) {
        eliminar(c);
        insertar(c);
    }
    
    public void eliminar(Grupo c) {
        
    }    
    public Grupo get(Object o) {
        return null;
    }
    
    public List<Grupo> getAll() {
        return listaGrupos;
    }
    public List<Grupo> getAll(Object o) {
        return null;
    }
}
