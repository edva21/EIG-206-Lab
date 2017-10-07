/**
 * Programmer: Eddy Valverde Garro
 * Version - 1.0
 * Last Modification: 14/08/17 19:00;
 */
package Dto;

import LogicaDeNegocio.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author edva5
 */
public abstract class PersonaDto implements Serializable {
public static final String ATRIBUTO_CEDULAPASAPORTE="Cedula_Pasaporte",//using protected attributes can be accessed directly by sons, otherwise, just by gets and sets
                            ATRIBUTO_NOMBRE="Nombre",
                            ATRIBUTO_APELLIDO1="Apellido Uno",
                            ATRIBUTO_APELLIDO2="Apellido Dos",
                            ATRIBUTO_TELEFONO="Telefono",
                            ATRIBUTO_EMAIL="Email",
                            ATRIBUTO_CLAVE="Clave",    
                            ATRIBUTO_FECHA_DE_NACIMMIENTO="Fecha De Nacimiento";
    protected String cedulaOPassaporte;//using protected attributes can be accessed directly by sons, otherwise, just by gets and sets
    protected String nombre;
    protected String Apellido1;
    protected String Apellido2;
    protected String telefono;
    protected String email;
    protected String clave;
    protected String fechaNacimiento;
    
    public PersonaDto() {
    }
    public PersonaDto(Persona p) {
        this.cedulaOPassaporte = p.getCedulaOPassaporte();
        this.nombre = p.getNombre();
        this.Apellido1 = p.getApellido1();
        this.Apellido2 = p.getApellido2();
        this.telefono = p.getTelefono();
        this.email = p.getEmail();
        this.clave = p.getClave();        
        this.fechaNacimiento=p.getFechaNacimiento().toString();
    }
    /**
     * @return the fechaNacimiento
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;        
    }    

    /**
     * @return the Apellido1
     */
    public String getApellido1() {
        return Apellido1;
    }

    /**
     * @param Apellido1 the Apellido1 to set
     */
    public void setApellido1(String Apellido1) {
        this.Apellido1 = Apellido1;
    }

    /**
     * @return the Apellido2
     */
    public String getApellido2() {
        return Apellido2;
    }

    /**
     * @param Apellido2 the Apellido2 to set
     */
    public void setApellido2(String Apellido2) {
        this.Apellido2 = Apellido2;
    }
    /**
     * @return the cedulaOPassaporte
     */
    public String getCedulaOPassaporte() {
        return cedulaOPassaporte;
    }

    /**
     * @param cedulaOPassaporte the cedulaOPassaporte to set
     */
    public void setCedulaOPassaporte(String cedulaOPassaporte) {
        this.cedulaOPassaporte = cedulaOPassaporte;
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
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     *
     */    
   
}
