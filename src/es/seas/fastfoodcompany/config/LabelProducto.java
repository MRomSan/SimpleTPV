/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.config;

import es.seas.fastfoodcompany.gestionbd.ServiceCategoria;
import es.seas.fastfoodcompany.modelo.entidades.Categoria;
import es.seas.fastfoodcompany.modelo.entidades.Producto;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Clase label para las Categorías del TPV Táctil
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class LabelProducto extends javax.swing.JLabel{
    private final String CARPETA_IMAGENES = "imagenes/";
    private Producto producto;

    /**
     * Constructor predeterminado
     */
    public LabelProducto() {
        super();
        Dimension d = new Dimension(115, 115);
        this.producto = null;
        this.setPreferredSize(d);
        this.setHorizontalAlignment(CENTER);
        this.setVerticalAlignment(TOP);
        this.setHorizontalTextPosition(CENTER);
        this.setVerticalTextPosition(BOTTOM);
        this.setIconTextGap(2);
    }

    /**
     * Constructor parametrizado, incluye el Producto
     *
     * @param producto Producto
     */
    public LabelProducto(Producto producto) {
        this();
        ServiceCategoria categoriaDAO = new ServiceCategoria();
        Categoria categoria;
        this.producto = producto;
        this.setText("<html><center>" + producto.getDescripcion() + 
                    "</center></html>");
        this.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 9));
        categoria = categoriaDAO.findById(producto.getId_categoria());
        this.setIcon(new ImageIcon(
                new ImageIcon(CARPETA_IMAGENES + 
                        categoria.getNombre() + "/" + producto.getImagen())
                        .getImage().getScaledInstance(99, 87, 
                                Image.SCALE_DEFAULT)));
    }
    
    /**
     * Devuelve el Producto enlazado al label
     *
     * @return Producto
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * Establece el Producto enlazado al label
     *
     * @param producto Producto
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

}
