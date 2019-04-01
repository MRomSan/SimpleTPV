/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.modelo.entidades;

import java.sql.Date;

/**
 * Clase Venta
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class Venta {
    private int id;
    private int id_empleado;
    private Integer id_cliente;
    private Date fecha;
    private String hora;
    private String forma_pago;
    private float total;
    private float entregado;
    
    /**
     * Constructor por defecto
     */
    public Venta() {
        id_cliente = null;
    }
    
    /**
     * Constructor parametrizado
     *
     * @param id int Id de la venta
     * @param id_empleado int Id del empleado que hizo la venta
     * @param id_cliente Integer Id del cliente que hizo la compra
     * @param fecha Date Fecha de la venta
     * @param hora String Hora de la venta
     * @param forma_pago String Forma de pago de la venta
     * @param total float Importe total de la venta
     * @param entregado float Importe entregado por el cliente
     */
    public Venta(int id, int id_empleado, Integer id_cliente, Date fecha, 
            String hora, String forma_pago, float total, float entregado) {
        this.id = id;
        this.id_empleado = id_empleado;
        this.id_cliente = id_cliente;
        this.fecha = fecha;
        this.hora = hora;
        this.forma_pago = forma_pago;
        this.total = total;
        this.entregado = entregado;
    }

    /**
     * Devuelve el id de la venta
     *
     * @return int Id de la venta
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el id de la venta
     *
     * @param id int Id de la venta
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Devuelve el id del empleado que hizo la venta
     *
     * @return int Id del empleado que hizo la venta
     */
    public int getId_empleado() {
        return id_empleado;
    }

    /**
     * Establece el id del empleado que hizo la venta
     *
     * @param id_empleado int Id del empleado que hizo la venta
     */
    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    /**
     * Devuelve el id del cliente que hizo la compra
     *
     * @return Integer Id del cliente que hizo la compra
     */
    public Integer getId_cliente() {
        return id_cliente;
    }

    /**
     * Establece el id del cliente que hizo la compra
     *
     * @param id_cliente Integer Id del cliente que hizo la compra
     */
    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    /**
     * Devuelve la fecha de la venta
     *
     * @return Date Fecha de la venta
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de la venta
     *
     * @param fecha Date Fecha de la venta
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Devuelve la hora de la venta
     *
     * @return String Hora de la venta
     */
    public String getHora() {
        return hora;
    }

    /**
     * Establece la hora de la venta
     *
     * @param hora String Hora de la venta
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * Devuelve la forma de pago de la venta
     *
     * @return String Forma de pago de la venta
     */
    public String getForma_pago() {
        return forma_pago;
    }

    /**
     * Establece la forma de pago de la venta
     *
     * @param forma_pago String Forma de pago de la venta
     */
    public void setForma_pago(String forma_pago) {
        this.forma_pago = forma_pago;
    }

    /**
     * Devuelve el importe total de la venta
     *
     * @return float Importe total de la venta
     */
    public float getTotal() {
        return total;
    }

    /**
     * Establece el importe total de la venta
     *
     * @param total float Importe total de la venta
     */
    public void setTotal(float total) {
        this.total = total;
    }

    /**
     * Devuelve el importe entregado por el cliente
     *
     * @return float Importe entregado por el cliente
     */
    public float getEntregado() {
        return entregado;
    }

    /**
     * Establece el importe entregado por el cliente
     *
     * @param entregado float Importe entregado por el cliente
     */
    public void setEntregado(float entregado) {
        this.entregado = entregado;
    }

    /**
     * Escribe los datos de la venta
     *
     * @return String Venta{id, fecha, hora, forma_pago, total, entregado}
     */
    @Override
    public String toString() {
        return "Venta{" + "id=" + id + ", fecha=" + fecha + ", hora=" + hora + 
               ", forma_pago=" + forma_pago + ", total=" + total + 
               ", entregado=" + entregado + '}';
    }
    
    
    
}
