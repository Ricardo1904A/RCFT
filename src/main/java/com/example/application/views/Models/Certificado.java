package com.example.application.views.Models;

public class Certificado {
    private Persona persona;

    public Certificado(Persona persona) {
        this.persona = persona;
    }

    public String generarCertificadoCiudadano() {
        return "Certificado de Ciudadano\n" +
                "Nombre: " + persona.getNombre() + "\n" +
                "Cédula: " + persona.getCedula() + "\n" +
                "El certificado se encuentra válido para ser ciudadano de la República.";
    }

    public String generarCertificadoNacimiento() {
        return "Certificado de Nacimiento\n" +
                "La persona " + persona.getNombre() + " con cédula de identidad " + persona.getCedula() +
                " nació en " + persona.getLugarNacimiento() + " con fecha " + persona.getFechaNacimiento() +
                " certificado por el gobierno.";
    }

    public String generarCertificadoProfesion() {
        return "Certificado de Profesión\n" +
                "La persona " + persona.getNombre() + " con cédula de identidad " + persona.getCedula() +
                " tiene como profesión " + persona.getProfesion() + ", válida en la República.";
    }

    public String generarCertificadoEstadoCivil() {
        return "Certificado de Estado Civil\n" +
                "La persona " + persona.getNombre() + " con cédula de identidad " + persona.getCedula() +
                " se encuentra " + persona.getEstadoCivil() + " registrado en la República.";
    }
}
