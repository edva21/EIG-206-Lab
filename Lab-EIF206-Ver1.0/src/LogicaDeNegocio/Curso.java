/**
 * Programmer: Eddy Valverde Garro
 * Version - 1.0
 * Last Modification: 14/08/17 19:00;
 */
package LogicaDeNegocio;

import Dto.CursoDto;
import java.util.ArrayList;

/**
 *
 * @author edva5
 */
public class Curso {

    /**
     * @return the carreras
     */
    public Carrera getCarreras() {
        return carreras;
    }

    /**
     * @param carreras the carreras to set
     */
    public void setCarreras(Carrera carreras) {
        this.carreras = carreras;
    }

    /**
     * @return the carreras
     */

    public void setGrupos(ArrayList<Grupo> grupos) {
        this.grupos = grupos;
    }
    public static final String ATRIBUTTE_CODIGO="Codigo",ATRIBUTTE_NOMBRE="Nombre",ATRIBUTTE_CREDITOS="CREDITOS",ATRIBUTTE_HORAS_SEMANALES="Horas Semanales",ATRIBUTTE_CARRERA="Carrera";
    private String codigo;
    private String nombre;
    private int creditos;
    private int horasSemanales;
    private ArrayList<Grupo> grupos;//Manca
    private Carrera carreras;
    public Curso() {
        grupos = new ArrayList<Grupo>();        
        carreras = new Carrera();
    }
    public Curso(String codigo) {
        this.codigo=codigo;
        grupos = new ArrayList<Grupo>();        
        carreras = new Carrera();
    }
    public Curso(CursoDto c) {
        this.codigo = c.getCodigo();
        this.nombre = c.getNombre();
        this.creditos = c.getCreditos();
        this.horasSemanales = c.getHorasSemanales();        
        carreras = new Carrera(c.getCarrera());
        grupos = new ArrayList<Grupo>();
        c.getGrupos().stream().forEach(x->grupos.add(new Grupo(x)));
    }
    public Curso(String codigo, String nombre, int creditos, int horasSemanales) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.horasSemanales = horasSemanales;
        grupos = new ArrayList<Grupo>();    
        carreras = new Carrera();
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
  

    /**
     * @param carreras the carreras to set
     */
  
    /**
     * @return the grupos
     */
    public ArrayList<Grupo> getGrupos() {
        return grupos;
    }

    /**
     * @param grupos the grupos to set
     */
    public static String[] getClassNames(){
        String[] aux={ATRIBUTTE_CARRERA,ATRIBUTTE_CODIGO,ATRIBUTTE_CREDITOS,ATRIBUTTE_HORAS_SEMANALES,ATRIBUTTE_NOMBRE};
        return aux;
    }
}
