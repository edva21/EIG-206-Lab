/**
 * Programmer: Eddy Valverde Garro
 * Version - 1.0
 * Last Modification: 24/08/17 15:00;
 */
package LogicaDeNegocio;

import java.util.ArrayList;

/**
 *
 * @author edva5
 */
public class Grupo {
    private String id; 
    private Curso curso;
    private Ciclo ciclo;
    private Profesor prof;
    private ArrayList<Estudiante> estudintes;
    public Grupo() {
    }

    public Grupo(String id) {
        this.id = id;
    }

    public Grupo(String id, Curso curso, Ciclo ciclo, Profesor prof, ArrayList<Estudiante> estudintes) {
        this.id = id;
        this.curso = curso;
        this.ciclo = ciclo;
        this.prof = prof;
        this.estudintes = estudintes;
    }
    
    /**
     * @return the curso
     */
    public Curso getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    /**
     * @return the ciclo
     */
    public Ciclo getCiclo() {
        return ciclo;
    }

    /**
     * @param ciclo the ciclo to set
     */
    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    /**
     * @return the prof
     */
    public Profesor getProf() {
        return prof;
    }

    /**
     * @param prof the prof to set
     */
    public void setProf(Profesor prof) {
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
