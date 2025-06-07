/**
 * Classe para instanciar as classes aprendidas na aula
 * @author Lucas Gonçalves
 * @since Classe criada em 31 de mai. de 2025
 */
public class Principal {

    public static void main(String[] args){
        IAnimal gato = new Gato();
        gato.emitirSom();
        
        Smartphone s23 = new Smartphone();
        s23.realizarChamada();
        s23.verificaEmail();
        
    }//fim do main
}//fim da classe Principal
