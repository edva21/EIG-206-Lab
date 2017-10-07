/**
 * Programmer: Eddy Valverde Garro
 * Version - 1.0
 * Last Modification: 24/08/17 15:00;
 */
package Dto;

import LogicaDeNegocio.*;
import java.util.ArrayList;

/**
 *
 * @author edva5
 */
public class GrupoDto {
    private String id; 
    private CursoDto curso;
    private CicloDto ciclo;
    private ProfesorDto prof;
    private ArrayList<EstudianteDto> estudintes;
    public GrupoDto() {
    }

    public GrupoDto(String id) {
        this.id = id;
    }

    public GrupoDto(String id, CursoDto curso, CicloDto ciclo, ProfesorDto prof, ArrayList<EstudianteDto> estudintes) {
        this.id = id;
        this.curso = curso;
        this.ciclo = ciclo;
        this.prof = prof;
        this.estudintes = estudintes;
    }
    
    /**
     * @return the curso
     */
    public CursoDto getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(CursoDto curso) {
        this.curso = curso;
    }

    /**
     * @return the ciclo
     */
    public CicloDto getCiclo() {
        return ciclo;
    }

    /**
     * @param ciclo the ciclo to set
     */
    public void setCiclo(CicloDto ciclo) {
        this.ciclo = ciclo;
    }

    /**
     * @return the prof
     */
    public ProfesorDto getProf() {
        return prof;
    }

    /**
     * @param prof the prof to set
     */
    public void setProf(ProfesorDto prof) {
        this.prof = prof;
    }
   
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    
}
