/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.controlador;

import es.seas.fastfoodcompany.config.ModeloTabla;
import es.seas.fastfoodcompany.gestionbd.ServiceIva;
import es.seas.fastfoodcompany.modelo.entidades.Iva;
import es.seas.fastfoodcompany.vistas.PanelBajaIVA;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 * Clase que controla las acciones de bajas de IVAs
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class AccionesBajaIVA {
    private PanelBajaIVA panel;
    private ModeloTabla tabla;

    /**
     * Constructor predeterminado
     *
     * @param panel PanelBajaIVA al que pertenecen las acciones
     */
    public AccionesBajaIVA(PanelBajaIVA panel) {
        this.panel = panel;
    }
    
    /**
     * Método que inicializa y carga los valores en la tabla.
     */
    public void InicializaTabla() {
        //Modelo
        tabla = new ModeloTabla(new String[]{
            "ID", "Nombre", "Cantidad"}, 0);
        PintaTabla();
        //Datos
        CargaDatosTabla();
    }

    /**
     * Método que carga los valores en la tabla
     */
    public void CargaDatosTabla() {
        ServiceIva ivaDAO = new ServiceIva();
        List<Iva> ivas = new ArrayList<Iva>();
        
        ivas = ivaDAO.findEliminables();
        for (Iva ivaActual : ivas) {
            Vector filaTabla = new Vector();
            filaTabla.add(ivaActual.getId());
            filaTabla.add(ivaActual.getNombre());
            filaTabla.add(Float.toString(ivaActual.getCantidad()).
                                    replace('.', ','));
            tabla.addRow(filaTabla);
        }
        PintaTabla();
    }
    
    /**
     * Método que elimina los IVAs seleccionados en la tabla
     */
    public void EliminarIVAs() {
        ServiceIva ivaDAO = new ServiceIva();
        int[] filasSeleccionadas;
        
        filasSeleccionadas = panel.getTablaIVA().getSelectedRows();
        if (filasSeleccionadas.length == 0) {
            JOptionPane.showMessageDialog(null, "No hay registros seleccionados");
        } else {
            int confirmacion;
            confirmacion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar"
                    + " (" + filasSeleccionadas.length + 
                    ") registro(s) seleccionados?");
            if (confirmacion == JOptionPane.YES_OPTION) {
                for (int i = filasSeleccionadas.length-1; i >= 0; i--) {
                    int idIva;
                    idIva = (int) panel.getTablaIVA().
                            getValueAt(filasSeleccionadas[i], 0);
                    ivaDAO.delete(idIva);
                    tabla.removeRow(filasSeleccionadas[i]);
                }
                PintaTabla();
            }
        }
    }
    
    /**
     * Método que busca los IVAs cuyos campos coincidan total o parcialmente 
     * con el texto introducido
     *
     * @param texto String
     */
    public void BuscarIVA(String texto) {
        ServiceIva ivaDAO = new ServiceIva();
        List<Iva> ivas = new ArrayList<Iva>();
        
        ivas = ivaDAO.buscarEliminables(texto);
        tabla.setNumRows(0);
        for (Iva ivaActual : ivas) {
            Vector filaTabla = new Vector();
            filaTabla.add(ivaActual.getId());
            filaTabla.add(ivaActual.getNombre());
            filaTabla.add(Float.toString(ivaActual.getCantidad()).
                                    replace('.', ','));
            tabla.addRow(filaTabla);
        }
        PintaTabla();
    }
    
    //Pinta de nuevo la tabla
    private void PintaTabla() {
        panel.getTablaIVA().setModel(tabla);
        panel.getTablaIVA().getColumnModel().getColumn(0).setPreferredWidth(0);
        panel.getTablaIVA().getColumnModel().getColumn(0).setMaxWidth(0);
        panel.getTablaIVA().getColumnModel().getColumn(0).setMinWidth(0);
        panel.getPanelTabla().setViewportView(panel.getTablaIVA());
    }
}
