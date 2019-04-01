/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.modelo.entidades;

/**
 * Clase Categoría
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class Categoria {
    private int id;
    private String nombre;
    private String descripcion;
    private String imagen;
    
    /**
     * Constructor por defecto
     */
    public Categoria() {
        this.id = 0;
    }

    /**
     * Constructor parametrizado
     *
     * @param id int Id de la categoría
     * @param nombre String Nombre de la categoría
     * @param descripcion String Descripción de la categoría
     * @param imagen String Ruta de la imagen de la categoría
     */
    public Categoria(int id, String nombre, String descripcion, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    /**
     * Devuelve el id de la categoría
     *
     * @return int Id de la categoría
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el id de la categoría
     *
     * @param id int Id de la categoría
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre de la categoría
     *
     * @return String Nombre de la categoría
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la categoría
     *
     * @param nombre String Nombre de la categoría
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la descripción de la categoría
     *
     * @return String Descripción de la categoría
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción de la categoría
     *
     * @param descripcion String Descripción de la categoría
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Devuelve la ruta de la imagen de la categoría
     *
     * @return String Ruta de la imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * Establece la ruta de la imagen de la categoría
     *
     * @param imagen String Ruta de la imagen
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    /**
     * Escribe los datos de la categoría
     *
     * @return String id.- nombre | descripción
     */
    @Override
    public String toString() {
        return id + ".- " + nombre + " | " + descripcion;
    }
    
}