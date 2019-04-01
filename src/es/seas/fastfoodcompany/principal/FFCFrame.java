/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.seas.fastfoodcompany.principal;

import es.seas.fastfoodcompany.vistas.PanelAltaClientes;
import es.seas.fastfoodcompany.vistas.PanelBajaClientes;
import es.seas.fastfoodcompany.vistas.PanelEditarClientes;
import es.seas.fastfoodcompany.vistas.PanelAltaEmpleados;
import es.seas.fastfoodcompany.vistas.PanelBajaEmpleados;
import es.seas.fastfoodcompany.vistas.PanelEditarEmpleados;
import es.seas.fastfoodcompany.modelo.entidades.Empleado;
import es.seas.fastfoodcompany.vistas.PanelAltaCategorias;
import es.seas.fastfoodcompany.vistas.PanelAltaIVA;
import es.seas.fastfoodcompany.vistas.PanelAltaProductos;
import es.seas.fastfoodcompany.vistas.PanelBajaCategorias;
import es.seas.fastfoodcompany.vistas.PanelBajaIVA;
import es.seas.fastfoodcompany.vistas.PanelBajaProductos;
import es.seas.fastfoodcompany.vistas.PanelBajaVentas;
import es.seas.fastfoodcompany.vistas.PanelEditarCategorias;
import es.seas.fastfoodcompany.vistas.PanelEditarIVA;
import es.seas.fastfoodcompany.vistas.PanelEditarProductos;
import es.seas.fastfoodcompany.vistas.PanelEditarVentas;
import es.seas.fastfoodcompany.vistas.TPVTactil;
import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 * Ventana principal de la aplicacion FastFoodCompany
 *
 * @author Manuel Antonio Romero Sánchez
 */
public class FFCFrame extends javax.swing.JFrame {
    private Empleado usuario;
    
    /**
     * Crea un nuevo formulario FFCFrame
     * @param usuario Usuario que abrió la aplicación
     */
    public FFCFrame(Empleado usuario) {
        this.usuario = usuario;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle(this.getTitle() + " - " + 
                ((!usuario.getApellido1().isEmpty())?
                usuario.getApellido1() + " " + usuario.getApellido2() + ", " +
                        usuario.getNombre()
                :usuario.getNombre()));
        if (!this.usuario.isAdministrador()) {
            menuEmpleados.setVisible(false);
            menuCategorias.setVisible(false);
            menuClientes.setVisible(false);
            menuIVA.setVisible(false);
            menuProductos.setVisible(false);
            menuVentas.setVisible(false);
        }
    }

