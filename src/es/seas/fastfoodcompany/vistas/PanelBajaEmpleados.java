/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.vistas;

import es.seas.fastfoodcompany.controlador.AccionesBajaEmpleados;
import es.seas.fastfoodcompany.principal.FFCFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * Pantalla de baja de empleados
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class PanelBajaEmpleados extends javax.swing.JPanel {
    private FFCFrame frame;
    private AccionesBajaEmpleados acciones;
    
    /**
     * Crea un nuevo formPanel PanelBajaEmpleados
     * @param frame FFCFrame Frame en el que se carga el panel
     */
    public PanelBajaEmpleados(FFCFrame frame) {
        initComponents();
        this.frame = frame;
        this.acciones = new AccionesBajaEmpleados(this);
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
     * Devuelve el Panel dónde están los botones
     *
     * @return JPanel
     */
    public JPanel getPanelBotones() {
        return panelBotones;
    }

    /**
     * Establece el Panel dónde están los botones
     *
     * @param panelBotones JPanel
     */
    public void setPanelBotones(JPanel panelBotones) {
        this.panelBotones = panelBotones;
    }

    /**
     * Devuelve el JScrollPane dónde está la tabla
     *
     * @return JScrollPane
     */
    public JScrollPane getPanelTabla() {
        return panelTabla;
    }

    /**
     * Establece el JScrollPane dónde está la tabla
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
     * Devuelve la Tabla Empleados
     *
     * @return JTable
     */
    public JTable getTablaEmpleados() {
        return tablaEmpleados;
    }

    /**
     * Establece la Tabla Empleados
     *
     * @param tablaEmpleados JTable
     */
    public void setTablaEmpleados(JTable tablaEmpleados) {
        this.tablaEmpleados = tablaEmpleados;
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
     * Devuelve una Clase con las acciones de baja de empleados
     *
     * @return AccionesBajaEmpleados Contiene las acciones de baja
     */
    public AccionesBajaEmpleados getAcciones() {
        return acciones;
    }

    /**
     * Establece una Clase con las acciones de baja de empleados
     *
     * @param acciones AccionesBajaEmpleados Contiene las acciones de baja
     */
    public void setAcciones(AccionesBajaEmpleados acciones) {
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
        tablaEmpleados = new javax.swing.JTable();
        panelBotones = new javax.swing.JPanel();
        lblBuscar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitulo.setText("BAJA EMPLEADOS");

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

        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaEmpleados.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tablaEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEmpleadosMouseClicked(evt);
            }
        });
        panelTabla.setViewportView(tablaEmpleados);

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

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(0, 9, Short.MAX_VALUE)
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBotonesLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEliminar)
                        .addComponent(lblBuscar)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
            .addComponent(panelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tablaEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEmpleadosMouseClicked
        if(evt.getClickCount() == 2) {
            acciones.EliminarEmpleados();
        }
    }//GEN-LAST:event_tablaEmpleadosMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        acciones.BuscarEmpleados(getTxtBuscar().getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        acciones.EliminarEmpleados();
    }//GEN-LAST:event_btnEliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JScrollPane panelTabla;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JTable tablaEmpleados;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
