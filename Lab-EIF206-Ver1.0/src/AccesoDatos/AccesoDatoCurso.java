/*
 * Programmer: Eddy Valverde Garro
 * Version - 1.0
 * Last Modification: 24/08/17 15:00;
 */
package AccesoDatos;

import LogicaDeNegocio.Curso;
import Obligacion.Obligation;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author edva5
 */
public class AccesoDatoCurso implements Obligation<Curso>{
private ArrayList<Curso> aDC;   

    @Override
    public void insertar(Curso c) {
        this.aDC.add(c);
    }

    @Override
    public void modificar(Curso c) {        
    eliminar(get(c.getCodigo()));
    insertar(c);
    }

    @Override
    public void eliminar(Curso c) {
        aDC.remove(c);
    }

    @Override
    public Curso get(Object o) {
        try{
            List<Curso> cl = aDC.stream().filter(x->x.getCodigo().equals(o.toString())).collect(Collectors.toList());
            if (cl.size()==1)
                return cl.get(0);
            else
                return null;
        }catch(Exception ex){
            return null;
        }        
    }

    @Override
    public List<Curso> getAll() {
        return aDC;
    }
    
    
}
