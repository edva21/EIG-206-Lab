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
public class Profesor extends Persona{
    private ArrayList<Grupo> grupos;
    public Profesor() {        
        super();
    }

    public Profesor(ArrayList<Grupo> grupos, String cedula_o_passaporte, String nombre, String Apellido1, String Apellido2, String telefono, String email, String clave, LocalDate fecaNacimiento) {
        super(cedula_o_passaporte, nombre, Apellido1, Apellido2, telefono, email, clave, fecaNacimiento);
        this.grupos = grupos;
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
