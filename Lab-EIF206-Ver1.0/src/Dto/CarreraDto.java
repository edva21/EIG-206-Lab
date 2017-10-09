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
public class CarreraDto implements Serializable{           
    private ArrayList<CursoDto> cursos;    
    private String codigo,nombre,titulo;        
    public CarreraDto() {
    }
    public CarreraDto(Carrera c) {
        this.codigo = c.getCodigo();
        this.nombre = c.getNombre();
        this.titulo = c.getTitulo();     
        cursos = new ArrayList<CursoDto>();
        c.getCursos().stream().forEach(x->cursos.add(new CursoDto(x)));
    }
    public CarreraDto(String codigo, String nombre, String titulo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.titulo = titulo;        
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
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String toString(){
        return codigo + nombre + titulo;
    }
    
    /**
     * @return the cursos
     */
    public ArrayList<CursoDto> getCursos() {
        return cursos;        
    }

    /**
     * @param cursos the cursos to set
     */
    public void setCursos(ArrayList<CursoDto> cursos) {        
        this.cursos = cursos;       
    }
}
