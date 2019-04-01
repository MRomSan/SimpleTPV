/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.gestionbd;

import es.seas.fastfoodcompany.modelo.entidades.Empleado;
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
 * Clase que controla las consultas a la base de datos para la tabla "empleados"
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class ServiceEmpleado {
    
    //Instrucciones a base de datos
    private final String SELECT_ALL = "SELECT * FROM empleados";
    private final String SELECT_ONE = "SELECT * FROM empleados WHERE id = ?";
    private final String DELETE = "DELETE FROM empleados WHERE id = ?";
    private final String UPDATE = "UPDATE empleados SET nombre = ?, " +
                                  "apellido1 = ?, apellido2 = ?, dni = ?, " +
                                  "telefono1 = ?, telefono2 = ?, email = ?, " +
                                  "direccion = ?, poblacion = ?, provincia = ?, " +
                                  "codigo_postal = ?, fecha_nacimiento = ?, " +
                                  "sexo = ?, cargo = ?, username = ?, " +
                                  "password = ?, administrador = ? WHERE id = ?";
    private final String INSERT = "INSERT INTO empleados (nombre, apellido1, " +
                                  "apellido2, dni, telefono1, telefono2, " +
                                  "email, direccion, poblacion, provincia, " +
                                  "codigo_postal, fecha_nacimiento, sexo, " +
                                  "cargo, username, password, administrador) " +
                                  "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                                  "?, ?, ?, ?, ?, ?)";
    private final String CLAUSULAS_BUSQUEDA = "nombre LIKE ? "
            + "OR apellido1 LIKE ? OR apellido2 LIKE ? "
            + "OR dni LIKE ? "
            + "OR telefono1 LIKE ? OR telefono2 LIKE ? OR email LIKE ? "
            + "OR direccion LIKE ? OR poblacion LIKE ? OR provincia LIKE ? "
            + "OR codigo_postal LIKE ? "
            + "OR fecha_nacimiento LIKE ? OR sexo LIKE ? "
            + "OR cargo LIKE ? OR username LIKE ?";
    private final String BUSCAR = "SELECT * FROM empleados WHERE " + 
                                    CLAUSULAS_BUSQUEDA;
    
    //Consultas para el login
    private final String BUSCAR_USUARIO = "SELECT * FROM empleados " + 
            "WHERE username LIKE ?";
    private final String BUSCAR_ADMIN = "SELECT * FROM empleados " + 
            "WHERE administrador = ?";
    private final String HACER_LOGIN = "SELECT * FROM empleados " + 
            "WHERE username LIKE ? AND password LIKE ?";
    
    // Consultas para evitar conflictos en la base de datos
    // Si encuentra un empleado que ya se esté usando en otra tabla de la 
    // base de datos, éste no se cargará en la pantalla de eliminación
    private final String SELECT_ELIMINABLES = "SELECT * FROM empleados " +
                            "WHERE id NOT IN " +
                            "(SELECT DISTINCT id_empleado FROM ventas)";
    private final String BUSCAR_ELIMINABLES = SELECT_ELIMINABLES + " AND (" + 
                                                CLAUSULAS_BUSQUEDA + ")";
    
    /**
     * Devuelve una lista de empleados con todos los empleados de la base de
     * datos
     *
     * @return ArrayList Listado de empleados
     */
    public List<Empleado> findAll() {
        try {
            List<Empleado> empleados = new ArrayList<>();
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(SELECT_ALL);
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                empleados.add(bind(rs));
            }
            GestionSql.closeConnection(conn);
            return empleados;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEmpleado.class.getName()).log(Level.SEVERE, null,
                            ex);
        }
        return null;
    }
    
    /**
     * Devuelve un empleado a partir de su Id
     *
     * @param id int Id del empleado
     * @return Empleado Empleado encontrado
     */
    public Empleado findById(int id) {
        Empleado empleado = null;
        try {
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(SELECT_ONE);
            query.setInt(1, id);
            ResultSet rs = query.executeQuery();
            while(rs.next()) {
                empleado = bind(rs);
            }
            GestionSql.closeConnection(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEmpleado.class.getName()).log(Level.SEVERE, null,
                            ex);
        }
        return empleado;
    }
    
    /**
     * Devuelve una lista de empleados con todos los empleados de la base de
     * datos que no se estén usando en otras tablas
     *
     * @return ArrayList Listado de empleados
     */
    public List<Empleado> findEliminables() {
        try {
            List<Empleado> empleados = new ArrayList<>();
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(SELECT_ELIMINABLES);
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                empleados.add(bind(rs));
            }
            GestionSql.closeConnection(conn);
            return empleados;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEmpleado.class.getName()).log(Level.SEVERE, null,
                            ex);
        }
        return null;
    }
    
    /**
     * Inserta un empleado, pasado por parámetro, en la base de datos
     *
     * @param empleado Empleado Empleado a insertar
     */
    public void insert(Empleado empleado) {
        try {
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(INSERT, 
                                    Statement.RETURN_GENERATED_KEYS);
            query.setString(1, empleado.getNombre());
            query.setString(2, empleado.getApellido1());
            query.setString(3, empleado.getApellido2());
            query.setString(4, empleado.getDni());
            query.setString(5, empleado.getTelefono1());
            query.setString(6, empleado.getTelefono2());
            query.setString(7, empleado.getEmail());
            query.setString(8, empleado.getDireccion());
            query.setString(9, empleado.getPoblacion());
            query.setString(10, empleado.getProvincia());
            query.setString(11, empleado.getCodigo_postal());
            query.setDate(12, empleado.getFecha_nacimiento());
            query.setString(13, empleado.getSexo());
            query.setString(14, empleado.getCargo());
            query.setString(15, empleado.getUsername());
            query.setString(16, empleado.getPassword());
            query.setBoolean(17, empleado.isAdministrador());
            query.execute();
            ResultSet rs = query.getGeneratedKeys();
            while (rs.next()) {
                empleado.setId(rs.getInt(1));
            }
            GestionSql.closeConnection(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEmpleado.class.getName()).log(Level.SEVERE, null,
                            ex);
        }
    }
    
    /**
     * Borra un empleado de la base de datos a partir de su Id
     *
     * @param id int Id del empleado
     */
    public void delete(int id) {
        try {
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(DELETE);
            query.setInt(1, id);
            query.executeUpdate();
            GestionSql.closeConnection(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEmpleado.class.getName()).log(Level.SEVERE, null, 
                            ex);
        }
    }
    
    /**
     * Actualiza un empleado, pasado por parámetro, en la base de datos
     *
     * @param empleado Empleado Empleado a actualizar
     */
    public void update(Empleado empleado) {
        try {
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(UPDATE);
            query.setString(1, empleado.getNombre());
            query.setString(2, empleado.getApellido1());
            query.setString(3, empleado.getApellido2());
            query.setString(4, empleado.getDni());
            query.setString(5, empleado.getTelefono1());
            query.setString(6, empleado.getTelefono2());
            query.setString(7, empleado.getEmail());
            query.setString(8, empleado.getDireccion());
            query.setString(9, empleado.getPoblacion());
            query.setString(10, empleado.getProvincia());
            query.setString(11, empleado.getCodigo_postal());
            query.setDate(12, empleado.getFecha_nacimiento());
            query.setString(13, empleado.getSexo());
            query.setString(14, empleado.getCargo());
            query.setString(15, empleado.getUsername());
            query.setString(16, empleado.getPassword());
            query.setBoolean(17, empleado.isAdministrador());
            query.setInt(18, empleado.getId());
            query.executeUpdate();
            GestionSql.closeConnection(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEmpleado.class.getName()).log(Level.SEVERE, null, 
                            ex);
        }
    }
    
    /**
     * Busca empleados a partir de un texto que coincida total o parcialmente 
     * con cualquier campo de la tabla empleados
     * No busca en el campo contraseña
     *
     * @param texto String Texto a buscar
     * @return ArrayList Lista de empleados encontrados
     */
    public List<Empleado> buscar(String texto) {
        try {
            List<Empleado> empleados = new ArrayList<>();
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
            query.setString(14, texto);
            query.setString(15, texto);
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                empleados.add(bind(rs));
            }
            GestionSql.closeConnection(conn);
            return empleados;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEmpleado.class.getName()).log(Level.SEVERE, null, 
                            ex);
        }
        return null;
    }
    
    /**
     * Busca empleados, a partir de un texto que coincida total o parcialmente 
     * con cualquier campo de la tabla empleados, que no se estén usando en 
     * otras tablas
     * No busca en el campo contraseña
     *
     * @param texto String Texto a buscar
     * @return ArrayList Lista de empleados encontrados
     */
    public List<Empleado> buscarEliminables(String texto) {
        try {
            List<Empleado> empleados = new ArrayList<>();
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
            query.setString(14, texto);
            query.setString(15, texto);
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                empleados.add(bind(rs));
            }
            GestionSql.closeConnection(conn);
            return empleados;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEmpleado.class.getName()).log(Level.SEVERE, null, 
                            ex);
        }
        return null;
    }
    
    /**
     * Determina si existe el usuario introducido en la pantalla Login en la 
     * base de datos (tabla empleados)
     *
     * @param usuario String Username introducido
     * @return boolean True si existe el usuario en la base de datos
     */
    public boolean existeUsuario(String usuario) {
        boolean hayUsuario = false;
        try {
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(BUSCAR_USUARIO);
            query.setString(1, usuario);
            ResultSet rs = query.executeQuery();
            if (rs.next()) hayUsuario = true;
            GestionSql.closeConnection(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEmpleado.class.getName()).log(Level.SEVERE, null,
                            ex);
        }
        return hayUsuario;
    }
    
    /**
     * Busca el usuario (empleado) introducido en la base de datos.
     * Si encuentra alguna coincidencia en ambos campos username y password
     * devuelve el usuario (empleado) encontrado
     *
     * @param usuario String Username introducido
     * @param password String Password introducido
     * @return Empleado El empleado encontrado. Null si no encontró nada
     */
    public Empleado login(String usuario, String password) {
        Empleado usuarioLogin = null;
        try {
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(HACER_LOGIN);
            query.setString(1, usuario);
            query.setString(2, password);
            ResultSet rs = query.executeQuery();
            if (rs.next()) usuarioLogin = bind(rs);
            GestionSql.closeConnection(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEmpleado.class.getName()).log(Level.SEVERE, null,
                            ex);
        }
        return usuarioLogin;
    }
    
    /**
     * Determina si hay algún administrador en la base de datos 
     * (tabla empleados con el campo Administrador en true)
     *
     * @return boolean True si encontró algún Administrador
     */
    public boolean existeAdministrador() {
        boolean hayAdministrador = false;
        try {
            Connection conn = GestionSql.openConnection();
            PreparedStatement query = conn.prepareStatement(BUSCAR_ADMIN);
            query.setBoolean(1, true);
            ResultSet rs = query.executeQuery();
            if (rs.next()) hayAdministrador = true;
            GestionSql.closeConnection(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEmpleado.class.getName()).log(Level.SEVERE, null,
                            ex);
        }
        return hayAdministrador;
    }
    
    private Empleado bind(ResultSet rs) {
        try {
            Empleado empleado = new Empleado(rs.getInt("id"), 
                    rs.getString("nombre"), rs.getString("apellido1"), 
                    rs.getString("apellido2"), rs.getString("dni"),
                    rs.getString("telefono1"), rs.getString("telefono2"),
                    rs.getString("email"), rs.getString("direccion"),
                    rs.getString("poblacion"), rs.getString("provincia"),
                    rs.getString("codigo_postal"),
                    rs.getDate("fecha_nacimiento"), rs.getString("sexo"), 
                    rs.getString("cargo"), rs.getString("username"),
                    rs.getString("password"), rs.getBoolean("administrador"));
            return empleado;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEmpleado.class.getName()).log(Level.SEVERE, null,
                            ex);
        }
        return null;
    }
}
