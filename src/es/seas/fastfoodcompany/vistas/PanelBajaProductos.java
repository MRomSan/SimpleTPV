/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.vistas;

import es.seas.fastfoodcompany.controlador.AccionesBajaProductos;
import es.seas.fastfoodcompany.modelo.entidades.Categoria;
import es.seas.fastfoodcompany.principal.FFCFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * Pantalla de baja de productos
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class PanelBajaProductos extends javax.swing.JPanel {
    private FFCFrame frame;
    private AccionesBajaProductos acciones;
    private Categoria categoriaBusqueda;
    
    /**
     * Crea un nuevo formPanel PanelBajaCategorias
     * @param frame FFCFrame Frame en el que se carga el panel
     */
    public PanelBajaProductos(FFCFrame frame) {
        this.frame = frame;
        this.acciones = new AccionesBajaProductos(this);
        this.categoriaBusqueda = null;
        initComponents();
        acciones.InicializaTabla();
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
     * Devuelve el botón Eliminar
     *
     * @return JButton
     */
    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    /**
     * Establece el botón Eliminar
     *
     * @param btnEliminar JButton
     */
    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
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
     * Devuelve el Panel donde están los botones
     *
     * @return JPanel
     */
    public JPanel getPanelBotones() {
        return panelBotones;
    }

    /**
     * Establece el Panel donde están los botones
     *
     * @param panelBotones JPanel
     */
    public void setPanelBotones(JPanel panelBotones) {
        this.panelBotones = panelBotones;
    }

    /**
     * Devuelve el JScrollPane donde está la tabla
     *
     * @return JScrollPane
     */
    public JScrollPane getPanelTabla() {
        return panelTabla;
    }

    /**
     * Establece el JScrollPane donde está la tabla
     *
     * @param panelTabla JScrollPane
     */
    public void setPanelTabla(JScrollPane panelTabla) {
        this.panelTabla = panelTabla;
    }

    /**
     * Devuelve el Panel del Título
     *
     * @return JPanel
     */
    public JPanel getPanelTitulo() {
        return panelTitulo;
    }

    /**
     * Establece el Panel del Título
     *
     * @param panelTitulo JPanel
     */
    public void setPanelTitulo(JPanel panelTitulo) {
        this.panelTitulo = panelTitulo;
    }

    /**
     * Devuelve la Tabla Productos
     *
     * @return JTable
     */
    public JTable getTablaProductos() {
        return tablaProductos;
    }

    /**
     * Establece la Tabla Productos
     *
     * @param tablaProductos JTable
     */
    public void setTablaProductos(JTable tablaProductos) {
        this.tablaProductos = tablaProductos;
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
     * Devuelve una Clase con las acciones de baja de productos
     *
     * @return AccionesBajaProductos Contiene las acciones de baja
     */
    public AccionesBajaProductos getAcciones() {
        return acciones;
    }

    /**
     * Establece una Clase con las acciones de baja de productos
     *
     * @param acciones AccionesBajaProductos Contiene las acciones de baja
     */
    public void setAcciones(AccionesBajaProductos acciones) {
        this.acciones = acciones;
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
     * Devuelve el botón Buscar Categoría
     *
     * @return JButton
     */
    public JButton getBtnBuscarCategoria() {
        return btnBuscarCategoria;
    }

    /**
     * Establece el botón Buscar Categoría
     *
     * @param btnBuscarCategoria JButton
     */
    public void setBtnBuscarCategoria(JButton btnBuscarCategoria) {
        this.btnBuscarCategoria = btnBuscarCategoria;
    }

    /**
     * Devuelve el botón Quitar Categoría
     *
     * @return JButton
     */
    public JButton getBtnQuitarCategoria() {
        return btnQuitarCategoria;
    }

    /**
     * Establece el botón Quitar Categoría
     *
     * @param btnQuitarCategoria JButton
     */
    public void setBtnQuitarCategoria(JButton btnQuitarCategoria) {
        this.btnQuitarCategoria = btnQuitarCategoria;
    }
    
    /**
     * Devuelve el label Categoría
     *
     * @return JLabel
     */
    public JLabel getLblBuscarCategoria() {
        return lblBuscarCategoria;
    }

    /**
     * Establece el label Categoría
     *
     * @param lblBuscarCategoria JLabel
     */
    public void setLblBuscarCategoria(JLabel lblBuscarCategoria) {
        this.lblBuscarCategoria = lblBuscarCategoria;
    }

    /**
     * Devuelve el campo de texto Buscar Categoría
     *
     * @return JTextField
     */
    public JTextField getTxtBuscarCategoria() {
        return txtBuscarCategoria;
    }

    /**
     * Establece el campo de texto Buscar Categoría
     *
     * @param txtBuscarCategoria JTextField
     */
    public void setTxtBuscarCategoria(JTextField txtBuscarCategoria) {
        this.txtBuscarCategoria = txtBuscarCategoria;
    }

    /**
     * Devuelve la Categoría seleccionada en el filtro de búsqueda
     *
     * @return Categoria
     */
    public Categoria getCategoriaBusqueda() {
        return categoriaBusqueda;
    }

    /**
     * Establece la Categoría para el filtro de búsqueda
     *
     * @param categoriaBusqueda Categoria
     */
    public void setCategoriaBusqueda(Categoria categoriaBusqueda) {
        this.categoriaBusqueda = categoriaBusqueda;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        panelTabla = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        panelBotones = new javax.swing.JPanel();
        lblBuscar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        lblBuscarCategoria = new javax.swing.JLabel();
        txtBuscarCategoria = new javax.swing.JTextField();
        btnBuscarCategoria = new javax.swing.JButton();
        btnQuitarCategoria = new javax.swing.JButton();

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitulo.setText("BAJA PRODUCTOS");

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
                .addContainerGap(15, Short.MAX_VALUE))
        );

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaProductos.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductosMouseClicked(evt);
            }
        });
        panelTabla.setViewportView(tablaProductos);

        lblBuscar.setText("Buscar:");

        txtBuscar.setPreferredSize(new java.awt.Dimension(120, 20));
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        lblBuscarCategoria.setText("Categoría:");

        txtBuscarCategoria.setEditable(false);
        txtBuscarCategoria.setPreferredSize(new java.awt.Dimension(220, 22));

        btnBuscarCategoria.setText("...");
        btnBuscarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCategoriaActionPerformed(evt);
            }
        });

        btnQuitarCategoria.setText("Quitar Categoría");
        btnQuitarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarCategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBuscarCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQuitarCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(lblBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar)
                .addContainerGap())
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotonesLayout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBotonesLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEliminar)
                        .addComponent(lblBuscar)
                        .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblBuscarCategoria)
                            .addComponent(txtBuscarCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnQuitarCategoria)
                            .addComponent(btnBuscarCategoria))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(panelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMouseClicked
        if(evt.getClickCount() == 2) {
            acciones.EliminarProductos();
        }
    }//GEN-LAST:event_tablaProductosMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        acciones.BuscarProductos(getTxtBuscar().getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        acciones.EliminarProductos();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCategoriaActionPerformed
        acciones.SeleccionarCategoria();
    }//GEN-LAST:event_btnBuscarCategoriaActionPerformed

    private void btnQuitarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarCategoriaActionPerformed
        acciones.QuitarCategoria();
    }//GEN-LAST:event_btnQuitarCategoriaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarCategoria;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnQuitarCategoria;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblBuscarCategoria;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JScrollPane panelTabla;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtBuscarCategoria;
    // End of variables declaration//GEN-END:variables
}
