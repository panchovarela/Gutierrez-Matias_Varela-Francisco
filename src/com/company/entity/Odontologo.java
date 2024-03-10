package com.company.entity;

public class Odontologo {

    private Long id;
    private Integer numeroDeMatricula;
    private String nombre;
    private String apellido;

    public Odontologo() {}

    public Odontologo(Integer numeroDeMatricula, String nombre, String apellido) {
        this.numeroDeMatricula = numeroDeMatricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Odontologo(Long id, Integer numeroDeMatricula, String nombre, String apellido) {
        this.id = id;
        this.numeroDeMatricula = numeroDeMatricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Long getId() {
        return id;
    }

    public Integer getNumeroDeMatricula() {
        return numeroDeMatricula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Odontologo{" +
                "id=" + id +
                ", numeroDeMatricula=" + numeroDeMatricula +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
