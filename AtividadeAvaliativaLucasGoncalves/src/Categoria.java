/**
 * Classe para definir o objeto do tipo categoria
 * @author Lucas Gonçalves
 * @since Classe criada em 16 de jun. de 2025
 */
public class Categoria {

    private int id;
    private String nome;
    private String descricao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String toString(){
    
        return this.id+" - " + this.nome;
    }
    
    
}//FIm da classe
