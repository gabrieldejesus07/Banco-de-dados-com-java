import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.gabriel.jdbc.ConnectionFactory;
import br.com.gabriel.jdbc.DAO.CategoriaDAO;
import br.com.gabriel.jdbc.modelo.Categoria;

public class TestaListagemCategorias {

	public static void main(String[] args) throws SQLException {
		
		try(Connection connection = new ConnectionFactory().recuperarConexao()){
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			List<Categoria> listaDeCategoria = categoriaDAO.listar();
			listaDeCategoria.stream().forEach(ct -> System.out.println(ct.getNome()));
		}
		
	}

}
