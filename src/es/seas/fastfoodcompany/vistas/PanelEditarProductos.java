/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.vistas;

import es.seas.fastfoodcompany.controlador.AccionesEditarProductos;
import es.seas.fastfoodcompany.modelo.entidades.Categoria;
import es.seas.fastfoodcompany.principal.FFCFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * Pantalla de edición de Productos
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class PanelEditarProductos extends javax.swing.JPanel {
    private FFCFrame frame;
    private AccionesEditarProductos acciones;
    private Categoria categoriaBusqueda;
    
    /**
     * Crea un nuevo formPanel PanelEditarProductos
     * @param frame FFCFrame Frame en el que se carga el panel
     */
    public PanelEditarProductos(FFCFrame frame) {
        this.frame = frame;
        this.acciones = new AccionesEditarProductos(this);
        this.categoriaBusqueda = null;
        initComponents();
        acciones.inicializaCmbCategoria();
        acciones.inicializaCmbIVA();
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
     * Devuelve la tabla de productos
     *
     * @return JTable
     */
    public JTable getTablaProductos() {
        return tablaProductos;
    }

    /**
     * Establece la tabla de productos
     *
     * @param tablaProductos JTable
     */
    public void setTablaProductos(JTable tablaProductos) {
        this.tablaProductos = tablaProductos;
    }

    /**
     * Devuelve la clase que contiene las acciones de edición de productos
     *
     * @return AccionesEditarProductos
     */
    public AccionesEditarProductos getAcciones() {
        return acciones;
    }

    /**
     * Establece la clase que contiene las acciones de edición de productos
     *
     * @param acciones AccionesEditarProductos
     */
    public void setAcciones(AccionesEditarProductos acciones) {
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
     * Devuelve el botón Buscar Imagen ("...")
     *
     * @return JButton
     */
    public JButton getBtnBuscarImagen() {
        return btnBuscarImagen;
    }

    /**
     * Establece el botón Buscar Imagen ("...")
     *
     * @param btnBuscarImagen JButton
     */
    public void setBtnBuscarImagen(JButton btnBuscarImagen) {
        this.btnBuscarImagen = btnBuscarImagen;
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
     * Devuelve el label Descripción
     *
     * @return JLabel
     */
    public JLabel getLblDescripcion() {
        return lblDescripcion;
    }

    /**
     * Establece el label Descripción
     *
     * @param lblDescripcion JLabel
     */
    public void setLblDescripcion(JLabel lblDescripcion) {
        this.lblDescripcion = lblDescripcion;
    }

    /**
     * Devuelve el label Imagen
     *
     * @return JLabel
     */
    public JLabel getLblImagen() {
        return lblImagen;
    }

    /**
     * Establece el label Imagen
     *
     * @param lblImagen JLabel
     */
    public void setLblImagen(JLabel lblImagen) {
        this.lblImagen = lblImagen;
    }

    /**
     * Devuelve el label Muestra Imagen (donde se carga la imagen)
     *
     * @return JLabel
     */
    public JLabel getLblMuestraImagen() {
        return lblMuestraImagen;
    }

    /**
     * Establece el label Muestra Imagen (donde se carga la imagen)
     *
     * @param lblMuestraImagen JLabel
     */
    public void setLblMuestraImagen(JLabel lblMuestraImagen) {
        this.lblMuestraImagen = lblMuestraImagen;
    }

    /**
     * Devuelve el campo de texto Descripción
     *
     * @return JTextField
     */
    public JTextField getTxtDescripcion() {
        return txtDescripcion;
    }

    /**
     * Establece el campo de texto Descripción
     *
     * @param txtDescripcion JTextField
     */
    public void setTxtDescripcion(JTextField txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
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
     * Devuelve el comboBox Categoría
     *
     * @return JComboBox
     */
    public JComboBox<String> getCmbCategoria() {
        return cmbCategoria;
    }

    /**
     * Establece el comboBox Categoría
     *
     * @param cmbCategoria JComboBox
     */
    public void setCmbCategoria(JComboBox<String> cmbCategoria) {
        this.cmbCategoria = cmbCategoria;
    }

    /**
     * Devuelve el comboBox IVA
     *
     * @return JComboBox
     */
    public JComboBox<String> getCmbIVA() {
        return cmbIVA;
    }

    /**
     * Establece el comboBox IVA
     *
     * @param cmbIVA JComboBox
     */
    public void setCmbIVA(JComboBox<String> cmbIVA) {
        this.cmbIVA = cmbIVA;
    }

    /**
     * Devuelve el label Categoría
     *
     * @return JLabel
     */
    public JLabel getLblCategoria() {
        return lblCategoria;
    }

    /**
     * Establece el label Categoría
     *
     * @param lblCategoria JLabel
     */
    public void setLblCategoria(JLabel lblCategoria) {
        this.lblCategoria = lblCategoria;
    }

    /**
     * Devuelve el label IVA
     *
     * @return JLabel
     */
    public JLabel getLblIVA() {
        return lblIVA;
    }

    /**
     * Establece el label IVA
     *
     * @param lblIVA JLabel
     */
    public void setLblIVA(JLabel lblIVA) {
        this.lblIVA = lblIVA;
    }

    /**
     * Devuelve el label Precio
     *
     * @return JLabel
     */
    public JLabel getLblPrecio() {
        return lblPrecio;
    }

    /**
     * Establece el label Precio
     *
     * @param lblPrecio JLabel
     */
    public void setLblPrecio(JLabel lblPrecio) {
        this.lblPrecio = lblPrecio;
    }

    /**
     * Devuelve el campo de texto formateado Precio
     *
     * @return JFormattedTextField
     */
    public JFormattedTextField getTxtPrecio() {
        return txtPrecio;
    }

    /**
     * Establece el campo de texto formateado Precio
     *
     * @param txtPrecio JFormattedTextField
     */
    public void setTxtPrecio(JFormattedTextField txtPrecio) {
        this.txtPrecio = txtPrecio;
    }

    /**
     * Devuelve el label Cantidad IVA
     *
     * @return JLabel
     */
    public JLabel getLblCantidadIVA() {
        return lblCantidadIVA;
    }
    
    /**
     * Establece el label Cantidad IVA
     *
     * @param lblCantidadIVA JLabel
     */
    public void setLblCantidadIVA(JLabel lblCantidadIVA) {
        this.lblCantidadIVA = lblCantidadIVA;
    }

    /**
     * Devuelve el label Euro
     *
     * @return JLabel
     */
    public JLabel getLblEuro() {
        return lblEuro;
    }

    /**
     * Establece el label Euro
     *
     * @param lblEuro JLabel
     */
    public void setLblEuro(JLabel lblEuro) {
        this.lblEuro = lblEuro;
    }
    
    /**
     * Devuelve el botón Buscar Categoría
     *
     * @return JButton
     */
    public JButton getBtnBuscarCategoria() {
        return btnBuscarCategoria;
    }

    /**
     * Establece el botón Buscar Categoría
     *
     * @param btnBuscarCategoria JButton
     */
    public void setBtnBuscarCategoria(JButton btnBuscarCategoria) {
        this.btnBuscarCategoria = btnBuscarCategoria;
    }

    /**
     * Devuelve el botón Quitar Categoría
     *
     * @return JButton
     */
    public JButton getBtnQuitarCategoria() {
        return btnQuitarCategoria;
    }

    /**
     * Establece el botón Quitar Categoría
     *
     * @param btnQuitarCategoria JButton
     */
    public void setBtnQuitarCategoria(JButton btnQuitarCategoria) {
        this.btnQuitarCategoria = btnQuitarCategoria;
    }
    
    /**
     * Devuelve el label Categoría
     *
     * @return JLabel
     */
    public JLabel getLblBuscarCategoria() {
        return lblBuscarCategoria;
    }

    /**
     * Establece el label Categoría
     *
     * @param lblBuscarCategoria JLabel
     */
    public void setLblBuscarCategoria(JLabel lblBuscarCategoria) {
        this.lblBuscarCategoria = lblBuscarCategoria;
    }

    /**
     * Devuelve el campo de texto Buscar Categoría
     *
     * @return JTextField
     */
    public JTextField getTxtBuscarCategoria() {
        return txtBuscarCategoria;
    }

    /**
     * Establece el campo de texto Buscar Categoría
     *
     * @param txtBuscarCategoria JTextField
     */
    public void setTxtBuscarCategoria(JTextField txtBuscarCategoria) {
        this.txtBuscarCategoria = txtBuscarCategoria;
    }

    /**
     * Devuelve la Categoría seleccionada en el filtro de búsqueda
     *
     * @return Categoria
     */
    public Categoria getCategoriaBusqueda() {
        return categoriaBusqueda;
    }

    /**
     * Establece la Categoría para el filtro de búsqueda
     *
     * @param categoriaBusqueda Categoria
     */
    public void setCategoriaBusqueda(Categoria categoriaBusqueda) {
        this.categoriaBusqueda = categoriaBusqueda;
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
        tablaProductos = new javax.swing.JTable();
        panelDatos = new javax.swing.JPanel();
        lblID = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        lblCategoria = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblDescripcion = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        lblPrecio = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JFormattedTextField();
        lblEuro = new javax.swing.JLabel();
        lblIVA = new javax.swing.JLabel();
        cmbIVA = new javax.swing.JComboBox<>();
        lblCantidadIVA = new javax.swing.JLabel();
        lblImagen = new javax.swing.JLabel();
        lblMuestraImagen = new javax.swing.JLabel();
        btnBuscarImagen = new javax.swing.JButton();
        panelBotonera = new javax.swing.JPanel();
        btnEditar = new javax.swing.JButton();
        lblBuscar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        lblBuscarCategoria = new javax.swing.JLabel();
        txtBuscarCategoria = new javax.swing.JTextField();
        btnBuscarCategoria = new javax.swing.JButton();
        btnQuitarCategoria = new javax.swing.JButton();

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitulo.setText("EDITAR PRODUCTOS");

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

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaProductos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductosMouseClicked(evt);
            }
        });
        panelTabla.setViewportView(tablaProductos);

        panelDatos.setBorder(javax.swing.BorderFactory.createTitledBorder("Producto Seleccionado"));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        lblCategoria.setText("Categoría:");

        cmbCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCategoriaItemStateChanged(evt);
            }
        });

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

        lblDescripcion.setText("Descripción:");

        txtDescripcion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDescripcionFocusGained(evt);
            }
        });
        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });

        lblPrecio.setText("Precio:");

        txtPrecio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtPrecio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPrecioFocusGained(evt);
            }
        });
        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });

        lblEuro.setText("€");

        lblIVA.setText("IVA:");

        cmbIVA.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIVAItemStateChanged(evt);
            }
        });

        lblCantidadIVA.setText("0,0");

        lblImagen.setText("Imagen:");

        lblMuestraImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnBuscarImagen.setText(",,,");
        btnBuscarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarImagenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addContainerGap())
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCategoria)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelDatosLayout.createSequentialGroup()
                                        .addComponent(lblMuestraImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnBuscarImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblEuro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblIVA)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCantidadIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategoria)
                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescripcion)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrecio)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIVA)
                    .addComponent(cmbIVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEuro)
                    .addComponent(lblCantidadIVA))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImagen)
                    .addComponent(lblMuestraImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarImagen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

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

        lblBuscarCategoria.setText("Categoría:");

        txtBuscarCategoria.setEditable(false);
        txtBuscarCategoria.setPreferredSize(new java.awt.Dimension(220, 22));

        btnBuscarCategoria.setText("...");
        btnBuscarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCategoriaActionPerformed(evt);
            }
        });

        btnQuitarCategoria.setText("Quitar Categoría");
        btnQuitarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarCategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotoneraLayout = new javax.swing.GroupLayout(panelBotonera);
        panelBotonera.setLayout(panelBotoneraLayout);
        panelBotoneraLayout.setHorizontalGroup(
            panelBotoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotoneraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBuscarCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQuitarCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
                .addComponent(lblBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditar)
                .addContainerGap())
        );
        panelBotoneraLayout.setVerticalGroup(
            panelBotoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotoneraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBotoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBotoneraLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtBuscarCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelBotoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblBuscarCategoria)
                        .addComponent(btnQuitarCategoria)
                        .addComponent(btnBuscarCategoria))
                    .addGroup(panelBotoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEditar)
                        .addComponent(lblBuscar)))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBotonera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTabla, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, 0)
                .addComponent(panelBotonera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void tablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMouseClicked
        if(evt.getClickCount() == 2) {
            acciones.CargaProductoSeleccionado();
        }
    }//GEN-LAST:event_tablaProductosMouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        acciones.ActualizaProducto();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        acciones.CargaProductoSeleccionado();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        acciones.BuscarProductos(getTxtBuscar().getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void cmbCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCategoriaItemStateChanged
        acciones.cambiaCategoriaSeleccionada(getCmbCategoria().
            getSelectedItem().toString());
    }//GEN-LAST:event_cmbCategoriaItemStateChanged

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        acciones.ActualizaProducto();
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        acciones.ActualizaProducto();
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        acciones.ActualizaProducto();
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        if (evt.getKeyChar() == '.') {
            evt.setKeyChar(',');
        }
    }//GEN-LAST:event_txtPrecioKeyTyped

    private void cmbIVAItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbIVAItemStateChanged
        acciones.cambiaIVASeleccionado(getCmbIVA().
            getSelectedItem().toString());
    }//GEN-LAST:event_cmbIVAItemStateChanged

    private void btnBuscarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarImagenActionPerformed
        acciones.buscarImagen();
    }//GEN-LAST:event_btnBuscarImagenActionPerformed

    private void txtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusGained
        ((JTextField)evt.getComponent()).selectAll();
    }//GEN-LAST:event_txtNombreFocusGained

    private void txtDescripcionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescripcionFocusGained
        ((JTextField)evt.getComponent()).selectAll();
    }//GEN-LAST:event_txtDescripcionFocusGained

    private void txtPrecioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioFocusGained
        SwingUtilities.invokeLater(() -> {
            ((JFormattedTextField)evt.getComponent()).selectAll();
        });
    }//GEN-LAST:event_txtPrecioFocusGained

    private void btnBuscarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCategoriaActionPerformed
        acciones.SeleccionarCategoria();
    }//GEN-LAST:event_btnBuscarCategoriaActionPerformed

    private void btnQuitarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarCategoriaActionPerformed
        acciones.QuitarCategoria();
    }//GEN-LAST:event_btnQuitarCategoriaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarCategoria;
    private javax.swing.JButton btnBuscarImagen;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnQuitarCategoria;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbIVA;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblBuscarCategoria;
    private javax.swing.JLabel lblCantidadIVA;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblEuro;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblIVA;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblMuestraImagen;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelBotonera;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JScrollPane panelTabla;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtBuscarCategoria;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JFormattedTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
