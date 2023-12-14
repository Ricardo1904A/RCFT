package com.example.application.views.verciudadanos;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Ver Ciudadanos")
@Route(value = "Ver-Ciudadanos", layout = MainLayout.class)
@Uses(Icon.class)
public class VerCiudadanosView extends Composite<VerticalLayout> {

    public VerCiudadanosView() {
        H2 h2 = new H2();
        Button buttonSecondary = new Button();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        h2.setText("Ciudadanos actuales");
        getContent().setAlignSelf(FlexComponent.Alignment.CENTER, h2);
        h2.setWidth("max-content");
        buttonSecondary.setText("Cancelar");
        getContent().setAlignSelf(FlexComponent.Alignment.CENTER, buttonSecondary);
        buttonSecondary.setWidth("min-content");
        getContent().add(h2);
        getContent().add(buttonSecondary);
    }
}
