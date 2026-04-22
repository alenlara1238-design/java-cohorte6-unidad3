public class ServicioAutenticacion {
   
   public ServicioAutenticacion() {};
   
    public void autenticar(Cuenta cuenta, String claveIngresada) throws AuthenticationException {
       if(!cuenta.getClave().equals(claveIngresada)){
              throw new AuthenticationException("Clave incorrecta");
       }
    }
}
