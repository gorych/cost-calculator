package by.gsu.form;

import javax.swing.*;

public interface Form {

    JPanel getMainPanel();

    String getTitle();

    int getWidth();

    int getHeight();

    int getDefaultCloseOperation();

    void onCloseAction();

}