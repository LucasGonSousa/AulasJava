
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe para efetuar a conexão com o MYSQL
 * @author Lucas Gonçalves
 * @since Classe criada em 16 de jun. de 2025
 */
public class Conexao {

    public Connection getConexao(){
        try {
            Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/dbestoque?useTimezone=true&serverTimezone=UTC",
                    "root","root");
                System.out.println("Conexão realizada com sucesso");
                return conn;
        }catch(SQLException e){
                System.out.println("Erro ao conectar no BD"+e.getMessage());
                return null;
        }
    }
    
}//FIM da classe
