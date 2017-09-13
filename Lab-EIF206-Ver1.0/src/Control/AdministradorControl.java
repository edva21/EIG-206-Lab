/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import AccesoDatos.AccesoDatoAdministrador;
import Interfaz.AdministradorVista;
import LogicaDeNegocio.Administrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author edva5
 */
public class AdministradorControl implements ActionListener,MouseListener,KeyListener {
    private AccesoDatoAdministrador modelo; //modelo
    private AdministradorVista vista; //vista
    /**
     * @return the modelo
     */
   
    public AdministradorControl(AccesoDatoAdministrador modelo, AdministradorVista vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setController(this);
        modelo.addObserver(vista);
    }    

    public AdministradorControl() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {        
        if (e.getActionCommand().equals("Agrgegar Nuevo")) {
            
        }
        else if (e.getActionCommand().equals("Eliminar")) {
            
        }
        else if (e.getActionCommand().equals("Guardar")) {
            
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
