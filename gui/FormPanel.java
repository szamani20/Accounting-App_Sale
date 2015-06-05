package gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyEvent;

public class FormPanel extends JPanel {

    private JLabel nameLabel;
    private JLabel lastNameLabel;
    private JLabel phoneLabel;
    private JLabel passwordLabel;
    private JLabel productLabel;
    private JLabel priceLabel;
    private JLabel amountLabel;
    private JLabel totalLabel;
    private JLabel paymentLabel;
    private JLabel debtLabel;
    private JLabel paidLabel;
    private JLabel yearLabel;
    private JLabel monthLabel;
    private JLabel dayLabel;

    private JTextField nameField;
    private JTextField lastNameField;
    private JTextField phoneField;
    private JPasswordField passwordField;
    private JComboBox productCombo;
    private JSpinner priceSpinner;
    private JSpinner amountSpinner;
    private JSpinner totalSpinner;
    private JSpinner paymentSpinner;
    private JSpinner debtSpinner;
    private JCheckBox paid;
    private JSpinner yearSpinner;
    private JSpinner monthSpinner;
    private JSpinner daySpinner;

    private JButton okButton;

    private FormListener formListener;

    public FormPanel() {
        Dimension dimension = getPreferredSize();
        setPreferredSize(dimension);

        nameLabel = new JLabel("Name: ");
        lastNameLabel = new JLabel("Last name: ");
        phoneLabel = new JLabel("Phone number: ");
        passwordLabel = new JLabel("Password: ");
        productLabel = new JLabel("Product: ");
        priceLabel = new JLabel("Price: ");
        amountLabel = new JLabel("Amount: ");
        totalLabel = new JLabel("Total Price: ");
        paymentLabel = new JLabel("Payment: ");
        debtLabel = new JLabel("Debt: ");
        paidLabel = new JLabel("Paid? ");
        yearLabel = new JLabel("Year: ");
        monthLabel = new JLabel("Month: ");
        dayLabel = new JLabel("Day: ");

        nameField = new JTextField(10);
        lastNameField = new JTextField(10);
        phoneField = new JTextField(10);
        passwordField = new JPasswordField(10);
        productCombo = new JComboBox();
        SpinnerNumberModel priceModel = new SpinnerNumberModel(0, 0, 90000000, 1);
        priceSpinner = new JSpinner(priceModel);
        SpinnerNumberModel amountModel = new SpinnerNumberModel(1, 1, 10, 1);
        amountSpinner = new JSpinner(amountModel);
        SpinnerNumberModel totalModel = new SpinnerNumberModel(0, 0, 900000000, 1);
        totalSpinner = new JSpinner(totalModel);
        SpinnerNumberModel paymentModel = new SpinnerNumberModel(0, 0, 900000000, 1);
        paymentSpinner = new JSpinner(paymentModel);
        SpinnerNumberModel debtModel = new SpinnerNumberModel(0, -900000000, 900000000, 1);
        debtSpinner = new JSpinner(debtModel);
        paid = new JCheckBox();
        SpinnerNumberModel yearModel = new SpinnerNumberModel(1394, 1394, 1440, 1);
        yearSpinner = new JSpinner(yearModel);
        SpinnerNumberModel monthModel = new SpinnerNumberModel(1, 1, 12, 1);
        monthSpinner = new JSpinner(monthModel);
        SpinnerNumberModel dayModel = new SpinnerNumberModel(1, 1, 30, 1);
        daySpinner = new JSpinner(dayModel);
        okButton = new JButton("OK");

        DefaultComboBoxModel productModel = new DefaultComboBoxModel();
        productModel.addElement(Products.C);
        productModel.addElement(Products.CPlusPlus);
        productModel.addElement(Products.Java);
        productModel.addElement(Products.Python);
        productModel.addElement(Products.JavaScript);
        productModel.addElement(Products.HTML);
        productModel.addElement(Products.CSS);
        productModel.addElement(Products.PHP);
        productModel.addElement(Products.JQuery);
        productModel.addElement(Products.MySQL);
        productModel.addElement(Products.Json);
        productModel.addElement(Products.Django);
        productCombo.setModel(productModel);
        productCombo.setSelectedIndex(2);

        phoneField.setText("09");

        okButton.addActionListener(e -> {

            if(!amountSpinner.getValue().equals(0)&& !priceSpinner.getValue().equals(0))
                totalSpinner.setValue((Integer)amountSpinner.getValue()*(Integer)priceSpinner.getValue());

            debtSpinner.setValue((Integer)totalSpinner.getValue() - (Integer)paymentSpinner.getValue());

            if (((Integer)totalSpinner.getValue() - (Integer)paymentSpinner.getValue()) != 0) {
                paid.setSelected(false);
                System.out.println("khar");
            }
            else System.out.println("kore khar");

            FormEvent event = new FormEvent(FormPanel.this, nameField.getText(),
                    lastNameField.getText(), phoneField.getText(),
                    new String(passwordField.getPassword()), (Products)productCombo.getSelectedItem(),
                    (Integer)priceSpinner.getValue(), (Integer)amountSpinner.getValue(),
                    (Integer)amountSpinner.getValue()*(Integer)priceSpinner.getValue(),
                    (Integer)paymentSpinner.getValue(), (Integer)debtSpinner.getValue(),
                    paid.isSelected(), (Integer)yearSpinner.getValue(), (Integer)monthSpinner.getValue(),
                    (Integer)daySpinner.getValue());

            if(formListener != null) {
                debtSpinner.setValue(0);
                totalSpinner.setValue(0);
                formListener.formEventOccur(event);
                nameField.setText("");
                lastNameField.setText("");
                phoneField.setText("09");
                passwordField.setText("");
                priceSpinner.setValue(0);
                amountSpinner.setValue(1);
                paymentSpinner.setValue(0);
                paid.setSelected(false);
                yearSpinner.setValue(1394);
                monthSpinner.setValue(1);
                daySpinner.setValue(1);
            }
        });


        okButton.setMnemonic(KeyEvent.VK_ENTER);

        Border innerBorder = BorderFactory.createTitledBorder("Add Family");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        layoutComponents();

    }

