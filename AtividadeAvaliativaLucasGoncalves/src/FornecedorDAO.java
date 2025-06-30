/**
 * Classe para efetuar o CRUD com o fornecedor
 * @author Lucas Gonçalves
 * @since Classe criada em 16 de jun. de 2025
 */

//Sessão de importação
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FornecedorDAO {

    private Conexao conexao;
    private Connection conn;
    
    public FornecedorDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserir (Fornecedor fornecedor){
        String sql = "INSERT INTO fornecedor (nome, nome_fantasia, cnpj) VALUES (?,?,?);";
        
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getNome_fantasia());
            stmt.setString(3, fornecedor.getCnpj());

            stmt.execute(); //executar as ações no banco
        }catch(SQLException ex){
            System.out.println("Erro ao inserir pessoa: " + ex.getMessage());
        }
    }//Fim do inserir pessoa
    
    // Consultar pessoa
    public Fornecedor getFornecedor(int id){
    String sql = "SELECT * FROM fornecedor WHERE id_fornecedor = ?";
    try{
        PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        
        if (rs.first()) {
            Fornecedor fornec = new Fornecedor();
            fornec.setId(rs.getInt("id_fornecedor"));
            fornec.setNome(rs.getString("nome"));
            fornec.setNome_fantasia(rs.getString("nome_fantasia"));
            fornec.setCnpj(rs.getString("cnpj"));
            return fornec;
        } else {
            return null;
        }
    } catch(SQLException ex){
        System.out.println("Consulta falhou: " + ex.getMessage());
        return null;
    }
}//fim do get fornecedor
    
    public void editarFornecedor(Fornecedor fornec){
        try{
            String sql = "UPDATE fornecedor SET nome=?, nome_fantasia=?, cnpj=? WHERE id_fornecedor=?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, fornec.getNome());
            stmt.setString(2, fornec.getNome_fantasia());
            stmt.setString(3, fornec.getCnpj());
            stmt.setInt(4, fornec.getId());

            stmt.execute();
        } catch(SQLException ex){
            System.out.println("Erro ao atualizar Fornecedor: " + ex.getMessage());
        }
    }//Fim do editar fornecedor
    
    //Deletar fornecedor
    public void excluirFornecedor(int id){
        try{
            String sql = "delete from fornecedor WHERE id_fornecedor=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,id);
            stmt.execute();
        }catch(SQLException e){
            System.out.println("Erro ao excluir fornecedor: " + e.getMessage());
        }
    }//Fim do metodo excluir fornecedor
    
    public List<Fornecedor> getFornecedor(){
          String sql = "SELECT * FROM fornecedor";
        
            try 
            {
                PreparedStatement stmt = conn.prepareStatement(
                    sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
                );

                ResultSet rs = stmt.executeQuery();
                List<Fornecedor> listaFornecedor = new ArrayList<>();

            while(rs.next()){
                Fornecedor f = new Fornecedor();
                f.setId(rs.getInt("id_fornecedor"));
                f.setNome(rs.getString("nome"));
                listaFornecedor.add(f);

            }
            return listaFornecedor;
        }catch(SQLException ex){
                System.out.println("Erro ao consultar fornecedores: "+ ex.getMessage());
                return null;
        }
    }
}
