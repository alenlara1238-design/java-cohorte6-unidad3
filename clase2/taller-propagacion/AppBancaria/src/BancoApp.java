public class BancoApp {
    private Cajero cajero;

    public BancoApp() {
        this.cajero = new Cajero();
    }

    public void realizarRetiro(Cuenta cuenta, double monto) throws MontoInvalidoException  {
        cajero.procesarRetiro(cuenta, monto);
    }

    public void realizarTransferencia(Cuenta origen, Cuenta destino, double monto) throws MontoInvalidoException, SaldoInsuficienteException {
        cajero.procesarTransferencia(origen, destino, monto);
    }
}
