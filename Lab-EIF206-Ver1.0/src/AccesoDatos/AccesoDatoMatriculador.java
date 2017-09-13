/*
 * Programmer: Eddy Valverde Garro
 * Version - 1.0
 * Last Modification: 24/08/17 15:00;
 */
package AccesoDatos;

import LogicaDeNegocio.Matriculador;
import Obligacion.Obligation;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author edva5
 */
public class AccesoDatoMatriculador implements Obligation<Matriculador>{
List<Matriculador> aDE;
    @Override
    public void insertar(Matriculador c) {
        aDE.add(c);
    }
    @Override
    public void modificar(Matriculador c) {
        eliminar(get(c.getCedula_o_passaporte()));
        insertar(c);
    }

    @Override
    public void eliminar(Matriculador c) {
        aDE.remove(c);        
    }

    @Override
    public Matriculador get(Object o) {
        try{
            List<Matriculador> e=aDE.stream().filter(x->x.getCedula_o_passaporte()==o.toString()).collect(Collectors.toList());
        if (e.size()==1)
            return e.get(0);
        }catch(Exception ex){
            return null;
        }
        return null;
    }

    @Override
    public List<Matriculador> getAll() {
        return aDE;
    }
    
}
