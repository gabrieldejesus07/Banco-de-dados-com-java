import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();
		
		PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
		stm.setInt(1, 2);
		stm.execute();
		
		 // retorna quantas linhas foram afetadas após execução do statement.
		Integer linhasModificadas = stm.getUpdateCount(); 
		
		System.out.println("Foram modificadas " + linhasModificadas + " linhas");
	}
}
