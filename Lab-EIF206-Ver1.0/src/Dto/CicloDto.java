/**
 * Programmer: Eddy Valverde Garro
 * Version - 1.0
 * Last Modification: 24/08/17 15:00;
 */
package Dto;

import LogicaDeNegocio.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author edva5
 */
public class CicloDto implements Serializable{
    private String codigo,fechaIni,fechaFin;
    private int Anho;
    private int numero;    

    public CicloDto() {
    }
    public CicloDto(Ciclo c) {
        codigo=c.getCodigo();
        fechaIni=c.getFechaIni().toString();
        fechaFin=c.getFechaFin().toString();
        Anho=c.getAnho();
        numero=c.getNumero();
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
    public String getFechaIni() {
        return fechaIni;
    }

    /**
     * @param fechaIni the fechaIni to set
     */
    public void setFechaIni(String fechaIni) {
        this.fechaIni = fechaIni;
    }

    /**
     * @return the fechaFin
     */
    public String getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(String fechaFin) {
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
