/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;


import Dto.CicloDto;
import LogicaDeNegocio.Ciclo;
import java.time.LocalDate;
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
public class AccesoDatosCiclo {
private static AccesoDatosCiclo INSTANCE;
    private Comparator<Ciclo> COMPARATOR;
    private ObservableList<Ciclo> listaCicloes;       
     private AccesoDatosCiclo(){         
         listaCicloes= FXCollections.observableArrayList();
         COMPARATOR= new Comparator<Ciclo>() {
             @Override
             public int compare(Ciclo o1, Ciclo o2) {
                 return o1.getCodigo().compareTo(o2.getCodigo());
             }
         };
     }
     
     public static AccesoDatosCiclo getInstance(){
         if (INSTANCE==null) 
             INSTANCE=new AccesoDatosCiclo();
         return INSTANCE;
     }
       
    public void insertar(Ciclo c) {
        listaCicloes.add(c);
        listaCicloes.sort(COMPARATOR);
        
    }
    public void modificar(Ciclo c) {
        int aux=listaCicloes.indexOf(get(c.getCodigo()));
        listaCicloes.remove(aux);
        listaCicloes.add(aux, c);
        
    }
    
    public void eliminar(Object o) {
        if (o instanceof Ciclo) 
            listaCicloes.remove((Ciclo)o);
        else if (o instanceof String) {
            listaCicloes.remove(get(o));
        }            
    }    
    public Ciclo get(Object o) {    
    int pisition=buscar(o);
        if (listaCicloes.isEmpty()||pisition<0) 
            return null;
        else          
            return listaCicloes.get(pisition);
    }
    private int buscar(Object o) {                        
        if (listaCicloes.size()>999)
            return Collections.binarySearch(listaCicloes, new Ciclo(o.toString()), COMPARATOR);
        else{
            for (Ciclo c:listaCicloes) {
                if (c.getCodigo().equals(o.toString()))
                    return listaCicloes.indexOf(o.toString());
            }
            return -1;
        }
        
    }    
    public ObservableList<Ciclo> getAll() {
        return listaCicloes;
    }
    /*public void setCicloes(ArrayList<Ciclo> list) {
        listaCicloes.addAll(list);
    }*/

    /**
     *
     * @param list
     */
    public void setCicloesDto(ArrayList<CicloDto> list) {
        listaCicloes.clear();
        if (!list.isEmpty()) {
            list.stream().forEach(x->insertar(new Ciclo(x)));
        }
        
    }
}