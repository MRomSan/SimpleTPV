/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.vistas;

import es.seas.fastfoodcompany.controlador.AccionesSeleccionCliente;
import es.seas.fastfoodcompany.modelo.entidades.Cliente;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * Pantalla de Selección de Cliente
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class FrmSeleccionCliente extends javax.swing.JDialog {
    private AccionesSeleccionCliente acciones;
    private Cliente clienteSeleccionado;

    /**
     * Crea un nuevo formDialog FrmSeleccionCliente
     * @param parent JDialog Formulario padre
     * @param modal boolean Modalidad
     */
    public FrmSeleccionCliente(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        this.acciones = new AccionesSeleccionCliente(this);
        this.clienteSeleccionado = null;
        initComponents();
        acciones.InicializaTabla();
    }
    
    /**
     * Crea un nuevo formDialog FrmSeleccionCliente
     * @param parent JFrame Formulario padre
     * @param modal boolean Modalidad
     */
    public FrmSeleccionCliente(javax.swing.JFrame parent, boolean modal) {
        super(parent, modal);
        this.acciones = new AccionesSeleccionCliente(this);
        this.clienteSeleccionado = null;
        initComponents();
        acciones.InicializaTabla();
    }

    /**
     * Devuelve una Clase con las acciones de selección de cliente
     *
     * @return AccionesSeleccionCliente Contiene las acciones de selección
     */
    public AccionesSeleccionCliente getAcciones() {
        return acciones;
    }

    /**
     * Establece una Clase con las acciones de selección de cliente
     *
     * @param acciones AccionesSeleccionCliente Contiene las acciones de 
     * selección
     */
    public void setAcciones(AccionesSeleccionCliente acciones) {
        this.acciones = acciones;
    }
    
    /**
     * Devuelve el botón Seleccionar
     *
     * @return JButton
     */
    public JButton getBtnSeleccionar() {
        return btnSeleccionar;
    }

    /**
     * Establece el botón Seleccionar
     *
     * @param btnSeleccionar JButton
     */
    public void setBtnSeleccionar(JButton btnSeleccionar) {
        this.btnSeleccionar = btnSeleccionar;
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
     * Devuelve la Tabla Clientes
     *
     * @return JTable
     */
    public JTable getTablaClientes() {
        return tablaClientes;
    }

    /**
     * Establece la Tabla Clientes
     *
     * @param tablaClientes JTable
     */
    public void setTablaClientes(JTable tablaClientes) {
        this.tablaClientes = tablaClientes;
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
     * Devuelve el Cliente Seleccionado con el botón Seleccionar Cliente
     *
     * @return Cliente
     */
    public Cliente getClienteSeleccionado() {

        return clienteSeleccionado;
    }

    /**
     * Establece el Cliente Seleccionado con el botón Seleccionar Cliente
     *
     * @param clienteSeleccionado Cliente
     */
    public void setClienteSeleccionado(Cliente clienteSeleccionado) {    
        this.clienteSeleccionado = clienteSeleccionado;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings(value = "unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTabla = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        panelBotones = new javax.swing.JPanel();
        lblBuscar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnSeleccionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaClientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClientesMouseClicked(evt);
            }
        });
        panelTabla.setViewportView(tablaClientes);

        lblBuscar.setText("Buscar:");

        txtBuscar.setPreferredSize(new java.awt.Dimension(120, 20));
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSeleccionar)
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
                        .addComponent(btnSeleccionar)
                        .addComponent(lblBuscar)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMouseClicked
        if(evt.getClickCount() == 2) {
            acciones.SeleccionarCliente();
        }
    }//GEN-LAST:event_tablaClientesMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        acciones.BuscarClientes(getTxtBuscar().getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        acciones.SeleccionarCliente();
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JScrollPane panelTabla;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
