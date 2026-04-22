public class App {
    public static void main(String[] args) throws Exception {
        BancoApp bancoApp = new BancoApp();
        ServicioAutenticacion autenticacion = new ServicioAutenticacion();

        Cuenta cuenta1 = new Cuenta("12345", "clave1", 1000.0);
        Cuenta cuenta2 = new Cuenta("67890", "clave2", 500.0);

        // caso 1: retiro exitoso
        try {   
            autenticacion.autenticar(cuenta1, "clave2");
            bancoApp.realizarRetiro(cuenta1, 200.0);
            System.out.println("Retiro exitoso. Nuevo saldo: " + cuenta1.getSaldo());
        } catch (MontoInvalidoException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (AuthenticationException e) {
            System.out.println("Error de autenticación: " + e.getMessage());
        }

        // caso 2: retiro con monto negativo
        try {
            bancoApp.realizarRetiro(cuenta1, -50.0);
            System.out.println("Retiro exitoso. Nuevo saldo: " + cuenta1.getSaldo());
        } catch (MontoInvalidoException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // caso 3: retiro con saldo insuficiente
        try {   
            bancoApp.realizarRetiro(cuenta1, 900.0);
            System.out.println("Retiro exitoso. Nuevo saldo: " + cuenta1.getSaldo());
        } catch (MontoInvalidoException e) {
            System.out.println("Error: " + e.getMessage());
        }


        // caso 4: transferencia con error de monto negativo
        try {       
            bancoApp.realizarTransferencia(cuenta1, cuenta2, -100.0);
            System.out.println("Transferencia exitosa. Nuevo saldo cuenta1: " + cuenta1.getSaldo() + ", nuevo saldo cuenta2: " + cuenta2.getSaldo());
        } catch (MontoInvalidoException | SaldoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    
}
