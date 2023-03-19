/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import EstructurasDeDatos.HashTable;
import EstructurasDeDatos.Lista;
import EstructurasDeDatos.Nodo;
import Interfaces.InterfazInicial;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

/**
 * Esta clase contiene el main que la da inicio a todo el proyecto, pre-cargando los resumenes guardados anteriormente en el programa
 * @author Fabrizio Spiotta, Georgina Akel, Daniel Morillo
 */
public class Main {
    /**
     * Método que inserta un resumen a una hashtbale dada
     * @param summaryHashTable la hashtable en la cual se insertará el resumen
     * @param newSummary el nuevo resumen
     * @param nombreArticulo el nombre del artículo
     */
     
    public static void insertarSummaryHashTable(HashTable summaryHashTable, Summary newSummary, String nombreArticulo) {
        boolean encontrado = false;
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
            summaryHashTable.insertar(newSummary.getTitulo(), newSummary);
        } else {
            JOptionPane.showMessageDialog(null, "EL resumen ya esta registrado");
        }
    }
    
    /**
     * Método que inserta autores dentro de una hashtable
     * @param autoresHashTable La hashtable de los autores
     * @param newSummary el resumen del artículo de los autores a ser ingresados
     * @param nombreAutor nombre de los autores
     */
    public static void insertarAutoresHashTable(HashTable autoresHashTable, Summary newSummary, String nombreAutor) {
        boolean encontrado = false;
        int hashIndex = autoresHashTable.hash(nombreAutor);
        Lista listaAux = autoresHashTable.getArrayHash()[hashIndex];
        if (listaAux != null) {
            encontrado = true;
        } 

        if (encontrado == false) {
            autoresHashTable.insertar(nombreAutor, newSummary);
        } else {
            if (listaAux.existeEnLaLista(newSummary) == false) {
                listaAux.AppendAtTheEnd(newSummary);
            }
        }
    }
    
    /**
     * Método que inserta palabras clave dentro de una hashtable
     * @param palabrasClaveHashTable la hashtable de las palabras clave
     * @param newSummary el resumen del artículo de las palabras clave a ser ingresadas
     * @param palabraCalve las palabras clave
     */
    public static void insertarPalabrasClaveHashTable(HashTable palabrasClaveHashTable, Summary newSummary, String palabraCalve) {
        boolean encontrado = false;
        int hashIndex = palabrasClaveHashTable.hash(palabraCalve);
        Lista listaAux = palabrasClaveHashTable.getArrayHash()[hashIndex];
        if (listaAux != null) {
            encontrado = true;
        } 

        if (encontrado == false) {
            palabrasClaveHashTable.insertar(palabraCalve, newSummary);
        } else {
            if (listaAux.existeEnLaLista(newSummary) == false) {
                listaAux.AppendAtTheEnd(newSummary);
            }
        }
    }
    
    /**
     * Método que insertar autores dentro de una lista de autores
     * @param listaAutoresRegistrados lista de autores previa
     * @param nombreAutor nombre del autor a ser ingresado
     */
    public  static void insertarListaAutoresregistrados(Lista listaAutoresRegistrados, String nombreAutor) {
        if (listaAutoresRegistrados.serachInList(nombreAutor.trim()) == false) {
            listaAutoresRegistrados.AppendOrdenadoStringsListaAutores(nombreAutor.trim());
        }
    }
    
    /**
     * Método que lee determinado TXT seleccionado por el usuario
     * @param summaryHashTable la hashtable de los resúemenes
     * @param autoresHashTable la hashtable de los autores
     * @param palabrasClaveHashTable la hashtable de las palabras clave
     * @param listaAutoresRegistrados la lista de los autores registrados 
     */
    public static void leerTxtGuardado(HashTable summaryHashTable, HashTable autoresHashTable, HashTable palabrasClaveHashTable, Lista listaAutoresRegistrados){
        String path = "test//resumenes_guardados.txt";
        File file = new File(path);
        
        if (!file.toString().contains("txt")) {
            JOptionPane.showMessageDialog(null, "EL ARCHIVO SELECCIONADO NO ES TXT");
        } else {
            String line;
            String texto = "";

            try { 
                if (!file.exists()){
                    file.createNewFile();
                } else {               
                    FileReader fr = new FileReader(file);
                    BufferedReader br = new BufferedReader(fr);

                    while((line = br.readLine()) != null){
                        if (!line.isEmpty()) {
                            texto += line + "\n";
                        }    
                    }

                    if (!"".equals(texto)) {
                        String [] textoSeparadoGrande = texto.split("INVESTIGACION\n");
                        for (int i = 1; i < textoSeparadoGrande.length; i++) {
                            String [] textoSeparadoAutores = textoSeparadoGrande[i].split("Autores\n");
                            String [] nombreArticuloArray = textoSeparadoAutores[0].split("\n");
                            String nombreArticulo = nombreArticuloArray[0];
                            if (!nombreArticulo.contains(".")) {
                                nombreArticulo += ".";
                            }
                            String [] textoSeparadoResumen = textoSeparadoAutores[1].split("Resumen\n");
                            String [] autoresArray = textoSeparadoResumen[0].split("\n");
                            Lista autoresList = new Lista();
                            for (int j = 0; j < autoresArray.length; j++) {
                                autoresList.AppendAtTheEnd(autoresArray[j]);
                            }
                            String [] textoSeparadoKeyWords = textoSeparadoResumen[1].split(".\n");
                            String cuerpoResumen = textoSeparadoKeyWords[0] + ".";
                            String [] textoSeparadoDosPuntos = textoSeparadoKeyWords[1].split(": ");
                            String [] keyWordsArray = textoSeparadoDosPuntos[1].split(", ");
                            Lista keyWordsList = new Lista();
                            for (int j = 0; j < keyWordsArray.length; j++) {
                                if (keyWordsArray[i].equals("C")) {
                                    keyWordsList.AppendAtTheEnd(keyWordsArray[j] + "#");
                                } else {
                                    keyWordsList.AppendAtTheEnd(keyWordsArray[j]);
                                }   
                            }

                            Summary newSummary = new Summary(nombreArticulo, autoresList, cuerpoResumen, keyWordsList);

                            insertarSummaryHashTable(summaryHashTable, newSummary, nombreArticulo);
                            Nodo aux = autoresList.getpFirst();
                            for (int j = 0; j < autoresList.getSize(); j++) {
                                insertarAutoresHashTable(autoresHashTable, newSummary, (String) aux.getElemento());
                                insertarListaAutoresregistrados(listaAutoresRegistrados, (String) aux.getElemento());
                                aux = aux.getpNext();
                            }
                            Nodo aux1 = keyWordsList.getpFirst();
                            for (int j = 0; j < keyWordsList.getSize(); j++) {
                                insertarPalabrasClaveHashTable(palabrasClaveHashTable, newSummary, (String) aux1.getElemento());
                                aux1 = aux1.getpNext();
                            }
                        }
                        JOptionPane.showMessageDialog(null, "LECTURA COMPLETADA");
                    }
                    br.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "NO SELECCIONO NINGUN ARCHIVO O NO SE PUDO LEER PROPORCIONADO");
            }
        }
    }
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {  
        UIManager UI = new UIManager();
        UI.put("OptionPane.background", new ColorUIResource(255, 153, 102));
        UI.put("OptionPane.messageForeground", new ColorUIResource(255, 255, 255));
        UI.put("Panel.background", new ColorUIResource(255, 153, 102));
        HashTable summaryHashTable = new HashTable(23);
        HashTable autoresHashTable = new HashTable(31);
        HashTable palabrasClaveHashTable = new HashTable(53);
        Lista listaAutoresRegistrados = new Lista();
        leerTxtGuardado(summaryHashTable, autoresHashTable, palabrasClaveHashTable, listaAutoresRegistrados);
        InterfazInicial main = new InterfazInicial(summaryHashTable, autoresHashTable, palabrasClaveHashTable, listaAutoresRegistrados);
        main.show();
    }
}
