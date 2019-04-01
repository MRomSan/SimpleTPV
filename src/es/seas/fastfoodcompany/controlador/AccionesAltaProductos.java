/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.controlador;

import es.seas.fastfoodcompany.gestionbd.ServiceCategoria;
import es.seas.fastfoodcompany.gestionbd.ServiceIva;
import es.seas.fastfoodcompany.gestionbd.ServiceProducto;
import es.seas.fastfoodcompany.modelo.entidades.Categoria;
import es.seas.fastfoodcompany.modelo.entidades.Iva;
import es.seas.fastfoodcompany.modelo.entidades.Producto;
import es.seas.fastfoodcompany.vistas.PanelAltaProductos;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Clase que controla las acciones de altas de productos
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class AccionesAltaProductos {
    private final PanelAltaProductos panel;
    private final String CARPETA_IMAGENES = "imagenes";
    private final JFileChooser abrirImagen = new JFileChooser();
    private Iva ivaSeleccionado = null;
    private Categoria categoriaSeleccionada = null;
    
    /**
     * Constructor predeterminado
     *
     * @param panel Panel al que están enlazadas las acciones de productos
     */
    public AccionesAltaProductos(PanelAltaProductos panel) {
        this.panel = panel;
    }
    
    /**
     * Procedimiento para guardar una categoría en la base de datos
     */
    public void Guardar() {
        if (ValidaCampos()) {
            ServiceProducto productoDAO = new ServiceProducto();
            Producto producto = new Producto();
            producto.setId_categoria(categoriaSeleccionada.getId());
            producto.setNombre(panel.getTxtNombre().getText());
            producto.setDescripcion(panel.getTxtDescripcion().getText());
            producto.setPrecio(Float.parseFloat(panel.getTxtPrecio().getText().
                                                        replace(',', '.')));
            producto.setId_iva(ivaSeleccionado.getId());
            producto.setImagen(abrirImagen.getSelectedFile().getName());
            productoDAO.insert(producto);
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
            JOptionPane.showMessageDialog(null, "Producto guardado: " +
                        producto.toString());
        }
    }
    
    /**
     * Procedimiento para buscar y cargar la imagen del producto
     */
    public void buscarImagen() {
        if (panel.getCmbCategoria().getSelectedItem().toString().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una "
                    + "Categoría", "Categoría no seleccionada", 0);
        } else {
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
                ImageIcon imagen = new ImageIcon(ruta);
                JLabel etiImagen;
                etiImagen = panel.getLblMuestraImagen();
                etiImagen.setIcon(new ImageIcon(
                        imagen.getImage().getScaledInstance(etiImagen.getWidth(), 
                                etiImagen.getHeight(), Image.SCALE_DEFAULT)));
            }
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
            if (producto != null)
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
     * Procedimiento que rellena el comboBox con las categorías disponibles
     */
    public void inicializaCmbCategoria() {
        ServiceCategoria categoriaDAO = new ServiceCategoria();
        List<Categoria> categorias = new ArrayList<>();
        
        categorias = categoriaDAO.findAll();
        panel.getCmbCategoria().removeAllItems();
        if (categorias.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe introducir al menos una "
                    + "Categoría", "Categoría no encontrada", 0);
            panel.setVisible(false);
        } else {
            panel.getCmbCategoria().addItem("");
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
        if (ivas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe introducir al menos un IVA", 
                    "IVA no encontrado", 0);
            panel.setVisible(false);
        } else {
            panel.getCmbIVA().addItem("");
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
}
