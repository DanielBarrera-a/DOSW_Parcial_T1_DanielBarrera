package com.dosw.bobsbarber.model;

public class Servicio {

    private final String codigo;
    private final String nombre;
    private final double precio;
    private final Especialidad especialidad;
    private final boolean activo;

    public Servicio(String codigo, String nombre, double precio, Especialidad especialidad, boolean activo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.especialidad = especialidad;
        this.activo = activo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public boolean isActivo() {
        return activo;
    }
}
