/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.modelo.entidades;

/**
 * Clase Producto
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class Producto {
    private int id;
    private String nombre;
    private String descripcion;
    private float precio;
    private String imagen;
    private int id_categoria;
    private int id_iva;

    /**
     * Constructor por defecto
     */
    public Producto() {
    }

    /**
     * Constructor parametrizado
     *
     * @param id int Id del producto
     * @param nombre String Nombre del producto
     * @param descripcion String Descripción del producto
     * @param precio float Precio del producto
     * @param imagen String Ruta de la imagen del producto
     * @param id_categoria int Id de la categoría del producto
     * @param id_iva int Id del IVA del producto
     */
    public Producto(int id, String nombre, String descripcion, float precio, 
            String imagen, int id_categoria, int id_iva) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen = imagen;
        this.id_categoria = id_categoria;
        this.id_iva = id_iva;
    }

    /**
     * Devuelve el id del producto
     *
     * @return int Id del producto
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el id del producto
     *
     * @param id int Id del producto
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre del producto
     *
     * @return String Nombre del producto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto
     *
     * @param nombre String Nombre del producto
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la descripción del producto
     *
     * @return String Descripción del producto
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del producto
     *
     * @param descripcion String Descripción del producto
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Devuelve el precio del producto
     *
     * @return float Precio del producto
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto
     *
     * @param precio float Precio del producto
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * Devuelve la ruta de la imagen del producto
     *
     * @return String Ruta de la imagen del producto
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * Establece la ruta de la imagen del producto
     *
     * @param imagen String Ruta de la imagen del producto
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * Devuelve el id de la categoría del producto
     *
     * @return int Id de la categoría del producto
     */
    public int getId_categoria() {
        return id_categoria;
    }

    /**
     * Establece el id de la categoría del producto
     *
     * @param id_categoria int Id de la categoría del producto
     */
    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    /**
     * Devuelve el id del IVA del producto
     *
     * @return int Id del IVA del producto
     */
    public int getId_iva() {
        return id_iva;
    }

    /**
     * Establece el id del IVA del producto
     *
     * @param id_iva int Id del IVA del producto
     */
    public void setId_iva(int id_iva) {
        this.id_iva = id_iva;
    }

    /**
     * Escribe los datos del producto
     *
     * @return String id.- nombre | precio
     */
    @Override
    public String toString() {
        return id + ".- " + nombre + " | " + precio;
    }

}
