/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ecoactivistas.model;

/**
 *
 * @author martinbl
 */
public class ProblemaActivista {

    //Atributos para la tabla de relación Problema y Activista (N:M). Los usamos como una pk combinada, así
    // como FKs a sus respectivas tablas.
    private int idProblema;
    private int idActivista;

    // Constructor vacio
    public ProblemaActivista() {
    }

    /**
     * Constructor que recibe dos parámetros, ambos IDs
     *
     * @param idProblema FK de tabla Problema
     * @param idActivista FK de tabla Activista
     */
    public ProblemaActivista(int idProblema, int idActivista) {
        this.idProblema = idProblema;
        this.idActivista = idActivista;
    }

    /**
     * Getter de IdProblema
     *
     * @return idProblema
     */
    public int getIdProblema() {
        return idProblema;
    }

    /**
     * Setter IdProblema
     *
     * @param idProblema
     */
    public void setIdProblema(int idProblema) {
        this.idProblema = idProblema;
    }

    /**
     * Getter de IdActivista
     *
     * @return idActivista
     */
    public int getIdActivista() {
        return idActivista;
    }

    /**
     * Setter IdProblema
     *
     * @param idActivista
     */
    public void setIdActivista(int idActivista) {
        this.idActivista = idActivista;
    }

    @Override
    public String toString() {
        return "ProblemaActivista{" + "idProblema=" + idProblema + ", idActivista=" + idActivista + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idProblema;
        hash = 97 * hash + this.idActivista;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProblemaActivista other = (ProblemaActivista) obj;
        if (this.idProblema != other.idProblema) {
            return false;
        }
        return this.idActivista == other.idActivista;
    }

}
