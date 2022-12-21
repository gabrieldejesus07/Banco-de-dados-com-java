package br.com.gabriel.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.gabriel.jdbc.factory.ConnectionFactory;

public class TestaInsercaoEListagemComParametro {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection connection = factory.recuperarConexao()){
		connection.setAutoCommit(false);
		
		try (PreparedStatement stm = 
					connection.prepareStatement("INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
			){
			adicionarVariavel("SmarTv", "45 polegadas", stm);
			adicionarVariavel("Radio", "Radio a bateria", stm);
			
			connection.commit();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("ROLLBACK EXECUTADO");
			connection.rollback();
		}
		}
		}
		
	
	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);
		
		if(nome.equals("Radio")) {
			throw new RuntimeException("Não foi possível adicionar o produto");
		}
		
		stm.execute();
		
		try (ResultSet rst = stm.getGeneratedKeys()){
		while(rst.next()) {
			Integer id = rst.getInt(1);
			
			System.out.println("O id criado foi: " + id);
		}
	  }
	} 
}
