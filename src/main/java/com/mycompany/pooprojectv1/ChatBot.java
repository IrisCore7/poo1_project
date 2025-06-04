/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pooprojectv1;

import com.mycompany.pooprojectv1.estudiante.Alumno;
import com.mycompany.pooprojectv1.universidad.MatriculaUniversidad;
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
    private MatriculaUniversidad matriculaUniversidad;
    private Alumno alumno;
    private List<String> respuestas;
    private boolean ingresarReclamo;
    private boolean verReclamo;
    
    public ChatBot(String nombre, MatriculaUniversidad matriculaUniversidad, Alumno alumno){
        this.nombre = nombre; 
        this.matriculaUniversidad = matriculaUniversidad;
        this.alumno = alumno;
        this.respuestas = new ArrayList<>();
        this.ingresarReclamo = false;
        this.verReclamo = false;
    }
    
    public void procesarConsulta(String entrada){
        
        respuestas.clear(); // borramos las respuestas
        
        int contador = 0;
        
        if(ingresarReclamo == true){
            ingresarReclamo = false;
            respuestas.add(alumno.agregarReclamo(entrada));
            return;
        }
        
        if(verReclamo == true){
            verReclamo = false;
            respuestas.add(alumno.obtenerEstadoReclamo(entrada));
            return;
        }
             
        // lista donde se guardara cada linea del archivo de texto
        List<String> consultasRespuestas = null;

        // try catch para abrir de forma segura el archivo de texto y guadarlo en  
        try {         
            consultasRespuestas = Files.readAllLines(Paths.get("src\\\\main\\\\resources\\\\data2.txt"));
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
            int inicioParte1 = consulta.indexOf('{') + 1;
            int finParte1 = consulta.indexOf('}');

            int inicioParte2 = finParte1 + 1;
            int finParte2 = consulta.lastIndexOf('{');

            int inicioParte3 = finParte2 + 1;
            int finParte3 = consulta.lastIndexOf('}');

            // Extracciones
            String parte1 = consulta.substring(inicioParte1, finParte1);
            String parte2 = consulta.substring(inicioParte2, finParte2);
            String parte3 = consulta.substring(inicioParte3, finParte3);

            // lo guardamos en 2 lista
            List<String> lista1 = Arrays.stream(parte1.split(","))
                                        .collect(Collectors.toList());

            List<String> lista2 = Arrays.stream(parte2.split(","))
                                        .collect(Collectors.toList());
            
            List<String> lista3 = Arrays.stream(parte3.split(","))
                                        .collect(Collectors.toList());
                 
            // condicionamos
            boolean cumpleLista1 = lista1.stream().anyMatch(entrada::contains);
            boolean cumpleLista2 = lista2.stream().allMatch(entrada::contains);
            boolean cumpleLista3 = lista3.get(0).equals("") ? true : !lista3.stream().anyMatch(entrada::contains);
            
            // si cumple la condicion
            if(cumpleLista1 && cumpleLista2 && cumpleLista3){
                if(respuesta.equals("ok alumno, escriba el motivo de su reclamo para ingresarlo al sistema")){
                    respuestas.add(respuesta);
                    ingresarReclamo = true;
                    return;
                }
                
                if(respuesta.equals("ok alumno, escriba el motivo de su reclamo para buscarlo y saber su estado")){
                    respuestas.add(respuesta);
                    verReclamo = true;
                    return;
                }
        
                respuesta = respuesta.replace("matriculaUniversidad.inicia()", matriculaUniversidad.inicia());
                respuesta = respuesta.replace("matriculaUniversidad.precio()", matriculaUniversidad.precio());
                respuesta = respuesta.replace("alumno.getEstadoProximaMatricula()", alumno.getEstadoProximaMatricula());
                respuesta = respuesta.replace("alumno.getProximaMatriculaSeleccionCursos()", alumno.getProximaMatriculaSeleccionCursos());
                respuesta = respuesta.replace("alumno.getCodigo()", alumno.getCodigo());
                respuesta = respuesta.replace("alumno.getCorreo()", alumno.getCorreo());
                respuestas.add(nombre+": "+respuesta);
                contador++;
            }
            
            // si la cantidad de respuestas es igual a ... entonces se deja de ejecutar el metodo
            if(contador == 3){
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
