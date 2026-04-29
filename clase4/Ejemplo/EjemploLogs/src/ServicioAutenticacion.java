import java.util.logging.Logger;

public class ServicioAutenticacion {

    private static final Logger logger = Logger.getLogger(ServicioAutenticacion.class.getName());

    public void login(String usuario, String password) throws AutenticacionException {

        logger.info("Intentando autenticar usuario: " + usuario);

        if (usuario == null || password == null) {
            logger.warning("Usuario o contraseña nulos");
            throw new AutenticacionException("Datos de acceso inválidos");
        }

        if (!usuario.equals("admin") || !password.equals("1234")) {
            logger.warning("Credenciales incorrectas para usuario: " + usuario);
            throw new AutenticacionException("Credenciales incorrectas");
        }

        logger.info("Usuario autenticado correctamente: " + usuario);
    }
}