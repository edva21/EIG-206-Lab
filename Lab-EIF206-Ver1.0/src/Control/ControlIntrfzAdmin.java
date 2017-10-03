/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;


import Datos.Datos;
import Interfaz.ButtonColumn;
import Interfaz.Forms.FormAdministrador;
import Interfaz.InterfazAdministrador;
import LogicaDeNegocio.Administrador;
import Modelo.Modelos.ModeloAdministrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


/**
 *
 * @author edva5
 */
public class ControlIntrfzAdmin implements KeyListener,MouseListener,ActionListener{
    private JFrame jFrame;
    private Datos datos;
    private Interfaz.InterfazAdministrador interfazAdministrador;
    private JFrame frame;
    private FormAdministrador formAdministrador;
    private Modelo.Modelos.ModeloAdministrador modelo;
    public ControlIntrfzAdmin(InterfazAdministrador interfazAdministrador,ModeloAdministrador modelo) throws IOException, ClassNotFoundException {
        datos = new Datos();
        AccesoDatos.AccesoDatosAdministrador.getInstance().setAdministradores(datos.getLista(Datos.FICHERO_ADMINISTRADOR));
        this.modelo=modelo;
        formAdministrador= new FormAdministrador();
        formAdministrador.fillForm(AccesoDatos.AccesoDatosAdministrador.getInstance().getAll().get(0));
        //int aux=JOptionPane.showConfirmDialog(null, formAdministrador,"Probando",JOptionPane.OK_CANCEL_OPTION);
        this.interfazAdministrador = interfazAdministrador;        
        interfazAdministrador= new InterfazAdministrador();
        interfazAdministrador.setControl(this);        
        interfazAdministrador.setVisible(true);
        
        jFrame = new JFrame();
        jFrame.add(interfazAdministrador);
        jFrame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowClosing(WindowEvent e) {
                datos.guardarDatos(AccesoDatos.AccesoDatosAdministrador.getInstance().getAll());
            }

            @Override
            public void windowClosed(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowIconified(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowActivated(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        jFrame.setVisible(true);
        jFrame.setBounds(0, 0, 700, 400);
        interfazAdministrador.getDefaultTableModel().setRowCount(0);
        for (int i = 0; i < Administrador.getClassNames().length; i++) {
          interfazAdministrador.getDefaultTableModel().addColumn(Administrador.getClassNames()[i]);
        }       
        for (Administrador a:AccesoDatos.AccesoDatosAdministrador.getInstance().getAll()) {
          interfazAdministrador.getDefaultTableModel().addRow(a.toVectorOfString());
        }
        interfazAdministrador.addDeleteButton();
        modelo.addObserver(interfazAdministrador);
        //Administrador.getClassNames()
    }
    /**
     * @return the formAdministrador
     */
    public FormAdministrador getFormAdministrador() {
        return formAdministrador;
    }

    /**
     * @param formAdministrador the formAdministrador to set
     */
    public void setFormAdministrador(FormAdministrador formAdministrador) {
        this.formAdministrador = formAdministrador;
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
    public void mouseClicked(MouseEvent e) {           
        if (e.getClickCount()==1) {
            String auxString;
            if (e.getSource() instanceof JTable) {
                JTable auxTable =(JTable) e.getSource();
                int sel=auxTable.getSelectedColumn()+1,count=auxTable.getColumnCount();
                if (auxTable.getSelectedColumn()+1<auxTable.getColumnCount()) {                     
                    auxString = auxTable.getValueAt(auxTable.getSelectedRow(), 0).toString();
                    Administrador auxAdmi=AccesoDatos.AccesoDatosAdministrador.getInstance().get(auxString);
                    formAdministrador.clearForm();            
                    formAdministrador.fillForm(auxAdmi);
                    int aux=JOptionPane.showConfirmDialog(null, formAdministrador,"Editar",JOptionPane.OK_CANCEL_OPTION);
                    if (aux==JOptionPane.OK_OPTION)
                        {
                         AccesoDatos.AccesoDatosAdministrador.getInstance().modificar(formAdministrador.getAdministador());                                                    
                         modelo.update();
                        }                       
                }
                else
                {                    
                    auxString = auxTable.getValueAt(auxTable.getSelectedRow(), 0).toString();
                    Administrador auxAdmi=AccesoDatos.AccesoDatosAdministrador.getInstance().get(auxString);
                    formAdministrador.clearForm();            
                    formAdministrador.fillForm(auxAdmi);
                    formAdministrador.setEditable(false);                    
                    int aux=JOptionPane.showConfirmDialog(null, formAdministrador," Desea Eliminar Administrador?",JOptionPane.OK_CANCEL_OPTION);
                    if (aux==JOptionPane.OK_OPTION)
                        {
                         AccesoDatos.AccesoDatosAdministrador.getInstance().eliminar(formAdministrador.getAdministador().getCedulaOPassaporte());                                                    
                         formAdministrador.setEditable(true);
                         modelo.update();
                        }
                    else
                        formAdministrador.setEditable(true);
                }
             
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            if (e.getActionCommand().equals("Add")) {
                formAdministrador.clearForm();                                
                    int aux=JOptionPane.showConfirmDialog(null, formAdministrador,"Agregar Nuevo",JOptionPane.OK_CANCEL_OPTION);
                    if (aux==JOptionPane.OK_OPTION)
                        {
                         AccesoDatos.AccesoDatosAdministrador.getInstance().insertar(formAdministrador.getAdministador());                                                    
                         modelo.update();
                        }       
            }
        }
    }
    private void showInfoOnForm(JTable auxTable){
        
    }
    
}

