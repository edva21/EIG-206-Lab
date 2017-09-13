/*
 * Programmer: Eddy Valverde Garro
 * Version - 1.0
 * Last Modification: 24/08/17 15:00;
 */
package AccesoDatos;


import LogicaDeNegocio.Grupo;
import Obligacion.Obligation;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author edva5
 */
public class AccesoDatoGrupo implements Obligation<Grupo>{
private ArrayList<Grupo> aDC;      

    @Override
    public void insertar(Grupo c) {
        this.aDC.add(c);
    }

    @Override
    public void modificar(Grupo c) {        
    eliminar(get(c.getId()));
    insertar(c);
    }

    @Override
    public void eliminar(Grupo c) {
        aDC.remove(c);
    }

    @Override
    public Grupo get(Object o) {
        try{
            List<Grupo> cl = aDC.stream().filter(x->x.getId().equals(o.toString())).collect(Collectors.toList());
            if (cl.size()==1)
                return cl.get(0);
            else
                return null;
        }catch(Exception ex){
            return null;
        }
        
    }

    @Override
    public List<Grupo> getAll() {
        return aDC;
    }
    
    
}
