package com.example.application.views.buscarciudadano;

import com.example.application.views.MainLayout;
import com.example.application.views.Models.Persona;
import com.example.application.views.Models.RegistroPersona;
import com.example.application.views.utils.Utils;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;




import java.util.List;

@PageTitle("Buscar Ciudadano")
@Route(value = "Buscar-Ciudadano", layout = MainLayout.class)
@Uses(Icon.class)
public class BuscarCiudadanoView extends Composite<VerticalLayout> {

    // Elementos de la UI
    private Select<String> selectCriterioBusqueda;
    private TextField textFieldBusqueda;
    private DatePicker datePickerBusqueda;
    private Button buttonBuscar;
    private Button buttonLimpiar;
    private VerticalLayout layoutResultados;

    public BuscarCiudadanoView() {
        H2 h2 = new H2("Buscar Ciudadano");
        H4 h4 = new H4("Seleccione el criterio de búsqueda y proporcione la información correspondiente:");

        // Configuración del selector de criterios
        selectCriterioBusqueda = new Select<>();
        selectCriterioBusqueda.setItems("Cédula", "Nombre", "Fecha de Nacimiento", "Lugar de Nacimiento", "Profesión");
        selectCriterioBusqueda.setLabel("Criterio de búsqueda");
        selectCriterioBusqueda.addValueChangeListener(e -> actualizarInterfazBusqueda());

        // Campos de texto y fecha para la búsqueda
        textFieldBusqueda = new TextField();
        textFieldBusqueda.setLabel("Valor de búsqueda");
        datePickerBusqueda = new DatePicker();
        datePickerBusqueda.setLabel("Fecha de Nacimiento");

        // Botones
        buttonBuscar = new Button("Buscar", event -> buscarCiudadano());
        buttonLimpiar = new Button("Limpiar", event -> limpiarResultados());
        buttonBuscar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        // Layout para resultados
        layoutResultados = new VerticalLayout();

        VerticalLayout layout = getContent();
        layout.setWidth("100%");
        layout.getStyle().set("flex-grow", "1");
        layout.add(h2, h4, selectCriterioBusqueda, textFieldBusqueda, datePickerBusqueda, buttonBuscar, buttonLimpiar, layoutResultados);
    }

    private void actualizarInterfazBusqueda() {
        String criterio = selectCriterioBusqueda.getValue();
        textFieldBusqueda.setVisible(!"Fecha de Nacimiento".equals(criterio));
        datePickerBusqueda.setVisible("Fecha de Nacimiento".equals(criterio));
    }

    private void buscarCiudadano() {
        String criterio = selectCriterioBusqueda.getValue();
        layoutResultados.removeAll();

        switch (criterio) {
            case "Cédula":
                Utils.listaPersonas.stream()
                        .filter(persona -> persona.getCedula().equals(textFieldBusqueda.getValue()))
                        .forEach(p -> layoutResultados.add(new H4(p.toString())));
                break;
            case "Nombre":
                Utils.listaPersonas.stream()
                        .filter(persona -> persona.getNombre().equalsIgnoreCase(textFieldBusqueda.getValue()))
                        .forEach(p -> layoutResultados.add(new H4(p.toString())));
                break;
            case "Fecha de Nacimiento":
                Utils.listaPersonas.stream()
                        .filter(persona -> persona.getFechaNacimiento().equals(datePickerBusqueda.getValue()))
                        .forEach(p -> layoutResultados.add(new H4(p.toString())));
                break;
            case "Lugar de Nacimiento":
                Utils.listaPersonas.stream()
                        .filter(persona -> persona.getLugarNacimiento().equalsIgnoreCase(textFieldBusqueda.getValue()))
                        .forEach(p -> layoutResultados.add(new H4(p.toString())));
                break;
            case "Profesión":
                Utils.listaPersonas.stream()
                        .filter(persona -> persona.getProfesion().equalsIgnoreCase(textFieldBusqueda.getValue()))
                        .forEach(p -> layoutResultados.add(new H4(p.toString())));
                break;
        }
    }

    private void limpiarResultados() {
        layoutResultados.removeAll();
        textFieldBusqueda.clear();
        datePickerBusqueda.clear();
    }
}