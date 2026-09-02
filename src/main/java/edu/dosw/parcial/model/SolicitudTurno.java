package com.dosw.bobsbarber.model;

import java.util.List;

public class SolicitudTurno {

    private final int numeroTurno;
    private final Cliente cliente;
    private final List<String> codigosServicio;
    private final DiaSemana dia;
    private final int hora;
    private final String nombreBarberoPreferido; // puede ser null = "Sin preferencia"
    private final TipoPasarela pasarelaSeleccionada;

    // Se completan a medida que la cadena avanza
    private Barbero barberoAsignado;
    private double totalCalculado;

    public SolicitudTurno(int numeroTurno, Cliente cliente, List<String> codigosServicio, DiaSemana dia, int hora,
                           String nombreBarberoPreferido, TipoPasarela pasarelaSeleccionada) {
        this.numeroTurno = numeroTurno;
        this.cliente = cliente;
        this.codigosServicio = codigosServicio;
        this.dia = dia;
        this.hora = hora;
        this.nombreBarberoPreferido = nombreBarberoPreferido;
        this.pasarelaSeleccionada = pasarelaSeleccionada;
    }

    public int getNumeroTurno() {
        return numeroTurno;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<String> getCodigosServicio() {
        return codigosServicio;
    }

    public DiaSemana getDia() {
        return dia;
    }

    public int getHora() {
        return hora;
    }

    public String getNombreBarberoPreferido() {
        return nombreBarberoPreferido;
    }

    public TipoPasarela getPasarelaSeleccionada() {
        return pasarelaSeleccionada;
    }

    public Barbero getBarberoAsignado() {
        return barberoAsignado;
    }

    public void setBarberoAsignado(Barbero barberoAsignado) {
        this.barberoAsignado = barberoAsignado;
    }

    public double getTotalCalculado() {
        return totalCalculado;
    }

    public void setTotalCalculado(double totalCalculado) {
        this.totalCalculado = totalCalculado;
    }
}
