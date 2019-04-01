/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.controlador;

import es.seas.fastfoodcompany.gestionbd.ServiceIva;
import es.seas.fastfoodcompany.modelo.entidades.Iva;
import es.seas.fastfoodcompany.vistas.PanelAltaIVA;
import javax.swing.JOptionPane;

/**
 * Clase que controla las acciones de altas de IVAs
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class AccionesAltaIVA {
    private final PanelAltaIVA panel;
    
    /**
     * Constructor predeterminado
     *
     * @param panel Panel al que están enlazadas las acciones de IVAs
     */
    public AccionesAltaIVA(PanelAltaIVA panel) {
        this.panel = panel;
    }
    
    /**
     * Procedimiento para guardar un IVA en la base de datos
     */
    public void Guardar() {
        if (ValidaCampos()) {
            ServiceIva ivaDAO = new ServiceIva();
            Iva iva = new Iva();
            iva.setNombre(panel.getTxtNombre().getText());
            iva.setCantidad(Float.parseFloat(panel.getTxtCantidad().
                                                getText().replace(',', '.')));
            ivaDAO.insert(iva);
            panel.getTxtNombre().setText("");
            panel.getTxtCantidad().setText("");
            panel.getTxtCantidad().setValue(null);
            JOptionPane.showMessageDialog(null, "Iva guardado: " +
                        iva.toString());
        }
    }
    
    //Validación de campos
    private boolean ValidaCampos() {
        try {
            Exception excNombreVacio = new Exception("Campo Nombre vacío");
            Exception excCantidadVacio = new Exception("Campo Cantidad vacío");
            
            //Validación de campos
            if (panel.getTxtNombre().getText().trim().isEmpty()) 
                throw excNombreVacio;
            if (panel.getTxtCantidad().getText().trim().isEmpty()) 
                throw excCantidadVacio;
            
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), 
                    "Dato incorrecto", 0);
        }
        return false;
    }
}
