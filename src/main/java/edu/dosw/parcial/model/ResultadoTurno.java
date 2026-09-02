package com.dosw.bobsbarber.model;

import java.util.List;

/**
 * Resultado de pasar una solicitud por la cadena de responsabilidad.
 * Por ahora solo refleja el resultado de las validaciones (RF-01).
 * Cuando se implemente el Adapter (RF-02), este resultado se
 * extendera con la respuesta normalizada del pago.
 */
public class ResultadoTurno {

    private final SolicitudTurno solicitud;
    private final List<ResultadoValidacion> pasosValidacion;
    private final boolean aprobadoPorValidaciones;

    public ResultadoTurno(SolicitudTurno solicitud, List<ResultadoValidacion> pasosValidacion,
                           boolean aprobadoPorValidaciones) {
        this.solicitud = solicitud;
        this.pasosValidacion = pasosValidacion;
        this.aprobadoPorValidaciones = aprobadoPorValidaciones;
    }

    public SolicitudTurno getSolicitud() {
        return solicitud;
    }

    public List<ResultadoValidacion> getPasosValidacion() {
        return pasosValidacion;
    }

    public boolean isAprobadoPorValidaciones() {
        return aprobadoPorValidaciones;
    }
}
