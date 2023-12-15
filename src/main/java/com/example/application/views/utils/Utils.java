package com.example.application.views.utils;

import com.example.application.views.Models.Persona;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<Persona> listaPersonas = new ArrayList<>();

    static {
        // Lista de personas
        listaPersonas.add(new Persona("1", "Juan ", LocalDate.of(2000, 5, 15), "Quito", "Divorciado", "Ingeniero"));
        listaPersonas.add(new Persona("2", "Ana ", LocalDate.of(2001, 8, 20), "Guayaquil", "Casada", "Medico"));
        listaPersonas.add(new Persona("3", "Carlos ", LocalDate.of(2002, 12, 5), "Cuenca", "Soltero", "Abogado"));

        // Imprimir el tamaño de la lista después de la inicialización
        System.out.println("Utils.listaPersonas ha sido inicializada con " + listaPersonas.size() + " elementos.");
    }
}
