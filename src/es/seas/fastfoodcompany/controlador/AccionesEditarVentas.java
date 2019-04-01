/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.controlador;

import es.seas.fastfoodcompany.config.ModeloTabla;
import es.seas.fastfoodcompany.gestionbd.ServiceCliente;
import es.seas.fastfoodcompany.gestionbd.ServiceDetallesVenta;
import es.seas.fastfoodcompany.gestionbd.ServiceEmpleado;
import es.seas.fastfoodcompany.gestionbd.ServiceProducto;
import es.seas.fastfoodcompany.gestionbd.ServiceVenta;
import es.seas.fastfoodcompany.modelo.entidades.Cliente;
import es.seas.fastfoodcompany.modelo.entidades.DetallesVenta;
import es.seas.fastfoodcompany.modelo.entidades.Empleado;
import es.seas.fastfoodcompany.modelo.entidades.Producto;
import es.seas.fastfoodcompany.modelo.entidades.Venta;
import es.seas.fastfoodcompany.vistas.FrmSeleccionCliente;
import es.seas.fastfoodcompany.vistas.FrmSeleccionEmpleado;
import es.seas.fastfoodcompany.vistas.PanelAltaEditarDetalleVenta;
import es.seas.fastfoodcompany.vistas.PanelEditarVentas;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.TableColumnModel;

