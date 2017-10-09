/*
 * Programmer: Eddy Valverde Garro
 * Version - 1.0
 * Last Modification: 24/08/17 15:00;
 */
package LogicaDeNegocio;

import Dto.NotaDto;

/**
 *
 * @author edva5
 */
public class Nota {
    private String id;
    private int anho;
    private int semestre;
    private int Nota;
    public Nota(String id) {
        this.id = id;
    }
    public Nota() {
    }
    public Nota(NotaDto n) {
        this.id = n.getId();
        this.Nota = n.getNota();
        semestre=n.getSemestre();
        anho=n.getAnho();
    }   
    public Nota(String id, int Nota) {
        this.id = id;
        this.Nota = Nota;
    }   
    /**
     * @return the anho
     */
    public int getAnho() {
        return anho;
    }

    /**
     * @param anho the anho to set
     */
    public void setAnho(int anho) {
        this.anho = anho;
    }

    /**
     * @return the semestre
     */ 
    public int getSemestre() {
        return semestre;
    }

    /**
     * @param semestre the semestre to set
     */
    public void setSemestre(int semestre) {
        this.semestre = semestre;
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

    

    /**
     * @return the Nota
     */
    public int getNota() {
        return Nota;
    }

    /**
     * @param Nota the Nota to set
     */
    public void setNota(int Nota) {
        this.Nota = Nota;
    }
    
}
