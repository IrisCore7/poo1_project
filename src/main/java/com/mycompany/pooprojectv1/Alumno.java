/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pooprojectv1;

/**
 *
 * @author IrisCore7
 */
public class Alumno {
    
    private String codigo;
    private String nombres;
    private String apellidos;
    private String correo;
    private Object puedeMatricularse; // deudas pendientes, Bloqueos administrativos
    private Object puedeExamenResagado; //  Si asistió presencial o zoom, si solicito dentro de los 2 dias plazo
    private Object reclamoNota; //
    private Object retiroCurso; //
    private Object retiroCiclo; //
    private Object condicionAcademica; // Alerta o observación académica
}
