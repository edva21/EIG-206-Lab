/**
 * Programmer: Eddy Valverde Garro
 * Version - 1.0
 * Last Modification: 14/08/17 19:00;
 */
package LogicaDeNegocio;

import Dto.EstudianteDto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author edva5
 */
public class Estudiante extends Persona{

  private ArrayList<Grupo> grupos;
    private ArrayList<Nota> notas;
    private ArrayList<Carrera> carreras;    

    public Estudiante(String cedulaOPassaporte) {
        this.cedulaOPassaporte=cedulaOPassaporte;
    }
    
    public Estudiante(EstudianteDto e) {
        super(e);     
        grupos = new ArrayList<Grupo>();
        e.getGrupos().forEach(x->grupos.add(new Grupo(x)));
        notas = new ArrayList<Nota>();
        e.getNotas().stream().forEach(x->notas.add(new Nota(x)));
        carreras = new ArrayList<Carrera>();
        e.getCarreras().stream().forEach(x->carreras.add(new Carrera(x)));
    }
    public Estudiante(String cedula_o_passaporte, String nombre, String Apellido1, String Apellido2, String telefono, String email, String clave, LocalDate fecaNacimiento) {
        super(cedula_o_passaporte, nombre, Apellido1, Apellido2, telefono, email, clave, fecaNacimiento);
     
    }
    
    public Estudiante(Carrera carrera, String cedula_o_passaporte, String nombre, String Apellido1, String Apellido2, String telefono, String email, String clave, LocalDate fecaNacimiento) {
        super(cedula_o_passaporte, nombre, Apellido1, Apellido2, telefono, email, clave, fecaNacimiento);        
        carreras = new ArrayList<Carrera>();
        carreras.add(carrera);
        grupos = new ArrayList<Grupo>();
        notas = new ArrayList<Nota>();
    }

   
 
 
    /**
     * @return the notas
     */
    public ArrayList<Nota> getNotas() {
        return notas;
    }

    /**
     * @param notas the notas to set
     */
    public void setNotas(ArrayList<Nota> notas) {
        this.notas = notas;
    }


    /**
     * @return the grupos
     */
    public ArrayList<Grupo> getGrupos() {
        return grupos;
    }

    /**
     * @param grupos the grupos to set
     */
    public void setGrupos(ArrayList<Grupo> grupos) {
        this.grupos = grupos;
    }       
    
    /**
     * @return the carreras
     */
    public ArrayList<Carrera> getCarreras() {
        return carreras;
    }

    /**
     * @param carreras the carreras to set
     */
    public void setCarreras(ArrayList<Carrera> carreras) {
        this.carreras = carreras;
    }
}
