
import java.util.logging.Level;
import java.util.logging.Logger;

/***
 * Classe para gerar objetos do tipo Threads para simular linhas de execução dentro de um processo (Programa)
 * @author Lucas Gonçalves
 * @since Classe criada em 29 de mai. de 2025
 */
public class Threads extends Thread{
    
    int  sleepTime;
    
    public Threads(String nome){
        super(nome);
        sleepTime = (int)(Math.random() * 120000); //dormira por no maximo 5 seg
        System.out.println("A Thread " + nome + " vai dormir por " + sleepTime + " ms");
    }//Fim do construtor

    //metodo sobrescrito da superclasse Thread
    public void run(){
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException ex) {
            System.out.println("A thread foi interrompida!");
        }
        System.err.println("======> A Thread " + getName() + " acordou");
    }
    
}//fim da classe
