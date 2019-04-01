/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.controlador;

import es.seas.fastfoodcompany.gestionbd.ServiceCategoria;
import es.seas.fastfoodcompany.modelo.entidades.Categoria;
import es.seas.fastfoodcompany.vistas.PanelAltaCategorias;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Clase que controla las acciones de altas de categorías
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class AccionesAltaCategorias {
    private final PanelAltaCategorias panel;
    private final String CARPETA_IMAGENES = "imagenes";
    private final JFileChooser abrirImagen = new JFileChooser();
    
    /**
     * Constructor predeterminado
     *
     * @param panel Panel al que están enlazadas las acciones de categorías
     */
    public AccionesAltaCategorias(PanelAltaCategorias panel) {
        this.panel = panel;
    }
    
    /**
     * Procedimiento para guardar una categoría en la base de datos
     */
    public void Guardar() {
        if (ValidaCampos()) {
            ServiceCategoria categoriaDAO = new ServiceCategoria();
            Categoria categoria = new Categoria();
            categoria.setNombre(panel.getTxtNombre().getText());
            categoria.setDescripcion(panel.getTxtDescripcion().getText());
            categoria.setImagen(abrirImagen.getSelectedFile().getName());
            categoriaDAO.insert(categoria);
            panel.getTxtNombre().setText("");
            panel.getTxtDescripcion().setText("");
            panel.getLblMuestraImagen().setIcon(null);
            abrirImagen.setSelectedFile(null);
            JOptionPane.showMessageDialog(null, "Categoría guardada: " +
                        categoria.toString());
        }
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
            ImageIcon imagen = new ImageIcon(ruta);
            JLabel etiImagen;
            etiImagen = panel.getLblMuestraImagen();
            etiImagen.setIcon(new ImageIcon(
                    imagen.getImage().getScaledInstance(etiImagen.getWidth(), 
                            etiImagen.getHeight(), Image.SCALE_DEFAULT)));
        }
    }
    
    //Validación de campos
    private boolean ValidaCampos() {
        try {
            Exception excNombreVacio = new Exception("Campo Nombre vacío");
            Exception excNombreImagen = new Exception("La imagen debe tener el "
                                + "mismo nombre que la Categoría");
            Exception excNoImagen = new Exception("Seleccione una imagen");
            
            //Validación de campos
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
            JOptionPane.showMessageDialog(null, e.getMessage(), 
                    "Dato incorrecto", 0);
        }
        return false;
    }
}
