/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ecoactivistas.controller;

import com.mycompany.ecoactivistas.dao.ActivistaDAO;
import com.mycompany.ecoactivistas.dao.ProblemaActivistaDAO;
import com.mycompany.ecoactivistas.dao.ProblemaDAO;
import com.mycompany.ecoactivistas.interfaces.IProblemaActivistaDAO;
import com.mycompany.ecoactivistas.model.Activista;
import com.mycompany.ecoactivistas.model.ProblemaActivista;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author martinbl
 */
public class ProblemaActivistaController {

    private final IProblemaActivistaDAO paDAO;
    private final ActivistaDAO activistaDAO;
    private final ProblemaDAO problemaDAO;
    private final ActivistaController activistaController;
    private final ProblemaController problemaController;

    public ProblemaActivistaController() {
        this.paDAO = new ProblemaActivistaDAO();
        this.activistaDAO = new ActivistaDAO();
        this.problemaDAO = new ProblemaDAO();
        this.activistaController = new ActivistaController();
        this.problemaController = new ProblemaController();
    }

    // Asignar un activista a un problema
    public boolean asignarActivista(int idProblema, int idActivista) {
        if (idProblema <= 0 || idActivista <= 0) {
            System.err.println("IDs inválidos para asignación.");
            return false;
        }

        ProblemaActivista relacion = new ProblemaActivista();
        relacion.setIdProblema(idProblema);
        relacion.setIdActivista(idActivista);

        return paDAO.insertar(relacion);
    }

    // Listar activistas asignados a un problema
    public List<ProblemaActivista> obtenerPorProblema(int idProblema) {
        if (idProblema <= 0) {
            System.err.println("ID de problema inválido.");
            return null;
        }
        return paDAO.obtenerPorProblema(idProblema);
    }

    // Listar problemas asignados a un activista
    public List<ProblemaActivista> obtenerPorActivista(int idActivista) {
        if (idActivista <= 0) {
            System.err.println("ID de activista inválido.");
            return null;
        }
        return paDAO.obtenerPorActivista(idActivista);
    }

    // Eliminar asignación
    public boolean eliminarAsignacion(int idProblema, int idActivista) {
        if (idProblema <= 0 || idActivista <= 0) {
            System.err.println("IDs inválidos para eliminación.");
            return false;
        }
        return paDAO.eliminar(idProblema, idActivista);
    }

    public DefaultTableModel obtenerTablaPorProblema(int idProblema) {

        String[] columnas = {"ID PROBLEMA", "ID ACTIVISTA"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        List<ProblemaActivista> lista = paDAO.obtenerPorProblema(idProblema);

        if (lista != null) {
            for (ProblemaActivista pa : lista) {

                modelo.addRow(new Object[]{pa.getIdProblema(), pa.getIdActivista()});

            }
        }

        return modelo;
    }

    public DefaultTableModel obtenerTablaPorActivista(int idActivista) {

        String[] columnas = {"ID PROBLEMA", "ID ACTIVISTA"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        List<ProblemaActivista> lista = paDAO.obtenerPorActivista(idActivista);

        if (lista != null) {

            for (ProblemaActivista pa : lista) {

                modelo.addRow(new Object[]{pa.getIdProblema(), pa.getIdActivista()});

            }
        }

        return modelo;
    }

    public DefaultTableModel obtenerTablaActivistasAsignados(int idProblema) {

        List<ProblemaActivista> asignaciones = paDAO.obtenerPorProblema(idProblema);

        String[] columnas = {"ID ACTIVISTA", "NOMBRE", "TELÉFONO", "ID PROBLEMA", "DESCRIPCIÓN", "ESTADO"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);

        for (ProblemaActivista pa : asignaciones) {
            Object[] fila = new Object[6];

            // Traer info del activista
            var activista = activistaController.obtenerActivista(pa.getIdActivista());
            fila[0] = activista.getIdActivista();
            fila[1] = activista.getNombre();
            fila[2] = activista.getTelefono();

            // Traer info del problema
            var problema = problemaController.obtenerProblema(pa.getIdProblema());
            fila[3] = problema.getIdProblema();
            fila[4] = problema.getDescripcion();
            fila[5] = problema.getEstado();

            modelo.addRow(fila);
        }

        return modelo;
    }

    public DefaultTableModel obtenerTablaActivistasDisponibles(int idProblema) {

        String[] columnas = {"ID ACTIVISTA", "NOMBRE", "TELEFONO"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        List<Activista> todos = activistaDAO.obtenerTodos();
        List<ProblemaActivista> asignados = paDAO.obtenerPorProblema(idProblema);

        for (Activista a : todos) {

            boolean estaAsignado = false;

            for (ProblemaActivista pa : asignados) {

                if (pa.getIdActivista() == a.getIdActivista()) {

                    estaAsignado = true;
                    break;

                }
            }

            if (!estaAsignado) {

                modelo.addRow(new Object[]{a.getIdActivista(), a.getNombre(), a.getTelefono()});

            }
        }

        return modelo;
    }

}
