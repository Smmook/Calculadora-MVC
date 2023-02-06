package view;

import controller.ControladorCalculadora;
import controller.OperationsEnum;

public interface VistaInterfaz {
    void setController(ControladorCalculadora c);
    void start();

    double getFirstNumber();
    double getSecondNumber();

    void printResult(String s);

    OperationsEnum getOperation();
}
