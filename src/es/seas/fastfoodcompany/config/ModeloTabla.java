/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.config;

import javax.swing.table.DefaultTableModel;

/**
 * Crea un modelo de tablas con celdas no editables
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class ModeloTabla extends DefaultTableModel {
    
    /**
     * Constructor del modelo para la tabla
     * 
     * @param string String que contiene los encabezamientos de las columnas
     * @param i Número de filas iniciales que contiene la tabla
     */
    public ModeloTabla(String[] string, int i) {
        super(string, i);
    }

    /**
     * Define la posibilidad de editar de una celda.
     * 
     * @param row Coordenada de la fila dentro de la tabla
     * @param column Coordenada de la columna dentro de la tabla
     * @return true/false para cada columna, indica si es editable o no
     */
    @Override
    public final boolean isCellEditable(int row, int column) {
        return false;
    }
}
