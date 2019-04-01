/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.controlador;

import es.seas.fastfoodcompany.config.ModeloTabla;
import es.seas.fastfoodcompany.gestionbd.ServiceCategoria;
import es.seas.fastfoodcompany.modelo.entidades.Categoria;
import es.seas.fastfoodcompany.vistas.FrmSeleccionCategoria;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 * Clase que controla las acciones de Selección de Categoría
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class AccionesSeleccionCategoria {
    private FrmSeleccionCategoria panel;
    private ModeloTabla tabla;
    
    /**
     * Constructor predeterminado
     *
     * @param panel FrmSeleccionCategoria al que pertenecen las acciones
     */
    public AccionesSeleccionCategoria(FrmSeleccionCategoria panel) {
        this.panel = panel;
    }
    
    /**
     * Método que inicializa y carga los valores en la tabla.
     */
    public void InicializaTabla() {
        //Modelo
        tabla = new ModeloTabla(new String[]{
            "ID", "Nombre", "Descripción", "Imagen"}, 0);
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
     * Guarda la categoría seleccionada en una variable de la clase 
     * FrmSeleccionCategoria y cierra la pantalla
     */
    public void SeleccionarCategoria() {
        ServiceCategoria categoriaDAO = new ServiceCategoria();
        int[] filasSeleccionadas;
        
        filasSeleccionadas = panel.getTablaCategorias().getSelectedRows();
        if (filasSeleccionadas.length == 0) {
            JOptionPane.showMessageDialog(null, "No hay registro seleccionado");
        } else {
            int idCategoria;
            idCategoria = (int) panel.getTablaCategorias().
                    getValueAt(filasSeleccionadas[0], 0);

            panel.setCategoriaSeleccionada(categoriaDAO.findById(idCategoria));
            panel.dispose();
        }
    }
    
    /**
     * Método que busca las categorías cuyos campos coincidan total o 
     * parcialmente con el texto introducido
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
            filaTabla.add(categoriaActual.getImagen());
            tabla.addRow(filaTabla);
        }
        PintaTabla();
    }
    
    //Pinta de nuevo la tabla
    private void PintaTabla() {
        panel.getTablaCategorias().setModel(tabla);
        panel.getTablaCategorias().getColumnModel().getColumn(0).setPreferredWidth(0);
        panel.getTablaCategorias().getColumnModel().getColumn(0).setMaxWidth(0);
        panel.getTablaCategorias().getColumnModel().getColumn(0).setMinWidth(0);
        panel.getPanelTabla().setViewportView(panel.getTablaCategorias());
    }
}
