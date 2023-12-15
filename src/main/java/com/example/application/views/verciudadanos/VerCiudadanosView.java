package com.example.application.views.verciudadanos;

import com.example.application.views.MainLayout;
import com.example.application.views.Models.Persona;
import com.example.application.views.utils.Utils;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Ver Ciudadanos")
@Route(value = "Ver-Ciudadanos", layout = MainLayout.class)
public class VerCiudadanosView extends Composite<VerticalLayout> implements BeforeEnterObserver {

    private Grid<Persona> grid;

    public VerCiudadanosView() {
        H2 titulo = new H2("Ciudadanos actuales");
        grid = new Grid<>(Persona.class, false);
        configurarGrid();

        VerticalLayout layout = getContent();
        layout.setWidth("100%");
        layout.add(titulo, grid);
    }

    private void configurarGrid() {
        grid.addColumn(Persona::getCedula).setHeader("Cédula");
        grid.addColumn(Persona::getNombre).setHeader("Nombre");
        grid.addColumn(Persona::getFechaNacimiento).setHeader("Fecha de Nacimiento");
        grid.addColumn(Persona::getLugarNacimiento).setHeader("Lugar de Nacimiento");
        grid.addColumn(Persona::getEstadoCivil).setHeader("Estado Civil");
        grid.addColumn(Persona::getProfesion).setHeader("Profesión");

        grid.setSizeFull();
    }

    private void actualizarListaCiudadanos() {
        // Agregando log de depuración
        System.out.println("Actualizando lista de ciudadanos. Tamaño actual: " + Utils.listaPersonas.size());
        grid.setItems(Utils.listaPersonas);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        actualizarListaCiudadanos();
    }
}
