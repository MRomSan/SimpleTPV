/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.vistas;

import es.seas.fastfoodcompany.controlador.AccionesAltaEmpleados;
import es.seas.fastfoodcompany.principal.FFCFrame;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Pantalla de alta de empleados
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class PanelAltaEmpleados extends javax.swing.JPanel {
    private FFCFrame frame;
    private AccionesAltaEmpleados acciones;
    
    /**
     * Crea un nuevo formPanel PanelAltaEmpleados
     * 
     * @param frame FFCFrame Frame en el que se carga el panel
     */
    public PanelAltaEmpleados(FFCFrame frame) {
        this.frame = frame;
        this.acciones = new AccionesAltaEmpleados(this);
        initComponents();
    }

    /**
     * Devuelve el frame en el que se carga el panel
     *
     * @return FFCFrame Frame en el que se carga el panel
     */
    public FFCFrame getFrame() {
        return frame;
    }

    /**
     * Establece el frame en el que se carga el panel
     *
     * @param frame FFCFrame Frame en el que se carga el panel
     */
    public void setFrame(FFCFrame frame) {
        this.frame = frame;
    }

    /**
     * Devuelve el panel dónde se cargan los datos
     *
     * @return panelDatos Panel en el que se cargarán los datos del empleado
     */
    public JPanel getPanelDatos() {
        return panelDatos;
    }

    /**
     * Establece el panel dónde se cargan los datos
     *
     * @param panelDatos Panel en el que se cargarán los datos del empleado
     */
    public void setPanelDatos(JPanel panelDatos) {
        this.panelDatos = panelDatos;
    }
    
    /**
     * Devuelve una Clase con las acciones de alta de empleados
     *
     * @return AccionesAltaEmpleados Contiene las acciones de alta
     */
    public AccionesAltaEmpleados getAcciones() {
        return acciones;
    }

    /**
     * Establece una Clase con las acciones de alta de empleados
     *
     * @param acciones AccionesAltaEmpleados Contiene las acciones de alta
     */
    public void setAcciones(AccionesAltaEmpleados acciones) {
        this.acciones = acciones;
    }
    
    /**
     * Devuelve el botón Guardar
     *
     * @return JButton
     */
    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    /**
     * Establece el botón Guardar
     *
     * @param btnGuardar JButton
     */
    public void setBtnGuardar(JButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    /**
     * Devuelve el botón Imprimir
     *
     * @return JButton
     */
    public JButton getBtnImprimir() {
        return btnImprimir;
    }

    /**
     * Establece el botón Imprimir
     *
     * @param btnImprimir JButton
     */
    public void setBtnImprimir(JButton btnImprimir) {
        this.btnImprimir = btnImprimir;
    }

    /**
     * Devuelve el label Título
     *
     * @return JLabel
     */
    public JLabel getLblTitulo() {
        return lblTitulo;
    }

    /**
     * Establece el label Título
     *
     * @param lblTitulo JLabel
     */
    public void setLblTitulo(JLabel lblTitulo) {
        this.lblTitulo = lblTitulo;
    }
    
    /**
     * Devuelve el label Apellido1
     *
     * @return JLabel
     */
    public JLabel getLblApellido1() {
        return lblApellido1;
    }

    /**
     * Establece el label Apellido1
     *
     * @param lblApellido1 JLabel
     */
    public void setLblApellido1(JLabel lblApellido1) {
        this.lblApellido1 = lblApellido1;
    }

    /**
     * Devuelve el label Apellido2
     *
     * @return JLabel
     */
    public JLabel getLblApellido2() {
        return lblApellido2;
    }

    /**
     * Establece el label Apellido2
     *
     * @param lblApellido2 JLabel
     */
    public void setLblApellido2(JLabel lblApellido2) {
        this.lblApellido2 = lblApellido2;
    }

    /**
     * Devuelve el label Nombre
     *
     * @return JLabel
     */
    public JLabel getLblNombre() {
        return lblNombre;
    }

    /**
     * Establece el label Nombre
     *
     * @param lblNombre JLabel
     */
    public void setLblNombre(JLabel lblNombre) {
        this.lblNombre = lblNombre;
    }

    /**
     * Devuelve el campo de texto Apellido1
     *
     * @return JTextField
     */
    public JTextField getTxtApellido1() {
        return txtApellido1;
    }

    /**
     * Establece el campo de texto Apellido1
     *
     * @param txtApellido1 JTextField
     */
    public void setTxtApellido1(JTextField txtApellido1) {
        this.txtApellido1 = txtApellido1;
    }

    /**
     * Devuelve el campo de texto Apellido2
     *
     * @return JTextField
     */
    public JTextField getTxtApellido2() {
        return txtApellido2;
    }

    /**
     * Establece el campo de texto Apellido2
     *
     * @param txtApellido2 JTextField
     */
    public void setTxtApellido2(JTextField txtApellido2) {
        this.txtApellido2 = txtApellido2;
    }

    /**
     * Devuelve el campo de texto Nombre
     *
     * @return JTextField
     */
    public JTextField getTxtNombre() {
        return txtNombre;
    }

    /**
     * Establece el campo de texto Nombre
     *
     * @param txtNombre JTextField
     */
    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }
    
    /**
     * Devuelve el checkBox de estado Administrador
     *
     * @return JCheckBox
     */
    public JCheckBox getChkAdministrador() {
        return chkAdministrador;
    }

    /**
     * Establece el checkBox de estado Administrador
     *
     * @param chkAdministrador JCheckBox
     */
    public void setChkAdministraor(JCheckBox chkAdministrador) {
        this.chkAdministrador = chkAdministrador;
    }

    /**
     * Devuelve el label Password
     *
     * @return JLabel
     */
    public JLabel getLblPassword() {
        return lblPassword;
    }

    /**
     * Establece el label Password
     *
     * @param lblPassword JLabel
     */
    public void setLblPassword(JLabel lblPassword) {
        this.lblPassword = lblPassword;
    }

    /**
     * Devuelve el label Username
     *
     * @return JLabel
     */
    public JLabel getLblUsername() {
        return lblUsername;
    }

    /**
     * Establece el label Username
     *
     * @param lblUsername JLabel
     */
    public void setLblUsername(JLabel lblUsername) {
        this.lblUsername = lblUsername;
    }

    /**
     * Devuelve el campo de texto Password
     *
     * @return JTextField
     */
    public JTextField getTxtPassword() {
        return txtPassword;
    }

    /**
     * Establece el campo de texto Password
     *
     * @param txtPassword JTextField
     */
    public void setTxtPassword(JTextField txtPassword) {
        this.txtPassword = txtPassword;
    }

    /**
     * Devuelve el campo de texto Username
     *
     * @return JTextField
     */
    public JTextField getTxtUsername() {
        return txtUsername;
    }

    /**
     * Establece el campo de texto Username
     *
     * @param txtUsername JTextField
     */
    public void setTxtUsername(JTextField txtUsername) {
        this.txtUsername = txtUsername;
    }
    
    /**
     * Devuelve el comboBox Sexo
     *
     * @return JComboBox
     */
    public JComboBox<String> getCmbSexo() {
        return cmbSexo;
    }
    
    /**
     * Establece el comboBox Sexo
     *
     * @param cmbSexo JComboBox
     */
    public void setCmbSexo(JComboBox<String> cmbSexo) {
        this.cmbSexo = cmbSexo;
    }

    /**
     * Devuelve el label Código Postal (C.P.)
     *
     * @return JLabel
     */
    public JLabel getLblCodigoPostal() {
        return lblCodigoPostal;
    }

    /**
     * Establece el label Código Postal (C.P.)
     *
     * @param lblCodigoPostal JLabel
     */
    public void setLblCodigoPostal(JLabel lblCodigoPostal) {
        this.lblCodigoPostal = lblCodigoPostal;
    }

    /**
     * Devuelve el label DNI
     *
     * @return JLabel
     */
    public JLabel getLblDNI() {
        return lblDNI;
    }

    /**
     * Establece el label DNI
     *
     * @param lblDNI JLabel
     */
    public void setLblDNI(JLabel lblDNI) {
        this.lblDNI = lblDNI;
    }

    /**
     * Devuelve el label Dirección
     *
     * @return JLabel
     */
    public JLabel getLblDireccion() {
        return lblDireccion;
    }

    /**
     * Establece el label Dirección
     *
     * @param lblDireccion JLabel
     */
    public void setLblDireccion(JLabel lblDireccion) {
        this.lblDireccion = lblDireccion;
    }

    /**
     * Devuelve el label email
     *
     * @return JLabel
     */
    public JLabel getLblEmail() {
        return lblEmail;
    }

    /**
     * Establece el label email
     *
     * @param lblEmail JLabel
     */
    public void setLblEmail(JLabel lblEmail) {
        this.lblEmail = lblEmail;
    }

    /**
     * Devuelve el label Fecha de nacimiento
     *
     * @return JLabel
     */
    public JLabel getLblFechaNacimiento() {
        return lblFechaNacimiento;
    }

    /**
     * Establece el label Fecha de nacimiento
     *
     * @param lblFechaNacimiento JLabel
     */
    public void setLblFechaNacimiento(JLabel lblFechaNacimiento) {
        this.lblFechaNacimiento = lblFechaNacimiento;
    }

    /**
     * Devuelve el label Formato de Fecha
     *
     * @return JLabel
     */
    public JLabel getLblFormatoFecha() {
        return lblFormatoFecha;
    }

    /**
     * Establece el label Formato de Fecha
     *
     * @param lblFormatoFecha JLabel
     */
    public void setLblFormatoFecha(JLabel lblFormatoFecha) {
        this.lblFormatoFecha = lblFormatoFecha;
    }

    /**
     * Devuelve el label Guión del DNI
     *
     * @return JLabel
     */
    public JLabel getLblGuionDNI() {
        return lblGuionDNI;
    }

    /**
     * Establece el label Guión del DNI
     *
     * @param lblGuionDNI JLabel
     */
    public void setLblGuionDNI(JLabel lblGuionDNI) {
        this.lblGuionDNI = lblGuionDNI;
    }

    /**
     * Devuelve el label Población
     *
     * @return JLabel
     */
    public JLabel getLblPoblacion() {
        return lblPoblacion;
    }

    /**
     * Establece el label Población
     *
     * @param lblPoblacion JLabel
     */
    public void setLblPoblacion(JLabel lblPoblacion) {
        this.lblPoblacion = lblPoblacion;
    }

    /**
     * Devuelve el label Provincia
     *
     * @return JLabel
     */
    public JLabel getLblProvincia() {
        return lblProvincia;
    }

    /**
     * Establece el label Provincia
     *
     * @param lblProvincia JLabel
     */
    public void setLblProvincia(JLabel lblProvincia) {
        this.lblProvincia = lblProvincia;
    }

    /**
     * Devuelve el label Sexo
     *
     * @return JLabel
     */
    public JLabel getLblSexo() {
        return lblSexo;
    }

    /**
     * Establece el label Sexo
     *
     * @param lblSexo JLabel
     */
    public void setLblSexo(JLabel lblSexo) {
        this.lblSexo = lblSexo;
    }

    /**
     * Devuelve el label Teléfono 1
     *
     * @return JLabel
     */
    public JLabel getLblTlfn1() {
        return lblTlfn1;
    }

    /**
     * Establece el label Teléfono 1
     *
     * @param lblTlfn1 JLabel
     */
    public void setLblTlfn1(JLabel lblTlfn1) {
        this.lblTlfn1 = lblTlfn1;
    }

    /**
     * Devuelve el label Teléfono 2
     *
     * @return JLabel
     */
    public JLabel getLblTlfn2() {
        return lblTlfn2;
    }

    /**
     * Establece el label Teléfono 2
     *
     * @param lblTlfn2 JLabel
     */
    public void setLblTlfn2(JLabel lblTlfn2) {
        this.lblTlfn2 = lblTlfn2;
    }

    /**
     * Devuelve el campo de texto formateado Código Postal
     *
     * @return JFormattedTextField
     */
    public JFormattedTextField getTxtCodigoPostal() {
        return txtCodigoPostal;
    }

    /**
     * Establece el campo de texto formateado Código Postal
     *
     * @param txtCodigoPostal JFormattedTextField
     */
    public void setTxtCodigoPostal(JFormattedTextField txtCodigoPostal) {
        this.txtCodigoPostal = txtCodigoPostal;
    }

    /**
     * Devuelve el campo de texto formateado DNI (########)
     *
     * @return JFormattedTextField
     */
    public JFormattedTextField getTxtDNI() {
        return txtDNI;
    }

    /**
     * Establece el campo de texto formateado DNI (########)
     *
     * @param txtDNI JFormattedTextField
     */
    public void setTxtDNI(JFormattedTextField txtDNI) {
        this.txtDNI = txtDNI;
    }

    /**
     * Devuelve el campo de texto formateado DNILetra (U)
     *
     * @return JFormattedTextField
     */
    public JFormattedTextField getTxtDNILetra() {
        return txtDNILetra;
    }

    /**
     * Establece el campo de texto formateado DNILetra (U)
     *
     * @param txtDNILetra JFormattedTextField
     */
    public void setTxtDNILetra(JFormattedTextField txtDNILetra) {
        this.txtDNILetra = txtDNILetra;
    }

    /**
     * Devuelve el campo de texto Dirección
     *
     * @return JTextField
     */
    public JTextField getTxtDireccion() {
        return txtDireccion;
    }

    /**
     * Establece el campo de texto Dirección
     *
     * @param txtDireccion JTextField
     */
    public void setTxtDireccion(JTextField txtDireccion) {
        this.txtDireccion = txtDireccion;
    }

    /**
     * Devuelve el campo de texto email
     *
     * @return JTextField
     */
    public JTextField getTxtEmail() {
        return txtEmail;
    }

    /**
     * Establece el campo de texto email
     *
     * @param txtEmail JTextField
     */
    public void setTxtEmail(JTextField txtEmail) {
        this.txtEmail = txtEmail;
    }

    /**
     * Devuelve el campo de texto formateado Fecha de nacimiento (dd/mm/aaaa)
     *
     * @return JFormattedTextField
     */
    public JFormattedTextField getTxtFechaNacimiento() {
        return txtFechaNacimiento;
    }

    /**
     * Establece el campo de texto formateado Fecha de nacimiento (dd/mm/aaaa)
     *
     * @param txtFechaNacimiento JFormattedTextField
     */
    public void setTxtFechaNacimiento(JFormattedTextField txtFechaNacimiento) {
        this.txtFechaNacimiento = txtFechaNacimiento;
    }

    /**
     * Devuelve el campo de texto Población
     *
     * @return JTextField
     */
    public JTextField getTxtPoblacion() {
        return txtPoblacion;
    }

    /**
     * Establece el campo de texto Población
     *
     * @param txtPoblacion JTextField
     */
    public void setTxtPoblacion(JTextField txtPoblacion) {
        this.txtPoblacion = txtPoblacion;
    }

    /**
     * Devuelve el campo de texto Provincia
     *
     * @return JTextField
     */
    public JTextField getTxtProvincia() {
        return txtProvincia;
    }

    /**
     * Establece el campo de texto Provincia
     *
     * @param txtProvincia JTextField
     */
    public void setTxtProvincia(JTextField txtProvincia) {
        this.txtProvincia = txtProvincia;
    }

    /**
     * Devuelve el campo de texto formateado Teléfono 1 (### ### ###)
     *
     * @return JFormattedTextField
     */
    public JFormattedTextField getTxtTlfn1() {
        return txtTlfn1;
    }

    /**
     * Establece el campo de texto formateado Teléfono 1 (### ### ###)
     *
     * @param txtTlfn1 JFormattedTextField
     */
    public void setTxtTlfn1(JFormattedTextField txtTlfn1) {
        this.txtTlfn1 = txtTlfn1;
    }

    /**
     * Devuelve el campo de texto formateado Teléfono 2 (### ### ###)
     *
     * @return JFormattedTextField
     */
    public JFormattedTextField getTxtTlfn2() {
        return txtTlfn2;
    }

    /**
     * Establece el campo de texto formateado Teléfono 2 (### ### ###)
     *
     * @param txtTlfn2 JFormattedTextField
     */
    public void setTxtTlfn2(JFormattedTextField txtTlfn2) {
        this.txtTlfn2 = txtTlfn2;
    }

    /**
     * Devuelve el label Cargo
     *
     * @return JLabel
     */
    public JLabel getLblCargo() {
        return lblCargo;
    }

    /**
     * Establece el label Cargo
     *
     * @param lblCargo JLabel
     */
    public void setLblCargo(JLabel lblCargo) {
        this.lblCargo = lblCargo;
    }

    /**
     * Devuelve el campo de texto Cargo
     *
     * @return JTextField
     */
    public JTextField getTxtCargo() {
        return txtCargo;
    }

    /**
     * Establece el campo de texto Cargo
     *
     * @param txtCargo JTextField
     */
    public void setTxtCargo(JTextField txtCargo) {
        this.txtCargo = txtCargo;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDatos = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblApellido1 = new javax.swing.JLabel();
        txtApellido1 = new javax.swing.JTextField();
        lblApellido2 = new javax.swing.JLabel();
        txtApellido2 = new javax.swing.JTextField();
        lblDNI = new javax.swing.JLabel();
        txtDNI = new javax.swing.JFormattedTextField();
        lblGuionDNI = new javax.swing.JLabel();
        txtDNILetra = new javax.swing.JFormattedTextField();
        lblSexo = new javax.swing.JLabel();
        cmbSexo = new javax.swing.JComboBox<>();
        lblTlfn1 = new javax.swing.JLabel();
        txtTlfn1 = new javax.swing.JFormattedTextField();
        lblTlfn2 = new javax.swing.JLabel();
        txtTlfn2 = new javax.swing.JFormattedTextField();
        lblFechaNacimiento = new javax.swing.JLabel();
        txtFechaNacimiento = new javax.swing.JFormattedTextField();
        lblFormatoFecha = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        lblPoblacion = new javax.swing.JLabel();
        txtPoblacion = new javax.swing.JTextField();
        lblProvincia = new javax.swing.JLabel();
        txtProvincia = new javax.swing.JTextField();
        lblCodigoPostal = new javax.swing.JLabel();
        txtCodigoPostal = new javax.swing.JFormattedTextField();
        lblCargo = new javax.swing.JLabel();
        txtCargo = new javax.swing.JTextField();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        chkAdministrador = new javax.swing.JCheckBox();
        btnImprimir = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitulo.setText("ALTA EMPLEADOS");

        lblNombre.setText("Nombre:");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        lblApellido1.setText("Primer apellido:");

        txtApellido1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellido1ActionPerformed(evt);
            }
        });

        lblApellido2.setText("Segundo apellido:");

        txtApellido2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellido2ActionPerformed(evt);
            }
        });

        lblDNI.setText("DNI:");

        try {
            txtDNI.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDNIActionPerformed(evt);
            }
        });

        lblGuionDNI.setText("-");

        try {
            txtDNILetra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("U")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDNILetra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDNILetraActionPerformed(evt);
            }
        });

        lblSexo.setText("Sexo:");

        cmbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hombre", "Mujer" }));

        lblTlfn1.setText("Tlfn. 1:");

        try {
            txtTlfn1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("### ### ###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTlfn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTlfn1ActionPerformed(evt);
            }
        });

        lblTlfn2.setText("Tlfn. 2:");

        try {
            txtTlfn2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("### ### ###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTlfn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTlfn2ActionPerformed(evt);
            }
        });

        lblFechaNacimiento.setText("F. nacimiento:");

        try {
            txtFechaNacimiento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFechaNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaNacimientoActionPerformed(evt);
            }
        });

        lblFormatoFecha.setText("(dd/mm/aaaa)");

        lblEmail.setText("e-mail:");

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        lblDireccion.setText("Dirección:");

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        lblPoblacion.setText("Población:");

        txtPoblacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPoblacionActionPerformed(evt);
            }
        });

        lblProvincia.setText("Provincia:");

        txtProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProvinciaActionPerformed(evt);
            }
        });

        lblCodigoPostal.setText("C.P.:");

        try {
            txtCodigoPostal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCodigoPostal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoPostalActionPerformed(evt);
            }
        });

        lblCargo.setText("Cargo:");

        txtCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCargoActionPerformed(evt);
            }
        });

        lblUsername.setText("Usuario:");

        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        lblPassword.setText("Contraseña:");

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        chkAdministrador.setText("Administrador");

        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(lblDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblGuionDNI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDNILetra, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbSexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(lblTlfn1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTlfn1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTlfn2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTlfn2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(lblFechaNacimiento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFormatoFecha))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(lblEmail)
                        .addGap(18, 18, 18)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(lblDireccion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(lblPoblacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPoblacion, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTitulo)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblApellido1, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                            .addComponent(lblApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtApellido2, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(txtNombre)
                            .addComponent(txtApellido1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosLayout.createSequentialGroup()
                        .addComponent(lblPassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPassword))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosLayout.createSequentialGroup()
                        .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUsername))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(chkAdministrador))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDatosLayout.createSequentialGroup()
                                .addComponent(lblCargo)
                                .addGap(18, 18, 18)
                                .addComponent(txtCargo))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDatosLayout.createSequentialGroup()
                                .addComponent(lblProvincia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblCodigoPostal)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigoPostal)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnImprimir)
                .addGap(18, 18, 18)
                .addComponent(btnGuardar)
                .addContainerGap())
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellido1)
                    .addComponent(txtApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellido2)
                    .addComponent(txtApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDNI)
                    .addComponent(txtDNILetra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGuionDNI)
                    .addComponent(lblSexo)
                    .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTlfn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTlfn2)
                    .addComponent(txtTlfn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTlfn1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaNacimiento)
                    .addComponent(lblFormatoFecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDireccion)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPoblacion)
                    .addComponent(txtPoblacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProvincia)
                    .addComponent(txtProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodigoPostal)
                    .addComponent(txtCodigoPostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCargo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsername))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkAdministrador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnImprimir))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        acciones.Guardar();
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        acciones.Guardar();
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        acciones.Guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        acciones.Imprimir();
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void txtApellido2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellido2ActionPerformed
        acciones.Guardar();
    }//GEN-LAST:event_txtApellido2ActionPerformed

    private void txtApellido1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellido1ActionPerformed
        acciones.Guardar();
    }//GEN-LAST:event_txtApellido1ActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        acciones.Guardar();
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDNIActionPerformed
        acciones.Guardar();
    }//GEN-LAST:event_txtDNIActionPerformed

    private void txtDNILetraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDNILetraActionPerformed
        acciones.Guardar();
    }//GEN-LAST:event_txtDNILetraActionPerformed

    private void txtTlfn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTlfn1ActionPerformed
        acciones.Guardar();
    }//GEN-LAST:event_txtTlfn1ActionPerformed

    private void txtTlfn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTlfn2ActionPerformed
        acciones.Guardar();
    }//GEN-LAST:event_txtTlfn2ActionPerformed

    private void txtFechaNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaNacimientoActionPerformed
        acciones.Guardar();
    }//GEN-LAST:event_txtFechaNacimientoActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        acciones.Guardar();
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        acciones.Guardar();
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtPoblacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPoblacionActionPerformed
        acciones.Guardar();
    }//GEN-LAST:event_txtPoblacionActionPerformed

    private void txtProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProvinciaActionPerformed
        acciones.Guardar();
    }//GEN-LAST:event_txtProvinciaActionPerformed

    private void txtCodigoPostalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoPostalActionPerformed
        acciones.Guardar();
    }//GEN-LAST:event_txtCodigoPostalActionPerformed

    private void txtCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCargoActionPerformed
        acciones.Guardar();
    }//GEN-LAST:event_txtCargoActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JCheckBox chkAdministrador;
    private javax.swing.JComboBox<String> cmbSexo;
    private javax.swing.JLabel lblApellido1;
    private javax.swing.JLabel lblApellido2;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblCodigoPostal;
    private javax.swing.JLabel lblDNI;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblFormatoFecha;
    private javax.swing.JLabel lblGuionDNI;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPoblacion;
    private javax.swing.JLabel lblProvincia;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTlfn1;
    private javax.swing.JLabel lblTlfn2;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JTextField txtApellido1;
    private javax.swing.JTextField txtApellido2;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JFormattedTextField txtCodigoPostal;
    private javax.swing.JFormattedTextField txtDNI;
    private javax.swing.JFormattedTextField txtDNILetra;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JFormattedTextField txtFechaNacimiento;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPoblacion;
    private javax.swing.JTextField txtProvincia;
    private javax.swing.JFormattedTextField txtTlfn1;
    private javax.swing.JFormattedTextField txtTlfn2;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
