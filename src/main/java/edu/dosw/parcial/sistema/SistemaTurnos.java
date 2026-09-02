package com.dosw.bobsbarber.sistema;

import com.dosw.bobsbarber.model.ResultadoTurno;
import com.dosw.bobsbarber.model.ResultadoValidacion;
import com.dosw.bobsbarber.model.SolicitudTurno;
import com.dosw.bobsbarber.validation.Validador;
import com.dosw.bobsbarber.validation.ValidadorBarbero;
import com.dosw.bobsbarber.validation.ValidadorDatosCliente;
import com.dosw.bobsbarber.validation.ValidadorFranja;
import com.dosw.bobsbarber.validation.ValidadorPasarela;
import com.dosw.bobsbarber.validation.ValidadorServicio;

import java.util.ArrayList;
import java.util.List;

/**
 * Orquesta el procesamiento de un turno a traves de la cadena de
 * responsabilidad (RF-01).
 *
 * PENDIENTE (RF-02): cuando un turno sea aprobado por todas las
 * validaciones, el siguiente paso es invocar el Adapter de la pasarela
 * de pago seleccionada para procesar el cobro y normalizar la
 * respuesta a {payment_Id, estado, mensaje}. Esa parte aun no esta
 * implementada.
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
