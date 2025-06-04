/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pooprojectv1.estudiante;

/**
 *
 * @author IrisCore7
 */
public class Reclamo {
    
    private String motivo;
    private int estado;

    public Reclamo(String motivo) {
        this.motivo = motivo;
        this.estado = 1;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getEstado() {
        switch(estado) {
            case 1:
                return "el reclamo fue enviado se recomienda que esperes";
            case 2:
                return "el reclamo se encuentra en evaluacion";
            case 3:
                return "el reclamo se dio solucion";
            case 4:
                return "No se dio solucion porque las reglas de la institucion lo permiten";
            default:
                return "";
        }
    }
    
    
}
