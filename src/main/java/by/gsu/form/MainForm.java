package by.gsu.form;


import by.gsu.domain.Product;
import by.gsu.form.custom.ButtonRender;
import by.gsu.form.custom.CalculateButtonEditor;
import by.gsu.form.custom.tablemodel.CheckBoxColumnTableModel;
import by.gsu.repository.ConnectionHolder;
import by.gsu.repository.impl.ProductRepositoryImpl;
import by.gsu.service.ProductService;
import by.gsu.service.ProductServiceImpl;
import by.gsu.util.FormUtil;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.List;
import java.util.function.ObjIntConsumer;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MainForm extends AbstractForm {

    private static final int PREF_WIDTH = 1300;
    private static final int PREF_HEIGHT = 500;
    private static final String TITLE = "Система рассчета стоимости продукции";

    private static final String SELECTION_COLUMN_NAME = "Выбор";
    private static final String NUMBER_COLUMN_NAME = "№";
    private static final String ACTION_COLUMN_NAME = "Действие";
    private static final String HIDDEN_COLUMN_NAME = "Hidden";

    private JPanel mainPanel;
    private JTable productsTable;

    private JButton addProductButton;
    private JButton deleteProductButton;

    private ProductService productService;

    public MainForm() {
        productService = new ProductServiceImpl(new ProductRepositoryImpl());

        productsTable.setRowSelectionAllowed(true);

        initProductsTable();

//        addProductButton.addActionListener(e -> FormUtil.openForm(new AddNewPerson(this)));

        deleteProductButton.addActionListener(e -> {
            deleteProduct();
            initProductsTable();
        });
    }

    private void deleteProduct() {
        deleteEntity(productsTable, "Не выбераны изделия для удаления!", (tableModel, rowIndex) -> {
            Product product = (Product) tableModel.getValueAt(rowIndex, 11);
            productService.delete(product);
        });
    }

    private void deleteEntity(JTable table, String errorMessage, ObjIntConsumer<TableModel> deleteAction) {
        TableModel tableModel = table.getModel();

        int checkedRowCount = 0;
        for (int i = 0; i < table.getRowCount(); i++) {
            boolean isCheckedRow = Boolean.parseBoolean(String.valueOf(tableModel.getValueAt(i, 0)));
            if (isCheckedRow) {
                checkedRowCount++;
                deleteAction.accept(tableModel, i);
            }
        }

        if (checkedRowCount == 0) {
            JOptionPane.showMessageDialog(mainPanel, errorMessage, "Предупреждение", WARNING_MESSAGE);
        }
    }

    public void initProductsTable() {
        String[] columnNames = new String[]{SELECTION_COLUMN_NAME, NUMBER_COLUMN_NAME,
                "Наименование", "Сырье и материалы, т. руб", "Комплектующие, т. руб", "Возвратные отходы, %",
                "Топливо и энергия, т. руб", "Заработная плата, т. руб", "Прибыль, %", "НДС, %",
                ACTION_COLUMN_NAME, HIDDEN_COLUMN_NAME};

        List<Product> products = productService.getAll();
        Object[][] data = new Object[products.size()][columnNames.length];

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            data[i][0] = false;
            data[i][1] = i + 1;
            data[i][2] = product.getName();
            data[i][3] = product.getRawAndMaterials();
            data[i][4] = product.getComponents();
            data[i][5] = product.getRecyclableAndWaste();
            data[i][6] = product.getFuelAndEnergy();
            data[i][7] = product.getSalary();
            data[i][8] = product.getProfit();
            data[i][9] = product.getVat();
            data[i][10] = "Рассчитать стоимость";
            data[i][11] = product;
        }

        this.productsTable.setModel(new CheckBoxColumnTableModel(data, columnNames, 0, 10));
        setColumnSizes(this.productsTable);

        TableColumn actionColumn = this.productsTable.getColumn(ACTION_COLUMN_NAME);
        actionColumn.setCellRenderer(new ButtonRender());
        actionColumn.setCellEditor(new CalculateButtonEditor(
                event -> {
                    JOptionPane.showMessageDialog(mainPanel, "Стоимость = 23432 руб.", "Результаты рассчета", INFORMATION_MESSAGE);
                }));
    }

    private void setColumnSizes(JTable productsTable) {
        TableColumn selectionColumn = productsTable.getColumn(SELECTION_COLUMN_NAME);
        selectionColumn.setWidth(70);
        selectionColumn.setMaxWidth(70);

        TableColumn numberColumn = productsTable.getColumn(NUMBER_COLUMN_NAME);
        numberColumn.setWidth(30);
        numberColumn.setMaxWidth(30);

        TableColumn actionColumn = productsTable.getColumn(ACTION_COLUMN_NAME);
        actionColumn.setMinWidth(150);

        TableColumn hiddenColumn = productsTable.getColumn(HIDDEN_COLUMN_NAME);
        hiddenColumn.setWidth(0);
        hiddenColumn.setMinWidth(0);
        hiddenColumn.setMaxWidth(0);
    }

    @Override
    public JPanel getMainPanel() {
        return mainPanel;
    }

    @Override
    public String getTitle() {
        return TITLE;
    }

    @Override
    public int getWidth() {
        return PREF_WIDTH;
    }

    @Override
    public int getHeight() {
        return PREF_HEIGHT;
    }

    @Override
    public int getDefaultCloseOperation() {
        return EXIT_ON_CLOSE;
    }

    @Override
    public void onCloseAction() {
        ConnectionHolder.closeConnection();
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(0, 0));
        mainPanel.setEnabled(true);
        mainPanel.setVisible(true);
        final JTabbedPane tabbedPane1 = new JTabbedPane();
        Font tabbedPane1Font = this.$$$getFont$$$(null, -1, 12, tabbedPane1.getFont());
        if (tabbedPane1Font != null) tabbedPane1.setFont(tabbedPane1Font);
        mainPanel.add(tabbedPane1, BorderLayout.CENTER);
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout(0, 0));
        tabbedPane1.addTab("Изделия", panel1);
        final JScrollPane scrollPane1 = new JScrollPane();
        scrollPane1.setHorizontalScrollBarPolicy(31);
        panel1.add(scrollPane1, BorderLayout.CENTER);
        productsTable = new JTable();
        productsTable.setAutoCreateRowSorter(true);
        scrollPane1.setViewportView(productsTable);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridBagLayout());
        panel1.add(panel2, BorderLayout.SOUTH);
        deleteProductButton = new JButton();
        deleteProductButton.setMargin(new Insets(0, 0, 0, 0));
        deleteProductButton.setPreferredSize(new Dimension(199, 26));
        deleteProductButton.setText("Удалить изделие");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);
        panel2.add(deleteProductButton, gbc);
        addProductButton = new JButton();
        addProductButton.setHorizontalTextPosition(0);
        addProductButton.setMargin(new Insets(0, 0, 0, 0));
        addProductButton.setMinimumSize(new Dimension(700, 26));
        addProductButton.setOpaque(false);
        addProductButton.setPreferredSize(new Dimension(700, 26));
        addProductButton.setText("Добавить изделие");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 0, 5);
        panel2.add(addProductButton, gbc);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }

}