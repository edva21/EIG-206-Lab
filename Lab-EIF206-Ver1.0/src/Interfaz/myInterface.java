/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Control.Control;
import Modelo.Modelo;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author edva5
 */
abstract class myInterface extends javax.swing.JFrame {

    /**
     * @return the defaultTableModel
     */
    
     protected Control control;
    protected Modelo modelo;
    protected JTable jTable;
    protected  DefaultTableModel defaultTableModel;    
    protected JScrollPane jScrollPane;
    /**
     * Creates new form Interfaz
     */
    public myInterface() {
        initComponents();
        jTable= new JTable();
        jScrollPane= new JScrollPane(jTable);
        defaultTableModel=(DefaultTableModel) jTable.getModel();        
        this.add(jScrollPane);
        jScrollPane.setVisible(true);
        jScrollPane.setBounds(50, 50, 600, 250);
        this.setBounds(0, 0, 800, 500);
        
    }
    /**
     * @param control the control to set
     */
    public void setControl(Control control) {
        this.control = control;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
   public DefaultTableModel getDefaultTableModel() {
        return defaultTableModel;
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

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
