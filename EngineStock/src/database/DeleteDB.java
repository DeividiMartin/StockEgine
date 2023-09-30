package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteDB {
	DadosDB dadosDB = new DadosDB();
	
	Scanner sc = new Scanner(System.in);


	public boolean deleteDb(int idMotorExcluir) {
	    try {
	        Connection conexao = DriverManager.getConnection(dadosDB.connectionString);
	        String sql = "DELETE FROM motores WHERE id = ?";
	        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
	        preparedStatement.setInt(1, idMotorExcluir);
	        int linhasAfetadas = preparedStatement.executeUpdate();
	        preparedStatement.close();
	        conexao.close();
	        return linhasAfetadas > 0;
	    } catch (SQLException e) {
	        System.err.println("Erro ao excluir dados.");
	        e.printStackTrace();
	        return false;
	    }
	}
}



