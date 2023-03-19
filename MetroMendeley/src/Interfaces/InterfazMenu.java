/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Clases.Summary;
import EstructurasDeDatos.HashTable;
import EstructurasDeDatos.Lista;
import EstructurasDeDatos.Nodo;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

/**
 * Esta interfaz corresponde al menú, a partir de ella es que se puede acceder a las otras interfaces y sus funciones
 * @author Georgina Akel, Fabrizio Spiotta, Daniel Morillo
 */
public class InterfazMenu extends javax.swing.JFrame {

    static HashTable summaryHashTable;
    static HashTable autoresHashTable;
    static HashTable palabrasClaveHashTable;
    static Lista listaAutoresRegistrados;
    /**
     * Creates new form InterfazMenu
     * @param summaryHashTable
     * @param autoresHashTable
     * @param palabrasClaveHashTable
     * @param listaAutoresRegistrados
     */
    public InterfazMenu(HashTable summaryHashTable, HashTable autoresHashTable, HashTable palabrasClaveHashTable, Lista listaAutoresRegistrados) {
        this.summaryHashTable = summaryHashTable;
        this.autoresHashTable = autoresHashTable;
        this.palabrasClaveHashTable = palabrasClaveHashTable;
        this.listaAutoresRegistrados = listaAutoresRegistrados;
        initComponents();
        UIManager UI = new UIManager();
        UI.put("OptionPane.background", new ColorUIResource(255, 153, 102));
        UI.put("Panel.background", new ColorUIResource(255, 153, 102));
        this.setLocationRelativeTo(null);
        this.setSize(900, 687);
    }

    /**
     * Cambia el ícono de la interfaz 
     * @return el nuevo ícono
     */
    public Image getIconImage(){
        Image retvalue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/cc.png"));
        return retvalue;
    }

    /**
     * Imprime un resumen
     * @param summary el resumen a ser impreso
     * @return un stirng con el resumen deseado
     */
    public String imprimirResumen(Summary summary) {
        String cadena = "";
        cadena += summary.getTitulo() + "\n" + "\n";
        cadena += "Autores" + "\n";
        Nodo aux = summary.getAutores().getpFirst();
        for (int i = 0; i < summary.getAutores().getSize(); i++) {
           cadena += aux.getElemento() + "\n";
           aux = aux.getpNext();
        }
        cadena += "\n";
        cadena += "Resumen" + "\n";
        cadena += summary.getCuerpoResumen() + "\n" + "\n";
        cadena += "Palabras Claves: ";
        Nodo aux1 = summary.getKeyWords().getpFirst();
        for (int i = 0; i < summary.getKeyWords().getSize()- 1; i++) {
           cadena += aux1.getElemento() + ", ";
           aux1 = aux1.getpNext();
        }
        cadena += summary.getKeyWords().getpLast().getElemento() + ".";
        return cadena;
    }
    
