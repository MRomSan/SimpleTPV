/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.vistas;

import es.seas.fastfoodcompany.controlador.AccionesEditarIVA;
import es.seas.fastfoodcompany.principal.FFCFrame;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * Pantalla de edición de ivas
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class PanelEditarIVA extends javax.swing.JPanel {
    private FFCFrame frame;
    private AccionesEditarIVA acciones;

    /**
     * Crea un nuevo formPanel PanelEditarIVA
     * @param frame FFCFrame Frame en el que se carga el panel
     */
    public PanelEditarIVA(FFCFrame frame) {
        this.frame = frame;
        this.acciones = new AccionesEditarIVA(this);
        initComponents();
        acciones.InicializaTabla();
        lblID.setVisible(false);
        acciones.habilitaCampos(false);
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
     * Devuelve el panel Botonera
     *
     * @return JPanel
     */
    public JPanel getPanelBotonera() {
        return panelBotonera;
    }

    /**
     * Establece el panel Botonera
     *
     * @param panelBotonera JPanel
     */
    public void setPanelBotonera(JPanel panelBotonera) {
        this.panelBotonera = panelBotonera;
    }

    /**
     * Devuelve el panel Contenedor
     *
     * @return JPanel
     */
    public JPanel getPanelContenedor() {
        return panelContenedor;
    }

    /**
     * Establece el panel Contenedor
     *
     * @param panelContenedor JPanel
     */
    public void setPanelContenedor(JPanel panelContenedor) {
        this.panelContenedor = panelContenedor;
    }

    /**
     * Devuelve el panel Datos
     *
     * @return JPanel
     */
    public JPanel getPanelDatos() {
        return panelDatos;
    }

    /**
     * Establece el panel Datos
     *
     * @param panelDatos JPanel
     */
    public void setPanelDatos(JPanel panelDatos) {
        this.panelDatos = panelDatos;
    }

    /**
     * Devuelve el JScrollPane que contiene la tabla
     *
     * @return JScrollPane
     */
    public JScrollPane getPanelTabla() {
        return panelTabla;
    }

    /**
     * Establece el JScrollPane que contiene la tabla
     *
     * @param panelTabla JScrollPane
     */
    public void setPanelTabla(JScrollPane panelTabla) {
        this.panelTabla = panelTabla;
    }

    /**
     * Devuelve el panel Título
     *
     * @return JPanel
     */
    public JPanel getPanelTitulo() {
        return panelTitulo;
    }

    /**
     * Establece el panel Título
     *
     * @param panelTitulo JPanel
     */
    public void setPanelTitulo(JPanel panelTitulo) {
        this.panelTitulo = panelTitulo;
    }

    /**
     * Devuelve la tabla de IVAs
     *
     * @return JTable
     */
    public JTable getTablaIVA() {
        return tablaIVA;
    }

    /**
     * Establece la tabla de IVAs
     *
     * @param tablaIVA JTable
     */
    public void setTablaIVA(JTable tablaIVA) {
        this.tablaIVA = tablaIVA;
    }
    
    /**
     * Devuelve el campo de texto del Nombre
     *
     * @return JTextField
     */
    public JTextField getTxtNombre() {
        return txtNombre;
    }

    /**
     * Establece el campo de texto del Nombre
     *
     * @param txtNombre JTextField
     */
    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    /**
     * Devuelve la clase que contiene las acciones de edición de IVAs
     *
     * @return AccionesEditarIVA
     */
    public AccionesEditarIVA getAcciones() {
        return acciones;
    }

    /**
     * Establece la clase que contiene las acciones de edición de IVAs
     *
     * @param acciones AccionesEditarIVA
     */
    public void setAcciones(AccionesEditarIVA acciones) {
        this.acciones = acciones;
    }
    
    /**
     * Devuelve el botón Editar
     *
     * @return JButton
     */
    public JButton getBtnEditar() {
        return btnEditar;
    }

    /**
     * Establece el botón Editar
     *
     * @param btnEditar JButton
     */
    public void setBtnEditar(JButton btnEditar) {
        this.btnEditar = btnEditar;
    }

    /**
     * Devuelve el label ID
     *
     * @return JLabel
     */
    public JLabel getLblID() {
        return lblID;
    }

    /**
     * Establece el label ID
     *
     * @param lblID JLabel
     */
    public void setLblID(JLabel lblID) {
        this.lblID = lblID;
    }
    
    /**
     * Devuelve el campo de texto Buscar
     *
     * @return JTextField
     */
    public JTextField getTxtBuscar() {
        return txtBuscar;
    }
    
    /**
     * Establece el campo de texto Buscar
     *
     * @param txtBuscar JTextField
     */
    public void setTxtBuscar(JTextField txtBuscar) {
        this.txtBuscar = txtBuscar;
    }
    
    /**
     * Devuelve el label Buscar
     *
     * @return JLabel
     */
    public JLabel getLblBuscar() {
        return lblBuscar;
    }

    /**
     * Establece el label Buscar
     *
     * @param lblBuscar JLabel
     */
    public void setLblBuscar(JLabel lblBuscar) {
        this.lblBuscar = lblBuscar;
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
     * Devuelve el label Porcentaje
     *
     * @return JLabel
     */
    public JLabel getLblPorcentaje() {
        return lblPorcentaje;
    }

    /**
     * Establece el label Porcentaje
     *
     * @param lblPorcentaje JLabel
     */
    public void setLblPorcentaje(JLabel lblPorcentaje) {
        this.lblPorcentaje = lblPorcentaje;
    }

    /**
     * Devuelve el campo de texto formateado Cantidad
     *
     * @return JFormattedTextField
     */
    public JFormattedTextField getTxtCantidad() {
        return txtCantidad;
    }

    /**
     * Establece el campo de texto formateado Cantidad
     *
     * @param txtCantidad JFormattedTextField
     */
    public void setTxtCantidad(JFormattedTextField txtCantidad) {
        this.txtCantidad = txtCantidad;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContenedor = new javax.swing.JPanel();
        panelTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        panelTabla = new javax.swing.JScrollPane();
        tablaIVA = new javax.swing.JTable();
        panelDatos = new javax.swing.JPanel();
        lblID = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblCantidad = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JFormattedTextField();
        lblPorcentaje = new javax.swing.JLabel();
        panelBotonera = new javax.swing.JPanel();
        btnEditar = new javax.swing.JButton();
        lblBuscar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitulo.setText("EDITAR IVA");

        javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTituloLayout.setVerticalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tablaIVA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaIVA.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaIVA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaIVAMouseClicked(evt);
            }
        });
        panelTabla.setViewportView(tablaIVA);

        panelDatos.setBorder(javax.swing.BorderFactory.createTitledBorder("IVA Seleccionado"));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        lblNombre.setText("Nombre:");

        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreFocusGained(evt);
            }
        });
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

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

        lblPorcentaje.setText("%");

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addContainerGap())
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCantidad))
                .addGap(18, 18, 18)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPorcentaje)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCantidad)
                    .addComponent(lblPorcentaje)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        lblBuscar.setText("Buscar:");

        txtBuscar.setPreferredSize(new java.awt.Dimension(120, 20));
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panelBotoneraLayout = new javax.swing.GroupLayout(panelBotonera);
        panelBotonera.setLayout(panelBotoneraLayout);
        panelBotoneraLayout.setHorizontalGroup(
            panelBotoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotoneraLayout.createSequentialGroup()
                .addContainerGap(240, Short.MAX_VALUE)
                .addComponent(lblBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditar)
                .addContainerGap())
        );
        panelBotoneraLayout.setVerticalGroup(
            panelBotoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotoneraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBotoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBotoneraLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelBotoneraLayout.createSequentialGroup()
                        .addGroup(panelBotoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEditar)
                            .addComponent(lblBuscar))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBotonera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContenedorLayout.createSequentialGroup()
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTabla, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, 0)
                .addComponent(panelBotonera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tablaIVAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaIVAMouseClicked
        if(evt.getClickCount() == 2) {
            acciones.CargaIVASeleccionado();
        }
    }//GEN-LAST:event_tablaIVAMouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        acciones.ActualizaIVA();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        acciones.CargaIVASeleccionado();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        acciones.BuscarIVA(getTxtBuscar().getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        if (evt.getKeyChar() == '.') {
            evt.setKeyChar(',');
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void txtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusGained
        ((JTextField)evt.getComponent()).selectAll();
    }//GEN-LAST:event_txtNombreFocusGained

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        acciones.ActualizaIVA();
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        acciones.ActualizaIVA();
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void txtCantidadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCantidadFocusGained
        SwingUtilities.invokeLater(() -> {
            ((JFormattedTextField)evt.getComponent()).selectAll();
        });
    }//GEN-LAST:event_txtCantidadFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPorcentaje;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelBotonera;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JScrollPane panelTabla;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JTable tablaIVA;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JFormattedTextField txtCantidad;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
