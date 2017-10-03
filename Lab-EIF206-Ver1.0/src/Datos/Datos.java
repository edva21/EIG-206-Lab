/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import LogicaDeNegocio.Administrador;
import LogicaDeNegocio.Carrera;
import LogicaDeNegocio.Ciclo;
import LogicaDeNegocio.Curso;
import LogicaDeNegocio.Estudiante;
import LogicaDeNegocio.Grupo;
import LogicaDeNegocio.Matriculador;
import LogicaDeNegocio.Nota;
import LogicaDeNegocio.Profesor;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Datos {
    public static String FICHERO_ADMINISTRADOR="TABLE_ADMINISTRADOR.tmp",
        FICHERO_CARRERA="TABLE_CARRERA.tmp",
        FICHERO_CICLO="TABLE_CICLO.tmp",
        FICHERO_CURSO="TABLE_CURSO.tmp",
        FICHERO_ESTUDIANTE="TABLE_ESTUDIANTE.tmp",
        FICHERO_GRUPO="TABLE_GRUPO.tmp",
        FICHERO_MATRICULADOR="TABLE_MATRICULADOR.tmp",
        FICHERO_NOTA="TABLE_NOTA.tmp",
        FICHERO_PROFESOR="TABLE_PROFESOR.tmp";
    FileOutputStream ficheroSalida;
    ObjectOutputStream objetoSalida;
    FileInputStream ficheroEntrada;
    ObjectInputStream objetoEntrada;
    public Datos() {            
        
    }
    public ArrayList getLista(String fichero) throws IOException, ClassNotFoundException{
        ArrayList aux= new ArrayList<>();
        try{
            loadArchivesToRead(fichero);
            while(true){
                aux.add(objetoEntrada.readObject());
            }
        }catch(EOFException ex){
            objetoEntrada.close();
            return aux;
        }
        
    }
                
    public void guardarDatos(ArrayList list){
        try{
            if (!list.isEmpty()) {
                if (list.get(0) instanceof Administrador)                
                {
                    ArrayList<Administrador> admiList = list;
                    loadArchivesToWrite(FICHERO_ADMINISTRADOR);                          
                    for (Administrador a:admiList) {                        
                        objetoSalida.writeObject(new Administrador(a));                                                
                    }                     
                    objetoSalida.close();
                }                        
                else if (list.get(0) instanceof Carrera)                
                {
                    loadArchivesToWrite(FICHERO_CARRERA);          
                }                      
                else if (list.get(0) instanceof Ciclo)                
                {
                    loadArchivesToWrite(FICHERO_CICLO);        
                }                        
                else if (list.get(0) instanceof Curso)                
                {
                    loadArchivesToWrite(FICHERO_CURSO);    
                }                            
                else if (list.get(0) instanceof Estudiante)                
                {
                    loadArchivesToWrite(FICHERO_ESTUDIANTE);                                
                }
                else if (list.get(0) instanceof Grupo)                
                {
                    loadArchivesToWrite(FICHERO_GRUPO);                                
                }
                else if (list.get(0) instanceof Matriculador)                
                {
                    loadArchivesToWrite(FICHERO_MATRICULADOR);                                
                }
                else if (list.get(0) instanceof Nota)                
                {
                    loadArchivesToWrite(FICHERO_NOTA);                                
                }
                else if (list.get(0) instanceof Profesor)                
                {
                    loadArchivesToWrite(FICHERO_PROFESOR);                                
                }               
            }
            
            
        }  catch(IOException ex){
            
        }
    }
    private void loadArchivesToWrite(String fichero) throws IOException{
        try {   
            ficheroSalida= new FileOutputStream(fichero);
            objetoSalida = new ObjectOutputStream(ficheroSalida);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void loadArchivesToRead(String fichero) throws IOException{
        try {   
         ficheroEntrada = new FileInputStream(fichero);
         objetoEntrada = new ObjectInputStream(ficheroEntrada);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   

}
