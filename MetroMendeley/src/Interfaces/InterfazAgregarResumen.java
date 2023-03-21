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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

/**
 * Esta interfaz corresponde a la función de agregar un resumen
 *
 * @author Fabrizio Spiotta, Daniel Morillo, Georgina Akel
 */
public class InterfazAgregarResumen extends javax.swing.JFrame {

    static HashTable summaryHashTable;
    static HashTable autoresHashTable;
    static HashTable palabrasClaveHashTable;
    static Lista listaAutoresRegistrados;

    /**
     * Creates new form InterfazAgregarResumen
     *
     * @param summaryHashTable Hashtable de los resúmenes
     * @param autoresHashTable Hashtable de los autores
     * @param listaAutoresRegistrados lista de los autores registrados hasta el
     * momento
     * @param palabrasClaveHashTable Hashtable de las palabras clave
     */
    public InterfazAgregarResumen(HashTable summaryHashTable, HashTable autoresHashTable, HashTable palabrasClaveHashTable, Lista listaAutoresRegistrados) {
        this.summaryHashTable = summaryHashTable;
        this.autoresHashTable = autoresHashTable;
        this.palabrasClaveHashTable = palabrasClaveHashTable;
        this.listaAutoresRegistrados = listaAutoresRegistrados;
        initComponents();
        UIManager UI = new UIManager();
        UI.put("OptionPane.background", new ColorUIResource(255, 153, 102));
        UI.put("OptionPane.messageForeground", new ColorUIResource(255, 255, 255));
        UI.put("Panel.background", new ColorUIResource(255, 153, 102));
        this.setSize(900, 760);
        this.setLocationRelativeTo(null);
    }

    /**
     * Cambia el ícono de la interfaz
     *
     * @return el nuevo ícono
     */
    public Image getIconImage() {
        Image retvalue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/cc.png"));
        return retvalue;
    }

    /**
     * Inserta un nuevo resumen
     *
     * @param newSummary el resumen a sser insertado
     * @param nombreArticulo el nombre del artículo del resumen a ser ingresado
     * @return
     */
    public int insertarSummaryHashTable(Summary newSummary, String nombreArticulo) {
        boolean encontrado = false;
        int cont = 0;
        for (int i = 0; i < summaryHashTable.getArrayHash().length; i++) {
            Lista lista = summaryHashTable.getArrayHash()[i];
            if (lista != null) {
                Nodo<Summary> aux = lista.getpFirst();
                while (aux != null) {
                    if (Summary.class.cast(aux.getElemento()).getTitulo().equalsIgnoreCase(nombreArticulo)) {
                        encontrado = true;
                    }
                    aux = aux.getpNext();
                }
            }
        }

        if (encontrado == false) {
            this.summaryHashTable.insertar(newSummary.getTitulo(), newSummary);
        } else {
            JOptionPane.showMessageDialog(null, "EL resumen ya está registrado");
            cont++;
        }
        return cont;
    }

    /**
     * Método que inserta autores
     *
     * @param newSummary el resumen del artículo de los autores a ser ingresados
     * @param nombreAutor nombre de los autores
     */
    public static void insertarAutoresHashTable(Summary newSummary, String nombreAutor) {
        boolean encontrado = false;
        int hashIndex = autoresHashTable.hash(nombreAutor);
        Lista listaAux = autoresHashTable.getArrayHash()[hashIndex];
        if (listaAux != null) {
            encontrado = true;
        }

        if (encontrado == false) {
            autoresHashTable.insertar(nombreAutor, newSummary);
        } else {
            listaAux.AppendAtTheEnd(newSummary);
        }
    }

    /**
     * Inserta palabras clave
     *
     * @param newSummary el resumen del articulo de las palabras claves
     * ingresadas
     * @param palabraCalve las palabras clave
     */
    public static void insertarPalabrasClaveHashTable(Summary newSummary, String palabraCalve) {
        boolean encontrado = false;
        int hashIndex = palabrasClaveHashTable.hash(palabraCalve);
        Lista listaAux = palabrasClaveHashTable.getArrayHash()[hashIndex];
        if (listaAux != null) {
            encontrado = true;
        }

        if (encontrado == false) {
            palabrasClaveHashTable.insertar(palabraCalve, newSummary);
        } else {
            listaAux.AppendAtTheEnd(newSummary);
        }
    }

    /**
     * Método que insertar autores dentro de una lista de autores
     *
     * @param listaAutoresRegistrados lista de autores previa
     * @param nombreAutor nombre del autor a ser ingresado
     */
    public static void insertarListaAutoresregistrados(Lista listaAutoresRegistrados, String nombreAutor) {
        if (listaAutoresRegistrados.serachInList(nombreAutor.trim()) == false) {
            listaAutoresRegistrados.AppendOrdenadoStringsListaAutores(nombreAutor.trim());
        }
    }

