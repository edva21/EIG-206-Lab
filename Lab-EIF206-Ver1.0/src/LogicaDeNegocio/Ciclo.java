/**
 * Programmer: Eddy Valverde Garro
 * Version - 1.0
 * Last Modification: 24/08/17 15:00;
 */
package LogicaDeNegocio;

import Dto.CicloDto;
import Dto.GrupoDto;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author edva5
 */
public class Ciclo {

    public static final String ATRIBUTTE_CODIGO="Codigo",ATRIBUTTE_NUMERO="Numero",ATRIBUTTE_FECHA_INI="Fecha Inicio",ATRIBUTTE_FECHA_FIN="Fecha Fin";
    private String codigo;    
    private int numero;
    private LocalDate fechaIni;
    private LocalDate fechaFin;
    private ArrayList<Grupo> grupos;

    public Ciclo() {
        grupos=new ArrayList<Grupo>();
    }
    public Ciclo(String codigo) {
        this.codigo=codigo;
        grupos=new ArrayList<Grupo>();
    }
    public Ciclo(CicloDto c) {
        this.codigo = c.getCodigo();        
        this.numero = c.getNumero();
        this.fechaIni = LocalDate.parse(c.getFechaIni());
        this.fechaFin = LocalDate.parse(c.getFechaIni());
        grupos=new ArrayList<Grupo>();
        c.getGrupos().stream().forEach(x->grupos.add(new Grupo(x)));
    }
    public Ciclo(String codigo, int Anho, int numero, LocalDate fechaIni, LocalDate fechaFin) {
        this.codigo = codigo;        
        this.numero = numero;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        grupos=new ArrayList<Grupo>();
    }    
    

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the fechaIni
     */
    public LocalDate getFechaIni() {
        return fechaIni;
    }

    /**
     * @param fechaIni the fechaIni to set
     */
    public void setFechaIni(LocalDate fechaIni) {
        this.fechaIni = fechaIni;
    }

    /**
     * @return the fechaFin
     */
    public LocalDate getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
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
    public static final String[] getClassNames(){  
        String[] aux={ATRIBUTTE_CODIGO,ATRIBUTTE_NUMERO,ATRIBUTTE_FECHA_INI,ATRIBUTTE_FECHA_FIN};
        return aux;
    }
    
    /**
     * @return the grupos
     */
    public ArrayList<Grupo> getGrupos() {
        return grupos;
    }

    /**
     * @param grupos the grupos to set
     */
    public void setGrupos(ArrayList<Grupo> grupos) {
        this.grupos = grupos;
    }
}
