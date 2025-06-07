
/**
 * Classe para 
 * @author Lucas Gonçalves
 * @since Classe criada em 2 de jun. de 2025
 */
public class Pessoa {

    String nome;
    String sexo;
    String idioma;
    
    public Pessoa(String nome, String sexo, String idioma){
        this.nome = nome;
        this.sexo = sexo;
        this.idioma = idioma;
    }

    public Object[] obterDados()
    {
        return new Object[]{nome, sexo, idioma};
    }
}//Fim da classe