    /**
     * Devuelve el usuario (Empleado) actual
     *
     * @return Empleado
     */
    public Empleado getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario (Empleado) actual
     *
     * @param usuario Empleado
     */
    public void setUsuario(Empleado usuario) {
        this.usuario = usuario;
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
        barraMenus = new javax.swing.JMenuBar();
        menuClientes = new javax.swing.JMenu();
        menuAltaClientes = new javax.swing.JMenuItem();
        menuBajaClientes = new javax.swing.JMenuItem();
        menuEdicionClientes = new javax.swing.JMenuItem();
        menuEmpleados = new javax.swing.JMenu();
        menuAltaEmpleados = new javax.swing.JMenuItem();
        menuBajaEmpleados = new javax.swing.JMenuItem();
        menuEdicionEmpleados = new javax.swing.JMenuItem();
        menuIVA = new javax.swing.JMenu();
        menuAltaIVA = new javax.swing.JMenuItem();
        menuBajaIVA = new javax.swing.JMenuItem();
        menuEdicionIVA = new javax.swing.JMenuItem();
        menuCategorias = new javax.swing.JMenu();
        menuAltaCategorias = new javax.swing.JMenuItem();
        menuBajaCategorias = new javax.swing.JMenuItem();
        menuEdicionCategorias = new javax.swing.JMenuItem();
        menuProductos = new javax.swing.JMenu();
        menuAltaProductos = new javax.swing.JMenuItem();
        menuBajaProductos = new javax.swing.JMenuItem();
        menuEdicionProductos = new javax.swing.JMenuItem();
        menuVentas = new javax.swing.JMenu();
        menuBajaVentas = new javax.swing.JMenuItem();
        menuEditarVentas = new javax.swing.JMenuItem();
        menuTPV = new javax.swing.JMenu();
        menuTPVTactil = new javax.swing.JMenuItem();
        menuSesion = new javax.swing.JMenu();
        menuCerrarSesion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fast Food Company");

        panelContenedor.setPreferredSize(new java.awt.Dimension(500, 500));
        panelContenedor.setLayout(new java.awt.BorderLayout());
        getContentPane().add(panelContenedor, java.awt.BorderLayout.CENTER);

        menuClientes.setText("Clientes");

        menuAltaClientes.setText("Alta");
        menuAltaClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAltaClientesActionPerformed(evt);
            }
        });
        menuClientes.add(menuAltaClientes);

        menuBajaClientes.setText("Baja");
        menuBajaClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBajaClientesActionPerformed(evt);
            }
        });
        menuClientes.add(menuBajaClientes);

        menuEdicionClientes.setText("Ver/Editar");
        menuEdicionClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEdicionClientesActionPerformed(evt);
            }
        });
        menuClientes.add(menuEdicionClientes);

        barraMenus.add(menuClientes);

        menuEmpleados.setText("Empleados");

        menuAltaEmpleados.setText("Alta");
        menuAltaEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAltaEmpleadosActionPerformed(evt);
            }
        });
        menuEmpleados.add(menuAltaEmpleados);

        menuBajaEmpleados.setText("Baja");
        menuBajaEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBajaEmpleadosActionPerformed(evt);
            }
        });
        menuEmpleados.add(menuBajaEmpleados);

        menuEdicionEmpleados.setText("Ver/Editar");
        menuEdicionEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEdicionEmpleadosActionPerformed(evt);
            }
        });
        menuEmpleados.add(menuEdicionEmpleados);

        barraMenus.add(menuEmpleados);

        menuIVA.setText("IVA");

        menuAltaIVA.setText("Alta");
        menuAltaIVA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAltaIVAActionPerformed(evt);
            }
        });
        menuIVA.add(menuAltaIVA);

        menuBajaIVA.setText("Baja");
        menuBajaIVA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBajaIVAActionPerformed(evt);
            }
        });
        menuIVA.add(menuBajaIVA);

        menuEdicionIVA.setText("Ver/Editar");
        menuEdicionIVA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEdicionIVAActionPerformed(evt);
            }
        });
        menuIVA.add(menuEdicionIVA);

        barraMenus.add(menuIVA);

        menuCategorias.setText("Categorías");

        menuAltaCategorias.setText("Alta");
        menuAltaCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAltaCategoriasActionPerformed(evt);
            }
        });
        menuCategorias.add(menuAltaCategorias);

        menuBajaCategorias.setText("Baja");
        menuBajaCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBajaCategoriasActionPerformed(evt);
            }
        });
        menuCategorias.add(menuBajaCategorias);

        menuEdicionCategorias.setText("Ver/Editar");
        menuEdicionCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEdicionCategoriasActionPerformed(evt);
            }
        });
        menuCategorias.add(menuEdicionCategorias);

        barraMenus.add(menuCategorias);

        menuProductos.setText("Productos");

        menuAltaProductos.setText("Alta");
        menuAltaProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAltaProductosActionPerformed(evt);
            }
        });
        menuProductos.add(menuAltaProductos);

        menuBajaProductos.setText("Baja");
        menuBajaProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBajaProductosActionPerformed(evt);
            }
        });
        menuProductos.add(menuBajaProductos);

        menuEdicionProductos.setText("Ver/Editar");
        menuEdicionProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEdicionProductosActionPerformed(evt);
            }
        });
        menuProductos.add(menuEdicionProductos);

        barraMenus.add(menuProductos);

        menuVentas.setText("Ventas");

        menuBajaVentas.setText("Baja");
        menuBajaVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBajaVentasActionPerformed(evt);
            }
        });
        menuVentas.add(menuBajaVentas);

        menuEditarVentas.setText("Ver/Editar");
        menuEditarVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditarVentasActionPerformed(evt);
            }
        });
        menuVentas.add(menuEditarVentas);

        barraMenus.add(menuVentas);

        menuTPV.setText("TPV");

        menuTPVTactil.setText("TPV Táctil");
        menuTPVTactil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTPVTactilActionPerformed(evt);
            }
        });
        menuTPV.add(menuTPVTactil);

        barraMenus.add(menuTPV);

        menuSesion.setText("Sesión");

        menuCerrarSesion.setText("Logout");
        menuCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCerrarSesionActionPerformed(evt);
            }
        });
        menuSesion.add(menuCerrarSesion);

        barraMenus.add(menuSesion);

        setJMenuBar(barraMenus);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuAltaClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAltaClientesActionPerformed
        cargaPanel(new PanelAltaClientes(this));
    }//GEN-LAST:event_menuAltaClientesActionPerformed

    private void menuBajaClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBajaClientesActionPerformed
        cargaPanel(new PanelBajaClientes(this));
    }//GEN-LAST:event_menuBajaClientesActionPerformed

    private void menuEdicionClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEdicionClientesActionPerformed
        cargaPanel(new PanelEditarClientes(this));
    }//GEN-LAST:event_menuEdicionClientesActionPerformed

    private void menuAltaEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAltaEmpleadosActionPerformed
        cargaPanel(new PanelAltaEmpleados(this));
    }//GEN-LAST:event_menuAltaEmpleadosActionPerformed

    private void menuBajaEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBajaEmpleadosActionPerformed
        cargaPanel(new PanelBajaEmpleados(this));
    }//GEN-LAST:event_menuBajaEmpleadosActionPerformed

    private void menuEdicionEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEdicionEmpleadosActionPerformed
        cargaPanel(new PanelEditarEmpleados(this));
    }//GEN-LAST:event_menuEdicionEmpleadosActionPerformed

    private void menuCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCerrarSesionActionPerformed
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuCerrarSesionActionPerformed

    private void menuAltaCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAltaCategoriasActionPerformed
        cargaPanel(new PanelAltaCategorias(this));
    }//GEN-LAST:event_menuAltaCategoriasActionPerformed

    private void menuBajaCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBajaCategoriasActionPerformed
        cargaPanel(new PanelBajaCategorias(this));
    }//GEN-LAST:event_menuBajaCategoriasActionPerformed

    private void menuEdicionCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEdicionCategoriasActionPerformed
        cargaPanel(new PanelEditarCategorias(this));
    }//GEN-LAST:event_menuEdicionCategoriasActionPerformed

    private void menuAltaIVAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAltaIVAActionPerformed
        cargaPanel(new PanelAltaIVA(this));
    }//GEN-LAST:event_menuAltaIVAActionPerformed

    private void menuBajaIVAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBajaIVAActionPerformed
        cargaPanel(new PanelBajaIVA(this));
    }//GEN-LAST:event_menuBajaIVAActionPerformed

    private void menuEdicionIVAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEdicionIVAActionPerformed
        cargaPanel(new PanelEditarIVA(this));
    }//GEN-LAST:event_menuEdicionIVAActionPerformed

    private void menuAltaProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAltaProductosActionPerformed
        cargaPanel(new PanelAltaProductos(this));
    }//GEN-LAST:event_menuAltaProductosActionPerformed

    private void menuBajaProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBajaProductosActionPerformed
        cargaPanel(new PanelBajaProductos(this));
    }//GEN-LAST:event_menuBajaProductosActionPerformed

    private void menuEdicionProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEdicionProductosActionPerformed
        cargaPanel(new PanelEditarProductos(this));
    }//GEN-LAST:event_menuEdicionProductosActionPerformed

    private void menuBajaVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBajaVentasActionPerformed
        cargaPanel(new PanelBajaVentas(this));
    }//GEN-LAST:event_menuBajaVentasActionPerformed

    private void menuEditarVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditarVentasActionPerformed
        cargaPanel(new PanelEditarVentas(this));
    }//GEN-LAST:event_menuEditarVentasActionPerformed

    private void menuTPVTactilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTPVTactilActionPerformed
        cargaPanel(new TPVTactil(this));
        this.setResizable(false);
        pack();
    }//GEN-LAST:event_menuTPVTactilActionPerformed
    
    private void cargaPanel(JPanel panel) {
        panelContenedor.removeAll();
        panelContenedor.add(panel, BorderLayout.CENTER);
        panelContenedor.setPreferredSize(panel.getPreferredSize());
        pack();
        this.setLocationRelativeTo(null);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenus;
    private javax.swing.JMenuItem menuAltaCategorias;
    private javax.swing.JMenuItem menuAltaClientes;
    private javax.swing.JMenuItem menuAltaEmpleados;
    private javax.swing.JMenuItem menuAltaIVA;
    private javax.swing.JMenuItem menuAltaProductos;
    private javax.swing.JMenuItem menuBajaCategorias;
    private javax.swing.JMenuItem menuBajaClientes;
    private javax.swing.JMenuItem menuBajaEmpleados;
    private javax.swing.JMenuItem menuBajaIVA;
    private javax.swing.JMenuItem menuBajaProductos;
    private javax.swing.JMenuItem menuBajaVentas;
    private javax.swing.JMenu menuCategorias;
    private javax.swing.JMenuItem menuCerrarSesion;
    private javax.swing.JMenu menuClientes;
    private javax.swing.JMenuItem menuEdicionCategorias;
    private javax.swing.JMenuItem menuEdicionClientes;
    private javax.swing.JMenuItem menuEdicionEmpleados;
    private javax.swing.JMenuItem menuEdicionIVA;
    private javax.swing.JMenuItem menuEdicionProductos;
    private javax.swing.JMenuItem menuEditarVentas;
    private javax.swing.JMenu menuEmpleados;
    private javax.swing.JMenu menuIVA;
    private javax.swing.JMenu menuProductos;
    private javax.swing.JMenu menuSesion;
    private javax.swing.JMenu menuTPV;
    private javax.swing.JMenuItem menuTPVTactil;
    private javax.swing.JMenu menuVentas;
    private javax.swing.JPanel panelContenedor;
    // End of variables declaration//GEN-END:variables
}
