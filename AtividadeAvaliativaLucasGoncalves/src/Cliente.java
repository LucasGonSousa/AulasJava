/**
 * Classe para 
 * @author Lucas Gonçalves
 * @since Classe criada em 16 de jun. de 2025
 */
public class Cliente {

    private int id;
    private String nome;
    private String email;
    private String cpf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
    
    
}//fim da classe
