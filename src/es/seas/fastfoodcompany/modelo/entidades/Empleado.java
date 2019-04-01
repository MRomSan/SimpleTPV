/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.modelo.entidades;

import java.sql.Date;

/**
 * Clase Empleado
 * 
 * @author Manuel Antonio Romero Sánchez
 */
public class Empleado {
    private int id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String dni;
    private String telefono1;
    private String telefono2;
    private String email;
    private String direccion;
    private String poblacion;
    private String provincia;
    private String codigo_postal;
    private Date fecha_nacimiento;
    private String sexo;
    private String cargo;
    private String username;
    private String password;
    private boolean administrador;
    
    /**
     * Constructor por defecto
     */
    public Empleado() {
        this.id = 0;
    }

    /**
     * Constructor parametrizado
     *
     * @param id int Id del empleado
     * @param nombre String Nombre del empleado
     * @param apellido1 String Apellido paterno
     * @param apellido2 STring Apellido materno
     * @param dni String DNI con letra
     * @param telefono1 String Teléfono principal
     * @param telefono2 String Teléfono secundario
     * @param email String Dirección e-mail
     * @param direccion String Dirección del empleado
     * @param poblacion String Población
     * @param provincia String Provincia
     * @param codigo_postal String Código postal
     * @param fecha_nacimiento Date Fecha de nacimiento
     * @param sexo String Sexo del empleado (H/M)
     * @param cargo String Cargo del empleado en la empresa
     * @param username STring Nombre de usuario en la aplicación FFC
     * @param password STring Contraseña de usuario
     * @param administrador int Permisos de administrador
     */
    public Empleado(int id, String nombre, String apellido1, String apellido2, 
            String dni, String telefono1, String telefono2, String email, 
            String direccion, String poblacion, String provincia, 
            String codigo_postal, Date fecha_nacimiento, String sexo, String cargo,
            String username, String password, boolean administrador) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dni = dni;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.email = email;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.provincia = provincia;
        this.codigo_postal = codigo_postal;
        this.fecha_nacimiento = fecha_nacimiento;
        this.sexo = sexo;
        this.cargo = cargo;
        this.username = username;
        this.password = password;
        this.administrador = administrador;
    }
    
    /**
     * Devuelve el id del empleado
     *
     * @return int Id del empleado
     */
    public int getId() {
        return id;
    }

    /**
     * Devuelve el nombre del empleado
     *
     * @return String Nombre del empleado
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el apellido paterno del empleado
     *
     * @return String Apellido paterno
     */
    public String getApellido1() {
        return apellido1;
    }

    /**
     * Devuelve el apellido materno del empleado
     *
     * @return String Apellido materno
     */
    public String getApellido2() {
        return apellido2;
    }
    
    /**
     * Establece el Id del empleado
     *
     * @param id int Id del empleado
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Establece el nombre del empleado
     *
     * @param nombre String Nombre del empleado
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece el apellido paterno del empleado
     *
     * @param apellido1 String Apellido paterno
     */
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    /**
     * Establece el apellido materno del empleado
     *
     * @param apellido2 String Apellido materno
     */
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }
    
    /**
     * Devuelve el DNI del empleado
     *
     * @return String DNI con letra
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece el DNI del empleado
     *
     * @param dni String DNI con letra
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Devuelve el teléfono principal del empleado
     *
     * @return String Teléfono principal
     */
    public String getTelefono1() {
        return telefono1;
    }

    /**
     * Establece el teléfono principal del empleado
     *
     * @param telefono1 String Teléfono principal
     */
    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    /**
     * Devuelve el teléfono secundario del empleado
     *
     * @return String Teléfono secundario
     */
    public String getTelefono2() {
        return telefono2;
    }

    /**
     * Establece el teléfono secundario del empleado
     *
     * @param telefono2 String Teléfono secundario
     */
    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    /**
     * Devuelve el e-mail del empleado
     *
     * @return String e-mail
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el e-mail del empleado
     *
     * @param email String e-mail
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Devuelve la dirección del empleado
     *
     * @return String Dirección
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del empleado
     *
     * @param direccion String Dirección
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Devuelve la población del empleado
     *
     * @return String Población
     */
    public String getPoblacion() {
        return poblacion;
    }

    /**
     * Establece la población del empleado
     *
     * @param poblacion String Población
     */
    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    /**
     * Devuelve la provincia del empleado
     *
     * @return String Provincia
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * Establece la provincia del empleado
     *
     * @param provincia String Provincia
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     * Devuelve el código postal del empleado
     *
     * @return String Código Postal
     */
    public String getCodigo_postal() {
        return codigo_postal;
    }

    /**
     * Establece el código postal del empleado
     *
     * @param codigo_postal String Código Postal
     */
    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    /**
     * Devuelve la fecha de nacimiento del empleado
     *
     * @return Date Fecha de Nacimiento
     */
    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    /**
     * Establece la fecha de nacimiento del empleado
     *
     * @param fecha_nacimiento Date Fecha de Nacimiento
     */
    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    /**
     * Devuelve el sexo del empleado
     *
     * @return String Sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * Establece el sexo del empleado
     *
     * @param sexo String Sexo
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * Devuelve el cargo del empleado en la empresa
     *
     * @return String Cargo del empleado
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * Establece el cargo del empleado en la empresa
     *
     * @param cargo String Cargo del empleado
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    /**
     * Devuelve el nombre de usuario en la aplicación FFC
     *
     * @return String Nombre de usuario en la aplicación FFC
     */
    public String getUsername() {
        return username;
    }

    /**
     * Establece el nombre de usuario en la aplicación FFC
     *
     * @param username String Usuario
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Devuelve la contraseña de usuario en la aplicación FFC
     *
     * @return String Contraseña de usuario
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contraseña de usuario en la aplicación FFC
     *
     * @param password String Contraseña
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * Indica si el usuario tiene permisos de administrador
     *
     * @return administrador boolean Permisos de administrador
     */
    public boolean isAdministrador() {
        return administrador;
    }
    
    /**
     * Establece si el usuario tiene permisos de administrador
     *
     * @param administrador boolean Permisos de administrador
     */
    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }
    
    /**
     * Escribe los datos del empleado
     *
     * @return String Id.- Apellido1 Apellido2, Nombre (Username/Password)
     */
    @Override
    public String toString() {
        return getId() + ".- " + getApellido1() + " " + getApellido2() + ", " 
                + getNombre() +
                " (" + getUsername() + "/" + getPassword() + ")";
    }
}
