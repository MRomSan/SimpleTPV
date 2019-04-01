/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.config;

import es.seas.fastfoodcompany.vistas.TPVTactil;
import java.awt.Component;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import javax.swing.DefaultCellEditor;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Clase que hereda de DefaultCellEditor para controlar la edición de campos
 * en la tablaTicket del TPV Táctil
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class NumberCellEditor extends DefaultCellEditor {
    private final TPVTactil panel;
    private int row;

    /**
     * Asigna un JFormattedTextField a la celda cuando comienza su edición
     * 
     * @param panel TPVTactil Panel del TPVTacil para acceder a sus propiedades 
     *  y funciones
     */
    public NumberCellEditor(TPVTactil panel) {
        super(new JFormattedTextField());
        this.panel = panel;
        this.setClickCountToStart(Integer.MAX_VALUE);
    }
    
    /**
     * Obtiene el componente de la celda en edición
     *
     * @param table JTable Tabla a la que pertenece la celda
     * @param value Object Valor de la celda
     * @param isSelected boolean Indica si está seleccionada
     * @param row int Fila de la celda
     * @param column int Columna de la celda
     * @return Component Devuelve el JFormattedTextField en edición
     */
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        JTextField editor = (JTextField) super.getTableCellEditorComponent(table, value, isSelected, row, column);

        if (value instanceof Number){
            editor.setHorizontalAlignment(SwingConstants.RIGHT);
            editor.setText(value.toString());
            this.row = row;
        }
        return editor;
    }
    
    /**
     * Termina la edición actual
     *
     * @return boolean Devuelve True si la celda se modificó satisfactoriamente 
     *  y devuelve False si ocurrió algún error (como no introducir un número)
     */
    @Override
    public boolean stopCellEditing() {
        try {
            super.stopCellEditing();
            this.getCellEditorValue();
            panel.getTablaTicket().getModel().setValueAt(panel.getAcciones().CalculaTotalLinea(
                    (float)panel.getTablaTicket().getModel().getValueAt(row, 3), 
                    (float)panel.getTablaTicket().getModel().getValueAt(row, 2), 
                    (float)panel.getTablaTicket().getModel().getValueAt(row, 4))
                    , row , 5);
            panel.getAcciones().ActualizaTotalTicket();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * Devuelve el valor introducido
     *
     * @return Object Float del valor introducido
     */
    @Override
    public Object getCellEditorValue() {
        String str = (String) super.getCellEditorValue();
        if (str == null) {
            return null;
        }

        if (str.length() == 0) {
            return null;
        }

        try {
            ParsePosition pos = new ParsePosition(0);
            Number n = NumberFormat.getInstance().parse(str, pos);
            if (pos.getIndex() != str.length()) {
                throw new ParseException(
                        "parsing incomplete", pos.getIndex());
            }

            return n.floatValue();

        } catch (ParseException pex) {
            throw new RuntimeException(pex);
        }
    }
    
}
