package edu.dosw.parcial.sistema;

import com.dosw.bobsbarber.model.ResultadoTurno;
import com.dosw.bobsbarber.model.ResultadoValidacion;
import com.dosw.bobsbarber.model.SolicitudTurno;
import com.dosw.bobsbarber.validation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Esta clase se encarga de mover un turno por toda la cadena de
 * validaciones, o sea la parte que revisa que la franja este libre,
 * que haya un barbero disponible, que los datos del cliente esten
 * bien, que el servicio exista y que la pasarela de pago este activa,
 * antes de aprobar el turno
 *
 * Pendiente: cuando un turno pase todas esas validaciones, lo que
 * sigue es cobrar con la pasarela que el cliente eligio y devolver el
 * resultado del pago. Esa parte todavia no esta hecha cabe aclarar porque no me dio el tiempo
 */




public class SistemaTurnos {

    private final ContextoSistema contexto;

    public SistemaTurnos(ContextoSistema contexto) {
        this.contexto = contexto;
    }

    public ResultadoTurno procesarTurno(SolicitudTurno solicitud) {
        Validador cadena = construirCadena();
        List<ResultadoValidacion> pasos = new ArrayList<>();

        boolean aprobadaPorLaCadena = cadena.validar(solicitud, contexto, pasos);

        if (aprobadaPorLaCadena) {
            contexto.ocuparFranja(solicitud.getDia(), solicitud.getHora());
        }

        return new ResultadoTurno(solicitud, pasos, aprobadaPorLaCadena);
    }

    private Validador construirCadena() {
        Validador franja = new ValidadorFranja();
        Validador barbero = new ValidadorBarbero();
        Validador datosCliente = new ValidadorDatosCliente();
        Validador servicio = new ValidadorServicio();
        Validador pasarela = new ValidadorPasarela();

        franja.setSiguiente(barbero)
                .setSiguiente(datosCliente)
                .setSiguiente(servicio)
                .setSiguiente(pasarela);

        return franja;
    }
}
