/*
 * Programmer: Eddy Valverde Garro
 * Version - 1.0
 * Last Modification: 24/08/17 15:00;
 */
package AccesoDatos;

import LogicaDeNegocio.Estudiante;
import java.util.ArrayList;
import java.util.Optional;
import Obligacion.Obligation;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author edva5
 */
public class AccesoDatoEstudiante implements Obligation<Estudiante> {//un wrapper por cada funcionlidad
    List<Estudiante> aDE;
    @Override
    public void insertar(Estudiante c) {
        aDE.add(c);
    }
    @Override
    public void modificar(Estudiante c) {
        eliminar(get(c.getCedula_o_passaporte()));
        insertar(c);
    }

    @Override
    public void eliminar(Estudiante c) {
        aDE.remove(c);        
    }

    @Override
    public Estudiante get(Object o) {
        try{
            List<Estudiante> e=aDE.stream().filter(x->x.getCedula_o_passaporte()==o.toString()).collect(Collectors.toList());
        if (e.size()==1)
            return e.get(0);
        }catch(Exception ex){
            return null;
        }
        return null;
    }

    @Override
    public List<Estudiante> getAll() {
        return aDE;
    }
    
}
