package com.example.application.views.imprimircertificado;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
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
import java.util.ArrayList;
import java.util.List;

@PageTitle("Imprimir Certificado")
@Route(value = "Imprimir-Certificado", layout = MainLayout.class)
@Uses(Icon.class)
public class ImprimirCertificadoView extends Composite<VerticalLayout> {

    public ImprimirCertificadoView() {
        H2 h2 = new H2();
        H4 h4 = new H4();
        Select select = new Select();
        TextField textField = new TextField();
        Button buttonPrimary = new Button();
        Button buttonSecondary = new Button();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        h2.setText("Generación de Certificados");
        getContent().setAlignSelf(FlexComponent.Alignment.CENTER, h2);
        h2.setWidth("max-content");
        h4.setText("Elija que certificado quiere obtener:");
        h4.setWidth("max-content");
        select.setLabel("Opciones");
        select.setWidth("min-content");
        setSelectSampleData(select);
        textField.setLabel("Ingrese la cedula de la persona");
        textField.setWidth("400px");
        textField.setMaxWidth("220px");
        buttonPrimary.setText("Continuar");
        getContent().setAlignSelf(FlexComponent.Alignment.CENTER, buttonPrimary);
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonSecondary.setText("Cancelar");
        getContent().setAlignSelf(FlexComponent.Alignment.CENTER, buttonSecondary);
        buttonSecondary.setWidth("min-content");
        getContent().add(h2);
        getContent().add(h4);
        getContent().add(select);
        getContent().add(textField);
        getContent().add(buttonPrimary);
        getContent().add(buttonSecondary);
    }

    record SampleItem(String value, String label, Boolean disabled) {
    }

    private void setSelectSampleData(Select select) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("first", "First", null));
        sampleItems.add(new SampleItem("second", "Second", null));
        sampleItems.add(new SampleItem("third", "Third", Boolean.TRUE));
        sampleItems.add(new SampleItem("fourth", "Fourth", null));
        select.setItems(sampleItems);
        select.setItemLabelGenerator(item -> ((SampleItem) item).label());
        select.setItemEnabledProvider(item -> !Boolean.TRUE.equals(((SampleItem) item).disabled()));
    }
}
