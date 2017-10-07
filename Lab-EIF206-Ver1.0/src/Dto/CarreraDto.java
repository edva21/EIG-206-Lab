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
    public static final String ATRIBUTO_CODIGO="Codigo",ATRIBUTO_NOMBRE="Nombre",ATRIBUTO_TITULO="Titulo";
   
    //atrbutos
    private String[] cursos;    
    private String codigo,nombre,titulo;    
    //Constructores

    public CarreraDto() {
    }

    public CarreraDto(String codigo, String nombre, String titulo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.titulo = titulo;        
    }
    public String[] toVectorOfString(){        
        String[] aux = {codigo,nombre,titulo};        
        return aux;
    }
    public static final String[] getAtributesNames(){        
         final String[] aux = {ATRIBUTO_CODIGO,ATRIBUTO_NOMBRE,ATRIBUTO_TITULO};   
         return aux;        
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
    public String[] getCursos() {
        return cursos;        
    }

    /**
     * @param cursos the cursos to set
     */
    public void setCursos(ArrayList<Curso> cursos) {        
        this.cursos = new String[cursos.size()];
        for (int i = 0; i < cursos.size(); i++) {this.cursos[i]=new String(cursos.get(i).getCodigo());}
    }
}
