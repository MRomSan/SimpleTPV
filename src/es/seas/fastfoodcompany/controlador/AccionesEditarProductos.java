/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.controlador;

import es.seas.fastfoodcompany.config.ModeloTabla;
import es.seas.fastfoodcompany.gestionbd.ServiceCategoria;
import es.seas.fastfoodcompany.gestionbd.ServiceIva;
import es.seas.fastfoodcompany.gestionbd.ServiceProducto;
import es.seas.fastfoodcompany.modelo.entidades.Categoria;
import es.seas.fastfoodcompany.modelo.entidades.Iva;
import es.seas.fastfoodcompany.modelo.entidades.Producto;
import es.seas.fastfoodcompany.vistas.FrmSeleccionCategoria;
import es.seas.fastfoodcompany.vistas.PanelEditarProductos;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Clase que controla las acciones de edición de productos
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class AccionesEditarProductos {
    private PanelEditarProductos panel;
    private ModeloTabla tabla;
    private final String CARPETA_IMAGENES = "imagenes";
    private final JFileChooser abrirImagen = new JFileChooser();
    private Iva ivaSeleccionado = null;
    private Categoria categoriaSeleccionada = null;
    
    
    /**
     * Constructor predeterminado
     *
     * @param panel PanelEditarProductos al que pertenecen las acciones
     */
    public AccionesEditarProductos(PanelEditarProductos panel) {
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
     * Método que carga, en el panel de datos de producto, el producto 
     * seleccionado en la tabla
     */
    public void CargaProductoSeleccionado () {
        int filaSeleccionada = panel.getTablaProductos().getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "No hay registros seleccionados");
        } else {
            Producto producto = new Producto();
            ServiceProducto productoDAO = new ServiceProducto();
            producto = productoDAO.findById((int) panel.getTablaProductos().
                        getValueAt(filaSeleccionada, 0));
            
            habilitaCampos(true);
            
            panel.getLblID().setText(Integer.toString(producto.getId()));
            cargaCategoria(producto.getId_categoria());
            panel.getTxtNombre().setText(producto.getNombre());
            panel.getTxtDescripcion().setText(producto.getDescripcion());
            panel.getTxtPrecio().setText(Float.toString(producto.getPrecio()).
                                            replace('.', ','));
            cargaIVA(producto.getId_iva());
            String ruta = CARPETA_IMAGENES + "/" + 
                    categoriaSeleccionada.getNombre() + "/" + 
                    producto.getImagen();
            cargaImagen(ruta);
            abrirImagen.setSelectedFile(new File(ruta));
        }
    }
    
    /**
     * Método que actualiza el producto en la base de datos y por pantalla
     */
    public void ActualizaProducto() {
        if (panel.getLblID().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay registro cargado");
        } else {
            if(ValidaCampos()){
                ServiceProducto productoDAO = new ServiceProducto();
                Producto producto = new Producto();

                producto.setId(Integer.parseInt(panel.getLblID().getText()));
                producto.setId_categoria(categoriaSeleccionada.getId());
                producto.setNombre(panel.getTxtNombre().getText());
                producto.setDescripcion(panel.getTxtDescripcion().getText());
                producto.setPrecio(Float.parseFloat(panel.getTxtPrecio().getText().
                                                            replace(',', '.')));
                producto.setId_iva(ivaSeleccionado.getId());
                producto.setImagen(abrirImagen.getSelectedFile().getName());
                
                productoDAO.update(producto);

                panel.getLblID().setText("");
                panel.getCmbCategoria().setSelectedItem("");
                categoriaSeleccionada = null;
                panel.getTxtNombre().setText("");
                panel.getTxtDescripcion().setText("");
                panel.getTxtPrecio().setText("");
                panel.getTxtPrecio().setValue(null);
                panel.getCmbIVA().setSelectedItem("");
                ivaSeleccionado = null;
                panel.getLblMuestraImagen().setIcon(null);
                abrirImagen.setSelectedFile(null);
                JOptionPane.showMessageDialog(null, "Producto actualizado: " 
                        + producto.toString());
                tabla.setNumRows(0);
                BuscarProductos(panel.getTxtBuscar().getText());
                habilitaCampos(false);
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
     * Método que busca los productos cuyos campos coincidan total o parcialmente
     * con el texto introducido
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
    
    /**
     * Procedimiento para buscar y cargar la imagen del producto
     */
    public void buscarImagen() {
        FileNameExtensionFilter filtro = new FileNameExtensionFilter(
                "JPG y PNG", "jpg", "png");
        String rutaCarpeta;
        abrirImagen.setFileFilter(filtro);
        
        rutaCarpeta = CARPETA_IMAGENES + "/" +
                        panel.getCmbCategoria().getSelectedItem().toString();
        abrirImagen.setCurrentDirectory(new File(rutaCarpeta));
        
        int botonPulsado = abrirImagen.showOpenDialog(null);
        if (botonPulsado == JFileChooser.APPROVE_OPTION) {
            String ruta = rutaCarpeta + "/" +
                            abrirImagen.getSelectedFile().getName();
            cargaImagen(ruta);
        }
    }
    
    //Validación de campos
    private boolean ValidaCampos() {
        try {
            ServiceProducto productoDAO = new ServiceProducto();
            Producto producto = productoDAO.findByNombre(
                                    panel.getTxtNombre().getText().trim());
            
            Exception excCategoriaVacio = new Exception("Seleccione una " +
                                                            "categoría");
            Exception excNombreVacio = new Exception("Campo Nombre vacío");
            Exception excNombreExistente = new Exception("Ya existe un artículo "
                    + "con este nombre");
            Exception excDescripcionVacio = new Exception("Campo Descripción " +
                                                            "vacío");
            Exception excPrecioVacio = new Exception("Campo Precio vacío");
            Exception excIVAVacio = new Exception("Seleccione un IVA");
            Exception excNoImagen = new Exception("Seleccione una imagen");
            
            //Validación de campos
            if (panel.getCmbCategoria().getSelectedItem().toString().equals("")) 
                throw excCategoriaVacio;
            if (panel.getTxtNombre().getText().trim().isEmpty()) 
                throw excNombreVacio;
            if (producto != null && 
                producto.getId() != Integer.parseInt(panel.getLblID().getText()))
                throw excNombreExistente;
            if (panel.getTxtDescripcion().getText().trim().isEmpty()) 
                throw excDescripcionVacio;
            if (panel.getTxtPrecio().getText().trim().isEmpty()) 
                throw excPrecioVacio;
            if (panel.getCmbIVA().getSelectedItem().toString().equals("")) 
                throw excIVAVacio;
            if (abrirImagen.getSelectedFile() == null)
                throw excNoImagen;
            
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), 
                    "Dato incorrecto", 0);
        }
        return false;
    }
    
    /**
     * Procedimiento que rellena el comboBox con los IVAs disponibles
     */
    public void inicializaCmbCategoria() {
        ServiceCategoria categoriaDAO = new ServiceCategoria();
        List<Categoria> categorias = new ArrayList<>();
        
        categorias = categoriaDAO.findAll();
        panel.getCmbCategoria().removeAllItems();
        panel.getCmbCategoria().addItem("");
        if (!categorias.isEmpty()) {
            for (Categoria categoriaActual : categorias) {
                panel.getCmbCategoria().addItem(categoriaActual.getNombre());
            }
        }
    }
    
    /**
     * Procedimiento que rellena el comboBox con los IVAs disponibles
     */
    public void inicializaCmbIVA() {
        ServiceIva ivaDAO = new ServiceIva();
        List<Iva> ivas = new ArrayList<>();
        
        ivas = ivaDAO.findAll();
        panel.getCmbIVA().removeAllItems();
        panel.getCmbIVA().addItem("");
        if (!ivas.isEmpty()) {
            for (Iva ivaActual : ivas) {
                panel.getCmbIVA().addItem(ivaActual.getNombre());
            }
        }
    }
    
    /**
     * Almacena el IVA seleccionado en el comboBox en una variable de clase para 
     * poder usar los datos de ésta
     *
     * @param cmbIVA String
     */
    public void cambiaIVASeleccionado(String cmbIVA) {
        if (cmbIVA.equals("")) {
            ivaSeleccionado = null;
            panel.getLblCantidadIVA().setText("0,0");
        } else {
            ServiceIva ivaDAO = new ServiceIva();
            ivaSeleccionado = ivaDAO.findByNombre(cmbIVA);
            panel.getLblCantidadIVA().setText(
                                Float.toString(ivaSeleccionado.getCantidad()).
                                        replace('.', ','));
        }
    }
    
    /**
     * Almacena la categoría seleccionada en el comboBox en una variable de 
     * clase para poder usar los datos de ésta
     *
     * @param cmbCategoria String
     */
    public void cambiaCategoriaSeleccionada(String cmbCategoria) {
        if (cmbCategoria.equals("")) {
            categoriaSeleccionada = null;
        } else {
            ServiceCategoria categoriaDAO = new ServiceCategoria();
            categoriaSeleccionada = categoriaDAO.findByNombre(cmbCategoria);
        }
    }
    
    //Carga el IVA del producto seleccionado en la tabla
    private void cargaIVA(int idIVA) {
        ServiceIva ivaDAO = new ServiceIva();
        ivaSeleccionado = ivaDAO.findById(idIVA);
        panel.getCmbIVA().setSelectedItem(ivaSeleccionado.getNombre());
        panel.getLblCantidadIVA().setText(
                            Float.toString(ivaSeleccionado.getCantidad()).
                                    replace('.', ','));
    }
    
    //Carga la categoría del producto seleccionado en la tabla
    private void cargaCategoria(int idCategoria) {
        ServiceCategoria categoriaDAO = new ServiceCategoria();
        categoriaSeleccionada = categoriaDAO.findById(idCategoria);
        panel.getCmbCategoria().setSelectedItem(
                                categoriaSeleccionada.getNombre());
    }
    
    //Pinta de nuevo la tabla
    private void PintaTabla() {
        panel.getTablaProductos().setModel(tabla);
        panel.getTablaProductos().getColumnModel().getColumn(0).setPreferredWidth(0);
        panel.getTablaProductos().getColumnModel().getColumn(0).setMaxWidth(0);
        panel.getTablaProductos().getColumnModel().getColumn(0).setMinWidth(0);
        panel.getPanelTabla().setViewportView(panel.getTablaProductos());
    }
    
    //Carga la imagen en el label
    private void cargaImagen(String ruta) {
        ImageIcon imagen = new ImageIcon(ruta);
        JLabel etiImagen;
        etiImagen = panel.getLblMuestraImagen();
        etiImagen.setIcon(new ImageIcon(
                imagen.getImage().getScaledInstance(etiImagen.getWidth(), 
                        etiImagen.getHeight(), Image.SCALE_DEFAULT)));
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
    }
    
}