    /**
     * Función que carga, lee y procesa el archivo txt que el usuario selecciono
     *
     */
    public void agregarResumen() {
        JFileChooser archivo = new JFileChooser();
        archivo.showOpenDialog(archivo);
        File file = archivo.getSelectedFile();
        if (file == null) {
            JOptionPane.showMessageDialog(null, "NO SE HA SELECCIONADO NINGÚN ARCHIVO");
        } else {
            if (!file.toString().contains("txt")) {
                JOptionPane.showMessageDialog(null, "EL ARCHIVO SELECCIONADO NO ES TXT");
            } else {
                String line;
                String texto = "";

                try {
                    if (!file.exists()) {
                        file.createNewFile();
                    } else {
                        FileReader fr = new FileReader(file);
                        BufferedReader br = new BufferedReader(fr);

                        while ((line = br.readLine()) != null) {
                            if (!line.isEmpty()) {
                                texto += line + "\n";
                            }
                        }

                        if (!"".equals(texto)) {
                            String[] textoSeparadoAutores = texto.split("Autores\n");
                            String[] nombreArticuloArray = textoSeparadoAutores[0].split("\n");
                            String nombreArticulo = nombreArticuloArray[0];
                            if (!nombreArticulo.contains(".")) {
                                nombreArticulo += ".";
                            }
                            String[] textoSeparadoResumen = textoSeparadoAutores[1].split("Resumen\n");
                            String[] autoresArray = textoSeparadoResumen[0].split("\n");
                            Lista autoresList = new Lista();
                            for (int i = 0; i < autoresArray.length; i++) {
                                String autorCadena = autoresArray[i];
                                if (autorCadena.contains("-")) {
                                    autorCadena = autorCadena.replaceAll("-", " ");
                                }
                                autoresList.AppendAtTheEnd(autorCadena);
                            }
                            String[] textoSeparadoKeyWords = textoSeparadoResumen[1].split(".\n");
                            String cuerpoResumen = textoSeparadoKeyWords[0] + ".";
                            String[] textoSeparadoDosPuntos = textoSeparadoKeyWords[1].split(": ");
                            String[] keyWordsArray = textoSeparadoDosPuntos[1].split(", ");
                            Lista keyWordsList = new Lista();
                            for (int i = 0; i < keyWordsArray.length; i++) {
                                if (keyWordsArray[i].equals("C")) {
                                    keyWordsList.AppendAtTheEnd(keyWordsArray[i] + "#");
                                } else {
                                    keyWordsList.AppendAtTheEnd(keyWordsArray[i]);
                                }
                            }

                            Summary newSummary = new Summary(nombreArticulo, autoresList, cuerpoResumen, keyWordsList);

                            int cont = this.insertarSummaryHashTable(newSummary, nombreArticulo);
                            Nodo aux = autoresList.getpFirst();
                            for (int j = 0; j < autoresList.getSize(); j++) {
                                insertarAutoresHashTable(newSummary, (String) aux.getElemento());
                                insertarListaAutoresregistrados(listaAutoresRegistrados, (String) aux.getElemento());
                                aux = aux.getpNext();
                            }
                            Nodo aux1 = keyWordsList.getpFirst();
                            for (int j = 0; j < keyWordsList.getSize(); j++) {
                                insertarPalabrasClaveHashTable(newSummary, (String) aux1.getElemento());
                                aux1 = aux1.getpNext();
                            }

                            if (cont == 0) {
                                JOptionPane.showMessageDialog(null, "LECTURA COMPLETADA");
                            }
                        }
                        br.close();
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "NO SELECCIONO NINGÚN ARCHIVO O NO SE PUDO LEER PROPORCIONADO");
                }
            }
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
        MenuButton = new javax.swing.JButton();
        AgregarResumenButton = new javax.swing.JButton();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, -1, -1));

        MenuButton.setBackground(new java.awt.Color(0, 51, 153));
        MenuButton.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N
        MenuButton.setForeground(new java.awt.Color(255, 255, 255));
        MenuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/7(60 px).png"))); // NOI18N
        MenuButton.setText("VOLVER AL MENU");
        MenuButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MenuButton.setOpaque(true);
        MenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuButtonActionPerformed(evt);
            }
        });
        getContentPane().add(MenuButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 600, 220, -1));

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
        getContentPane().add(AgregarResumenButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, 280, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo agregar.png"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        InterfazMenu menu = new InterfazMenu(summaryHashTable, autoresHashTable, palabrasClaveHashTable, listaAutoresRegistrados);
        menu.setVisible(true);
    }//GEN-LAST:event_MenuButtonActionPerformed

    private void AgregarResumenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarResumenButtonActionPerformed
        // TODO add your handling code here:
        this.agregarResumen();
    }//GEN-LAST:event_AgregarResumenButtonActionPerformed

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
            java.util.logging.Logger.getLogger(InterfazAgregarResumen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazAgregarResumen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazAgregarResumen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazAgregarResumen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazAgregarResumen(summaryHashTable, autoresHashTable, palabrasClaveHashTable, listaAutoresRegistrados).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarResumenButton;
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton MenuButton;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
