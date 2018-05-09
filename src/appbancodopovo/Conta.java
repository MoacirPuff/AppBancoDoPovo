package appbancodopovo;

public class Conta {
    private int numero;
    private double saldo;
    private Cliente cliente;
    
    //construtores
    public Conta(int numero) {
        this.numero = numero;
        saldo = 0.0;
        
        //associacao
        cliente = new Cliente();
    }

    public Conta() {
    }
    
    //encapsulamento
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    //metodos
    
    //toString
    @Override
    public String toString(){
        return cliente.toString() + "\nNúmero da Conta: " + numero + "\nSaldo: R$" + saldo;
    }
    
    //metodo de deposito
    public void depositar(double quantia){
        saldo += quantia;
    }
    
    //metodo de saque
    public boolean sacar(double quantia){
        if(saldo >= quantia){
            saldo -= quantia;
            return true;
        } else {
            return false;
        }
    }
}
