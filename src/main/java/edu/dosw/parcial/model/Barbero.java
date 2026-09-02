package edu.dosw.parcial.model;

import java.util.EnumSet;
import java.util.Set;

public class Barbero {

    private final String nombre;
    private final Set<Especialidad> especialidades;
    private final Set<DiaSemana> diasDisponibles;
    private final int horaInicio;
    private final int horaFin;

    public Barbero(String nombre, Set<Especialidad> especialidades, Set<DiaSemana> diasDisponibles,
                    int horaInicio, int horaFin) {
        this.nombre = nombre;
        this.especialidades = EnumSet.copyOf(especialidades);
        this.diasDisponibles = EnumSet.copyOf(diasDisponibles);
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean tieneEspecialidad(Especialidad especialidad) {

        return especialidades.contains(especialidad);
    }

    public boolean tieneTodasLasEspecialidades(Set<Especialidad> requeridas) {
        return especialidades.containsAll(requeridas);
    }

    public boolean disponibleEn(DiaSemana dia, int hora) {
        return diasDisponibles.contains(dia) && hora >= horaInicio && hora < horaFin;
    }
}
