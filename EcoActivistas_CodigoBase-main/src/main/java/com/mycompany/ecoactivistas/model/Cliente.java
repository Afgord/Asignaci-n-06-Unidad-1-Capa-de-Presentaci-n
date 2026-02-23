/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ecoactivistas.model;

import java.util.Objects;

/**
 *
 * @author martinbl
 */
public class Cliente {

    /**
     * Atributos de la tabla Cliente
     */
    private int idCliente;
    private String nombre;
    private String direccion;
    private String telefonos;

    /**
     * Constructor vacío
     */
    public Cliente() {
    }

    /**
     * Constructor que recibe como parámetros los atributos de la clase Cliente
     *
     * @param idCliente
     * @param nombre
     * @param direccion
     * @param telefonos
     */
    public Cliente(int idCliente, String nombre, String direccion, String telefonos) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefonos = telefonos;
    }

    /**
     * Getter de idCliente
     *
     * @return idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Setter de idCliente
     *
     * @param idCliente
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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
     * Getter de direccion
     *
     * @return direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Setter de direccion
     *
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Getter de telefonos
     *
     * @return telefonos
     */
    public String getTelefonos() {
        return telefonos;
    }

    /**
     * Setter de telefonos
     *
     * @param telefonos
     */
    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.idCliente;
        hash = 17 * hash + Objects.hashCode(this.nombre);
        hash = 17 * hash + Objects.hashCode(this.direccion);
        hash = 17 * hash + Objects.hashCode(this.telefonos);
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
        final Cliente other = (Cliente) obj;
        if (this.idCliente != other.idCliente) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        return Objects.equals(this.telefonos, other.telefonos);
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nombre=" + nombre + ", direccion=" + direccion + ", telefonos=" + telefonos + '}';
    }

}
