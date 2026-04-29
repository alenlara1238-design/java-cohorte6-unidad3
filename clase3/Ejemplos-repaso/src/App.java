import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        int x = 5 + 3;
        
        retirar(x, x);
        Scanner scanner = new Scanner(System.in);
        int edad2 = scanner.nextInt();
        //manejamos directamente la excepción...
        try {
            System.out.print("Enter your age: ");
            int age = scanner.nextInt(); //aqui se puede romper si el usuario ingresa algo que no es un número
            System.out.println("You are " + age + " years old.");//si todo fue bien se ejecuta esta línea
        } catch (InputMismatchException e) {
            System.out.println("Buscamos la alternativa...la edad se estableció en 0 por defecto");
        }
        scanner.close();
    }

    public static void retirar(double monto, double saldo) throws SaldoInsuficienteException {
        if (monto > saldo) {
            throw new SaldoInsuficienteException("No tienes suficiente saldo para retirar " + monto);
        }
        // lógica para retirar el dinero: monto a retirar no puede ser mayor a saldo disponible.
    }

    public void metodoA() throws Exception {
        metodoB();
    }

    public void metodoB() throws Exception {
        System.out.println("Estamos en metodoB...otros procesos");
        throw new Exception("Ocurrió un error en metodoB");
    }

    /*
        procesarCompra();
        validarPago();
        conetarBanco();

        leerArchivo();

        cargarConfiguracion(){
            try {
                leerArchivo();
            } catch (IOException e) {
               usarCOnfiguracionDefault();
               log.error("No se pudo cargar la configuración, se usará la configuración por defecto", e);
            }
        }
    */
}
