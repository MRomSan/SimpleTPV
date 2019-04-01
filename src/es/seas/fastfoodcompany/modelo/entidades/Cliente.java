/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.modelo.entidades;

import java.sql.Date;

/**
 * Clase Cliente
 * 
 * @author Manuel Antonio Romero Sánchez
 */
public class Cliente {
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
    
    /**
     * Constructor por defecto
     */
    public Cliente() {
        this.id = 0;
    }

    /**
     * Constructor parametrizado
     *
     * @param id int Id del cliente
     * @param nombre String Nombre del cliente
     * @param apellido1 String Apellido paterno
     * @param apellido2 String Apellido materno
     * @param dni String DNI con letra
     * @param telefono1 String Teléfono principal
     * @param telefono2 String Teléfono secundario
     * @param email String Dirección e-mail
     * @param direccion String Dirección del cliente
     * @param poblacion String Población
     * @param provincia String Provincia
     * @param codigo_postal String Código postal
     * @param fecha_nacimiento Date Fecha de nacimiento
     * @param sexo String Sexo del cliente (H/M)
     */
    public Cliente(int id, String nombre, String apellido1, String apellido2, 
            String dni, String telefono1, String telefono2, String email, 
            String direccion, String poblacion, String provincia, 
            String codigo_postal, Date fecha_nacimiento, String sexo) {
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
    }
    
    /**
     * Devuelve el id del cliente
     *
     * @return int Id del cliente
     */
    public int getId() {
        return id;
    }

    /**
     * Devuelve el nombre del cliente
     *
     * @return String Nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el apellido paterno del cliente
     *
     * @return String Apellido paterno
     */
    public String getApellido1() {
        return apellido1;
    }

    /**
     * Devuelve el apellido materno del cliente
     *
     * @return String Apellido materno
     */
    public String getApellido2() {
        return apellido2;
    }
    
    /**
     * Establece el Id del cliente
     *
     * @param id int Id del cliente
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Establece el nombre del cliente
     *
     * @param nombre String Nombre del cliente
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece el apellido paterno del cliente
     *
     * @param apellido1 String Apellido paterno
     */
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    /**
     * Establece el apellido materno del cliente
     *
     * @param apellido2 String Apellido materno
     */
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    /**
     * Devuelve el DNI del cliente
     *
     * @return String DNI con letra
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece el DNI del cliente
     *
     * @param dni String DNI con letra
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Devuelve el teléfono principal del cliente
     *
     * @return String Teléfono principal
     */
    public String getTelefono1() {
        return telefono1;
    }

    /**
     * Establece el teléfono principal del cliente
     *
     * @param telefono1 String Teléfono principal
     */
    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    /**
     * Devuelve el teléfono secundario del cliente
     *
     * @return String Teléfono secundario
     */
    public String getTelefono2() {
        return telefono2;
    }

    /**
     * Establece el teléfono secundario del cliente
     *
     * @param telefono2 String Teléfono secundario
     */
    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    /**
     * Devuelve el e-mail del cliente
     *
     * @return String e-mail
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el e-mail del cliente
     *
     * @param email String e-mail
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Devuelve la dirección del cliente
     *
     * @return String Dirección
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del cliente
     *
     * @param direccion String Dirección
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Devuelve la población del cliente
     *
     * @return String Población
     */
    public String getPoblacion() {
        return poblacion;
    }

    /**
     * Establece la población del cliente
     *
     * @param poblacion String Población
     */
    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    /**
     * Devuelve la provincia del cliente
     *
     * @return String Provincia
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * Establece la provincia del cliente
     *
     * @param provincia String Provincia
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     * Devuelve el código postal del cliente
     *
     * @return String Código Postal
     */
    public String getCodigo_postal() {
        return codigo_postal;
    }

    /**
     * Establece el código postal del cliente
     *
     * @param codigo_postal String Código Postal
     */
    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    /**
     * Devuelve la fecha de nacimiento del cliente
     *
     * @return Date Fecha de Nacimiento
     */
    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    /**
     * Establece la fecha de nacimiento del cliente
     *
     * @param fecha_nacimiento Date Fecha de Nacimiento
     */
    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    /**
     * Devuelve el sexo del cliente
     *
     * @return String Sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * Establece el sexo del cliente
     *
     * @param sexo String Sexo
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * Escribe los datos del cliente
     *
     * @return String Id.- Apellido1 Apellido2, Nombre (DNI)
     */
    @Override
    public String toString() {
        return getId() + ".- " + getApellido1() + " " + getApellido2() + ", " 
                + getNombre() + " (" + getDni() + ")";
    }
}
