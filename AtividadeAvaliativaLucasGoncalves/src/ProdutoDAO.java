/**
 * Classe para efetuar o CRUD de um produto no banco de dados
 * @author Lucas Gonçalves
 * @since Classe criada em 16 de jun. de 2025
 */

//sessão de importação

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProdutoDAO {

    private Conexao conexao;
    private Connection conn;
    
    public ProdutoDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public void inserir (Produto produto){
        String sql = "INSERT INTO produto (nome, preco, id_categoria, cod_barras) VALUES (?,?,?,?);";
        
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getCategoria());
            stmt.setInt(4, produto.getCod_barras());
            
            stmt.execute(); //executar as ações no banco
        }catch(SQLException ex){
            System.out.println("Erro ao inserir produto: " + ex.getMessage());
        }
    }//Fim do inserir pessoa
    
    // Consultar produto
    public Produto getProduto(int id_produto){
    String sql = "SELECT * FROM produto WHERE id_produto = ?";
    try{
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id_produto);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) { // ✅ Verifica se existe resultado
            Produto p = new Produto();
            p.setId_produto(rs.getInt("id_produto")); // importante preencher o ID também!
            p.setNome(rs.getString("nome"));
            p.setPreco(rs.getDouble("preco"));
            p.setCategoria(rs.getInt("id_categoria")); // certifique-se que nome da coluna é esse
            p.setCod_barras(rs.getInt("cod_barras"));
            return p;
        } else {
            return null; // produto não encontrado
        }
    } catch(SQLException ex){
        System.out.println("Consulta falhou: " + ex.getMessage());
        return null;
    }
}//fim do get pessoa
    
    public void editarProduto(Produto produto) {
    String sql = "UPDATE produto SET nome = ?, preco = ?, id_categoria = ?, cod_barras = ? WHERE id_produto = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getCategoria());
            stmt.setInt(4, produto.getCod_barras());
            stmt.setInt(5, produto.getId_produto());

            stmt.executeUpdate();
            System.out.println("Produto atualizado com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar produto: " + ex.getMessage());
        }
    }//Fim do editar pessoa
    
    //Deletar pessoa
    public void excluirProduto(int id_produto) {
        String sql = "DELETE FROM produto WHERE id_produto = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_produto);

            stmt.executeUpdate();
            System.out.println("Produto excluído com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir produto: " + ex.getMessage());
        }
    }//Fim do metodo excluir pessoa
    
    
    public List<Produto> getProdutos(int codBarras){
          String sql = "SELECT * FROM produto where prod_cod = ? ";
        
        try 
        {
            PreparedStatement stmt = conn.prepareStatement(
                sql,
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE
            );
            
            stmt.setInt(1, codBarras);
            ResultSet rs = stmt.executeQuery();
            java.util.List<Produto> listaProdutos = new ArrayList<>();
            
        while(rs.next()){
            Produto p = new Produto();
            p.setId_produto(rs.getInt("id_produto"));
            p.setNome(rs.getString("nome"));
            p.setPreco(rs.getDouble("preco"));
            p.setCod_barras(rs.getInt("cod_barras"));
            listaProdutos.add(p);
            
        }
        return listaProdutos;
    }catch(SQLException ex){
            System.out.println("Erro ao consultar Produtos: "+ ex.getMessage());
            return null;
    }
    }
    
}
