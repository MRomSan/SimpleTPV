/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.controlador;

import es.seas.fastfoodcompany.config.ModeloTabla;
import es.seas.fastfoodcompany.gestionbd.ServiceDetallesVenta;
import es.seas.fastfoodcompany.gestionbd.ServiceVenta;
import es.seas.fastfoodcompany.modelo.entidades.Venta;
import es.seas.fastfoodcompany.vistas.PanelBajaVentas;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 * Clase que controla las acciones de bajas de ventas
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class AccionesBajaVentas {
    private PanelBajaVentas panel;
    private ModeloTabla tabla;

    /**
     * Constructor predeterminado
     *
     * @param panel PanelBajaVentas al que pertenecen las acciones
     */
    public AccionesBajaVentas(PanelBajaVentas panel) {
        this.panel = panel;
    }
    
    /**
     * Método que inicializa y carga los valores en la tabla.
     */
    public void InicializaTabla() {
        //Modelo
        tabla = new ModeloTabla(new String[]{
            "ID", "Fecha", "Hora", "Forma Pago", "Total (€)", "Entregado (€)"}, 
                0);
        PintaTabla();
        //Datos
        CargaDatosTabla();
    }

    /**
     * Método que carga los valores en la tabla
     */
    public void CargaDatosTabla() {
        ServiceVenta ventaDAO = new ServiceVenta();
        List<Venta> ventas = new ArrayList<Venta>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        ventas = ventaDAO.findAll();
        for (Venta ventaActual : ventas) {
            Vector filaTabla = new Vector();
            filaTabla.add(ventaActual.getId());
            java.util.Date utilDate = new java.util.Date(
                                            ventaActual.getFecha().getTime());
            filaTabla.add(sdf.format(utilDate));
            filaTabla.add(ventaActual.getHora());
            filaTabla.add(ventaActual.getForma_pago());
            filaTabla.add(Float.toString(ventaActual.getTotal()).
                                            replace('.', ','));
            filaTabla.add(Float.toString(ventaActual.getEntregado()).
                                            replace('.', ','));
            tabla.addRow(filaTabla);
        }
        PintaTabla();
    }
    
    /**
     * Método que elimina las ventas seleccionadas en la tabla
     */
    public void EliminarVentas() {
        int[] filasSeleccionadas;
        
        filasSeleccionadas = panel.getTablaVentas().getSelectedRows();
        if (filasSeleccionadas.length == 0) {
            JOptionPane.showMessageDialog(null, "No hay registros seleccionados");
        } else {
            int confirmacion;
            confirmacion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar"
                    + " (" + filasSeleccionadas.length + 
                    ") registro(s) seleccionados?");
            if (confirmacion == JOptionPane.YES_OPTION) {
                for (int i = filasSeleccionadas.length-1; i >= 0; i--) {
                    int idVenta;
                    ServiceVenta ventaDAO = new ServiceVenta();
                    ServiceDetallesVenta detallesVentaDAO = new ServiceDetallesVenta();
                    idVenta = (int) panel.getTablaVentas().
                            getValueAt(filasSeleccionadas[i], 0);
                    detallesVentaDAO.deleteByVenta(idVenta);
                    ventaDAO.delete(idVenta);
                    tabla.removeRow(filasSeleccionadas[i]);
                }
                PintaTabla();
            }
        }
    }
    
    /**
     * Método que busca las ventas cuyos campos coincidan total o 
     * parcialmente con el texto introducido
     *
     * @param texto String
     */
    public void BuscarVentas(String texto) {
        ServiceVenta ventaDAO = new ServiceVenta();
        List<Venta> ventas = new ArrayList<Venta>();
        
        ventas = ventaDAO.buscar(texto, null, null);
        tabla.setNumRows(0);
        for (Venta ventaActual : ventas) {
            Vector filaTabla = new Vector();
            filaTabla.add(ventaActual.getId());
            filaTabla.add(ventaActual.getFecha());
            filaTabla.add(ventaActual.getHora());
            filaTabla.add(ventaActual.getForma_pago());
            filaTabla.add(ventaActual.getTotal());
            filaTabla.add(ventaActual.getEntregado());
            tabla.addRow(filaTabla);
        }
        PintaTabla();
    }
    
    //Pinta de nuevo la tabla
    private void PintaTabla() {
        panel.getTablaVentas().setModel(tabla);
        panel.getTablaVentas().getColumnModel().getColumn(0).setPreferredWidth(0);
        panel.getTablaVentas().getColumnModel().getColumn(0).setMaxWidth(0);
        panel.getTablaVentas().getColumnModel().getColumn(0).setMinWidth(0);
        panel.getPanelTabla().setViewportView(panel.getTablaVentas());
    }
    
}
