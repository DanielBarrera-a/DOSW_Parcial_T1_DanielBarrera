package edu.dosw.parcial.model;

public class ResultadoValidacion {

    private final boolean aprobado;
    private final String nombrePaso;
    private final String motivoRechazo;

    private ResultadoValidacion(boolean aprobado, String nombrePaso, String motivoRechazo) {
        this.aprobado = aprobado;
        this.nombrePaso = nombrePaso;
        this.motivoRechazo = motivoRechazo;
    }

    public static ResultadoValidacion ok(String nombrePaso) {
        return new ResultadoValidacion(true, nombrePaso, null);
    }

    public static ResultadoValidacion rechazado(String nombrePaso, String motivo) {
        return new ResultadoValidacion(false, nombrePaso, motivo);
    }

    public boolean isAprobado() {
        return aprobado;
    }

    public String getNombrePaso() {
        return nombrePaso;
    }

    public String getMotivoRechazo() {
        return motivoRechazo;
    }
}
