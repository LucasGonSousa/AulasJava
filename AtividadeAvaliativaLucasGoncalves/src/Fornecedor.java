/**
 * Classe para 
 * @author Lucas Gonçalves
 * @since Classe criada em 16 de jun. de 2025
 */
public class Fornecedor {

    private int id;
    private String nome;
    private String nome_fantasia;
    private String cnpj;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome_fantasia() {
        return nome_fantasia;
    }

    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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
    
}
