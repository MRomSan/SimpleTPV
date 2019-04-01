/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.controlador;

import es.seas.fastfoodcompany.modelo.entidades.Cliente;
import es.seas.fastfoodcompany.gestionbd.ServiceCliente;
import es.seas.fastfoodcompany.vistas.PanelEditarClientes;
import es.seas.fastfoodcompany.config.ModeloTabla;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Clase que controla las acciones de edición de clientes
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class AccionesEditarClientes {
    private PanelEditarClientes panel;
    private ModeloTabla tabla;

    /**
     * Constructor predeterminado
     *
     * @param panel PanelEditarClientes al que pertenecen las acciones
     */
    public AccionesEditarClientes(PanelEditarClientes panel) {
        this.panel = panel;
    }
    
    /**
     * Método que inicializa y carga los valores en la tabla.
     */
    public void InicializaTabla() {
        //Modelo
        tabla = new ModeloTabla(new String[]{
            "ID", "Apellido1", "Apellido2", "Nombre", "DNI"}, 0);
        PintaTabla();
        //Datos
        CargaDatosTabla();
    }

    /**
     * Método que carga los valores en la tabla
     */
    public void CargaDatosTabla() {
        ServiceCliente clienteDAO = new ServiceCliente();
        List<Cliente> clientes = new ArrayList<Cliente>();
        
        clientes = clienteDAO.findAll();
        for (Cliente clienteActual : clientes) {
            Vector filaTabla = new Vector();
            filaTabla.add(clienteActual.getId());
            filaTabla.add(clienteActual.getApellido1());
            filaTabla.add(clienteActual.getApellido2());
            filaTabla.add(clienteActual.getNombre());
            filaTabla.add(clienteActual.getDni());
            tabla.addRow(filaTabla);
        }
        PintaTabla();
    }
    
    /**
     * Método que carga, en el panel de datos de cliente, el cliente 
     * seleccionado en la tabla
     */
    public void CargaClienteSeleccionado () {
        int filaSeleccionada = panel.getTablaClientes().getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "No hay registros seleccionados");
        } else {
            Cliente cliente = new Cliente();
            ServiceCliente clienteDAO = new ServiceCliente();
            cliente = clienteDAO.findById((int) panel.getTablaClientes().
                        getValueAt(filaSeleccionada, 0));
            
            habilitaCampos(true);
            panel.getLblID().setText(Integer.toString(cliente.getId()));
            panel.getTxtNombre().setText(cliente.getNombre());
            panel.getTxtApellido1().setText(cliente.getApellido1());
            panel.getTxtApellido2().setText(cliente.getApellido2());
            panel.getTxtDNI().setText(cliente.getDni().substring(0, 
                    cliente.getDni().length() - 1));
            panel.getTxtDNILetra().setText(cliente.getDni().substring(
                    cliente.getDni().length() - 1));
            panel.getCmbSexo().setSelectedIndex(cliente.getSexo().equals("H")?0:1);
            panel.getTxtTlfn1().setText(cliente.getTelefono1());
            panel.getTxtTlfn2().setText(cliente.getTelefono2());
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date utilDate = new java.util.Date(cliente.getFecha_nacimiento().getTime());
            panel.getTxtFechaNacimiento().setText(sdf.format(utilDate));
            panel.getTxtEmail().setText(cliente.getEmail());
            panel.getTxtDireccion().setText(cliente.getDireccion());
            panel.getTxtPoblacion().setText(cliente.getPoblacion());
            panel.getTxtProvincia().setText(cliente.getProvincia());
            panel.getTxtCodigoPostal().setText(cliente.getCodigo_postal());
        }
    }
    
    /**
     * Método que actualiza el cliente en la base de datos y por pantalla
     */
    public void ActualizaCliente () {
        if (panel.getLblID().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay registro cargado");
        } else {
            if(ValidaCampos()){
                try {
                    ServiceCliente clienteDAO = new ServiceCliente();
                    Cliente cliente = new Cliente();
                    
                    cliente.setId(Integer.parseInt(panel.getLblID().getText()));
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
                    
                    clienteDAO.update(cliente);
                    
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
                    JOptionPane.showMessageDialog(null, "Cliente actualizado: " 
                            + cliente.toString());
                    tabla.setNumRows(0);
                    BuscarClientes(panel.getTxtBuscar().getText());
                    habilitaCampos(false);
                } catch (ParseException ex) {
                    Logger.getLogger(AccionesEditarClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    /**
     * Método que busca los clientes cuyos campos coincidan total o parcialmente
     * con el texto introducido
     *
     * @param texto String
     */
    public void BuscarClientes(String texto) {
        ServiceCliente clienteDAO = new ServiceCliente();
        List<Cliente> clientes = new ArrayList<Cliente>();
        
        clientes = clienteDAO.buscar(texto);
        tabla.setNumRows(0);
        for (Cliente clienteActual : clientes) {
            Vector filaTabla = new Vector();
            filaTabla.add(clienteActual.getId());
            filaTabla.add(clienteActual.getApellido1());
            filaTabla.add(clienteActual.getApellido2());
            filaTabla.add(clienteActual.getNombre());
            filaTabla.add(clienteActual.getDni());
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
            Exception excDNIIncorrecto = new Exception("DNI incorrecto");

            //Validación campo no vacío
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
            JOptionPane.showMessageDialog(null, e.getMessage(), "Campo vacío", 0);
        }
        return false;
    }
    
    //Función que valida si el DNI es válido
    private boolean validaLetraDNI(String dniIntroducido) {
        int DNI = Integer.parseInt(dniIntroducido.substring(0, 8));
        String letraIntroducida = dniIntroducido.substring(8);
        int resto;
        String letraCorrecta;
        String[] asignacionLetra = {"T", "R", "W", "A", "G", "M", "Y", "F", "P",
                        "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", 
                        "C", "K" , "E"};
        resto = DNI % 23;
        letraCorrecta = asignacionLetra[resto];
        
        return letraIntroducida.equals(letraCorrecta);
    }
    
    //Pinta de nuevo la tabla
    private void PintaTabla() {
        panel.getTablaClientes().setModel(tabla);
        panel.getTablaClientes().getColumnModel().getColumn(0).setPreferredWidth(0);
        panel.getTablaClientes().getColumnModel().getColumn(0).setMaxWidth(0);
        panel.getTablaClientes().getColumnModel().getColumn(0).setMinWidth(0);
        panel.getPanelTabla().setViewportView(panel.getTablaClientes());
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
