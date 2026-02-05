package empresaalquiler;

public class EmpresaAlquiler {

    private String nombre;

    private Vehiculo[] vehiculos;
    private int numVehiculos;

    private Cliente[] clientes;
    private int numClientes;

    // Array paralelo: posición i se asocia a vehiculos[i]
    // null => disponible
    // dni => alquilado por ese cliente
    private String[] dniAlquiler;

    public EmpresaAlquiler(String nombre) {
        // TODO:
        // - inicializar nombre
        // - crear arrays: vehiculos[100], clientes[50], dniAlquiler[100]
        // - contadores a 0
    }

    public String getNombre() {
        // TODO
        return null;
    }

    public boolean agregarVehiculo(Vehiculo v) {
        // TODO:
        // - v != null
        // - hay hueco
        // - matrícula no repetida
        // - insertar y aumentar numVehiculos
        // - dniAlquiler en esa posición debe quedar null
        return false;
    }

    public Vehiculo buscarPorMatricula(String matricula) {
        // TODO:
        // - recorrer vehiculos[0..numVehiculos)
        // - devolver el encontrado o null
        return null;
    }

    public boolean agregarCliente(Cliente c) {
        // TODO:
        // - c != null
        // - hay hueco
        // - dni no repetido
        // - insertar y aumentar numClientes
        return false;
    }

    public Cliente buscarClientePorDni(String dni) {
        // TODO
        return null;
    }

    public int contarVehiculosAlquilados() {
        // TODO:
        // - contar vehiculos[i].isAlquilado() en 0..numVehiculos
        return 0;
    }

    public int contarVehiculosDisponibles() {
        // TODO:
        // - numVehiculos - contarVehiculosAlquilados()
        return 0;
    }

    public boolean alquilarVehiculo(String matricula, String dniCliente) {
        // TODO (flujo recomendado):
        // 1) buscar vehículo y cliente
        // 2) validar existen
        // 3) validar vehículo no esté alquilado
        // 4) validar cliente puedeAlquilar()
        // 5) si cliente.alquilarVehiculo(v) es true:
        //    - registrar dniAlquiler en la posición del vehículo
        //    - devolver true
        return false;
    }

    public boolean devolverVehiculo(String matricula, String dniCliente) {
        // TODO (flujo recomendado):
        // 1) buscar vehículo y cliente
        // 2) validar existen
        // 3) validar vehículo está alquilado
        // 4) validar quienTieneElVehiculo(matricula) coincide con dniCliente
        // 5) si cliente.devolverVehiculo(matricula) es true:
        //    - poner dniAlquiler[pos] = null
        //    - devolver true
        return false;
    }

    public String quienTieneElVehiculo(String matricula) {
        // TODO:
        // - localizar el índice del vehículo
        // - devolver dniAlquiler[i] (puede ser null)
        return null;
    }

    public int contarAlquileresDeCliente(String dniCliente) {
        // TODO:
        // - si cliente no existe => -1
        // - si existe => cliente.getNumAlquilados()
        return 0;
    }

    public void mostrarVehiculos() {
        // TODO:
        // - listar todos los vehículos
        // - incluir estado y, si está alquilado, dni asociado
    }

    public void mostrarClientes() {
        // TODO:
        // - listar todos los clientes y su numAlquilados
    }

    public void mostrarAlquileresDeCliente(String dniCliente) {
        // TODO:
        // - si no existe cliente, mostrar aviso
        // - si existe, listar los vehículos alquilados por ese cliente
    }

    // Método auxiliar (recomendado, opcional)
    private int posicionVehiculo(String matricula) {
        // TODO:
        // - devolver índice o -1
        return -1;
    }
}
