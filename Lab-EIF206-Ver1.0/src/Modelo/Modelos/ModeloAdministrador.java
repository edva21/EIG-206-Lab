/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Modelos;

import LogicaDeNegocio.Administrador;
import java.util.Observable;

/**
 *
 * @author edva5
 */
public class ModeloAdministrador extends Observable{

    public ModeloAdministrador() {
    }
    public void update(){
        setChanged();
        notifyObservers(AccesoDatos.AccesoDatosAdministrador.getInstance().getAll());
    }
}
