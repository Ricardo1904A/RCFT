package com.example.application.views.agregarciudadano;

import com.example.application.views.MainLayout;
import com.example.application.views.Models.Persona;
import com.example.application.views.Models.RegistroPersona;
import com.example.application.views.utils.Utils;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
@PageTitle("Agregar Ciudadano")
@Route(value = "Agregar-Ciudadano", layout = MainLayout.class)
public class AgregarCiudadanoView extends Composite<VerticalLayout> {

    private TextField textFieldNombres;
    private TextField textFieldId;
    private DatePicker datePickerFechaNacimiento;
    private TextField textFieldLugarNacimiento;
    private TextField textFieldEstadoCivil;
    private TextField textFieldProfesion;
    private Button buttonPrimary;
    private Button buttonSecondary;
public AgregarCiudadanoView() {
        H2 h2 = new H2("Agregar a un ciudadano");
        H4 h4 = new H4("Por favor rellenar todos los espacios solicitados:");
        FormLayout formLayout2Col = new FormLayout();

        textFieldNombres = new TextField("Nombres Completos:");
        textFieldId = new TextField("Id:");
        datePickerFechaNacimiento = new DatePicker("Fecha de Nacimiento");
        textFieldLugarNacimiento = new TextField("Lugar de Nacimiento:");
        textFieldEstadoCivil = new TextField("Estado Civil:");
        textFieldProfesion = new TextField("Profesion:");

        buttonPrimary = new Button("Continuar", event -> agregarCiudadano());
        buttonSecondary = new Button("Cancelar", event -> limpiarFormulario());

        formLayout2Col.add(textFieldNombres, textFieldId, datePickerFechaNacimiento,
        textFieldLugarNacimiento, textFieldEstadoCivil, textFieldProfesion);

        VerticalLayout layout = getContent();
        layout.setWidth("100%");
        layout.getStyle().set("flex-grow", "1");
        layout.add(h2, h4, formLayout2Col, buttonPrimary, buttonSecondary);
        }

private void agregarCiudadano() {
        Persona nuevaPersona = new Persona(
        textFieldId.getValue(),
        textFieldNombres.getValue(),
        datePickerFechaNacimiento.getValue(),
        textFieldLugarNacimiento.getValue(),
        textFieldEstadoCivil.getValue(),
        textFieldProfesion.getValue()
        );

        Utils.listaPersonas.add(nuevaPersona);
        Notification.show("Ciudadano agregado con éxito.");


        limpiarFormulario();
        }

private void limpiarFormulario() {
        textFieldNombres.clear();
        textFieldId.clear();
        datePickerFechaNacimiento.clear();
        textFieldLugarNacimiento.clear();
        textFieldEstadoCivil.clear();
        textFieldProfesion.clear();
        }
        }