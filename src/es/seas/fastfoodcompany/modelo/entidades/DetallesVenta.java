/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.modelo.entidades;

/**
 * Clase DetallesVenta
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class DetallesVenta {
    private int id;
    private int id_venta;
    private int id_producto;
    private float cantidad;
    private float precio_linea;
    private float descuento_linea;

    /**
     * Constructor por defecto
     */
    public DetallesVenta() {
    }

    /**
     * Constructor parametrizado
     *
     * @param id int Id del detalle de la venta
     * @param id_venta int Id de la venta a la que pertenece
     * @param id_producto int Id del producto vendido
     * @param cantidad Date Cantidad del producto vendido
     * @param precio_linea String Precio del detalle (cantidad * precioProducto)
     * @param descuento_linea String Descuento realizado en el detalle
     */
    public DetallesVenta(int id, int id_venta, int id_producto, float cantidad, 
            float precio_linea, float descuento_linea) {
        this.id = id;
        this.id_venta = id_venta;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.precio_linea = precio_linea;
        this.descuento_linea = descuento_linea;
    }

    /**
     * Devuelve el id del detalle de la venta
     *
     * @return int Detalle de la venta
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el id del detalle de la venta
     *
     * @param id int Detalle de la venta
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Devuelve el id de la venta a la que pertenece
     *
     * @return int Id de la venta
     */
    public int getId_venta() {
        return id_venta;
    }

    /**
     * Establece el id de la venta a la que pertenece
     *
     * @param id_venta int Id de la venta
     */
    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    /**
     * Devuelve el id del producto vendido
     *
     * @return int Id del producto vendido
     */
    public int getId_producto() {
        return id_producto;
    }

    /**
     * Establece el id del producto vendido
     *
     * @param id_producto int Id del producto vendido
     */
    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    /**
     * Devuelve la cantidad del producto vendido
     *
     * @return float Cantidad del producto vendido
     */
    public float getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad del producto vendido
     *
     * @param cantidad float Cantidad del producto vendido
     */
    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Devuelve el precio del detalle (cantidad * precioProducto)
     *
     * @return float Precio del detalle
     */
    public float getPrecio_linea() {
        return precio_linea;
    }

    /**
     * Establece el precio del detalle (cantidad * precioProducto)
     *
     * @param precio_linea float Precio del detalle
     */
    public void setPrecio_linea(float precio_linea) {
        this.precio_linea = precio_linea;
    }

    /**
     * Devuelve el descuento realizado en el detalle
     *
     * @return float Descuento realizado en el detalle
     */
    public float getDescuento_linea() {
        return descuento_linea;
    }

    /**
     * Establece el descuento realizado en el detalle
     *
     * @param descuento_linea float Descuento realizado en el detalle
     */
    public void setDescuento_linea(float descuento_linea) {
        this.descuento_linea = descuento_linea;
    }
    
    /**
     * Escribe los datos del detalle de la venta
     *
     * @return String id.- cantidad | precio_linea | descuento_linea
     */
    @Override
    public String toString() {
        return id + ".- " + cantidad +  " | " + precio_linea + " | " + 
               descuento_linea;
    }
    
}
