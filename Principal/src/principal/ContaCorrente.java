package principal;

/**
 * Classe para 
 * @author Lucas Gonçalves
 * @since Classe criada em 26 de mai. de 2025
 */
public class ContaCorrente {
    float saldo = 0;
    boolean saqueOk = false;
    boolean deposito = false;
    
    //metodos da classe
    public void saldoAtual(){
        System.out.println("Saldo atual da conta: R$" + saldo);
    }
    public void DefinirSaldo(float incluirSaldo){
        saldo += incluirSaldo;
    }
    
    public boolean depositar(float adcSaldo){
        if(adcSaldo > 0){
            saldo += adcSaldo;
            return deposito = true;
        }
        else{
            return deposito = false;
        }
    }
    
    public boolean sacar(float saque){
        boolean saqueOk = false;
        
        if(saque > saldo){
            saqueOk = false;
        }
        else{
            saldo = saldo - saque;
            saqueOk = true;
        }
        return saqueOk;
    }
}//fim da classe
