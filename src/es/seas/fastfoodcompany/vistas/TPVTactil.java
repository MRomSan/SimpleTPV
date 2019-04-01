/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.vistas;

import es.seas.fastfoodcompany.controlador.AccionesTPVTactil;
import es.seas.fastfoodcompany.modelo.entidades.Cliente;
import es.seas.fastfoodcompany.modelo.entidades.Empleado;
import es.seas.fastfoodcompany.modelo.entidades.Venta;
import es.seas.fastfoodcompany.principal.FFCFrame;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

/**
 * Pantalla del TPV Táctil
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class TPVTactil extends javax.swing.JPanel {
    private FFCFrame frame;
    private AccionesTPVTactil acciones;
    private Venta venta;
    private Cliente clienteTicket;
    private Empleado empleadoTicket;

    /**
     * Crea un nuevo formPanel TPVTactil
     * 
     * @param frame FFCFrame Frame en el que se carga el panel
     */
    public TPVTactil(FFCFrame frame) {
        this.frame = frame;
        this.acciones = new AccionesTPVTactil(this);
        this.venta = new Venta();
        this.clienteTicket = null;
        this.empleadoTicket = frame.getUsuario();
        this.venta.setId_empleado(frame.getUsuario().getId());
        initComponents();
        iniciarCategorias();
        this.txtNombreEmpleado.setText(empleadoTicket.getNombre());
        this.txtApellidosEmpleado.setText(empleadoTicket.getApellido1() + " " +
                                                empleadoTicket.getApellido2());
        this.txtTotalTicket.setValue(0.00f);
        this.btnDtoLinea.setEnabled(false);
        this.btnDtoTicket.setEnabled(false);
        this.btnQuitarCliente.setEnabled(false);
        this.btnGrpFormaPago.add(tglBtnEfectivo);
        this.btnGrpFormaPago.add(tglBtnTarjeta);
        acciones.InicializaTabla(false);
    }
    
    //Inicia el panel de Categorías creando Jlabels con imágenes con las 
    //categorías de la base de datos
    private void iniciarCategorias() {
        acciones.CargaCategorias();
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
     * Devuelve las acciones del TPV Táctil
     *
     * @return AccionesTPVTactil
     */
    public AccionesTPVTactil getAcciones() {
        return acciones;
    }

    /**
     * Establece las acciones del TPV Táctil
     *
     * @param acciones AccionesTPVTactil
     */
    public void setAcciones(AccionesTPVTactil acciones) {
        this.acciones = acciones;
    }
    
    /**
     * Devuelve la Venta del ticket actual
     *
     * @return Venta
     */
    public Venta getVenta() {
        return venta;
    }

    /**
     * Establece la Venta del ticket actual
     *
     * @param venta Venta
     */
    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    /**
     * Devuelve el Cliente del Ticket almacenado en la variable de clase del 
     * TPV Táctil
     *
     * @return Cliente
     */
    public Cliente getClienteTicket() {
        return clienteTicket;
    }

    /**
     * Establece el Cliente del Ticket almacenado en la variable de clase del 
     * TPV Táctil
     *
     * @param clienteTicket Cliente
     */
    public void setClienteTicket(Cliente clienteTicket) {
        this.clienteTicket = clienteTicket;
    }

    /**
     * Devuelve el Empleado del Ticket con el botón Cambiar Empleado
     *
     * @return Empleado
     */
    public Empleado getEmpleadoTicket() {
        return empleadoTicket;
    }

    /**
     * Establece el Empleado del Ticket con el botón Cambiar Empleado
     *
     * @param empleadoTicket Empleado
     */
    public void setEmpleadoTicket(Empleado empleadoTicket) {
        this.empleadoTicket = empleadoTicket;
    }

    /**
     * Devuelve el botón Aceptar Edición de la cantidad/descuento
     *
     * @return JButton
     */
    public JButton getBtnAceptarEdicion() {
        return btnAceptarEdicion;
    }

    /**
     * Establece el botón Aceptar Edición de la cantidad/descuento
     *
     * @param btnAceptarEdicion JButton
     */
    public void setBtnAceptarEdicion(JButton btnAceptarEdicion) {
        this.btnAceptarEdicion = btnAceptarEdicion;
    }

    /**
     * Devuelve el botón Anular Ticket
     *
     * @return JButton
     */
    public JButton getBtnAnularTicket() {
        return btnAnularTicket;
    }

    /**
     * Establece el botón Anular Ticket
     *
     * @param btnAnularTicket JButton
     */
    public void setBtnAnularTicket(JButton btnAnularTicket) {
        this.btnAnularTicket = btnAnularTicket;
    }

    /**
     * Devuelve el botón Artículo Abajo (mueve hacia abajo el panel de los 
     * artículos)
     *
     * @return JButton
     */
    public JButton getBtnArticuloAbajo() {
        return btnArticuloAbajo;
    }

    /**
     * Establece el botón Artículo Abajo (mueve hacia abajo el panel de los 
     * artículos)
     *
     * @param btnArticuloAbajo JButton
     */
    public void setBtnArticuloAbajo(JButton btnArticuloAbajo) {
        this.btnArticuloAbajo = btnArticuloAbajo;
    }

    /**
     * Devuelve el botón Artículo Arriba (mueve hacia arriba el panel de los 
     * artículos)
     *
     * @return JButton
     */
    public JButton getBtnArticuloArriba() {
        return btnArticuloArriba;
    }

    /**
     * Establece el botón Artículo Arriba (mueve hacia arriba el panel de los 
     * artículos)
     *
     * @param btnArticuloArriba JButton
     */
    public void setBtnArticuloArriba(JButton btnArticuloArriba) {
        this.btnArticuloArriba = btnArticuloArriba;
    }

    /**
     * Devuelve el botón Borrar que elimina el último caracter de la edición 
     * actual de cantidad o descuento del Ticket
     *
     * @return JButton
     */
    public JButton getBtnBorrar() {
        return btnBorrar;
    }

    /**
     * Establece el botón Borrar que elimina el último caracter de la edición 
     * actual de cantidad o descuento del Ticket
     *
     * @param btnBorrar JButton
     */
    public void setBtnBorrar(JButton btnBorrar) {
        this.btnBorrar = btnBorrar;
    }

    /**
     * Devuelve el botón Cambiar Empleado
     *
     * @return JButton
     */
    public JButton getBtnCambiarEmpleado() {
        return btnCambiarEmpleado;
    }

    /**
     * Establece el botón Cambiar Empleado
     *
     * @param btnCambiarEmpleado JButton
     */
    public void setBtnCambiarEmpleado(JButton btnCambiarEmpleado) {
        this.btnCambiarEmpleado = btnCambiarEmpleado;
    }

    /**
     * Devuelve el botón Categoría Abajo (mueve hacia abajo el panel de las 
     * categorías)
     *
     * @return JButton
     */
    public JButton getBtnCategoriaAbajo() {
        return btnCategoriaAbajo;
    }

    /**
     * Establece el botón Categoría Abajo (mueve hacia abajo el panel de las 
     * categorías)
     *
     * @param btnCategoriaAbajo JButton
     */
    public void setBtnCategoriaAbajo(JButton btnCategoriaAbajo) {
        this.btnCategoriaAbajo = btnCategoriaAbajo;
    }

    /**
     * Devuelve el botón Categoría Arriba (mueve hacia arriba el panel de las 
     * categorías)
     *
     * @return JButton
     */
    public JButton getBtnCategoriaArriba() {
        return btnCategoriaArriba;
    }

    /**
     * Establece el botón Categoría Arriba (mueve hacia arriba el panel de las 
     * categorías)
     *
     * @param btnCategoriaArriba JButton
     */
    public void setBtnCategoriaArriba(JButton btnCategoriaArriba) {
        this.btnCategoriaArriba = btnCategoriaArriba;
    }

    /**
     * Devuelve el botón Cero
     *
     * @return JButton
     */
    public JButton getBtnCero() {
        return btnCero;
    }

    /**
     * Establece el botón Cero
     *
     * @param btnCero JButton
     */
    public void setBtnCero(JButton btnCero) {
        this.btnCero = btnCero;
    }

    /**
     * Devuelve el botón Cinco
     *
     * @return JButton
     */
    public JButton getBtnCinco() {
        return btnCinco;
    }

    /**
     * Establece el botón Cinco
     *
     * @param btnCinco JButton
     */
    public void setBtnCinco(JButton btnCinco) {
        this.btnCinco = btnCinco;
    }

    /**
     * Devuelve el botón Cliente Ticket
     *
     * @return JButton
     */
    public JButton getBtnClienteTicket() {
        return btnClienteTicket;
    }

    /**
     * Establece el botón Cliente Ticket
     *
     * @param btnClienteTicket JButton
     */
    public void setBtnClienteTicket(JButton btnClienteTicket) {
        this.btnClienteTicket = btnClienteTicket;
    }

    /**
     * Devuelve el botón Cobrar
     *
     * @return JButton
     */
    public JButton getBtnCobrar() {
        return btnCobrar;
    }

    /**
     * Establece el botón Cobrar
     *
     * @param btnCobrar JButton
     */
    public void setBtnCobrar(JButton btnCobrar) {
        this.btnCobrar = btnCobrar;
    }

    /**
     * Devuelve el botón Coma
     *
     * @return JButton
     */
    public JButton getBtnComa() {
        return btnComa;
    }

    /**
     * Establece el botón Coma
     *
     * @param btnComa JButton
     */
    public void setBtnComa(JButton btnComa) {
        this.btnComa = btnComa;
    }

    /**
     * Devuelve el botón Cuatro
     *
     * @return JButton
     */
    public JButton getBtnCuatro() {
        return btnCuatro;
    }

    /**
     * Establece el botón Cuatro
     *
     * @param btnCuatro JButton
     */
    public void setBtnCuatro(JButton btnCuatro) {
        this.btnCuatro = btnCuatro;
    }

    /**
     * Devuelve el botón Dos
     *
     * @return JButton
     */
    public JButton getBtnDos() {
        return btnDos;
    }

    /**
     * Establece el botón Dos
     *
     * @param btnDos JButton
     */
    public void setBtnDos(JButton btnDos) {
        this.btnDos = btnDos;
    }
    
    /**
     * Devuelve el botón Dto. Línea
     *
     * @return JButton
     */
    public JButton getBtnDtoLinea() {
        return btnDtoLinea;
    }

    /**
     * Establece el botón Dto. Línea
     *
     * @param btnDtoLinea JButton
     */
    public void setBtnDtoLinea(JButton btnDtoLinea) {
        this.btnDtoLinea = btnDtoLinea;
    }

    /**
     * Devuelve el botón Dto. Ticket
     *
     * @return JButton
     */
    public JButton getBtnDtoTicket() {
        return btnDtoTicket;
    }

    /**
     * Establece el botón Dto. Ticket
     *
     * @param btnDtoTicket JButton
     */
    public void setBtnDtoTicket(JButton btnDtoTicket) {
        this.btnDtoTicket = btnDtoTicket;
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
     * Devuelve el botón Nueve
     *
     * @return JButton
     */
    public JButton getBtnNueve() {
        return btnNueve;
    }

    /**
     * Establece el botón Nueve
     *
     * @param btnNueve JButton
     */
    public void setBtnNueve(JButton btnNueve) {
        this.btnNueve = btnNueve;
    }

    /**
     * Devuelve el botón Ocho
     *
     * @return JButton
     */
    public JButton getBtnOcho() {
        return btnOcho;
    }

    /**
     * Establece el botón Ocho
     *
     * @param btnOcho JButton
     */
    public void setBtnOcho(JButton btnOcho) {
        this.btnOcho = btnOcho;
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
     * Devuelve el botón Seis
     *
     * @return JButton
     */
    public JButton getBtnSeis() {
        return btnSeis;
    }

    /**
     * Establece el botón Seis
     *
     * @param btnSeis JButton
     */
    public void setBtnSeis(JButton btnSeis) {
        this.btnSeis = btnSeis;
    }

    /**
     * Devuelve el botón Siete
     *
     * @return JButton
     */
    public JButton getBtnSiete() {
        return btnSiete;
    }

    /**
     * Establece el botón Siete
     *
     * @param btnSiete JButton
     */
    public void setBtnSiete(JButton btnSiete) {
        this.btnSiete = btnSiete;
    }

    /**
     * Devuelve el botón Ticket Abajo (mueve hacia abajo el panel del Ticket)
     *
     * @return JButton
     */
    public JButton getBtnTicketAbajo() {
        return btnTicketAbajo;
    }

    /**
     * Establece el botón Ticket Abajo (mueve hacia abajo el panel del Ticket)
     *
     * @param btnTicketAbajo JButton
     */
    public void setBtnTicketAbajo(JButton btnTicketAbajo) {
        this.btnTicketAbajo = btnTicketAbajo;
    }

    /**
     * Devuelve el botón Ticket Arriba (mueve hacia arriba el panel del Ticket)
     *
     * @return JButton
     */
    public JButton getBtnTicketArriba() {
        return btnTicketArriba;
    }

    /**
     * Establece el botón Ticket Arriba (mueve hacia arriba el panel del Ticket)
     *
     * @param btnTicketArriba JButton
     */
    public void setBtnTicketArriba(JButton btnTicketArriba) {
        this.btnTicketArriba = btnTicketArriba;
    }

    /**
     * Devuelve el botón Tres
     *
     * @return JButton
     */
    public JButton getBtnTres() {
        return btnTres;
    }

    /**
     * Establece el botón Tres
     *
     * @param btnTres JButton
     */
    public void setBtnTres(JButton btnTres) {
        this.btnTres = btnTres;
    }

    /**
     * Devuelve el botón Uno
     *
     * @return JButton
     */
    public JButton getBtnUno() {
        return btnUno;
    }

    /**
     * Establece el botón Uno
     *
     * @param btnUno JButton
     */
    public void setBtnUno(JButton btnUno) {
        this.btnUno = btnUno;
    }

    /**
     * Devuelve el label Apellidos Cliente
     *
     * @return JLabel
     */
    public JLabel getLblApellidosCliente() {
        return lblApellidosCliente;
    }

    /**
     * Establece el label Apellidos Cliente
     *
     * @param lblApellidosCliente JLabel
     */
    public void setLblApellidosCliente(JLabel lblApellidosCliente) {
        this.lblApellidosCliente = lblApellidosCliente;
    }

    /**
     * Devuelve el label Apellidos Empleado
     *
     * @return JLabel
     */
    public JLabel getLblApellidosEmpleado() {
        return lblApellidosEmpleado;
    }

    /**
     * Establece el label Apellidos Empleado
     *
     * @param lblApellidosEmpleado JLabel
     */
    public void setLblApellidosEmpleado(JLabel lblApellidosEmpleado) {
        this.lblApellidosEmpleado = lblApellidosEmpleado;
    }

    /**
     * Devuelve el label Nombre Cliente
     *
     * @return JLabel
     */
    public JLabel getLblNombreCliente() {
        return lblNombreCliente;
    }

    /**
     * Establece el label Nombre Cliente
     *
     * @param lblNombreCliente JLabel
     */
    public void setLblNombreCliente(JLabel lblNombreCliente) {
        this.lblNombreCliente = lblNombreCliente;
    }

    /**
     * Devuelve el label Nombre Empleado
     *
     * @return JLabel
     */
    public JLabel getLblNombreEmpleado() {
        return lblNombreEmpleado;
    }

    /**
     * Establece el label Nombre Empleado
     *
     * @param lblNombreEmpleado JLabel
     */
    public void setLblNombreEmpleado(JLabel lblNombreEmpleado) {
        this.lblNombreEmpleado = lblNombreEmpleado;
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
     * Devuelve el panel Categorías
     *
     * @return JPanel
     */
    public JPanel getPanelCategorias() {
        return panelCategorias;
    }

    /**
     * Establece el panel Categorías
     *
     * @param panelCategorias JPanel
     */
    public void setPanelCategorias(JPanel panelCategorias) {
        this.panelCategorias = panelCategorias;
    }

    /**
     * Devuelve el panel Productos
     *
     * @return JPanel
     */
    public JPanel getPanelProductos() {
        return panelProductos;
    }

    /**
     * Establece el panel Productos
     *
     * @param panelProductos JPanel
     */
    public void setPanelProductos(JPanel panelProductos) {
        this.panelProductos = panelProductos;
    }

    /**
     * Devuelve el panel con Scroll lateral de Productos
     *
     * @return JScrollPane
     */
    public JScrollPane getPanelScrollProductos() {
        return panelScrollProductos;
    }

    /**
     * Establece el panel con Scroll lateral de Productos
     *
     * @param panelScrollProductos JScrollPane
     */
    public void setPanelScrollProductos(JScrollPane panelScrollProductos) {
        this.panelScrollProductos = panelScrollProductos;
    }

    /**
     * Devuelve el panel con Scroll lateral de Categorias
     *
     * @return JScrollPane
     */
    public JScrollPane getPanelScrollCategorias() {
        return panelScrollCategorias;
    }

    /**
     * Establece el panel con Scroll lateral de Categorias
     *
     * @param panelScrollCategorias JScrollPane
     */
    public void setPanelScrollCategorias(JScrollPane panelScrollCategorias) {
        this.panelScrollCategorias = panelScrollCategorias;
    }

    /**
     * Devuelve el panel Cliente
     *
     * @return JPanel
     */
    public JPanel getPanelCliente() {
        return panelCliente;
    }

    /**
     * Establece el panel Cliente
     *
     * @param panelCliente JPanel
     */
    public void setPanelCliente(JPanel panelCliente) {
        this.panelCliente = panelCliente;
    }

    /**
     * Devuelve el JDialog Cobrar
     *
     * @return JDialog
     */
    public JDialog getPanelCobrar() {
        return panelCobrar;
    }

    /**
     * Establece el JDialog Cobrar
     *
     * @param panelCobrar JDialog
     */
    public void setPanelCobrar(JDialog panelCobrar) {
        this.panelCobrar = panelCobrar;
    }
    
    /**
     * Devuelve el panel Datos Generales
     *
     * @return JPanel
     */
    public JPanel getPanelDatosGenerales() {
        return panelDatosGenerales;
    }

    /**
     * Establece el panel Datos Generales
     *
     * @param panelDatosGenerales JPanel
     */
    public void setPanelDatosGenerales(JPanel panelDatosGenerales) {
        this.panelDatosGenerales = panelDatosGenerales;
    }

    /**
     * Devuelve el panel Empleado
     *
     * @return JPanel
     */
    public JPanel getPanelEmpleado() {
        return panelEmpleado;
    }

    /**
     * Establece el panel Empleado
     *
     * @param panelEmpleado JPanel
     */
    public void setPanelEmpleado(JPanel panelEmpleado) {
        this.panelEmpleado = panelEmpleado;
    }

    /**
     * Devuelve el panel Selección
     *
     * @return JPanel
     */
    public JPanel getPanelSeleccion() {
        return panelSeleccion;
    }

    /**
     * Establece el panel Selección
     *
     * @param panelSeleccion JPanel
     */
    public void setPanelSeleccion(JPanel panelSeleccion) {
        this.panelSeleccion = panelSeleccion;
    }

    /**
     * Devuelve el panel con Scroll lateral de la Tabla Ticket
     *
     * @return JScrollPane
     */
    public JScrollPane getPanelTablaTicket() {
        return panelTablaTicket;
    }

    /**
     * Establece el panel con Scroll lateral de la Tabla Ticket
     *
     * @param panelTablaTicket JScrollPane
     */
    public void setPanelTablaTicket(JScrollPane panelTablaTicket) {
        this.panelTablaTicket = panelTablaTicket;
    }

    /**
     * Devuelve el panel Ticket
     *
     * @return JPanel
     */
    public JPanel getPanelTicket() {
        return panelTicket;
    }

    /**
     * Establece el panel Ticket
     *
     * @param panelTicket JPanel
     */
    public void setPanelTicket(JPanel panelTicket) {
        this.panelTicket = panelTicket;
    }

    /**
     * Devuelve el panel Total Ticket
     *
     * @return JPanel
     */
    public JPanel getPanelTotalTicket() {
        return panelTotalTicket;
    }

    /**
     * Establece el panel Total Ticket
     *
     * @param panelTotalTicket JPanel
     */
    public void setPanelTotalTicket(JPanel panelTotalTicket) {
        this.panelTotalTicket = panelTotalTicket;
    }
    
    /**
     * Devuelve la Tabla Ticket
     *
     * @return JTable
     */
    public JTable getTablaTicket() {
        return tablaTicket;
    }

    /**
     * Establece la Tabla Ticket
     *
     * @param tablaTicket JTable
     */
    public void setTablaTicket(JTable tablaTicket) {
        this.tablaTicket = tablaTicket;
    }
    
    /**
     * Devuelve el label Apellidos Cliente
     *
     * @return JLabel
     */
    public JLabel getTxtApellidosCliente() {
        return txtApellidosCliente;
    }

    /**
     * Establece el label Apellidos Cliente
     *
     * @param txtApellidosCliente JLabel
     */
    public void setTxtApellidosCliente(JLabel txtApellidosCliente) {
        this.txtApellidosCliente = txtApellidosCliente;
    }

    /**
     * Devuelve el label Apellidos Empleado
     *
     * @return JLabel
     */
    public JLabel getTxtApellidosEmpleado() {
        return txtApellidosEmpleado;
    }

    /**
     * Establece el label Apellidos Empleado
     *
     * @param txtApellidosEmpleado JLabel
     */
    public void setTxtApellidosEmpleado(JLabel txtApellidosEmpleado) {
        this.txtApellidosEmpleado = txtApellidosEmpleado;
    }

    /**
     * Devuelve el label Nombre Cliente
     *
     * @return JLabel
     */
    public JLabel getTxtNombreCliente() {
        return txtNombreCliente;
    }

    /**
     * Establece el label Nombre Cliente
     *
     * @param txtNombreCliente JLabel
     */
    public void setTxtNombreCliente(JLabel txtNombreCliente) {
        this.txtNombreCliente = txtNombreCliente;
    }

    /**
     * Devuelve el label Nombre Empleado
     *
     * @return JLabel
     */
    public JLabel getTxtNombreEmpleado() {
        return txtNombreEmpleado;
    }

    /**
     * Establece el label Nombre Empleado
     *
     * @param txtNombreEmpleado JLabel
     */
    public void setTxtNombreEmpleado(JLabel txtNombreEmpleado) {
        this.txtNombreEmpleado = txtNombreEmpleado;
    }

    /**
     * Devuelve el campo de texto formateado Total Ticket
     *
     * @return JFormattedTextField
     */
    public JFormattedTextField getTxtTotalTicket() {
        return txtTotalTicket;
    }

    /**
     * Establece el campo de texto formateado Total Ticket
     *
     * @param txtTotalTicket JFormattedTextField
     */
    public void setTxtTotalTicket(JFormattedTextField txtTotalTicket) {
        this.txtTotalTicket = txtTotalTicket;
    }

    /**
     * Devuelve el botón Aceptar Cobro
     *
     * @return JButton
     */
    public JButton getBtnAceptarCobro() {
        return btnAceptarCobro;
    }

    /**
     * Establece el botón Aceptar Cobro
     *
     * @param btnAceptarCobro JButton
     */
    public void setBtnAceptarCobro(JButton btnAceptarCobro) {
        this.btnAceptarCobro = btnAceptarCobro;
    }

    /**
     * Devuelve el botón Borrar Cobro
     *
     * @return JButton
     */
    public JButton getBtnBorrarCobro() {
        return btnBorrarCobro;
    }

    /**
     * Establece el botón Borrar Cobro
     *
     * @param btnBorrarCobro JButton
     */
    public void setBtnBorrarCobro(JButton btnBorrarCobro) {
        this.btnBorrarCobro = btnBorrarCobro;
    }

    /**
     * Devuelve el botón Cancelar Cobro
     *
     * @return JButton
     */
    public JButton getBtnCancelarCobro() {
        return btnCancelarCobro;
    }

    /**
     * Establece el botón Cancelar Cobro
     *
     * @param btnCancelarCobro JButton
     */
    public void setBtnCancelarCobro(JButton btnCancelarCobro) {
        this.btnCancelarCobro = btnCancelarCobro;
    }

    /**
     * Devuelve el botón Cero de la pantalla Cobro
     *
     * @return JButton
     */
    public JButton getBtnCeroCobro() {
        return btnCeroCobro;
    }

    /**
     * Establece el botón Cero de la pantalla Cobro
     *
     * @param btnCeroCobro JButton
     */
    public void setBtnCeroCobro(JButton btnCeroCobro) {
        this.btnCeroCobro = btnCeroCobro;
    }

    /**
     * Devuelve el botón Cinco de la pantalla Cobro
     *
     * @return JButton
     */
    public JButton getBtnCincoCobro() {
        return btnCincoCobro;
    }

    /**
     * Establece el botón Cinco de la pantalla Cobro
     *
     * @param btnCincoCobro JButton
     */
    public void setBtnCincoCobro(JButton btnCincoCobro) {
        this.btnCincoCobro = btnCincoCobro;
    }

    /**
     * Devuelve el botón Coma de la pantalla Cobro
     *
     * @return JButton
     */
    public JButton getBtnComaCobro() {
        return btnComaCobro;
    }

    /**
     * Establece el botón Coma de la pantalla Cobro
     *
     * @param btnComaCobro JButton
     */
    public void setBtnComaCobro(JButton btnComaCobro) {
        this.btnComaCobro = btnComaCobro;
    }

    /**
     * Devuelve el botón Cuatro de la pantalla Cobro
     *
     * @return JButton
     */
    public JButton getBtnCuatroCobro() {
        return btnCuatroCobro;
    }

    /**
     * Establece el botón Cuatro de la pantalla Cobro
     *
     * @param btnCuatroCobro JButton
     */
    public void setBtnCuatroCobro(JButton btnCuatroCobro) {
        this.btnCuatroCobro = btnCuatroCobro;
    }

    /**
     * Devuelve el botón Dos de la pantalla Cobro
     *
     * @return JButton
     */
    public JButton getBtnDosCobro() {
        return btnDosCobro;
    }

    /**
     * Establece el botón Dos de la pantalla Cobro
     *
     * @param btnDosCobro JButton
     */
    public void setBtnDosCobro(JButton btnDosCobro) {
        this.btnDosCobro = btnDosCobro;
    }

    /**
     * Devuelve el ButtonGroup Forma de Pago
     *
     * @return ButtonGroup
     */
    public ButtonGroup getBtnGrpFormaPago() {
        return btnGrpFormaPago;
    }

    /**
     * Establece el ButtonGroup Forma de Pago
     *
     * @param btnGrpFormaPago ButtonGroup
     */
    public void setBtnGrpFormaPago(ButtonGroup btnGrpFormaPago) {
        this.btnGrpFormaPago = btnGrpFormaPago;
    }

    /**
     * Devuelve el botón Nueve de la pantalla Cobro
     *
     * @return JButton
     */
    public JButton getBtnNueveCobro() {
        return btnNueveCobro;
    }

    /**
     * Establece el botón Nueve de la pantalla Cobro
     *
     * @param btnNueveCobro JButton
     */
    public void setBtnNueveCobro(JButton btnNueveCobro) {
        this.btnNueveCobro = btnNueveCobro;
    }

    /**
     * Devuelve el botón Ocho de la pantalla Cobro
     *
     * @return JButton
     */
    public JButton getBtnOchoCobro() {
        return btnOchoCobro;
    }

    /**
     * Establece el botón Ocho de la pantalla Cobro
     *
     * @param btnOchoCobro JButton
     */
    public void setBtnOchoCobro(JButton btnOchoCobro) {
        this.btnOchoCobro = btnOchoCobro;
    }

    /**
     * Devuelve el botón Seis de la pantalla Cobro
     *
     * @return JButton
     */
    public JButton getBtnSeisCobro() {
        return btnSeisCobro;
    }

    /**
     * Establece el botón Seis de la pantalla Cobro
     *
     * @param btnSeisCobro JButton
     */
    public void setBtnSeisCobro(JButton btnSeisCobro) {
        this.btnSeisCobro = btnSeisCobro;
    }

    /**
     * Devuelve el botón Siete de la pantalla Cobro
     *
     * @return JButton
     */
    public JButton getBtnSieteCobro() {
        return btnSieteCobro;
    }

    /**
     * Establece el botón Siete de la pantalla Cobro
     *
     * @param btnSieteCobro JButton
     */
    public void setBtnSieteCobro(JButton btnSieteCobro) {
        this.btnSieteCobro = btnSieteCobro;
    }

    /**
     * Devuelve el botón Tres de la pantalla Cobro
     *
     * @return JButton
     */
    public JButton getBtnTresCobro() {
        return btnTresCobro;
    }

    /**
     * Establece el botón Tres de la pantalla Cobro
     *
     * @param btnTresCobro JButton
     */
    public void setBtnTresCobro(JButton btnTresCobro) {
        this.btnTresCobro = btnTresCobro;
    }

    /**
     * Devuelve el botón Uno de la pantalla Cobro
     *
     * @return JButton
     */
    public JButton getBtnUnoCobro() {
        return btnUnoCobro;
    }

    /**
     * Establece el botón Uno de la pantalla Cobro
     *
     * @param btnUnoCobro JButton
     */
    public void setBtnUnoCobro(JButton btnUnoCobro) {
        this.btnUnoCobro = btnUnoCobro;
    }

    /**
     * Devuelve el label Devolver
     *
     * @return JLabel
     */
    public JLabel getLblDevolver() {
        return lblDevolver;
    }

    /**
     * Establece el label Devolver
     *
     * @param lblDevolver JLabel
     */
    public void setLblDevolver(JLabel lblDevolver) {
        this.lblDevolver = lblDevolver;
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
     * Devuelve el label Euro de Devolver (€)
     *
     * @return JLabel
     */
    public JLabel getLblEuroDevolver() {
        return lblEuroDevolver;
    }

    /**
     * Establece el label Euro de Devolver (€)
     *
     * @param lblEuroDevolver JLabel
     */
    public void setLblEuroDevolver(JLabel lblEuroDevolver) {
        this.lblEuroDevolver = lblEuroDevolver;
    }

    /**
     * Devuelve el label Euro de Entregado (€)
     *
     * @return JLabel
     */
    public JLabel getLblEuroEntregado() {
        return lblEuroEntregado;
    }

    /**
     * Establece el label Euro de Entregado (€)
     *
     * @param lblEuroEntregado JLabel
     */
    public void setLblEuroEntregado(JLabel lblEuroEntregado) {
        this.lblEuroEntregado = lblEuroEntregado;
    }

    /**
     * Devuelve el label Euro de Total (€)
     *
     * @return JLabel
     */
    public JLabel getLblEuroTotal() {
        return lblEuroTotal;
    }

    /**
     * Establece el label Euro de Total (€)
     *
     * @param lblEuroTotal JLabel
     */
    public void setLblEuroTotal(JLabel lblEuroTotal) {
        this.lblEuroTotal = lblEuroTotal;
    }

    /**
     * Devuelve el label Total Cobro
     *
     * @return JLabel
     */
    public JLabel getLblTotalCobro() {
        return lblTotalCobro;
    }

    /**
     * Establece el label Total Cobro
     *
     * @param lblTotalCobro JLabel
     */
    public void setLblTotalCobro(JLabel lblTotalCobro) {
        this.lblTotalCobro = lblTotalCobro;
    }

    /**
     * Devuelve el panel Contenedor de la pantalla Cobro
     *
     * @return JPanel
     */
    public JPanel getPanelContenedorCobro() {
        return panelContenedorCobro;
    }

    /**
     * Establece el panel Contenedor de la pantalla Cobro
     *
     * @param panelContenedorCobro JPanel
     */
    public void setPanelContenedorCobro(JPanel panelContenedorCobro) {
        this.panelContenedorCobro = panelContenedorCobro;
    }

    /**
     * Devuelve el panel Forma de Pago de la pantalla Cobro
     *
     * @return JPanel
     */
    public JPanel getPanelFormaPago() {
        return panelFormaPago;
    }

    /**
     * Establece el panel Forma de Pago de la pantalla Cobro
     *
     * @param panelFormaPago JPanel
     */
    public void setPanelFormaPago(JPanel panelFormaPago) {
        this.panelFormaPago = panelFormaPago;
    }

    /**
     * Devuelve el botón Toggle Efectivo
     *
     * @return JToggleButton
     */
    public JToggleButton getTglBtnEfectivo() {
        return tglBtnEfectivo;
    }

    /**
     * Establece el botón Toggle Efectivo
     *
     * @param tglBtnEfectivo JToggleButton
     */
    public void setTglBtnEfectivo(JToggleButton tglBtnEfectivo) {
        this.tglBtnEfectivo = tglBtnEfectivo;
    }

    /**
     * Devuelve el botón Toggle Tarjeta
     *
     * @return JToggleButton
     */
    public JToggleButton getTglBtnTarjeta() {
        return tglBtnTarjeta;
    }

    /**
     * Establece el botón Toggle Tarjeta
     *
     * @param tglBtnTarjeta JToggleButton
     */
    public void setTglBtnTarjeta(JToggleButton tglBtnTarjeta) {
        this.tglBtnTarjeta = tglBtnTarjeta;
    }

    /**
     * Devuelve el campo de texto formateado Devolver
     *
     * @return JFormattedTextField
     */
    public JFormattedTextField getTxtDevolver() {
        return txtDevolver;
    }

    /**
     * Establece el campo de texto formateado Devolver
     *
     * @param txtDevolver JFormattedTextField
     */
    public void setTxtDevolver(JFormattedTextField txtDevolver) {
        this.txtDevolver = txtDevolver;
    }

    /**
     * Devuelve el campo de texto Entregado
     *
     * @return JTextField
     */
    public JTextField getTxtEntregado() {
        return txtEntregado;
    }

    /**
     * Establece el campo de texto Entregado
     *
     * @param txtEntregado JTextField
     */
    public void setTxtEntregado(JTextField txtEntregado) {
        this.txtEntregado = txtEntregado;
    }

    /**
     * Devuelve el campo de texto formateado Total de la pantalla Cobro
     *
     * @return JFormattedTextField
     */
    public JFormattedTextField getTxtTotalCobro() {
        return txtTotalCobro;
    }

    /**
     * Establece el campo de texto formateado Total de la pantalla Cobro
     *
     * @param txtTotalCobro JFormattedTextField
     */
    public void setTxtTotalCobro(JFormattedTextField txtTotalCobro) {
        this.txtTotalCobro = txtTotalCobro;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCobrar = new javax.swing.JDialog();
        panelContenedorCobro = new javax.swing.JPanel();
        panelFormaPago = new javax.swing.JPanel();
        tglBtnEfectivo = new javax.swing.JToggleButton();
        tglBtnTarjeta = new javax.swing.JToggleButton();
        btnCeroCobro = new javax.swing.JButton();
        btnUnoCobro = new javax.swing.JButton();
        btnDosCobro = new javax.swing.JButton();
        btnTresCobro = new javax.swing.JButton();
        btnCuatroCobro = new javax.swing.JButton();
        btnCincoCobro = new javax.swing.JButton();
        btnSeisCobro = new javax.swing.JButton();
        btnSieteCobro = new javax.swing.JButton();
        btnOchoCobro = new javax.swing.JButton();
        btnNueveCobro = new javax.swing.JButton();
        btnComaCobro = new javax.swing.JButton();
        btnBorrarCobro = new javax.swing.JButton();
        btnAceptarCobro = new javax.swing.JButton();
        btnCancelarCobro = new javax.swing.JButton();
        lblTotalCobro = new javax.swing.JLabel();
        lblEuroTotal = new javax.swing.JLabel();
        lblEntregado = new javax.swing.JLabel();
        txtEntregado = new javax.swing.JTextField();
        lblEuroDevolver = new javax.swing.JLabel();
        lblDevolver = new javax.swing.JLabel();
        lblEuroEntregado = new javax.swing.JLabel();
        txtTotalCobro = new javax.swing.JFormattedTextField();
        txtDevolver = new javax.swing.JFormattedTextField();
        btnGrpFormaPago = new javax.swing.ButtonGroup();
        panelDatosGenerales = new javax.swing.JPanel();
        panelCliente = new javax.swing.JPanel();
        btnClienteTicket = new javax.swing.JButton();
        lblNombreCliente = new javax.swing.JLabel();
        lblApellidosCliente = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JLabel();
        txtApellidosCliente = new javax.swing.JLabel();
        btnQuitarCliente = new javax.swing.JButton();
        panelEmpleado = new javax.swing.JPanel();
        btnCambiarEmpleado = new javax.swing.JButton();
        lblNombreEmpleado = new javax.swing.JLabel();
        lblApellidosEmpleado = new javax.swing.JLabel();
        txtNombreEmpleado = new javax.swing.JLabel();
        txtApellidosEmpleado = new javax.swing.JLabel();
        panelTicket = new javax.swing.JPanel();
        panelTablaTicket = new javax.swing.JScrollPane();
        tablaTicket = new javax.swing.JTable();
        btnComa = new javax.swing.JButton();
        btnCero = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnUno = new javax.swing.JButton();
        btnDos = new javax.swing.JButton();
        btnTres = new javax.swing.JButton();
        btnCuatro = new javax.swing.JButton();
        btnCinco = new javax.swing.JButton();
        btnSeis = new javax.swing.JButton();
        btnSiete = new javax.swing.JButton();
        btnOcho = new javax.swing.JButton();
        btnNueve = new javax.swing.JButton();
        btnCobrar = new javax.swing.JButton();
        btnTicketAbajo = new javax.swing.JButton();
        btnAnularTicket = new javax.swing.JButton();
        btnAceptarEdicion = new javax.swing.JButton();
        btnEliminarLinea = new javax.swing.JButton();
        btnDtoLinea = new javax.swing.JButton();
        btnTicketArriba = new javax.swing.JButton();
        panelTotalTicket = new javax.swing.JPanel();
        lblTotal = new javax.swing.JLabel();
        txtTotalTicket = new javax.swing.JFormattedTextField();
        btnDtoTicket = new javax.swing.JButton();
        panelSeleccion = new javax.swing.JPanel();
        panelScrollCategorias = new javax.swing.JScrollPane();
        panelCategorias = new javax.swing.JPanel();
        panelScrollProductos = new javax.swing.JScrollPane();
        panelProductos = new javax.swing.JPanel();
        btnCategoriaAbajo = new javax.swing.JButton();
        btnCategoriaArriba = new javax.swing.JButton();
        btnArticuloAbajo = new javax.swing.JButton();
        btnArticuloArriba = new javax.swing.JButton();

        panelCobrar.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        panelCobrar.setTitle("Cobrar Ticket");

        panelContenedorCobro.setLayout(null);

        panelFormaPago.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Forma Pago", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        tglBtnEfectivo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tglBtnEfectivo.setText("Efectivo");
        tglBtnEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglBtnEfectivoActionPerformed(evt);
            }
        });

        tglBtnTarjeta.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tglBtnTarjeta.setText("Tarjeta");
        tglBtnTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglBtnTarjetaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFormaPagoLayout = new javax.swing.GroupLayout(panelFormaPago);
        panelFormaPago.setLayout(panelFormaPagoLayout);
        panelFormaPagoLayout.setHorizontalGroup(
            panelFormaPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormaPagoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFormaPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tglBtnTarjeta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tglBtnEfectivo, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelFormaPagoLayout.setVerticalGroup(
            panelFormaPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormaPagoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tglBtnEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(tglBtnTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelContenedorCobro.add(panelFormaPago);
        panelFormaPago.setBounds(10, 10, 160, 220);

        btnCeroCobro.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnCeroCobro.setText("0");
        btnCeroCobro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCeroCobroActionPerformed(evt);
            }
        });
        panelContenedorCobro.add(btnCeroCobro);
        btnCeroCobro.setBounds(249, 178, 63, 50);

        btnUnoCobro.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnUnoCobro.setText("1");
        btnUnoCobro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnoCobroActionPerformed(evt);
            }
        });
        panelContenedorCobro.add(btnUnoCobro);
        btnUnoCobro.setBounds(180, 122, 63, 50);

        btnDosCobro.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnDosCobro.setText("2");
        btnDosCobro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDosCobroActionPerformed(evt);
            }
        });
        panelContenedorCobro.add(btnDosCobro);
        btnDosCobro.setBounds(249, 122, 63, 50);

        btnTresCobro.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnTresCobro.setText("3");
        btnTresCobro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTresCobroActionPerformed(evt);
            }
        });
        panelContenedorCobro.add(btnTresCobro);
        btnTresCobro.setBounds(318, 122, 63, 50);

        btnCuatroCobro.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnCuatroCobro.setText("4");
        btnCuatroCobro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuatroCobroActionPerformed(evt);
            }
        });
        panelContenedorCobro.add(btnCuatroCobro);
        btnCuatroCobro.setBounds(180, 66, 63, 50);

        btnCincoCobro.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnCincoCobro.setText("5");
        btnCincoCobro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCincoCobroActionPerformed(evt);
            }
        });
        panelContenedorCobro.add(btnCincoCobro);
        btnCincoCobro.setBounds(249, 66, 63, 50);

        btnSeisCobro.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnSeisCobro.setText("6");
        btnSeisCobro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeisCobroActionPerformed(evt);
            }
        });
        panelContenedorCobro.add(btnSeisCobro);
        btnSeisCobro.setBounds(318, 66, 63, 50);

        btnSieteCobro.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnSieteCobro.setText("7");
        btnSieteCobro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSieteCobroActionPerformed(evt);
            }
        });
        panelContenedorCobro.add(btnSieteCobro);
        btnSieteCobro.setBounds(180, 10, 63, 50);

        btnOchoCobro.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnOchoCobro.setText("8");
        btnOchoCobro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOchoCobroActionPerformed(evt);
            }
        });
        panelContenedorCobro.add(btnOchoCobro);
        btnOchoCobro.setBounds(249, 10, 63, 50);

        btnNueveCobro.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnNueveCobro.setText("9");
        btnNueveCobro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNueveCobroActionPerformed(evt);
            }
        });
        panelContenedorCobro.add(btnNueveCobro);
        btnNueveCobro.setBounds(318, 10, 63, 50);

        btnComaCobro.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnComaCobro.setText(",");
        btnComaCobro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComaCobroActionPerformed(evt);
            }
        });
        panelContenedorCobro.add(btnComaCobro);
        btnComaCobro.setBounds(180, 178, 63, 50);

        btnBorrarCobro.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnBorrarCobro.setText("C");
        btnBorrarCobro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarCobroActionPerformed(evt);
            }
        });
        panelContenedorCobro.add(btnBorrarCobro);
        btnBorrarCobro.setBounds(318, 178, 63, 50);

        this.btnAceptarCobro.setIcon(new ImageIcon(
            new ImageIcon(getClass().getResource(
                "/es/seas/fastfoodcompany/iconos/aceptar.png")).getImage().
        getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
btnAceptarCobro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
btnAceptarCobro.setText("Aceptar");
btnAceptarCobro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
btnAceptarCobro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
btnAceptarCobro.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnAceptarCobroActionPerformed(evt);
    }
    });
    panelContenedorCobro.add(btnAceptarCobro);
    btnAceptarCobro.setBounds(400, 30, 100, 80);

    this.btnCancelarCobro.setIcon(new ImageIcon(
        new ImageIcon(getClass().getResource(
            "/es/seas/fastfoodcompany/iconos/cancelar.png")).getImage().
    getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
    btnCancelarCobro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    btnCancelarCobro.setText("Cancelar");
    btnCancelarCobro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    btnCancelarCobro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    btnCancelarCobro.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnCancelarCobroActionPerformed(evt);
        }
    });
    panelContenedorCobro.add(btnCancelarCobro);
    btnCancelarCobro.setBounds(400, 130, 100, 80);

    lblTotalCobro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    lblTotalCobro.setText("Total");
    panelContenedorCobro.add(lblTotalCobro);
    lblTotalCobro.setBounds(530, 20, 40, 17);

    lblEuroTotal.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
    lblEuroTotal.setText(" €");
    panelContenedorCobro.add(lblEuroTotal);
    lblEuroTotal.setBounds(630, 40, 30, 36);

    lblEntregado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    lblEntregado.setText("Entregado");
    panelContenedorCobro.add(lblEntregado);
    lblEntregado.setBounds(530, 90, 80, 17);

    txtEntregado.setEditable(false);
    txtEntregado.setBackground(new java.awt.Color(255, 255, 255));
    txtEntregado.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
    txtEntregado.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    txtEntregado.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
    txtEntregado.setFocusable(false);
    panelContenedorCobro.add(txtEntregado);
    txtEntregado.setBounds(530, 110, 100, 36);

    lblEuroDevolver.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
    lblEuroDevolver.setText(" €");
    panelContenedorCobro.add(lblEuroDevolver);
    lblEuroDevolver.setBounds(630, 180, 30, 36);

    lblDevolver.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    lblDevolver.setText("A Devolver");
    panelContenedorCobro.add(lblDevolver);
    lblDevolver.setBounds(530, 160, 80, 17);

    lblEuroEntregado.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
    lblEuroEntregado.setText(" €");
    panelContenedorCobro.add(lblEuroEntregado);
    lblEuroEntregado.setBounds(630, 110, 30, 36);

    txtTotalCobro.setEditable(false);
    txtTotalCobro.setBackground(new java.awt.Color(255, 255, 255));
    txtTotalCobro.setBorder(null);
    txtTotalCobro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
    txtTotalCobro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    txtTotalCobro.setFocusable(false);
    txtTotalCobro.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
    panelContenedorCobro.add(txtTotalCobro);
    txtTotalCobro.setBounds(530, 40, 100, 36);

    txtDevolver.setEditable(false);
    txtDevolver.setBackground(new java.awt.Color(255, 255, 255));
    txtDevolver.setBorder(null);
    txtDevolver.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
    txtDevolver.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    txtDevolver.setFocusable(false);
    txtDevolver.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
    panelContenedorCobro.add(txtDevolver);
    txtDevolver.setBounds(530, 180, 100, 36);

    javax.swing.GroupLayout panelCobrarLayout = new javax.swing.GroupLayout(panelCobrar.getContentPane());
    panelCobrar.getContentPane().setLayout(panelCobrarLayout);
    panelCobrarLayout.setHorizontalGroup(
        panelCobrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(panelContenedorCobro, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
    );
    panelCobrarLayout.setVerticalGroup(
        panelCobrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(panelContenedorCobro, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
    );

    setPreferredSize(new java.awt.Dimension(800, 600));
    setLayout(null);

    panelDatosGenerales.setLayout(null);

    panelCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cliente", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP));
    panelCliente.setLayout(null);

    this.btnClienteTicket.setIcon(new ImageIcon(
        new ImageIcon(getClass().getResource(
            "/es/seas/fastfoodcompany/iconos/usuario.png")).getImage().
    getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH)));
    btnClienteTicket.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    btnClienteTicket.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnClienteTicketActionPerformed(evt);
        }
    });
    panelCliente.add(btnClienteTicket);
    btnClienteTicket.setBounds(10, 10, 38, 38);

    lblNombreCliente.setText("Nombre:");
    panelCliente.add(lblNombreCliente);
    lblNombreCliente.setBounds(60, 10, 50, 20);

    lblApellidosCliente.setText("Apellidos:");
    panelCliente.add(lblApellidosCliente);
    lblApellidosCliente.setBounds(60, 30, 60, 20);
    panelCliente.add(txtNombreCliente);
    txtNombreCliente.setBounds(120, 10, 130, 20);
    panelCliente.add(txtApellidosCliente);
    txtApellidosCliente.setBounds(120, 30, 130, 20);

    btnQuitarCliente.setText("Quitar");
    btnQuitarCliente.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnQuitarClienteActionPerformed(evt);
        }
    });
    panelCliente.add(btnQuitarCliente);
    btnQuitarCliente.setBounds(260, 15, 70, 30);

    panelDatosGenerales.add(panelCliente);
    panelCliente.setBounds(0, 0, 340, 60);

    panelEmpleado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Empleado", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP));
    panelEmpleado.setLayout(null);

    this.btnCambiarEmpleado.setIcon(new ImageIcon(
        new ImageIcon(getClass().getResource(
            "/es/seas/fastfoodcompany/iconos/cambiarEmpleado.png")).getImage().
    getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH)));
    btnCambiarEmpleado.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnCambiarEmpleadoActionPerformed(evt);
        }
    });
    panelEmpleado.add(btnCambiarEmpleado);
    btnCambiarEmpleado.setBounds(10, 10, 38, 38);

    lblNombreEmpleado.setText("Nombre:");
    panelEmpleado.add(lblNombreEmpleado);
    lblNombreEmpleado.setBounds(60, 10, 50, 20);

    lblApellidosEmpleado.setText("Apellidos:");
    panelEmpleado.add(lblApellidosEmpleado);
    lblApellidosEmpleado.setBounds(60, 30, 60, 20);
    panelEmpleado.add(txtNombreEmpleado);
    txtNombreEmpleado.setBounds(120, 10, 130, 20);
    panelEmpleado.add(txtApellidosEmpleado);
    txtApellidosEmpleado.setBounds(120, 30, 130, 20);

    panelDatosGenerales.add(panelEmpleado);
    panelEmpleado.setBounds(480, 0, 320, 60);

    add(panelDatosGenerales);
    panelDatosGenerales.setBounds(0, 0, 800, 60);

    panelTicket.setLayout(null);

    panelTablaTicket.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    panelTablaTicket.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

    tablaTicket.setModel(new javax.swing.table.DefaultTableModel(
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
    tablaTicket.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    panelTablaTicket.setViewportView(tablaTicket);

    panelTicket.add(panelTablaTicket);
    panelTablaTicket.setBounds(0, 0, 312, 262);

    btnComa.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    btnComa.setText(",");
    btnComa.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnComaActionPerformed(evt);
        }
    });
    panelTicket.add(btnComa);
    btnComa.setBounds(10, 479, 63, 50);

    btnCero.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    btnCero.setText("0");
    btnCero.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnCeroActionPerformed(evt);
        }
    });
    panelTicket.add(btnCero);
    btnCero.setBounds(79, 479, 63, 50);

    btnBorrar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    btnBorrar.setText("C");
    btnBorrar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnBorrarActionPerformed(evt);
        }
    });
    panelTicket.add(btnBorrar);
    btnBorrar.setBounds(148, 479, 63, 50);

    btnUno.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    btnUno.setText("1");
    btnUno.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnUnoActionPerformed(evt);
        }
    });
    panelTicket.add(btnUno);
    btnUno.setBounds(10, 423, 63, 50);

    btnDos.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    btnDos.setText("2");
    btnDos.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnDosActionPerformed(evt);
        }
    });
    panelTicket.add(btnDos);
    btnDos.setBounds(79, 423, 63, 50);

    btnTres.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    btnTres.setText("3");
    btnTres.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnTresActionPerformed(evt);
        }
    });
    panelTicket.add(btnTres);
    btnTres.setBounds(148, 423, 63, 50);

    btnCuatro.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    btnCuatro.setText("4");
    btnCuatro.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnCuatroActionPerformed(evt);
        }
    });
    panelTicket.add(btnCuatro);
    btnCuatro.setBounds(10, 367, 63, 50);

    btnCinco.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    btnCinco.setText("5");
    btnCinco.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnCincoActionPerformed(evt);
        }
    });
    panelTicket.add(btnCinco);
    btnCinco.setBounds(79, 367, 63, 50);

    btnSeis.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    btnSeis.setText("6");
    btnSeis.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSeisActionPerformed(evt);
        }
    });
    panelTicket.add(btnSeis);
    btnSeis.setBounds(148, 367, 63, 50);

    btnSiete.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    btnSiete.setText("7");
    btnSiete.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSieteActionPerformed(evt);
        }
    });
    panelTicket.add(btnSiete);
    btnSiete.setBounds(10, 311, 63, 50);

    btnOcho.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    btnOcho.setText("8");
    btnOcho.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnOchoActionPerformed(evt);
        }
    });
    panelTicket.add(btnOcho);
    btnOcho.setBounds(79, 311, 63, 50);

    btnNueve.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    btnNueve.setText("9");
    btnNueve.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnNueveActionPerformed(evt);
        }
    });
    panelTicket.add(btnNueve);
    btnNueve.setBounds(148, 311, 63, 50);

    this.btnCobrar.setIcon(new ImageIcon(
        new ImageIcon(getClass().getResource(
            "/es/seas/fastfoodcompany/iconos/cobrar.png")).getImage().
    getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)));
    btnCobrar.setText("COBRAR");
    btnCobrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    btnCobrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    btnCobrar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnCobrarActionPerformed(evt);
        }
    });
    panelTicket.add(btnCobrar);
    btnCobrar.setBounds(220, 380, 160, 150);

    this.btnTicketAbajo.setIcon(new ImageIcon(
        new ImageIcon(getClass().getResource(
            "/es/seas/fastfoodcompany/iconos/flechaAbajo.png")).getImage().
    getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH)));
    btnTicketAbajo.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnTicketAbajoActionPerformed(evt);
        }
    });
    panelTicket.add(btnTicketAbajo);
    btnTicketAbajo.setBounds(320, 50, 36, 36);

    this.btnAnularTicket.setIcon(new ImageIcon(
        new ImageIcon(getClass().getResource(
            "/es/seas/fastfoodcompany/iconos/eliminar.png")).getImage().
    getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH)));
    btnAnularTicket.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
    btnAnularTicket.setText("Anular Ticket");
    btnAnularTicket.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    btnAnularTicket.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    btnAnularTicket.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAnularTicketActionPerformed(evt);
        }
    });
    panelTicket.add(btnAnularTicket);
    btnAnularTicket.setBounds(290, 310, 90, 60);

    this.btnAceptarEdicion.setIcon(new ImageIcon(
        new ImageIcon(getClass().getResource(
            "/es/seas/fastfoodcompany/iconos/aceptar.png")).getImage().
    getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
    btnAceptarEdicion.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
    btnAceptarEdicion.setText("<html><body><center>Aceptar<br>Cant./Dto.</center></body></html>");
    btnAceptarEdicion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    btnAceptarEdicion.setIconTextGap(0);
    btnAceptarEdicion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    btnAceptarEdicion.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAceptarEdicionActionPerformed(evt);
        }
    });
    panelTicket.add(btnAceptarEdicion);
    btnAceptarEdicion.setBounds(217, 311, 70, 60);

    this.btnEliminarLinea.setIcon(new ImageIcon(
        new ImageIcon(getClass().getResource(
            "/es/seas/fastfoodcompany/iconos/eliminarlinea.png")).getImage().
    getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
    btnEliminarLinea.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
    btnEliminarLinea.setText("<html><body><center>Eliminar<br>Línea</center></body></html>");
    btnEliminarLinea.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    btnEliminarLinea.setIconTextGap(0);
    btnEliminarLinea.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    btnEliminarLinea.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnEliminarLineaActionPerformed(evt);
        }
    });
    panelTicket.add(btnEliminarLinea);
    btnEliminarLinea.setBounds(320, 170, 60, 60);

    this.btnDtoLinea.setIcon(new ImageIcon(
        new ImageIcon(getClass().getResource(
            "/es/seas/fastfoodcompany/iconos/descuentolinea.png")).getImage().
    getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
    btnDtoLinea.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
    btnDtoLinea.setText("<html><body><center>Dto.<br>Línea</center></body></html>");
    btnDtoLinea.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    btnDtoLinea.setIconTextGap(0);
    btnDtoLinea.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    btnDtoLinea.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnDtoLineaActionPerformed(evt);
        }
    });
    panelTicket.add(btnDtoLinea);
    btnDtoLinea.setBounds(320, 100, 60, 60);

    this.btnTicketArriba.setIcon(new ImageIcon(
        new ImageIcon(getClass().getResource(
            "/es/seas/fastfoodcompany/iconos/flechaArriba.png")).getImage().
    getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH)));
    btnTicketArriba.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnTicketArribaActionPerformed(evt);
        }
    });
    panelTicket.add(btnTicketArriba);
    btnTicketArriba.setBounds(320, 10, 36, 36);

    panelTotalTicket.setBackground(new java.awt.Color(255, 255, 255));
    panelTotalTicket.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    lblTotal.setBackground(new java.awt.Color(255, 255, 255));
    lblTotal.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
    lblTotal.setText("TOTAL");
    lblTotal.setOpaque(true);

    txtTotalTicket.setEditable(false);
    txtTotalTicket.setBackground(new java.awt.Color(255, 255, 255));
    txtTotalTicket.setBorder(null);
    txtTotalTicket.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
    txtTotalTicket.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    txtTotalTicket.setFocusable(false);
    txtTotalTicket.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N

    javax.swing.GroupLayout panelTotalTicketLayout = new javax.swing.GroupLayout(panelTotalTicket);
    panelTotalTicket.setLayout(panelTotalTicketLayout);
    panelTotalTicketLayout.setHorizontalGroup(
        panelTotalTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTotalTicketLayout.createSequentialGroup()
            .addComponent(lblTotal)
            .addGap(0, 0, 0)
            .addComponent(txtTotalTicket, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
    );
    panelTotalTicketLayout.setVerticalGroup(
        panelTotalTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelTotalTicketLayout.createSequentialGroup()
            .addGroup(panelTotalTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtTotalTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    panelTicket.add(panelTotalTicket);
    panelTotalTicket.setBounds(0, 262, 312, 40);

    this.btnDtoTicket.setIcon(new ImageIcon(
        new ImageIcon(getClass().getResource(
            "/es/seas/fastfoodcompany/iconos/descuento.png")).getImage().
    getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
    btnDtoTicket.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
    btnDtoTicket.setText("<html><body><center>Dto.<br>Ticket</center></body></html>");
    btnDtoTicket.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    btnDtoTicket.setIconTextGap(0);
    btnDtoTicket.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    btnDtoTicket.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnDtoTicketActionPerformed(evt);
        }
    });
    panelTicket.add(btnDtoTicket);
    btnDtoTicket.setBounds(320, 240, 60, 60);

    add(panelTicket);
    panelTicket.setBounds(0, 60, 388, 540);

    panelSeleccion.setLayout(null);

    panelScrollCategorias.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    panelScrollCategorias.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

    javax.swing.GroupLayout panelCategoriasLayout = new javax.swing.GroupLayout(panelCategorias);
    panelCategorias.setLayout(panelCategoriasLayout);
    panelCategoriasLayout.setHorizontalGroup(
        panelCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 348, Short.MAX_VALUE)
    );
    panelCategoriasLayout.setVerticalGroup(
        panelCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 178, Short.MAX_VALUE)
    );

    panelScrollCategorias.setViewportView(panelCategorias);

    panelSeleccion.add(panelScrollCategorias);
    panelScrollCategorias.setBounds(0, 0, 350, 180);

    panelScrollProductos.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    panelScrollProductos.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

    javax.swing.GroupLayout panelProductosLayout = new javax.swing.GroupLayout(panelProductos);
    panelProductos.setLayout(panelProductosLayout);
    panelProductosLayout.setHorizontalGroup(
        panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 348, Short.MAX_VALUE)
    );
    panelProductosLayout.setVerticalGroup(
        panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 358, Short.MAX_VALUE)
    );

    panelScrollProductos.setViewportView(panelProductos);

    panelSeleccion.add(panelScrollProductos);
    panelScrollProductos.setBounds(0, 180, 350, 360);

    this.btnCategoriaAbajo.setIcon(new ImageIcon(
        new ImageIcon(getClass().getResource(
            "/es/seas/fastfoodcompany/iconos/flechaAbajo.png")).getImage().
    getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH)));
    btnCategoriaAbajo.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnCategoriaAbajoActionPerformed(evt);
        }
    });
    panelSeleccion.add(btnCategoriaAbajo);
    btnCategoriaAbajo.setBounds(360, 50, 36, 36);

    this.btnCategoriaArriba.setIcon(new ImageIcon(
        new ImageIcon(getClass().getResource(
            "/es/seas/fastfoodcompany/iconos/flechaArriba.png")).getImage().
    getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH)));
    btnCategoriaArriba.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnCategoriaArribaActionPerformed(evt);
        }
    });
    panelSeleccion.add(btnCategoriaArriba);
    btnCategoriaArriba.setBounds(360, 10, 36, 36);

    this.btnArticuloAbajo.setIcon(new ImageIcon(
        new ImageIcon(getClass().getResource(
            "/es/seas/fastfoodcompany/iconos/flechaAbajo.png")).getImage().
    getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH)));
    btnArticuloAbajo.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnArticuloAbajoActionPerformed(evt);
        }
    });
    panelSeleccion.add(btnArticuloAbajo);
    btnArticuloAbajo.setBounds(360, 230, 36, 36);

    this.btnArticuloArriba.setIcon(new ImageIcon(
        new ImageIcon(getClass().getResource(
            "/es/seas/fastfoodcompany/iconos/flechaArriba.png")).getImage().
    getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH)));
    btnArticuloArriba.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnArticuloArribaActionPerformed(evt);
        }
    });
    panelSeleccion.add(btnArticuloArriba);
    btnArticuloArriba.setBounds(360, 190, 36, 36);

    add(panelSeleccion);
    panelSeleccion.setBounds(388, 60, 412, 540);
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnCategoriaArribaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriaArribaActionPerformed
        getPanelScrollCategorias().getVerticalScrollBar().setValue(
            getPanelScrollCategorias().getVerticalScrollBar().getValue()-35);
    }//GEN-LAST:event_btnCategoriaArribaActionPerformed

    private void btnCategoriaAbajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriaAbajoActionPerformed
        getPanelScrollCategorias().getVerticalScrollBar().setValue(
            getPanelScrollCategorias().getVerticalScrollBar().getValue()+35);
    }//GEN-LAST:event_btnCategoriaAbajoActionPerformed

    private void btnArticuloArribaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArticuloArribaActionPerformed
        getPanelScrollProductos().getVerticalScrollBar().setValue(
            getPanelScrollProductos().getVerticalScrollBar().getValue()-50);
    }//GEN-LAST:event_btnArticuloArribaActionPerformed

    private void btnArticuloAbajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArticuloAbajoActionPerformed
        getPanelScrollProductos().getVerticalScrollBar().setValue(
            getPanelScrollProductos().getVerticalScrollBar().getValue()+50);
    }//GEN-LAST:event_btnArticuloAbajoActionPerformed

    private void btnTicketArribaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTicketArribaActionPerformed
        getPanelTablaTicket().getVerticalScrollBar().setValue(
            getPanelTablaTicket().getVerticalScrollBar().getValue()-25);
    }//GEN-LAST:event_btnTicketArribaActionPerformed

    private void btnTicketAbajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTicketAbajoActionPerformed
        getPanelTablaTicket().getVerticalScrollBar().setValue(
            getPanelTablaTicket().getVerticalScrollBar().getValue()+25);
    }//GEN-LAST:event_btnTicketAbajoActionPerformed

    private void btnEliminarLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarLineaActionPerformed
        acciones.EliminarLineaTicket();
    }//GEN-LAST:event_btnEliminarLineaActionPerformed

    private void btnClienteTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteTicketActionPerformed
        acciones.SeleccionarClienteTicket();
    }//GEN-LAST:event_btnClienteTicketActionPerformed

    private void btnQuitarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarClienteActionPerformed
        acciones.QuitarCliente();
    }//GEN-LAST:event_btnQuitarClienteActionPerformed

    private void btnCambiarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarEmpleadoActionPerformed
        acciones.SeleccionarEmpleadoTicket();
    }//GEN-LAST:event_btnCambiarEmpleadoActionPerformed

    private void btnDtoTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDtoTicketActionPerformed
        acciones.DescuentoTicket();
    }//GEN-LAST:event_btnDtoTicketActionPerformed

    private void btnDtoLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDtoLineaActionPerformed
        acciones.DescuentoLinea();
    }//GEN-LAST:event_btnDtoLineaActionPerformed

    private void btnAceptarEdicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarEdicionActionPerformed
        acciones.FinalizaEdicionCelda();
    }//GEN-LAST:event_btnAceptarEdicionActionPerformed

    private void btnAnularTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularTicketActionPerformed
        acciones.AnularTicket();
    }//GEN-LAST:event_btnAnularTicketActionPerformed

    private void btnCeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCeroActionPerformed
        acciones.CambiarCantidad("0");
    }//GEN-LAST:event_btnCeroActionPerformed

    private void btnUnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnoActionPerformed
        acciones.CambiarCantidad("1");
    }//GEN-LAST:event_btnUnoActionPerformed

    private void btnDosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDosActionPerformed
        acciones.CambiarCantidad("2");
    }//GEN-LAST:event_btnDosActionPerformed

    private void btnTresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTresActionPerformed
        acciones.CambiarCantidad("3");
    }//GEN-LAST:event_btnTresActionPerformed

    private void btnCuatroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuatroActionPerformed
        acciones.CambiarCantidad("4");
    }//GEN-LAST:event_btnCuatroActionPerformed

    private void btnCincoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCincoActionPerformed
        acciones.CambiarCantidad("5");
    }//GEN-LAST:event_btnCincoActionPerformed

    private void btnSeisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeisActionPerformed
        acciones.CambiarCantidad("6");
    }//GEN-LAST:event_btnSeisActionPerformed

    private void btnSieteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSieteActionPerformed
        acciones.CambiarCantidad("7");
    }//GEN-LAST:event_btnSieteActionPerformed

    private void btnOchoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOchoActionPerformed
        acciones.CambiarCantidad("8");
    }//GEN-LAST:event_btnOchoActionPerformed

    private void btnNueveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNueveActionPerformed
        acciones.CambiarCantidad("9");
    }//GEN-LAST:event_btnNueveActionPerformed

    private void btnComaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComaActionPerformed
        acciones.CambiarCantidad(",");
    }//GEN-LAST:event_btnComaActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        acciones.EliminarUltimoCaracterEdicion();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCobrarActionPerformed
        acciones.AbrirPantallaCobro();
    }//GEN-LAST:event_btnCobrarActionPerformed

    private void btnComaCobroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComaCobroActionPerformed
        acciones.CambiarEntregado(",");
    }//GEN-LAST:event_btnComaCobroActionPerformed

    private void btnCeroCobroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCeroCobroActionPerformed
        acciones.CambiarEntregado("0");
    }//GEN-LAST:event_btnCeroCobroActionPerformed

    private void btnUnoCobroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnoCobroActionPerformed
        acciones.CambiarEntregado("1");
    }//GEN-LAST:event_btnUnoCobroActionPerformed

    private void btnDosCobroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDosCobroActionPerformed
        acciones.CambiarEntregado("2");
    }//GEN-LAST:event_btnDosCobroActionPerformed

    private void btnTresCobroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTresCobroActionPerformed
        acciones.CambiarEntregado("3");
    }//GEN-LAST:event_btnTresCobroActionPerformed

    private void btnCuatroCobroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuatroCobroActionPerformed
        acciones.CambiarEntregado("4");
    }//GEN-LAST:event_btnCuatroCobroActionPerformed

    private void btnCincoCobroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCincoCobroActionPerformed
        acciones.CambiarEntregado("5");
    }//GEN-LAST:event_btnCincoCobroActionPerformed

    private void btnSeisCobroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeisCobroActionPerformed
        acciones.CambiarEntregado("6");
    }//GEN-LAST:event_btnSeisCobroActionPerformed

    private void btnSieteCobroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSieteCobroActionPerformed
        acciones.CambiarEntregado("7");
    }//GEN-LAST:event_btnSieteCobroActionPerformed

    private void btnOchoCobroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOchoCobroActionPerformed
        acciones.CambiarEntregado("8");
    }//GEN-LAST:event_btnOchoCobroActionPerformed

    private void btnNueveCobroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNueveCobroActionPerformed
        acciones.CambiarEntregado("9");
    }//GEN-LAST:event_btnNueveCobroActionPerformed

    private void btnBorrarCobroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarCobroActionPerformed
        acciones.EliminarUltimoCaracterEntregado();
    }//GEN-LAST:event_btnBorrarCobroActionPerformed

    private void btnAceptarCobroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarCobroActionPerformed
        acciones.FinalizaVenta();
    }//GEN-LAST:event_btnAceptarCobroActionPerformed

    private void btnCancelarCobroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCobroActionPerformed
        this.getPanelCobrar().dispose();
    }//GEN-LAST:event_btnCancelarCobroActionPerformed

    private void tglBtnTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglBtnTarjetaActionPerformed
        acciones.FormaPagoTarjeta();
    }//GEN-LAST:event_tglBtnTarjetaActionPerformed

    private void tglBtnEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglBtnEfectivoActionPerformed
        acciones.FormaPagoEfectivo();
    }//GEN-LAST:event_tglBtnEfectivoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarCobro;
    private javax.swing.JButton btnAceptarEdicion;
    private javax.swing.JButton btnAnularTicket;
    private javax.swing.JButton btnArticuloAbajo;
    private javax.swing.JButton btnArticuloArriba;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBorrarCobro;
    private javax.swing.JButton btnCambiarEmpleado;
    private javax.swing.JButton btnCancelarCobro;
    private javax.swing.JButton btnCategoriaAbajo;
    private javax.swing.JButton btnCategoriaArriba;
    private javax.swing.JButton btnCero;
    private javax.swing.JButton btnCeroCobro;
    private javax.swing.JButton btnCinco;
    private javax.swing.JButton btnCincoCobro;
    private javax.swing.JButton btnClienteTicket;
    private javax.swing.JButton btnCobrar;
    private javax.swing.JButton btnComa;
    private javax.swing.JButton btnComaCobro;
    private javax.swing.JButton btnCuatro;
    private javax.swing.JButton btnCuatroCobro;
    private javax.swing.JButton btnDos;
    private javax.swing.JButton btnDosCobro;
    private javax.swing.JButton btnDtoLinea;
    private javax.swing.JButton btnDtoTicket;
    private javax.swing.JButton btnEliminarLinea;
    private javax.swing.ButtonGroup btnGrpFormaPago;
    private javax.swing.JButton btnNueve;
    private javax.swing.JButton btnNueveCobro;
    private javax.swing.JButton btnOcho;
    private javax.swing.JButton btnOchoCobro;
    private javax.swing.JButton btnQuitarCliente;
    private javax.swing.JButton btnSeis;
    private javax.swing.JButton btnSeisCobro;
    private javax.swing.JButton btnSiete;
    private javax.swing.JButton btnSieteCobro;
    private javax.swing.JButton btnTicketAbajo;
    private javax.swing.JButton btnTicketArriba;
    private javax.swing.JButton btnTres;
    private javax.swing.JButton btnTresCobro;
    private javax.swing.JButton btnUno;
    private javax.swing.JButton btnUnoCobro;
    private javax.swing.JLabel lblApellidosCliente;
    private javax.swing.JLabel lblApellidosEmpleado;
    private javax.swing.JLabel lblDevolver;
    private javax.swing.JLabel lblEntregado;
    private javax.swing.JLabel lblEuroDevolver;
    private javax.swing.JLabel lblEuroEntregado;
    private javax.swing.JLabel lblEuroTotal;
    private javax.swing.JLabel lblNombreCliente;
    private javax.swing.JLabel lblNombreEmpleado;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotalCobro;
    private javax.swing.JPanel panelCategorias;
    private javax.swing.JPanel panelCliente;
    private javax.swing.JDialog panelCobrar;
    private javax.swing.JPanel panelContenedorCobro;
    private javax.swing.JPanel panelDatosGenerales;
    private javax.swing.JPanel panelEmpleado;
    private javax.swing.JPanel panelFormaPago;
    private javax.swing.JPanel panelProductos;
    private javax.swing.JScrollPane panelScrollCategorias;
    private javax.swing.JScrollPane panelScrollProductos;
    private javax.swing.JPanel panelSeleccion;
    private javax.swing.JScrollPane panelTablaTicket;
    private javax.swing.JPanel panelTicket;
    private javax.swing.JPanel panelTotalTicket;
    private javax.swing.JTable tablaTicket;
    private javax.swing.JToggleButton tglBtnEfectivo;
    private javax.swing.JToggleButton tglBtnTarjeta;
    private javax.swing.JLabel txtApellidosCliente;
    private javax.swing.JLabel txtApellidosEmpleado;
    private javax.swing.JFormattedTextField txtDevolver;
    private javax.swing.JTextField txtEntregado;
    private javax.swing.JLabel txtNombreCliente;
    private javax.swing.JLabel txtNombreEmpleado;
    private javax.swing.JFormattedTextField txtTotalCobro;
    private javax.swing.JFormattedTextField txtTotalTicket;
    // End of variables declaration//GEN-END:variables
}
