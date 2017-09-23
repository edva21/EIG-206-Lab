/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Modelo.Modelo;
import Control.Control;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author edva5
 */ 
public class InterfazCurso extends myInterface implements Observer {
    public static final String MANTENIMIENTO_CURSO="Mantenimiento CURSO";
     private JTable jTable;     
    private  DefaultTableModel defaultTableModel;    
    private JScrollPane jScrollPane;
    /**
     * Creates new form InterfazEstudiante
     */
    public InterfazCurso() {
        initComponents();
        
        jTable= new JTable();
        jScrollPane= new JScrollPane(jTable);
        defaultTableModel=(DefaultTableModel) jTable.getModel();
        defaultTableModel.addColumn("A");
        defaultTableModel.addColumn("B");
        defaultTableModel.addColumn("C");
        defaultTableModel.addColumn("D");
        defaultTableModel.addColumn("E");
        defaultTableModel.addColumn("F");
        this.add(jScrollPane);
        jScrollPane.setVisible(true);
        jScrollPane.setBounds(100, 100, 300, 300);
    }
    /**
     * @return the defaultTableModel
     */
    public DefaultTableModel getDefaultTableModel() {
        return defaultTableModel;
    }
    public void setControl(Control control) {
        this.setControl(control);
    }

    /**
     * @return the modelo
     */
    public Modelo getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(Modelo modelo) {
        this.setModelo(modelo);
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

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
