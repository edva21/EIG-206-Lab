/*
 * Programmer: Eddy Valverde Garro
 * Version - 1.0
 * Last Modification: 24/08/17 15:00;
 */
package AccesoDatos;
import LogicaDeNegocio.Administrador;
import Obligacion.Obligation;
import java.util.ArrayList;  
import java.util.List;  
import java.util.Observable;
import java.util.stream.Collectors;

/**
 *
 * @author edva5
 */
                        //Binary Search, sort Listas
public class AccesoDatoAdministrador extends Observable implements Obligation<Administrador>{
   private ArrayList<Administrador> aDE;

    public AccesoDatoAdministrador() {
        aDE = new ArrayList<>();
    }
   
    @Override
    public void insertar(Administrador c) {
        aDE.add(c);
        
    }
    @Override
    public void modificar(Administrador c) {
        eliminar(c);
        insertar(c);
    }

    @Override
    public void eliminar(Administrador c) {
        try{
            List<Administrador> e=aDE.stream().filter(x->x.getCedula_o_passaporte()==c.getCedula_o_passaporte()).collect(Collectors.toList());            
        if (e.size()==1)
            aDE.remove(e.get(0));        
        }catch(Exception ex){
            
        }        
    }

    @Override
    public Administrador get(Object o) {
        try{
            List<Administrador> e=aDE.stream().filter(x->x.getCedula_o_passaporte()==o.toString()).collect(Collectors.toList());
        if (e.size()==1)
            return e.get(0);
        }catch(Exception ex){
            return null;
        }
        return null;
    }

    @Override
    public List<Administrador> getAll() {
        return aDE;
    }
    @Override
    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers(true); // parametro no usado por ahora
    }
}


