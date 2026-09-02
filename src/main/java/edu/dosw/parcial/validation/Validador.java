package com.dosw.bobsbarber.validation;

import com.dosw.bobsbarber.model.ResultadoValidacion;
import com.dosw.bobsbarber.model.SolicitudTurno;
import com.dosw.bobsbarber.sistema.ContextoSistema;

import java.util.List;

/**
 * Eslabon base de la cadena de responsabilidad. Cada validacion concreta
 * extiende esta clase e implementa {@link #ejecutar}. El resultado de
 * cada eslabon se agrega a la bitacora {@code pasos} (para poder mostrar
 * el checklist [OK]/[RECHAZADO] paso a paso). Si la validacion falla, la
 * cadena se detiene inmediatamente: no se invoca el siguiente eslabon.
 */
public abstract class Validador {

    private Validador siguiente;

    public Validador setSiguiente(Validador siguiente) {
        this.siguiente = siguiente;
        return siguiente;
    }

    /**
     * @return true si la solicitud paso este eslabon y puede continuar,
     *         false si fue rechazada (la cadena se detuvo aqui).
     */
    public final boolean validar(SolicitudTurno solicitud, ContextoSistema contexto,
                                  List<ResultadoValidacion> pasos) {
        ResultadoValidacion resultado = ejecutar(solicitud, contexto);
        pasos.add(resultado);
        if (!resultado.isAprobado()) {
            return false;
        }
        if (siguiente != null) {
            return siguiente.validar(solicitud, contexto, pasos);
        }
        return true;
    }

    protected abstract ResultadoValidacion ejecutar(SolicitudTurno solicitud, ContextoSistema contexto);
}
