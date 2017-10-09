/**
 * Programmer: Eddy Valverde Garro
 * Version - 1.0
 * Last Modification: 24/08/17 15:00;
 */
package LogicaDeNegocio;

import Dto.CicloDto;
import java.time.LocalDate;

/**
 *
 * @author edva5
 */
public class Ciclo {
    private String codigo;
    private int Anho;
    private int numero;
    private LocalDate fechaIni;
    private LocalDate fechaFin;

    public Ciclo() {
    }
    public Ciclo(String codigo) {
        this.codigo=codigo;
    }
    public Ciclo(CicloDto c) {
        this.codigo = c.getCodigo();
        this.Anho = c.getAnho();
        this.numero = c.getNumero();
        this.fechaIni = LocalDate.parse(c.getFechaIni());
        this.fechaFin = LocalDate.parse(c.getFechaIni());
    }
    public Ciclo(String codigo, int Anho, int numero, LocalDate fechaIni, LocalDate fechaFin) {
        this.codigo = codigo;
        this.Anho = Anho;
        this.numero = numero;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
    }    

    /**
     * @return the Anho
     */
    public int getAnho() {
        return Anho;
    }

    /**
     * @param Anho the Anho to set
     */
    public void setAnho(int Anho) {
        this.Anho = Anho;
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
    
}
