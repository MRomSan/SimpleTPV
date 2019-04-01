/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.controlador;

import es.seas.fastfoodcompany.config.ModeloTabla;
import es.seas.fastfoodcompany.gestionbd.ServiceIva;
import es.seas.fastfoodcompany.modelo.entidades.Iva;
import es.seas.fastfoodcompany.vistas.PanelEditarIVA;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 * Clase que controla las acciones de edición de ivas
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class AccionesEditarIVA {
    private PanelEditarIVA panel;
    private ModeloTabla tabla;

    /**
     * Constructor predeterminado
     *
     * @param panel PanelEditarIVA al que pertenecen las acciones
     */
    public AccionesEditarIVA(PanelEditarIVA panel) {
        this.panel = panel;
    }
    
    /**
     * Método que inicializa y carga los valores en la tabla.
     */
    public void InicializaTabla() {
        //Modelo
        tabla = new ModeloTabla(new String[]{
            "ID", "Nombre", "Descripción"}, 0);
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
        
        ivas = ivaDAO.findAll();
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
     * Método que carga, en el panel de datos de IVAs, el IVA 
     * seleccionado en la tabla
     */
    public void CargaIVASeleccionado() {
        int filaSeleccionada = panel.getTablaIVA().getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "No hay registros seleccionados");
        } else {
            Iva iva = new Iva();
            ServiceIva ivaDAO = new ServiceIva();
            iva = ivaDAO.findById((int) panel.getTablaIVA().
                        getValueAt(filaSeleccionada, 0));
            
            habilitaCampos(true);
            
            panel.getLblID().setText(Integer.toString(iva.getId()));
            panel.getTxtNombre().setText(iva.getNombre());
            panel.getTxtCantidad().setText(Float.toString(iva.getCantidad()).
                                                replace('.', ','));
        }
    }
    
    /**
     * Método que actualiza el IVA en la base de datos y por pantalla
     */
    public void ActualizaIVA() {
        if (panel.getLblID().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay registro cargado");
        } else {
            if(ValidaCampos()){
                ServiceIva ivaDAO = new ServiceIva();
                Iva iva = new Iva();

                iva.setId(Integer.parseInt(panel.getLblID().getText()));
                iva.setNombre(panel.getTxtNombre().getText());
                iva.setCantidad(Float.parseFloat(
                                        panel.getTxtCantidad().getText().
                                                    replace(',', '.')));
                
                ivaDAO.update(iva);

                panel.getLblID().setText("");
                panel.getTxtNombre().setText("");
                panel.getTxtCantidad().setText("");
                panel.getTxtCantidad().setValue(null);
                JOptionPane.showMessageDialog(null, "IVA actualizado: " 
                        + iva.toString());
                tabla.setNumRows(0);
                BuscarIVA(panel.getTxtBuscar().getText());
                habilitaCampos(false);
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
        
        ivas = ivaDAO.buscar(texto);
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
    
    //Validación de campos
    private boolean ValidaCampos() {
        try {
            Exception excNombreVacio = new Exception("Campo Nombre vacío");
            Exception excCantidadVacio = new Exception("Campo Cantidad vacío");

            //Validación campo no vacío
            if (panel.getTxtNombre().getText().trim().isEmpty()) 
                throw excNombreVacio;
            if (panel.getTxtCantidad().getText().trim().isEmpty()) 
                throw excCantidadVacio;
            
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Campo vacío", 0);
        }
        return false;
    }
    
    //Pinta de nuevo la tabla
    private void PintaTabla() {
        panel.getTablaIVA().setModel(tabla);
        panel.getTablaIVA().getColumnModel().getColumn(0).setPreferredWidth(0);
        panel.getTablaIVA().getColumnModel().getColumn(0).setMaxWidth(0);
        panel.getTablaIVA().getColumnModel().getColumn(0).setMinWidth(0);
        panel.getPanelTabla().setViewportView(panel.getTablaIVA());
    }
    
    /**
     * Habilita o deshabilita los componentes del panel "panelDatos"
     *
     * @param habilitar boolean True/False
     */
    public void habilitaCampos(boolean habilitar) {
        for (int i = 0; i < panel.getPanelDatos().getComponents().length; i++) {
            panel.getPanelDatos().getComponent(i).setEnabled(habilitar);
        }
    }
}
