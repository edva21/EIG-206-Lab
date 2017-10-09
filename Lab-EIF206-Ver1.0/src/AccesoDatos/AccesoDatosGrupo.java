/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Dto.GrupoDto;
import LogicaDeNegocio.Curso;
import LogicaDeNegocio.Grupo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sun.security.jca.GetInstance;

/**
 *
 * @author edva5
 */
public class AccesoDatosGrupo {
private static AccesoDatosGrupo INSTANCE;
    private Comparator<Grupo> COMPARATOR;
    private ObservableList<Grupo> listaGrupoes;       
     private AccesoDatosGrupo(){         
         listaGrupoes= FXCollections.observableArrayList();
         COMPARATOR= new Comparator<Grupo>() {
             @Override
             public int compare(Grupo o1, Grupo o2) {
                 return o1.getId().compareTo(o2.getId());
             }
         };
     }
     
     public static AccesoDatosGrupo getInstance(){
         if (INSTANCE==null) 
             INSTANCE=new AccesoDatosGrupo();
         return INSTANCE;
     }
       
    public void insertar(Grupo c) {
        listaGrupoes.add(c);
        listaGrupoes.sort(COMPARATOR);
        
    }
    public void modificar(Grupo c) {
        int aux=listaGrupoes.indexOf(get(c.getId()));
        listaGrupoes.remove(aux);
        listaGrupoes.add(aux, c);
        
    }
    
    public void eliminar(Object o) {
        if (o instanceof Grupo) 
            listaGrupoes.remove((Grupo)o);
        else if (o instanceof String) {
            listaGrupoes.remove(get(o));
        }            
    }    
    public Grupo get(Object o) {    
    int pisition=buscar(o);
        if (listaGrupoes.isEmpty()||pisition<0) 
            return null;
        else          
            return listaGrupoes.get(pisition);
    }
    private int buscar(Object o) {                        
        return Collections.binarySearch(listaGrupoes, new Grupo(o.toString()), COMPARATOR);
    }    
    public ObservableList<Grupo> getAll() {
        return listaGrupoes;
    }
    /*public void setGrupoes(ArrayList<Grupo> list) {
        listaGrupoes.addAll(list);
    }*/

    /**
     *
     * @param list
     */
    public void setGrupoesDto(ArrayList<GrupoDto> list) {
        listaGrupoes.clear();
        if (!list.isEmpty()) {
            list.stream().forEach(x->insertar(new Grupo(x)));
        }
        
    }
}