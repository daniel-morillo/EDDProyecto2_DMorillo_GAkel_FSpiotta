/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import EstructurasDeDatos.HashTable;
import EstructurasDeDatos.Lista;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

/**
 *
 * @author fabriziospiotta
 */
public class InterfazInicial extends javax.swing.JFrame {
    
    private static HashTable summaryHashTable;
    private static HashTable autoresHashTable;
    private static HashTable palabrasClaveHashTable;
    private static Lista listaAutoresRegistrados;
    /**
     * Creates new form InterfazPrincipal
     */
    public InterfazInicial(HashTable summaryHashTable, HashTable autoresHashTable, HashTable palabrasClaveHashTable, Lista listaAutoresRegistrados) {
        this.summaryHashTable = summaryHashTable;
        this.autoresHashTable = autoresHashTable;
        this.palabrasClaveHashTable = palabrasClaveHashTable;
        this.listaAutoresRegistrados =  listaAutoresRegistrados;
        initComponents();
        UIManager UI = new UIManager();
        UI.put("OptionPane.background", new ColorUIResource(255, 153, 102));
        UI.put("Panel.background", new ColorUIResource(255, 153, 102));
        this.setLocationRelativeTo(null);
        this.setSize(900, 700);
    }
    
    public Image getIconImage(){
        Image retvalue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/cc.png"));
        return retvalue;
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
        IrMenuButton = new javax.swing.JButton();
        BorrarSistemaButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, -1, -1));

        IrMenuButton.setBackground(new java.awt.Color(102, 153, 255));
        IrMenuButton.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N
        IrMenuButton.setForeground(new java.awt.Color(255, 255, 255));
        IrMenuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/7.png"))); // NOI18N
        IrMenuButton.setText("IR AL MENU PRINCIPAL");
        IrMenuButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        IrMenuButton.setOpaque(true);
        IrMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IrMenuButtonActionPerformed(evt);
            }
        });
        getContentPane().add(IrMenuButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 430, 310, 90));

        BorrarSistemaButton.setBackground(new java.awt.Color(102, 153, 255));
        BorrarSistemaButton.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N
        BorrarSistemaButton.setForeground(new java.awt.Color(255, 255, 255));
        BorrarSistemaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/6.png"))); // NOI18N
        BorrarSistemaButton.setText("BORRAR PRE-GUARDADO");
        BorrarSistemaButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BorrarSistemaButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BorrarSistemaButton.setOpaque(true);
        BorrarSistemaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrarSistemaButtonActionPerformed(evt);
            }
        });
        getContentPane().add(BorrarSistemaButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, 310, 90));

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Bienvenido al sistema de administración de artículos ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, -1, -1));

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("científicos, aquí podrás realizar búsquedas ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, -1, -1));

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("¿Cómo deseas empezar?");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, -1, -1));

        jLabel4.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("y analizar resúmenes.");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, -1, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo Inicio.png"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IrMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IrMenuButtonActionPerformed
        // TODO add your handling code here:
        InterfazMenu menu = new InterfazMenu(summaryHashTable, autoresHashTable, palabrasClaveHashTable, listaAutoresRegistrados);
        this.setVisible(false);
        menu.setVisible(true);                
    }//GEN-LAST:event_IrMenuButtonActionPerformed

    private void BorrarSistemaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrarSistemaButtonActionPerformed
        // TODO add your handling code here:
        this.summaryHashTable = new HashTable(23);
        try {
            PrintWriter pw = new PrintWriter("test//resumenes_guardados.txt");
            pw.print("");
            pw.close();
            JOptionPane.showMessageDialog(this, "Sistema borrado exitosamente!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al borrar los datos del sistema, porfavor intente de nuevo");
        }
    }//GEN-LAST:event_BorrarSistemaButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazInicial(summaryHashTable, autoresHashTable, palabrasClaveHashTable, listaAutoresRegistrados).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BorrarSistemaButton;
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton IrMenuButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
