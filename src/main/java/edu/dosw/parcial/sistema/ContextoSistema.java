package edu.dosw.parcial.sistema;

import com.dosw.bobsbarber.model.Barbero;
import com.dosw.bobsbarber.model.DiaSemana;
import com.dosw.bobsbarber.model.Servicio;
import com.dosw.bobsbarber.model.TipoPasarela;

import java.util.*;

/**
 * Aqui se guarda toda la info que el negocio necesita para funcionar:
 * los servicios que se ofrecen, los barberos, que horarios ya estan
 * llenos y que pasarelas de pago estan activas. Las validaciones de
 * la cadena consultan esto para saber si pueden aprobar o no un turno
 */

public class ContextoSistema {

    public static final int MAX_CLIENTES_POR_FRANJA = 3;

    private final Map<String, Servicio> catalogoServicios = new HashMap<>();
    private final List<Barbero> barberos = new ArrayList<>();
    private final Set<TipoPasarela> pasarelasActivas = new HashSet<>();
    private final Map<String, Integer> ocupacionFranjas = new HashMap<>();

    public void registrarServicio(Servicio servicio) {
        catalogoServicios.put(servicio.getCodigo(), servicio);
    }

    public Servicio buscarServicio(String codigo) {
        return catalogoServicios.get(codigo);
    }

    public void registrarBarbero(Barbero barbero) {
        barberos.add(barbero);
    }

    public List<Barbero> getBarberos() {
        return barberos;
    }

    public void activarPasarela(TipoPasarela tipoPasarela) {
        pasarelasActivas.add(tipoPasarela);
    }

    public boolean pasarelaActiva(TipoPasarela tipoPasarela) {
        return pasarelasActivas.contains(tipoPasarela);
    }

    public boolean hayCupoEnFranja(DiaSemana dia, int hora) {
        String clave = dia + "-" + hora;
        return ocupacionFranjas.getOrDefault(clave, 0) < MAX_CLIENTES_POR_FRANJA;
    }

    public void ocuparFranja(DiaSemana dia, int hora) {
        String clave = dia + "-" + hora;
        ocupacionFranjas.merge(clave, 1, Integer::sum);
    }
}
