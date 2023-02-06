package controller;

import model.ModeloCalculadora;
import view.VistaInterfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorCalculadora implements ActionListener {

    private VistaInterfaz vista;
    private ModeloCalculadora modelo;

    public ControladorCalculadora(VistaInterfaz vista, ModeloCalculadora modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double a = vista.getFirstNumber();
        double b = vista.getSecondNumber();

        switch (vista.getOperation()) {
            case SUMA -> vista.printResult(String.valueOf(modelo.sumar(a, b)));
            case RESTA -> vista.printResult(String.valueOf(modelo.restar(a, b)));
            case MULTIPLICACION -> vista.printResult(String.valueOf(modelo.multiplicar(a, b)));
            case DIVISION -> {
                try {
                    vista.printResult(String.valueOf(modelo.dividir(a, b)));
                } catch (ArithmeticException error) {
                    System.out.println("Division por cero");
                    vista.printResult("No se puede dividir por 0!");
                }
            }
            default -> vista.printResult("Error!");
        }
    }
}
