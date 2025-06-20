package GUI;

import main.java.Logica.Sistema;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author msanz
 */
public class Interfaz extends javax.swing.JFrame {

    private final Sistema sistema;
    ImageIcon galleta = new ImageIcon("CookieClicker/cookie.png");
    
    Image imagen = galleta.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
    private final ImageIcon galletaPequena = new ImageIcon(galleta.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH));

    ImageIcon galletamini = new ImageIcon(imagen);
    
    /**
     * Creates new form Interfaz
     */
    public Interfaz(Sistema sistema) {
        this.sistema = sistema;
        initComponents();
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        this.setIconImage(galletamini.getImage());
        this.setTitle("Cookie Clicker");
        this.setLocationRelativeTo(null);
        jLabel1.setText("");
        jLabel1.setIcon(galletamini);
        
        refrescarTabla();
        
        Timer refrescarTimer = new javax.swing.Timer(150, (e) -> {
            try {
                jLabel2.setText("Cookies: " + sistema.getNumeroGalletas());


            } catch (Exception ex) {
                System.out.println("Error al actualizar las galletas: " + ex.getMessage());
            }
            
    });
        refrescarTimer.start();
        
    }
    public void refrescarTabla() {
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Limpiar la tabla
        model.addRow(new Object[]{"Cursor", (int) Math.ceil(15 * Math.pow(1.15, sistema.getNumCursors())), sistema.getNumCursors()});
        model.addRow(new Object[]{"Abuela", (int) Math.ceil(100 * Math.pow(1.15, sistema.getNumAbuelas())), sistema.getNumAbuelas()});
        model.addRow(new Object[]{"Granja", (int) Math.ceil(500 * Math.pow(1.15, sistema.getNumGranjas())), sistema.getNumGranjas()});
        model.addRow(new Object[]{"Fábrica", (int) Math.ceil(3000 * Math.pow(1.15, sistema.getNumFabricas())), sistema.getNumFabricas()});
        model.addRow(new Object[]{"Banco", (int) Math.ceil(20000 * Math.pow(1.15, sistema.getNumBancos())), sistema.getNumBancos()});
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(60, 86, 80));

        jLabel1.setText("jLabel1");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setText("Cookies: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel2)
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 113, Short.MAX_VALUE)
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tipo", "Precio", "Cantidad comprada"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("Comprar!");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cursor", "Abuela", "Granja", "Fábrica", "Banco" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:

        sistema.Click();
        jLabel1.setIcon(galletaPequena); // Cambia a pequeña

        // Después de 120 ms, vuelve al tamaño normal
        new javax.swing.Timer(120, e -> {
            jLabel1.setIcon(galletamini);
            ((javax.swing.Timer) e.getSource()).stop();
        }).start();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String seleccion = (String) jComboBox1.getSelectedItem();
        switch (seleccion) {
            case "Cursor":
                if (sistema.getNumeroGalletas() >= Math.ceil(15 * Math.pow(1.15, sistema.getNumCursors()))) {
                    sistema.CrearCursor();
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "No tienes suficientes galletas para comprar un Cursor.", "Fondos insuficientes", javax.swing.JOptionPane.WARNING_MESSAGE);
                }
                break;
            case "Abuela":
                if (sistema.getNumeroGalletas() >= Math.ceil(100 * Math.pow(1.15, sistema.getNumAbuelas()))) {
                    sistema.CrearAbuela();
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "No tienes suficientes galletas para comprar una Abuela.", "Fondos insuficientes", javax.swing.JOptionPane.WARNING_MESSAGE);
                }
                break;
            case "Granja":
                if (sistema.getNumeroGalletas() >= Math.ceil(500 * Math.pow(1.15, sistema.getNumGranjas()))) {
                    sistema.CrearGranja();
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "No tienes suficientes galletas para comprar una Granja.", "Fondos insuficientes", javax.swing.JOptionPane.WARNING_MESSAGE);
                }
                break;
            case "Fábrica":
                if (sistema.getNumeroGalletas() >= Math.ceil(3000 * Math.pow(1.15, sistema.getNumFabricas()))) {
                    sistema.CrearFabrica();
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "No tienes suficientes galletas para comprar una Fábrica.", "Fondos insuficientes", javax.swing.JOptionPane.WARNING_MESSAGE);
                }
                break;
            case "Banco":
                if (sistema.getNumeroGalletas() >= Math.ceil(20000 * Math.pow(1.15, sistema.getNumBancos()))) {
                    sistema.CrearBanco();
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "No tienes suficientes galletas para comprar un Banco.", "Fondos insuficientes", javax.swing.JOptionPane.WARNING_MESSAGE);
                }
                break;
        }
        // Actualizar la tabla después de la compra
        refrescarTabla();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
