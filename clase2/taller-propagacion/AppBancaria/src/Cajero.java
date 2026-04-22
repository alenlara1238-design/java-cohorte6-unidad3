public class Cajero {

    public void procesarRetiro(Cuenta cuenta, double monto) throws MontoInvalidoException {
        cuenta.retirar(monto);
    }

    public void procesarDeposito(Cuenta cuenta, double monto) throws MontoInvalidoException {
        cuenta.depositar(monto);
    }

    public void procesarTransferencia(Cuenta origen, Cuenta destino, double monto) throws MontoInvalidoException, SaldoInsuficienteException {
        origen.transferir(destino, monto);
    }
}   
