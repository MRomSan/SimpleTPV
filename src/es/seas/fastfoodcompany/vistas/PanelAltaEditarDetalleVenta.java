/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.vistas;

import es.seas.fastfoodcompany.controlador.AccionesAltaEditarDetallesVenta;
import es.seas.fastfoodcompany.modelo.entidades.DetallesVenta;
import es.seas.fastfoodcompany.modelo.entidades.Producto;
import es.seas.fastfoodcompany.modelo.entidades.Venta;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * Pantalla de alta y edición de Detalles de Venta
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class PanelAltaEditarDetalleVenta extends javax.swing.JPanel {
    private AccionesAltaEditarDetallesVenta acciones;
    private Producto productoSeleccionado;
    private Venta venta;
    private DetallesVenta detVentaModificado;
    private List<DetallesVenta> detallesVentaExistentes;

    /**
     * Crea un nuevo formPanel PanelAltaEditarDetalleVenta
     * @param detalleVenta int Id del detalle de Venta a cargar, si es igual a 0 
     * crea uno nuevo
     */
    public PanelAltaEditarDetalleVenta(DetallesVenta detalleVenta) {
        this.acciones = new AccionesAltaEditarDetallesVenta(this);
        this.productoSeleccionado = null;
        initComponents();
        btnActualizar.setVisible(false);
        if (detalleVenta != null) {
            acciones.cargarDetalleVenta(detalleVenta);
        }
    }

    /**
     * Devuelve una Clase con las acciones de alta de Detalles de Venta
     *
     * @return AccionesAltaEditarDetallesVenta Contiene las acciones de alta
     */
    public AccionesAltaEditarDetallesVenta getAcciones() {
        return acciones;
    }

    /**
     * Establece una Clase con las acciones de alta de Detalles de Venta
     *
     * @param acciones AccionesAltaEditarDetallesVenta Contiene las acciones de alta
     */
    public void setAcciones(AccionesAltaEditarDetallesVenta acciones) {
        this.acciones = acciones;
    }

    /**
     * Devuelve el botón Buscar Producto (...)
     *
     * @return JButton
     */
    public JButton getBtnBuscarProducto() {
        return btnBuscarProducto;
    }

    /**
     * Establece el botón Buscar Producto (...)
     *
     * @param btnBuscarProducto JButton
     */
    public void setBtnBuscarProducto(JButton btnBuscarProducto) {
        this.btnBuscarProducto = btnBuscarProducto;
    }

    /**
     * Devuelve el botón Actualizar
     *
     * @return JButton
     */
    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    /**
     * Establece el botón Actualizar
     *
     * @param btnActualizar JButton
     */
    public void setBtnActualizar(JButton btnActualizar) {
        this.btnActualizar = btnActualizar;
    }
    
    /**
     * Devuelve el botón Guardar
     *
     * @return JButton
     */
    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    /**
     * Establece el botón Guardar
     *
     * @param btnGuardar JButton
     */
    public void setBtnGuardar(JButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    /**
     * Devuelve el label Cantidad
     *
     * @return JLabel
     */
    public JLabel getLblCantidad() {
        return lblCantidad;
    }

    /**
     * Establece el label Cantidad
     *
     * @param lblCantidad JLabel
     */
    public void setLblCantidad(JLabel lblCantidad) {
        this.lblCantidad = lblCantidad;
    }

    /**
     * Devuelve el label Descuento
     *
     * @return JLabel
     */
    public JLabel getLblDescuento() {
        return lblDescuento;
    }

    /**
     * Establece el label Descuento
     *
     * @param lblDescuento JLabel
     */
    public void setLblDescuento(JLabel lblDescuento) {
        this.lblDescuento = lblDescuento;
    }
    
    /**
     * Devuelve el label Precio
     *
     * @return JLabel
     */
    public JLabel getLblPrecio() {
        return lblPrecio;
    }

    /**
     * Establece el label Precio
     *
     * @param lblPrecio JLabel
     */
    public void setLblPrecio(JLabel lblPrecio) {
        this.lblPrecio = lblPrecio;
    }

    /**
     * Devuelve el label Producto
     *
     * @return JLabel
     */
    public JLabel getLblProducto() {
        return lblProducto;
    }

    /**
     * Establece el label Producto
     *
     * @param lblProducto JLabel
     */
    public void setLblProducto(JLabel lblProducto) {
        this.lblProducto = lblProducto;
    }

    /**
     * Devuelve el label Título
     *
     * @return JLabel
     */
    public JLabel getLblTitulo() {
        return lblTitulo;
    }

    /**
     * Establece el label Título
     *
     * @param lblTitulo JLabel
     */
    public void setLblTitulo(JLabel lblTitulo) {
        this.lblTitulo = lblTitulo;
    }

    /**
     * Devuelve el panel que contiene los datos del Detalle de Venta
     *
     * @return JPanel
     */
    public JPanel getPanelDatos() {
        return panelDatos;
    }

    /**
     * Establece el panel que contiene los datos del Detalle de Venta
     *
     * @param panelDatos JPanel
     */
    public void setPanelDatos(JPanel panelDatos) {
        this.panelDatos = panelDatos;
    }

    /**
     * Devuelve el campo de texto formateado Cantidad (#0.00)
     *
     * @return JFormattedTextField
     */
    public JFormattedTextField getTxtCantidad() {
        return txtCantidad;
    }

    /**
     * Establece el campo de texto formateado Cantidad (#0.00)
     *
     * @param txtCantidad JFormattedTextField
     */
    public void setTxtCantidad(JFormattedTextField txtCantidad) {
        this.txtCantidad = txtCantidad;
    }

    /**
     * Devuelve el campo de texto formateado Descuento (#0.00)
     *
     * @return JFormattedTextField
     */
    public JFormattedTextField getTxtDescuento() {
        return txtDescuento;
    }

    /**
     * Establece el campo de texto formateado Descuento (#0.00)
     *
     * @param txtDescuento JFormattedTextField
     */
    public void setTxtDescuento(JFormattedTextField txtDescuento) {
        this.txtDescuento = txtDescuento;
    }

    /**
     * Devuelve el campo de texto formateado Precio (#0.00)
     *
     * @return JFormattedTextField
     */
    public JFormattedTextField getTxtPrecio() {
        return txtPrecio;
    }

    /**
     * Establece el campo de texto formateado Precio (#0.00)
     *
     * @param txtPrecio JFormattedTextField
     */
    public void setTxtPrecio(JFormattedTextField txtPrecio) {
        this.txtPrecio = txtPrecio;
    }

    /**
     * Devuelve el campo de texto Producto
     *
     * @return JTextField
     */
    public JTextField getTxtProducto() {
        return txtProducto;
    }

    /**
     * Establece el campo de texto Producto
     *
     * @param txtProducto JTextField
     */
    public void setTxtProducto(JTextField txtProducto) {
        this.txtProducto = txtProducto;
    }
    
    /**
     * Devuelve el Producto Seleccionado con el botón Seleccionar Producto
     *
     * @return Producto
     */
    public Producto getProductoSeleccionado() {
        return productoSeleccionado;
    }

    /**
     * Establece el Producto Seleccionado con el botón Seleccionar Producto
     *
     * @param productoSeleccionado Producto
     */
    public void setProductoSeleccionado(Producto productoSeleccionado) {
        this.productoSeleccionado = productoSeleccionado;
    }

    /**
     * Devuelve los detalles de venta ya existentes en la tabla de detalles
     *
     * @return List
     */
    public List<DetallesVenta> getDetallesVentaExistentes() {
        return detallesVentaExistentes;
    }

    /**
     * Establece los detalles de venta ya existentes en la tabla de detalles
     *
     * @param detallesVentaExistentes List
     */
    public void setDetallesVentaExistentes(List<DetallesVenta> detallesVentaExistentes) {
        this.detallesVentaExistentes = detallesVentaExistentes;
    }

    /**
     * Devuelve el detalle de venta a modificar
     *
     * @return DetallesVenta
     */
    public DetallesVenta getDetVentaModificado() {
        return detVentaModificado;
    }

    /**
     * Establece el detalle de venta a modificar
     *
     * @param detVentaModificado DetallesVenta
     */
    public void setDetVentaModificado(DetallesVenta detVentaModificado) {
        this.detVentaModificado = detVentaModificado;
    }

    /**
     * Devuelve la Venta del detalle
     *
     * @return Venta
     */
    public Venta getVenta() {
        return venta;
    }

    /**
     * Establece la Venta del detalle
     *
     * @param venta Venta
     */
    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDatos = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblProducto = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        btnBuscarProducto = new javax.swing.JButton();
        lblPrecio = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JFormattedTextField();
        lblCantidad = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JFormattedTextField();
        lblDescuento = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JFormattedTextField();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitulo.setText("ALTA DETALLE VENTA");

        lblProducto.setText("Producto:");

        txtProducto.setEditable(false);

        btnBuscarProducto.setText("...");
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });

        lblPrecio.setText("Precio:");

        txtPrecio.setEditable(false);
        txtPrecio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        lblCantidad.setText("Cantidad:");

        txtCantidad.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtCantidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCantidadFocusGained(evt);
            }
        });
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        lblDescuento.setText("Descuento:");

        txtDescuento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtDescuento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDescuentoFocusGained(evt);
            }
        });
        txtDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescuentoActionPerformed(evt);
            }
        });
        txtDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescuentoKeyTyped(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(lblCantidad)
                        .addGap(10, 10, 10)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(lblDescuento)
                        .addGap(4, 4, 4)
                        .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panelDatosLayout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelDatosLayout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(btnGuardar))
                                .addComponent(btnActualizar)))
                        .addGroup(panelDatosLayout.createSequentialGroup()
                            .addComponent(lblProducto)
                            .addGap(10, 10, 10)
                            .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(btnBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblProducto))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscarProducto))
                .addGap(11, 11, 11)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblPrecio))
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblCantidad))
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblDescuento))
                    .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar)
                    .addComponent(btnActualizar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        acciones.BuscarProducto();
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        if (getBtnGuardar().isVisible())
            acciones.Guardar();
        else acciones.Actualizar();
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        if (evt.getKeyChar() == '.') {
            evt.setKeyChar(',');
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void txtDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescuentoActionPerformed
        if (getBtnGuardar().isVisible())
            acciones.Guardar();
        else acciones.Actualizar();
    }//GEN-LAST:event_txtDescuentoActionPerformed

    private void txtDescuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentoKeyTyped
        if (evt.getKeyChar() == '.') {
            evt.setKeyChar(',');
        }
    }//GEN-LAST:event_txtDescuentoKeyTyped

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        acciones.Guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        acciones.Actualizar();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtCantidadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCantidadFocusGained
        SwingUtilities.invokeLater(() -> {
            ((JFormattedTextField)evt.getComponent()).selectAll();
        });
    }//GEN-LAST:event_txtCantidadFocusGained

    private void txtDescuentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescuentoFocusGained
        SwingUtilities.invokeLater(() -> {
            ((JFormattedTextField)evt.getComponent()).selectAll();
        });
    }//GEN-LAST:event_txtDescuentoFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblDescuento;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JFormattedTextField txtCantidad;
    private javax.swing.JFormattedTextField txtDescuento;
    private javax.swing.JFormattedTextField txtPrecio;
    private javax.swing.JTextField txtProducto;
    // End of variables declaration//GEN-END:variables
}
