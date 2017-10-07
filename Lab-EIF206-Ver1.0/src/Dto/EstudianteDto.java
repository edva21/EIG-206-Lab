/**
 * Programmer: Eddy Valverde Garro
 * Version - 1.0
 * Last Modification: 14/08/17 19:00;
 */
package Dto;

import LogicaDeNegocio.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author edva5
 */
public class EstudianteDto extends PersonaDto implements Comparable<EstudianteDto>{
  private ArrayList<GrupoDto> grupos;
    private ArrayList<NotaDto> notas;
    private CarreraDto carrera;
    private HashMap<String, EstudianteDto> Cedula_o_passaporte = new HashMap<String, EstudianteDto>();

    public EstudianteDto(Estudiante e) {
        //super(e.getCedulaOPassaporte(), e.getNombre(), e.getApellido1(), e.g, telefono, email, clave, fecaNacimiento);
     
    }    
   
 
 
    /**
     * @return the notas
     */
    public ArrayList<NotaDto> getNotas() {
        return notas;
    }

    /**
     * @param notas the notas to set
     */
    public void setNotas(ArrayList<NotaDto> notas) {
        this.notas = notas;
    }

    /**
     * @return the carrera
     */
    public CarreraDto getCarrera() {
        return carrera;
    }

    /**
     * @param carrera the carrera to set
     */
    public void setCarrera(CarreraDto carrera) {
        this.carrera = carrera;
    }
  

    /**
     * @return the grupos
     */
    public ArrayList<GrupoDto> getGrupos() {
        return grupos;
    }

    /**
     * @param grupos the grupos to set
     */
    public void setGrupos(ArrayList<GrupoDto> grupos) {
        this.grupos = grupos;
    }
    

    @Override
    public int compareTo(EstudianteDto o) {
        /*System.out.println("LogicaDeNegocio.Estudiante.compareTo()"+Integer.valueOf(this.cedulaOPassaporte));
        if(Integer.valueOf(this.cedulaOPassaporte)==Integer.valueOf(o.cedulaOPassaporte)){return 0;}
        if(Integer.valueOf(this.cedulaOPassaporte)<Integer.valueOf(o.cedulaOPassaporte)){return 1;}
        else return -1;*/
        return o.cedulaOPassaporte.compareTo(this.cedulaOPassaporte);
        
    }
    
}
