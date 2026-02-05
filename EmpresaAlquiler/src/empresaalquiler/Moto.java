package empresaalquiler;

public class Moto extends Vehiculo {

    private int cilindrada;

    public Moto(String matricula, String marca, String modelo, int cilindrada) {
        super(matricula, marca, modelo);
        // TODO: inicializar cilindrada.
        this.cilindrada=cilindrada;
    }

    public int getCilindrada() {
        // TODO
        return this.cilindrada;
    }

    @Override
    public void mostrar() {
        super.mostrar();
        System.out.println("Cilindrada: " + this.cilindrada);
        // TODO:
        // Llamar a mostrar() del padre o imprimir lo común,
        // y añadir "cilindrada".
    }
}
