/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pooprojectv1.universidad;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author IrisCore7
 */
public class MatriculaUniversidad {
    
    private final Date fechaInicio;
    private final Date fechaFinal;
    private final double precio;
    private boolean activo;

    public MatriculaUniversidad(String fechaInicio, String fechaFinal, double precio) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
        this.fechaInicio = formato.parse(fechaInicio);
        this.fechaFinal = formato.parse(fechaFinal);
        this.precio = precio;
        this.activo = false;
    }

    public String inicia(){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
        return "inicia el " + formato.format(fechaInicio) + " y termina el " + formato.format(fechaFinal);
    }
    
    public String precio(){
        return "S/" + precio;
    }
    
    public String activo(){
        if(activo){
            return "no se encuentra activo";
        }else{
            return "ya se encuentra activo";
        }
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
