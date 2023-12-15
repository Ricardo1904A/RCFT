package com.example.application.views.Models;

import com.example.application.views.utils.Utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RegistroPersona {
    public static final RegistroPersona INSTANCE = new RegistroPersona();

    private RegistroPersona() {
        // Constructor privado para evitar la creación de múltiples instancias
    }

    public void agregarPersona(Persona persona) {
        Utils.listaPersonas.add(persona);
    }

    public Persona buscarPorCedula(String cedula) {
        return Utils.listaPersonas.stream()
                .filter(persona -> persona.getCedula().equals(cedula))
                .findFirst()
                .orElse(null);
    }

    public List<Persona> buscarPorNombre(String nombre) {
        return Utils.listaPersonas.stream()
                .filter(persona -> persona.getNombre().equalsIgnoreCase(nombre))
                .collect(Collectors.toList());
    }

    public List<Persona> buscarPorFechaNacimiento(LocalDate fechaNacimiento) {
        return Utils.listaPersonas.stream()
                .filter(persona -> persona.getFechaNacimiento() != null && persona.getFechaNacimiento().equals(fechaNacimiento))
                .collect(Collectors.toList());
    }

    public List<Persona> buscarPorLugarNacimiento(String lugarNacimiento) {
        return Utils.listaPersonas.stream()
                .filter(persona -> persona.getLugarNacimiento().equalsIgnoreCase(lugarNacimiento))
                .collect(Collectors.toList());
    }

    public List<Persona> buscarPorProfesion(String profesion) {
        return Utils.listaPersonas.stream()
                .filter(persona -> persona.getProfesion().equalsIgnoreCase(profesion))
                .collect(Collectors.toList());
    }

    public List<Persona> obtenerTodos() {
        return new ArrayList<>(Utils.listaPersonas);
    }
}