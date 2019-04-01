/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.gestionbd;

import es.seas.fastfoodcompany.modelo.entidades.Cliente;
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
 * Clase que controla las consultas a la base de datos para la tabla "clientes"
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class ServiceCliente {
    
    //Instrucciones a base de datos
    private final String SELECT_ALL = "SELECT * FROM clientes";
    private final String SELECT_ONE = "SELECT * FROM clientes WHERE id = ?";
    private final String DELETE = "DELETE FROM clientes WHERE id = ?";
    private final String UPDATE = "UPDATE clientes SET nombre = ?, " +
                                  "apellido1 = ?, apellido2 = ?, dni = ?, " +
                                  "telefono1 = ?, telefono2 = ?, email = ?, " +
                                  "direccion = ?, poblacion = ?, provincia = ?, " +
                                  "codigo_postal = ?, fecha_nacimiento = ?, " +
                                  "sexo = ? WHERE id = ?";
    private final String INSERT = "INSERT INTO clientes (nombre, apellido1, " +
                                  "apellido2, dni, telefono1, telefono2, " +
                                  "email, direccion, poblacion, provincia, " +
                                  "codigo_postal, fecha_nacimiento, sexo) " + 
                                  "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                                  "?, ?)";
    private final String CLAUSULAS_BUSQUEDA = "nombre LIKE ? "
            + "OR apellido1 LIKE ? OR apellido2 LIKE ? "
            + "OR dni LIKE ? "
            + "OR telefono1 LIKE ? OR telefono2 LIKE ? OR email LIKE ? "
            + "OR direccion LIKE ? OR poblacion LIKE ? OR provincia LIKE ? "
            + "OR codigo_postal LIKE ? "
            + "OR fecha_nacimiento LIKE ? OR sexo LIKE ?";
    private final String BUSCAR = "SELECT * FROM clientes WHERE " + 
                                    CLAUSULAS_BUSQUEDA;
    
    // Consultas para evitar conflictos en la base de datos
    // Si encuentra un cliente que ya se esté usando en otra tabla de la 
    // base de datos, ésta no se cargará en la pantalla de eliminación
    private final String SELECT_ELIMINABLES = "SELECT * FROM clientes " +
                            "WHERE id NOT IN " +
                            "(SELECT DISTINCT id_cliente FROM ventas)";
    private final String BUSCAR_ELIMINABLES = SELECT_ELIMINABLES + " AND (" + 
                                                CLAUSULAS_BUSQUEDA + ")";
    
    /**
     * Devuelve una lista de clientes con todos los clientes de la base de
     * datos
     *
     * @return ArrayList Listado de clientes
     */
    public List<Cliente> findAll() {
        try {
            List<Cliente> clientes = new ArrayList<>();
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(SELECT_ALL);
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                clientes.add(bind(rs));
            }
            GestionSql.closeConnection(conn);
            return clientes;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCliente.class.getName()).log(Level.SEVERE, null,
                            ex);
        }
        return null;
    }
    
    /**
     * Devuelve un cliente a partir de su Id
     *
     * @param id int Id del cliente
     * @return Cliente Cliente encontrado
     */
    public Cliente findById(int id) {
        Cliente cliente = null;
        try {
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(SELECT_ONE);
            query.setInt(1, id);
            ResultSet rs = query.executeQuery();
            while(rs.next()) {
                cliente = bind(rs);
            }
            GestionSql.closeConnection(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCliente.class.getName()).log(Level.SEVERE, null,
                            ex);
        }
        return cliente;
    }
    
    /**
     * Devuelve una lista de clientes con todos los clientes de la base de
     * datos que no se estén usando en otras tablas
     *
     * @return ArrayList Listado de clientes
     */
    public List<Cliente> findEliminables() {
        try {
            List<Cliente> cliente = new ArrayList<>();
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(SELECT_ELIMINABLES);
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                cliente.add(bind(rs));
            }
            GestionSql.closeConnection(conn);
            return cliente;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCliente.class.getName()).log(Level.SEVERE, null, 
                            ex);
        }
        return null;
    }
    
    /**
     * Inserta un cliente, pasado por parámetro, en la base de datos
     *
     * @param cliente Cliente Cliente a insertar
     */
    public void insert(Cliente cliente) {
        try {
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(INSERT, 
                                    Statement.RETURN_GENERATED_KEYS);
            query.setString(1, cliente.getNombre());
            query.setString(2, cliente.getApellido1());
            query.setString(3, cliente.getApellido2());
            query.setString(4, cliente.getDni());
            query.setString(5, cliente.getTelefono1());
            query.setString(6, cliente.getTelefono2());
            query.setString(7, cliente.getEmail());
            query.setString(8, cliente.getDireccion());
            query.setString(9, cliente.getPoblacion());
            query.setString(10, cliente.getProvincia());
            query.setString(11, cliente.getCodigo_postal());
            query.setDate(12, cliente.getFecha_nacimiento());
            query.setString(13, cliente.getSexo());
            query.execute();
            ResultSet rs = query.getGeneratedKeys();
            while (rs.next()) {
                cliente.setId(rs.getInt(1));
            }
            GestionSql.closeConnection(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCliente.class.getName()).log(Level.SEVERE, null,
                            ex);
        }
    }
    
    /**
     * Borra un cliente de la base de datos a partir de su Id
     *
     * @param id int Id del cliente
     */
    public void delete(int id) {
        try {
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(DELETE);
            query.setInt(1, id);
            query.executeUpdate();
            GestionSql.closeConnection(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCliente.class.getName()).log(Level.SEVERE, null, 
                            ex);
        }
    }
    
    /**
     * Actualiza un cliente, pasado por parámetro, en la base de datos
     *
     * @param cliente Cliente Cliente a actualizar
     */
    public void update(Cliente cliente) {
        try {
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(UPDATE);
            query.setString(1, cliente.getNombre());
            query.setString(2, cliente.getApellido1());
            query.setString(3, cliente.getApellido2());
            query.setString(4, cliente.getDni());
            query.setString(5, cliente.getTelefono1());
            query.setString(6, cliente.getTelefono2());
            query.setString(7, cliente.getEmail());
            query.setString(8, cliente.getDireccion());
            query.setString(9, cliente.getPoblacion());
            query.setString(10, cliente.getProvincia());
            query.setString(11, cliente.getCodigo_postal());
            query.setDate(12, cliente.getFecha_nacimiento());
            query.setString(13, cliente.getSexo());
            query.setInt(14, cliente.getId());
            query.executeUpdate();
            GestionSql.closeConnection(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCliente.class.getName()).log(Level.SEVERE, null, 
                            ex);
        }
    }
    
    /**
     * Busca clientes a partir de un texto que coincida total o parcialmente
     * con cualquier campo de la tabla clientes
     *
     * @param texto String Texto a buscar
     * @return ArrayList Lista de clientes encontrados
     */
    public List<Cliente> buscar(String texto) {
        try {
            List<Cliente> clientes = new ArrayList<>();
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(BUSCAR);
            texto = "%" + texto + "%";
            query.setString(1, texto);
            query.setString(2, texto);
            query.setString(3, texto);
            query.setString(4, texto);
            query.setString(5, texto);
            query.setString(6, texto);
            query.setString(7, texto);
            query.setString(8, texto);
            query.setString(9, texto);
            query.setString(10, texto);
            query.setString(11, texto);
            query.setString(12, texto);
            query.setString(13, texto);
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                clientes.add(bind(rs));
            }
            GestionSql.closeConnection(conn);
            return clientes;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCliente.class.getName()).log(Level.SEVERE, null, 
                            ex);
        }
        return null;
    }
    
    /**
     * Busca clientes, a partir de un texto que coincida total o parcialmente
     * con cualquier campo de la tabla clientes, que no se estén usando en 
     * otras tablas
     *
     * @param texto String Texto a buscar
     * @return ArrayList Lista de clientes encontrados
     */
    public List<Cliente> buscarEliminables(String texto) {
        try {
            List<Cliente> clientes = new ArrayList<>();
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(BUSCAR_ELIMINABLES);
            texto = "%" + texto + "%";
            query.setString(1, texto);
            query.setString(2, texto);
            query.setString(3, texto);
            query.setString(4, texto);
            query.setString(5, texto);
            query.setString(6, texto);
            query.setString(7, texto);
            query.setString(8, texto);
            query.setString(9, texto);
            query.setString(10, texto);
            query.setString(11, texto);
            query.setString(12, texto);
            query.setString(13, texto);
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                clientes.add(bind(rs));
            }
            GestionSql.closeConnection(conn);
            return clientes;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCliente.class.getName()).log(Level.SEVERE, null, 
                            ex);
        }
        return null;
    }
    
    private Cliente bind(ResultSet rs) {
        try {
            Cliente cliente = new Cliente(rs.getInt("id"), 
                    rs.getString("nombre"), rs.getString("apellido1"), 
                    rs.getString("apellido2"), rs.getString("dni"),
                    rs.getString("telefono1"), rs.getString("telefono2"),
                    rs.getString("email"), rs.getString("direccion"),
                    rs.getString("poblacion"), rs.getString("provincia"),
                    rs.getString("codigo_postal"),
                    rs.getDate("fecha_nacimiento"), rs.getString("sexo"));
            return cliente;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCliente.class.getName()).log(Level.SEVERE, null,
                            ex);
        }
        return null;
    }
}
