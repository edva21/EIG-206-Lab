/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;


import Interfaz.Dispatcher;
import Interfaz.InterfazAdministrador;
import Interfaz.InterfazCiclo;
import LogicaDeNegocio.Carrera;
import LogicaDeNegocio.Estudiante;
import Modelo.Modelo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.stream.Collectors;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author edva5
 */
public class Control implements ActionListener{
    private Modelo modelo;
    private Dispatcher dispatcher;  

    

    public Control(Modelo modelo, Dispatcher dispatcher) {
        this.modelo = modelo;
        this.dispatcher = dispatcher;
        this.dispatcher.dispatcherRequest(Dispatcher.LOGIN, modelo, this);
        
    }        

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            switch(e.getActionCommand()){
                case "LogIn":
                    if (!dispatcher.getInterfazLogIn().getjCheckBoxs().isEmpty()) {                                                                
                    switch(dispatcher.getInterfazLogIn().getjCheckBoxs().stream().filter(x->x.isSelected()).collect(Collectors.toList()).get(0).getActionCommand()){
                        case Interfaz.InterfazLogIn.ADMINISTRADOR:
                            dispatcher.getInterfazLogIn().dispose();
                            dispatcher.dispatcherRequest(Dispatcher.MENUADMINISTRADOR, modelo, this);
                            break;
                        case Interfaz.InterfazLogIn.ESTUDIANTE:
                            dispatcher.getInterfazLogIn().dispose();
                            dispatcher.dispatcherRequest(Dispatcher.MENUESTUDIANTE, modelo, this);
                            break;
                        case Interfaz.InterfazLogIn.MATRICULADOR:
                            dispatcher.getInterfazLogIn().dispose();
                            dispatcher.dispatcherRequest(Dispatcher.MENUMATRICULADOR, modelo, this);
                            break;
                        default:
                            break;
                    }
                     }
                    break;
                case InterfazAdministrador.MANTENIMIENTO_ADMINISTRADOR:
                    this.dispatcher.dispatcherRequest(Dispatcher.ADMINISTRADOR, modelo, this);
                    this.dispatcher.getInterfazAdministrador().getDefaultTableModel().setColumnIdentifiers(LogicaDeNegocio.Administrador.getClassNames());
                    this.dispatcher.getInterfazAdministrador().setTitle(InterfazAdministrador.MANTENIMIENTO_ADMINISTRADOR);
                    this.dispatcher.getInterfazAdministrador().addButtonsToTable();
                    break;
                case Interfaz.InterfazCarrera.MANTENIMIENTO_CARRERA:
                    this.dispatcher.dispatcherRequest(Dispatcher.CARRERA, modelo, this);
                    break;
                case Interfaz.InterfazCiclo.MANTENIMIENTO_CICLO:
                    this.dispatcher.dispatcherRequest(Dispatcher.CICLO, modelo, this);
                    break;
                case Interfaz.InterfazCurso.MANTENIMIENTO_CURSO:
                    this.dispatcher.dispatcherRequest(Dispatcher.CURSO, modelo, this);
                    break;
                case Interfaz.InterfazGrupo.MANTENIMIENTO_GRUPO:
                    this.dispatcher.dispatcherRequest(Dispatcher.GRUPO, modelo, this);
                    break;                
                case Interfaz.InterfazMatriculador.MANTENIMIENTO_MATRICULADOR:
                    this.dispatcher.dispatcherRequest(Dispatcher.MATRICULADOR, modelo, this);
                    this.dispatcher.getInterfazMatriculador().getDefaultTableModel().setColumnIdentifiers(LogicaDeNegocio.Matriculador.getClassNames());
                    this.dispatcher.getInterfazMatriculador().setTitle(Interfaz.InterfazMatriculador.MANTENIMIENTO_MATRICULADOR);
                    this.dispatcher.getInterfazMatriculador().addButtonsToTable();
                    break;
                case Interfaz.InterfazNota.MANTENIMIENTO_NOTA:
                    this.dispatcher.dispatcherRequest(Dispatcher.NOTA, modelo, this);
                    break;
                case Interfaz.InterfazProfesor.MANTENIMIENTO_PROFESOR:
                    this.dispatcher.dispatcherRequest(Dispatcher.PROFESOR, modelo, this);
                    this.dispatcher.getInterfazProfesor().getDefaultTableModel().setColumnIdentifiers(LogicaDeNegocio.Profesor.getClassNames());
                    this.dispatcher.getInterfazProfesor().setTitle(Interfaz.InterfazProfesor.MANTENIMIENTO_PROFESOR);
                    this.dispatcher.getInterfazProfesor().addButtonsToTable();
                    break;
                case Interfaz.InterfazEstudiante.MANTENIMIENTO_ESTUDIANTE:
                    this.dispatcher.dispatcherRequest(Dispatcher.ESTUDIANTE, modelo, this);
                    this.dispatcher.getInterfazEstudiante().getDefaultTableModel().setColumnIdentifiers(LogicaDeNegocio.Estudiante.getClassNames());
                    this.dispatcher.getInterfazEstudiante().setTitle(Interfaz.InterfazEstudiante.MANTENIMIENTO_ESTUDIANTE);
                    this.dispatcher.getInterfazEstudiante().addButtonsToTable();
                    break;
                case Interfaz.InterfazLogIn.LOGIN:
                    this.dispatcher.dispatcherRequest(Dispatcher.LOGIN, modelo, this);
                    break;
                default:
                    break;
            }
        }
    }
    
}
