import controller.ControladorCalculadora;
import model.ModeloCalculadora;
import view.VistaCalculadora;

public class Main {
    public static void main(String[] args) {
        ModeloCalculadora modelo = new ModeloCalculadora();
        VistaCalculadora vista = new VistaCalculadora();
        ControladorCalculadora controlador = new ControladorCalculadora(vista, modelo);

        vista.setController(controlador);

        vista.start();
    }
}