package empresaalquiler;

public class Coche extends Vehiculo {

    private int puertas;

    public Coche(String matricula, String marca, String modelo, int puertas) {
        super(matricula, marca, modelo);
        // TODO: inicializar puertas.
        this.puertas= puertas;
    }

    public int getPuertas() {
        // TODO
        return this.puertas;
    }

    @Override
    public void mostrar() {
        super.mostrar();
        System.out.println("nº Puertas: " + this.puertas);
        // TODO:
        // Llamar a mostrar() del padre o imprimir lo común,
        // y añadir "puertas".
    }
}
