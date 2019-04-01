/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.vistas;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import es.seas.fastfoodcompany.controlador.AccionesEditarVentas;
import es.seas.fastfoodcompany.modelo.entidades.Cliente;
import es.seas.fastfoodcompany.modelo.entidades.DetallesVenta;
import es.seas.fastfoodcompany.modelo.entidades.Empleado;
import es.seas.fastfoodcompany.modelo.entidades.Venta;
import es.seas.fastfoodcompany.principal.FFCFrame;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * Pantalla de edición de ventas
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class PanelEditarVentas extends javax.swing.JPanel {
    private FFCFrame frame;
    private AccionesEditarVentas acciones;
    private Venta ventaSeleccionada;
    private DetallesVenta detVentaModificado;
    private List<DetallesVenta> detallesVentaSeleccionada;
    private Cliente clienteVenta;
    private Empleado empleadoVenta;
    private Cliente clienteBusqueda;

    /**
     * Crea un nuevo formPanel PanelEditarVentas
     * @param frame FFCFrame Frame en el que se carga el panel
     */
    public PanelEditarVentas(FFCFrame frame) {
        this.frame = frame;
        this.acciones = new AccionesEditarVentas(this);
        this.ventaSeleccionada = null;
        this.clienteVenta = null;
        this.empleadoVenta = null;
        this.clienteBusqueda = null;
        initComponents();
        btnGrpFormaPago.add(rbtnEfectivo);
        btnGrpFormaPago.add(rbtnTarjeta);
        acciones.InicializaTablas();
        acciones.habilitaCampos(false);
        btnDescuentoTicket.setEnabled(false);
        //Deshabilita la edición del JDateChooser
        JTextFieldDateEditor editor = 
                (JTextFieldDateEditor) txtBuscarFecha.getDateEditor();
        editor.setEditable(false);
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
     * Devuelve las acciones de Edición de Ventas
     *
     * @return AccionesEditarVentas
     */
    public AccionesEditarVentas getAcciones() {
        return acciones;
    }
    
    /**
     * Establece las acciones de Edición de Ventas
     *
     * @param acciones AccionesEditarVentas
     */
    public void setAcciones(AccionesEditarVentas acciones) {
        this.acciones = acciones;
    }
    
    /**
     * Devuelve el Grupo de Botones Forma de Pago
     *
     * @return ButtonGroup
     */
    public ButtonGroup getBtnGrpFormaPago() {
        return btnGrpFormaPago;
    }

    /**
     * Establece el Grupo de Botones Forma de Pago
     *
     * @param btnGrpFormaPago ButtonGroup
     */
    public void setBtnGrpFormaPago(ButtonGroup btnGrpFormaPago) {
        this.btnGrpFormaPago = btnGrpFormaPago;
    }
    
    /**
     * Devuelve el botón Anular Línea
     *
     * @return JButton
     */
    public JButton getBtnAnularLinea() {
        return btnAnularLinea;
    }

    /**
     * Establece el botón Anular Línea
     *
     * @param btnAnularLinea JButton
     */
    public void setBtnAnularLinea(JButton btnAnularLinea) {
        this.btnAnularLinea = btnAnularLinea;
    }

    /**
     * Devuelve el botón Buscar Cliente
     *
     * @return JButton
     */
    public JButton getBtnBuscarCliente() {
        return btnBuscarCliente;
    }

    /**
     * Establece el botón Buscar Cliente
     *
     * @param btnBuscarCliente JButton
     */
    public void setBtnBuscarCliente(JButton btnBuscarCliente) {
        this.btnBuscarCliente = btnBuscarCliente;
    }
    
    /**
     * Devuelve el botón Cliente Venta (...)
     *
     * @return JButton
     */
    public JButton getBtnClienteVenta() {
        return btnClienteVenta;
    }

    /**
     * Establece el botón Cliente Venta (...)
     *
     * @param btnClienteVenta JButton
     */
    public void setBtnClienteVenta(JButton btnClienteVenta) {
        this.btnClienteVenta = btnClienteVenta;
    }

    /**
     * Devuelve el botón Empleado Venta (...)
     *
     * @return JButton
     */
    public JButton getBtnEmpleadoVenta() {
        return btnEmpleadoVenta;
    }

    /**
     * Establece el botón Empleado Venta (...)
     *
     * @param btnEmpleadoVenta JButton
     */
    public void setBtnEmpleadoVenta(JButton btnEmpleadoVenta) {
        this.btnEmpleadoVenta = btnEmpleadoVenta;
    }

    /**
     * Devuelve el botón Descuento Ticket
     *
     * @return JButton
     */
    public JButton getBtnDescuentoTicket() {
        return btnDescuentoTicket;
    }

    /**
     * Establece el botón Descuento Ticket
     *
     * @param btnDescuentoTicket JButton
     */
    public void setBtnDescuentoTicket(JButton btnDescuentoTicket) {
        this.btnDescuentoTicket = btnDescuentoTicket;
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
     * Devuelve el botón Editar Línea
     *
     * @return JButton
     */
    public JButton getBtnEditarLinea() {
        return btnEditarLinea;
    }

    /**
     * Establece el botón Editar Línea
     *
     * @param btnEditarLinea JButton
     */
    public void setBtnEditarLinea(JButton btnEditarLinea) {
        this.btnEditarLinea = btnEditarLinea;
    }

    /**
     * Devuelve el botón Eliminar Línea
     *
     * @return JButton
     */
    public JButton getBtnEliminarLinea() {
        return btnEliminarLinea;
    }

    /**
     * Establece el botón Eliminar Línea
     *
     * @param btnEliminarLinea JButton
     */
    public void setBtnEliminarLinea(JButton btnEliminarLinea) {
        this.btnEliminarLinea = btnEliminarLinea;
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
     * Devuelve el botón Nueva Línea
     *
     * @return JButton
     */
    public JButton getBtnNuevaLinea() {
        return btnNuevaLinea;
    }

    /**
     * Establece el botón Nueva Línea
     *
     * @param btnNuevaLinea JButton
     */
    public void setBtnNuevaLinea(JButton btnNuevaLinea) {
        this.btnNuevaLinea = btnNuevaLinea;
    }

    /**
     * Devuelve el botón Quitar Cliente
     *
     * @return JButton
     */
    public JButton getBtnQuitarCliente() {
        return btnQuitarCliente;
    }

    /**
     * Establece el botón Quitar Cliente
     *
     * @param btnQuitarCliente JButton
     */
    public void setBtnQuitarCliente(JButton btnQuitarCliente) {
        this.btnQuitarCliente = btnQuitarCliente;
    }

    /**
     * Devuelve el botón Vaciar Filtros Búsqueda
     *
     * @return JButton
     */
    public JButton getBtnVaciarFiltrosBusqueda() {
        return btnVaciarFiltrosBusqueda;
    }

    /**
     * Establece el botón Vaciar Filtros Búsqueda
     *
     * @param btnVaciarFiltrosBusqueda JButton
     */
    public void setBtnVaciarFiltrosBusqueda(JButton btnVaciarFiltrosBusqueda) {
        this.btnVaciarFiltrosBusqueda = btnVaciarFiltrosBusqueda;
    }
    
    /**
     * Devuelve la Venta seleccionada
     *
     * @return Venta
     */
    public Venta getVentaSeleccionada() {
        return ventaSeleccionada;
    }

    /**
     * Establece la Venta seleccionada
     *
     * @param ventaSeleccionada Venta
     */
    public void setVentaSeleccionada(Venta ventaSeleccionada) {
        this.ventaSeleccionada = ventaSeleccionada;
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
     * Devuelve los Detalles de la Venta seleccionada
     *
     * @return Venta List Lista de Detalles de Venta
     */
    public List<DetallesVenta> getDetallesVentaSeleccionada() {
        return detallesVentaSeleccionada;
    }

    /**
     * Establece los Detalles de la Venta seleccionada
     *
     * @param detallesVentaSeleccionada List
     */
    public void setDetallesVentaSeleccionada(List<DetallesVenta> detallesVentaSeleccionada) {
        this.detallesVentaSeleccionada = detallesVentaSeleccionada;
    }

    /**
     * Devuelve el Cliente establecido para la búsqueda
     *
     * @return Cliente
     */
    public Cliente getClienteBusqueda() {
        return clienteBusqueda;
    }

    /**
     * Establece el Cliente para la búsqueda
     *
     * @param clienteBusqueda Cliente
     */
    public void setClienteBusqueda(Cliente clienteBusqueda) {
        this.clienteBusqueda = clienteBusqueda;
    }
    
    /**
     * Devuelve el Cliente de la Venta con el botón Cliente Venta
     *
     * @return Cliente
     */
    public Cliente getClienteVenta() {
        return clienteVenta;
    }

    /**
     * Establece el Cliente de la Venta con el botón Cliente Venta
     *
     * @param clienteVenta Cliente
     */
    public void setClienteVenta(Cliente clienteVenta) {
        this.clienteVenta = clienteVenta;
    }
    
    /**
     * Devuelve el Empleado de la Venta con el botón Empleado Venta
     *
     * @return Empleado
     */
    public Empleado getEmpleadoVenta() {
        return empleadoVenta;
    }

    /**
     * Establece el Empleado de la Venta con el botón Empleado Venta
     *
     * @param empleadoVenta Empleado
     */
    public void setEmpleadoVenta(Empleado empleadoVenta) {
        this.empleadoVenta = empleadoVenta;
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
     * Devuelve el label Buscar Cliente
     *
     * @return JLabel
     */
    public JLabel getLblBuscarCliente() {
        return lblBuscarCliente;
    }

    /**
     * Establece el label Buscar Cliente
     *
     * @param lblBuscarCliente JLabel
     */
    public void setLblBuscarCliente(JLabel lblBuscarCliente) {
        this.lblBuscarCliente = lblBuscarCliente;
    }
    
    /**
     * Devuelve el label Buscar Fecha
     *
     * @return JLabel
     */
    public JLabel getLblBuscarFecha() {
        return lblBuscarFecha;
    }

    /**
     * Establece el label Buscar Fecha
     *
     * @param lblBuscarFecha JLabel
     */
    public void setLblBuscarFecha(JLabel lblBuscarFecha) {
        this.lblBuscarFecha = lblBuscarFecha;
    }

    /**
     * Devuelve el label Cliente
     *
     * @return JLabel
     */
    public JLabel getLblCliente() {
        return lblCliente;
    }

    /**
     * Establece el label Cliente
     *
     * @param lblCliente JLabel
     */
    public void setLblCliente(JLabel lblCliente) {
        this.lblCliente = lblCliente;
    }

    /**
     * Devuelve el label Empleado
     *
     * @return JLabel
     */
    public JLabel getLblEmpleado() {
        return lblEmpleado;
    }

    /**
     * Establece el label Empleado
     *
     * @param lblEmpleado JLabel
     */
    public void setLblEmpleado(JLabel lblEmpleado) {
        this.lblEmpleado = lblEmpleado;
    }

    /**
     * Devuelve el label Entregado
     *
     * @return JLabel
     */
    public JLabel getLblEntregado() {
        return lblEntregado;
    }

    /**
     * Establece el label Entregado
     *
     * @param lblEntregado JLabel
     */
    public void setLblEntregado(JLabel lblEntregado) {
        this.lblEntregado = lblEntregado;
    }

    /**
     * Devuelve el label Euro1 (€)
     *
     * @return JLabel
     */
    public JLabel getLblEuro1() {
        return lblEuro1;
    }

    /**
     * Establece el label Euro1 (€)
     *
     * @param lblEuro1 JLabel
     */
    public void setLblEuro1(JLabel lblEuro1) {
        this.lblEuro1 = lblEuro1;
    }

    /**
     * Devuelve el label Euro2 (€)
     *
     * @return JLabel
     */
    public JLabel getLblEuro2() {
        return lblEuro2;
    }

    /**
     * Establece el label Euro2 (€)
     *
     * @param lblEuro2 JLabel
     */
    public void setLblEuro2(JLabel lblEuro2) {
        this.lblEuro2 = lblEuro2;
    }

    /**
     * Devuelve el label Fecha/Hora
     *
     * @return JLabel
     */
    public JLabel getLblFechaHora() {
        return lblFechaHora;
    }

    /**
     * Establece el label Fecha/Hora
     *
     * @param lblFechaHora JLabel
     */
    public void setLblFechaHora(JLabel lblFechaHora) {
        this.lblFechaHora = lblFechaHora;
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
     * Devuelve el label Total
     *
     * @return JLabel
     */
    public JLabel getLblTotal() {
        return lblTotal;
    }

    /**
     * Establece el label Total
     *
     * @param lblTotal JLabel
     */
    public void setLblTotal(JLabel lblTotal) {
        this.lblTotal = lblTotal;
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
     * Devuelve el panel Forma de Pago
     *
     * @return JPanel
     */
    public JPanel getPanelFormaPago() {
        return panelFormaPago;
    }

    /**
     * Establece el panel Forma de Pago
     *
     * @param panelFormaPago JPanel
     */
    public void setPanelFormaPago(JPanel panelFormaPago) {
        this.panelFormaPago = panelFormaPago;
    }

    /**
     * Devuelve el panel con Scroll lateral de la Tabla de Ventas
     *
     * @return JScrollPane
     */
    public JScrollPane getPanelTabla() {
        return panelTabla;
    }

    /**
     * Establece el panel con Scroll lateral de la Tabla de Ventas
     *
     * @param panelTabla JScrollPane
     */
    public void setPanelTabla(JScrollPane panelTabla) {
        this.panelTabla = panelTabla;
    }

    /**
     * Devuelve el panel con Scroll lateral de la Tabla de Detalles
     *
     * @return JScrollPane
     */
    public JScrollPane getPanelTablaDetalles() {
        return panelTablaDetalles;
    }

    /**
     * Establece el panel con Scroll lateral de la Tabla de Detalles
     *
     * @param panelTablaDetalles JScrollPane
     */
    public void setPanelTablaDetalles(JScrollPane panelTablaDetalles) {
        this.panelTablaDetalles = panelTablaDetalles;
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
     * Devuelve el RadioButton Efectivo
     *
     * @return JRadioButton
     */
    public JRadioButton getRbtnEfectivo() {
        return rbtnEfectivo;
    }

    /**
     * Establece el RadioButton Efectivo
     *
     * @param rbtnEfectivo JRadioButton
     */
    public void setRbtnEfectivo(JRadioButton rbtnEfectivo) {
        this.rbtnEfectivo = rbtnEfectivo;
    }

    /**
     * Devuelve el RadioButton Tarjeta
     *
     * @return JRadioButton
     */
    public JRadioButton getRbtnTarjeta() {
        return rbtnTarjeta;
    }

    /**
     * Establece el RadioButton Tarjeta
     *
     * @param rbtnTarjeta JRadioButton
     */
    public void setRbtnTarjeta(JRadioButton rbtnTarjeta) {
        this.rbtnTarjeta = rbtnTarjeta;
    }

    /**
     * Devuelve la tabla Detalles Venta
     *
     * @return JTable
     */
    public JTable getTablaDetallesVenta() {
        return tablaDetallesVenta;
    }

    /**
     * Establece la tabla Detalles Venta
     *
     * @param tablaDetallesVenta JTable
     */
    public void setTablaDetallesVenta(JTable tablaDetallesVenta) {
        this.tablaDetallesVenta = tablaDetallesVenta;
    }

    /**
     * Devuelve la tabla Ventas
     *
     * @return JTable
     */
    public JTable getTablaVentas() {
        return tablaVentas;
    }

    /**
     * Establece la tabla Ventas
     *
     * @param tablaVentas JTable
     */
    public void setTablaVentas(JTable tablaVentas) {
        this.tablaVentas = tablaVentas;
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
     * Devuelve el campo de texto Buscar Cliente
     *
     * @return JTextField
     */
    public JTextField getTxtBuscarCliente() {
        return txtBuscarCliente;
    }

    /**
     * Establece el campo de texto Buscar Cliente
     *
     * @param txtBuscarCliente JTextField
     */
    public void setTxtBuscarCliente(JTextField txtBuscarCliente) {
        this.txtBuscarCliente = txtBuscarCliente;
    }

    /**
     * Devuelve el selector de fecha Buscar Fecha
     *
     * @return JDateChooser
     */
    public JDateChooser getTxtBuscarFecha() {
        return txtBuscarFecha;
    }

    /**
     * Establece el selector de fecha Buscar Fecha
     *
     * @param txtBuscarFecha JDateChooser
     */
    public void setTxtBuscarFecha(JDateChooser txtBuscarFecha) {
        this.txtBuscarFecha = txtBuscarFecha;
    }

    /**
     * Devuelve el campo de texto Cliente
     *
     * @return JTextField
     */
    public JTextField getTxtCliente() {
        return txtCliente;
    }

    /**
     * Establece el campo de texto Cliente
     *
     * @param txtCliente JTextField
     */
    public void setTxtCliente(JTextField txtCliente) {
        this.txtCliente = txtCliente;
    }

    /**
     * Devuelve el campo de texto Empleado
     *
     * @return JTextField
     */
    public JTextField getTxtEmpleado() {
        return txtEmpleado;
    }

    /**
     * Establece el campo de texto Empleado
     *
     * @param txtEmpleado JTextField
     */
    public void setTxtEmpleado(JTextField txtEmpleado) {
        this.txtEmpleado = txtEmpleado;
    }

    /**
     * Devuelve el campo de texto formateado Entregado
     *
     * @return JFormattedTextField
     */
    public JFormattedTextField getTxtEntregado() {
        return txtEntregado;
    }

    /**
     * Establece el campo de texto formateado Entregado
     *
     * @param txtEntregado JFormattedTextField
     */
    public void setTxtEntregado(JFormattedTextField txtEntregado) {
        this.txtEntregado = txtEntregado;
    }

    /**
     * Devuelve el campo de texto formateado Fecha
     *
     * @return JFormattedTextField
     */
    public JFormattedTextField getTxtFecha() {
        return txtFecha;
    }

    /**
     * Establece el campo de texto formateado Fecha
     *
     * @param txtFecha JFormattedTextField
     */
    public void setTxtFecha(JFormattedTextField txtFecha) {
        this.txtFecha = txtFecha;
    }
    
    /**
     * Devuelve el campo de texto formateado Hora
     *
     * @return JFormattedTextField
     */
    public JFormattedTextField getTxtHora() {
        return txtHora;
    }

    /**
     * Establece el campo de texto formateado Hora
     *
     * @param txtHora JFormattedTextField
     */
    public void setTxtHora(JFormattedTextField txtHora) {
        this.txtHora = txtHora;
    }

    /**
     * Devuelve el campo de texto formateado Total
     *
     * @return JFormattedTextField
     */
    public JFormattedTextField getTxtTotal() {
        return txtTotal;
    }

    /**
     * Establece el campo de texto formateado Total
     *
     * @param txtTotal JFormattedTextField
     */
    public void setTxtTotal(JFormattedTextField txtTotal) {
        this.txtTotal = txtTotal;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrpFormaPago = new javax.swing.ButtonGroup();
        panelContenedor = new javax.swing.JPanel();
        panelTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        panelTabla = new javax.swing.JScrollPane();
        tablaVentas = new javax.swing.JTable();
        panelDatos = new javax.swing.JPanel();
        lblCliente = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        btnClienteVenta = new javax.swing.JButton();
        lblEmpleado = new javax.swing.JLabel();
        txtEmpleado = new javax.swing.JTextField();
        btnEmpleadoVenta = new javax.swing.JButton();
        panelFormaPago = new javax.swing.JPanel();
        rbtnEfectivo = new javax.swing.JRadioButton();
        rbtnTarjeta = new javax.swing.JRadioButton();
        lblFechaHora = new javax.swing.JLabel();
        txtFecha = new javax.swing.JFormattedTextField();
        txtHora = new javax.swing.JFormattedTextField();
        lblTotal = new javax.swing.JLabel();
        txtTotal = new javax.swing.JFormattedTextField();
        lblEuro1 = new javax.swing.JLabel();
        lblEntregado = new javax.swing.JLabel();
        txtEntregado = new javax.swing.JFormattedTextField();
        lblEuro2 = new javax.swing.JLabel();
        panelTablaDetalles = new javax.swing.JScrollPane();
        tablaDetallesVenta = new javax.swing.JTable();
        btnNuevaLinea = new javax.swing.JButton();
        btnEliminarLinea = new javax.swing.JButton();
        btnEditarLinea = new javax.swing.JButton();
        btnQuitarCliente = new javax.swing.JButton();
        btnDescuentoTicket = new javax.swing.JButton();
        btnAnularLinea = new javax.swing.JButton();
        panelBotonera = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        lblBuscar = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        txtBuscarFecha = new com.toedter.calendar.JDateChooser();
        lblBuscarFecha = new javax.swing.JLabel();
        lblBuscarCliente = new javax.swing.JLabel();
        txtBuscarCliente = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        btnVaciarFiltrosBusqueda = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitulo.setText("EDITAR VENTAS");

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

        tablaVentas.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaVentas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaVentasMouseClicked(evt);
            }
        });
        panelTabla.setViewportView(tablaVentas);

        panelDatos.setBorder(javax.swing.BorderFactory.createTitledBorder("Venta Seleccionada"));

        lblCliente.setText("Cliente:");

        txtCliente.setEditable(false);

        btnClienteVenta.setText("...");
        btnClienteVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteVentaActionPerformed(evt);
            }
        });

        lblEmpleado.setText("Empleado:");

        txtEmpleado.setEditable(false);

        btnEmpleadoVenta.setText("...");
        btnEmpleadoVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadoVentaActionPerformed(evt);
            }
        });

        panelFormaPago.setBorder(javax.swing.BorderFactory.createTitledBorder("Forma de pago"));

        rbtnEfectivo.setText("Efectivo");
        rbtnEfectivo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbtnEfectivoStateChanged(evt);
            }
        });

        rbtnTarjeta.setText("Tarjeta");
        rbtnTarjeta.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbtnTarjetaStateChanged(evt);
            }
        });

        javax.swing.GroupLayout panelFormaPagoLayout = new javax.swing.GroupLayout(panelFormaPago);
        panelFormaPago.setLayout(panelFormaPagoLayout);
        panelFormaPagoLayout.setHorizontalGroup(
            panelFormaPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormaPagoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFormaPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbtnEfectivo)
                    .addComponent(rbtnTarjeta))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        panelFormaPagoLayout.setVerticalGroup(
            panelFormaPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormaPagoLayout.createSequentialGroup()
                .addComponent(rbtnEfectivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtnTarjeta))
        );

        lblFechaHora.setText("Fecha/Hora");

        txtFecha.setEditable(false);
        try {
            txtFecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txtHora.setEditable(false);
        txtHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance())));

        lblTotal.setText("Total:");

        txtTotal.setEditable(false);
        txtTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        lblEuro1.setText("€");

        lblEntregado.setText("Entregado:");

        txtEntregado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtEntregado.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtEntregado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEntregadoFocusGained(evt);
            }
        });
        txtEntregado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEntregadoActionPerformed(evt);
            }
        });

        lblEuro2.setText("€");

        tablaDetallesVenta.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaDetallesVenta.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        panelTablaDetalles.setViewportView(tablaDetallesVenta);

        btnNuevaLinea.setText("<html><center>Nueva<br>Línea</center></html>");
        btnNuevaLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaLineaActionPerformed(evt);
            }
        });

        btnEliminarLinea.setText("<html><center>Eliminar<br>Línea</center></html>");
        btnEliminarLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarLineaActionPerformed(evt);
            }
        });

        btnEditarLinea.setText("<html><center>Modificar<br>Línea</center></html>");
        btnEditarLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarLineaActionPerformed(evt);
            }
        });

        btnQuitarCliente.setText("Quitar");
        btnQuitarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarClienteActionPerformed(evt);
            }
        });

        btnDescuentoTicket.setText("<html><center>Descuento<br>Tícket</center></html>");
        btnDescuentoTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescuentoTicketActionPerformed(evt);
            }
        });

        btnAnularLinea.setText("<html><center>Anular<br>Línea</center></html>");
        btnAnularLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularLineaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addComponent(btnDescuentoTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(btnAnularLinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNuevaLinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminarLinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditarLinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCliente)
                            .addComponent(lblEmpleado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(txtEmpleado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEmpleadoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(txtCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnClienteVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnQuitarCliente))))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(panelFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(lblFechaHora)
                                .addGap(29, 29, 29))
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEntregado)
                            .addComponent(lblTotal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblEuro1))
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(txtEntregado, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblEuro2)))
                        .addGap(12, 12, 12)))
                .addContainerGap())
            .addComponent(panelTablaDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCliente)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClienteVenta)
                    .addComponent(btnQuitarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEmpleadoVenta)
                    .addComponent(txtEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmpleado))
                .addGap(9, 9, 9)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(lblFechaHora)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTotal)
                                    .addComponent(lblEuro1)
                                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblEntregado)
                                    .addComponent(lblEuro2)
                                    .addComponent(txtEntregado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTablaDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNuevaLinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEliminarLinea)
                        .addComponent(btnEditarLinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDescuentoTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAnularLinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        btnGuardar.setText("<html><center>Guardar<br>Venta</center></html>");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        lblBuscar.setText("Buscar:");

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        txtBuscarFecha.setDateFormatString("dd/MM/yyyy");
        txtBuscarFecha.setPreferredSize(new java.awt.Dimension(87, 22));
        txtBuscarFecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtBuscarFechaPropertyChange(evt);
            }
        });

        lblBuscarFecha.setText("Fecha:");

        lblBuscarCliente.setText("Cliente:");

        txtBuscarCliente.setEditable(false);
        txtBuscarCliente.setPreferredSize(new java.awt.Dimension(220, 22));

        btnBuscarCliente.setText("...");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        btnVaciarFiltrosBusqueda.setText("<html><center>Vaciar filtros<br>búsqueda</center></html>");
        btnVaciarFiltrosBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVaciarFiltrosBusquedaActionPerformed(evt);
            }
        });

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
                .addContainerGap()
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(panelBotoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBotoneraLayout.createSequentialGroup()
                        .addComponent(lblBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblBuscarFecha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBotoneraLayout.createSequentialGroup()
                        .addComponent(lblBuscarCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVaciarFiltrosBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116)
                .addComponent(btnEditar)
                .addContainerGap())
        );
        panelBotoneraLayout.setVerticalGroup(
            panelBotoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotoneraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBotoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBotoneraLayout.createSequentialGroup()
                        .addGroup(panelBotoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtBuscarFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelBotoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblBuscarFecha)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblBuscar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBotoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBuscarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBuscarCliente)
                            .addComponent(lblBuscarCliente)))
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVaciarFiltrosBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBotonera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(panelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelTabla))
                .addGap(0, 0, Short.MAX_VALUE)
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

    private void tablaVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaVentasMouseClicked
        if(evt.getClickCount() == 2) {
            acciones.CargaVentaSeleccionada();
        }
    }//GEN-LAST:event_tablaVentasMouseClicked

    private void btnEditarLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarLineaActionPerformed
        acciones.modificarDetalleVenta();
    }//GEN-LAST:event_btnEditarLineaActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        acciones.CargaVentaSeleccionada();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEmpleadoVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadoVentaActionPerformed
        acciones.SeleccionarEmpleadoTicket();
    }//GEN-LAST:event_btnEmpleadoVentaActionPerformed

    private void btnEliminarLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarLineaActionPerformed
        acciones.eliminarDetalleVenta();
    }//GEN-LAST:event_btnEliminarLineaActionPerformed

    private void btnNuevaLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaLineaActionPerformed
        acciones.nuevoDetalleVenta();
    }//GEN-LAST:event_btnNuevaLineaActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        acciones.ActualizaVenta();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtEntregadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEntregadoActionPerformed
        acciones.ActualizaVenta();
    }//GEN-LAST:event_txtEntregadoActionPerformed

    private void txtEntregadoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEntregadoFocusGained
        SwingUtilities.invokeLater(() -> {
            ((JFormattedTextField)evt.getComponent()).selectAll();
        });
    }//GEN-LAST:event_txtEntregadoFocusGained

    private void btnQuitarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarClienteActionPerformed
        acciones.QuitarCliente();
    }//GEN-LAST:event_btnQuitarClienteActionPerformed

    private void btnDescuentoTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescuentoTicketActionPerformed
        acciones.AplicaDescuentoTicket();
    }//GEN-LAST:event_btnDescuentoTicketActionPerformed

    private void rbtnTarjetaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rbtnTarjetaStateChanged
        if(getRbtnTarjeta().isSelected()) {
            getTxtEntregado().setText(getTxtTotal().getText());
            getTxtEntregado().setEnabled(false);
        }
    }//GEN-LAST:event_rbtnTarjetaStateChanged

    private void rbtnEfectivoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rbtnEfectivoStateChanged
        if(getRbtnEfectivo().isSelected()) {
            getTxtEntregado().setEnabled(true);
        }
    }//GEN-LAST:event_rbtnEfectivoStateChanged

    private void txtBuscarFechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtBuscarFechaPropertyChange
        acciones.BuscarVentas();
    }//GEN-LAST:event_txtBuscarFechaPropertyChange

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        acciones.SeleccionarClienteBusqueda();
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void btnClienteVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteVentaActionPerformed
        acciones.SeleccionarClienteTicket();
    }//GEN-LAST:event_btnClienteVentaActionPerformed

    private void btnVaciarFiltrosBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVaciarFiltrosBusquedaActionPerformed
        acciones.VaciarFiltrosBusqueda();
    }//GEN-LAST:event_btnVaciarFiltrosBusquedaActionPerformed

    private void btnAnularLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularLineaActionPerformed
        acciones.AnularLinea();
    }//GEN-LAST:event_btnAnularLineaActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        acciones.BuscarVentas();
    }//GEN-LAST:event_txtBuscarKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnularLinea;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnClienteVenta;
    private javax.swing.JButton btnDescuentoTicket;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEditarLinea;
    private javax.swing.JButton btnEliminarLinea;
    private javax.swing.JButton btnEmpleadoVenta;
    private javax.swing.ButtonGroup btnGrpFormaPago;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevaLinea;
    private javax.swing.JButton btnQuitarCliente;
    private javax.swing.JButton btnVaciarFiltrosBusqueda;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblBuscarCliente;
    private javax.swing.JLabel lblBuscarFecha;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblEmpleado;
    private javax.swing.JLabel lblEntregado;
    private javax.swing.JLabel lblEuro1;
    private javax.swing.JLabel lblEuro2;
    private javax.swing.JLabel lblFechaHora;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel panelBotonera;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelFormaPago;
    private javax.swing.JScrollPane panelTabla;
    private javax.swing.JScrollPane panelTablaDetalles;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JRadioButton rbtnEfectivo;
    private javax.swing.JRadioButton rbtnTarjeta;
    private javax.swing.JTable tablaDetallesVenta;
    private javax.swing.JTable tablaVentas;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtBuscarCliente;
    private com.toedter.calendar.JDateChooser txtBuscarFecha;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtEmpleado;
    private javax.swing.JFormattedTextField txtEntregado;
    private javax.swing.JFormattedTextField txtFecha;
    private javax.swing.JFormattedTextField txtHora;
    private javax.swing.JFormattedTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
