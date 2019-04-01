/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.controlador;

import es.seas.fastfoodcompany.modelo.entidades.Empleado;
import es.seas.fastfoodcompany.gestionbd.ServiceEmpleado;
import es.seas.fastfoodcompany.vistas.PanelAltaEmpleados;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Clase que controla las acciones de altas de empleados
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class AccionesAltaEmpleados {
    private final PanelAltaEmpleados panel;

    /**
     * Constructor predeterminado
     *
     * @param panel Panel al que están enlazadas las acciones de empleados
     */
    public AccionesAltaEmpleados(PanelAltaEmpleados panel) {
        this.panel = panel;
    }
    
    /**
     * Procedimiento para guardar un empleado en la base de datos
     */
    public void Guardar() {
        if (ValidaCampos()) {
            try {
                ServiceEmpleado empleadoDAO = new ServiceEmpleado();
                Empleado empleado = new Empleado();
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
                empleadoDAO.insert(empleado);
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
                JOptionPane.showMessageDialog(null, "Empleado guardado: " +
                        empleado.toString());
            } catch (ParseException ex) {
                Logger.getLogger(AccionesAltaEmpleados.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
    
    /**
     * Procedimiento para imprimir por pantalla los empleados guardados en
     * la base de datos
     */
    public void Imprimir() {
        ServiceEmpleado EmpleadoDAO = new ServiceEmpleado();
        List<Empleado> empleados = new ArrayList<>();
        String textoEmpleados = "Empleados:\n";
        
        empleados = EmpleadoDAO.findAll();
        
        if (!empleados.isEmpty()) {
            for (Iterator<Empleado> iterator = empleados.iterator(); iterator.hasNext();) {
                Empleado empleadoActual = iterator.next();
                textoEmpleados += "  " + empleadoActual.toString() + "\n";
            }
            JOptionPane.showMessageDialog(null, textoEmpleados);
        } else {
            JOptionPane.showMessageDialog(null, "No hay empleados guardados");
        }
    }
}
