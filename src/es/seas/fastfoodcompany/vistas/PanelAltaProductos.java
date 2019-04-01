/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.vistas;

import es.seas.fastfoodcompany.controlador.AccionesAltaProductos;
import es.seas.fastfoodcompany.principal.FFCFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Pantalla de alta de productos
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class PanelAltaProductos extends javax.swing.JPanel {
    private FFCFrame frame;
    private AccionesAltaProductos acciones;

    /**
     * Crea un nuevo formPanel PanelAltaProductos
     * 
     * @param frame FFCFrame Frame en el que se carga el panel
     */
    public PanelAltaProductos(FFCFrame frame) {
        this.frame = frame;
        this.acciones = new AccionesAltaProductos(this);
        initComponents();
        acciones.inicializaCmbCategoria();
        acciones.inicializaCmbIVA();
    }
    
    /**
     * Devuelve el frame en el que se carga el panel
     *
     * @return FFCFrame Frame en el que se carga el panel
     */
    public FFCFrame getFrame() {
        return frame;
    }

    /**
     * Establece el frame en el que se carga el panel
     *
     * @param frame FFCFrame Frame en el que se carga el panel
     */
    public void setFrame(FFCFrame frame) {
        this.frame = frame;
    }

    /**
     * Devuelve una Clase con las acciones de alta de productos
     *
     * @return AccionesAltaProductos
     */
    public AccionesAltaProductos getAcciones() {
        return acciones;
    }

    /**
     * Establece una Clase con las acciones de alta de productos
     *
     * @param acciones AccionesAltaProductos Contiene las acciones de alta
     */
    public void setAcciones(AccionesAltaProductos acciones) {
        this.acciones = acciones;
    }
    
    /**
     * Devuelve el botón Buscar Imagen
     *
     * @return JButton
     */
    public JButton getBtnBuscarImagen() {
        return btnBuscarImagen;
    }

    /**
     * Establece el botón Buscar Imagen
     *
     * @param btnBuscarImagen JButton
     */
    public void setBtnBuscarImagen(JButton btnBuscarImagen) {
        this.btnBuscarImagen = btnBuscarImagen;
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
     * Devuelve el label Descripción
     *
     * @return JLabel
     */
    public JLabel getLblDescripcion() {
        return lblDescripcion;
    }

    /**
     * Establece el label Descripción
     *
     * @param lblDescripcion JLabel
     */
    public void setLblDescripcion(JLabel lblDescripcion) {
        this.lblDescripcion = lblDescripcion;
    }

    /**
     * Devuelve el label Imagen
     *
     * @return JLabel
     */
    public JLabel getLblImagen() {
        return lblImagen;
    }

    /**
     * Establece el label Imagen
     *
     * @param lblImagen JLabel
     */
    public void setLblImagen(JLabel lblImagen) {
        this.lblImagen = lblImagen;
    }

    /**
     * Devuelve el label en el que se muestra la imagen
     *
     * @return JLabel
     */
    public JLabel getLblMuestraImagen() {
        return lblMuestraImagen;
    }

    /**
     * Establece el label en el que se muestra la imagen
     *
     * @param lblMuestraImagen JLabel
     */
    public void setLblMuestraImagen(JLabel lblMuestraImagen) {
        this.lblMuestraImagen = lblMuestraImagen;
    }

    /**
     * Devuelve el label Nombre
     *
     * @return JLabel
     */
    public JLabel getLblNombre() {
        return lblNombre;
    }

    /**
     * Establece el label Nombre
     *
     * @param lblNombre JLabel
     */
    public void setLblNombre(JLabel lblNombre) {
        this.lblNombre = lblNombre;
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
     * Devuelve el panel dónde se cargan los datos
     *
     * @return panelDatos Panel en el que se cargarán los datos de la categoría
     */
    public JPanel getPanelDatos() {
        return panelDatos;
    }

    /**
     * Establece el panel dónde se cargan los datos
     *
     * @param panelDatos Panel en el que se cargarán los datos de la categoría
     */
    public void setPanelDatos(JPanel panelDatos) {
        this.panelDatos = panelDatos;
    }

    /**
     * Devuelve el campo de texto Descripción
     *
     * @return JTextField
     */
    public JTextField getTxtDescripcion() {
        return txtDescripcion;
    }

    /**
     * Establece el campo de texto Descripción
     *
     * @param txtDescripcion JTextField
     */
    public void setTxtDescripcion(JTextField txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }

    /**
     * Devuelve el campo de texto Nombre
     *
     * @return JTextField
     */
    public JTextField getTxtNombre() {
        return txtNombre;
    }

    /**
     * Establece el campo de texto Nombre
     *
     * @param txtNombre JTextField
     */
    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    /**
     * Devuelve el comboBox Categoría
     *
     * @return JComboBox
     */
    public JComboBox<String> getCmbCategoria() {
        return cmbCategoria;
    }

    /**
     * Establece el comboBox Categoría
     *
     * @param cmbCategoria JComboBox
     */
    public void setCmbCategoria(JComboBox<String> cmbCategoria) {
        this.cmbCategoria = cmbCategoria;
    }

    /**
     * Devuelve el comboBox IVA
     *
     * @return JComboBox
     */
    public JComboBox<String> getCmbIVA() {
        return cmbIVA;
    }

    /**
     * Establece el comboBox IVA
     *
     * @param cmbIVA JComboBox
     */
    public void setCmbIVA(JComboBox<String> cmbIVA) {
        this.cmbIVA = cmbIVA;
    }

    /**
     * Devuelve el label Categoría
     *
     * @return JLabel
     */
    public JLabel getLblCategoria() {
        return lblCategoria;
    }

    /**
     * Establece el label Categoría
     *
     * @param lblCategoria JLabel
     */
    public void setLblCategoria(JLabel lblCategoria) {
        this.lblCategoria = lblCategoria;
    }

    /**
     * Devuelve el label IVA
     *
     * @return JLabel
     */
    public JLabel getLblIVA() {
        return lblIVA;
    }

    /**
     * Establece el label IVA
     *
     * @param lblIVA JLabel
     */
    public void setLblIVA(JLabel lblIVA) {
        this.lblIVA = lblIVA;
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
     * Devuelve el campo de texto formateado Precio
     *
     * @return JFormattedTextField
     */
    public JFormattedTextField getTxtPrecio() {
        return txtPrecio;
    }

    /**
     * Establece el campo de texto formateado Precio
     *
     * @param txtPrecio JFormattedTextField
     */
    public void setTxtPrecio(JFormattedTextField txtPrecio) {
        this.txtPrecio = txtPrecio;
    }

    /**
     * Devuelve el label Cantidad IVA
     *
     * @return JLabel
     */
    public JLabel getLblCantidadIVA() {
        return lblCantidadIVA;
    }
    
    /**
     * Establece el label Cantidad IVA
     *
     * @param lblCantidadIVA JLabel
     */
    public void setLblCantidadIVA(JLabel lblCantidadIVA) {
        this.lblCantidadIVA = lblCantidadIVA;
    }

    /**
     * Devuelve el label Euro
     *
     * @return JLabel
     */
    public JLabel getLblEuro() {
        return lblEuro;
    }

    /**
     * Establece el label Euro
     *
     * @param lblEuro JLabel
     */
    public void setLblEuro(JLabel lblEuro) {
        this.lblEuro = lblEuro;
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
        lblCategoria = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblDescripcion = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        lblPrecio = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JFormattedTextField();
        lblEuro = new javax.swing.JLabel();
        lblIVA = new javax.swing.JLabel();
        cmbIVA = new javax.swing.JComboBox<>();
        lblCantidadIVA = new javax.swing.JLabel();
        lblImagen = new javax.swing.JLabel();
        lblMuestraImagen = new javax.swing.JLabel();
        btnBuscarImagen = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitulo.setText("ALTA PRODUCTOS");

        lblCategoria.setText("Categoría:");

        cmbCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCategoriaItemStateChanged(evt);
            }
        });

        lblNombre.setText("Nombre:");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        lblDescripcion.setText("Descripción:");

        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });

        lblPrecio.setText("Precio:");

        txtPrecio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });

        lblEuro.setText("€");

        lblIVA.setText("IVA:");

        cmbIVA.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIVAItemStateChanged(evt);
            }
        });

        lblCantidadIVA.setText("0,0");

        lblImagen.setText("Imagen:");

        lblMuestraImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnBuscarImagen.setText(",,,");
        btnBuscarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarImagenActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGuardar))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitulo)
                            .addComponent(lblCategoria)
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelDatosLayout.createSequentialGroup()
                                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelDatosLayout.createSequentialGroup()
                                                .addComponent(lblMuestraImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnBuscarImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(panelDatosLayout.createSequentialGroup()
                                        .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblEuro)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblIVA)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCantidadIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategoria)
                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescripcion)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrecio)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIVA)
                    .addComponent(cmbIVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEuro)
                    .addComponent(lblCantidadIVA))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImagen)
                    .addComponent(lblMuestraImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarImagen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addContainerGap())
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

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        if (evt.getKeyChar() == '.') {
            evt.setKeyChar(',');
        }
    }//GEN-LAST:event_txtPrecioKeyTyped

    private void btnBuscarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarImagenActionPerformed
        acciones.buscarImagen();
    }//GEN-LAST:event_btnBuscarImagenActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        acciones.Guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        acciones.Guardar();
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        acciones.Guardar();
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        acciones.Guardar();
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void cmbIVAItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbIVAItemStateChanged
        acciones.cambiaIVASeleccionado(getCmbIVA().
                getSelectedItem().toString());
    }//GEN-LAST:event_cmbIVAItemStateChanged

    private void cmbCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCategoriaItemStateChanged
        acciones.cambiaCategoriaSeleccionada(getCmbCategoria().
                getSelectedItem().toString());
    }//GEN-LAST:event_cmbCategoriaItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarImagen;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbIVA;
    private javax.swing.JLabel lblCantidadIVA;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblEuro;
    private javax.swing.JLabel lblIVA;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblMuestraImagen;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JFormattedTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
