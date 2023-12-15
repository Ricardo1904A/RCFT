package com.example.application.views.utils;

import com.example.application.views.Models.Persona;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<Persona> listaPersonas = new ArrayList<>();

    static {
        // Agregar personas con datos aleatorios
        listaPersonas.add(new Persona("123456789", "Juan Pérez", LocalDate.of(1985, 5, 15), "Ciudad Central", "Soltero", "Ingeniero"));
        listaPersonas.add(new Persona("987654321", "Ana López", LocalDate.of(1990, 8, 20), "Ciudad del Lago", "Casada", "Médico"));
        listaPersonas.add(new Persona("456789123", "Carlos Gómez", LocalDate.of(1978, 12, 5), "Ciudad de las Colinas", "Divorciado", "Abogado"));

        // Imprimir el tamaño de la lista después de la inicialización
        System.out.println("Utils.listaPersonas ha sido inicializada con " + listaPersonas.size() + " elementos.");
    }
}
