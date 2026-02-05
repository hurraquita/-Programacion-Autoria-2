package empresaalquiler;

public class Furgoneta extends Vehiculo {

    private int cargaMaxKg;

    public Furgoneta(String matricula, String marca, String modelo, int cargaMaxKg) {
        super(matricula, marca, modelo);
        // TODO: inicializar cargaMaxKg.
        this.cargaMaxKg = cargaMaxKg;
    }

    public int getCargaMaxKg() {
        // TODO
        return this.cargaMaxKg;
    }

    @Override
    public void mostrar() {
        super.mostrar();
        System.out.println("Carga Maxima(kg): " + this.cargaMaxKg);
        
        // TODO:
        // Llamar a mostrar() del padre o imprimir lo común,
        // y añadir "cargaMaxKg".
    }
}
