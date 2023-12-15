package com.example.application;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * La clase principal de la aplicación Spring Boot.
 */
@SpringBootApplication
@Theme(value = "registrocivil") // Asegúrate de que el tema 'registrocivil' esté definido en tu proyecto
public class Application implements AppShellConfigurator {

    /**
     * Punto de entrada principal de la aplicación Spring Boot.
     *
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}
