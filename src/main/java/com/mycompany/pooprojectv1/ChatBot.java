/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pooprojectv1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author IrisCore7
 */
public class ChatBot {
    
    private String nombre;
    private List<String> respuestas;
    
    public ChatBot(String nombre){
        this.nombre = nombre; 
        this.respuestas = new ArrayList<>();
    }
    
    @SuppressWarnings("null")
    public void procesarConsulta(String entrada){
        
        respuestas.clear(); // borramos las respuestas
        
        int contador = 0;
        
        // lista donde se guardara cada linea del archivo de texto
        List<String> consultasRespuestas = null;

        // try catch para abrir de forma segura el archivo de texto y guadarlo en  
        try {         
            consultasRespuestas = Files.readAllLines(Paths.get("src\\\\main\\\\resources\\\\data.txt"));
        } catch (IOException e) {
        }
        
        // recorremos la lista para evaluar
        for (String linea : consultasRespuestas) {
            
            if (linea.trim().isEmpty()) {
                continue; // omitir línea vacía para recorrer el siguiente bucle
            }
            
            // cortamos el texto en 2 partes
            String[] partes = linea.split("=>", 2);
            String consulta = partes[0].trim();
            String respuesta = partes[1].trim();
            
            // Extraemos la parte entre llaves y la parte fuera de las llaves de la consulta
            String parte1 = consulta.substring(consulta.indexOf('{') + 1, consulta.indexOf('}'));
            String parte2 = consulta.substring(consulta.indexOf('}') + 2); // saltar la coma
            
            // lo guardamos en 2 lista
            List<String> lista1 = Arrays.stream(parte1.split(","))
                                        .collect(Collectors.toList());

            List<String> lista2 = Arrays.stream(parte2.split(","))
                                        .collect(Collectors.toList());
            
            // condicionamos
            boolean cumpleLista1 = lista1.stream().anyMatch(entrada::contains);
            boolean cumpleLista2 = lista2.stream().allMatch(entrada::contains);
            
            // si cumple la condicion
            if(cumpleLista1 && cumpleLista2){
                respuestas.add(nombre+": "+respuesta);
                contador++;
            }
            
            // si la cantidad de respuestas es igual a ... entonces se deja de ejecutar el metodo
            if(contador == 1){
                return;
            }
        }
        
        if(respuestas.isEmpty()){
            respuestas.add(nombre+": Por favor consulte algo relacionado a la atencion al alumno");
        }
    }

    public List<String> getRespuestas() {
        return respuestas;
    }
}
