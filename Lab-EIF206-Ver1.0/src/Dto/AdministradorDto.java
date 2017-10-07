/**
 * Programmer: Eddy Valverde Garro
 * Version - 1.0
 * Last Modification: 14/08/17 19:00;
 */
package Dto;

import LogicaDeNegocio.*;
import java.io.Serializable;
import java.time.LocalDate;


/**
 *
 * @author edva5
 */
public class AdministradorDto extends PersonaDto implements Serializable{    
    
    public AdministradorDto(Administrador a) {        
        super(a);
    }
    
}
