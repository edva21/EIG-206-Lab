/**
 * Programmer: Eddy Valverde Garro
 * Version - 1.0
 * Last Modification: 14/08/17 19:00;
 */
package LogicaDeNegocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author edva5
 */
public class Estudiante extends Persona {
  private ArrayList<Grupo> grupos;
    private ArrayList<Nota> notas;
    private Carrera carrera;
    public Estudiante() {        
        super();
    }

    public Estudiante(Carrera carrera, String cedula_o_passaporte, String nombre, String Apellido1, String Apellido2, String telefono, String email, String clave, LocalDate fecaNacimiento) {
        super(cedula_o_passaporte, nombre, Apellido1, Apellido2, telefono, email, clave, fecaNacimiento);
        this.grupos = grupos;
        this.notas = notas;
        this.carrera = carrera;
    }

    public Estudiante(ArrayList<Grupo> grupos, ArrayList<Nota> notas, Carrera carrera) {
        this.grupos = grupos;
        this.notas = notas;
        this.carrera = carrera;
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
     * @return the carrera
     */
    public Carrera getCarrera() {
        return carrera;
    }

    /**
     * @param carrera the carrera to set
     */
    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
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
    
}
