package edu.dosw.parcial.validation;

import com.dosw.bobsbarber.model.ResultadoValidacion;
import com.dosw.bobsbarber.model.SolicitudTurno;
import com.dosw.bobsbarber.sistema.ContextoSistema;

import java.util.List;

/
public abstract class Validador {

    private Validador siguiente;

    public Validador setSiguiente(Validador siguiente) {
        this.siguiente = siguiente;
        return siguiente;
    }


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
