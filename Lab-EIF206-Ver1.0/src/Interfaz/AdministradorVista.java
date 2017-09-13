/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.HeadlessException;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import AccesoDatos.AccesoDatoAdministrador;
import Control.AdministradorControl;
import LogicaDeNegocio.Administrador;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SelectionModel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author edva5
 */
public class AdministradorVista extends javax.swing.JFrame implements Observer {
    private AdministradorForm form;
    private AccesoDatoAdministrador modelo;
    private AdministradorControl controlador; 
    private DefaultTableModel tableModel;
    private JButton guardarCambiosBtn,agregarNuevoBtn,eliminarBtn,addBtn;
    
    public AdministradorVista(AccesoDatoAdministrador ada) {           
        modelo=ada;        
    }
    public AdministradorVista() {  
    initComponents();    
    }
    /**
     * @return the modelo
     */
    public AccesoDatoAdministrador getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(AccesoDatoAdministrador modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the controlador
     */
    public AdministradorControl getControlador() {
        return controlador;
    }

    /**
     * @param controlador the controlador to set
     */
    public void setControlador(AdministradorControl controlador) {
        this.controlador = controlador;
    }
    
    /**
     *
     */
    
    private void initComponents(){
                
        JPanel contentPane,rightPane,northPane,leftPane,southPane;    
        JTable table;    
        JLabel titleLbl,buscarLbl;
        JTextField buscarTxtFld;
        titleLbl = new JLabel("Admonistradores");        
        buscarLbl = new JLabel("Buscar Por Id:");
        buscarTxtFld= new JTextField("Buscar:");        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setModelo(new AccesoDatoAdministrador());   
        table = new JTable();        
        guardarCambiosBtn = new JButton("Guardar Cambios");
        agregarNuevoBtn = new JButton("Agregar Nuevo");
        eliminarBtn = new JButton("Eliminar");        
        contentPane = new JPanel(); 
        rightPane = new JPanel();
        northPane = new JPanel();
        leftPane = new JPanel();
        southPane = new JPanel();        
        agregarNuevoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarNuevoBtnActionPerformed(e);
            }
        });
        
        tableModel=(DefaultTableModel) table.getModel();
        tableModel.addColumn("Cedula/Pasaporte");
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Apellido1");
        tableModel.addColumn("Apellido2");
        tableModel.addColumn("Fecha de Nacimiento");
        tableModel.addColumn("Telefono");
        tableModel.addColumn("Email");
        tableModel.addColumn("Clave");
               
        contentPane.add(titleLbl,BorderLayout.NORTH);
        contentPane.add(new JScrollPane(table),BorderLayout.CENTER);              
        contentPane.setBackground(Color.GRAY);   
        contentPane.setVisible(true);
        
        rightPane.setLayout(new BoxLayout(rightPane, BoxLayout.PAGE_AXIS));
        rightPane.setBackground(Color.lightGray);
        rightPane.setVisible(true);        
        northPane.setBackground(Color.red);
        northPane.setVisible(true);
        leftPane.setBackground(Color.ORANGE);
        leftPane.setVisible(true);
        southPane.setBackground(Color.yellow);
        
        table.setVisible(true);
        this.add(southPane,BorderLayout.SOUTH)      ;
        this.add(leftPane,BorderLayout.WEST);
        this.add(northPane,BorderLayout.NORTH);
        this.add(contentPane,BorderLayout.CENTER);
        this.add(rightPane,BorderLayout.EAST);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        this.pack();                          
        this.setSize(700, 300);
        this.setLocation(250, 250);
                
        southPane.add(guardarCambiosBtn,BorderLayout.CENTER);
        southPane.add(agregarNuevoBtn,BorderLayout.CENTER);
        southPane.add(eliminarBtn,BorderLayout.CENTER);
        
        northPane.add(titleLbl,BorderLayout.CENTER);
        rightPane.add(buscarLbl,new GridLayout(1, 7));
        rightPane.add(buscarTxtFld,BorderLayout.NORTH);
       
        agregarNuevoBtn.setBounds(new Rectangle(600, 50, 100, 50));
        agregarNuevoBtn.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        
    }
    public void setController(AdministradorControl _controlador){
        guardarCambiosBtn.addMouseListener(_controlador);
        //agregarNuevoBtn.addActionListener(_controlador);
        eliminarBtn.addActionListener(_controlador);        
        setControlador(_controlador);
    }

    @Override
    public void update(Observable o, Object arg) {
        setModelo((AccesoDatoAdministrador) o);
            for (int i = tableModel.getRowCount()-1; i > - 1; i--) {
                tableModel.removeRow(i);
            }        
         if (!modelo.getAll().isEmpty()) 
            getModelo().getAll().forEach(x->tableModel.addRow(x.toVectorOfString()));
    }    
    private void agregarNuevoBtnActionPerformed(ActionEvent e){
        form = new AdministradorForm(controlador);
        tableModel.addRow(new String[]{null,null,null,null,null});
        form.setVisible(true);
    }private void guardarBtnActionPerformed(ActionEvent e,String[] nuevoAdmi){
        System.out.println(nuevoAdmi);
        this.agregarNuevoBtn.setEnabled(false);
        tableModel.addRow(new String[]{null,null,null,null,null});
    }   

  
    
}
    
