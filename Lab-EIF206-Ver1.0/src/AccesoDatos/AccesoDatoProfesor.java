/*
 * Programmer: Eddy Valverde Garro
 * Version - 1.0
 * Last Modification: 24/08/17 15:00;
 */
package AccesoDatos;

import LogicaDeNegocio.Profesor;
import Obligacion.Obligation;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author edva5
 */
public class AccesoDatoProfesor implements Obligation<Profesor>{
private ArrayList<Profesor> aDC;   

   List<Profesor> aDE;
    @Override
    public void insertar(Profesor c) {
        aDE.add(c);
    }
    @Override
    public void modificar(Profesor c) {
        eliminar(get(c.getCedula_o_passaporte()));
        insertar(c);
    }

    @Override
    public void eliminar(Profesor c) {
        aDE.remove(c);        
    }

    @Override
    public Profesor get(Object o) {
        try{
            List<Profesor> e=aDE.stream().filter(x->x.getCedula_o_passaporte()==o.toString()).collect(Collectors.toList());
        if (e.size()==1)
            return e.get(0);
        }catch(Exception ex){
            return null;
        }
        return null;
    }

    @Override
    public List<Profesor> getAll() {
        return aDE;
    }
    
    
}
