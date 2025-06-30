
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe para efetuar o CRUD do onbjeto cliente
 * @author Lucas Gonçalves
 * @since Classe criada em 16 de jun. de 2025
 */
public class ClienteDAO {
    private Conexao conexao;
    private Connection conn;

    public ClienteDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public void inserir(Cliente cliente) {
        String sql = "INSERT INTO cliente (nome, email, cpf) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getCpf());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir cliente: " + ex.getMessage());
        }
    }

    public Cliente getCliente(int id) {
        String sql = "SELECT * FROM cliente WHERE id_cliente = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Cliente cli = new Cliente();
                cli.setId(id);  // Certifique-se que existe setId()
                cli.setNome(rs.getString("nome"));
                cli.setEmail(rs.getString("email"));
                cli.setCpf(rs.getString("cpf"));
                return cli;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar cliente: " + ex.getMessage());
            return null;
        }
}

    public void editar(Cliente cliente) {
        String sql = "UPDATE cliente SET nome = ?, email = ?, cpf = ? WHERE id_cliente = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getCpf());
            stmt.setInt(4, cliente.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar cliente: " + ex.getMessage());
        }
    }

    public void excluirPorID(int id) {
        String sql = "DELETE FROM cliente WHERE id_cliente = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir cliente: " + ex.getMessage());
        }
    }
    
    public List<Cliente> getCliente(){
          String sql = "SELECT * FROM cliente";
        
        try 
        {
            PreparedStatement stmt = conn.prepareStatement(
                sql,
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE
            );
            
            ResultSet rs = stmt.executeQuery();
            List<Cliente> listaCliente = new ArrayList<>();
            
        while(rs.next()){
            Cliente c = new Cliente();
            c.setId(rs.getInt("id_cliente"));
            c.setNome(rs.getString("nome"));
            listaCliente.add(c);
            
        }
        return listaCliente;
    }catch(SQLException ex){
            System.out.println("Erro ao consultar clientes: "+ ex.getMessage());
            return null;
    }
    }

}
