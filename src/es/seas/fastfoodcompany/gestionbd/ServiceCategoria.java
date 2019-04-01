/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.gestionbd;

import es.seas.fastfoodcompany.modelo.entidades.Categoria;
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
 * Clase que controla las consultas a la base de datos para la tabla "categoria"
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class ServiceCategoria {
    
    //Instrucciones a base de datos
    private final String SELECT_ALL = "SELECT * FROM categoria";
    private final String SELECT_ONE = "SELECT * FROM categoria WHERE id = ?";
    private final String DELETE = "DELETE FROM categoria WHERE id = ?";
    private final String UPDATE = "UPDATE categoria SET nombre = ?, " +
                                  "descripcion = ?, imagen = ? WHERE id = ?";
    private final String INSERT = "INSERT INTO categoria (nombre, descripcion, "
                                  + "imagen) VALUES (?, ?, ?)";
    private final String CLAUSULAS_BUSQUEDA = "nombre LIKE ? " +
            "OR descripcion LIKE ? OR imagen LIKE ?";
    private final String BUSCAR = "SELECT * FROM categoria WHERE " + 
                                    CLAUSULAS_BUSQUEDA;
    private final String BUSCAR_POR_NOMBRE = "SELECT * FROM categoria "
                                + "WHERE nombre LIKE ?";
    
    // Consultas para evitar conflictos en la base de datos
    // Si encuentra una categoría que ya se esté usando en otra tabla de la 
    // base de datos, ésta no se cargará en la pantalla de eliminación
    private final String SELECT_ELIMINABLES = "SELECT * FROM categoria " +
                            "WHERE id NOT IN " +
                            "(SELECT DISTINCT id_categoria FROM productos)";
    private final String BUSCAR_ELIMINABLES = SELECT_ELIMINABLES + " AND (" + 
                                                CLAUSULAS_BUSQUEDA + ")";
    
    /**
     * Devuelve una lista de categorías con todas las categorías de la base de
     * datos
     *
     * @return ArrayList Listado de categorías
     */
    public List<Categoria> findAll() {
        try {
            List<Categoria> categoria = new ArrayList<>();
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(SELECT_ALL);
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                categoria.add(bind(rs));
            }
            GestionSql.closeConnection(conn);
            return categoria;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCategoria.class.getName()).log(Level.SEVERE,
                                null, ex);
        }
        return null;
    }
    
    /**
     * Devuelve una categoría a partir de su Id
     *
     * @param id int Id de la categoría
     * @return Categoria Categoría encontrada
     */
    public Categoria findById(int id) {
        Categoria categoria = null;
        try {
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(SELECT_ONE);
            query.setInt(1, id);
            ResultSet rs = query.executeQuery();
            while(rs.next()) {
                categoria = bind(rs);
            }
            GestionSql.closeConnection(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCategoria.class.getName()).log(Level.SEVERE,
                                null, ex);
        }
        return categoria;
    }
    
    /**
     * Devuelve una lista de categorías con todas las categorías de la base de
     * datos que no se estén usando en otras tablas
     *
     * @return ArrayList Listado de categorías
     */
    public List<Categoria> findEliminables() {
        try {
            List<Categoria> categoria = new ArrayList<>();
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(SELECT_ELIMINABLES);
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                categoria.add(bind(rs));
            }
            GestionSql.closeConnection(conn);
            return categoria;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCategoria.class.getName()).log(Level.SEVERE,
                                null, ex);
        }
        return null;
    }
    
    /**
     * Devuelve una categoría a partir de su Nombre
     *
     * @param nombre String Nombre de la categoría a buscar
     * @return Categoria Categoría encontrada
     */
    public Categoria findByNombre(String nombre) {
        Categoria categoria = null;
        try {
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(BUSCAR_POR_NOMBRE);
            nombre = "%" + nombre + "%";
            query.setString(1, nombre);
            ResultSet rs = query.executeQuery();
            while(rs.next()) {
                categoria = bind(rs);
            }
            GestionSql.closeConnection(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCategoria.class.getName()).log(Level.SEVERE,
                                null, ex);
        }
        return categoria;
    }
    
    /**
     * Inserta una categoría, pasada por parámetro, en la base de datos
     *
     * @param categoria Categoria Categoría a insertar
     */
    public void insert(Categoria categoria) {
        try {
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(INSERT, 
                                    Statement.RETURN_GENERATED_KEYS);
            query.setString(1, categoria.getNombre());
            query.setString(2, categoria.getDescripcion());
            query.setString(3, categoria.getImagen());
            query.execute();
            ResultSet rs = query.getGeneratedKeys();
            while (rs.next()) {
                categoria.setId(rs.getInt(1));
            }
            GestionSql.closeConnection(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCategoria.class.getName()).log(Level.SEVERE,
                                null, ex);
        }
    }
    
    /**
     * Borra una categoría de la base de datos a partir de su Id
     *
     * @param id int Id de la categoría
     */
    public void delete(int id) {
        try {
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(DELETE);
            query.setInt(1, id);
            query.executeUpdate();
            GestionSql.closeConnection(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCategoria.class.getName()).log(Level.SEVERE,
                                null, ex);
        }
    }
    
    /**
     * Actualiza una categoría, pasada por parámetro, en la base de datos
     *
     * @param categoria Categoria Categoría a actualizar
     */
    public void update(Categoria categoria) {
        try {
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(UPDATE);
            query.setString(1, categoria.getNombre());
            query.setString(2, categoria.getDescripcion());
            query.setString(3, categoria.getImagen());
            query.setInt(4, categoria.getId());
            query.executeUpdate();
            GestionSql.closeConnection(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCategoria.class.getName()).log(Level.SEVERE,
                                null, ex);
        }
    }
    
    /**
     * Busca categorías a partir de un texto que coincida total o parcialmente
     * con cualquier campo de la tabla categorias
     *
     * @param texto String Texto a buscar
     * @return ArrayList Lista de categorías encontradas
     */
    public List<Categoria> buscar(String texto) {
        try {
            List<Categoria> categorias = new ArrayList<>();
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(BUSCAR);
            texto = "%" + texto + "%";
            query.setString(1, texto);
            query.setString(2, texto);
            query.setString(3, texto);
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                categorias.add(bind(rs));
            }
            GestionSql.closeConnection(conn);
            return categorias;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCategoria.class.getName()).log(Level.SEVERE,
                                null, ex);
        }
        return null;
    }
    
    /**
     * Busca categorías, a partir de un texto que coincida total o parcialmente
     * con cualquier campo de la tabla categorias, que no se estén usando en 
     * otras tablas
     *
     * @param texto String Texto a buscar
     * @return ArrayList Lista de categorías encontradas
     */
    public List<Categoria> buscarEliminables(String texto) {
        try {
            List<Categoria> categorias = new ArrayList<>();
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(BUSCAR_ELIMINABLES);
            texto = "%" + texto + "%";
            query.setString(1, texto);
            query.setString(2, texto);
            query.setString(3, texto);
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                categorias.add(bind(rs));
            }
            GestionSql.closeConnection(conn);
            return categorias;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCategoria.class.getName()).log(Level.SEVERE,
                                null, ex);
        }
        return null;
    }
    
    private Categoria bind(ResultSet rs) {
        try {
            Categoria categoria = new Categoria(rs.getInt("id"), 
                    rs.getString("nombre"), rs.getString("descripcion"), 
                    rs.getString("imagen"));
            return categoria;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCategoria.class.getName()).log(Level.SEVERE,
                                null, ex);
        }
        return null;
    }
}
