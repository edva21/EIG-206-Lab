/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import datechooser.beans.DateChooserCombo;


/**
 *
 * @author edva5
 */
public class AdministradorForm extends JFrame {
    private AdministradorVista vista;
    private JButton guardarBtn= new JButton("Gurdar");
    public AdministradorForm(ActionListener aL) throws HeadlessException {
    initComponents();
    guardarBtn.addActionListener(aL);
    }
    private  void initComponents(){  
    
    JPanel  jPanel1,cedulaPnl,nombrePnl,apellido1Pnl,apellido2Pnl,fechaNacimientoPnl,telefonoPnl,emailPnl,clavePnl,buttonPnl;
    JLabel cedulaLbl,nombreLbl,apellido1Lbl,apellido2LbL,fechaNacimientoLbl,telefonoLbl,emailLbl,claveLbl;
    JTextField cedulaTxtfld,nombreTxtfld,apellido1Txtfld,apellido2Txtfld,fechaNacimientoTxtfld,telefonoTxtfld,emailTxtfld,claveTxtfld;
    DateChooserCombo dateChooser;
    FlowLayout layoutManager;
    EmptyBorder lblBorder;
    JPanel listPane,txtfldPane;
    Container contentPane;        
        
        cedulaLbl = new JLabel("Cedula:");
        nombreLbl = new JLabel("Nombre:");
        apellido1Lbl = new JLabel("Apellido1:");
        apellido2LbL = new JLabel("Apellido2:");
        fechaNacimientoLbl = new JLabel("FechaNacimiento:");
        telefonoLbl = new JLabel("Telefono:");
        emailLbl = new JLabel("Email:");
        claveLbl = new JLabel("Clave:");
        
        cedulaTxtfld = new JTextField(10);
        nombreTxtfld = new JTextField(10);
        apellido1Txtfld = new JTextField(10);
        apellido2Txtfld = new JTextField(10);
        fechaNacimientoTxtfld = new JTextField(10);
        telefonoTxtfld = new JTextField(10);
        emailTxtfld = new JTextField(10);
        claveTxtfld = new JTextField(10);
        dateChooser = new DateChooserCombo();
        
        cedulaPnl = new JPanel(new FlowLayout());
        cedulaPnl.add(cedulaLbl);
        cedulaPnl.add(cedulaTxtfld);
        nombrePnl = new JPanel(new FlowLayout());
        nombrePnl.add(nombreLbl);
        nombrePnl.add(nombreTxtfld);
        apellido1Pnl = new  JPanel(new FlowLayout());
        apellido1Pnl.add(apellido1Lbl);
        apellido1Pnl.add(apellido1Txtfld);
        apellido2Pnl = new  JPanel(new FlowLayout());
        apellido2Pnl.add(apellido1Lbl);
        apellido2Pnl.add(apellido1Txtfld);
        fechaNacimientoPnl = new JPanel(new FlowLayout());
        fechaNacimientoPnl.add(fechaNacimientoLbl);
        fechaNacimientoPnl.add(dateChooser);
        telefonoPnl = new JPanel(new FlowLayout());
        telefonoPnl.add(telefonoLbl);
        telefonoPnl.add(telefonoTxtfld);
        emailPnl = new JPanel(new FlowLayout());
        emailPnl.add(emailLbl);
        emailPnl.add(emailTxtfld);
        clavePnl = new JPanel(new FlowLayout());
        clavePnl.add(claveLbl);
        clavePnl.add(claveTxtfld);
        
        
        
        lblBorder = new EmptyBorder(10, 10, 10, 10);
        guardarBtn.setBorder(lblBorder);
        cedulaLbl.setBorder(lblBorder);
        nombreLbl.setBorder(lblBorder);
        telefonoLbl.setBorder(lblBorder);
        emailLbl.setBorder(lblBorder);
        claveLbl.setBorder(lblBorder);
                       
        

//Put everything together, using the content pane's BoxLayout.
contentPane = getContentPane();
contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS)); 
contentPane.add(cedulaPnl);
contentPane.add(apellido1Pnl);
contentPane.add(apellido2Pnl);
contentPane.add(fechaNacimientoPnl);
contentPane.add(nombrePnl);
contentPane.add(telefonoPnl);
contentPane.add(emailPnl);
contentPane.add(clavePnl);
contentPane.add(guardarBtn);
     
        this.setSize(350, 375);
    }
    
}
