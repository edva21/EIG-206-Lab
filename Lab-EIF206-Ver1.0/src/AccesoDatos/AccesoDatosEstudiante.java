/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import LogicaDeNegocio.Carrera;
import LogicaDeNegocio.Estudiante;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author edva5
 */
public class AccesoDatosEstudiante {
    private static AccesoDatosEstudiante instance;
    private static Comparator<Estudiante> comparatorNombre,comparatoCarrera;
    private HashMap<String, Estudiante> Cedula = new HashMap<String, Estudiante>();
    private Predicate<Estudiante> nombrePrdct;
    private List<Estudiante> listaEstudiantes;

    private AccesoDatosEstudiante() {
        comparatorNombre = new Comparator<Estudiante>() {
            @Override
            public int compare(Estudiante o1, Estudiante o2) {
                if (o1.getApellido1().compareTo(o2.getApellido1())==0){
                  if(o1.getApellido2().compareTo(o2.getApellido2())==0){
                      return o1.getNombre().compareTo(o2.getNombre());
                  }
                  else return o1.getApellido2().compareTo(o2.getApellido2());
                }
                else return o1.getApellido1().compareTo(o2.getApellido1());
            }
                       
        };
        comparatoCarrera = new Comparator<Estudiante>() {
            @Override
            public int compare(Estudiante o1, Estudiante o2) {
                return o1.getCarrera().getCodigo().compareTo(o2.getCarrera().getCodigo());
            }
        };        
    }
    public static AccesoDatosEstudiante getInstance(){
        if (instance==null)
            instance=new AccesoDatosEstudiante();
        return instance;
    }    
    public void insertar(Estudiante c) {
        listaEstudiantes.add(c);
        Collections.sort(listaEstudiantes);
    }
    public void modificar(Estudiante c, int post) {
       listaEstudiantes.add(post, c);
       }
    public void eliminar(Estudiante c) {
        listaEstudiantes.remove(c);        
    }
    
    public Estudiante get(int x) {
        return listaEstudiantes.get(x);
    }

    
   
    public List<Estudiante> buscar(String nombre,Carrera carrera, String id){
        if(nombre!= null && carrera== null && id== null){
            return listaEstudiantes.stream().filter(x->x.getNombre().equals(nombre)).collect(Collectors.toList());
        }
        if(nombre!= null && carrera!= null && id== null){
            return listaEstudiantes.stream().filter(x->x.getNombre().equals(nombre)&& x.getCarrera().getCodigo().equals(carrera.getCodigo())).collect(Collectors.toList());
        }
        if(nombre!= null && carrera!= null && id!= null){
            return listaEstudiantes.stream().filter(
            x->x.getNombre().equals(nombre)&& 
            x.getCarrera().getCodigo().equals(carrera.getCodigo())
            && x.getCedulaOPassaporte().equals(id)).collect(Collectors.toList());
        }
        if(nombre== null && carrera!= null && id== null){
            return listaEstudiantes.stream().filter(x->x.getCarrera().equals(carrera.getCodigo())).collect(Collectors.toList());
        }
        if(nombre== null && carrera!= null && id!= null){
           return listaEstudiantes.stream().filter(x->x.getCarrera().getCodigo().equals(carrera.getCodigo())
            && x.getCedulaOPassaporte().equals(id)).collect(Collectors.toList());
        }
         if(nombre== null && carrera== null && id!= null){
           return listaEstudiantes.stream().filter(x->x.getCedulaOPassaporte().equals(id)).collect(Collectors.toList());
        }
        return listaEstudiantes;  
    }
    public int buscar(Estudiante cedula){
        return Collections.binarySearch(listaEstudiantes,cedula);
        //Collections.
        
    }
    private static Predicate<Estudiante> nameEqualsTo(String name){
        return x->x.getNombre().equals(name);
    }
}
