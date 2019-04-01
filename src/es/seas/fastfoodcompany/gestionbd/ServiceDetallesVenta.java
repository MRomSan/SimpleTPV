/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.gestionbd;

import es.seas.fastfoodcompany.modelo.entidades.DetallesVenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que controla las consultas a la base de datos para la tabla 
 * "detalles_venta"
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class ServiceDetallesVenta {
    
    //Instrucciones a base de datos
    private final String SELECT_ALL = "SELECT * FROM detalles_venta";
    private final String SELECT_ONE = "SELECT * FROM detalles_venta WHERE id = ?";
    private final String SELECT_BY_VENTA = "SELECT * FROM detalles_venta " +
                                    "WHERE id_venta = ? ORDER BY id_producto";
    private final String DETALLE_YA_EN_VENTA = "SELECT * FROM detalles_venta " +
                        "WHERE id_venta = ? AND id_producto = ?";
    private final String DELETE = "DELETE FROM detalles_venta WHERE id = ?";
    private final String DELETE_VENTA = "DELETE FROM detalles_venta " +
                                        "WHERE id_venta = ?";
    private final String UPDATE = "UPDATE detalles_venta SET id_venta = ?, " +
                                  "id_producto = ?, cantidad = ?, " +
                                  "precio_linea = ?, descuento_linea = ? " +
                                  "WHERE id = ?";
    private final String INSERT = "INSERT INTO detalles_venta (id_venta, " +
                                  "id_producto, cantidad, precio_linea, " +
                                  "descuento_linea) " + 
                                  "VALUES (?, ?, ?, ?, ?)";
    private final String BUSCAR = "SELECT * FROM detalles_venta "
            + "WHERE cantidad LIKE ? OR precio_linea LIKE ? "
            + "OR descuento_linea LIKE ?";
    
    /**
     * Devuelve una lista de detalles de ventas con todos los detalles de ventas
     * de la base de datos
     *
     * @return ArrayList Listado de detalles de ventas
     */
    public List<DetallesVenta> findAll() {
        try {
            List<DetallesVenta> detallesVenta = new ArrayList<>();
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(SELECT_ALL);
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                detallesVenta.add(bind(rs));
            }
            GestionSql.closeConnection(conn);
            return detallesVenta;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDetallesVenta.class.getName()).log(
                                Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * Devuelve un detalle de venta a partir de su Id
     *
     * @param id int Id del detalle de venta
     * @return DetallesVenta Detalle de venta encontrado
     */
    public DetallesVenta findById(int id) {
        DetallesVenta detalleVenta = null;
        try {
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(SELECT_ONE);
            query.setInt(1, id);
            ResultSet rs = query.executeQuery();
            while(rs.next()) {
                detalleVenta = bind(rs);
            }
            GestionSql.closeConnection(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDetallesVenta.class.getName()).log(
                                Level.SEVERE, null, ex);
        }
        return detalleVenta;
    }
    
    /**
     * Devuelve un detalle de venta a partir de su Id de venta
     *
     * @param idVenta int Id de la venta a la que pertenece el detalle
     * @return DetallesVenta Detalle de venta encontrado
     */
    public List<DetallesVenta> findByVenta(int idVenta) {
        List<DetallesVenta> detallesVenta = new ArrayList<>();
        try {
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(SELECT_BY_VENTA);
            query.setInt(1, idVenta);
            ResultSet rs = query.executeQuery();
            while(rs.next()) {
                detallesVenta.add(bind(rs));
            }
            GestionSql.closeConnection(conn);
            return detallesVenta;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDetallesVenta.class.getName()).log(
                                Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * Devuelve un detalle de venta a partir de su Id de venta y del Id del 
     * producto para averiguar si ya existe el producto en el ticket
     *
     * @param idVenta int Id de la venta
     * @param idProducto int Id del producto
     * @return DetallesVenta Detalle de venta encontrado
     */
    public DetallesVenta findIfIsInVenta(int idVenta, int idProducto) {
        DetallesVenta detalleVenta = null;
        try {
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(DETALLE_YA_EN_VENTA);
            query.setInt(1, idVenta);
            query.setInt(2, idProducto);
            ResultSet rs = query.executeQuery();
            while(rs.next()) {
                detalleVenta = bind(rs);
            }
            GestionSql.closeConnection(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDetallesVenta.class.getName()).log(
                                Level.SEVERE, null, ex);
        }
        return detalleVenta;
    }
    
    /**
     * Inserta un detalle de venta, pasado por parámetro, en la base de datos
     *
     * @param detalleVenta DetallesVenta Detalle de venta a insertar
     */
    public void insert(DetallesVenta detalleVenta) {
        try {
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(INSERT, 
                                    Statement.RETURN_GENERATED_KEYS);
            query.setInt(1, detalleVenta.getId_venta());
            query.setInt(2, detalleVenta.getId_producto());
            query.setFloat(3, detalleVenta.getCantidad());
            query.setFloat(4, detalleVenta.getPrecio_linea());
            query.setFloat(5, detalleVenta.getDescuento_linea());
            query.execute();
            ResultSet rs = query.getGeneratedKeys();
            while (rs.next()) {
                detalleVenta.setId(rs.getInt(1));
            }
            GestionSql.closeConnection(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDetallesVenta.class.getName()).log(
                                Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Borra un detalle de venta de la base de datos a partir de su Id
     *
     * @param id int Id del detalle de venta
     */
    public void delete(int id) {
        try {
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(DELETE);
            query.setInt(1, id);
            query.executeUpdate();
            GestionSql.closeConnection(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDetallesVenta.class.getName()).log(
                                Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Borra los detalle de venta de la base de datos pertenecientes a la misma 
     * venta
     *
     * @param idVenta int Id de la venta
     */
    public void deleteByVenta(int idVenta) {
        try {
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(DELETE_VENTA);
            query.setInt(1, idVenta);
            query.executeUpdate();
            GestionSql.closeConnection(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDetallesVenta.class.getName()).log(
                                Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Actualiza un detalle de venta, pasado por parámetro, en la base de datos
     *
     * @param detalleVenta DetallesVenta Detalle de venta a actualizar
     */
    public void update(DetallesVenta detalleVenta) {
        try {
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(UPDATE);
            query.setInt(1, detalleVenta.getId_venta());
            query.setInt(2, detalleVenta.getId_producto());
            query.setFloat(3, detalleVenta.getCantidad());
            query.setFloat(4, detalleVenta.getPrecio_linea());
            query.setFloat(5, detalleVenta.getDescuento_linea());
            query.setInt(6, detalleVenta.getId());
            query.executeUpdate();
            GestionSql.closeConnection(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDetallesVenta.class.getName()).log(
                                Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Busca detalles de ventas a partir de un texto que coincida total o 
     * parcialmente con cualquier campo de la tabla detalles_venta
     *
     * @param texto String Texto a buscar
     * @return ArrayList Lista de detalles de ventas encontrados
     */
    public List<DetallesVenta> buscar(String texto) {
        try {
            List<DetallesVenta> detallesVenta = new ArrayList<>();
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(BUSCAR);
            texto = "%" + texto + "%";
            query.setString(1, texto);
            query.setString(2, texto);
            query.setString(3, texto);
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                detallesVenta.add(bind(rs));
            }
            GestionSql.closeConnection(conn);
            return detallesVenta;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDetallesVenta.class.getName()).log(
                                Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private DetallesVenta bind(ResultSet rs) {
        try {
            DetallesVenta detalleVenta = new DetallesVenta(rs.getInt("id"), 
                    rs.getInt("id_venta"), rs.getInt("id_producto"), 
                    rs.getFloat("cantidad"), rs.getFloat("precio_linea"),
                    rs.getFloat("descuento_linea"));
            return detalleVenta;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDetallesVenta.class.getName()).log(
                                Level.SEVERE, null, ex);
        }
        return null;
    }
}
