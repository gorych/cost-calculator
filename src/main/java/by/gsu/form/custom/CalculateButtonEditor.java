package by.gsu.form.custom;

import by.gsu.model.Calculation;
import by.gsu.model.Product;
import by.gsu.service.CalculationService;
import by.gsu.service.CalculationServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class CalculateButtonEditor extends DefaultCellEditor {

    private JButton button;
    private String label;
    private boolean isPressed;

    private transient Consumer<Calculation> onPressAction;
    private transient Product product;

    private CalculationService calculationService;

    public CalculateButtonEditor(Consumer<Calculation> onPressAction) {
        super(new JCheckBox());
        this.button = new JButton();
        this.button.setOpaque(true);
        this.button.addActionListener(e -> fireEditingStopped());
        this.onPressAction = onPressAction;
        this.calculationService = new CalculationServiceImpl();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        } else {
            button.setForeground(table.getForeground());
            button.setBackground(table.getBackground());
        }

        product = (Product) table.getModel().getValueAt(row, 11);

        label = (value == null) ? "" : value.toString();
        button.setText(label);
        isPressed = true;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        if (isPressed) {
            Calculation calculation = calculationService.calculate(product);
            onPressAction.accept(calculation);
        }
        isPressed = false;
        return label;
    }

    @Override
    public boolean stopCellEditing() {
        isPressed = false;
        return super.stopCellEditing();
    }
}

