package com.example.application.views.agregarciudadano;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Agregar Ciudadano")
@Route(value = "Agregar-Ciudadano", layout = MainLayout.class)
@Uses(Icon.class)
public class AgregarCiudadanoView extends Composite<VerticalLayout> {

    public AgregarCiudadanoView() {
        H2 h2 = new H2();
        H4 h4 = new H4();
        FormLayout formLayout2Col = new FormLayout();
        TextField textField = new TextField();
        TextField textField2 = new TextField();
        DatePicker datePicker = new DatePicker();
        TextField textField3 = new TextField();
        TextField textField4 = new TextField();
        TextField textField5 = new TextField();
        Button buttonPrimary = new Button();
        Button buttonSecondary = new Button();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        h2.setText("Agregar a un ciudadano");
        getContent().setAlignSelf(FlexComponent.Alignment.CENTER, h2);
        h2.setWidth("max-content");
        h4.setText("Por favor rellenar todos los espacios solicitados:");
        h4.setWidth("max-content");
        formLayout2Col.setWidth("100%");
        textField.setLabel("Nombres Completos:");
        textField.setWidth("min-content");
        textField2.setLabel("Id:");
        textField2.setWidth("min-content");
        datePicker.setLabel("Fecha de Nacimiento");
        datePicker.setWidth("min-content");
        textField3.setLabel("Lugar de Nacimiento:");
        textField3.setWidth("min-content");
        textField4.setLabel("Estado Civil:");
        textField4.setWidth("min-content");
        textField5.setLabel("Profesion:");
        textField5.setWidth("min-content");
        buttonPrimary.setText("Continuar");
        getContent().setAlignSelf(FlexComponent.Alignment.CENTER, buttonPrimary);
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonSecondary.setText("Cancelar");
        getContent().setAlignSelf(FlexComponent.Alignment.CENTER, buttonSecondary);
        buttonSecondary.setWidth("min-content");
        getContent().add(h2);
        getContent().add(h4);
        getContent().add(formLayout2Col);
        formLayout2Col.add(textField);
        formLayout2Col.add(textField2);
        formLayout2Col.add(datePicker);
        formLayout2Col.add(textField3);
        formLayout2Col.add(textField4);
        formLayout2Col.add(textField5);
        getContent().add(buttonPrimary);
        getContent().add(buttonSecondary);
    }
}
