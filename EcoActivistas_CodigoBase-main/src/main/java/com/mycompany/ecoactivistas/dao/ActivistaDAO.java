/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ecoactivistas.dao;

import com.mycompany.ecoactivistas.config.ConexionDB;
import com.mycompany.ecoactivistas.interfaces.IActivistaDAO;
import com.mycompany.ecoactivistas.model.Activista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author martinbl
 */
public class ActivistaDAO implements IActivistaDAO {

    @Override
    /**
     * Método Insertar que recibe como parámetro un objeto de tipo Activista que
     * permitirá dar de alta nuevos activistas en la BD.
     *
     * @param activista
     */
    public boolean insertar(Activista activista) {
        String sql = "INSERT INTO Activista (nombre, telefono, fchIngreso) VALUES (?, ?, ?)";
        try (Connection conn = ConexionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, activista.getNombre());
            ps.setString(2, activista.getTelefono());
            ps.setDate(3, activista.getFchIngreso());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al insertar activista: " + e.getMessage());
            return false;
        }
    }

    @Override
    /**
     * Método obtenerPorId que recibe como parámetro el id de un activista (int)
     * lo que permitirá buscar un activista existente en la BD con sus
     * respectivos datos (atributos).
     *
     * @param idActivista
     */
    public Activista obtenerPorId(int idActivista) {
        String sql = "SELECT idActivista, nombre, telefono, fchIngreso FROM Activista WHERE idActivista = ? LIMIT 100";
        Activista activista = null;

        try (Connection conn = ConexionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idActivista);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                activista = new Activista();
                activista.setIdActivista(rs.getInt("idActivista"));
                activista.setNombre(rs.getString("nombre"));
                activista.setTelefono(rs.getString("telefono"));
                activista.setFchIngreso(rs.getDate("fchIngreso"));
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener activista por ID: " + e.getMessage());
        }
        return activista;
    }

    @Override
    /**
     * Método obtenerTodos que permitirá buscar y mostrar todos los activistas
     * existentes en la BD con sus respectivos datos (atributos).
     */
    public List<Activista> obtenerTodos() {
        String sql = "SELECT idActivista, nombre, telefono, fchIngreso FROM Activista LIMIT 100";
        List<Activista> lista = new ArrayList<>();

        try (Connection conn = ConexionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Activista activista = new Activista();
                activista.setIdActivista(rs.getInt("idActivista"));
                activista.setNombre(rs.getString("nombre"));
                activista.setTelefono(rs.getString("telefono"));
                activista.setFchIngreso(rs.getDate("fchIngreso"));
                lista.add(activista);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener todos los activistas: " + e.getMessage());
        }
        return lista;
    }

    @Override
    /**
     * Método obtenerTodosPorFiltro que recibe como parámetro un String como
     * filtro para buscar un activista existente en la BD con sus respectivos
     * datos (atributos).
     *
     * @param filtro
     */
    public List<Activista> obtenerTodosPorFiltro(String filtro) {
        String sql = "SELECT idActivista, nombre, telefono, fchIngreso FROM Activista WHERE nombre LIKE ? LIMIT 100";
        List<Activista> lista = new ArrayList<>();

        try (Connection conn = ConexionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + filtro + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Activista activista = new Activista();
                activista.setIdActivista(rs.getInt("idActivista"));
                activista.setNombre(rs.getString("nombre"));
                activista.setTelefono(rs.getString("telefono"));
                activista.setFchIngreso(rs.getDate("fchIngreso"));
                lista.add(activista);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener activistas por filtro: " + e.getMessage());
        }

        return lista;
    }

    @Override
    /**
     * Método actualizar que recibe como parámetro un objeto de tipo Activista
     * lo que permitirá buscar un activista existente en la BD y actualizar sus
     * atributos..
     *
     * @param activista
     */
    public boolean actualizar(Activista activista) {
        String sql = "UPDATE Activista SET nombre = ?, telefono = ?, fchIngreso = ? WHERE idActivista = ?";
        try (Connection conn = ConexionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, activista.getNombre());
            ps.setString(2, activista.getTelefono());
            ps.setDate(3, activista.getFchIngreso());
            ps.setInt(4, activista.getIdActivista());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al actualizar activista: " + e.getMessage());
            return false;
        }
    }

    @Override
    /**
     * Método eliminar que recibe como parámetro el id de un Activista lo que
     * permitirá buscar un activista existente en la BD y eliminarlo.
     *
     * @param activista
     */
    public boolean eliminar(int idActivista) {
        String sql = "DELETE FROM Activista WHERE idActivista = ?";
        try (Connection conn = ConexionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idActivista);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al eliminar activista: " + e.getMessage());
            return false;
        }
    }

}
