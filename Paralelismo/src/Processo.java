/**
 * Classe para instanciar diversas threads para simulação do paralelismo
 * @author Lucas Gonçalves
 * @since Classe criada em 29 de mai. de 2025
 */
public class Processo {
    public static void main(String []args){
        while(true){
            Threads t1, t2, t3, t4;
            t1 = new Threads("Fatec santana de parnaiba");
            t2 = new Threads("Lucas");
            t3 = new Threads("Nao consegue, Moises 8==D ");
            t4 = new Threads("Paz para o nosso tempo");

            t1.start();
            t2.start();
            t3.start();
            t4.start();
        }
        
    }//fim do main

}//Fim da classe
