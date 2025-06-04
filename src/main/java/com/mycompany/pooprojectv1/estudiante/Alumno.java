/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pooprojectv1.estudiante;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author IrisCore7
 */
public class Alumno {
    
    private String codigo;
    private String nombres;
    private String apellidos;
    private String correo;
    private List<Curso> cursos;
    private List<Reclamo> reclamos;
    
    private int estadoProximaMatricula;
    private String ProximaMatriculaSeleccionCursos;

    public Alumno(String codigo, String nombres, String apellidos, String correo) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.cursos = new ArrayList<>();
        this.reclamos = new ArrayList<>();
        this.estadoProximaMatricula = 5;
        this.ProximaMatriculaSeleccionCursos = "todavia no termina el ciclo";
    }
    
    public String getEstadoProximaMatricula() {
        switch(estadoProximaMatricula) {
            case 1:
                return "Sí cumple todo los requisitos";
            case 2:
                return "No, porque usted tiene documentación incompleta";
            case 3:
                return "No, porque usted tiene una deuda pendiente del ciclo anterior";
            case 4:
                return "No, porque la administracion lo denego, por favor comuniquese a secretaria";
            case 5:
                return "Esta desabilitada porque todavia sigue vigente el ciclo actual, por favor consulte cuando se termine el ciclo";
            default:
                return "";
        }
    }

    public void SetEstadoProximaMatricula(int estadoProximaMatricula) {
        this.estadoProximaMatricula = estadoProximaMatricula;
    }

    public String getProximaMatriculaSeleccionCursos() {
        return ProximaMatriculaSeleccionCursos;
    }

    public void setProximaMatriculaSeleccionCursos(String ProximaMatriculaSeleccionCursos) {
        this.ProximaMatriculaSeleccionCursos = ProximaMatriculaSeleccionCursos;
    }
    
    public String agregarReclamo(String reclamo){
        reclamos.add(new Reclamo(reclamo));
        return "reclamo recibido, gracias lo vamos a considerar";
    }
    
    public String obtenerEstadoReclamo(String motivo) {
        Reclamo mejorCoincidencia = null;
        int maxCoincidencias = 0;

        for (Reclamo reclamo : reclamos) {
            int coincidencias = 0;
            for (String palabra : motivo.toLowerCase().split("\\s+")) {
                if (reclamo.getMotivo().toLowerCase().contains(palabra)) {
                    coincidencias++;
                }
            }

            if (coincidencias > maxCoincidencias) {
                maxCoincidencias = coincidencias;
                mejorCoincidencia = reclamo;
            }
        }

        if (mejorCoincidencia != null && maxCoincidencias >= 2) {
            return mejorCoincidencia.getEstado();
        }

        return "Por favor describa bien su reclamo para encontrarlo";
    }


    public String getCodigo() {
        return codigo;
    }

    public String getCorreo() {
        return correo;
    }
}
