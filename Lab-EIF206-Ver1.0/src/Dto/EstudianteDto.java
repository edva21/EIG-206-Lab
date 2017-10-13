/**
 * Programmer: Eddy Valverde Garro
 * Version - 1.0
 * Last Modification: 14/08/17 19:00;
 */
package Dto;

import LogicaDeNegocio.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author edva5
 */
public class EstudianteDto extends PersonaDto implements Comparable<EstudianteDto>, Serializable{

  
    private ArrayList<NotaDto> notas;
    private ArrayList<CarreraDto> carreras;    

    public EstudianteDto(Estudiante e) {
        super(e);
        carreras = new ArrayList<CarreraDto>();
        e.getCarreras().stream().forEach(x->carreras.add(new CarreraDto(x)));        
        notas= new ArrayList<NotaDto>();
        e.getNotas().stream().forEach(x->notas.add(new NotaDto(x)));
     
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

    


    

    @Override
    public int compareTo(EstudianteDto o) {
        /*System.out.println("LogicaDeNegocio.Estudiante.compareTo()"+Integer.valueOf(this.cedulaOPassaporte));
        if(Integer.valueOf(this.cedulaOPassaporte)==Integer.valueOf(o.cedulaOPassaporte)){return 0;}
        if(Integer.valueOf(this.cedulaOPassaporte)<Integer.valueOf(o.cedulaOPassaporte)){return 1;}
        else return -1;*/
        return o.cedulaOPassaporte.compareTo(this.cedulaOPassaporte);
        
    }
    
    /**
     * @return the carreras
     */
    public ArrayList<CarreraDto> getCarreras() {
        return carreras;
    }

    /**
     * @param carreras the carreras to set
     */
    public void setCarreras(ArrayList<CarreraDto> carreras) {
        this.carreras = carreras;
    }
}
