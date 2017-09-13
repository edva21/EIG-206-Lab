/*
 * Programmer: Eddy Valverde Garro
 * Version - 1.0
 * Last Modification: 24/08/17 15:00;
 */
package AccesoDatos;


import LogicaDeNegocio.Ciclo;
import Obligacion.Obligation;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author edva5
 */
public class AccesoDatoCiclo implements Obligation<Ciclo>{
private ArrayList<Ciclo> aDC;   

    @Override
    public void insertar(Ciclo c) {
        this.aDC.add(c);
    }

    @Override
    public void modificar(Ciclo c) {        
    eliminar(get(c.getCodigo()));
    insertar(c);
    }

    @Override
    public void eliminar(Ciclo c) {
        aDC.remove(c);
    }

    @Override
    public Ciclo get(Object o) {
        try{
            List<Ciclo> cl = aDC.stream().filter(x->x.getCodigo().equals(o.toString())).collect(Collectors.toList());
            if (cl.size()==1)
                return cl.get(0);
            else
                return null;
        }catch(Exception ex){
            return null;
        }        
    }

    @Override
    public List<Ciclo> getAll() {
        return aDC;
    }
    
}
