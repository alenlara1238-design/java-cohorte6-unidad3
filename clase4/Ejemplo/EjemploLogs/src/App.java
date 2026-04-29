import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class App {

    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) throws Exception {
        try {
            FileHandler archivo = new FileHandler("app.log", true);
            archivo.setFormatter(new SimpleFormatter());
            logger.addHandler(archivo);

            ServicioAutenticacion servicio = new ServicioAutenticacion();

            Scanner sc = new Scanner(System.in);

            System.out.print("Usuario: ");
            String usuario = sc.nextLine();

            System.out.print("Contraseña: ");
            String password = sc.nextLine();

            servicio.login(usuario, password);

            System.out.println("Acceso concedido");

        } catch (AutenticacionException e) {
            logger.severe("Error de autenticación: " + e.getMessage());
            System.out.println("Acceso denegado: " + e.getMessage());

        } catch (IOException e) {
            logger.severe("Error al configurar archivo de logs");
            e.printStackTrace();
        }
    }
}
