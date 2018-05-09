package appbancodopovo;

import java.util.ArrayList;

public class GerenciaContas {
    //declaração ArrayList
    static ArrayList<Conta> contas = new ArrayList();

    //metodos
    
    //adicionar conta
    static void adicionarConta(Conta conta){
        contas.add(conta);
    }
    
    //listagem de contas
    static String listarContas(){
        String saida = "";
        
        //validacao de existencia de contas
        if(contas.isEmpty()){
            saida = "Não há contas cadastradas!!!";
        } else {
            for(Conta c : contas){
                saida += c.toString() + "\n";
            }
        }
        return saida;
    }
    
    //busca de conta
    static Conta buscarConta(int numero) {
        for(Conta c : contas){
            if(c.getNumero() == numero) {
                return c;
            }
        }
        return null;
    }
}
 
