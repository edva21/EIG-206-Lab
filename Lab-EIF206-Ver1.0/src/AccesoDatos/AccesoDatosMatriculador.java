/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Dto.MatriculadorDto;
import LogicaDeNegocio.Matriculador;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author edva5
 */
public class AccesoDatosMatriculador {
private static AccesoDatosMatriculador INSTANCE;
    private Comparator<Matriculador> COMPARATOR;
    private ObservableList<Matriculador> listaMatriculadores;       
     private AccesoDatosMatriculador(){         
         listaMatriculadores= FXCollections.observableArrayList();
         COMPARATOR= new Comparator<Matriculador>() {
             @Override
             public int compare(Matriculador o1, Matriculador o2) {
                 return o1.getCedulaOPassaporte().compareTo(o2.getCedulaOPassaporte());
             }
         };
     }
     
     public static AccesoDatosMatriculador getInstance(){
         if (INSTANCE==null) 
             INSTANCE=new AccesoDatosMatriculador();
         return INSTANCE;
     }
       
    public void insertar(Matriculador c) {
        listaMatriculadores.add(c);
        listaMatriculadores.sort(COMPARATOR);
        
    }
    public void modificar(Matriculador c) {
        int aux=listaMatriculadores.indexOf(get(c.getCedulaOPassaporte()));
        listaMatriculadores.remove(aux);
        listaMatriculadores.add(aux, c);
        
    }
    
    public void eliminar(Object o) {
        if (o instanceof Matriculador) 
            listaMatriculadores.remove((Matriculador)o);
        else if (o instanceof String) {
            listaMatriculadores.remove(get(o));
        }            
    }    
    public Matriculador get(Object o) {    
    int pisition=buscar(o);
        if (listaMatriculadores.isEmpty()||pisition<0) 
            return null;
        else          
            return listaMatriculadores.get(pisition);
    }
    private int buscar(Object o) {                        
         if (listaMatriculadores.size()>999)
            return Collections.binarySearch(listaMatriculadores, new Matriculador(o.toString()), COMPARATOR);
        else{
            for(Matriculador m:listaMatriculadores){
                if (m.getCedulaOPassaporte().equals(o.toString())) 
                    return listaMatriculadores.indexOf(m);
            }
            return -1;
        }        
    }    
    public ObservableList<Matriculador> getAll() {
        return listaMatriculadores;
    }
    /*public void setMatriculadores(ArrayList<Matriculador> list) {
        listaMatriculadores.addAll(list);
    }*/

    /**
     *
     * @param list
     */
    public void setMatriculadoresDto(ArrayList<MatriculadorDto> list) {
        listaMatriculadores.clear();
        if (!list.isEmpty()) {
            list.stream().forEach(x->insertar(new Matriculador(x)));
        }
        
    }
}