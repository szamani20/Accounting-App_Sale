package gui;

import controller.Controller;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private FormPanel formPanel;
    private Controller controller;

    public MainFrame() {
        super("Darpa");

        setLayout(new BorderLayout());

        formPanel = new FormPanel();
        controller = new Controller();

        formPanel.setFormListener(event -> controller.setClient(event));

        add(formPanel, BorderLayout.CENTER);

        setSize(300, 800);
        setMinimumSize(new Dimension(300, 800));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
