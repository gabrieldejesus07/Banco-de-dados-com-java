import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();
		
		Statement stm = connection.createStatement();
		stm.execute("DELETE FROM PRODUTO WHERE ID > 2");
		
		 // retorna quantas linhas foram afetadas após execução do statement.
		Integer linhasModificadas = stm.getUpdateCount(); 
		
		System.out.println("Foram modificadas " + linhasModificadas + " linhas");
	}
}
