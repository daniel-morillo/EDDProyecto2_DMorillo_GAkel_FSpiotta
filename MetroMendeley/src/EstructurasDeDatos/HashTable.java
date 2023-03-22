/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

import Clases.Summary;

/**
 * Esta classe integra la estructura de datos de una HashTable
 * @author Daniel Morillo, Fabrizio Spiotta, Georgina Akel
 * @param <T>
 */
public class HashTable<T> {
    
    private Lista[] arrayHash;
    private int size;

    /**
     * Constructor de la clase
     * @param size tamaño a ser definido en la hash table
     */
    public HashTable(int size) {
        this.size = size;
        this.arrayHash = new Lista[size];
    }
    
    /**
     * Método que pone en mayúscula la primera letra de una palabra
     * @param palabra palabra a ser editada
     * @return palabra capitalizada
     */
    public String capitalizeTitle(String palabra) {  
        String words[]= palabra.split("\\s");  
        String capitalizeWord="";  
        for(String w:words){  
            String first = w.substring(0,1);  
            String afterfirst = w.substring(1);  
            capitalizeWord += first.toUpperCase() + afterfirst.toLowerCase() + " ";  
        }  
        return capitalizeWord.trim();  
    }
    
    /**
     * Método para obtener el valor ASCII de una palabra sumando los valores de sus letras
     * @param name Palabra a obtener el valor ASCII
     * @return suma de los valores ASCII de las letras de una palabra
     */
    public int getAsciiValue(String name){
        int suma = 0;
        String [] array = name.split(" ");
        for (int i = 0; i < array[0].length(); i++) {
            char character = array[0].charAt(i);
            int ascii = (int) character;
            suma += ascii;
        }
        return suma;
    }
    
    /**
     * Método que le asigna un valor hash para la HashTable a un String dado
     * @param n String al cual se le asigna el valor del hash
     * @return valor del hash del texto introducido
     */
    public int hash(String n){
        int clave;
        String palabra = this.capitalizeTitle(n);
        clave = getAsciiValue(palabra) % getSize();
        return clave;
    }
    
    /**
     * Método que inserta determinado valor a la hashtable
     * @param key Corresponde a un valor que se pasa para obtenerle el valor del hash
     * @param valor corresponde a la información que se quiere introducir en la hashtable
     */
    public void insertar(String key, T valor){
        int hashindex = hash(key);
        Lista subLista = new Lista();
        subLista.AppendAtTheEnd(valor);
        Lista valorArreglo = getArrayHash()[hashindex];
        if (valorArreglo != null) {
            valorArreglo.AppendAtTheEnd(valor);
        } else {
            getArrayHash()[hashindex] = subLista;
        }
    } 
    
    /**
     * Método que obtiene un valor que se encuentra en la hashtable
     * @param key valor que fue seleccionado a la hora de introducir el valor a la hashtable
     * @return el valor buscado
     */
    public T obtener(String key){
        T valor = null;
        int hashindex = hash(key);
        Lista valorarreglo = getArrayHash()[hashindex];
        Nodo<Summary> aux = valorarreglo.getpFirst();
        if (valorarreglo != null) {
            while(aux != null){
                if (aux.getElemento().getTitulo().equalsIgnoreCase(key)){
                    valor = (T) aux.getElemento();
                    break;
                }
                aux = aux.getpNext();
            }
        }
        return valor;  
    }
    
    /**
     * Método que obtiene un valor que se encuentra en la hashtable por su valor hash
     * @param hash valor hash que sse le asignó al valor introducido
     * @return el valor buscado
     */
    public Lista obtenerPorHash(int hash) {
        Lista valorArreglo = getArrayHash()[hash];
        Lista newList = new Lista();
        Nodo<Summary> aux = valorArreglo.getpFirst();
        while(aux != null) {
            newList.AppendAtTheEnd(valorArreglo);
            aux = aux.getpNext();
        }  
        return newList;
    }
    
    /**
     * Método que obtiene los autores de un resumen articulo introducido en la hashtable
     * @param key valor que fue seleccionado a la hora de introducir el valor a la hashtable
     * @return autores del artículo
     */
    public Lista obtenerAutores(String key) {
        int hashindex = hash(key);
        Lista valorArreglo = getArrayHash()[hashindex];
        Lista newList = new Lista();
        if (valorArreglo != null) {
            Nodo<Summary> aux = valorArreglo.getpFirst();
            while(aux != null) {
                Nodo<String> aux2 = aux.getElemento().getAutores().getpFirst();
                for (int i = 0; i < aux.getElemento().getAutores().getSize(); i++) {
                    if (aux2.getElemento().trim().equalsIgnoreCase(key)) {
                        newList.AppendAtTheEnd(aux.getElemento());
                    }
                    aux2 = aux2.getpNext();
                }
                aux = aux.getpNext();
            }
        }
        return newList;
    }
    
    /**
     * Obtiene las palabras clave de un artículo introducido en la hashtable
     * @param key valor que fue seleccionado a la hora de introducir el valor a la hashtable
     * @return las palabras claves del articulo
     */
    public Lista obtenerPalabraClave(String key) {
        int hashindex = hash(key);
        Lista valorArreglo = getArrayHash()[hashindex];
        Lista newList = new Lista();
        if (valorArreglo!= null) {
            Nodo<Summary> aux = valorArreglo.getpFirst();
            while(aux != null) {
                Nodo<String> aux2 = aux.getElemento().getKeyWords().getpFirst();
                for (int i = 0; i < aux.getElemento().getKeyWords().getSize(); i++) {
                    if (aux2.getElemento().trim().equalsIgnoreCase(key)) {
                        newList.AppendAtTheEnd(aux.getElemento());
                    }
                    aux2 = aux2.getpNext();
                }
                aux = aux.getpNext();
            } 
        }
        return newList;
    }

    /**
     * Obtiene los hash de un array
     * @return la lista de los hash del array
     */
    public Lista[] getArrayHash() {
        return arrayHash;
    }

    /**
     * Establece una lista de hash´s de un array
     * @param arrayHash los hash para el array a ser establecido
     */
    public void setArrayHash(Lista[] arrayHash) {
        this.arrayHash = arrayHash;
    }

    /**
     * Obtiene el tamaño de la hashtable
     * @return el tamaño
     */
    public int getSize() {
        return size;
    }

    /**
     * Establece el tamaño de la hashtable
     * @param size el tamaño a ser establecido
     */
    public void setSize(int size) {
        this.size = size;
    }   
}
