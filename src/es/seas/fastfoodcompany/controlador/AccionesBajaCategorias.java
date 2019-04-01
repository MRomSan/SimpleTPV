/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.controlador;

import es.seas.fastfoodcompany.config.ModeloTabla;
import es.seas.fastfoodcompany.gestionbd.ServiceCategoria;
import es.seas.fastfoodcompany.modelo.entidades.Categoria;
import es.seas.fastfoodcompany.vistas.PanelBajaCategorias;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 * Clase que controla las acciones de bajas de categorías
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class AccionesBajaCategorias {
    private PanelBajaCategorias panel;
    private ModeloTabla tabla;

    /**
     * Constructor predeterminado
     *
     * @param panel PanelBajaCategorias al que pertenecen las acciones
     */
    public AccionesBajaCategorias(PanelBajaCategorias panel) {
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
        
        categorias = categoriaDAO.findEliminables();
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
     * Método que elimina las categorías seleccionadas en la tabla
     */
    public void EliminarCategorias() {
        ServiceCategoria categoriaDAO = new ServiceCategoria();
        int[] filasSeleccionadas;
        
        filasSeleccionadas = panel.getTablaCategorias().getSelectedRows();
        if (filasSeleccionadas.length == 0) {
            JOptionPane.showMessageDialog(null, "No hay registros seleccionados");
        } else {
            int confirmacion;
            confirmacion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar"
                    + " (" + filasSeleccionadas.length + 
                    ") registro(s) seleccionados?");
            if (confirmacion == JOptionPane.YES_OPTION) {
                for (int i = filasSeleccionadas.length-1; i >= 0; i--) {
                    int idCategoria;
                    idCategoria = (int) panel.getTablaCategorias().
                            getValueAt(filasSeleccionadas[i], 0);
                    categoriaDAO.delete(idCategoria);
                    tabla.removeRow(filasSeleccionadas[i]);
                }
                PintaTabla();
            }
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
        
        categorias = categoriaDAO.buscarEliminables(texto);
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
