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
public class Problema {

    /**
     * Atributos de la tabla Problema
     */
    private int idProblema;
    private String descripcion;
    private Date fchIni;
    private Date fchFin;
    private String estado;// pendiente, concluido, cancelado
    private int idCliente;   // FK hacia Cliente

    /**
     * Constructor vacío
     */
    public Problema() {
    }

    /**
     * Constructor del objeto Problema que recibe como parámetros los atributos
     * de la tabla Problema.
     *
     * @param idProblema
     * @param descripcion
     * @param fchIni
     * @param fchFin
     * @param estado
     * @param idCliente
     *
     */
    public Problema(int idProblema, String descripcion, Date fchIni, Date fchFin, String estado, int idCliente) {
        this.idProblema = idProblema;
        this.descripcion = descripcion;
        this.fchIni = fchIni;
        this.fchFin = fchFin;
        this.estado = estado;
        this.idCliente = idCliente;
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
     * Setter de IdProblema
     *
     * @param idProblema
     */
    public void setIdProblema(int idProblema) {
        this.idProblema = idProblema;
    }

    /**
     * Getter de Descripcion
     *
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Setter de descripcion
     *
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Getter de chIni
     *
     * @return fchIni
     */
    public Date getFchIni() {
        return fchIni;
    }

    /**
     * Setter de fchIni
     *
     * @param fchIni
     */
    public void setFchIni(Date fchIni) {
        this.fchIni = fchIni;
    }

    /**
     * Getter de fchFin
     *
     * @return fchFin
     */
    public Date getFchFin() {
        return fchFin;
    }

    /**
     * Setter de fchFin
     *
     * @param fchFin
     */
    public void setFchFin(Date fchFin) {
        this.fchFin = fchFin;
    }

    /**
     * Getter de estado
     *
     * @return estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Setter de estado
     *
     * @param estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Getter de IdCliente
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + this.idProblema;
        hash = 43 * hash + Objects.hashCode(this.fchIni);
        hash = 43 * hash + Objects.hashCode(this.fchFin);
        hash = 43 * hash + Objects.hashCode(this.estado);
        hash = 43 * hash + this.idCliente;
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
        final Problema other = (Problema) obj;
        if (this.idProblema != other.idProblema) {
            return false;
        }
        if (this.idCliente != other.idCliente) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.fchIni, other.fchIni)) {
            return false;
        }
        return Objects.equals(this.fchFin, other.fchFin);
    }

    @Override
    public String toString() {
        return "Problema{" + "idProblema=" + idProblema + ",descripcion=" + descripcion + ", fchIni=" + fchIni + ", fchFin=" + fchFin + ", estado=" + estado + ", idCliente=" + idCliente + '}';
    }

}
