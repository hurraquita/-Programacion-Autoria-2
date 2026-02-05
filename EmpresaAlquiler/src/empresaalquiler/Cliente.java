package empresaalquiler;

public class Cliente {

    private String dni;
    private String nombre;

    private Vehiculo[] alquilados;
    private int numAlquilados;
    final int MAX_ALQUILADOS = 2;

    public Cliente(String dni, String nombre) {
                this.dni = dni;
        this.nombre = nombre;
        // para construir los arrays simplemente hacer uno nuvo con el mismo nombre y 
        //distinto rango
        this.alquilados = new Vehiculo[MAX_ALQUILADOS];
        this.numAlquilados = 0;
            // TODO:
            
        // - inicializar dni y nombre
        // - crear alquilados con tamaño 2 (límite de alquileres)
        // - numAlquilados = 0
    }


    public String getDni() {
        return this.dni;
        // TODO
    }

    public String getNombre() {
        // TODO
        return this.nombre;
    }

    public int getNumAlquilados() {
        // TODO
        return this.numAlquilados;
    }

    public boolean puedeAlquilar() {
        // TODO: numAlquilados < alquilados.length
        return numAlquilados < this.alquilados.length;
    }

    public boolean tieneVehiculo(String matricula) {
       boolean resultado = false;
        // TODO:
        // - recorrer alquilados hasta numAlquilados
        // - comparar matricula
        for (int i = 0; i < MAX_ALQUILADOS-1; i++) {
            if (alquilados[i].getMatricula().equals(matricula)) {
                resultado = true;
            }
        }
        return resultado;
    }

    public boolean alquilarVehiculo(Vehiculo v) {
        // TODO:
        // Validaciones mínimas:
        // 1) v != null
        // 2) puedeAlquilar()
        // 3) no lo tiene ya (por matrícula)
        // 4) v no está alquilado
        // Acción:
        // - llamar v.alquilar()
        // - guardarlo en alquilados[numAlquilados]
        // - numAlquilados++
        boolean resultado=false;
        //ponerlo todo en el mismo if con && y tomando prestado de vehiculo.
        if (resultado) {
            
        }
        return false;
    }

    public boolean devolverVehiculo(String matricula) {
        // TODO:
        // - buscar vehículo por matrícula en alquilados[0..numAlquilados)
        // - si existe: llamar devolver(), compactar array (sin huecos), numAlquilados--, true
        // - si no existe: false
        return false;
    }

    public void mostrar() {
        // TODO:
        // imprimir dni, nombre, numAlquilados y listar matrículas alquiladas.
    }
}
