/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import EstructurasDeDatos.Lista;

/**
 * Clase que corresponde a los resúmenes del proyecto
 * @author Daniel Morillo, Fabrizio Spiotta, Georgina Akel
 */
public class Summary {
    
    private String titulo;
    private Lista autores;
    private String cuerpoResumen;
    private Lista keyWords;

    /**
     * Constructor
     * @param titulo titulo del articulo
     * @param autores autores del articulo
     * @param cuerpoResumen el escrito del resumen
     * @param keyWords las palabras claves
     */
    public Summary(String titulo, Lista autores, String cuerpoResumen, Lista keyWords) {
        this.titulo = titulo;
        this.autores = autores;
        this.cuerpoResumen = cuerpoResumen;
        this.keyWords = keyWords;
    }

    /**
     * Obtiene el titulo del articulo
     * @return el titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * establece el título del artículo
     * @param titulo el artículo a ser establecido
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene los autores del artículo
     * @return los autores
     */
    public Lista getAutores() {
        return autores;
    }

    /**
     * Establece los autores de un artículo
     * @param autores los autores a ser establecidos
     */
    public void setAutores(Lista autores) {
        this.autores = autores;
    }

    /**
     * Obtiene el contenido de un resumen
     * @return el cuerpo del resumen
     */
    public String getCuerpoResumen() {
        return cuerpoResumen;
    }

    /**
     * Establece el cuerpo de un resumen
     * @param cuerpoResumen el cuerpo del resumen a ser establecido
     */
    public void setCuerpoResumen(String cuerpoResumen) {
        this.cuerpoResumen = cuerpoResumen;
    }

    /**
     * Obtiene las palabras clave de un artículo
     * @return the keyWords
     */
    public Lista getKeyWords() {
        return keyWords;
    }

    /**
     * Establece las palabras clave de un artículo
     * @param keyWords las palabras clave a ser establecidas
     */
    public void setKeyWords(Lista keyWords) {
        this.keyWords = keyWords;
    }
    
    
    
           
    
}
