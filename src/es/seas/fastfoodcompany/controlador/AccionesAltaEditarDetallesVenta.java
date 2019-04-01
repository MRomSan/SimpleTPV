/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.controlador;

import es.seas.fastfoodcompany.gestionbd.ServiceProducto;
import es.seas.fastfoodcompany.modelo.entidades.DetallesVenta;
import es.seas.fastfoodcompany.modelo.entidades.Producto;
import es.seas.fastfoodcompany.vistas.FrmSeleccionProducto;
import es.seas.fastfoodcompany.vistas.PanelAltaEditarDetalleVenta;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 * Clase que controla las acciones de altas de Detalles de Venta
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class AccionesAltaEditarDetallesVenta {
    private final PanelAltaEditarDetalleVenta panel;
    
    /**
     * Constructor predeterminado
     *
     * @param panel Panel al que están enlazadas las acciones de Detalles de 
     * Venta
     */
    public AccionesAltaEditarDetallesVenta(PanelAltaEditarDetalleVenta panel) {
        this.panel = panel;
    }
    
    /**
     * Carga un detalle de venta para su modificación
     * @param detalleVenta DetallesVenta Detalle de Venta a cargar
     */
    public void cargarDetalleVenta(DetallesVenta detalleVenta) {
        ServiceProducto productoDAO = new ServiceProducto();

        Producto producto = new Producto();

        panel.getLblTitulo().setText("Editar Detalle Venta");
        panel.getBtnGuardar().setVisible(false);
        panel.getBtnActualizar().setVisible(true);

        panel.setDetVentaModificado(detalleVenta);

        producto = productoDAO.findById(detalleVenta.getId_producto());
        panel.setProductoSeleccionado(producto);
        panel.getTxtProducto().setText(producto.getNombre());
        panel.getTxtPrecio().setText(Float.toString(producto.getPrecio()).
                                                            replace('.', ','));
        panel.getTxtCantidad().setText(Float.toString(
                                detalleVenta.getCantidad()).replace('.', ','));
        panel.getTxtDescuento().setText(Float.toString(
                        detalleVenta.getDescuento_linea()).replace('.', ','));
    }
    
    /**
     * Procedimiento para guardar un Detalle de Venta en la base de datos
     */
    public void Guardar() {
        if (ValidaCampos()) {
            DetallesVenta detalleVenta = new DetallesVenta();
            DetallesVenta detalleExistente;
            double precioLinea;
            
            detalleExistente = buscaSiDetalleExiste();
            
            if(detalleExistente != null) {
                //Si ya eiste el producto en la venta lo actualiza sumándole
                //la cantidad introducida por pantalla
                detalleExistente.setCantidad(detalleExistente.getCantidad() + 
                                    Float.parseFloat(panel.getTxtCantidad().
                                        getText().replace(',', '.')));

                if (!panel.getTxtDescuento().getText().equals(""))
                    detalleExistente.setDescuento_linea(Float.parseFloat(panel.
                                getTxtDescuento().getText().replace(',', '.')));
                else detalleExistente.setDescuento_linea(Float.parseFloat("0.0"));

                //Precio por cantidad
                precioLinea = Float.parseFloat(panel.getTxtPrecio().
                                                    getText().replace(',', '.'))
                        * detalleExistente.getCantidad();
                //Aplico el descuento
                precioLinea = precioLinea - 
                        (precioLinea * detalleExistente.getDescuento_linea()) 
                        / 100;

                //Redondeo a dos decimales
                precioLinea = Math.round(precioLinea*100.0)/100.0;

                detalleExistente.setPrecio_linea(
                        Float.parseFloat(Double.toString(precioLinea)));

                JOptionPane.showMessageDialog(null, "Se ha actualizado un "
                        + "detalle de venta que ya contenía este producto");

                SwingUtilities.getWindowAncestor(panel).dispose();
            } else {
                //Si no existe el producto en la venta inserta un detalle nuevo 
                detalleVenta.setId_venta(panel.getVenta().getId());
                detalleVenta.setId_producto(
                                    panel.getProductoSeleccionado().getId());
                detalleVenta.setCantidad(Float.parseFloat(
                        panel.getTxtCantidad().getText().replace(',', '.')));

                if (!panel.getTxtDescuento().getText().equals(""))
                    detalleVenta.setDescuento_linea(Float.parseFloat(panel.
                                getTxtDescuento().getText().replace(',', '.')));
                else detalleVenta.setDescuento_linea(Float.parseFloat("0.0"));

                //Precio por cantidad
                precioLinea = Float.parseFloat(panel.getTxtPrecio().
                                                    getText().replace(',', '.'))
                        * detalleVenta.getCantidad();
                //Aplico el descuento
                precioLinea = precioLinea - 
                        (precioLinea * detalleVenta.getDescuento_linea()) / 100;

                //Redondeo a dos decimales
                precioLinea = Math.round(precioLinea*100.0)/100.0;

                detalleVenta.setPrecio_linea(
                        Float.parseFloat(Double.toString(precioLinea)));

                panel.getDetallesVentaExistentes().add(detalleVenta);

                JOptionPane.showMessageDialog(null, "Detalle de venta agregado");

                SwingUtilities.getWindowAncestor(panel).dispose();
            }
        }
    }
    
    /**
     * Procedimiento para actualizar un Detalle de Venta en la base de datos
     */
    public void Actualizar() {
        if (ValidaCampos()) {
            DetallesVenta detalleVenta;
            double precioLinea;
            
            detalleVenta = panel.getDetVentaModificado();
            
            detalleVenta.setCantidad(Float.parseFloat(panel.getTxtCantidad().
                                                getText().replace(',', '.')));
            
            if (!panel.getTxtDescuento().getText().equals(""))
                detalleVenta.setDescuento_linea(Float.parseFloat(panel.
                            getTxtDescuento().getText().replace(',', '.')));
            else detalleVenta.setDescuento_linea(Float.parseFloat("0.0"));
            
            //Precio por cantidad
            precioLinea = Float.parseFloat(panel.getTxtPrecio().
                                                getText().replace(',', '.')) * 
                    Float.parseFloat(panel.getTxtCantidad().
                                                getText().replace(',', '.'));
            //Aplico el descuento
            precioLinea = precioLinea - 
                    (precioLinea * detalleVenta.getDescuento_linea()) / 100;
            
            //Redondeo a dos decimales
            precioLinea = Math.round(precioLinea*100.0)/100.0;
            
            detalleVenta.setPrecio_linea(
                    Float.parseFloat(Double.toString(precioLinea)));
            
            JOptionPane.showMessageDialog(null, "Detalle de venta actualizado");
            
            SwingUtilities.getWindowAncestor(panel).dispose();
        }
    }
    
    //Busca si el detalle de venta ya existe en esta Venta
    private DetallesVenta buscaSiDetalleExiste() {
        for(DetallesVenta detalleActual : panel.getDetallesVentaExistentes()){
            if(detalleActual.getId_producto() == 
                    panel.getProductoSeleccionado().getId()) {
                return detalleActual;
            }
        }
        return null;
    }
    
    /**
     * Crea un JDialog FrmSeleccionProducto para seleccionar un producto de los 
     * disponibles en la base de datos y lo almacena en una variable de la clase 
     * PanelAltaDetallesVenta
     */
    public void BuscarProducto() {
        DetallesVenta detVentaExistente;
        FrmSeleccionProducto seleccionarProducto = new FrmSeleccionProducto(
            (JDialog) SwingUtilities.getWindowAncestor(panel), true);
        seleccionarProducto.setLocationRelativeTo(null);
        seleccionarProducto.setVisible(true);
        
        if (seleccionarProducto.getProductoSeleccionado() != null) {
            panel.setProductoSeleccionado(seleccionarProducto.
                    getProductoSeleccionado());
            panel.getTxtProducto().setText(panel.getProductoSeleccionado().
                    getNombre());
            panel.getTxtPrecio().setText(Float.toString(panel.
                    getProductoSeleccionado().getPrecio()).replace('.', ','));
            
            detVentaExistente = buscaSiDetalleExiste();
            if(detVentaExistente != null)
                panel.getTxtDescuento().setText(Float.toString(
                        detVentaExistente.getDescuento_linea()).
                            replace('.', ','));
        }
    }
    
    //Validación de campos
    private boolean ValidaCampos() {
        try {
            Exception excProductoVacio = new Exception("Seleccione un producto");
            Exception excCantidadVacio = new Exception("Campo Cantidad vacío");
            
            //Validación de campos
            if (panel.getTxtProducto().getText().trim().isEmpty()) 
                throw excProductoVacio;
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
