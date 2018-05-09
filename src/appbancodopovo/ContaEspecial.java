package appbancodopovo;

//herança da superclasse Conta
public class ContaEspecial extends Conta {
    private double limite;
    
    //construtor
    public ContaEspecial(int numero) {
        super(numero);
        limite = 500.0;
    }
    
    //encapsulamento
    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
    
    //metodos
    
    //toString
    @Override
    public String toString(){
        return super.toString() + "\nLimite: R$" + limite;
    }
    
    //metodo de saque
    @Override
    public boolean sacar(double quantia) {
        if(super.getSaldo() >= quantia) {
            double saldo = super.getSaldo();
            saldo -= quantia;
            super.setSaldo(saldo);
            return true;
        } else if(getLimite() >= quantia) {
            limite -= quantia;
            return true;
        } else {
            return false;
        }
    }
}
