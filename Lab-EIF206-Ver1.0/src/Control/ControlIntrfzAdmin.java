/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Interfaz.InterfazAdministrador;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import sun.awt.im.InputMethodJFrame;

/**
 *
 * @author edva5
 */
public class ControlIntrfzAdmin implements KeyListener,ListSelectionListener{
    private Interfaz.InterfazAdministrador interfazAdministrador;
    private JFrame frame;
    public ControlIntrfzAdmin(InterfazAdministrador interfazAdministrador) {
        this.interfazAdministrador = interfazAdministrador;
        if (this.interfazAdministrador==null)
            interfazAdministrador= new InterfazAdministrador();
        
            
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

    @Override
    public void valueChanged(ListSelectionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

