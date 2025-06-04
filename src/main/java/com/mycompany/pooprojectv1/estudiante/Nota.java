/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pooprojectv1.estudiante;

/**
 *
 * @author IrisCore7
 */
public class Nota {
    
    private String tipo;
    private double calificacion;
    private int estado;

    public Nota(String tipo, double calificacion) {
        this.tipo = tipo;
        this.calificacion = calificacion;
        this.estado = 1;
    }

    public String getTipo() {
        return tipo;
    }

    public double getCalificacion() {
        return calificacion;
    }
    
    
}
