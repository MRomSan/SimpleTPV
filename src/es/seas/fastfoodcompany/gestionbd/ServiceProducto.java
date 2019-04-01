/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.gestionbd;

import es.seas.fastfoodcompany.modelo.entidades.Producto;
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
 * Clase que controla las consultas a la base de datos para la tabla "productos"
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class ServiceProducto {
    
    //Instrucciones a base de datos
    private final String SELECT_ALL = "SELECT * FROM productos" +
                                    " ORDER BY id_categoria";
    private final String SELECT_ONE = "SELECT * FROM productos WHERE id = ?";
    private final String SELECT_BY_CATEGORIA = "SELECT * FROM productos " +
                                    "WHERE id_categoria = ?";
    private final String SELECT_BY_NOMBRE = "SELECT * FROM productos " +
                                    "WHERE nombre = ?";
    private final String DELETE = "DELETE FROM productos WHERE id = ?";
    private final String UPDATE = "UPDATE productos SET nombre = ?, " +
                                  "descripcion = ?, precio = ?, imagen = ?, " +
                                  "id_categoria = ?, id_iva = ? WHERE id = ?";
    private final String INSERT = "INSERT INTO productos (nombre, descripcion, " +
                                  "precio, imagen, id_categoria, id_iva) " + 
                                  "VALUES (?, ?, ?, ?, ?, ?)";
    private final String CLAUSULAS_BUSQUEDA = "nombre LIKE ? "
            + "OR descripcion LIKE ? OR precio LIKE ? OR imagen LIKE ?";
    private final String BUSCAR = "SELECT * FROM productos WHERE (" + 
                                    CLAUSULAS_BUSQUEDA + ")";
    
    // Consultas para evitar conflictos en la base de datos
    // Si encuentra una categoría que ya se esté usando en otra tabla de la 
    // base de datos, ésta no se cargará en la pantalla de eliminación
    private final String SELECT_ELIMINABLES = "SELECT * FROM productos " +
                            "WHERE id NOT IN " +
                            "(SELECT DISTINCT id_producto FROM detalles_venta)";
    private final String BUSCAR_ELIMINABLES = SELECT_ELIMINABLES + " AND (" + 
                                                CLAUSULAS_BUSQUEDA + ")";
    
    /**
     * Devuelve una lista de productos con todos los productos de la base de
     * datos
     *
     * @return ArrayList Listado de productos
     */
    public List<Producto> findAll() {
        try {
            List<Producto> productos = new ArrayList<>();
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(SELECT_ALL);
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                productos.add(bind(rs));
            }
            GestionSql.closeConnection(conn);
            return productos;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProducto.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        return null;
    }
    
    /**
     * Devuelve un producto a partir de su Id
     *
     * @param id int Id del producto
     * @return Producto Producto encontrado
     */
    public Producto findById(int id) {
        Producto producto = null;
        try {
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(SELECT_ONE);
            query.setInt(1, id);
            ResultSet rs = query.executeQuery();
            while(rs.next()) {
                producto = bind(rs);
            }
            GestionSql.closeConnection(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProducto.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        return producto;
    }
    
    /**
     * Devuelve una lista de productos con todos los productos de una categoría 
     * específica
     *
     * @param idCategoria int Id de la categoría
     * @return ArrayList Listado de productos
     */
    public List<Producto> findByCategoria(int idCategoria) {
        try {
            List<Producto> productos = new ArrayList<>();
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(SELECT_BY_CATEGORIA);
            query.setInt(1, idCategoria);
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                productos.add(bind(rs));
            }
            GestionSql.closeConnection(conn);
            return productos;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProducto.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        return null;
    }
    
    /**
     * Devuelve un producto a partir de su Nombre
     *
     * @param nombre String Nombre del producto
     * @return Producto Producto encontrado
     */
    public Producto findByNombre(String nombre) {
        Producto producto = null;
        try {
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(SELECT_BY_NOMBRE);
            query.setString(1, nombre);
            ResultSet rs = query.executeQuery();
            while(rs.next()) {
                producto = bind(rs);
            }
            GestionSql.closeConnection(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProducto.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        return producto;
    }
    
    /**
     * Devuelve una lista de productos con todos los productos de la base de
     * datos que no se estén usando en otras tablas
     *
     * @return ArrayList Listado de productos
     */
    public List<Producto> findEliminables() {
        try {
            List<Producto> productos = new ArrayList<>();
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(SELECT_ELIMINABLES);
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                productos.add(bind(rs));
            }
            GestionSql.closeConnection(conn);
            return productos;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProducto.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        return null;
    }
    
    /**
     * Inserta un producto, pasado por parámetro, en la base de datos
     *
     * @param producto Producto Producto a insertar
     */
    public void insert(Producto producto) {
        try {
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(INSERT, 
                                    Statement.RETURN_GENERATED_KEYS);
            query.setString(1, producto.getNombre());
            query.setString(2, producto.getDescripcion());
            query.setFloat(3, producto.getPrecio());
            query.setString(4, producto.getImagen());
            query.setInt(5, producto.getId_categoria());
            query.setInt(6, producto.getId_iva());
            query.execute();
            ResultSet rs = query.getGeneratedKeys();
            while (rs.next()) {
                producto.setId(rs.getInt(1));
            }
            GestionSql.closeConnection(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProducto.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }
    
    /**
     * Borra un producto de la base de datos a partir de su Id
     *
     * @param id int Id del producto
     */
    public void delete(int id) {
        try {
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(DELETE);
            query.setInt(1, id);
            query.executeUpdate();
            GestionSql.closeConnection(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProducto.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }
    
    /**
     * Actualiza un producto, pasado por parámetro, en la base de datos
     *
     * @param producto Producto Producto a actualizar
     */
    public void update(Producto producto) {
        try {
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(UPDATE);
            query.setString(1, producto.getNombre());
            query.setString(2, producto.getDescripcion());
            query.setFloat(3, producto.getPrecio());
            query.setString(4, producto.getImagen());
            query.setInt(5, producto.getId_categoria());
            query.setInt(6, producto.getId_iva());
            query.setInt(7, producto.getId());
            query.executeUpdate();
            GestionSql.closeConnection(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProducto.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }
    
    /**
     * Busca productos a partir de un texto que coincida total o parcialmente
     * con cualquier campo de la tabla productos
     *
     * @param texto String Texto a buscar
     * @param idCategoria Integer Id de la Categoría seleccionada en el filtro 
     * de búsqueda
     * @return ArrayList Lista de productos encontrados
     */
    public List<Producto> buscar(String texto, Integer idCategoria) {
        try {
            List<Producto> productos = new ArrayList<>();
            Connection conn = GestionSql.openConnection();
            String clBusCategoria = "";
            
            if (idCategoria != null)
                clBusCategoria = " AND (id_categoria = " + idCategoria + ")";
            
            //Ordenados por categoría
            clBusCategoria += " ORDER BY id_categoria";
            
            PreparedStatement query = conn.prepareStatement(BUSCAR + 
                                                        clBusCategoria);
            texto = "%" + texto + "%";
            query.setString(1, texto);
            query.setString(2, texto);
            query.setString(3, texto);
            query.setString(4, texto);
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                productos.add(bind(rs));
            }
            GestionSql.closeConnection(conn);
            return productos;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProducto.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        return null;
    }
    
    /**
     * Busca productos, a partir de un texto que coincida total o parcialmente
     * con cualquier campo de la tabla productos, que no se estén usando en 
     * otras tablas
     *
     * @param texto String Texto a buscar
     * @param idCategoria Integer Id de la Categoría seleccionada en el filtro 
     * de búsqueda
     * @return ArrayList Lista de productos encontrados
     */
    public List<Producto> buscarEliminables(String texto, Integer idCategoria) {
        try {
            List<Producto> productos = new ArrayList<>();
            Connection conn = GestionSql.openConnection();
            String clBusCategoria = "";
            
            if (idCategoria != null)
                clBusCategoria = " AND (id_categoria = " + idCategoria + ")";
            
            //Ordenados por categoría
            clBusCategoria += " ORDER BY id_categoria";
            
            PreparedStatement query = conn.prepareStatement(BUSCAR_ELIMINABLES + 
                                                        clBusCategoria);
            texto = "%" + texto + "%";
            query.setString(1, texto);
            query.setString(2, texto);
            query.setString(3, texto);
            query.setString(4, texto);
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                productos.add(bind(rs));
            }
            GestionSql.closeConnection(conn);
            return productos;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProducto.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        return null;
    }
    
    private Producto bind(ResultSet rs) {
        try {
            Producto producto = new Producto(rs.getInt("id"), 
                    rs.getString("nombre"), rs.getString("descripcion"), 
                    rs.getFloat("precio"), rs.getString("imagen"),
                    rs.getInt("id_categoria"), rs.getInt("id_iva"));
            return producto;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProducto.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        return null;
    }
}
