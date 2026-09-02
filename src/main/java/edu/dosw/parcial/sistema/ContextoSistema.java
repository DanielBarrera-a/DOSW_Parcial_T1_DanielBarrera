package com.dosw.bobsbarber.sistema;

import com.dosw.bobsbarber.model.Barbero;
import com.dosw.bobsbarber.model.DiaSemana;
import com.dosw.bobsbarber.model.Servicio;
import com.dosw.bobsbarber.model.TipoPasarela;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Contiene el "estado del negocio" que las validaciones de la cadena
 * necesitan consultar: catalogo de servicios, barberos, ocupacion de
 * franjas horarias y pasarelas activas.
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
