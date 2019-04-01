/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.gestionbd;

import es.seas.fastfoodcompany.modelo.entidades.Venta;
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
 * Clase que controla las consultas a la base de datos para la tabla "ventas"
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class ServiceVenta {
    private final String SELECT_ALL = "SELECT * FROM ventas" +
                                " ORDER BY fecha DESC, hora DESC";
    private final String SELECT_ONE = "SELECT * FROM ventas WHERE id = ?";
    private final String DELETE = "DELETE FROM ventas WHERE id = ?";
    private final String UPDATE = "UPDATE ventas SET id_empleado = ?, " +
                                  "id_cliente = ?, fecha = ?, hora = ?, " +
                                  "forma_pago = ?, total = ?, entregado = ? " +
                                  "WHERE id = ?";
    private final String INSERT = "INSERT INTO ventas (id_empleado, " +
                                  "id_cliente, fecha, hora, forma_pago, " +
                                  "total, entregado) " + 
                                  "VALUES (?, ?, ?, ?, ?, ?, ?)";
    private final String BUSCAR = "SELECT * FROM ventas "
            + "WHERE (fecha LIKE ? OR hora LIKE ? OR forma_pago LIKE ? "
            + "OR total LIKE ? OR entregado LIKE ?)";

    /**
     * Devuelve una lista de ventas con todas las ventas de la base de
     * datos
     *
     * @return ArrayList Listado de ventas
     */
    public List<Venta> findAll() {
        try {
            List<Venta> ventas = new ArrayList<>();
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(SELECT_ALL);
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                ventas.add(bind(rs));
            }
            GestionSql.closeConnection(conn);
            return ventas;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceVenta.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        return null;
    }
    
    /**
     * Devuelve una venta a partir de su Id
     *
     * @param id int Id de la venta
     * @return Venta Venta encontrada
     */
    public Venta findById(int id) {
        Venta venta = null;
        try {
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(SELECT_ONE);
            query.setInt(1, id);
            ResultSet rs = query.executeQuery();
            while(rs.next()) {
                venta = bind(rs);
            }
            GestionSql.closeConnection(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceVenta.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        return venta;
    }
    
    /**
     * Inserta una venta, pasada por parámetro, en la base de datos
     *
     * @param venta Venta Venta a insertar
     */
    public void insert(Venta venta) {
        try {
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(INSERT, 
                                    Statement.RETURN_GENERATED_KEYS);
            query.setInt(1, venta.getId_empleado());
            if(venta.getId_cliente() == null) 
                query.setNull(2, java.sql.Types.INTEGER);
            else query.setInt(2, venta.getId_cliente());
            query.setDate(3, venta.getFecha());
            query.setString(4, venta.getHora());
            query.setString(5, venta.getForma_pago());
            query.setFloat(6, venta.getTotal());
            query.setFloat(7, venta.getEntregado());
            query.execute();
            ResultSet rs = query.getGeneratedKeys();
            while (rs.next()) {
                venta.setId(rs.getInt(1));
            }
            GestionSql.closeConnection(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceVenta.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }
    
    /**
     * Borra una venta de la base de datos a partir de su Id
     *
     * @param id int Id de la venta
     */
    public void delete(int id) {
        try {
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(DELETE);
            query.setInt(1, id);
            query.executeUpdate();
            GestionSql.closeConnection(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceVenta.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }
    
    /**
     * Actualiza una venta, pasada por parámetro, en la base de datos
     *
     * @param venta Venta Venta a actualizar
     */
    public void update(Venta venta) {
        try {
            Connection conn = GestionSql.openConnection();
            PreparedStatement query;
            query = conn.prepareStatement(UPDATE);
            query.setInt(1, venta.getId_empleado());
            if(venta.getId_cliente() == null) {
                query.setNull(2, java.sql.Types.INTEGER);
            } else {
                query.setInt(2, venta.getId_cliente());
            }
            query.setDate(3, venta.getFecha());
            query.setString(4, venta.getHora());
            query.setString(5, venta.getForma_pago());
            query.setFloat(6, venta.getTotal());
            query.setFloat(7, venta.getEntregado());
            query.setInt(8, venta.getId());
            query.executeUpdate();
            GestionSql.closeConnection(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceVenta.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }
    
    /**
     * Busca ventas a partir de un texto que coincida total o parcialmente
     * con cualquier campo de la tabla ventas
     *
     * @param texto String Texto a buscar en cualquier campo
     * @param fecha String Si no está vacío buscará las ventas de ésta fecha
     * @param idCliente Integer Si no está vacío buscará las ventas de éste cliente
     * @return ArrayList Lista de ventas encontradas
     */
    public List<Venta> buscar(String texto, String fecha, Integer idCliente) {
        try {
            List<Venta> ventas = new ArrayList<>();
            Connection conn = GestionSql.openConnection();
            String selectBusqueda = BUSCAR;
            
            if(fecha != null){
                selectBusqueda += " AND fecha LIKE \"%" + fecha + "%\"";
            }
            if(idCliente != null){
                selectBusqueda += " AND id_cliente = " + idCliente + "";
            }
            
            //Ordenados por fecha
            selectBusqueda += " ORDER BY fecha DESC, hora DESC";
            
            PreparedStatement query = conn.prepareStatement(selectBusqueda);
            
            texto = "%" + texto + "%";
            query.setString(1, texto);
            query.setString(2, texto);
            query.setString(3, texto);
            query.setString(4, texto);
            query.setString(5, texto);
            
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                ventas.add(bind(rs));
            }
            GestionSql.closeConnection(conn);
            return ventas;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceVenta.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        return null;
    }
    
    private Venta bind(ResultSet rs) {
        try {
            Integer idCliente = rs.getInt("id_cliente");
            Venta venta = new Venta(rs.getInt("id"), 
                    rs.getInt("id_empleado"), idCliente, 
                    rs.getDate("fecha"), rs.getString("hora"),
                    rs.getString("forma_pago"), rs.getFloat("total"), 
                    rs.getFloat("entregado"));
            return venta;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceVenta.class.getName()).log(Level.SEVERE,
                    null, ex);
        } 
        return null;
    }
}
