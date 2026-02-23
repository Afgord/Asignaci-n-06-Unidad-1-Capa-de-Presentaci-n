/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ecoactivistas.model;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author martinbl
 */
public class Activista {

    /**
     * Atributos de la tabla Activista
     */
    private int idActivista;
    private String nombre;
    private String telefono;
    private Date fchIngreso;

    /**
     * Constructor vacío
     */
    public Activista() {
    }

    /**
     * Constructor de la tabla Activista que recibe como parámetros sus
     * atributos
     *
     * @param idActivista
     * @param nombre
     * @param telefono
     * @param fchIngreso
     */
    public Activista(int idActivista, String nombre, String telefono, Date fchIngreso) {
        this.idActivista = idActivista;
        this.nombre = nombre;
        this.telefono = telefono;
        this.fchIngreso = fchIngreso;
    }

    /**
     * Getter de idActivista
     *
     * @return idActivista
     */
    public int getIdActivista() {
        return idActivista;
    }

    /**
     * Setter de idActivista
     *
     * @param idActivista
     */
    public void setIdActivista(int idActivista) {
        this.idActivista = idActivista;
    }

    /**
     * Getter de nombre
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter de nombre
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter de telefono
     *
     * @return telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Setter de telefono
     *
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Getter de fchIngreso
     *
     * @return fchIngreso
     */
    public Date getFchIngreso() {
        return fchIngreso;
    }

    /**
     * Setter de fchIngreso
     *
     * @param fchIngreso
     */
    public void setFchIngreso(Date fchIngreso) {
        this.fchIngreso = fchIngreso;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.idActivista;
        hash = 89 * hash + Objects.hashCode(this.nombre);
        hash = 89 * hash + Objects.hashCode(this.telefono);
        hash = 89 * hash + Objects.hashCode(this.fchIngreso);
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
        final Activista other = (Activista) obj;
        if (this.idActivista != other.idActivista) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        return Objects.equals(this.fchIngreso, other.fchIngreso);
    }

    @Override
    public String toString() {
        return "Activista{" + "idActivista=" + idActivista + ", nombre=" + nombre + ", telefono=" + telefono + ", fchIngreso=" + fchIngreso + '}';
    }

}
