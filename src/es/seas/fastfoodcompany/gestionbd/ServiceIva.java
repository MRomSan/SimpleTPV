/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.gestionbd;

import es.seas.fastfoodcompany.modelo.entidades.Iva;
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
 * Clase que controla las consultas a la base de datos para la tabla "iva"
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class ServiceIva {
    
    //Instrucciones a base de datos
    private final String SELECT_ALL = "SELECT * FROM iva";
    private final String SELECT_ONE = "SELECT * FROM iva WHERE id = ?";
    private final String DELETE = "DELETE FROM iva WHERE id = ?";
    private final String UPDATE = "UPDATE iva SET nombre = ?, cantidad = ? "
                                + "WHERE id = ?";
    private final String INSERT = "INSERT INTO iva (nombre, cantidad) "
                                + "VALUES (?, ?)";
    private final String CLAUSULAS_BUSQUEDA = "nombre LIKE ? OR cantidad LIKE ?";
    private final String BUSCAR = "SELECT * FROM iva WHERE " + 
                                    CLAUSULAS_BUSQUEDA;
    private final String BUSCAR_POR_NOMBRE = "SELECT * FROM iva "
                                + "WHERE nombre LIKE ?";
    
    // Consultas para evitar conflictos en la base de datos
    // Si encuentra un iva que ya se esté usando en otra tabla de la 
    // base de datos, ésta no se cargará en la pantalla de eliminación
    private final String SELECT_ELIMINABLES = "SELECT * FROM iva " +
                            "WHERE id NOT IN " +
                            "(SELECT DISTINCT id_iva FROM productos)";
    private final String BUSCAR_ELIMINABLES = SELECT_ELIMINABLES + " AND (" + 
                                                CLAUSULAS_BUSQUEDA + ")";
    
    /**
     * Devuelve una lista de IVAs con todos los IVAs de la base de datos
     *
     * @return ArrayList Listado de IVAs
     */
    public List<Iva> findAll() {
        try {
            List<Iva> ivas = new ArrayList<>();
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(SELECT_ALL);
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                ivas.add(bind(rs));
            }
            GestionSql.closeConnection(conn);
            return ivas;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceIva.class.getName()).log(Level.SEVERE, null,
                            ex);
        }
        return null;
    }
    
    /**
     * Devuelve un IVA a partir de su Id
     *
     * @param id int Id del IVA
     * @return Iva IVA encontrado
     */
    public Iva findById(int id) {
        Iva iva = null;
        try {
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(SELECT_ONE);
            query.setInt(1, id);
            ResultSet rs = query.executeQuery();
            while(rs.next()) {
                iva = bind(rs);
            }
            GestionSql.closeConnection(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceIva.class.getName()).log(Level.SEVERE, null,
                            ex);
        }
        return iva;
    }
    
    /**
     * Devuelve un IVA a partir de su Nombre
     *
     * @param nombre String Nombre del IVA a buscar
     * @return Iva IVA encontrado
     */
    public Iva findByNombre(String nombre) {
        try {
            Iva iva = null;
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(BUSCAR_POR_NOMBRE);
            nombre = "%" + nombre + "%";
            query.setString(1, nombre);
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                iva = bind(rs);
            }
            GestionSql.closeConnection(conn);
            return iva;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceIva.class.getName()).log(Level.SEVERE, null, 
                            ex);
        }
        return null;
    }
    
    /**
     * Devuelve una lista de IVAs con todos los IVAs de la base de datos que no 
     * se estén usando en otras tablas
     *
     * @return ArrayList Listado de IVAs
     */
    public List<Iva> findEliminables() {
        try {
            List<Iva> ivas = new ArrayList<>();
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(SELECT_ELIMINABLES);
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                ivas.add(bind(rs));
            }
            GestionSql.closeConnection(conn);
            return ivas;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceIva.class.getName()).log(Level.SEVERE, null,
                            ex);
        }
        return null;
    }
    
    /**
     * Inserta un IVA, pasado por parámetro, en la base de datos
     *
     * @param iva Iva IVA a insertar
     */
    public void insert(Iva iva) {
        try {
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(INSERT, 
                                    Statement.RETURN_GENERATED_KEYS);
            query.setString(1, iva.getNombre());
            query.setFloat(2, iva.getCantidad());
            query.execute();
            ResultSet rs = query.getGeneratedKeys();
            while (rs.next()) {
                iva.setId(rs.getInt(1));
            }
            GestionSql.closeConnection(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceIva.class.getName()).log(Level.SEVERE, null,
                            ex);
        }
    }
    
    /**
     * Borra un IVA de la base de datos a partir de su Id
     *
     * @param id int Id del IVA
     */
    public void delete(int id) {
        try {
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(DELETE);
            query.setInt(1, id);
            query.executeUpdate();
            GestionSql.closeConnection(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceIva.class.getName()).log(Level.SEVERE, null, 
                            ex);
        }
    }
    
    /**
     * Actualiza un IVA, pasado por parámetro, en la base de datos
     *
     * @param iva Iva IVA a actualizar
     */
    public void update(Iva iva) {
        try {
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(UPDATE);
            query.setString(1, iva.getNombre());
            query.setFloat(2, iva.getCantidad());
            query.setInt(3, iva.getId());
            query.executeUpdate();
            GestionSql.closeConnection(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceIva.class.getName()).log(Level.SEVERE, null, 
                            ex);
        }
    }
    
    /**
     * Busca IVAs a partir de un texto que coincida total o parcialmente
     * con cualquier campo de la tabla iva
     *
     * @param texto String Texto a buscar
     * @return ArrayList Lista de IVAs encontrados
     */
    public List<Iva> buscar(String texto) {
        try {
            List<Iva> ivas = new ArrayList<>();
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(BUSCAR);
            texto = "%" + texto + "%";
            query.setString(1, texto);
            query.setString(2, texto);
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                ivas.add(bind(rs));
            }
            GestionSql.closeConnection(conn);
            return ivas;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceIva.class.getName()).log(Level.SEVERE, null, 
                            ex);
        }
        return null;
    }
    
    /**
     * Busca IVAs, a partir de un texto que coincida total o parcialmente
     * con cualquier campo de la tabla iva, que no se estén usando en 
     * otras tablas
     *
     * @param texto String Texto a buscar
     * @return ArrayList Lista de IVAs encontrados
     */
    public List<Iva> buscarEliminables(String texto) {
        try {
            List<Iva> ivas = new ArrayList<>();
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(BUSCAR_ELIMINABLES);
            texto = "%" + texto + "%";
            query.setString(1, texto);
            query.setString(2, texto);
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                ivas.add(bind(rs));
            }
            GestionSql.closeConnection(conn);
            return ivas;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceIva.class.getName()).log(Level.SEVERE, null, 
                            ex);
        }
        return null;
    }
    
    private Iva bind(ResultSet rs) {
        try {
            Iva iva = new Iva(rs.getInt("id"), 
                    rs.getString("nombre"), rs.getFloat("cantidad"));
            return iva;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceIva.class.getName()).log(Level.SEVERE, null,
                            ex);
        }
        return null;
    }
}
