/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.vistas;

import es.seas.fastfoodcompany.controlador.AccionesEditarEmpleados;
import es.seas.fastfoodcompany.principal.FFCFrame;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * Pantalla de edición de empleados
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class PanelEditarEmpleados extends javax.swing.JPanel {
    private FFCFrame frame;
    private AccionesEditarEmpleados acciones;
    
    /**
     * Crea un nuevo formPanel PanelEditarEmpleados
     * @param frame FFCFrame
     */
    public PanelEditarEmpleados(FFCFrame frame) {
        this.frame = frame;
        this.acciones = new AccionesEditarEmpleados(this);
        initComponents();
        acciones.InicializaTabla();
        lblID.setVisible(false);
        acciones.habilitaCampos(false);
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
     * Devuelve el panel Botonera
     *
     * @return JPanel
     */
    public JPanel getPanelBotonera() {
        return panelBotonera;
    }

    /**
     * Establece el panel Botonera
     *
     * @param panelBotonera JPanel
     */
    public void setPanelBotonera(JPanel panelBotonera) {
        this.panelBotonera = panelBotonera;
    }

    /**
     * Devuelve el panel Contenedor
     *
     * @return JPanel
     */
    public JPanel getPanelContenedor() {
        return panelContenedor;
    }

    /**
     * Establece el panel Contenedor
     *
     * @param panelContenedor JPanel
     */
    public void setPanelContenedor(JPanel panelContenedor) {
        this.panelContenedor = panelContenedor;
    }

    /**
     * Devuelve el panel Datos
     *
     * @return JPanel
     */
    public JPanel getPanelDatos() {
        return panelDatos;
    }

    /**
     * Establece el panel Datos
     *
     * @param panelDatos JPanel
     */
    public void setPanelDatos(JPanel panelDatos) {
        this.panelDatos = panelDatos;
    }

    /**
     * Devuelve el JScrollPane que contiene la tabla
     *
     * @return JScrollPane
     */
    public JScrollPane getPanelTabla() {
        return panelTabla;
    }

    /**
     * Establece el JScrollPane que contiene la tabla
     *
     * @param panelTabla JScrollPane
     */
    public void setPanelTabla(JScrollPane panelTabla) {
        this.panelTabla = panelTabla;
    }

    /**
     * Devuelve el panel Título
     *
     * @return JPanel
     */
    public JPanel getPanelTitulo() {
        return panelTitulo;
    }

    /**
     * Establece el panel Título
     *
     * @param panelTitulo JPanel
     */
    public void setPanelTitulo(JPanel panelTitulo) {
        this.panelTitulo = panelTitulo;
    }

    /**
     * Devuelve la tabla de empleados
     *
     * @return JTable
     */
    public JTable getTablaEmpleados() {
        return tablaEmpleados;
    }

    /**
     * Establece la tabla de empleados
     *
     * @param tablaEmpleados JTable
     */
    public void setTablaEmpleados(JTable tablaEmpleados) {
        this.tablaEmpleados = tablaEmpleados;
    }

    /**
     * Devuelve el campo de texto del Apellido1
     *
     * @return JTextField
     */
    public JTextField getTxtApellido1() {
        return txtApellido1;
    }

    /**
     * Establece el campo de texto del Apellido1
     *
     * @param txtApellido1 JTextField
     */
    public void setTxtApellido1(JTextField txtApellido1) {
        this.txtApellido1 = txtApellido1;
    }

    /**
     * Devuelve el campo de texto del Apellido2
     *
     * @return JTextField
     */
    public JTextField getTxtApellido2() {
        return txtApellido2;
    }

    /**
     * Establece el campo de texto del Apellido2
     *
     * @param txtApellido2 JTextField
     */
    public void setTxtApellido2(JTextField txtApellido2) {
        this.txtApellido2 = txtApellido2;
    }

    /**
     * Devuelve el campo de texto del Nombre
     *
     * @return JTextField
     */
    public JTextField getTxtNombre() {
        return txtNombre;
    }

    /**
     * Establece el campo de texto del Nombre
     *
     * @param txtNombre JTextField
     */
    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    /**
     * Devuelve la clase que contiene las acciones de edición de empleados
     *
     * @return AccionesEditarEmpleados
     */
    public AccionesEditarEmpleados getAcciones() {
        return acciones;
    }

    /**
     * Establece la clase que contiene las acciones de edición de empleados
     *
     * @param acciones AccionesEditarEmpleados
     */
    public void setAcciones(AccionesEditarEmpleados acciones) {
        this.acciones = acciones;
    }

    /**
     * Devuelve el botón Editar
     *
     * @return JButton
     */
    public JButton getBtnEditar() {
        return btnEditar;
    }

    /**
     * Establece el botón Editar
     *
     * @param btnEditar JButton
     */
    public void setBtnEditar(JButton btnEditar) {
        this.btnEditar = btnEditar;
    }

    /**
     * Devuelve el label ID
     *
     * @return JLabel
     */
    public JLabel getLblID() {
        return lblID;
    }

    /**
     * Establece el label ID
     *
     * @param lblID JLabel
     */
    public void setLblID(JLabel lblID) {
        this.lblID = lblID;
    }

    /**
     * Devuelve el CheckBox Administrador
     *
     * @return JCheckBox
     */
    public JCheckBox getChkAdministrador() {
        return chkAdministrador;
    }

    /**
     * Establece el CheckBox Administrador
     *
     * @param chkAdministrador JCheckBox
     */
    public void setChkAdministrador(JCheckBox chkAdministrador) {
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
     * Devuelve el campo de texto Buscar
     *
     * @return JTextField
     */
    public JTextField getTxtBuscar() {
        return txtBuscar;
    }

    /**
     * Establece el campo de texto Buscar
     *
     * @param txtBuscar JTextField
     */
    public void setTxtBuscar(JTextField txtBuscar) {
        this.txtBuscar = txtBuscar;
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
     * Establece campo de texto Password
     *
     * @param txtPassword JTextField
     */
    public void setTxtPassword(JTextField txtPassword) {
        this.txtPassword = txtPassword;
    }

    /**
     * Devuelve campo de texto Username
     *
     * @return JTextField
     */
    public JTextField getTxtUsername() {
        return txtUsername;
    }

    /**
     * Establece campo de texto Username
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
     * Devuelve el label Buscar
     *
     * @return JLabel
     */
    public JLabel getLblBuscar() {
        return lblBuscar;
    }

    /**
     * Establece el label Buscar
     *
     * @param lblBuscar JLabel
     */
    public void setLblBuscar(JLabel lblBuscar) {
        this.lblBuscar = lblBuscar;
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

        panelContenedor = new javax.swing.JPanel();
        panelTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        panelTabla = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        panelDatos = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblApellido1 = new javax.swing.JLabel();
        txtApellido1 = new javax.swing.JTextField();
        lblApellido2 = new javax.swing.JLabel();
        txtApellido2 = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        lblID = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        chkAdministrador = new javax.swing.JCheckBox();
        lblGuionDNI = new javax.swing.JLabel();
        txtDNI = new javax.swing.JFormattedTextField();
        lblDNI = new javax.swing.JLabel();
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
        txtCodigoPostal = new javax.swing.JFormattedTextField();
        lblCodigoPostal = new javax.swing.JLabel();
        lblCargo = new javax.swing.JLabel();
        txtCargo = new javax.swing.JTextField();
        panelBotonera = new javax.swing.JPanel();
        btnEditar = new javax.swing.JButton();
        lblBuscar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitulo.setText("EDITAR EMPLEADOS");

        javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTituloLayout.setVerticalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaEmpleados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEmpleadosMouseClicked(evt);
            }
        });
        panelTabla.setViewportView(tablaEmpleados);

        panelDatos.setBorder(javax.swing.BorderFactory.createTitledBorder("Empleado Seleccionado"));

        lblNombre.setText("Nombre:");

        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreFocusGained(evt);
            }
        });
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        lblApellido1.setText("Primer apellido:");

        txtApellido1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtApellido1FocusGained(evt);
            }
        });
        txtApellido1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellido1ActionPerformed(evt);
            }
        });

        lblApellido2.setText("Segundo apellido:");

        txtApellido2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtApellido2FocusGained(evt);
            }
        });
        txtApellido2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellido2ActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        lblUsername.setText("Usuario:");

        txtUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsernameFocusGained(evt);
            }
        });
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        lblPassword.setText("Contraseña:");

        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPasswordFocusGained(evt);
            }
        });
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        chkAdministrador.setText("Administrador");

        lblGuionDNI.setText("-");

        try {
            txtDNI.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDNI.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDNIFocusGained(evt);
            }
        });
        txtDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDNIActionPerformed(evt);
            }
        });

        lblDNI.setText("DNI:");

        try {
            txtDNILetra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("U")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDNILetra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDNILetraFocusGained(evt);
            }
        });
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
        txtTlfn1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTlfn1FocusGained(evt);
            }
        });
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
        txtTlfn2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTlfn2FocusGained(evt);
            }
        });
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
        txtFechaNacimiento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFechaNacimientoFocusGained(evt);
            }
        });
        txtFechaNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaNacimientoActionPerformed(evt);
            }
        });

        lblFormatoFecha.setText("(dd/mm/aaaa)");

        lblEmail.setText("e-mail:");

        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEmailFocusGained(evt);
            }
        });
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        lblDireccion.setText("Dirección:");

        txtDireccion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDireccionFocusGained(evt);
            }
        });
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        lblPoblacion.setText("Población:");

        txtPoblacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPoblacionFocusGained(evt);
            }
        });
        txtPoblacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPoblacionActionPerformed(evt);
            }
        });

        lblProvincia.setText("Provincia:");

        txtProvincia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtProvinciaFocusGained(evt);
            }
        });
        txtProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProvinciaActionPerformed(evt);
            }
        });

        try {
            txtCodigoPostal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCodigoPostal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCodigoPostalFocusGained(evt);
            }
        });
        txtCodigoPostal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoPostalActionPerformed(evt);
            }
        });

        lblCodigoPostal.setText("C.P.:");

        lblCargo.setText("Cargo:");

        txtCargo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCargoFocusGained(evt);
            }
        });
        txtCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCargoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblApellido1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblApellido2))
                                .addGap(18, 18, 18)
                                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtApellido1)
                                    .addComponent(txtApellido2)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(chkAdministrador))
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(lblPassword)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                            .addComponent(txtCodigoPostal))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addContainerGap()
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
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelBotonera.setPreferredSize(new java.awt.Dimension(251, 34));

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        lblBuscar.setText("Buscar:");

        txtBuscar.setPreferredSize(new java.awt.Dimension(120, 20));
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panelBotoneraLayout = new javax.swing.GroupLayout(panelBotonera);
        panelBotonera.setLayout(panelBotoneraLayout);
        panelBotoneraLayout.setHorizontalGroup(
            panelBotoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotoneraLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditar)
                .addContainerGap())
        );
        panelBotoneraLayout.setVerticalGroup(
            panelBotoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotoneraLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelBotoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBotoneraLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEditar)
                        .addComponent(lblBuscar)))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBotonera, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContenedorLayout.createSequentialGroup()
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTabla, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, 0)
                .addComponent(panelBotonera, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        acciones.CargaEmpleadoSeleccionado();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        acciones.ActualizaEmpleado();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void tablaEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEmpleadosMouseClicked
        if(evt.getClickCount() == 2) {
            acciones.CargaEmpleadoSeleccionado();
        }
    }//GEN-LAST:event_tablaEmpleadosMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        acciones.BuscarEmpleados(getTxtBuscar().getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        acciones.ActualizaEmpleado();
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtApellido1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellido1ActionPerformed
        acciones.ActualizaEmpleado();
    }//GEN-LAST:event_txtApellido1ActionPerformed

    private void txtApellido2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellido2ActionPerformed
        acciones.ActualizaEmpleado();
    }//GEN-LAST:event_txtApellido2ActionPerformed

    private void txtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusGained
        ((JTextField)evt.getComponent()).selectAll();
    }//GEN-LAST:event_txtNombreFocusGained

    private void txtApellido1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApellido1FocusGained
        ((JTextField)evt.getComponent()).selectAll();
    }//GEN-LAST:event_txtApellido1FocusGained

    private void txtApellido2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApellido2FocusGained
        ((JTextField)evt.getComponent()).selectAll();
    }//GEN-LAST:event_txtApellido2FocusGained

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        acciones.ActualizaEmpleado();
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        acciones.ActualizaEmpleado();
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusGained
        ((JTextField)evt.getComponent()).selectAll();
    }//GEN-LAST:event_txtUsernameFocusGained

    private void txtPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusGained
        ((JTextField)evt.getComponent()).selectAll();
    }//GEN-LAST:event_txtPasswordFocusGained

    private void txtDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDNIActionPerformed
        acciones.ActualizaEmpleado();
    }//GEN-LAST:event_txtDNIActionPerformed

    private void txtDNILetraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDNILetraActionPerformed
        acciones.ActualizaEmpleado();
    }//GEN-LAST:event_txtDNILetraActionPerformed

    private void txtTlfn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTlfn1ActionPerformed
        acciones.ActualizaEmpleado();
    }//GEN-LAST:event_txtTlfn1ActionPerformed

    private void txtTlfn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTlfn2ActionPerformed
        acciones.ActualizaEmpleado();
    }//GEN-LAST:event_txtTlfn2ActionPerformed

    private void txtFechaNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaNacimientoActionPerformed
        acciones.ActualizaEmpleado();
    }//GEN-LAST:event_txtFechaNacimientoActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        acciones.ActualizaEmpleado();
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        acciones.ActualizaEmpleado();
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtPoblacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPoblacionActionPerformed
        acciones.ActualizaEmpleado();
    }//GEN-LAST:event_txtPoblacionActionPerformed

    private void txtProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProvinciaActionPerformed
        acciones.ActualizaEmpleado();
    }//GEN-LAST:event_txtProvinciaActionPerformed

    private void txtCodigoPostalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoPostalActionPerformed
        acciones.ActualizaEmpleado();
    }//GEN-LAST:event_txtCodigoPostalActionPerformed

    private void txtCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCargoActionPerformed
        acciones.ActualizaEmpleado();
    }//GEN-LAST:event_txtCargoActionPerformed

    private void txtDNIFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDNIFocusGained
        SwingUtilities.invokeLater(() -> {
            ((JFormattedTextField)evt.getComponent()).selectAll();
        });
    }//GEN-LAST:event_txtDNIFocusGained

    private void txtDNILetraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDNILetraFocusGained
        SwingUtilities.invokeLater(() -> {
            ((JFormattedTextField)evt.getComponent()).selectAll();
        });
    }//GEN-LAST:event_txtDNILetraFocusGained

    private void txtTlfn1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTlfn1FocusGained
        SwingUtilities.invokeLater(() -> {
            ((JFormattedTextField)evt.getComponent()).selectAll();
        });
    }//GEN-LAST:event_txtTlfn1FocusGained

    private void txtTlfn2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTlfn2FocusGained
        SwingUtilities.invokeLater(() -> {
            ((JFormattedTextField)evt.getComponent()).selectAll();
        });
    }//GEN-LAST:event_txtTlfn2FocusGained

    private void txtFechaNacimientoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaNacimientoFocusGained
        SwingUtilities.invokeLater(() -> {
            ((JFormattedTextField)evt.getComponent()).selectAll();
        });
    }//GEN-LAST:event_txtFechaNacimientoFocusGained

    private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusGained
        ((JTextField)evt.getComponent()).selectAll();
    }//GEN-LAST:event_txtEmailFocusGained

    private void txtDireccionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDireccionFocusGained
        ((JTextField)evt.getComponent()).selectAll();
    }//GEN-LAST:event_txtDireccionFocusGained

    private void txtPoblacionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPoblacionFocusGained
        ((JTextField)evt.getComponent()).selectAll();
    }//GEN-LAST:event_txtPoblacionFocusGained

    private void txtProvinciaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProvinciaFocusGained
        ((JTextField)evt.getComponent()).selectAll();
    }//GEN-LAST:event_txtProvinciaFocusGained

    private void txtCodigoPostalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoPostalFocusGained
        SwingUtilities.invokeLater(() -> {
            ((JFormattedTextField)evt.getComponent()).selectAll();
        });
    }//GEN-LAST:event_txtCodigoPostalFocusGained

    private void txtCargoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCargoFocusGained
        ((JTextField)evt.getComponent()).selectAll();
    }//GEN-LAST:event_txtCargoFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JCheckBox chkAdministrador;
    private javax.swing.JComboBox<String> cmbSexo;
    private javax.swing.JLabel lblApellido1;
    private javax.swing.JLabel lblApellido2;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblCodigoPostal;
    private javax.swing.JLabel lblDNI;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblFormatoFecha;
    private javax.swing.JLabel lblGuionDNI;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPoblacion;
    private javax.swing.JLabel lblProvincia;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTlfn1;
    private javax.swing.JLabel lblTlfn2;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel panelBotonera;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JScrollPane panelTabla;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JTable tablaEmpleados;
    private javax.swing.JTextField txtApellido1;
    private javax.swing.JTextField txtApellido2;
    private javax.swing.JTextField txtBuscar;
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
