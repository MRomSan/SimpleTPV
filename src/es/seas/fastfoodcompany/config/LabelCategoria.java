/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.config;

import es.seas.fastfoodcompany.modelo.entidades.Categoria;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Clase label para las Categorías del TPV Táctil
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class LabelCategoria extends javax.swing.JLabel{
    private final String CARPETA_IMAGENES = "imagenes/";
    private Categoria categoria;

    /**
     * Constructor predeterminado
     */
    public LabelCategoria() {
        super();
        Dimension d = new Dimension(87, 87);
        this.categoria = null;
        this.setPreferredSize(d);
        this.setHorizontalAlignment(CENTER);
        this.setHorizontalTextPosition(CENTER);
        this.setVerticalTextPosition(BOTTOM);
        this.setIconTextGap(2);
    }

    /**
     * Constructor parametrizado, incluye la Categoría
     *
     * @param categoria Categoria
     */
    public LabelCategoria(Categoria categoria) {
        this();
        this.categoria = categoria;
        this.setText("<html><center>" + categoria.getDescripcion() + 
                    "</center></html>");
        this.setIcon(new ImageIcon(
                new ImageIcon(CARPETA_IMAGENES + categoria.getImagen())
                        .getImage().getScaledInstance(74, 62, 
                                Image.SCALE_DEFAULT)));
    }

    /**
     * Devuelve la Categoría enlazada al label
     *
     * @return Categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * Establece la Categoría enlazada al label
     *
     * @param categoria Categoria
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
}
