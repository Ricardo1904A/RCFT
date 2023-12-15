package com.example.application.views.verciudadanos;

import com.example.application.views.MainLayout;
import com.example.application.views.Models.Persona;
import com.example.application.views.utils.Utils;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Ver Ciudadanos")
@Route(value = "Ver-Ciudadanos", layout = MainLayout.class)
public class VerCiudadanosView extends Composite<VerticalLayout> implements BeforeEnterObserver {

    private VerticalLayout listaCiudadanosLayout;

    public VerCiudadanosView() {
        H2 titulo = new H2("Ciudadanos actuales");
        listaCiudadanosLayout = new VerticalLayout();

        VerticalLayout layout = getContent();
        layout.setWidth("100%");
        layout.add(titulo, listaCiudadanosLayout);
    }

    private void actualizarListaCiudadanos() {
        listaCiudadanosLayout.removeAll();
        int contador = 1;
        for (Persona persona : Utils.listaPersonas) {
            String textoPersona = "Persona " + contador + ": " + persona.toString();
            Paragraph parrafo = new Paragraph(textoPersona);
            listaCiudadanosLayout.add(parrafo);
            contador++;
        }
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        actualizarListaCiudadanos();
    }
}
