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
import es.seas.fastfoodcompany.vistas.FrmSeleccionProducto;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 * Clase que controla las acciones de Selección de Producto
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class AccionesSeleccionProducto {
    private FrmSeleccionProducto panel;
    private ModeloTabla tabla;
    
    /**
     * Constructor predeterminado
     *
     * @param panel FrmSeleccionProducto al que pertenecen las acciones
     */
    public AccionesSeleccionProducto(FrmSeleccionProducto panel) {
        this.panel = panel;
    }
    
    /**
     * Método que inicializa y carga los valores en la tabla.
     */
    public void InicializaTabla() {
        //Modelo
        tabla = new ModeloTabla(new String[]{
            "ID", "Nombre", "Descripción", "Precio"}, 0);
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
        
        productos = productoDAO.findAll();
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
     * Guarda el producto seleccionado en una variable de la clase 
     * FrmSeleccionProducto y cierra la pantalla
     */
    public void SeleccionarProducto() {
        ServiceProducto productoDAO = new ServiceProducto();
        int[] filasSeleccionadas;
        
        filasSeleccionadas = panel.getTablaProductos().getSelectedRows();
        if (filasSeleccionadas.length == 0) {
            JOptionPane.showMessageDialog(null, "No hay registro seleccionado");
        } else {
            int idProducto;
            idProducto = (int) panel.getTablaProductos().
                    getValueAt(filasSeleccionadas[0], 0);

            panel.setProductoSeleccionado(productoDAO.findById(idProducto));
            panel.dispose();
        }
    }
    
    /**
     * Crea un JDialog FrmSeleccionCategoria para seleccionar un cliente y mostrar 
     * sus tickets
     */
    public void SeleccionarCategoria() {
        FrmSeleccionCategoria selCategoria = new FrmSeleccionCategoria(
            (JDialog) SwingUtilities.getWindowAncestor(panel), true);
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
        
        productos = productoDAO.buscar(texto, idCategoria);
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
