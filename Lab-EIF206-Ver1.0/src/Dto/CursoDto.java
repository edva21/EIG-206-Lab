/**
 * Programmer: Eddy Valverde Garro
 * Version - 1.0
 * Last Modification: 14/08/17 19:00;
 */
package Dto;

import LogicaDeNegocio.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author edva5
 */
public class CursoDto implements Serializable{
    private String codigo;
    private String nombre;
    private int creditos;
    private int horasSemanales;
    private ArrayList<GrupoDto> grupos;

    public CursoDto() {
    }
    public CursoDto(Curso c) {
        this.codigo = c.getCodigo();
        this.nombre = c.getNombre();
        this.creditos = c.getCreditos();
        this.horasSemanales = c.getHorasSemanales();
        grupos = new ArrayList<GrupoDto>();
        c.getGrupos().forEach(x->grupos.add(new GrupoDto(x)));
    }
    public CursoDto(String codigo, String nombre, int creditos, int horasSemanales) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.horasSemanales = horasSemanales;
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

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the creditos
     */
    public int getCreditos() {
        return creditos;
    }

    /**
     * @param creditos the creditos to set
     */
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    /**
     * @return the horasSemanales
     */
    public int getHorasSemanales() {
        return horasSemanales;
    }

    /**
     * @param horasSemanales the horasSemanales to set
     */
    public void setHorasSemanales(int horasSemanales) {
        this.horasSemanales = horasSemanales;
    }
    
}
