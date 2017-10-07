/**
 * Programmer: Eddy Valverde Garro
 * Version - 1.0
 * Last Modification: 14/08/17 19:00;
 */
package LogicaDeNegocio;

import Dto.AdministradorDto;
import java.io.Serializable;
import java.time.LocalDate;


/**
 *
 * @author edva5
 */
public class Administrador extends Persona implements Serializable{    
    public Administrador() {        
        super();
    }
    public Administrador(AdministradorDto a) {        
        super(a);
    }
    public Administrador(Administrador a) {        
        super(a.getCedulaOPassaporte(),a.getNombre(),a.getApellido1(),a.getApellido2(),a.getTelefono(),a.getEmail(),a.getClave(),a.getFechaNacimiento());
    }
    public Administrador(String cedula_o_passaporte, String nombre, String Apellido1, String Apellido2, String telefono, String email, String clave, LocalDate fecaNacimiento) {
        super(cedula_o_passaporte, nombre, Apellido1, Apellido2, telefono, email, clave, fecaNacimiento);
    }
}
