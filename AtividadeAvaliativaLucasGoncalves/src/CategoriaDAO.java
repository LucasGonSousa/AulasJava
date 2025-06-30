/**
 * Classe para efetuar o CRUD de uma categoria no banco de dados
 * @author Lucas Gonçalves
 * @since Classe criada em 16 de jun. de 2025
 */

//sessão de importação

import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CategoriaDAO {

    private Conexao conexao;
    private Connection conn;
    
    public CategoriaDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserirCategoria (Categoria categoria){
        String sql = "INSERT INTO categoria (nome, descricao) VALUES (?,?);";
        
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, categoria.getNome());
            stmt.setString(2, categoria.getDescricao());
            
            stmt.execute(); //executar as ações no banco
        }catch(SQLException ex){
            System.out.println("Erro ao inserir categoria: " + ex.getMessage());
        }
    }//Fim do inserir pessoa
    
    public Categoria getCategoria(int id){
        String sql = "SELECT * FROM categoria WHERE id_categoria = ?";
        
        try{
            PreparedStatement stmt = conn.prepareStatement(
                sql,
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE
            );
            
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery(); // obtenho o retorno da consulta e armazeno no ResultSet
            
            Categoria c = new Categoria();
            rs.first();
            
            c.setId(id);
            c.setNome(rs.getString("nome"));
            c.setDescricao(rs.getString("descricao"));
           
            
            return c;
        }catch(SQLException ex){
            System.out.println("Erro ao consultar categoria: " + ex.getMessage());
            return null;
        }
    }
    
    // Consultar Categoria
    public List<Categoria> getCategoria(){

        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT * FROM categoria";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(); //executar a consulta no banco
            
            while(rs.next()){
                Categoria cat = new Categoria();
                cat.setId(rs.getInt("id_categoria"));
                cat.setNome(rs.getString("nome"));
                
                categorias.add(cat);
            }
            return categorias;
        }catch(SQLException ex){
            System.out.println("Consulta falhou " + ex.getMessage());
            return null;
        }
    }//fim do get pessoa
    
    public void editarCategoria(Categoria categoria){
        try{
            String sql = "UPDATE categoria SET nome=?, descricao=? WHERE id_categoria = ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, categoria.getNome());
            stmt.setString(2, categoria.getDescricao());
            stmt.setInt(3, categoria.getId());
            stmt.execute();
        }catch(SQLException ex){
            System.out.println("Erro ao atualizar Categoria: " + ex.getMessage());
        }
    }//Fim do editar Categoria
    
    //Deletar pessoa
    public void excluirCategoria(int id){
        try{
            String sql = "DELETE FROM categoria WHERE id_categoria = ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,id);
            stmt.execute();
        }catch(SQLException e){
            System.out.println("Erro ao excluir Categoria: " + e.getMessage());
        }
    }//Fim do metodo excluir Categoria
    
}//Fim da classe