    public void layoutComponents() {
        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        gc.weighty = 0.1;
        gc.weightx = 2;
        gc.gridy = 0;

        /////////////////first row//////////////////
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(0, 0, 0, 5);

        add(nameLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);

        add(nameField, gc);

        ////////////////////next row//////////////////
        gc.gridy++;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(0, 0, 0, 5);

        add(lastNameLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);

        add(lastNameField, gc);

        ////////////////////next row//////////////////
        gc.gridy++;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(0, 0, 0, 5);

        add(phoneLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);

        add(phoneField, gc);

        ////////////////////next row//////////////////
        gc.gridy++;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(0, 0, 0, 5);

        add(passwordLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);

        add(passwordField, gc);

        ////////////////////next row//////////////////
        gc.gridy++;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(0, 0, 0, 5);

        add(productLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);

        add(productCombo, gc);

        ////////////////////next row//////////////////
        gc.gridy++;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(0, 0, 0, 5);

        add(priceLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);

        add(priceSpinner, gc);

        ////////////////////next row//////////////////
        gc.gridy++;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(0, 0, 0, 5);

        add(amountLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);

        add(amountSpinner, gc);

        ////////////////////next row//////////////////
        gc.gridy++;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(0, 0, 0, 5);

        add(totalLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);

        add(totalSpinner, gc);

        ////////////////////next row//////////////////
        gc.gridy++;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(0, 0, 0, 5);

        add(paymentLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);

        add(paymentSpinner, gc);

        ////////////////////next row//////////////////
        gc.gridy++;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(0, 0, 0, 5);

        add(debtLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);

        add(debtSpinner, gc);

        ////////////////////next row//////////////////
        gc.gridy++;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(0, 0, 0, 5);

        add(paidLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);

        add(paid, gc);

        ////////////////////next row//////////////////
        gc.gridy++;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(0, 0, 0, 5);

        add(yearLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);

        add(yearSpinner, gc);

        ////////////////////next row//////////////////
        gc.gridy++;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(0, 0, 0, 5);

        add(monthLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);

        add(monthSpinner, gc);

        ////////////////////next row//////////////////
        gc.gridy++;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(0, 0, 0, 5);

        add(dayLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);

        add(daySpinner, gc);

        ////////////////////next row//////////////////
        gc.gridy++;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = GridBagConstraints.NONE;
        gc.gridx = 1;
        gc.insets = new Insets(0, 0, 0, 0);

        add(okButton, gc);

    }

    public void setFormListener(FormListener formListener) {
        this.formListener = formListener;
    }

}
