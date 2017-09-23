/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import LogicaDeNegocio.Estudiante;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author edva5
 */
public class AccesoDatosEstudiante {
    static Comparator<Estudiante> EstudianteCOMPARATOR;
    private List<Estudiante> listaEstudiantes;
        
    public void insertar(Estudiante c) {
        listaEstudiantes.add(c);       
        listaEstudiantes.sort(EstudianteCOMPARATOR);
    }
    public void modificar(Estudiante c) {
        //eliminar(get(c.getCedula_o_passaporte()));
        insertar(c);
    }
    
    public void eliminar(Estudiante c) {
        listaEstudiantes.remove(c);        
    }
    
    public Estudiante getEstudiante(Object o) {
        return get(o,listaEstudiantes.size()/2);
    }
   
    private Estudiante get(Object o,int i){
        if (comparator(o, listaEstudiantes.get(i))==0)
            return listaEstudiantes.get(i);
        else if (comparator(o, listaEstudiantes.get(i))==-1)
            return get(o,i/2);
        else
            return get(o,i+i/2);
    }
    
    public List<Estudiante> getAllEstudiantes() {
        return listaEstudiantes;
    }
    private int comparator(Object o,Estudiante e){
        int smallerSize;
        if (o.toString().length()>e.getCedula_o_passaporte().length())
            smallerSize=e.getCedula_o_passaporte().length();        
        else 
            smallerSize=o.toString().length();
        for (int i = 0; i < smallerSize; i++) {            
                if (o.toString().charAt(i)>e.getCedula_o_passaporte().charAt(i))
                    return 1;
                else if (o.toString().charAt(i)<e.getCedula_o_passaporte().charAt(i)) 
                    return -1;
        }
        if (o.toString().length()==e.getCedula_o_passaporte().length()) {
            return 0;
        }
        else if (o.toString().length()>e.getCedula_o_passaporte().length())
            return 1;        
        else
            return -1;
    }
}
