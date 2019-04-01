/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.modelo.entidades;

/**
 * Clase IVA
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class Iva {
    private int id;
    private String nombre;
    private float cantidad;
    
    /**
     * Constructor por defecto
     */
    public Iva() {
    }

    /**
     * Constructor parametrizado
     *
     * @param id int Id del IVA
     * @param nombre String Nombre del IVA
     * @param cantidad float Cantidad (%) del IVA
     */
    public Iva(int id, String nombre, float cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    /**
     * Devuelve el id del IVA
     *
     * @return int Id del IVA
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el id del IVA
     *
     * @param id int Id del IVA
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre del IVA
     *
     * @return String Nombre del IVA
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del IVA
     *
     * @param nombre String Nombre del IVA
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la cantidad (%) del IVA
     *
     * @return float Cantidad (%) del IVA
     */
    public float getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad (%) del IVA
     *
     * @param cantidad float Cantidad (%) del IVA
     */
    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Escribe los datos del IVA
     *
     * @return String id.- nombre | cantidad
     */
    @Override
    public String toString() {
        return id + ".- " + nombre + " | " + cantidad;
    }
    
}
