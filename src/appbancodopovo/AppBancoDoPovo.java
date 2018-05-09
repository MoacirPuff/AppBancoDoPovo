package appbancodopovo;

import javax.swing.JOptionPane;

// RA: 21036783 - MOACIR LUIZ PUFF
// RA: 20747744 - GUILHERME RADEL
// RA: 20029522 - TIAGO BRAGA

public class AppBancoDoPovo {
    public static void main(String[] args) {
        int opcaoMenu;
        int opcaoRelatorio;
        int opcaoMovimentacao;
        boolean existeConta = false;
        
        //loop do aplicativo
        do {
            //interface do usuario com leitura de input de opcao
            opcaoMenu = Integer.parseInt(JOptionPane.showInputDialog("========MENU DE OPÇÕES========\n\n" +
                                                                     "1. Cadastrar Conta\n" + 
                                                                     "2. Cadastrar Conta Especial\n" +
                                                                     "3. Relatórios\n" +
                                                                     "4. Movimentações\n" +
                                                                     "5. Sair\n\n"));
            
            //desvio condicional de acordo com input
            switch(opcaoMenu) {
                //opcao 1 - cadastrar conta
                case 1:
                    Conta conta = new Conta(Integer.parseInt(JOptionPane.showInputDialog("Número da Conta: ")));
                   
                    Cliente cliente = new Cliente(JOptionPane.showInputDialog("CPF: "),
                                                  JOptionPane.showInputDialog("Nome: "), 
                                                  JOptionPane.showInputDialog("Endereço: "), 
                                                  JOptionPane.showInputDialog("Telefone: "));
                    
                    //associacao
                    conta.setCliente(cliente);
                    
                    GerenciaContas.adicionarConta(conta);
                    
                    //boolean para tornar a verificacao de existencia de conta durante deposito mais natural
                    existeConta = true;
                    
                    JOptionPane.showMessageDialog(null, "Conta cadastrada com sucesso!");
                    
                    break;

                //opcao 2 - cadastrar conta especial    
                case 2:
                    ContaEspecial contaEspecial = new ContaEspecial(Integer.parseInt(JOptionPane.showInputDialog("Número da Conta Especial: ")));
                   
                    Cliente clienteEspecial = new Cliente(JOptionPane.showInputDialog("CPF: "),
                                              JOptionPane.showInputDialog("Nome: "), 
                                              JOptionPane.showInputDialog("Endereço: "), 
                                              JOptionPane.showInputDialog("Telefone: "));
                    
                    //associacao
                    contaEspecial.setCliente(clienteEspecial);
                   
                    GerenciaContas.adicionarConta(contaEspecial);
                    
                    //boolean para tornar a verificacao de existencia de conta durante deposito mais natural
                    existeConta = true;
                    
                    JOptionPane.showMessageDialog(null, "Conta Especial cadastrada com sucesso!");
                    
                    break;
                
                //opcao 3 - relatorios    
                case 3:
                    //subinterface para desvio de opcao
                    opcaoRelatorio = Integer.parseInt(JOptionPane.showInputDialog("========MENU DE RELATÓRIOS========\n\n" +
                                                                                  "1. Listar Todas Contas Cadastradas\n" +
                                                                                  "2. Buscar Contas Pelo Número\n\n"));
                    
                    //desvio condicional da opcao escolhida
                    switch(opcaoRelatorio){
                        //opcao 1 - listagem geral
                        case 1:
                            JOptionPane.showMessageDialog(null, GerenciaContas.listarContas());        
                            break;
                        
                        //opcao 2 - busca por conta    
                        case 2:   
                          if(existeConta){
                            Conta objeto = GerenciaContas.buscarConta(Integer.parseInt(JOptionPane.showInputDialog("Conta: ")));
                            
                            //condicional de exito na busca
                            if(objeto != null) {
                                JOptionPane.showMessageDialog(null, objeto);
                            } else {
                                JOptionPane.showMessageDialog(null, "Conta não localizada!");
                            }
                          } else {
                                JOptionPane.showMessageDialog(null, "Não há contas cadastradas!");
                            }
                            break;
                            
                        default:
                            JOptionPane.showMessageDialog(null, "Opção inválida!");
                   }
                   break;
                
                //opcao 4 - movimentacoes
                case 4:
                    //subinterface para desvio de opcao
                    opcaoMovimentacao = Integer.parseInt(JOptionPane.showInputDialog("========MENU DE MOVIMENTAÇÕES========\n\n" +
                                                                                     "1. Efetuar Depósito\n" +
                                                                                     "2. Efetuar Saque\n\n"));
                    
                    //desvio condicional da opcao escolhida
                    switch(opcaoMovimentacao) {
                        //opcao 1 - efetuar deposito
                        case 1:
                            if(existeConta) {
                                try {
                                    GerenciaContas.buscarConta(Integer.parseInt(
                                        JOptionPane.showInputDialog("Conta: ")))
                                        .depositar(Double.parseDouble(JOptionPane.showInputDialog("Valor do Depósito: "))); 

                                    JOptionPane.showMessageDialog(null, "Depósito efetuado com sucesso!");
   
                                } catch(Exception e) {
                                    JOptionPane.showMessageDialog(null, "Número de conta inválido!");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Não há contas cadastradas!");
                            }
                            break;
                        
                        //opcao 2 - efetuar saque    
                        case 2:
                         if(existeConta) {
                           try {
                                boolean saqueOk = GerenciaContas.buscarConta(Integer.parseInt(
                                    JOptionPane.showInputDialog("Conta: ")))
                                    .sacar(Double.parseDouble(JOptionPane.showInputDialog("Valor do Saque: ")));
                                
                                //desvio de verificacao de condicoes do saque
                                if(saqueOk) {
                                    JOptionPane.showMessageDialog(null, "Saque efetuado com sucesso!");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Saldo insuficiente!");
                                }
                            } catch(Exception e) {
                               JOptionPane.showMessageDialog(null, "Número de conta inválido!");
                            }
                         } else {
                             JOptionPane.showMessageDialog(null, "Não há contas cadastradas!");
                         }
                            break;
                        default:
                           JOptionPane.showMessageDialog(null, "Opção inválida!!!");
                   }
                   break;
                   
                //opcao 5 - sair do  programa
                case 5:
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
            
        //condicao de loop do aplicativo (5 == sair)
        } while (opcaoMenu != 5);
    }  
}
