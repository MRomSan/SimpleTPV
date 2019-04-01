/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.vistas;

import es.seas.fastfoodcompany.controlador.AccionesEditarCategorias;
import es.seas.fastfoodcompany.principal.FFCFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * Pantalla de edición de categorías
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class PanelEditarCategorias extends javax.swing.JPanel {
    private FFCFrame frame;
    private AccionesEditarCategorias acciones;

    /**
     * Crea un nuevo formPanel PanelEditarCategorias
     * @param frame FFCFrame Frame en el que se carga el panel
     */
    public PanelEditarCategorias(FFCFrame frame) {
        this.frame = frame;
        this.acciones = new AccionesEditarCategorias(this);
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
     * Devuelve la tabla de categorías
     *
     * @return JTable
     */
    public JTable getTablaCategorias() {
        return tablaCategorias;
    }

    /**
     * Establece la tabla de categorías
     *
     * @param tablaCategorias JTable
     */
    public void setTablaCategorias(JTable tablaCategorias) {
        this.tablaCategorias = tablaCategorias;
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
     * Devuelve la clase que contiene las acciones de edición de categorías
     *
     * @return AccionesEditarCategorias
     */
    public AccionesEditarCategorias getAcciones() {
        return acciones;
    }

    /**
     * Establece la clase que contiene las acciones de edición de categorías
     *
     * @param acciones AccionesEditarCategorias
     */
    public void setAcciones(AccionesEditarCategorias acciones) {
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
     * Devuelve el botón Buscar Imagen ("...")
     *
     * @return JButton
     */
    public JButton getBtnBuscarImagen() {
        return btnBuscarImagen;
    }

    /**
     * Establece el botón Buscar Imagen ("...")
     *
     * @param btnBuscarImagen JButton
     */
    public void setBtnBuscarImagen(JButton btnBuscarImagen) {
        this.btnBuscarImagen = btnBuscarImagen;
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
     * Devuelve el label Muestra Imagen (donde se carga la imagen)
     *
     * @return JLabel
     */
    public JLabel getLblMuestraImagen() {
        return lblMuestraImagen;
    }

    /**
     * Establece el label Muestra Imagen (donde se carga la imagen)
     *
     * @param lblMuestraImagen JLabel
     */
    public void setLblMuestraImagen(JLabel lblMuestraImagen) {
        this.lblMuestraImagen = lblMuestraImagen;
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
        tablaCategorias = new javax.swing.JTable();
        panelDatos = new javax.swing.JPanel();
        lblID = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblDescripcion = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        lblImagen = new javax.swing.JLabel();
        lblMuestraImagen = new javax.swing.JLabel();
        btnBuscarImagen = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        panelBotonera = new javax.swing.JPanel();
        btnEditar = new javax.swing.JButton();
        lblBuscar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitulo.setText("EDITAR CATEGORÍAS");

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

        tablaCategorias.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaCategorias.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCategoriasMouseClicked(evt);
            }
        });
        panelTabla.setViewportView(tablaCategorias);

        panelDatos.setBorder(javax.swing.BorderFactory.createTitledBorder("Categoría Seleccionada"));

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

        lblDescripcion.setText("Descripción:");

        txtDescripcion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDescripcionFocusGained(evt);
            }
        });
        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });

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
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescripcion)
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelDatosLayout.createSequentialGroup()
                                        .addComponent(lblMuestraImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnBuscarImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 68, Short.MAX_VALUE)))))
                .addContainerGap())
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
                    .addComponent(lblDescripcion)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblImagen)
                            .addComponent(lblMuestraImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarImagen))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGuardar)))
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
                .addContainerGap(399, Short.MAX_VALUE)
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

    private void tablaCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCategoriasMouseClicked
        if(evt.getClickCount() == 2) {
            acciones.CargaCategoriaSeleccionada();
        }
    }//GEN-LAST:event_tablaCategoriasMouseClicked

    private void txtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusGained
        ((JTextField)evt.getComponent()).selectAll();
    }//GEN-LAST:event_txtNombreFocusGained

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        acciones.ActualizaCategoria();
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        acciones.CargaCategoriaSeleccionada();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        acciones.BuscarCategorias(getTxtBuscar().getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnBuscarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarImagenActionPerformed
        acciones.buscarImagen();
    }//GEN-LAST:event_btnBuscarImagenActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        acciones.ActualizaCategoria();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        acciones.ActualizaCategoria();
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void txtDescripcionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescripcionFocusGained
        ((JTextField)evt.getComponent()).selectAll();
    }//GEN-LAST:event_txtDescripcionFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarImagen;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblMuestraImagen;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelBotonera;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JScrollPane panelTabla;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JTable tablaCategorias;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
