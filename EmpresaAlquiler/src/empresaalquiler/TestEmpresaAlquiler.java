package empresaalquiler;

public class TestEmpresaAlquiler {

    public static void main(String[] args) {
        System.out.println("=== INICIO DE PRUEBAS EMPRESA ALQUILER ===\n");

        testAgregarCliente();
        testAgregarClienteDuplicado();
        testBuscarCliente();

        testAgregarVehiculo();
        testAgregarVehiculoDuplicado();
        testBuscarVehiculo();

        testAlquilarVehiculo_OK();
        testAlquilarClienteNoExiste();
        testAlquilarVehiculoNoExiste();
        testAlquilarVehiculoYaAlquilado();
        testAlquilarLimiteDos();

        testDevolverVehiculo_OK();
        testDevolverClienteNoExiste();
        testDevolverNoLoTieneEseCliente();
        testDevolverNoEstabaAlquilado();

        testContarAlquileresDeCliente();

        testMostrarAlquileresDeCliente_visual();
        testMostrarClientes_visual();
        testMostrarVehiculos_visual();

        System.out.println("\n=== FIN DE PRUEBAS ===");
    }

    private static EmpresaAlquiler empresaBase() {
        EmpresaAlquiler e = new EmpresaAlquiler("AlquilaTodo");

        e.agregarVehiculo(new Coche("1111AAA", "Toyota", "Corolla", 5));
        e.agregarVehiculo(new Moto("2222BBB", "Yamaha", "MT-07", 689));
        e.agregarVehiculo(new Furgoneta("3333CCC", "Ford", "Transit", 1200));
        e.agregarVehiculo(new Coche("4444DDD", "Seat", "Ibiza", 3));

        e.agregarCliente(new Cliente("11111111A", "Laura Martín"));
        e.agregarCliente(new Cliente("22222222B", "Mario Díaz"));

        return e;
    }

    private static void testAgregarCliente() {
        EmpresaAlquiler e = new EmpresaAlquiler("AlquilaTodo");
        boolean ok = e.agregarCliente(new Cliente("11111111A", "Laura Martín"));
        mostrarResultado("Test agregar cliente", ok);
    }

    private static void testAgregarClienteDuplicado() {
        EmpresaAlquiler e = new EmpresaAlquiler("AlquilaTodo");
        e.agregarCliente(new Cliente("11111111A", "Laura Martín"));
        boolean ok = !e.agregarCliente(new Cliente("11111111A", "Otra Persona"));
        mostrarResultado("Test agregar cliente duplicado (DNI)", ok);
    }

    private static void testBuscarCliente() {
        EmpresaAlquiler e = new EmpresaAlquiler("AlquilaTodo");
        e.agregarCliente(new Cliente("11111111A", "Laura Martín"));

        Cliente c1 = e.buscarClientePorDni("11111111A");
        Cliente c2 = e.buscarClientePorDni("99999999Z");

        boolean ok = c1 != null && c1.getNombre().equals("Laura Martín") && c2 == null;
        mostrarResultado("Test buscar cliente por DNI", ok);
    }

    private static void testAgregarVehiculo() {
        EmpresaAlquiler e = new EmpresaAlquiler("AlquilaTodo");
        boolean ok = e.agregarVehiculo(new Coche("1111AAA", "Toyota", "Corolla", 5));
        mostrarResultado("Test agregar vehículo", ok);
    }

    private static void testAgregarVehiculoDuplicado() {
        EmpresaAlquiler e = new EmpresaAlquiler("AlquilaTodo");
        e.agregarVehiculo(new Coche("1111AAA", "Toyota", "Corolla", 5));
        boolean ok = !e.agregarVehiculo(new Moto("1111AAA", "Yamaha", "R3", 321));
        mostrarResultado("Test agregar vehículo duplicado (matrícula)", ok);
    }

    private static void testBuscarVehiculo() {
        EmpresaAlquiler e = new EmpresaAlquiler("AlquilaTodo");
        e.agregarVehiculo(new Coche("1111AAA", "Toyota", "Corolla", 5));

        Vehiculo v1 = e.buscarPorMatricula("1111AAA");
        Vehiculo v2 = e.buscarPorMatricula("9999ZZZ");

        boolean ok = v1 != null && v1.getMarca().equals("Toyota") && v2 == null;
        mostrarResultado("Test buscar vehículo por matrícula", ok);
    }

    private static void testAlquilarVehiculo_OK() {
        EmpresaAlquiler e = empresaBase();

        boolean r = e.alquilarVehiculo("1111AAA", "11111111A");
        Vehiculo v = e.buscarPorMatricula("1111AAA");

        boolean ok = r && v != null && v.isAlquilado()
                && e.contarAlquileresDeCliente("11111111A") == 1
                && "11111111A".equals(e.quienTieneElVehiculo("1111AAA"));

        mostrarResultado("Test alquilar vehículo a cliente (OK)", ok);
    }

    private static void testAlquilarClienteNoExiste() {
        EmpresaAlquiler e = empresaBase();

        boolean r = e.alquilarVehiculo("1111AAA", "99999999Z");
        boolean ok = !r;

        mostrarResultado("Test alquilar (cliente no existe)", ok);
    }

