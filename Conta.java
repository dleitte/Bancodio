package models;

public class Conta {
    private static int contador = 0; 
    private int id;
    private String titular;
    private double saldo;

    public Conta(String titular, double saldoInicial) {
        this.id = ++contador;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public int getId() { return id; }
    public String getTitular() { return titular; }
    public void setTitular(String titular) { this.titular = titular; }
    public double getSaldo() { return saldo; }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Conta{id=" + id + ", titular='" + titular + "', saldo=" + saldo + "}";
    }
}
