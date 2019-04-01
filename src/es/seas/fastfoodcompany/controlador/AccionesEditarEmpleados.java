/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.controlador;

import es.seas.fastfoodcompany.modelo.entidades.Empleado;
import es.seas.fastfoodcompany.gestionbd.ServiceEmpleado;
import es.seas.fastfoodcompany.vistas.PanelEditarEmpleados;
import es.seas.fastfoodcompany.config.ModeloTabla;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Clase que controla las acciones de edición de empleados
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class AccionesEditarEmpleados {
    private PanelEditarEmpleados panel;
    private ModeloTabla tabla;

    /**
     * Constructor predeterminado
     *
     * @param panel PanelEditarEmpleados al que pertenecen las acciones
     */
    public AccionesEditarEmpleados(PanelEditarEmpleados panel) {
        this.panel = panel;
    }
    
    /**
     * Método que inicializa y carga los valores en la tabla.
     */
    public void InicializaTabla() {
        //Modelo
        tabla = new ModeloTabla(new String[]{
            "ID", "Apellido1", "Apellido2", "Nombre", "DNI", "Usuario", 
            "Contraseña", "Administrador"}, 0);
        PintaTabla();
        //Datos
        CargaDatosTabla();
    }

    /**
     * Método que carga los valores en la tabla
     */
    public void CargaDatosTabla() {
        ServiceEmpleado empleadoDAO = new ServiceEmpleado();
        List<Empleado> empleados = new ArrayList<Empleado>();
        
        empleados = empleadoDAO.findAll();
        for (Iterator<Empleado> iterator = empleados.iterator(); iterator.hasNext();) {
            Empleado empleadoActual = iterator.next();
            Vector filaTabla = new Vector();
            filaTabla.add(empleadoActual.getId());
            filaTabla.add(empleadoActual.getApellido1());
            filaTabla.add(empleadoActual.getApellido2());
            filaTabla.add(empleadoActual.getNombre());
            filaTabla.add(empleadoActual.getDni());
            filaTabla.add(empleadoActual.getUsername());
            filaTabla.add(empleadoActual.getPassword());
            filaTabla.add((empleadoActual.isAdministrador())?"Sí":"No");
            tabla.addRow(filaTabla);
        }
        PintaTabla();
    }
    
    /**
     * Método que carga, en el panel de datos de empleado, el empleado 
     * seleccionado en la tabla
     */
    public void CargaEmpleadoSeleccionado () {
        int filaSeleccionada = panel.getTablaEmpleados().getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "No hay registros seleccionados");
        } else {
            Empleado empleado = new Empleado();
            ServiceEmpleado empleadoDAO = new ServiceEmpleado();
            empleado = empleadoDAO.findById((int) panel.getTablaEmpleados().
                        getValueAt(filaSeleccionada, 0));
            
            habilitaCampos(true);
            panel.getLblID().setText(Integer.toString(empleado.getId()));
            panel.getTxtNombre().setText(empleado.getNombre());
            panel.getTxtApellido1().setText(empleado.getApellido1());
            panel.getTxtApellido2().setText(empleado.getApellido2());
            panel.getTxtDNI().setText(empleado.getDni().substring(0, 
                    empleado.getDni().length() - 1));
            panel.getTxtDNILetra().setText(empleado.getDni().substring(
                    empleado.getDni().length() - 1));
            panel.getCmbSexo().setSelectedIndex(empleado.getSexo().equals("H")?0:1);
            panel.getTxtTlfn1().setText(empleado.getTelefono1());
            panel.getTxtTlfn2().setText(empleado.getTelefono2());
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date utilDate = new java.util.Date(empleado.getFecha_nacimiento().getTime());
            panel.getTxtFechaNacimiento().setText(sdf.format(utilDate));
            panel.getTxtEmail().setText(empleado.getEmail());
            panel.getTxtDireccion().setText(empleado.getDireccion());
            panel.getTxtPoblacion().setText(empleado.getPoblacion());
            panel.getTxtProvincia().setText(empleado.getProvincia());
            panel.getTxtCodigoPostal().setText(empleado.getCodigo_postal());
            panel.getTxtCargo().setText(empleado.getCargo());
            panel.getTxtUsername().setText(empleado.getUsername());
            panel.getTxtPassword().setText(empleado.getPassword());
            panel.getChkAdministrador().setSelected(empleado.isAdministrador());
        }
    }
    
    /**
     * Método que actualiza el empleado en la base de datos y por pantalla
     */
    public void ActualizaEmpleado () {
        if (panel.getLblID().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay registro cargado");
        } else {
            if (ValidaCampos()) {
                try {
                    ServiceEmpleado empleadoDAO = new ServiceEmpleado();
                    Empleado empleado = new Empleado();
                    
                    empleado.setId(Integer.parseInt(panel.getLblID().getText()));
                    empleado.setNombre(panel.getTxtNombre().getText());
                    empleado.setApellido1(panel.getTxtApellido1().getText());
                    empleado.setApellido2(panel.getTxtApellido2().getText());
                    empleado.setDni(panel.getTxtDNI().getText() +
                            panel.getTxtDNILetra().getText());
                    empleado.setSexo(panel.getCmbSexo().getSelectedIndex()==0?"H":"M");
                    empleado.setTelefono1(panel.getTxtTlfn1().getText().replace(" ", ""));
                    empleado.setTelefono2(panel.getTxtTlfn2().getText().replace(" ", ""));
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    java.util.Date utilDate = new java.util.Date();
                    utilDate = sdf.parse(panel.getTxtFechaNacimiento().getText());
                    empleado.setFecha_nacimiento(new Date(utilDate.getTime()));
                    empleado.setEmail(panel.getTxtEmail().getText());
                    empleado.setDireccion(panel.getTxtDireccion().getText());
                    empleado.setPoblacion(panel.getTxtPoblacion().getText());
                    empleado.setProvincia(panel.getTxtProvincia().getText());
                    empleado.setCodigo_postal(panel.getTxtCodigoPostal().getText());
                    empleado.setCargo(panel.getTxtCargo().getText());
                    empleado.setUsername(panel.getTxtUsername().getText());
                    empleado.setPassword(panel.getTxtPassword().getText());
                    empleado.setAdministrador(panel.getChkAdministrador().isSelected());
                    
                    empleadoDAO.update(empleado);
                    
                    panel.getLblID().setText("");
                    panel.getTxtNombre().setText("");
                    panel.getTxtApellido1().setText("");
                    panel.getTxtApellido2().setText("");
                    panel.getTxtDNI().setText("");
                    panel.getTxtDNI().setValue(null);
                    panel.getTxtDNILetra().setText("");
                    panel.getTxtDNILetra().setValue(null);
                    panel.getCmbSexo().setSelectedIndex(0);
                    panel.getTxtTlfn1().setText("");
                    panel.getTxtTlfn1().setValue(null);
                    panel.getTxtTlfn2().setText("");
                    panel.getTxtTlfn2().setValue(null);
                    panel.getTxtFechaNacimiento().setText("");
                    panel.getTxtFechaNacimiento().setValue(null);
                    panel.getTxtEmail().setText("");
                    panel.getTxtDireccion().setText("");
                    panel.getTxtPoblacion().setText("");
                    panel.getTxtProvincia().setText("");
                    panel.getTxtCodigoPostal().setText("");
                    panel.getTxtCodigoPostal().setValue(null);
                    panel.getTxtCargo().setText("");
                    panel.getTxtUsername().setText("");
                    panel.getTxtPassword().setText("");
                    panel.getChkAdministrador().setSelected(false);
                    JOptionPane.showMessageDialog(null, "Empleado actualizado: " 
                            + empleado.toString());
                    tabla.setNumRows(0);
                    BuscarEmpleados(panel.getTxtBuscar().getText());
                    habilitaCampos(false);
                } catch (ParseException ex) {
                    Logger.getLogger(AccionesEditarEmpleados.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    /**
     * Método que busca los empleados cuyos campos coincidan total o parcialmente
     * con el texto introducido
     *
     * @param texto String
     */
    public void BuscarEmpleados(String texto) {
        ServiceEmpleado empleadoDAO = new ServiceEmpleado();
        List<Empleado> empleados = new ArrayList<Empleado>();
        
        empleados = empleadoDAO.buscar(texto);
        tabla.setNumRows(0);
        for (Iterator<Empleado> iterator = empleados.iterator(); iterator.hasNext();) {
            Empleado empleadoActual = iterator.next();
            Vector filaTabla = new Vector();
            filaTabla.add(empleadoActual.getId());
            filaTabla.add(empleadoActual.getApellido1());
            filaTabla.add(empleadoActual.getApellido2());
            filaTabla.add(empleadoActual.getNombre());
            filaTabla.add(empleadoActual.getDni());
            filaTabla.add(empleadoActual.getUsername());
            filaTabla.add(empleadoActual.getPassword());
            filaTabla.add((empleadoActual.isAdministrador())?"Sí":"No");
            tabla.addRow(filaTabla);
        }
        PintaTabla();
    }
    
    //Validación de campos
    private boolean ValidaCampos() {
        try {
            String dniIntroducido = panel.getTxtDNI().getText() + 
                    panel.getTxtDNILetra().getText();
            
            Exception excNombreVacio = new Exception("Campo Nombre vacío");
            Exception excApellido1Vacio = new Exception("Campo Primer apellido"
                    + " vacío");
            Exception excApellido2Vacio = new Exception("Campo Segundo apellido"
                    + " vacío");
            Exception excDNIVacio = new Exception("Campo DNI vacío");
            Exception excFNacimientoVacio = new Exception("Campo Fecha de "
                    + "Nacimiento vacío");
            Exception excDireccionVacio = new Exception("Campo Dirección vacío");
            Exception excPoblacionVacio = new Exception("Campo Población vacío");
            Exception excProvinciaVacio = new Exception("Campo Provincia vacío");
            Exception excCodPostalVacio = new Exception("Campo Código Postal "
                    + "vacío");
            Exception excUsernameVacio = new Exception("Campo Usuario vacío");
            Exception excPasswordVacio = new Exception("Campo Contraseña vacío");
            Exception excDNIIncorrecto = new Exception("DNI incorrecto");

            //Validación de campos
            if (panel.getTxtNombre().getText().trim().isEmpty()) 
                throw excNombreVacio;
            if (panel.getTxtApellido1().getText().trim().isEmpty()) 
                throw excApellido1Vacio;
            if (panel.getTxtApellido2().getText().trim().isEmpty()) 
                throw excApellido2Vacio;
            if (panel.getTxtDNI().getText().trim().isEmpty() || 
                    panel.getTxtDNILetra().getText().trim().isEmpty()) 
                throw excDNIVacio;
            if (validaLetraDNI(dniIntroducido) == false)
                throw excDNIIncorrecto;
            if (panel.getTxtFechaNacimiento().getText().trim().isEmpty()) 
                throw excFNacimientoVacio;
            if (panel.getTxtDireccion().getText().trim().isEmpty()) 
                throw excDireccionVacio;
            if (panel.getTxtPoblacion().getText().trim().isEmpty()) 
                throw excPoblacionVacio;
            if (panel.getTxtProvincia().getText().trim().isEmpty()) 
                throw excProvinciaVacio;
            if (panel.getTxtCodigoPostal().getText().trim().isEmpty()) 
                throw excCodPostalVacio;
            if (panel.getTxtUsername().getText().trim().isEmpty()) 
                throw excUsernameVacio;
            if (panel.getTxtPassword().getText().trim().isEmpty()) 
                throw excPasswordVacio;
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Dato incorrecto", 0);
        }
        return false;
    }
    
    //Función que valida si el DNI es válido
    private boolean validaLetraDNI(String dniIntroducido) {
        int DNI = Integer.parseInt(dniIntroducido.substring(0, 8));
        String letraIntroducida = dniIntroducido.substring(8);
        int resto = 0;
        String letraCorrecta = "";
        String[] asignacionLetra = {"T", "R", "W", "A", "G", "M", "Y", "F", "P",
                        "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", 
                        "C", "K" , "E"};
        resto = DNI % 23;
        letraCorrecta = asignacionLetra[resto];
        
        if (letraIntroducida.equals(letraCorrecta)) {
            return true;
        }
        return false;
    }
    
    //Pinta de nuevo la tabla
    private void PintaTabla() {
        panel.getTablaEmpleados().setModel(tabla);
        panel.getTablaEmpleados().getColumnModel().getColumn(0).setPreferredWidth(0);
        panel.getTablaEmpleados().getColumnModel().getColumn(0).setMaxWidth(0);
        panel.getTablaEmpleados().getColumnModel().getColumn(0).setMinWidth(0);
        panel.getPanelTabla().setViewportView(panel.getTablaEmpleados());
    }
    
    /**
     * Habilita o deshabilita los componentes del panel "panelDatos"
     *
     * @param habilitar boolean True/False
     */
    public void habilitaCampos(boolean habilitar) {
        for (int i = 0; i < panel.getPanelDatos().getComponents().length; i++) {
            panel.getPanelDatos().getComponent(i).setEnabled(habilitar);
        }
    }
}
