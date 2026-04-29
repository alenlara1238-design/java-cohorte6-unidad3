public class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String message) {
        super(message); //satisfacer el contructor de la clase padre Exception
    }
  // Estamos creando un uevo tipo de error personalizado con significado dentro de la lógica de nuestro programa.
}
