/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Obligacion;

import java.util.List;

/**
 *
 * @author edva5
 */
public interface Obligation<Clase> {
    public void insertar(Clase c);
    public void modificar(Clase c);
    public void eliminar(Clase c);
    public Clase get(Object o);
    public List<Clase> getAll();
}
