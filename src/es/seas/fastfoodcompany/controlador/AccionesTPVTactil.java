/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.controlador;

import es.seas.fastfoodcompany.config.LabelCategoria;
import es.seas.fastfoodcompany.config.LabelProducto;
import es.seas.fastfoodcompany.config.ModeloTablaTPV;
import es.seas.fastfoodcompany.config.NumberCellEditor;
import es.seas.fastfoodcompany.gestionbd.ServiceCategoria;
import es.seas.fastfoodcompany.gestionbd.ServiceDetallesVenta;
import es.seas.fastfoodcompany.gestionbd.ServiceProducto;
import es.seas.fastfoodcompany.gestionbd.ServiceVenta;
import es.seas.fastfoodcompany.modelo.entidades.Categoria;
import es.seas.fastfoodcompany.modelo.entidades.Cliente;
import es.seas.fastfoodcompany.modelo.entidades.DetallesVenta;
import es.seas.fastfoodcompany.modelo.entidades.Empleado;
import es.seas.fastfoodcompany.modelo.entidades.Producto;
import es.seas.fastfoodcompany.modelo.entidades.Venta;
import es.seas.fastfoodcompany.vistas.FrmSeleccionCliente;
import es.seas.fastfoodcompany.vistas.FrmSeleccionEmpleado;
import es.seas.fastfoodcompany.vistas.TPVTactil;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 * Clase que controla las acciones del TPV Táctil
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class AccionesTPVTactil {
    private TPVTactil panel;
    private ModeloTablaTPV tabla;
    private boolean comienzaEdicion;
    
    /**
     * Constructor predeterminado
     *
     * @param panel TPVTactil al que pertenecen las acciones
     */
    public AccionesTPVTactil(TPVTactil panel) {
        this.panel = panel;
        this.comienzaEdicion = false;
    }

    /**
     * Devuelve si la edición actual está comenzando 
     *  (no se ha introducido ninguna cifra)
     * 
     * @return boolean
     */
    public boolean isComienzaEdicion() {
        return comienzaEdicion;
    }

    /**
     * Establece si la edición actual está comenzando 
     *  (no se ha introducido ninguna cifra)
     * 
     * @param comienzaEdicion boolean
     */
    public void setComienzaEdicion(boolean comienzaEdicion) {
        this.comienzaEdicion = comienzaEdicion;
    }
    
    /**
     * Carga los label con imagen para las Categorías
     */
    public void CargaCategorias() {
        ServiceCategoria categoriaDAO = new ServiceCategoria();
        List<Categoria> categorias = new ArrayList<Categoria>();
        
        panel.getPanelCategorias().removeAll();
        panel.getPanelCategorias().setLayout(new GridLayout(0, 4));
        categorias = categoriaDAO.findAll();
        for (Categoria categoria : categorias) {
            LabelCategoria lblCatActual = new LabelCategoria(categoria);
            lblCatActual.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    CargaProductos(lblCatActual.getCategoria());
                }
            });
            panel.getPanelCategorias().add(lblCatActual);
        }
    }
    
    /**
     * Carga los label con imagen para los Productos de la Categoría seleccionada
     * 
     * @param categoria Categoria Categoría seleccionada
     */
    public void CargaProductos(Categoria categoria) {
        ServiceProducto productoDAO = new ServiceProducto();
        List<Producto> productos = new ArrayList<Producto>();
        
        panel.getPanelProductos().removeAll();
        panel.getPanelProductos().setLayout(new GridLayout(0, 3));
        productos = productoDAO.findByCategoria(categoria.getId());
        for (Producto producto : productos) {
            LabelProducto lblProdActual = new LabelProducto(producto);
            lblProdActual.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    InsertaLineaTicket(lblProdActual.getProducto());
                }
            });
            panel.getPanelProductos().add(lblProdActual);
        }
        panel.getPanelScrollProductos().getVerticalScrollBar().setValue(0);
        panel.getPanelProductos().updateUI();
    }
    
    /**
     * Inserta una línea en el ticket al pulsar el producto en el TPV Táctil
     * 
     * @param producto Producto Producto a insertar
     */
    public void InsertaLineaTicket(Producto producto) {
        boolean encontrado = false;
        for (int i = 0; i < tabla.getRowCount(); i++) {
            if (producto.getId() == (int) tabla.getValueAt(i, 0)) {
                encontrado = true;
                Vector filaTabla = new Vector();
                filaTabla.add(tabla.getValueAt(i, 0));
                filaTabla.add(tabla.getValueAt(i, 1));
                filaTabla.add((float)tabla.getValueAt(i, 2) + 1.0f);
                filaTabla.add(tabla.getValueAt(i, 3));
                filaTabla.add(tabla.getValueAt(i, 4));
                filaTabla.add(CalculaTotalLinea((float)filaTabla.get(3), 
                                                (float)filaTabla.get(2), 
                                                (float)filaTabla.get(4)));
                tabla.removeRow(i);
                tabla.insertRow(i, filaTabla);
                MueveScrollTicket(i * panel.getTablaTicket().getRowHeight());
                break;
            }
        }
        if (encontrado == false) {
            Vector filaTabla = new Vector();
            filaTabla.add(producto.getId());
            filaTabla.add(producto.getNombre());
            filaTabla.add(1.00f);
            filaTabla.add(producto.getPrecio());
            filaTabla.add(0.00f);
            filaTabla.add(CalculaTotalLinea(producto.getPrecio(), 1.0f, 0.0f));
            tabla.addRow(filaTabla);
            MueveScrollTicket(
                panel.getPanelTablaTicket().getVerticalScrollBar().getMaximum());
        }
        ActualizaTotalTicket();
    }
    
    /**
     * Elimina la línea seleccionada en el Ticket
     */
    public void EliminarLineaTicket() {
        int[] filasSeleccionadas;
        
        filasSeleccionadas = panel.getTablaTicket().getSelectedRows();
        if (filasSeleccionadas.length == 0) {
            JOptionPane.showMessageDialog(null, "No hay registro seleccionado");
        } else {
            int confirmacion;
            confirmacion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar"
                    + " el registro seleccionado?");
            if (confirmacion == JOptionPane.YES_OPTION) {
                tabla.removeRow(filasSeleccionadas[0]);
                PintaTabla();
                ActualizaTotalTicket();
            }
        }
    }
    
    /**
     * Anula el Ticket Actual
     */
    public void AnularTicket() {
        int confirmacion;
        confirmacion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar"
                + " el ticket actual?");
        if (confirmacion == JOptionPane.YES_OPTION) {
            LimpiaVenta();
        }
    }
    
    // Limpia la venta actual del TPV
    private void LimpiaVenta() {
        for (int i = tabla.getRowCount() - 1; i >= 0; i--) {
            tabla.removeRow(i);
        }
        PintaTabla();
        ActualizaTotalTicket();
        EliminarClienteActual();
        panel.getPanelProductos().removeAll();
        panel.updateUI();
    }
    
    /**
     * Cambia la cantidad/descuento en edición añadiendo la tecla pulsada
     * 
     * @param teclaPulsada String Tecla pulsada
     */
    public void CambiarCantidad(String teclaPulsada) {
        if (panel.getTablaTicket().isEditing()) {
            EscribeCantidad(teclaPulsada);
        } else {
            int[] filasSeleccionadas;
        
            filasSeleccionadas = panel.getTablaTicket().getSelectedRows();
            if (filasSeleccionadas.length == 0) {
                JOptionPane.showMessageDialog(null, "No hay registro seleccionado");
            } else {
                ComienzaEdicionCelda(panel.getTablaTicket().getSelectedRow(), 2);
                EscribeCantidad(teclaPulsada);
            }
        }
    }
    
    // Escribe la cantidad introducida en el campo en edición
    private void EscribeCantidad(String teclaPulsada) {
        JTextField txtEdicion = 
            ((JTextField)panel.getTablaTicket().getEditorComponent());
        if (isComienzaEdicion()) {
            if (teclaPulsada.equals(",")){
                if (panel.getTablaTicket().getEditingColumn() == 2)
                    txtEdicion.setText("1" + teclaPulsada);
                else if (panel.getTablaTicket().getEditingColumn() == 4)
                    txtEdicion.setText("0" + teclaPulsada);
            } else txtEdicion.setText(teclaPulsada);
            setComienzaEdicion(false);
        } else {
            if (teclaPulsada.equals(",")) {
                if (!txtEdicion.getText().contains(","))
                    txtEdicion.setText(txtEdicion.getText() + teclaPulsada);
            } else txtEdicion.setText(txtEdicion.getText() + teclaPulsada);
        }
        txtEdicion.requestFocusInWindow();
    }
    
    /**
     * Elimina el último caracter introducido
     */
    public void EliminarUltimoCaracterEdicion() {
        JTextField txtEdicion = 
            ((JTextField)panel.getTablaTicket().getEditorComponent());
        if (panel.getTablaTicket().isEditing() && 
                                        txtEdicion.getText().length() != 0) {
            txtEdicion.setText(txtEdicion.getText().substring(
                                    0, txtEdicion.getText().length() - 1));
        }
        txtEdicion.requestFocusInWindow();
    }
    
    /**
     * Abre la pantalla de cobro
     */
    public void AbrirPantallaCobro() {
        if (tabla.getRowCount() != 0) {
            JDialog panelCobro = panel.getPanelCobrar();

            panel.getTxtTotalCobro().setValue(panel.getTxtTotalTicket().getValue());
            panel.getTxtEntregado().setText("");
            panel.getTxtDevolver().setValue((-1) * 
                                    (float)panel.getTxtTotalTicket().getValue());
            panel.getTglBtnEfectivo().setSelected(true);

            panelCobro.setModal(true);
            panelCobro.pack();
            panelCobro.setLocationRelativeTo(panel);
            panelCobro.setVisible(true);
        } else JOptionPane.showMessageDialog(panel, "No hay productos en el "
                                                                    + "ticket");
    }
    
    /**
     * Cambia la cantidad entregada añadiendo la tecla pulsada
     * 
     * @param teclaPulsada String Tecla pulsada
     */
    public void CambiarEntregado(String teclaPulsada) {
        if (panel.getTglBtnEfectivo().isSelected()) {
            JTextField txtEdicion = panel.getTxtEntregado();
            if (teclaPulsada.equals(",")) {
                if (txtEdicion.getText().length() != 0)
                    if (!txtEdicion.getText().contains(","))
                        txtEdicion.setText(txtEdicion.getText() + teclaPulsada);
            } else txtEdicion.setText(txtEdicion.getText() + teclaPulsada);
            ActualizaCantidadADevolver();
        }
    }
    
    /**
     * Elimina el último caracter introducido
     */
    public void EliminarUltimoCaracterEntregado() {
        if (panel.getTglBtnEfectivo().isSelected()) {
            JTextField txtEdicion = panel.getTxtEntregado();
            if (txtEdicion.getText().length() != 0) {
                txtEdicion.setText(txtEdicion.getText().substring(
                                        0, txtEdicion.getText().length() - 1));
            }
            txtEdicion.requestFocusInWindow();
            ActualizaCantidadADevolver();
        }
    }
    
    /**
     * Acciones al cambiar la forma de pago a "Efectivo"
     */
    public void FormaPagoEfectivo() {
        panel.getTxtEntregado().setText("");
        ActualizaCantidadADevolver();
    }
    
    /**
     * Acciones al cambiar la forma de pago a "Tarjeta"
     */
    public void FormaPagoTarjeta() {
        panel.getTxtEntregado().setText(panel.getTxtTotalCobro().getText());
        ActualizaCantidadADevolver();
    }
    
    /**
     * Crea un JDialog FrmSeleccionCliente para seleccionar un cliente de los 
     * disponibles en la base de datos y lo enlaza a la venta actual
     */
    public void SeleccionarClienteTicket() {
        FrmSeleccionCliente seleccionarCliente = new FrmSeleccionCliente(
            (JFrame) SwingUtilities.getWindowAncestor(panel), true);
        seleccionarCliente.setLocationRelativeTo(panel);
        seleccionarCliente.getTablaClientes().setRowHeight(40);
        seleccionarCliente.setVisible(true);
        
        if (seleccionarCliente.getClienteSeleccionado() != null) {
            Cliente cliente = seleccionarCliente.getClienteSeleccionado();
            panel.getVenta().setId_cliente(cliente.getId());
            panel.getTxtNombreCliente().setText(cliente.getNombre());
            panel.getTxtApellidosCliente().setText(cliente.getApellido1() + " " 
                + cliente.getApellido2());
            
            CargaColumnasTabla(true);
            
            panel.getBtnDtoLinea().setEnabled(true);
            panel.getBtnDtoTicket().setEnabled(true);
            panel.getBtnQuitarCliente().setEnabled(true);
        }
    }
    
    /**
     * Quita el cliente de la venta actual. Se ejecuta al pulsar el botón 
     * "Quitar" y lanza una pregunta de confirmación
     */
    public void QuitarCliente() {
        int confirmacion;
        confirmacion = JOptionPane.showConfirmDialog(null, "¿Desea desvincular"
                + " el cliente de la venta actual?\nEsta acción borrará "
                + "todos los descuentos actuales");
        
        if (confirmacion == JOptionPane.YES_OPTION) {
            EliminarClienteActual();
        }
    }
    
    /**
    * Elimina el Cliente actual
    */
    public void EliminarClienteActual() {
        panel.getVenta().setId_cliente(null);
        panel.getTxtNombreCliente().setText("");
        panel.getTxtApellidosCliente().setText("");

        AplicaDescuentoLineas(0.0f);

        CargaColumnasTabla(false);

        panel.getBtnDtoLinea().setEnabled(false);
        panel.getBtnDtoTicket().setEnabled(false);
        panel.getBtnQuitarCliente().setEnabled(false);
    }
    
    /**
     * Crea un JDialog FrmSeleccionEmpleado para seleccionar un empleado de los 
     * disponibles en la base de datos y lo enlaza a la venta actual
     */
    public void SeleccionarEmpleadoTicket() {
        FrmSeleccionEmpleado seleccionarEmpleado = new FrmSeleccionEmpleado(
            (JFrame) SwingUtilities.getWindowAncestor(panel), true);
        seleccionarEmpleado.setLocationRelativeTo(panel);
        seleccionarEmpleado.getTablaEmpleados().setRowHeight(40);
        seleccionarEmpleado.setVisible(true);
        
        if (seleccionarEmpleado.getEmpleadoSeleccionado() != null) {
            Empleado empleado = seleccionarEmpleado.getEmpleadoSeleccionado();
            panel.setEmpleadoTicket(empleado);
            panel.getVenta().setId_empleado(empleado.getId());
            panel.getTxtNombreEmpleado().setText(empleado.getNombre());
            panel.getTxtApellidosEmpleado().setText(empleado.getApellido1() 
                    + " " + empleado.getApellido2());
        }
    }
    
    /**
     * Habilita la modificación del descuento para la línea seleccionada
     */
    public void DescuentoLinea() {
        if (panel.getTablaTicket().getSelectedRowCount() != 0) {
            ComienzaEdicionCelda(panel.getTablaTicket().getSelectedRow(), 4);
        }
        else JOptionPane.showMessageDialog(panel, "Seleccione un producto del "
                                                    + "ticket");
    }
    
    /*
    * Comienza la edición en la celda indicada por su fila y columna
    */
    private void ComienzaEdicionCelda(int row, int column) {
        panel.getTablaTicket().editCellAt(row, column);
        panel.getTablaTicket().getEditorComponent().requestFocusInWindow();
        ((JTextField)panel.getTablaTicket().
                                    getEditorComponent()).selectAll();
        setComienzaEdicion(true);
    }
    
    /**
     * Finaliza la edición actual de la tabla Ticket
     */
    public void FinalizaEdicionCelda() {
        if (panel.getTablaTicket().isEditing()) {
            JTextField campoEdicion = ((JTextField)panel.getTablaTicket().getEditorComponent());
            if (campoEdicion.getText().equals("")) {
                campoEdicion.setText(Float.toString(0.0f));
            }
            ((NumberCellEditor)panel.getTablaTicket().getColumnModel().getColumn(
                    panel.getTablaTicket().getEditingColumn()).getCellEditor()).
                        stopCellEditing();
        }
    }
    
    /**
     * Aplica un descuento introducido por pantalla a todas las líneas del ticket
     */
    public void DescuentoTicket() {
        boolean salir = false;
        do{
            try {
                String descuentoIntroducido;
                float descuento;

                descuentoIntroducido = 
                    JOptionPane.showInputDialog(panel, "Introduzca el descuento: ");

                if(descuentoIntroducido != null) {
                    descuento = Float.parseFloat(descuentoIntroducido.
                                                        replace(',', '.'));

                    AplicaDescuentoLineas(descuento);
                }
                salir = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(panel, "Debe introducir un número");
            }
        } while(!salir);
    }
    
    //Aplica el descuento a todas las líneas del ticket
    private void AplicaDescuentoLineas(float descuento) {
        for (int i = 0; i < tabla.getRowCount(); i++) {
            tabla.setValueAt(descuento, i, 4);
            tabla.setValueAt(CalculaTotalLinea((float)tabla.getValueAt(i, 3), 
                                                (float)tabla.getValueAt(i, 2), 
                                                (float)tabla.getValueAt(i, 4)),
                            i, 5);
        }
        ActualizaTotalTicket();
    }
    
    /**
     * Calcula el total de una línea a partir del precio, la cantidad y el descuento
     * 
     * @param precio float Precio
     * @param cantidad float Cantidad
     * @param descuento float Descuento
     * @return float
     */
    public float CalculaTotalLinea(float precio, float cantidad, float descuento) {
        return Math.round((precio * cantidad - 
                            precio * cantidad * descuento / 100.0f)
                                * 100.0f) / 100.0f;
    }
    
    /**
     * Actualiza el total del ticket
     */
    public void ActualizaTotalTicket() {
        float total = 0.0f;
        for (int i = 0; i < tabla.getRowCount(); i++) {
            total += (float) tabla.getValueAt(i, 5);
        }
        panel.getTxtTotalTicket().setValue(total);
    }
    
    /**
     * Actualiza la cantidad a devolver en la pantalla de Cobro
     */
    public void ActualizaCantidadADevolver() {
        float valorEntregado;
        String textoEntregado = panel.getTxtEntregado().getText();
        if (textoEntregado.length() == 0){
            valorEntregado = 0.0f;
        } else {
            textoEntregado = textoEntregado.replace(',', '.');
            valorEntregado = Float.parseFloat(textoEntregado);
        }
        panel.getTxtDevolver().setValue(
                valorEntregado - 
                (float)panel.getTxtTotalCobro().getValue());
    }
    
    /**
     * Finaliza la venta guardándola en la base de datos y carga una nueva
     */
    public void FinalizaVenta() {
        if (panel.getEmpleadoTicket().getId() == 0)
            JOptionPane.showMessageDialog(panel.getPanelCobrar(), 
                    "El empleado por defecto \"Admin\" no puede realizar "
                    + "ventas, seleccione otro");
        else if (panel.getTxtEntregado().getText().length() == 0)
            JOptionPane.showMessageDialog(panel.getPanelCobrar(), 
                    "Marque la cantidad entregada");
            else {
                Venta venta = panel.getVenta();
                ServiceVenta ventaDAO = new ServiceVenta();
                java.util.Date utilFecha = new java.util.Date();
                java.sql.Date sqlFecha = new java.sql.Date(utilFecha.getTime());
                DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");

                //Forma de pago
                if (panel.getTglBtnEfectivo().isSelected())
                    venta.setForma_pago("Efectivo");
                else if (panel.getTglBtnTarjeta().isSelected())
                    venta.setForma_pago("Tarjeta");
                //Entregado
                venta.setEntregado(Float.parseFloat(
                        panel.getTxtEntregado().getText().replace(',', '.')));
                //Total
                venta.setTotal((float)panel.getTxtTotalCobro().getValue());

                //Hora y fecha
                venta.setHora(formatoHora.format(utilFecha));
                venta.setFecha(sqlFecha);

                ventaDAO.insert(venta);

                //Guarda los Detalles de venta
                GuardarDetallesVenta();

                //Carga la nueva venta
                panel.setVenta(new Venta());
                panel.getVenta().setId_empleado(panel.getEmpleadoTicket().getId());

                LimpiaVenta();
                panel.getPanelCobrar().dispose();

                JOptionPane.showMessageDialog(panel, "Venta realizada");
            }
    }
    
    //Guarda los detalles de venta del ticket actual
    private void GuardarDetallesVenta() {
        DetallesVenta detVenta;
        ServiceDetallesVenta detVentaDAO = new ServiceDetallesVenta();
        for (int i = 0; i < tabla.getRowCount(); i++) {
            detVenta = new DetallesVenta();
            detVenta.setId_venta(panel.getVenta().getId());
            detVenta.setId_producto((int)tabla.getValueAt(i, 0));
            detVenta.setCantidad((float)tabla.getValueAt(i, 2));
            detVenta.setPrecio_linea((float)tabla.getValueAt(i, 5));
            detVenta.setDescuento_linea((float)tabla.getValueAt(i, 4));
            detVentaDAO.insert(detVenta);
        }
    }
    
    //Mueve la posición del Scroll del ticket a la posición pasada por parámetro
    private void MueveScrollTicket(int posicion) {
        PintaTabla();
        panel.getPanelTablaTicket().getVerticalScrollBar().setValue(posicion);
    }
    
    /**
     * Inicializa y carga los valores en la tabla
     * 
     * @param hayCliente boolean Indica si hay cliente en la venta actual
     */
    public void InicializaTabla(boolean hayCliente) {
        //Modelo
        tabla = new ModeloTablaTPV(new String[]{
            "IDProducto", "Artículo", "Und.", "Precio", "Dto(%)", "Total"}, 0);
        PintaTabla();
        //Datos
        tabla.setNumRows(0);
        CargaColumnasTabla(false);
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.RIGHT);
        for (int i = 2; i <= 5; i++) {
            panel.getTablaTicket().getColumnModel().getColumn(i).
                                        setCellRenderer(tcr);
            panel.getTablaTicket().getColumnModel().getColumn(i).
                                        setCellEditor(new NumberCellEditor(panel));
        }
    }
    
    //Carga las columnas de la tabla, con descuento si hay cliente en el ticket
    private void CargaColumnasTabla(boolean hayCliente) {
        TableColumnModel columnModel;
        columnModel = panel.getTablaTicket().getColumnModel();
        columnModel.getColumn(1).setPreferredWidth(125);
        columnModel.getColumn(2).setPreferredWidth(43);
        columnModel.getColumn(3).setPreferredWidth(48);
        columnModel.getColumn(5).setPreferredWidth(44);
        if (!hayCliente){
            columnModel.getColumn(1).setPreferredWidth(175);
            columnModel.getColumn(4).setPreferredWidth(0);
            columnModel.getColumn(4).setMaxWidth(0);
            columnModel.getColumn(4).setMinWidth(0);
            panel.getTablaTicket().getColumnModel().getColumn(4).setPreferredWidth(0);
            panel.getTablaTicket().getColumnModel().getColumn(4).setMaxWidth(0);
            panel.getTablaTicket().getColumnModel().getColumn(4).setMinWidth(0);
        } else {
            columnModel.getColumn(1).setPreferredWidth(125);
            columnModel.getColumn(4).setPreferredWidth(50);
            columnModel.getColumn(4).setMaxWidth(50);
            columnModel.getColumn(4).setMinWidth(50);
            panel.getTablaTicket().getColumnModel().getColumn(4).setPreferredWidth(50);
            panel.getTablaTicket().getColumnModel().getColumn(4).setMaxWidth(50);
            panel.getTablaTicket().getColumnModel().getColumn(4).setMinWidth(50);
        }
        PintaTabla();
    }
    
    //Pinta de nuevo la tabla
    private void PintaTabla() {
        panel.getTablaTicket().setRowHeight(40);
        panel.getTablaTicket().setModel(tabla);
        panel.getTablaTicket().getColumnModel().getColumn(0).setPreferredWidth(0);
        panel.getTablaTicket().getColumnModel().getColumn(0).setMaxWidth(0);
        panel.getTablaTicket().getColumnModel().getColumn(0).setMinWidth(0);
        panel.getPanelTablaTicket().setViewportView(panel.getTablaTicket());
    }

}
