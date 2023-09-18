package com.Backend.Api.Persona;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Cambiar de Integer a Long
    private String nombre;
    private String genero;
    private String descripcion;

    public persona() {
    }

    public persona(String nombre, String genero, String descripcion) {
        this.nombre = nombre;
        this.genero = genero;
        this.descripcion = descripcion;
    }

    // Getters and Setters
    public Long getId() { // Cambiar el tipo de retorno de Integer a Long
        return id;
    }

    public void setId(Long id) { // Cambiar el tipo del parámetro de Integer a Long
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
