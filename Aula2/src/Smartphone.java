/**
 * Classe para implementar os metodos da interface PC e Celular
 * @author Lucas Gonçalves
 * @since Classe criada em 31 de mai. de 2025
 */
public class Smartphone implements PC, Celular {

    @Override
    public void verificaEmail() {
        System.out.println("Email verificado");
    }

    @Override
    public void realizarChamada() {
        System.out.println("Ligação efetuada!");
    }
    
    

}//fim da classe
