/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;


import Interfaz.Dispatcher;
import Interfaz.InterfazAdministrador;
import Interfaz.InterfazLogIn;
import Interfaz.InterfazMenu;
import Modelo.Modelo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.stream.Collectors;
import javax.swing.JButton;
import javax.swing.JMenuItem;


/**
 *
 * @author edva5
 */
public class Control implements ActionListener,MouseListener{
    private Modelo modelo;
    private Dispatcher dispatcher;  

    

    public Control(Modelo modelo, Dispatcher dispatcher) {
        this.modelo = modelo;
        this.dispatcher = dispatcher;
        this.dispatcher.dispatcherRequest(InterfazLogIn.LOGIN, modelo, this);
        
    }        

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            if (e.getActionCommand().equals("LogIn"))
                dispatcher.dispatcherRequest(InterfazMenu.INTERFAZ_MENU, modelo, this);
            else if (e.getActionCommand().equals("Atras")) {
                dispatcher.dispatcherRequest(modelo.getHistorialDeVentana().pop(), modelo, this);                           
            }
                
        }
        else if (e.getSource() instanceof JMenuItem) {
            dispatcher.dispatcherRequest(e.getActionCommand(), modelo, this);                           
        }
        else if (e.getSource() instanceof String) {
            switch(((String)e.getSource())){
                case "Atras":
                    //dispatcher.
                break;
            }
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
    
}
