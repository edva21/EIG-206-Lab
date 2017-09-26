/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Control.Control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author edva5
 */
public class InterfazMenu extends myInterface {
    public static final String INTERFAZ_MENU="Interfaz Menu";
    private JMenuItem administradorMnuItm,carreraMnuItm,cicloMnuItm,CursoMnuItm,estudianteMnuItm,grupoMnuItm,matriculadorMnuItm,notaMnuItm,profesorMnuItm;
    private ArrayList<JMenuItem> jMenuItems;
    private JMenuBar menuBar;
    private JMenu administradorMnu,matriculadorMnu,estudianteMnu,profesorMnu;
    /**
     * Creates new form InterfazMenu
     */
    public InterfazMenu() {
        initComponents();        
        this.setTitle(INTERFAZ_MENU);
        super.jScrollPane.setVisible(false);
        InitiaizePrimaryButtons();
    }
    private void InitiaizePrimaryButtons(){
//        this.addKeyListener(controlador);
//private JMenuItem ,,,,,,,,;
        jMenuItems= new ArrayList<JMenuItem>();
        jMenuItems.add(administradorMnuItm);
        
        /*jMenuItems.add(carreraMnuItm);
        jMenuItems.add(cicloMnuItm);
        jMenuItems.add(CursoMnuItm);
        jMenuItems.add(estudianteMnuItm);
        jMenuItems.add(grupoMnuItm);
        jMenuItems.add(matriculadorMnuItm);
        jMenuItems.add(notaMnuItm);
        jMenuItems.add(profesorMnuItm);*/
        
        //this.setFocusable(true);
        menuBar = new JMenuBar();        
            //ediMnu= new JMenu("Edit");
            administradorMnu= new JMenu("Administrador");
                administradorMnuItm=new JMenuItem(Interfaz.InterfazAdministrador.MANTENIMIENTO_ADMINISTRADOR);
            administradorMnu.add(administradorMnuItm);
                carreraMnuItm= new JMenuItem(Interfaz.InterfazCarrera.MANTENIMIENTO_CARRERA);
            administradorMnu.add(carreraMnuItm);
                cicloMnuItm= new JMenuItem(InterfazCiclo.MANTENIMIENTO_CICLO);
            administradorMnu.add(cicloMnuItm);
                CursoMnuItm = new JMenuItem(InterfazCurso.MANTENIMIENTO_CURSO);
            administradorMnu.add(CursoMnuItm);
                estudianteMnuItm = new JMenuItem(InterfazEstudiante.MANTENIMIENTO_ESTUDIANTE);
            administradorMnu.add(estudianteMnuItm);
               grupoMnuItm = new JMenuItem(InterfazGrupo.MANTENIMIENTO_GRUPO);
            administradorMnu.add(grupoMnuItm);
                matriculadorMnuItm = new JMenuItem(InterfazMatriculador.MANTENIMIENTO_MATRICULADOR);
            administradorMnu.add(matriculadorMnuItm);                        
                profesorMnuItm = new JMenuItem(InterfazProfesor.MANTENIMIENTO_PROFESOR);
            administradorMnu.add(profesorMnuItm);
            
        menuBar.add(administradorMnu);//CursoMnuItm,estudianteMnuItm,grupoMnuItm        
            profesorMnu=new JMenu("Profesor");
                notaMnuItm = new JMenuItem(InterfazNota.MANTENIMIENTO_NOTA);
            profesorMnu.add(notaMnuItm);
            
        menuBar.add(profesorMnu);
            estudianteMnu=new JMenu("Estudiante");            
        menuBar.add(estudianteMnu);
            
        this.setJMenuBar(menuBar);
        administradorMnuItm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.actionPerformed(e);
            }
        });
        jMenuItems.add(carreraMnuItm);
        carreraMnuItm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.actionPerformed(e);
            }
        });
        jMenuItems.add(cicloMnuItm);
        cicloMnuItm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.actionPerformed(e);
            }
        });
        jMenuItems.add(CursoMnuItm);
        CursoMnuItm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.actionPerformed(e);
            }
        });
        jMenuItems.add(estudianteMnuItm);
        estudianteMnuItm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.actionPerformed(e);
            }
        });
        jMenuItems.add(grupoMnuItm);
        grupoMnuItm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.actionPerformed(e);
            }
        });
        jMenuItems.add(matriculadorMnuItm);
        matriculadorMnuItm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.actionPerformed(e);
            }
        });
        jMenuItems.add(notaMnuItm);
        notaMnuItm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.actionPerformed(e);
            }
        });
        jMenuItems.add(profesorMnuItm);
        profesorMnuItm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.actionPerformed(e);
            }
        });                
    }
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
