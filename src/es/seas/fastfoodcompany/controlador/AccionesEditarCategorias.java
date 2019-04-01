/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.controlador;

import es.seas.fastfoodcompany.config.ModeloTabla;
import es.seas.fastfoodcompany.gestionbd.ServiceCategoria;
import es.seas.fastfoodcompany.modelo.entidades.Categoria;
import es.seas.fastfoodcompany.vistas.PanelEditarCategorias;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Clase que controla las acciones de edición de categorías
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class AccionesEditarCategorias {
    private PanelEditarCategorias panel;
    private ModeloTabla tabla;
    private final String CARPETA_IMAGENES = "imagenes";
    private final JFileChooser abrirImagen = new JFileChooser();
    
    /**
     * Constructor predeterminado
     *
     * @param panel PanelEditarCategorias al que pertenecen las acciones
     */
    public AccionesEditarCategorias(PanelEditarCategorias panel) {
        this.panel = panel;
    }
    
    /**
     * Método que inicializa y carga los valores en la tabla.
     */
    public void InicializaTabla() {
        //Modelo
        tabla = new ModeloTabla(new String[]{
            "ID", "Nombre", "Descripción"}, 0);
        PintaTabla();
        //Datos
        CargaDatosTabla();
    }

    /**
     * Método que carga los valores en la tabla
     */
    public void CargaDatosTabla() {
        ServiceCategoria categoriaDAO = new ServiceCategoria();
        List<Categoria> categorias = new ArrayList<Categoria>();
        
        categorias = categoriaDAO.findAll();
        for (Categoria categoriaActual : categorias) {
            Vector filaTabla = new Vector();
            filaTabla.add(categoriaActual.getId());
            filaTabla.add(categoriaActual.getNombre());
            filaTabla.add(categoriaActual.getDescripcion());
            filaTabla.add(categoriaActual.getImagen());
            tabla.addRow(filaTabla);
        }
        PintaTabla();
    }
    
    /**
     * Método que carga, en el panel de datos de categoría, la categoría 
     * seleccionada en la tabla
     */
    public void CargaCategoriaSeleccionada() {
        int filaSeleccionada = panel.getTablaCategorias().getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "No hay registros seleccionados");
        } else {
            Categoria categoria = new Categoria();
            ServiceCategoria categoriaDAO = new ServiceCategoria();
            categoria = categoriaDAO.findById((int) panel.getTablaCategorias().
                        getValueAt(filaSeleccionada, 0));
            
            habilitaCampos(true);
            
            panel.getLblID().setText(Integer.toString(categoria.getId()));
            panel.getTxtNombre().setText(categoria.getNombre());
            panel.getTxtDescripcion().setText(categoria.getDescripcion());
            String ruta = CARPETA_IMAGENES + "/" + categoria.getImagen();
            cargaImagen(ruta);
            abrirImagen.setSelectedFile(new File(ruta));
        }
    }
    
    /**
     * Método que actualiza la categoría en la base de datos y por pantalla
     */
    public void ActualizaCategoria() {
        if (panel.getLblID().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay registro cargado");
        } else {
            if(ValidaCampos()){
                ServiceCategoria categoriaDAO = new ServiceCategoria();
                Categoria categoria = new Categoria();

                categoria.setId(Integer.parseInt(panel.getLblID().getText()));
                categoria.setNombre(panel.getTxtNombre().getText());
                categoria.setDescripcion(panel.getTxtDescripcion().getText());
                categoria.setImagen(abrirImagen.getSelectedFile().getName());
                
                categoriaDAO.update(categoria);

                panel.getLblID().setText("");
                panel.getTxtNombre().setText("");
                panel.getTxtDescripcion().setText("");
                panel.getLblMuestraImagen().setIcon(null);
                abrirImagen.setSelectedFile(null);
                JOptionPane.showMessageDialog(null, "Categoría actualizada: " 
                        + categoria.toString());
                tabla.setNumRows(0);
                BuscarCategorias(panel.getTxtBuscar().getText());
                habilitaCampos(false);
            }
        }
    }
    
    /**
     * Método que busca las categorías cuyos campos coincidan total o parcialmente
     * con el texto introducido
     *
     * @param texto String
     */
    public void BuscarCategorias(String texto) {
        ServiceCategoria categoriaDAO = new ServiceCategoria();
        List<Categoria> categorias = new ArrayList<Categoria>();
        
        categorias = categoriaDAO.buscar(texto);
        tabla.setNumRows(0);
        for (Categoria categoriaActual : categorias) {
            Vector filaTabla = new Vector();
            filaTabla.add(categoriaActual.getId());
            filaTabla.add(categoriaActual.getNombre());
            filaTabla.add(categoriaActual.getDescripcion());
            tabla.addRow(filaTabla);
        }
        PintaTabla();
    }
    
    /**
     * Procedimiento para buscar y cargar la imagen de la categoría
     */
    public void buscarImagen() {
        FileNameExtensionFilter filtro = new FileNameExtensionFilter(
                "JPG y PNG", "jpg", "png");
        abrirImagen.setFileFilter(filtro);
        
        abrirImagen.setCurrentDirectory(new File(CARPETA_IMAGENES));
        
        int botonPulsado = abrirImagen.showOpenDialog(null);
        if (botonPulsado == JFileChooser.APPROVE_OPTION) {
            String ruta = CARPETA_IMAGENES + "/" +
                            abrirImagen.getSelectedFile().getName();
            cargaImagen(ruta);
        }
    }
    
    //Validación de campos
    private boolean ValidaCampos() {
        try {
            Exception excNombreVacio = new Exception("Campo Nombre vacío");
            Exception excNombreImagen = new Exception("La imagen debe tener el "
                                + "mismo nombre que la Categoría");
            Exception excNoImagen = new Exception("Seleccione una imagen");

            //Validación campo no vacío
            if (panel.getTxtNombre().getText().trim().isEmpty()) 
                throw excNombreVacio;
            if (!panel.getTxtNombre().getText().trim().equals(
                 abrirImagen.getSelectedFile().getName().substring(0, 
                         abrirImagen.getSelectedFile().getName().indexOf(".")))) 
                throw excNombreImagen;
            if (abrirImagen.getSelectedFile() == null)
                throw excNoImagen;
            
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Campo vacío", 0);
        }
        return false;
    }
    
    //Pinta de nuevo la tabla
    private void PintaTabla() {
        panel.getTablaCategorias().setModel(tabla);
        panel.getTablaCategorias().getColumnModel().getColumn(0).setPreferredWidth(0);
        panel.getTablaCategorias().getColumnModel().getColumn(0).setMaxWidth(0);
        panel.getTablaCategorias().getColumnModel().getColumn(0).setMinWidth(0);
        panel.getPanelTabla().setViewportView(panel.getTablaCategorias());
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