    private static void testAlquilarVehiculoNoExiste() {
        EmpresaAlquiler e = empresaBase();

        boolean r = e.alquilarVehiculo("9999ZZZ", "11111111A");
        boolean ok = !r;

        mostrarResultado("Test alquilar (vehículo no existe)", ok);
    }

    private static void testAlquilarVehiculoYaAlquilado() {
        EmpresaAlquiler e = empresaBase();

        boolean r1 = e.alquilarVehiculo("1111AAA", "11111111A");
        boolean r2 = e.alquilarVehiculo("1111AAA", "22222222B");

        boolean ok = r1 && !r2
                && e.contarAlquileresDeCliente("11111111A") == 1
                && e.contarAlquileresDeCliente("22222222B") == 0;

        mostrarResultado("Test alquilar vehículo ya alquilado", ok);
    }

    private static void testAlquilarLimiteDos() {
        EmpresaAlquiler e = empresaBase();

        boolean r1 = e.alquilarVehiculo("1111AAA", "11111111A");
        boolean r2 = e.alquilarVehiculo("2222BBB", "11111111A");
        boolean r3 = e.alquilarVehiculo("3333CCC", "11111111A"); // debe fallar (3º)

        boolean ok = r1 && r2 && !r3
                && e.contarAlquileresDeCliente("11111111A") == 2;

        mostrarResultado("Test límite 2 alquileres por cliente", ok);
    }

    private static void testDevolverVehiculo_OK() {
        EmpresaAlquiler e = empresaBase();

        e.alquilarVehiculo("1111AAA", "11111111A");
        boolean r = e.devolverVehiculo("1111AAA", "11111111A");
        Vehiculo v = e.buscarPorMatricula("1111AAA");

        boolean ok = r && v != null && !v.isAlquilado()
                && e.contarAlquileresDeCliente("11111111A") == 0
                && e.quienTieneElVehiculo("1111AAA") == null;

        mostrarResultado("Test devolver vehículo (OK)", ok);
    }

    private static void testDevolverClienteNoExiste() {
        EmpresaAlquiler e = empresaBase();

        e.alquilarVehiculo("1111AAA", "11111111A");
        boolean r = e.devolverVehiculo("1111AAA", "99999999Z");

        boolean ok = !r && e.buscarPorMatricula("1111AAA").isAlquilado();
        mostrarResultado("Test devolver (cliente no existe)", ok);
    }

    private static void testDevolverNoLoTieneEseCliente() {
        EmpresaAlquiler e = empresaBase();

        e.alquilarVehiculo("1111AAA", "11111111A");
        boolean r = e.devolverVehiculo("1111AAA", "22222222B");

        boolean ok = !r
                && e.contarAlquileresDeCliente("11111111A") == 1
                && e.contarAlquileresDeCliente("22222222B") == 0;

        mostrarResultado("Test devolver (no lo tiene ese cliente)", ok);
    }

    private static void testDevolverNoEstabaAlquilado() {
        EmpresaAlquiler e = empresaBase();

        boolean r = e.devolverVehiculo("1111AAA", "11111111A");
        boolean ok = !r;

        mostrarResultado("Test devolver (no estaba alquilado)", ok);
    }

    private static void testContarAlquileresDeCliente() {
        EmpresaAlquiler e = empresaBase();

        e.alquilarVehiculo("1111AAA", "11111111A");
        e.alquilarVehiculo("2222BBB", "11111111A");

        int n1 = e.contarAlquileresDeCliente("11111111A");
        int n2 = e.contarAlquileresDeCliente("99999999Z"); // no existe => -1

        boolean ok = (n1 == 2) && (n2 == -1);

        mostrarResultado("Test contarAlquileresDeCliente", ok);
    }

    private static void testMostrarAlquileresDeCliente_visual() {
        EmpresaAlquiler e = empresaBase();
        e.alquilarVehiculo("1111AAA", "11111111A");
        e.alquilarVehiculo("2222BBB", "11111111A");

        System.out.println("\nTest mostrar alquileres de un cliente (comprobación visual):");
        e.mostrarAlquileresDeCliente("11111111A");
        System.out.println("Resultado esperado: 2 vehículos listados (matrícula y modelo).");
        System.out.println("Test mostrar alquileres de cliente - OK (si la salida es correcta)\n");
    }

    private static void testMostrarClientes_visual() {
        EmpresaAlquiler e = empresaBase();
        e.alquilarVehiculo("1111AAA", "11111111A");

        System.out.println("Test mostrar clientes (comprobación visual):");
        e.mostrarClientes();
        System.out.println("Resultado esperado: 2 clientes; Laura con 1 alquiler, Mario con 0.");
        System.out.println("Test mostrar clientes - OK (si la salida es correcta)\n");
    }

    private static void testMostrarVehiculos_visual() {
        EmpresaAlquiler e = empresaBase();
        e.alquilarVehiculo("1111AAA", "11111111A");

        System.out.println("Test mostrar vehículos (comprobación visual):");
        e.mostrarVehiculos();
        System.out.println("Resultado esperado: 4 vehículos; el 1111AAA figura como alquilado y con DNI asociado.");
        System.out.println("Test mostrar vehículos - OK (si la salida es correcta)\n");
    }

    private static void mostrarResultado(String test, boolean ok) {
        if (ok) {
            System.out.println(test + " - OK");
        } else {
            System.out.println(test + " - KO");
        }
    }
}
