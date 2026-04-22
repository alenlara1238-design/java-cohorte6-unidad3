public class Cuenta {
    private String numeroCuenta;
    private double saldo;
    private String clave; // Agregamos el campo clave para autenticación

    public Cuenta(String numeroCuenta, String clave, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.clave = clave;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getClave() {
        return clave;
    }

    public void depositar(double monto) throws MontoInvalidoException {
        if (monto <= 0) {
            throw new MontoInvalidoException("El monto a depositar debe ser mayor que cero.");
        }
        saldo += monto;
    }

    public void retirar(double monto) throws MontoInvalidoException {
        if (monto <= 0) {
            throw new MontoInvalidoException("El monto a retirar debe ser mayor que cero.");
        }
        if (monto > saldo) {
            throw new MontoInvalidoException("Fondos insuficientes para realizar el retiro.");
        }
        saldo -= monto;
    }

    public void transferir(Cuenta destino, double monto) throws MontoInvalidoException, SaldoInsuficienteException {
        if (monto <= 0) {
            throw new MontoInvalidoException("El monto a transferir debe ser mayor que cero.");
        }
        if (monto > saldo) {
            throw new SaldoInsuficienteException("Fondos insuficientes para realizar la transferencia.");
        }
        this.retirar(monto);
        destino.depositar(monto);
    }
}
