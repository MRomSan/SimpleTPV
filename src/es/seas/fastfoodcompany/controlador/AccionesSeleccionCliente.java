/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.controlador;

import es.seas.fastfoodcompany.config.ModeloTabla;
import es.seas.fastfoodcompany.gestionbd.ServiceCliente;
import es.seas.fastfoodcompany.modelo.entidades.Cliente;
import es.seas.fastfoodcompany.vistas.FrmSeleccionCliente;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 * Clase que controla las acciones de Selección de Cliente
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class AccionesSeleccionCliente {
    private FrmSeleccionCliente panel;
    private ModeloTabla tabla;

    /**
     * Constructor predeterminado
     *
     * @param panel FrmSeleccionCliente al que pertenecen las acciones
     */
    public AccionesSeleccionCliente(FrmSeleccionCliente panel) {
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
        
        clientes = clienteDAO.findAll();
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
     * Guarda el cliente seleccionado en una variable de la clase 
     * FrmSeleccionCliente y cierra la pantalla
     */
    public void SeleccionarCliente() {
        ServiceCliente clienteDAO = new ServiceCliente();
        int[] filasSeleccionadas;
        
        filasSeleccionadas = panel.getTablaClientes().getSelectedRows();
        if (filasSeleccionadas.length == 0) {
            JOptionPane.showMessageDialog(null, "No hay registro seleccionado");
        } else {
            int idCliente;
            idCliente = (int) panel.getTablaClientes().
                    getValueAt(filasSeleccionadas[0], 0);

            panel.setClienteSeleccionado(clienteDAO.findById(idCliente));
            panel.dispose();
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
        
        clientes = clienteDAO.buscar(texto);
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
