package empresaalquiler;

public class Vehiculo {

    private String matricula;
    private String marca;
    private String modelo;
    private boolean alquilado;

    public Vehiculo(String matricula, String marca, String modelo) {
        // TODO: inicializar atributos.
        // alquilado debe empezar en false.
                this.matricula = matricula;
        this.modelo = modelo;
        this.alquilado = false;
    }

    public String getMatricula() {
        // TODO
        return this.matricula;
    }

    public String getMarca() {
        // TODO
        return this.marca;
    }

    public String getModelo() {
        // TODO
        return this.modelo;
    }

    public boolean isAlquilado() {
        // TODO
        return this.alquilado;
    }

    public boolean alquilar() {
        // TODO:
        // - Si ya está alquilado => false.
        // - Si no, poner alquilado=true y devolver true.
        if(this.alquilado == true){
            System.out.println("Este vehiculo se encuentra alquilado");
                    return false;
        } else{
            System.out.println("Su vehiculo llegara dentro de poco");
            return true;
        }
    }

    public boolean devolver() {
        // TODO:
        // - Si no está alquilado => false.
        // - Si lo está, poner alquilado=false y devolver true.
        if (this.alquilado == false){
            System.out.println("Ese vehiculo no esta alquilado");
                    return false;
        } else{
            System.out.println("Pase por ventanilla 4");
            alquilado = false;
            return true;
        }
    }

    public void mostrar() {
        // TODO:
        // Imprimir matricula, marca, modelo y estado (alquilado/disponible).
        System.out.println("Matrícula: " + this.matricula);
        System.out.println("Marca: " + this.marca);
        System.out.println("Modelo: " + this.modelo);
        if (alquilado==true) {
             System.out.println("Estado: Alquilado");
        }else{
         System.out.println("Estado: Disponible");
        }
       
    }
}
