/**
 * Programmer: Eddy Valverde Garro
 * Version - 1.0
 * Last Modification: 24/08/17 15:00;
 */
package Dto;

import LogicaDeNegocio.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author edva5
 */
public class GrupoDto implements Serializable{
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
    public GrupoDto(Grupo g) {
        this.id = g.getId();
        this.curso = new CursoDto(g.getCurso());
        this.ciclo = new CicloDto(g.getCiclo());
        this.prof = new ProfesorDto(g.getProf());
        this.estudintes = new ArrayList<EstudianteDto>();
        g.getEstudintes().stream().forEach(x->estudintes.add(new EstudianteDto(x)));
    }
    public GrupoDto(String id, CursoDto curso, CicloDto ciclo, ProfesorDto prof, ArrayList<EstudianteDto> estudintes) {
        this.id = id;
        this.curso = curso;
        this.ciclo = ciclo;
        this.prof = prof;
        this.estudintes = estudintes;
    }
    
    /**
     * @return the estudintes
     */
    public ArrayList<EstudianteDto> getEstudintes() {
        return estudintes;
    }

    /**
     * @param estudintes the estudintes to set
     */
    public void setEstudintes(ArrayList<EstudianteDto> estudintes) {
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
