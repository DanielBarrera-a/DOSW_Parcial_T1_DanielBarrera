package com.dosw.bobsbarber.validation;

import com.dosw.bobsbarber.model.Barbero;
import com.dosw.bobsbarber.model.Especialidad;
import com.dosw.bobsbarber.model.ResultadoValidacion;
import com.dosw.bobsbarber.model.Servicio;
import com.dosw.bobsbarber.model.SolicitudTurno;
import com.dosw.bobsbarber.sistema.ContextoSistema;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class ValidadorBarbero extends Validador {

    @Override
    protected ResultadoValidacion ejecutar(SolicitudTurno solicitud, ContextoSistema contexto) {
        Set<Especialidad> especialidadesRequeridas = especialidadesDe(solicitud.getCodigosServicio(), contexto);

        if (solicitud.getNombreBarberoPreferido() != null) {
            Barbero preferido = buscarPorNombre(contexto.getBarberos(), solicitud.getNombreBarberoPreferido());
            if (preferido == null || !preferido.tieneTodasLasEspecialidades(especialidadesRequeridas)
                    || !preferido.disponibleEn(solicitud.getDia(), solicitud.getHora())) {
                return ResultadoValidacion.rechazado("Barbero asignado",
                        "El barbero preferido no esta disponible o no tiene la especialidad requerida");
            }
            solicitud.setBarberoAsignado(preferido);
            return ResultadoValidacion.ok("Barbero asignado: " + preferido.getNombre());
        }

        for (Barbero barbero : contexto.getBarberos()) {
            if (barbero.tieneTodasLasEspecialidades(especialidadesRequeridas)
                    && barbero.disponibleEn(solicitud.getDia(), solicitud.getHora())) {
                solicitud.setBarberoAsignado(barbero);
                return ResultadoValidacion.ok("Barbero asignado: " + barbero.getNombre());
            }
        }

        return ResultadoValidacion.rechazado("Barbero asignado",
                "Ningun barbero con la especialidad requerida esta libre en esa franja");
    }

    private Set<Especialidad> especialidadesDe(List<String> codigosServicio, ContextoSistema contexto) {
        Set<Especialidad> resultado = EnumSet.noneOf(Especialidad.class);
        for (String codigo : codigosServicio) {
            Servicio servicio = contexto.buscarServicio(codigo);
            if (servicio != null) {
                resultado.add(servicio.getEspecialidad());
            }
        }
        return resultado;
    }

    private Barbero buscarPorNombre(List<Barbero> barberos, String nombre) {
        for (Barbero barbero : barberos) {
            if (barbero.getNombre().equalsIgnoreCase(nombre)) {
                return barbero;
            }
        }
        return null;
    }
}
