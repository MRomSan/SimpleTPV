/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.controlador;

import es.seas.fastfoodcompany.config.ModeloTabla;
import es.seas.fastfoodcompany.gestionbd.ServiceEmpleado;
import es.seas.fastfoodcompany.modelo.entidades.Empleado;
import es.seas.fastfoodcompany.vistas.FrmSeleccionEmpleado;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class AccionesSeleccionEmpleado {
    private FrmSeleccionEmpleado panel;
    private ModeloTabla tabla;

    /**
     * Constructor predeterminado
     *
     * @param panel FrmSeleccionEmpleado al que pertenecen las acciones
     */
    public AccionesSeleccionEmpleado(FrmSeleccionEmpleado panel) {
        this.panel = panel;
    }
    
    /**
     * Método que inicializa y carga los valores en la tabla.
     */
    public void InicializaTabla() {
        //Modelo
        tabla = new ModeloTabla(new String[]{
            "ID", "Apellido1", "Apellido2", "Nombre", "DNI", "Usuario", 
            "Administrador"}, 0);
        PintaTabla();
        //Datos
        CargaDatosTabla();
    }

    /**
     * Método que carga los valores en la tabla
     */
    public void CargaDatosTabla() {
        ServiceEmpleado empleadoDAO = new ServiceEmpleado();
        List<Empleado> empleados = new ArrayList<Empleado>();
        
        empleados = empleadoDAO.findAll();
        for (Empleado empleadoActual : empleados) {
            Vector filaTabla = new Vector();
            filaTabla.add(empleadoActual.getId());
            filaTabla.add(empleadoActual.getApellido1());
            filaTabla.add(empleadoActual.getApellido2());
            filaTabla.add(empleadoActual.getNombre());
            filaTabla.add(empleadoActual.getDni());
            filaTabla.add(empleadoActual.getUsername());
            filaTabla.add((empleadoActual.isAdministrador())?"Sí":"No");
            tabla.addRow(filaTabla);
        }
        PintaTabla();
    }
    
    /**
     * Guarda el cliente seleccionado en una variable de la clase 
     * FrmSeleccionEmpleado y cierra la pantalla
     */
    public void SeleccionarEmpleado() {
        ServiceEmpleado empleadoDAO = new ServiceEmpleado();
        int[] filasSeleccionadas;
        
        filasSeleccionadas = panel.getTablaEmpleados().getSelectedRows();
        if (filasSeleccionadas.length == 0) {
            JOptionPane.showMessageDialog(null, "No hay registro seleccionado");
        } else {
            int idEmpleado;
            idEmpleado = (int) panel.getTablaEmpleados().
                    getValueAt(filasSeleccionadas[0], 0);

            panel.setEmpleadoSeleccionado(empleadoDAO.findById(idEmpleado));
            panel.dispose();
        }
    }
    
    /**
     * Método que busca los empleados cuyos campos coincidan total o 
     * parcialmente con el texto introducido
     *
     * @param texto String
     */
    public void BuscarEmpleados(String texto) {
        ServiceEmpleado empleadoDAO = new ServiceEmpleado();
        List<Empleado> empleados = new ArrayList<Empleado>();
        
        empleados = empleadoDAO.buscar(texto);
        tabla.setNumRows(0);
        for (Empleado empleadoActual : empleados) {
            Vector filaTabla = new Vector();
            filaTabla.add(empleadoActual.getId());
            filaTabla.add(empleadoActual.getApellido1());
            filaTabla.add(empleadoActual.getApellido2());
            filaTabla.add(empleadoActual.getNombre());
            filaTabla.add(empleadoActual.getDni());
            filaTabla.add(empleadoActual.getUsername());
            filaTabla.add((empleadoActual.isAdministrador())?"Sí":"No");
            tabla.addRow(filaTabla);
        }
        PintaTabla();
    }
    
    //Pinta de nuevo la tabla
    private void PintaTabla() {
        panel.getTablaEmpleados().setModel(tabla);
        panel.getTablaEmpleados().getColumnModel().getColumn(0).setPreferredWidth(0);
        panel.getTablaEmpleados().getColumnModel().getColumn(0).setMaxWidth(0);
        panel.getTablaEmpleados().getColumnModel().getColumn(0).setMinWidth(0);
        panel.getPanelTabla().setViewportView(panel.getTablaEmpleados());
    }
}
