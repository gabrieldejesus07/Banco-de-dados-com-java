import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.com.gabriel.jdbc.ConnectionFactory;
import br.com.gabriel.jdbc.DAO.ProdutoDAO;
import br.com.gabriel.jdbc.modelo.Produto;

public class TestaInsercaoComProduto {

	public static void main(String[] args) throws SQLException {
		
		Produto comoda = new Produto("Comoda", "comoda vertical");
		
		try(Connection connection = new ConnectionFactory().recuperarConexao()){
			ProdutoDAO produtoDao = new ProdutoDAO(connection);
			produtoDao.salvar(comoda);
			List<Produto> listaDeProdutos = produtoDao.listar();
			listaDeProdutos.stream().forEach(lp -> System.out.println(lp));
		}
	}
}
