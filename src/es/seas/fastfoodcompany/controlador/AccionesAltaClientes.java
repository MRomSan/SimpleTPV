/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.controlador;

import es.seas.fastfoodcompany.modelo.entidades.Cliente;
import es.seas.fastfoodcompany.gestionbd.ServiceCliente;
import es.seas.fastfoodcompany.vistas.PanelAltaClientes;
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
 * Clase que controla las acciones de altas de clientes
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class AccionesAltaClientes {
    private final PanelAltaClientes panel;

    /**
     * Constructor predeterminado
     *
     * @param panel Panel al que están enlazadas las acciones de clientes
     */
    public AccionesAltaClientes(PanelAltaClientes panel) {
        this.panel = panel;
    }
    
    /**
     * Procedimiento para guardar un cliente en la base de datos
     */
    public void Guardar() {
        if (ValidaCampos()) {
            try {
                ServiceCliente clienteDAO = new ServiceCliente();
                Cliente cliente = new Cliente();
                cliente.setNombre(panel.getTxtNombre().getText());
                cliente.setApellido1(panel.getTxtApellido1().getText());
                cliente.setApellido2(panel.getTxtApellido2().getText());
                cliente.setDni(panel.getTxtDNI().getText() +
                        panel.getTxtDNILetra().getText());
                cliente.setSexo(panel.getCmbSexo().getSelectedIndex()==0?"H":"M");
                cliente.setTelefono1(panel.getTxtTlfn1().getText().replace(" ", ""));
                cliente.setTelefono2(panel.getTxtTlfn2().getText().replace(" ", ""));
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                java.util.Date utilDate = new java.util.Date();
                utilDate = sdf.parse(panel.getTxtFechaNacimiento().getText());
                cliente.setFecha_nacimiento(new Date(utilDate.getTime()));
                cliente.setEmail(panel.getTxtEmail().getText());
                cliente.setDireccion(panel.getTxtDireccion().getText());
                cliente.setPoblacion(panel.getTxtPoblacion().getText());
                cliente.setProvincia(panel.getTxtProvincia().getText());
                cliente.setCodigo_postal(panel.getTxtCodigoPostal().getText());
                clienteDAO.insert(cliente);
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
                JOptionPane.showMessageDialog(null, "Cliente guardado: " +
                        cliente.toString());
            } catch (ParseException ex) {
                Logger.getLogger(AccionesAltaClientes.class.getName()).log(Level.SEVERE, null, ex);
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
     * Procedimiento para imprimir por pantalla los clientes guardados en
     * la base de datos
     */
    public void Imprimir() {
        ServiceCliente clienteDAO = new ServiceCliente();
        List<Cliente> clientes = new ArrayList<>();
        String textoClientes = "Clientes:\n";
        
        clientes = clienteDAO.findAll();
        
        if (!clientes.isEmpty()) {
            for (Iterator<Cliente> iterator = clientes.iterator(); iterator.hasNext();) {
                Cliente clienteActual = iterator.next();
                textoClientes += "  " + clienteActual.toString() + "\n";
            }
            JOptionPane.showMessageDialog(null, textoClientes);
        } else {
            JOptionPane.showMessageDialog(null, "No hay clientes guardados");
        }
    }
}
