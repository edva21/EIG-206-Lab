/*
 * Programmer: Eddy Valverde Garro
 * Version - 1.0
 * Last Modification: 24/08/17 15:00;
 */
package AccesoDatos;

import LogicaDeNegocio.Nota;
import Obligacion.Obligation;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author edva5
 */
public class AccesoDatoNota implements Obligation<Nota>{
private ArrayList<Nota> aDC;      

    @Override
    public void insertar(Nota c) {
        this.aDC.add(c);
    }

    @Override
    public void modificar(Nota c) {        
    eliminar(get(c.getId()));
    insertar(c);
    }

    @Override
    public void eliminar(Nota c) {
        aDC.remove(c);
    }

    @Override
    public Nota get(Object o) {
        try{
            List<Nota> cl = aDC.stream().filter(x->x.getId().equals(o.toString())).collect(Collectors.toList());
            if (cl.size()==1)
                return cl.get(0);
            else
                return null;
        }catch(Exception ex){
            return null;
        }        
    }

    @Override
    public List<Nota> getAll() {
        return aDC;
    }
    
}