    /**
     * Función que registra los resúmenes pasados por un txt
     */
    public void escribir_txt() {
        String cadenaDeTexto = "";
        for (int i = 0; i < this.summaryHashTable.getArrayHash().length; i++) {
            if (summaryHashTable.getArrayHash()[i] != null) {
                Lista listaAux = summaryHashTable.getArrayHash()[i];
                Nodo<Summary> aux = listaAux.getpFirst();
                while (aux != null) {
                    cadenaDeTexto += "INVESTIGACION" + "\n";
                    cadenaDeTexto += imprimirResumen(aux.getElemento());
                    cadenaDeTexto += "\n" + "\n" + "\n";
                    aux = aux.getpNext();
                }
            }
        }
        try {
            PrintWriter pw = new PrintWriter("test//resumenes_guardados.txt");
            pw.print(cadenaDeTexto);
            pw.close();
            JOptionPane.showMessageDialog(this, "Registro completado exitosamente!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al importar los datos, porfavor intente de nuevo");
        }   
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
        AgregarResumenButton = new javax.swing.JButton();
        AnalizarResumenButton = new javax.swing.JButton();
        BuscarPalabraClaveButton = new javax.swing.JButton();
        BuscarPorAutorButton = new javax.swing.JButton();
        SalirDelSistemaButton = new javax.swing.JButton();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, -1, -1));

        AgregarResumenButton.setBackground(new java.awt.Color(255, 204, 153));
        AgregarResumenButton.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N
        AgregarResumenButton.setForeground(new java.awt.Color(255, 255, 255));
        AgregarResumenButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1.png"))); // NOI18N
        AgregarResumenButton.setText("AGREGAR RESUMEN");
        AgregarResumenButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AgregarResumenButton.setOpaque(true);
        AgregarResumenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarResumenButtonActionPerformed(evt);
            }
        });
        getContentPane().add(AgregarResumenButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 470, 100));

        AnalizarResumenButton.setBackground(new java.awt.Color(255, 204, 102));
        AnalizarResumenButton.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N
        AnalizarResumenButton.setForeground(new java.awt.Color(255, 255, 255));
        AnalizarResumenButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/2.png"))); // NOI18N
        AnalizarResumenButton.setText("ANALIZAR RESUMEN");
        AnalizarResumenButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AnalizarResumenButton.setOpaque(true);
        AnalizarResumenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnalizarResumenButtonActionPerformed(evt);
            }
        });
        getContentPane().add(AnalizarResumenButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 470, 100));

        BuscarPalabraClaveButton.setBackground(new java.awt.Color(102, 153, 255));
        BuscarPalabraClaveButton.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N
        BuscarPalabraClaveButton.setForeground(new java.awt.Color(255, 255, 255));
        BuscarPalabraClaveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/3.png"))); // NOI18N
        BuscarPalabraClaveButton.setText("BUSCAR POR PALABRA CLAVE");
        BuscarPalabraClaveButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BuscarPalabraClaveButton.setOpaque(true);
        BuscarPalabraClaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarPalabraClaveButtonActionPerformed(evt);
            }
        });
        getContentPane().add(BuscarPalabraClaveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 430, 470, 100));

        BuscarPorAutorButton.setBackground(new java.awt.Color(255, 153, 102));
        BuscarPorAutorButton.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N
        BuscarPorAutorButton.setForeground(new java.awt.Color(255, 255, 255));
        BuscarPorAutorButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/4.png"))); // NOI18N
        BuscarPorAutorButton.setText("BUSCAR POR AUTOR");
        BuscarPorAutorButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BuscarPorAutorButton.setOpaque(true);
        BuscarPorAutorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarPorAutorButtonActionPerformed(evt);
            }
        });
        getContentPane().add(BuscarPorAutorButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 470, 100));

        SalirDelSistemaButton.setBackground(new java.awt.Color(0, 51, 153));
        SalirDelSistemaButton.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N
        SalirDelSistemaButton.setForeground(new java.awt.Color(255, 255, 255));
        SalirDelSistemaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/5.png"))); // NOI18N
        SalirDelSistemaButton.setText("SALIR DEL SISTEMA");
        SalirDelSistemaButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        SalirDelSistemaButton.setOpaque(true);
        SalirDelSistemaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirDelSistemaButtonActionPerformed(evt);
            }
        });
        getContentPane().add(SalirDelSistemaButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 540, 470, 90));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo Menu.png"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AgregarResumenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarResumenButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        InterfazAgregarResumen newI = new InterfazAgregarResumen(summaryHashTable, autoresHashTable, palabrasClaveHashTable, listaAutoresRegistrados);
        newI.setVisible(true);
    }//GEN-LAST:event_AgregarResumenButtonActionPerformed

    private void BuscarPalabraClaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarPalabraClaveButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        InterfazBuscarInvestigacionesPorPalabraClave newI = new InterfazBuscarInvestigacionesPorPalabraClave(summaryHashTable, autoresHashTable, palabrasClaveHashTable, listaAutoresRegistrados);
        newI.setVisible(true);
    }//GEN-LAST:event_BuscarPalabraClaveButtonActionPerformed

    private void BuscarPorAutorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarPorAutorButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        InterfazBuscarInvestigacionesPorAutor newI = new InterfazBuscarInvestigacionesPorAutor(summaryHashTable, autoresHashTable, palabrasClaveHashTable, listaAutoresRegistrados);
        newI.setVisible(true);
    }//GEN-LAST:event_BuscarPorAutorButtonActionPerformed

    private void AnalizarResumenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnalizarResumenButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        InterfazAnalizarResumen newI = new InterfazAnalizarResumen(summaryHashTable, autoresHashTable, palabrasClaveHashTable, listaAutoresRegistrados);
        newI.setVisible(true);
    }//GEN-LAST:event_AnalizarResumenButtonActionPerformed

    private void SalirDelSistemaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirDelSistemaButtonActionPerformed
        // TODO add your handling code here:
        this.escribir_txt();
        System.exit(0);
    }//GEN-LAST:event_SalirDelSistemaButtonActionPerformed

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
            java.util.logging.Logger.getLogger(InterfazMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazMenu(summaryHashTable, autoresHashTable, palabrasClaveHashTable, listaAutoresRegistrados).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarResumenButton;
    private javax.swing.JButton AnalizarResumenButton;
    private javax.swing.JButton BuscarPalabraClaveButton;
    private javax.swing.JButton BuscarPorAutorButton;
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton SalirDelSistemaButton;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
