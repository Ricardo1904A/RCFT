package com.example.application.views.accion;
import com.vaadin.flow.component.icon.Icon;

import com.example.application.views.MainLayout;
import com.example.application.views.verciudadanos.VerCiudadanosView;
import com.example.application.views.agregarciudadano.AgregarCiudadanoView;
import com.example.application.views.buscarciudadano.BuscarCiudadanoView;
import com.example.application.views.imprimircertificado.ImprimirCertificadoView;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.router.RouterLink;

@PageTitle("Acción")
@Route(value = "", layout = MainLayout.class) // Ruta raíz
@RouteAlias(value = "accion", layout = MainLayout.class) // Alias adicional
public class AccionView extends Composite<VerticalLayout> {

    public AccionView() {
        H1 h1 = new H1("Bienvenido al Registro Civil");
        H4 h4 = new H4("Seleccione qué operación desea realizar");

        // Botones o enlaces para las distintas acciones
        RouterLink agregarCiudadanoLink = new RouterLink("Agregar Ciudadano", AgregarCiudadanoView.class);
        RouterLink imprimirCertificadoLink = new RouterLink("Imprimir Certificado", ImprimirCertificadoView.class);
        RouterLink verCiudadanosLink = new RouterLink("Ver Ciudadanos", VerCiudadanosView.class);
        RouterLink buscarCiudadanoLink = new RouterLink("Buscar Ciudadano", BuscarCiudadanoView.class); // Asumiendo que existe una vista BuscarCiudadanoView

        VerticalLayout layout = getContent();
        layout.setWidth("100%");
        layout.setAlignItems(FlexComponent.Alignment.CENTER); // Uso correcto de FlexComponent.Alignment
        layout.add(h1, h4, agregarCiudadanoLink, imprimirCertificadoLink, verCiudadanosLink, buscarCiudadanoLink);
    }
}
