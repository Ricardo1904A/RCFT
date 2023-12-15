package com.example.application.views.imprimircertificado;

import com.example.application.views.MainLayout;
import com.example.application.views.Models.Persona;
import com.example.application.views.Models.RegistroPersona;
import com.example.application.views.Models.Certificado;
import com.example.application.views.utils.Utils;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.Optional;

@PageTitle("Imprimir Certificado")
@Route(value = "Imprimir-Certificado", layout = MainLayout.class)
@Uses(Icon.class)
public class ImprimirCertificadoView extends Composite<VerticalLayout> {

    // Elementos de la UI
    private Select<String> selectTipoCertificado;
    private TextField textFieldCedula;
    private Button buttonGenerar;
    private VerticalLayout layoutResultado;

    public ImprimirCertificadoView() {
        H2 titulo = new H2("Generación de Certificados");
        H4 subtitulo = new H4("Elija que certificado quiere obtener:");

        // Selector de tipo de certificado
        selectTipoCertificado = new Select<>();
        selectTipoCertificado.setItems("Ciudadano", "Nacimiento", "Profesión", "Estado Civil");
        selectTipoCertificado.setLabel("Tipo de Certificado");

        // Campo de texto para la cédula
        textFieldCedula = new TextField("Ingrese la cédula de la persona");

        // Botón para generar certificado
        buttonGenerar = new Button("Generar", event -> generarCertificado());
        buttonGenerar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        // Layout para mostrar el resultado
        layoutResultado = new VerticalLayout();

        VerticalLayout layout = getContent();
        layout.setWidth("100%");
        layout.getStyle().set("flex-grow", "1");
        layout.add(titulo, subtitulo, selectTipoCertificado, textFieldCedula, buttonGenerar, layoutResultado);
    }

    private void generarCertificado() {
        String cedula = textFieldCedula.getValue();
        String tipoCertificado = selectTipoCertificado.getValue();
        layoutResultado.removeAll();

        Persona persona = Utils.listaPersonas.stream()
                .filter(p -> p.getCedula().equals(cedula))
                .findFirst()
                .orElse(null);

        if (persona != null) {
            Certificado certificado = new Certificado(persona);
            String textoCertificado;

            switch (tipoCertificado) {
                case "Ciudadano":
                    textoCertificado = certificado.generarCertificadoCiudadano();
                    break;
                case "Nacimiento":
                    textoCertificado = certificado.generarCertificadoNacimiento();
                    break;
                case "Profesión":
                    textoCertificado = certificado.generarCertificadoProfesion();
                    break;
                case "Estado Civil":
                    textoCertificado = certificado.generarCertificadoEstadoCivil();
                    break;
                default:
                    textoCertificado = "Tipo de certificado no válido.";
                    break;
            }

            layoutResultado.add(new Paragraph(textoCertificado));
        } else {
            layoutResultado.add(new Paragraph("No se encontró a la persona con la cédula proporcionada."));
        }
    }
}