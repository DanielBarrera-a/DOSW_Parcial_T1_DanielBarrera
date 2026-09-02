package edu.dosw.parcial.model;

import java.util.List;

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
