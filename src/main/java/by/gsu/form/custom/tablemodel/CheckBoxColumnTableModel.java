package by.gsu.form.custom.tablemodel;

public class CheckBoxColumnTableModel extends ReadOnlyTableModel {

    public CheckBoxColumnTableModel(Object[][] data, Object[] columnNames, int... editableColumns) {
        super(data, columnNames, editableColumns);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
            return Boolean.class;
        }
        return super.getColumnClass(columnIndex);
    }


}