package org.convertator.view;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.Route;
import org.convertator.domain.Item;

@Route
public class MainView extends VerticalLayout {

    public MainView() {
        Item item = new Item();
        VerticalLayout todosList = new VerticalLayout();
        ComboBox<String> select = new ComboBox<>("Select from unit");
        select.setItems("Miles", "Meters", "Foots", "Inchs");
        ComboBox<String> selectTo = new ComboBox<>("Select to unit");
        selectTo.setItems("Miles", "Meters", "Foots", "Inchs");
        NumberField taskField = new NumberField();
        Button convertButton = new Button("Convert");
        convertButton.addClickShortcut(Key.ENTER);
        select.addValueChangeListener(event -> {
            item.setFirstItem(event.getValue());
        });
        selectTo.addValueChangeListener(event -> {
            item.setSecondItem(event.getValue());
        });
        taskField.addValueChangeListener(event -> {
            item.setValue(taskField.getValue());
        });
        convertButton.addClickListener(event -> {
            item.convert(item);
            System.out.println("item.getValue()" + item.getValue());
            taskField.setValue(item.getResult());
        });


        add(
                new H1("Converter"),
                todosList,
                new HorizontalLayout(
                        select,
                        selectTo,
                        taskField,
                        convertButton
                )
        );
    }
}