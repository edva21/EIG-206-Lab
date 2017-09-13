/*
 * Programmer: Eddy Valverde Garro
 * Version - 1.0
 * Last Modification: 24/08/17 15:00;
 */
package AccesoDatos;

import LogicaDeNegocio.Carrera;
import Obligacion.Obligation;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author edva5
 */
public class AccesoDatoCarrera implements Obligation<Carrera>{
private ArrayList<Carrera> aDC;   

    @Override
    public void insertar(Carrera c) {
        this.aDC.add(c);
    }

    @Override
    public void modificar(Carrera c) {        
    eliminar(get(c.getCodigo()));
    insertar(c);
    }

    @Override
    public void eliminar(Carrera c) {
        aDC.remove(c);
    }

    @Override
    public Carrera get(Object o) {
        try{
            List<Carrera> cl = aDC.stream().filter(x->x.getCodigo().equals(o.toString())).collect(Collectors.toList());
            if (cl.size()==1)
                return cl.get(0);
            else
                return null;
        }catch(Exception ex){
            return null;
        }
        
    }

    @Override
    public List<Carrera> getAll() {
        return aDC;
    }
    
}