/**
 * Clase que controla las acciones de edición de Ventas
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class AccionesEditarVentas {
    private PanelEditarVentas panel;
    private ModeloTabla tabla;
    private ModeloTabla tablaDetalles;

    /**
     * Constructor predeterminado
     *
     * @param panel PanelEditarVentas al que pertenecen las acciones
     */
    public AccionesEditarVentas(PanelEditarVentas panel) {
        this.panel = panel;
    }
    
    /**
     * Método que inicializa y carga los valores iniciales en la tabla.
     */
    public void InicializaTablas() {
        //Tabla Ventas
        //Modelo
        tabla = new ModeloTabla(new String[]{
            "ID", "Fecha", "Hora", "Forma Pago", "Total (€)", "Entregado (€)"}, 
                0);
        TableColumnModel columnModel;
        
        PintaTabla();
        //Datos
        CargaDatosTabla();
        
        columnModel = panel.getTablaVentas().getColumnModel();
        columnModel.getColumn(1).setPreferredWidth(80);
        columnModel.getColumn(2).setPreferredWidth(60);
        columnModel.getColumn(3).setPreferredWidth(85);
        columnModel.getColumn(4).setPreferredWidth(70);
        columnModel.getColumn(5).setPreferredWidth(90);
        
        //Tabla Detalles
        tablaDetalles = new ModeloTabla(new String[]{
            "ID", "Producto", "Cantidad", "Precio Línea(€)", 
            "Dto. Línea(%)"}, 0);
        
        PintaTablaDetalles();
        cargaDetallesVenta(null);
        
        columnModel = panel.getTablaDetallesVenta().getColumnModel();
        columnModel.getColumn(1).setPreferredWidth(132);
        columnModel.getColumn(2).setPreferredWidth(56);
        columnModel.getColumn(3).setPreferredWidth(90);
        columnModel.getColumn(4).setPreferredWidth(80);
    }

    /**
     * Método que carga los valores en la tabla de ventas
     */
    public void CargaDatosTabla() {
        ServiceVenta ventaDAO = new ServiceVenta();
        List<Venta> ventas = new ArrayList<Venta>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        tabla.setNumRows(0);
        ventas = ventaDAO.findAll();
        for (Venta ventaActual : ventas) {
            Vector filaTabla = new Vector();
            filaTabla.add(ventaActual.getId());
            java.util.Date utilDate = new java.util.Date(
                                            ventaActual.getFecha().getTime());
            filaTabla.add(sdf.format(utilDate));
            filaTabla.add(ventaActual.getHora());
            filaTabla.add(ventaActual.getForma_pago());
            filaTabla.add(Float.toString(ventaActual.getTotal()).
                                            replace('.', ','));
            filaTabla.add(Float.toString(ventaActual.getEntregado()).
                                            replace('.', ','));
            tabla.addRow(filaTabla);
        }
        PintaTabla();
    }
    
    /**
     * Método que carga, en el panel de datos de venta, la venta seleccionada 
     * en la tabla y la guarda en las variables de clase junto con sus Detalles 
     * de venta (VentaSeleccionada y DetallesVentaSeleccionada)
     */
    public void CargaVentaSeleccionada() {
        int filaSeleccionada = panel.getTablaVentas().getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "No hay registros seleccionados");
        } else {
            ServiceVenta ventaDAO = new ServiceVenta();
            ServiceDetallesVenta detVentaDAO = new ServiceDetallesVenta();
            Venta venta;
            List<DetallesVenta> detallesVenta;
            
            venta = ventaDAO.findById((int) panel.getTablaVentas().
                        getValueAt(filaSeleccionada, 0));
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            boolean hayCliente;
            
            habilitaCampos(true);
            
            //Carga Datos de la venta
            panel.setVentaSeleccionada(venta);
            if(venta.getId_cliente() != null && venta.getId_cliente() > 0) {
                cargaCliente(venta.getId_cliente());
                hayCliente = true;
            } else {
                panel.setClienteVenta(null);
                panel.getVentaSeleccionada().setId_cliente(null);
                panel.getTxtCliente().setText("");
                panel.getBtnQuitarCliente().setEnabled(false);
                hayCliente = false;
            }
            cargaEmpleado(venta.getId_empleado());
            if (venta.getForma_pago().equals("Efectivo")) {
                panel.getRbtnEfectivo().setSelected(true);
            } else if (venta.getForma_pago().equals("Tarjeta")) {
                panel.getRbtnTarjeta().setSelected(true);
                panel.getTxtEntregado().setEnabled(false);
            }
            java.util.Date utilDate = new java.util.Date(
                                                venta.getFecha().getTime());
            panel.getTxtFecha().setText(sdf.format(utilDate));
            panel.getTxtHora().setText(venta.getHora());
            panel.getTxtTotal().setText(Float.toString(venta.getTotal()).
                                                replace('.', ','));
            panel.getTxtEntregado().setText(Float.toString(venta.getEntregado()).
                                                replace('.', ','));
            
            //Carga detalles de la venta seleccionada
            CargaModeloTablaDetalles(hayCliente);
            detallesVenta = detVentaDAO.findByVenta(venta.getId());
            panel.setDetallesVentaSeleccionada(detallesVenta);
            cargaDetallesVenta(detallesVenta);
            
            panel.getBtnDescuentoTicket().setEnabled(hayCliente);
        }
    }
    
    /**
     * Método que actualiza la venta en la base de datos y por pantalla
     */
    public void ActualizaVenta() {
        if (panel.getVentaSeleccionada() == null) {
            JOptionPane.showMessageDialog(null, "No hay registro cargado");
        } else {
            if(ValidaCampos()){
                ServiceVenta ventaDAO = new ServiceVenta();
                Venta venta = panel.getVentaSeleccionada();
                
                if (panel.getRbtnEfectivo().isSelected())
                    venta.setForma_pago(panel.getRbtnEfectivo().getText());
                if (panel.getRbtnTarjeta().isSelected()) {
                    venta.setForma_pago(panel.getRbtnTarjeta().getText());
                    panel.getTxtEntregado().setText(panel.getTxtTotal().getText());
                }
                
                venta.setTotal(Float.parseFloat(
                                        panel.getTxtTotal().getText().
                                                    replace(',', '.')));
                venta.setEntregado(Float.parseFloat(
                                        panel.getTxtEntregado().getText().
                                                    replace(',', '.')));
                
                //Actualiza los detalles de venta
                ActualizaDetallesVenta();
                
                //Actualiza la venta
                ventaDAO.update(venta);
                
                panel.setVentaSeleccionada(null);
                panel.setDetallesVentaSeleccionada(null);
                panel.getTxtCliente().setText("");
                panel.setClienteVenta(null);
                panel.getTxtEmpleado().setText("");
                panel.setEmpleadoVenta(null);
                panel.getBtnGrpFormaPago().clearSelection();
                panel.getTxtFecha().setText("");
                panel.getTxtHora().setText("");
                panel.getTxtTotal().setText("");
                panel.getTxtEntregado().setText("");
                panel.getBtnDescuentoTicket().setEnabled(false);
                tablaDetalles.setNumRows(0);
                PintaTablaDetalles();
                
                tabla.setNumRows(0);
                BuscarVentas();
                
                JOptionPane.showMessageDialog(null, "Venta actualizada. \n"
                        + "  Entregado : " + 
                        Float.toString(venta.getEntregado()).replace('.', ',') 
                        + " € \n  Total: " +
                        Float.toString(venta.getTotal()).replace('.', ',')
                        + " € \n  Devolución: " + 
                        Double.toString(Math.round(
                                (venta.getEntregado() - venta.getTotal())*100.0)
                                / 100.0).replace('.', ',')
                        + " €");
                
                habilitaCampos(false);
            }
        }
    }
    
    //Compara los detalles de venta actuales con los guardados y actualiza la 
    //base de datos en función de si el detalle se ha modificado, es nuevo o se 
    //ha eliminado
    private void ActualizaDetallesVenta() {
          List<DetallesVenta> detallesActuales, detallesGuardados;
          ServiceDetallesVenta detVentaDAO = new ServiceDetallesVenta();
          
          detallesActuales = panel.getDetallesVentaSeleccionada();
          detallesGuardados = detVentaDAO.findByVenta(
                                        panel.getVentaSeleccionada().getId());
          
          //Comparo los detalles de venta actuales con los guardados en la base 
          //de datos
          
          //Eliminación
          //Si el detalle está en los guardados pero no en los actuales, se borra
          for(int i = detallesGuardados.size()-1; i >= 0; i--) {
              boolean detalleEncontrado = false;
              for(DetallesVenta detVentaActual : detallesActuales) {
                  if(detallesGuardados.get(i).getId() == detVentaActual.getId())
                      detalleEncontrado = true;
              }
              if(!detalleEncontrado)
                  detVentaDAO.delete(detallesGuardados.get(i).getId());
          }
          
          //Actualización
          //Si el detalle actual se encuentra en los guardados, se actualiza
          for(DetallesVenta detVentaActual : detallesActuales) {
              boolean detalleEncontrado = false;
              for(DetallesVenta detVentaGuardado : detallesGuardados) {
                  if(detVentaGuardado.getId() == detVentaActual.getId())
                      detalleEncontrado = true;
              }
              if(detalleEncontrado)
                  detVentaDAO.update(detVentaActual);
          }
          
          //Inserción
          //Si el detalle actual tiene id = 0 es nuevo y se inserta
          for(DetallesVenta detVentaActual : detallesActuales) {
              if(detVentaActual.getId() == 0)
                  detVentaDAO.insert(detVentaActual);
          }
    }
    
    /**
     * Método que busca las ventas cuyos campos coincidan total o parcialmente
     * con el texto introducido
     */
    public void BuscarVentas() {
        ServiceVenta ventaDAO = new ServiceVenta();
        List<Venta> ventas = new ArrayList<Venta>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String texto = panel.getTxtBuscar().getText();
        String fecha = null;
        Integer clienteBusqueda = null;
        
        if(panel.getTxtBuscarFecha().getDate() != null) {
            //Extrae la fecha del JDateChooser como String
            fecha = new Date(panel.getTxtBuscarFecha().getDate().getTime()).toString();
        }
        if(panel.getClienteBusqueda() != null) {
            clienteBusqueda = panel.getClienteBusqueda().getId();
        }
        
        ventas = ventaDAO.buscar(texto, fecha, clienteBusqueda);
        
        tabla.setNumRows(0);
        for (Venta ventaActual : ventas) {
            Vector filaTabla = new Vector();
            filaTabla.add(ventaActual.getId());
            java.util.Date utilDate = new java.util.Date(
                                            ventaActual.getFecha().getTime());
            filaTabla.add(sdf.format(utilDate));
            filaTabla.add(ventaActual.getHora());
            filaTabla.add(ventaActual.getForma_pago());
            filaTabla.add(Float.toString(ventaActual.getTotal()).
                                            replace('.', ','));
            filaTabla.add(Float.toString(ventaActual.getEntregado()).
                                            replace('.', ','));
            tabla.addRow(filaTabla);
        }
        PintaTabla();
    }
    
    /**
     * Crea un JDialog FrmSeleccionCliente para seleccionar un cliente y mostrar 
     * sus tickets
     */
    public void SeleccionarClienteBusqueda() {
        FrmSeleccionCliente selClienteBusqueda = new FrmSeleccionCliente(
            (JFrame) SwingUtilities.getWindowAncestor(panel), true);
        selClienteBusqueda.setLocationRelativeTo(panel);
        selClienteBusqueda.setVisible(true);
        
        if (selClienteBusqueda.getClienteSeleccionado() != null) {
            panel.setClienteBusqueda(selClienteBusqueda.
                    getClienteSeleccionado());
            panel.getTxtBuscarCliente().setText(
                    panel.getClienteBusqueda().getApellido1() + " " +
                    panel.getClienteBusqueda().getApellido2() + ", " +
                    panel.getClienteBusqueda().getNombre());
        }
        BuscarVentas();
    }
    
    /**
     * Vacía los filtros de búsqueda para mostrar todas las ventas
     */
    public void VaciarFiltrosBusqueda() {
        panel.getTxtBuscar().setText("");
        panel.getTxtBuscarCliente().setText("");
        panel.setClienteBusqueda(null);
        panel.getTxtBuscarFecha().setDate(null);
    }
    
    /**
     * Crea un JDialog FrmSeleccionCliente para seleccionar un cliente de los 
     * disponibles en la base de datos y lo almacena en una variable de la clase 
     * PanelEditarVenta
     */
    public void SeleccionarClienteTicket() {
        FrmSeleccionCliente seleccionarCliente = new FrmSeleccionCliente(
            (JFrame) SwingUtilities.getWindowAncestor(panel), true);
        seleccionarCliente.setLocationRelativeTo(panel);
        seleccionarCliente.setVisible(true);
        
        if (seleccionarCliente.getClienteSeleccionado() != null) {
            panel.setClienteVenta(seleccionarCliente.
                    getClienteSeleccionado());
            panel.getTxtCliente().setText(
                    panel.getClienteVenta().getApellido1() + " " +
                    panel.getClienteVenta().getApellido2() + ", " +
                    panel.getClienteVenta().getNombre());
            
            panel.getVentaSeleccionada().setId_cliente(
                    seleccionarCliente.getClienteSeleccionado().getId());
            
            CargaModeloTablaDetalles(true);
            cargaDetallesVenta(panel.getDetallesVentaSeleccionada());
            
            panel.getBtnDescuentoTicket().setEnabled(true);
            panel.getBtnQuitarCliente().setEnabled(true);
        }
    }
    
    /**
     * Crea un JDialog FrmSeleccionEmpleado para seleccionar un empleado de los 
     * disponibles en la base de datos y lo almacena en una variable de la clase 
     * PanelEditarVenta
     */
    public void SeleccionarEmpleadoTicket() {
        FrmSeleccionEmpleado seleccionarEmpleado = new FrmSeleccionEmpleado(
            (JFrame) SwingUtilities.getWindowAncestor(panel), true);
        seleccionarEmpleado.setLocationRelativeTo(panel);
        seleccionarEmpleado.setVisible(true);
        
        if (seleccionarEmpleado.getEmpleadoSeleccionado() != null) {
            panel.setEmpleadoVenta(seleccionarEmpleado.
                    getEmpleadoSeleccionado());
            panel.getTxtEmpleado().setText(
                    panel.getEmpleadoVenta().getApellido1() + " " +
                    panel.getEmpleadoVenta().getApellido2() + ", " +
                    panel.getEmpleadoVenta().getNombre());
            
            panel.getVentaSeleccionada().setId_empleado(
                    seleccionarEmpleado.getEmpleadoSeleccionado().getId());
        }
    }
    
    /**
     * Quita al Cliente de la Venta actual y borra los descuentos
     */
    public void QuitarCliente() {
        int confirmacion;
        confirmacion = JOptionPane.showConfirmDialog(null, "¿Desea desvincular"
                + " el cliente de la venta actual?\nEsta acción borrará "
                + "todos los descuentos actuales");
        
        if (confirmacion == JOptionPane.YES_OPTION) {
            ServiceProducto productoDAO = new ServiceProducto();
            Producto producto;
            
            panel.getVentaSeleccionada().setId_cliente(null);
            
            for (DetallesVenta detalleVentaActual : 
                    panel.getDetallesVentaSeleccionada()) {
                double precioLinea;
                
                producto = productoDAO.findById(
                                        detalleVentaActual.getId_producto());
                
                detalleVentaActual.setDescuento_linea(0);
                precioLinea = detalleVentaActual.getCantidad() * 
                                producto.getPrecio();
                precioLinea = Math.round(precioLinea * 100.0) / 100.0;
                detalleVentaActual.setPrecio_linea(
                            Float.parseFloat(Double.toString(precioLinea)));
            }
            
            //Carga los datos de los Detalles sin los descuentos
            CargaModeloTablaDetalles(false);
            cargaDetallesVenta(panel.getDetallesVentaSeleccionada());
            
            panel.getBtnDescuentoTicket().setEnabled(false);
            panel.getTxtCliente().setText("");
            panel.setClienteVenta(null);
            panel.getBtnQuitarCliente().setEnabled(false);
        }
    }
    
    /**
     * Aplica el descuento seleccionado a todas las líneas actuales de la venta
     */
    public void AplicaDescuentoTicket() {
        boolean salir = false;
        do{
            try {
                List<DetallesVenta> detallesVenta = new ArrayList<DetallesVenta>();
                String descuentoIntroducido;
                double descuento;

                descuentoIntroducido = 
                    JOptionPane.showInputDialog(panel, "Introduzca el descuento: ");

                if(descuentoIntroducido != null) {
                    descuento = Double.parseDouble(descuentoIntroducido);

                    detallesVenta = panel.getDetallesVentaSeleccionada();

                    for (DetallesVenta detVentaActual : detallesVenta) {
                        ServiceProducto productoDAO = new ServiceProducto();
                        Producto producto;
                        double precioLinea;

                        producto = productoDAO.findById(
                                detVentaActual.getId_producto());
                        
                        precioLinea = producto.getPrecio() * 
                                detVentaActual.getCantidad();
                        precioLinea -= (precioLinea * descuento) / 100;
                        precioLinea = Math.round(precioLinea * 100.0) / 100.0;

                        detVentaActual.setDescuento_linea(
                                Float.parseFloat(Double.toString(descuento)));
                        detVentaActual.setPrecio_linea(
                                Float.parseFloat(Double.toString(precioLinea)));
                    }

                    panel.setDetallesVentaSeleccionada(detallesVenta);
                    cargaDetallesVenta(detallesVenta);
                    
                    salir = true;

                } else salir = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(panel, "Debe introducir un número");
            }
        } while(!salir);
    }
    
    /**
     * Anula las líneas seleccionadas
     */
    public void AnularLinea() {
        int[] filasSeleccionadas;
        
        filasSeleccionadas = panel.getTablaDetallesVenta().getSelectedRows();
        if (filasSeleccionadas.length == 0) {
            JOptionPane.showMessageDialog(null, "No hay registros seleccionados");
        } else {
            for (int i = 0; i < filasSeleccionadas.length; i++) {
                DetallesVenta detVentaSeleccionado;
                DetallesVenta detVentaAnulado = new DetallesVenta();

                String nombreProducto = panel.
                        getTablaDetallesVenta().getValueAt(
                                panel.getTablaDetallesVenta().
                                    getSelectedRows()[i], 1).toString();
                float precioLinea = Float.parseFloat(panel.
                        getTablaDetallesVenta().getValueAt(
                                panel.getTablaDetallesVenta().
                                    getSelectedRows()[i], 3).
                                        toString().replace(',', '.'));

                detVentaSeleccionado = BuscaDetVentaSeleccionadoEnExistentes(
                                        nombreProducto, precioLinea);
                
                //detVentaSeleccionado = panel.getDetallesVentaSeleccionada().
                
                detVentaAnulado.setId(0);
                detVentaAnulado.setId_venta(detVentaSeleccionado.getId_venta());
                detVentaAnulado.setId_producto(
                        detVentaSeleccionado.getId_producto());
                detVentaAnulado.setDescuento_linea(
                        detVentaSeleccionado.getDescuento_linea());
                detVentaAnulado.setCantidad(
                        (-1) * detVentaSeleccionado.getCantidad());
                detVentaAnulado.setPrecio_linea(
                        (-1) * detVentaSeleccionado.getPrecio_linea());
                
                panel.getDetallesVentaSeleccionada().add(detVentaAnulado);
            }
            cargaDetallesVenta(panel.getDetallesVentaSeleccionada());
        }
    }
    
    /**
     * Abre un nuevo formulario de alta de Detalles de Venta para la venta 
     * actual
     */
    public void nuevoDetalleVenta() {
        JDialog jDialog = new JDialog(panel.getFrame(), true);
        PanelAltaEditarDetalleVenta nuevoDetalleVenta = 
                new PanelAltaEditarDetalleVenta(null);
        nuevoDetalleVenta.setVenta(panel.getVentaSeleccionada());
        nuevoDetalleVenta.setDetallesVentaExistentes(
                                   panel.getDetallesVentaSeleccionada());
        nuevoDetalleVenta.setDetVentaModificado(null);
        
        if(panel.getClienteVenta() == null) {
            nuevoDetalleVenta.getLblDescuento().setVisible(false);
            nuevoDetalleVenta.getTxtDescuento().setVisible(false);
        }
        jDialog.setTitle("Nuevo Detalle de Venta");
        jDialog.add(nuevoDetalleVenta);
        jDialog.getContentPane().setPreferredSize(
                nuevoDetalleVenta.getPreferredSize());
        jDialog.setResizable(false);
        jDialog.pack();
        jDialog.setLocationRelativeTo(panel);
        jDialog.setVisible(true);
        
        panel.setDetallesVentaSeleccionada(
                            nuevoDetalleVenta.getDetallesVentaExistentes());
        
        cargaDetallesVenta(panel.getDetallesVentaSeleccionada());
    }
    
    /**
     * Elimina el detalle de venta seleccionado en la tabla
     */
    public void eliminarDetalleVenta() {
        int[] filasSeleccionadas;
        
        filasSeleccionadas = panel.getTablaDetallesVenta().getSelectedRows();
        if (filasSeleccionadas.length == 0) {
            JOptionPane.showMessageDialog(null, "No hay registros seleccionados");
        } else {
            int confirmacion;
            confirmacion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar"
                    + " (" + filasSeleccionadas.length + 
                    ") registro(s) seleccionados permanentemente?");
            if (confirmacion == JOptionPane.YES_OPTION) {
                double totalVenta = Double.parseDouble(
                                        panel.getTxtTotal().getText().
                                                replace(',', '.'));
                
                for (int i = filasSeleccionadas.length-1; i >= 0; i--) {
                    DetallesVenta detalleVenta;
                    
                    String nombreProducto = (String) panel.
                            getTablaDetallesVenta().getValueAt(
                                    panel.getTablaDetallesVenta().
                                        getSelectedRows()[i], 1);
                    float precioLinea = Float.parseFloat(panel.
                        getTablaDetallesVenta().getValueAt(
                                panel.getTablaDetallesVenta().
                                    getSelectedRows()[i], 3).
                                        toString().replace(',', '.'));
                    
                    detalleVenta = BuscaDetVentaSeleccionadoEnExistentes(nombreProducto, precioLinea);
                    
                    totalVenta -= Double.parseDouble(panel.
                            getTablaDetallesVenta().getValueAt(
                                    filasSeleccionadas[i], 3).toString().
                                        replace(',', '.'));
                    totalVenta = Math.round(totalVenta*100.0)/100.0;
                    
                    panel.getDetallesVentaSeleccionada().remove(detalleVenta);
                    tablaDetalles.removeRow(filasSeleccionadas[i]);
                }
                PintaTablaDetalles();
                
                panel.getTxtTotal().setText(Double.toString(totalVenta).
                                            replace('.', ','));
            }
        }
    }
    
    /**
     * Abre un nuevo formulario de edición de Detalles de Venta para el detalle 
     * de venta seleccionado
     */
    public void modificarDetalleVenta() {
        int[] filasSeleccionadas;
        JDialog jDialog = new JDialog(panel.getFrame(), true);
        
        filasSeleccionadas = panel.getTablaDetallesVenta().getSelectedRows();
        if (filasSeleccionadas.length == 0) {
            JOptionPane.showMessageDialog(null, "No hay registro seleccionado");
        } else if (filasSeleccionadas.length > 1){
            JOptionPane.showMessageDialog(null, "Seleccione sólo un registro");
        } else {
            DetallesVenta detalleVenta;
            
            String nombreProducto = (String) panel.getTablaDetallesVenta().
                                getValueAt(panel.getTablaDetallesVenta().
                                    getSelectedRows()[0], 1);
            float precioLinea = Float.parseFloat(panel.
                        getTablaDetallesVenta().getValueAt(
                                panel.getTablaDetallesVenta().
                                    getSelectedRows()[0], 3).
                                        toString().replace(',', '.'));
            
            //Busca el detalle de venta seleccionado a través de su producto
            detalleVenta = BuscaDetVentaSeleccionadoEnExistentes(nombreProducto, precioLinea);
            
            PanelAltaEditarDetalleVenta modificarDetalleVenta = new 
                                    PanelAltaEditarDetalleVenta(detalleVenta);
            modificarDetalleVenta.setVenta(panel.getVentaSeleccionada());
            modificarDetalleVenta.setDetallesVentaExistentes(
                    panel.getDetallesVentaSeleccionada());
            
            if(panel.getClienteVenta()== null) {
                modificarDetalleVenta.getLblDescuento().setVisible(false);
                modificarDetalleVenta.getTxtDescuento().setVisible(false);
            }
            modificarDetalleVenta.getBtnBuscarProducto().setVisible(false);
            
            jDialog.setTitle("Modificar Detalle de Venta");
            jDialog.add(modificarDetalleVenta);
            jDialog.getContentPane().setPreferredSize(
                    modificarDetalleVenta.getPreferredSize());
            jDialog.setResizable(false);
            jDialog.pack();
            jDialog.setLocationRelativeTo(panel);
            jDialog.setVisible(true);
            
            panel.setDetVentaModificado(
                    modificarDetalleVenta.getDetVentaModificado());

            cargaDetallesVenta(panel.getDetallesVentaSeleccionada());
        }
    }
    
    //Busca por IdProducto en los detalles de venta cargados y devuelve el 
    //Detalle de venta
    private DetallesVenta BuscaDetVentaSeleccionadoEnExistentes(
            String nombreProducto, float precioLinea) {
        ServiceProducto productoDAO = new ServiceProducto();
        Producto producto;
        producto = productoDAO.findByNombre(nombreProducto);
        for(DetallesVenta detalleActual : panel.getDetallesVentaSeleccionada()){
            if(detalleActual.getId_producto() == producto.getId() && 
                    detalleActual.getPrecio_linea() == precioLinea) {
                return detalleActual;
            }
        }
        return null;
    }
    
    //Carga el cliente de la venta seleccionada
    private void cargaCliente(Integer idCliente) {
        ServiceCliente clienteDAO = new ServiceCliente();
        Cliente clienteSeleccionado;
        String textoCliente = "";
        
        clienteSeleccionado = clienteDAO.findById(idCliente);
        textoCliente += clienteSeleccionado.getApellido1() + " " + 
                        clienteSeleccionado.getApellido2() + ", " + 
                        clienteSeleccionado.getNombre();
        
        panel.setClienteVenta(clienteSeleccionado);
        panel.getTxtCliente().setText(textoCliente);
    }

    //Carga el empleado de la venta seleccionada
    private void cargaEmpleado(int idEmpleado) {
        ServiceEmpleado empleadoDAO = new ServiceEmpleado();
        Empleado empleadoSeleccionado;
        String textoEmpleado = "";
        
        empleadoSeleccionado = empleadoDAO.findById(idEmpleado);
        textoEmpleado += empleadoSeleccionado.getApellido1() + " " + 
                        empleadoSeleccionado.getApellido2() + ", " + 
                        empleadoSeleccionado.getNombre();
        
        panel.setEmpleadoVenta(empleadoSeleccionado);
        panel.getTxtEmpleado().setText(textoEmpleado);
    }
    
    //Carga los detalles de venta pasados por parámetro en la tabla de detalles, 
    //actualiza el total de la venta y guarda los detalles cargados en la 
    //variable de clase DetallesVentaSeleccionada
    private void cargaDetallesVenta(List<DetallesVenta> detallesVenta) {
        double totalVenta = 0.0;
        
        tablaDetalles.setNumRows(0);
        if(detallesVenta != null) {
            for (DetallesVenta detalleVentaActual : detallesVenta) {
                ServiceProducto productoDAO = new ServiceProducto();
                Producto producto = new Producto();
                Vector filaTabla = new Vector();

                filaTabla.add(detalleVentaActual.getId());
                producto = productoDAO.findById(detalleVentaActual.getId_producto());
                filaTabla.add(producto.getNombre());
                filaTabla.add(Float.toString(detalleVentaActual.getCantidad()).
                                                replace('.', ','));
                filaTabla.add(Float.toString(detalleVentaActual.getPrecio_linea()).
                                                replace('.', ','));
                filaTabla.add(Float.toString(detalleVentaActual.getDescuento_linea()).
                                                replace('.', ','));

                totalVenta += detalleVentaActual.getPrecio_linea();
                totalVenta = Math.round(totalVenta*100.0)/100.0;

                tablaDetalles.addRow(filaTabla);
            }
        }
        
        panel.setDetallesVentaSeleccionada(detallesVenta);
        
        PintaTablaDetalles();
        
        panel.getTxtTotal().setText(Double.toString(totalVenta).
                                            replace('.', ','));
    }
    
    //Carga el modelo de la Tabla de Detalles dependiendo de si hay o no cliente 
    //en la venta
    private void CargaModeloTablaDetalles(boolean hayCliente) {
        TableColumnModel columnModel;
        
        if (hayCliente){
            //Tabla Detalles
            tablaDetalles = new ModeloTabla(new String[]{
                "ID", "Producto", "Cantidad", "Precio Línea(€)", 
                "Dto. Línea(%)"}, 0);
            
            PintaTablaDetalles();

            columnModel = panel.getTablaDetallesVenta().getColumnModel();
            columnModel.getColumn(1).setPreferredWidth(142);
            columnModel.getColumn(2).setPreferredWidth(56);
            columnModel.getColumn(3).setPreferredWidth(90);
            columnModel.getColumn(4).setPreferredWidth(80);
        } else {
            tablaDetalles = new ModeloTabla(new String[]{
                "ID", "Producto", "Cantidad", "Precio Línea(€)"}, 0);
            
            PintaTablaDetalles();

            columnModel = panel.getTablaDetallesVenta().getColumnModel();
            columnModel.getColumn(1).setPreferredWidth(222);
            columnModel.getColumn(2).setPreferredWidth(56);
            columnModel.getColumn(3).setPreferredWidth(90);
        }
    }
    
    //Validación de campos
    private boolean ValidaCampos() {
        try {
            Exception excNombreVacio = new Exception("Campo Entregado vacío");
            Exception excEmpleadoVacio = new Exception("Seleccione un empleado");

            //Validación campo no vacío
            if (panel.getTxtEntregado().getText().trim().isEmpty()) 
                throw excNombreVacio;
            if (panel.getEmpleadoVenta()== null) 
                throw excEmpleadoVacio;
            
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Campo vacío", 0);
        }
        return false;
    }
    
    //Pinta de nuevo la tabla
    private void PintaTabla() {
        panel.getTablaVentas().setModel(tabla);
        panel.getTablaVentas().getColumnModel().getColumn(0).setPreferredWidth(0);
        panel.getTablaVentas().getColumnModel().getColumn(0).setMaxWidth(0);
        panel.getTablaVentas().getColumnModel().getColumn(0).setMinWidth(0);
        panel.getPanelTabla().setViewportView(panel.getTablaVentas());
    }
    
    //Pinta de nuevo la tabla de detalles
    private void PintaTablaDetalles() {
        panel.getTablaDetallesVenta().setModel(tablaDetalles);
        panel.getTablaDetallesVenta().getColumnModel().getColumn(0).
                setPreferredWidth(0);
        panel.getTablaDetallesVenta().getColumnModel().getColumn(0).
                setMaxWidth(0);
        panel.getTablaDetallesVenta().getColumnModel().getColumn(0).
                setMinWidth(0);
        panel.getPanelTablaDetalles().setViewportView(
                panel.getTablaDetallesVenta());
    }
    
    /**
     * Habilita o deshabilita los componentes del panel "panelDatos"
     *
     * @param habilitar boolean True/False
     */
    public void habilitaCampos(boolean habilitar) {
        for (int i = 0; i < panel.getPanelDatos().getComponents().length; i++) {
            panel.getPanelDatos().getComponent(i).setEnabled(habilitar);
        }
        for (int i = 0; i < panel.getPanelFormaPago().getComponents().length; i++) {
            panel.getPanelFormaPago().getComponent(i).setEnabled(habilitar);
        }
    }

}
