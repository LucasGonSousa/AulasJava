package principal;

/**
 *
 * @author Lucas
 */

//importação

import java.util.Scanner;

public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        /*Pessoa p1 = new Pessoa();
        Pessoa p2 = new Pessoa();
        Pessoa p3 = new Pessoa();
        
        System.out.println("Digite o nome da pessoa: ");
        p1.nome = sc.next();
        System.out.println("Digite a idade da pessoa: ");
        p1.idade = sc.nextInt();
        
        System.out.println("Digite o nome da pessoa: ");
        p2.nome = sc.next();
        System.out.println("Digite a idade da pessoa: ");
        p2.idade = sc.nextInt();
        
        System.out.println("Digite o nome da pessoa: ");        
        p3.nome = sc.next();
        System.out.println("Digite a idade da pessoa: ");
        p3.idade = sc.nextInt();
        
        
        System.out.println("Os nomes e idades digitados foram: " +
                 "\nNome: " + p1.nome +  " - idade: " + p1.idade +
                 "\nNome: " + p2.nome +  " - idade: " + p2.idade +
                 "\nNome: " + p3.nome +  " - idade: " + p3.idade);
*/
        ContaCorrente novaConta = new ContaCorrente();
        
        novaConta.DefinirSaldo(500f);
        
        novaConta.saldoAtual();
        
        //testa se deposito é valido
        if(novaConta.depositar(0)){
            System.out.println("Deposito efetuado com sucesso");
        }
            System.out.println("Deposito não efetuado, insira valor maior que R$ 0,00");
            
        novaConta.saldoAtual();
        
        //testa se saque é valido
        if (novaConta.sacar(500f)){
            System.out.println("Saque feito com sucesso");
        }
        else{
            System.out.println("Saldo insuficiente");
        }
        
        novaConta.saldoAtual();


    }
    
}
