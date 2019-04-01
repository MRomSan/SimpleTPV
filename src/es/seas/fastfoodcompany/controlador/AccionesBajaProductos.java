/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.controlador;

import es.seas.fastfoodcompany.config.ModeloTabla;
import es.seas.fastfoodcompany.gestionbd.ServiceProducto;
import es.seas.fastfoodcompany.modelo.entidades.Producto;
import es.seas.fastfoodcompany.vistas.FrmSeleccionCategoria;
import es.seas.fastfoodcompany.vistas.PanelBajaProductos;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 * Clase que controla las acciones de bajas de productos
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class AccionesBajaProductos {
    private PanelBajaProductos panel;
    private ModeloTabla tabla;

    /**
     * Constructor predeterminado
     *
     * @param panel PanelBajaProductos al que pertenecen las acciones
     */
    public AccionesBajaProductos(PanelBajaProductos panel) {
        this.panel = panel;
    }
    
    /**
     * Método que inicializa y carga los valores en la tabla.
     */
    public void InicializaTabla() {
        //Modelo
        tabla = new ModeloTabla(new String[]{
            "ID", "Nombre", "Descripción", "Precio (€)"}, 0);
        PintaTabla();
        //Datos
        CargaDatosTabla();
    }

    /**
     * Método que carga los valores en la tabla
     */
    public void CargaDatosTabla() {
        ServiceProducto productoDAO = new ServiceProducto();
        List<Producto> productos = new ArrayList<Producto>();
        
        productos = productoDAO.findEliminables();
        for (Producto productoActual : productos) {
            Vector filaTabla = new Vector();
            filaTabla.add(productoActual.getId());
            filaTabla.add(productoActual.getNombre());
            filaTabla.add(productoActual.getDescripcion());
            filaTabla.add(Float.toString(productoActual.getPrecio()).
                            replace('.', ','));
            tabla.addRow(filaTabla);
        }
        PintaTabla();
    }
    
    /**
     * Método que elimina los productos seleccionados en la tabla
     */
    public void EliminarProductos() {
        ServiceProducto productoDAO = new ServiceProducto();
        int[] filasSeleccionadas;
        
        filasSeleccionadas = panel.getTablaProductos().getSelectedRows();
        if (filasSeleccionadas.length == 0) {
            JOptionPane.showMessageDialog(null, "No hay registros seleccionados");
        } else {
            int confirmacion;
            confirmacion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar"
                    + " (" + filasSeleccionadas.length + 
                    ") registro(s) seleccionados?");
            if (confirmacion == JOptionPane.YES_OPTION) {
                for (int i = filasSeleccionadas.length-1; i >= 0; i--) {
                    int idProducto;
                    idProducto = (int) panel.getTablaProductos().
                            getValueAt(filasSeleccionadas[i], 0);
                    productoDAO.delete(idProducto);
                    tabla.removeRow(filasSeleccionadas[i]);
                }
                PintaTabla();
            }
        }
    }
    
    /**
     * Crea un JDialog FrmSeleccionCategoria para seleccionar un cliente y mostrar 
     * sus tickets
     */
    public void SeleccionarCategoria() {
        FrmSeleccionCategoria selCategoria = new FrmSeleccionCategoria(
            (JFrame) SwingUtilities.getWindowAncestor(panel), true);
        selCategoria.setLocationRelativeTo(panel);
        selCategoria.setVisible(true);
        
        if (selCategoria.getCategoriaSeleccionada()!= null) {
            panel.setCategoriaBusqueda(selCategoria.
                    getCategoriaSeleccionada());
            panel.getTxtBuscarCategoria().setText(
                    panel.getCategoriaBusqueda().getNombre());
        }
        BuscarProductos(panel.getTxtBuscar().getText());
    }
    
    /**
     * Quita la categoría seleccionada para la búsqueda
     */
    public void QuitarCategoria() {
        panel.setCategoriaBusqueda(null);
        panel.getTxtBuscarCategoria().setText("");
        BuscarProductos(panel.getTxtBuscar().getText());
    }
    
    /**
     * Método que busca los productos cuyos campos coincidan total o 
     * parcialmente con el texto introducido
     *
     * @param texto String
     */
    public void BuscarProductos(String texto) {
        ServiceProducto productoDAO = new ServiceProducto();
        List<Producto> productos = new ArrayList<Producto>();
        Integer idCategoria = null;
        
        if(panel.getCategoriaBusqueda() != null)
            idCategoria = panel.getCategoriaBusqueda().getId();
        
        productos = productoDAO.buscarEliminables(texto, idCategoria);
        tabla.setNumRows(0);
        for (Producto productoActual : productos) {
            Vector filaTabla = new Vector();
            filaTabla.add(productoActual.getId());
            filaTabla.add(productoActual.getNombre());
            filaTabla.add(productoActual.getDescripcion());
            filaTabla.add(Float.toString(productoActual.getPrecio()).
                            replace('.', ','));
            tabla.addRow(filaTabla);
        }
        PintaTabla();
    }
    
    //Pinta de nuevo la tabla
    private void PintaTabla() {
        panel.getTablaProductos().setModel(tabla);
        panel.getTablaProductos().getColumnModel().getColumn(0).setPreferredWidth(0);
        panel.getTablaProductos().getColumnModel().getColumn(0).setMaxWidth(0);
        panel.getTablaProductos().getColumnModel().getColumn(0).setMinWidth(0);
        panel.getPanelTabla().setViewportView(panel.getTablaProductos());
    }
}
