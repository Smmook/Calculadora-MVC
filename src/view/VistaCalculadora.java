package view;

import controller.ControladorCalculadora;
import controller.OperationsEnum;

import javax.swing.*;
import java.awt.*;

public class VistaCalculadora extends JFrame implements VistaInterfaz {

    private JTextField a;
    private JTextField b;
    private JComboBox<OperationsEnum> op;
    private JButton btn;
    private JLabel result;
    private static final OperationsEnum[] options = OperationsEnum.values();

    public VistaCalculadora() {
        super("Calculadora con MVC pattern");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));

        a = new JTextField(4);
        b = new JTextField(4);
        op = new JComboBox<>(options);
        op.setSelectedIndex(0);
        JPanel operationPanel = new JPanel();
        operationPanel.add(a); operationPanel.add(op); operationPanel.add(b);
        mainPanel.add(operationPanel, BorderLayout.NORTH);

        btn = new JButton("Calcular");
        JPanel btnPanel = new JPanel();
        btnPanel.add(btn);
        mainPanel.add(btnPanel, BorderLayout.CENTER);

        result = new JLabel("Pulsa el boton para calcular");
        JPanel resultPanel = new JPanel();
        resultPanel.add(result);
        mainPanel.add(resultPanel, BorderLayout.SOUTH);

        getContentPane().add(mainPanel);
    }

    @Override
    public void setController(ControladorCalculadora c) {
        btn.addActionListener(c);
    }

    @Override
    public void start() {
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public double getFirstNumber() {
        try {
            return Double.parseDouble(a.getText());
        } catch (NumberFormatException e) {
            return 0.0d;
        }
    }

    @Override
    public double getSecondNumber() {
        try {
            return Double.parseDouble(b.getText());
        } catch (NumberFormatException e) {
            return 0.0d;
        }
    }

    @Override
    public void printResult(String s) {
        result.setText(s);
    }

    @Override
    public OperationsEnum getOperation() {
        return (OperationsEnum) op.getSelectedItem();
    }
}
