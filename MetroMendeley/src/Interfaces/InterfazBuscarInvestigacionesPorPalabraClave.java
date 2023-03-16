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
import javax.swing.JOptionPane;

/**
 *
 * @author fabriziospiotta
 */
public class InterfazBuscarInvestigacionesPorPalabraClave extends javax.swing.JFrame {
    
    static HashTable summaryHashTable;
    static HashTable autoresHashTable;
    static HashTable palabrasClaveHashTable;
    /**
     * Creates new form InterfazBuscarInvestigacionesPorPalabraClave
     */
    public InterfazBuscarInvestigacionesPorPalabraClave(HashTable summaryHashTable, HashTable autoresHashTable, HashTable palabrasClaveHashTable) {
        this.summaryHashTable = summaryHashTable;
        this.autoresHashTable = autoresHashTable;
        this.palabrasClaveHashTable = palabrasClaveHashTable;
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public Image getIconImage(){
        Image retvalue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/cc.png"));
        return retvalue;
    }
    
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
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        MenuButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        SeleccionTextArea = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        VerDetallesButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        MostrarAnalisisTextArea = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        SelectWordTextArea = new javax.swing.JTextArea();
        BuscarInvButton = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        MostrarInvRelacionadasTextArea = new javax.swing.JTextArea();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, -1, -1));

        MenuButton.setBackground(new java.awt.Color(0, 51, 153));
        MenuButton.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 14)); // NOI18N
        MenuButton.setForeground(new java.awt.Color(255, 255, 255));
        MenuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/7(60 px).png"))); // NOI18N
        MenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuButtonActionPerformed(evt);
            }
        });
        getContentPane().add(MenuButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 630, 60, 60));

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Escriba una palabra clave para buscar ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, -1, -1));

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("las investigaciones relacionadas");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, -1, -1));

        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        SeleccionTextArea.setBackground(new java.awt.Color(102, 153, 255));
        SeleccionTextArea.setColumns(20);
        SeleccionTextArea.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 12)); // NOI18N
        SeleccionTextArea.setForeground(new java.awt.Color(255, 255, 255));
        SeleccionTextArea.setRows(5);
        jScrollPane3.setViewportView(SeleccionTextArea);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, 350, 50));

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("(Titulo completo como aparece en el registro)");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, -1, -1));

        jLabel4.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Escriba el nombre de la investigacion que desea ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, -1, -1));

        VerDetallesButton.setBackground(new java.awt.Color(102, 153, 255));
        VerDetallesButton.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N
        VerDetallesButton.setForeground(new java.awt.Color(255, 255, 255));
        VerDetallesButton.setText("SELECCIONAR INVESTIGACIÓN Y VER DETALLES");
        VerDetallesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerDetallesButtonActionPerformed(evt);
            }
        });
        getContentPane().add(VerDetallesButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, -1, -1));

        MostrarAnalisisTextArea.setEditable(false);
        MostrarAnalisisTextArea.setBackground(new java.awt.Color(0, 51, 91));
        MostrarAnalisisTextArea.setColumns(20);
        MostrarAnalisisTextArea.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 12)); // NOI18N
        MostrarAnalisisTextArea.setForeground(new java.awt.Color(255, 255, 255));
        MostrarAnalisisTextArea.setRows(5);
        jScrollPane4.setViewportView(MostrarAnalisisTextArea);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 300, 350, 320));

        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        SelectWordTextArea.setBackground(new java.awt.Color(102, 153, 255));
        SelectWordTextArea.setColumns(20);
        SelectWordTextArea.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 12)); // NOI18N
        SelectWordTextArea.setForeground(new java.awt.Color(255, 255, 255));
        SelectWordTextArea.setRows(5);
        jScrollPane5.setViewportView(SelectWordTextArea);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 350, 50));

        BuscarInvButton.setBackground(new java.awt.Color(102, 153, 255));
        BuscarInvButton.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N
        BuscarInvButton.setForeground(new java.awt.Color(255, 255, 255));
        BuscarInvButton.setText("BUSCAR INVESTIGACIONES RELACIONADAS");
        BuscarInvButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarInvButtonActionPerformed(evt);
            }
        });
        getContentPane().add(BuscarInvButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, -1));

        MostrarInvRelacionadasTextArea.setEditable(false);
        MostrarInvRelacionadasTextArea.setBackground(new java.awt.Color(0, 51, 91));
        MostrarInvRelacionadasTextArea.setColumns(20);
        MostrarInvRelacionadasTextArea.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 12)); // NOI18N
        MostrarInvRelacionadasTextArea.setForeground(new java.awt.Color(255, 255, 255));
        MostrarInvRelacionadasTextArea.setRows(5);
        jScrollPane6.setViewportView(MostrarInvRelacionadasTextArea);

        getContentPane().add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 350, 320));

        Fondo.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 14)); // NOI18N
        Fondo.setForeground(new java.awt.Color(255, 255, 255));
        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo palabra.png"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, -1, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        InterfazMenu menu = new InterfazMenu(summaryHashTable, autoresHashTable, palabrasClaveHashTable);
        menu.setVisible(true);
    }//GEN-LAST:event_MenuButtonActionPerformed

    private void VerDetallesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerDetallesButtonActionPerformed
        // TODO add your handling code here:
        if (SeleccionTextArea.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "El campo esta vacio, porfavor escriba el nombre de la investigacion a seleccionar");
        } else {
            String cadenaForPrint = "";
            String Nombre = SeleccionTextArea.getText();
            if (!Nombre.contains(".")) {
                Nombre += ".";
            }
            if (SelectWordTextArea.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Porfavor ingrese en el campo de arriba a la izquierda, el nombre de la palabra clave de la investigación que desea, para validar los detalles del resumen que se debe mostrar");
            } else {
                Lista listaInvestigacionesEncontradas = palabrasClaveHashTable.obtenerPalabraClave(SelectWordTextArea.getText());
                Nodo<Summary> aux = listaInvestigacionesEncontradas.getpFirst();
                Summary resumenEncontrado = null;
                for (int i = 0; i < listaInvestigacionesEncontradas.getSize(); i++) {
                    if (aux.getElemento().getTitulo().equalsIgnoreCase(Nombre)) {
                        resumenEncontrado = (Summary) this.summaryHashTable.obtener(Nombre);
                    }
                    aux = aux.getpNext();
                }
                if (resumenEncontrado == null) {
                    JOptionPane.showMessageDialog(null, "La investigacion seleccionada no se ha encontrado en el registro. (Asegurese de haber colocado los acentos, en caso de que el titulo los tenga)");
                } else {
                    String [] cuerpoResumenSeparado = resumenEncontrado.getCuerpoResumen().replaceAll("\\p{Punct}", "").split(" ");

                    cadenaForPrint += resumenEncontrado.getTitulo() + "\n" + "\n";
                    cadenaForPrint += "Autores: ";
                    Nodo auxiliar = resumenEncontrado.getAutores().getpFirst();
                    for (int i = 0; i < resumenEncontrado.getAutores().getSize() - 1; i++) {
                        cadenaForPrint += auxiliar.getElemento() + ", ";
                        auxiliar = auxiliar.getpNext();
                    }
                    cadenaForPrint += resumenEncontrado.getAutores().getpLast().getElemento() + "\n" + "\n";
                    cadenaForPrint += "Palabras claves son sus respectivas cantidades de repeticion en la investigacion:" + "\n" + "\n";
                    Nodo aux1 = resumenEncontrado.getKeyWords().getpFirst();
                    for (int i = 0; i < resumenEncontrado.getKeyWords().getSize(); i++) {
                        int cont = 0;
                        for (int j = 0; j < cuerpoResumenSeparado.length; j++) {
                            String [] auxDesplazado = String.class.cast(aux1.getElemento()).split(" ");
                            if (auxDesplazado.length == 1) {
                                if (cuerpoResumenSeparado[j].equalsIgnoreCase((String) aux1.getElemento())) {
                                    cont += 1;
                                }
                            } else {
                                int contadorCheckin = 0;
                                if (cuerpoResumenSeparado[j].equalsIgnoreCase(auxDesplazado[0])) {
                                    contadorCheckin +=1;
                                    for (int k = 1; k < auxDesplazado.length; k++) {
                                        if (cuerpoResumenSeparado[j + k].equalsIgnoreCase(auxDesplazado[k])) {
                                            contadorCheckin +=1;
                                        }
                                    }
                                }
                                if (contadorCheckin == auxDesplazado.length) {
                                    cont += 1;
                                }
                            }
                        }
                        cadenaForPrint += aux1.getElemento() + " --> " + Integer.toString(cont);
                        cadenaForPrint += "\n";
                        aux1 = aux1.getpNext();
                    }
                    MostrarAnalisisTextArea.setLineWrap(true);
                    MostrarAnalisisTextArea.setWrapStyleWord(true);
                    MostrarAnalisisTextArea.setText(cadenaForPrint);
                }
            }
        }
    }//GEN-LAST:event_VerDetallesButtonActionPerformed

    private void BuscarInvButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarInvButtonActionPerformed
        // TODO add your handling code here:
        String palabraClaveSelected = SelectWordTextArea.getText();
        if (palabraClaveSelected.equals("")) {
            JOptionPane.showMessageDialog(null, "El campo esta vacio, porfavor escriba el nombre de la investigacion a seleccionar");
        } else {
            String cadenaForPrint = "";
            Lista listaInvestigacionesEncontradas = palabrasClaveHashTable.obtenerPalabraClave(palabraClaveSelected);
            if (!listaInvestigacionesEncontradas.isEmpty()) {
                Nodo<Summary> aux = listaInvestigacionesEncontradas.getpFirst();
                for (int i = 1; i < listaInvestigacionesEncontradas.getSize() + 1; i++) {
                    cadenaForPrint += "INVESTIGACION #" + Integer.toString(i) +"--> " + "\n";
                    cadenaForPrint += imprimirResumen(aux.getElemento());
                    cadenaForPrint += "\n" + "\n" + "\n";
                    aux = aux.getpNext();
                }
                MostrarInvRelacionadasTextArea.setLineWrap(true);
                MostrarInvRelacionadasTextArea.setWrapStyleWord(true);
                MostrarInvRelacionadasTextArea.setText(cadenaForPrint);    
            } else {
                JOptionPane.showMessageDialog(null, "No se ha encontrado ninguna investigacion a nombre de la palabra clave proporcionada. (Asegurese de haber colocado los acentos, en caso de que la palabra los tenga)");
            }
            
        }
    }//GEN-LAST:event_BuscarInvButtonActionPerformed

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
            java.util.logging.Logger.getLogger(InterfazBuscarInvestigacionesPorPalabraClave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazBuscarInvestigacionesPorPalabraClave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazBuscarInvestigacionesPorPalabraClave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazBuscarInvestigacionesPorPalabraClave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazBuscarInvestigacionesPorPalabraClave(summaryHashTable, autoresHashTable, palabrasClaveHashTable).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BuscarInvButton;
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton MenuButton;
    private javax.swing.JTextArea MostrarAnalisisTextArea;
    private javax.swing.JTextArea MostrarInvRelacionadasTextArea;
    private javax.swing.JTextArea SeleccionTextArea;
    private javax.swing.JTextArea SelectWordTextArea;
    private javax.swing.JButton VerDetallesButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    // End of variables declaration//GEN-END:variables
}
