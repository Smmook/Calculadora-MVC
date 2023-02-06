package model;

public class ModeloCalculadora {
    public double sumar(double x, double y) {
        return x+y;
    }

    public double restar(double x, double y) {
        return x-y;
    }

    public double multiplicar(double x, double y) {
        return x*y;
    }

    public double dividir(double x, double y) throws ArithmeticException {
        if (y == 0d) throw new ArithmeticException("Division por 0");
        return x/y;
    }
}
