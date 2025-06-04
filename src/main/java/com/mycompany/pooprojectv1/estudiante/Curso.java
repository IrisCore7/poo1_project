/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pooprojectv1.estudiante;

/**
 *
 * @author IrisCore7
 */
public class Curso {
    private String codigo;
    private String nombre;
    private String profesor; 
    private String Horario;
    private boolean retiroCurso;

    public Curso(String codigo, String nombre, String profesor, String Horario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.profesor = profesor;
        this.Horario = Horario;
        this.retiroCurso = false;
    }
    
    
}
