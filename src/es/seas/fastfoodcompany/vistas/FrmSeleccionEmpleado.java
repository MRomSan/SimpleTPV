/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.vistas;

import es.seas.fastfoodcompany.controlador.AccionesSeleccionEmpleado;
import es.seas.fastfoodcompany.modelo.entidades.Empleado;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * Pantalla de Selección de Empleado
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class FrmSeleccionEmpleado extends javax.swing.JDialog {
    private AccionesSeleccionEmpleado acciones;
    private Empleado empleadoSeleccionado;

    /**
     * Crea un nuevo formDialog FrmSeleccionEmpleado
     * @param parent JDialog Formulario padre
     * @param modal boolean Modalidad
     */
    public FrmSeleccionEmpleado(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        this.acciones = new AccionesSeleccionEmpleado(this);
        this.empleadoSeleccionado = null;
        initComponents();
        acciones.InicializaTabla();
    }
    
    /**
     * Crea un nuevo formDialog FrmSeleccionEmpleado
     * @param parent JFrame Formulario padre
     * @param modal boolean Modalidad
     */
    public FrmSeleccionEmpleado(javax.swing.JFrame parent, boolean modal) {
        super(parent, modal);
        this.acciones = new AccionesSeleccionEmpleado(this);
        this.empleadoSeleccionado = null;
        initComponents();
        acciones.InicializaTabla();
    }

    /**
     * Devuelve una Clase con las acciones de selección de empleado
     *
     * @return AccionesSeleccionEmpleado Contiene las acciones de selección
     */
    public AccionesSeleccionEmpleado getAcciones() {
        return acciones;
    }

    /**
     * Establece una Clase con las acciones de selección de empleado
     *
     * @param acciones AccionesSeleccionEmpleado Contiene las acciones de 
     * selección
     */
    public void setAcciones(AccionesSeleccionEmpleado acciones) {
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
     * Devuelve el Empleado Seleccionado con el botón Seleccionar Empleado
     *
     * @return Empleado
     */
    public Empleado getEmpleadoSeleccionado() {
        return empleadoSeleccionado;
    }

    /**
     * Establece el Empleado Seleccionado con el botón Seleccionar Empleado
     *
     * @param empleadoSeleccionado Empleado
     */
    public void setEmpleadoSeleccionado(Empleado empleadoSeleccionado) {
        this.empleadoSeleccionado = empleadoSeleccionado;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTabla = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        panelBotones = new javax.swing.JPanel();
        lblBuscar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnSeleccionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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
        tablaEmpleados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
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
            .addComponent(panelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
            .addComponent(panelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void tablaEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEmpleadosMouseClicked
        if(evt.getClickCount() == 2) {
            acciones.SeleccionarEmpleado();
        }
    }//GEN-LAST:event_tablaEmpleadosMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        acciones.BuscarEmpleados(getTxtBuscar().getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        acciones.SeleccionarEmpleado();
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JScrollPane panelTabla;
    private javax.swing.JTable tablaEmpleados;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
