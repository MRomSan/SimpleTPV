/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.controlador;

import es.seas.fastfoodcompany.modelo.entidades.Cliente;
import es.seas.fastfoodcompany.gestionbd.ServiceCliente;
import es.seas.fastfoodcompany.vistas.PanelBajaClientes;
import es.seas.fastfoodcompany.config.ModeloTabla;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 * Clase que controla las acciones de bajas de clientes
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class AccionesBajaClientes {
    private PanelBajaClientes panel;
    private ModeloTabla tabla;

    /**
     * Constructor predeterminado
     *
     * @param panel PanelBajaClientes al que pertenecen las acciones
     */
    public AccionesBajaClientes(PanelBajaClientes panel) {
        this.panel = panel;
    }
    
    /**
     * Método que inicializa y carga los valores en la tabla.
     */
    public void InicializaTabla() {
        //Modelo
        tabla = new ModeloTabla(new String[]{
            "ID", "Apellido1", "Apellido2", "Nombre", "DNI"}, 0);
        PintaTabla();
        //Datos
        CargaDatosTabla();
    }

    /**
     * Método que carga los valores en la tabla
     */
    public void CargaDatosTabla() {
        ServiceCliente clienteDAO = new ServiceCliente();
        List<Cliente> clientes = new ArrayList<Cliente>();
        
        clientes = clienteDAO.findEliminables();
        for (Cliente clienteActual : clientes) {
            Vector filaTabla = new Vector();
            filaTabla.add(clienteActual.getId());
            filaTabla.add(clienteActual.getApellido1());
            filaTabla.add(clienteActual.getApellido2());
            filaTabla.add(clienteActual.getNombre());
            filaTabla.add(clienteActual.getDni());
            tabla.addRow(filaTabla);
        }
        PintaTabla();
    }
    
    /**
     * Método que elimina los clientes seleccionados en la tabla
     */
    public void EliminarClientes() {
        ServiceCliente clienteDAO = new ServiceCliente();
        int[] filasSeleccionadas;
        
        filasSeleccionadas = panel.getTablaClientes().getSelectedRows();
        if (filasSeleccionadas.length == 0) {
            JOptionPane.showMessageDialog(null, "No hay registros seleccionados");
        } else {
            int confirmacion;
            confirmacion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar"
                    + " (" + filasSeleccionadas.length + 
                    ") registro(s) seleccionados?");
            if (confirmacion == JOptionPane.YES_OPTION) {
                for (int i = filasSeleccionadas.length-1; i >= 0; i--) {
                    int idCliente;
                    idCliente = (int) panel.getTablaClientes().
                            getValueAt(filasSeleccionadas[i], 0);
                    clienteDAO.delete(idCliente);
                    tabla.removeRow(filasSeleccionadas[i]);
                }
                PintaTabla();
            }
        }
    }
    
    /**
     * Método que busca los clientes cuyos campos coincidan total o parcialmente
     * con el texto introducido
     *
     * @param texto String
     */
    public void BuscarClientes(String texto) {
        ServiceCliente clienteDAO = new ServiceCliente();
        List<Cliente> clientes = new ArrayList<Cliente>();
        
        clientes = clienteDAO.buscarEliminables(texto);
        tabla.setNumRows(0);
        for (Cliente clienteActual : clientes) {
            Vector filaTabla = new Vector();
            filaTabla.add(clienteActual.getId());
            filaTabla.add(clienteActual.getApellido1());
            filaTabla.add(clienteActual.getApellido2());
            filaTabla.add(clienteActual.getNombre());
            filaTabla.add(clienteActual.getDni());
            tabla.addRow(filaTabla);
        }
        PintaTabla();
    }
    
    //Pinta de nuevo la tabla
    private void PintaTabla() {
        panel.getTablaClientes().setModel(tabla);
        panel.getTablaClientes().getColumnModel().getColumn(0).setPreferredWidth(0);
        panel.getTablaClientes().getColumnModel().getColumn(0).setMaxWidth(0);
        panel.getTablaClientes().getColumnModel().getColumn(0).setMinWidth(0);
        panel.getPanelTabla().setViewportView(panel.getTablaClientes());
    }
}
