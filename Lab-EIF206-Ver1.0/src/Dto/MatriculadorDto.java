/**
 * Programmer: Eddy Valverde Garro
 * Version - 1.0
 * Last Modification: 14/08/17 19:00;
 */
package Dto;

import LogicaDeNegocio.*;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author edva5
 */
public class MatriculadorDto extends PersonaDto {       

    public MatriculadorDto() {
    }
    public MatriculadorDto(Matriculador matriculador) {
        super(matriculador);//super(cedula_o_passaporte, nombre, Apellido1, Apellido2, telefono, email, clave, fecaNacimiento);
    }
}
