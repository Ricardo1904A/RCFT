package com.example.application.views.accion;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Accion")
@Route(value = "Accion", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@Uses(Icon.class)
public class AccionView extends Composite<VerticalLayout> {

    public AccionView() {
        H1 h1 = new H1();
        H4 h4 = new H4();
        RadioButtonGroup radioGroup = new RadioButtonGroup();
        Button buttonPrimary = new Button();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        h1.setText("Bienvenido al Registro Civil");
        h1.setWidth("max-content");
        h4.setText("Seleccione que operación quiere realizar");
        h4.setWidth("max-content");
        radioGroup.setLabel("Radio Group");
        radioGroup.setWidth("min-content");
        radioGroup.setItems("Order ID", "Product Name", "Customer", "Status");
        radioGroup.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
        buttonPrimary.setText("Continuar");
        getContent().setAlignSelf(FlexComponent.Alignment.CENTER, buttonPrimary);
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        getContent().add(h1);
        getContent().add(h4);
        getContent().add(radioGroup);
        getContent().add(buttonPrimary);
    }
}
