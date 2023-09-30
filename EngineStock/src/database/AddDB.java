package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddDB {

		
		DadosDB dadosDB = new DadosDB();
		Scanner sc = new Scanner(System.in);
		
			
		public void adicionarMotor(String modelo, String marca, String numeroMotor, int potencia){
			try {
				Connection conexao = DriverManager.getConnection(dadosDB.connectionString);
				
				
				String sql = "INSERT INTO motores(modelo, marca, numero_motor, potencia) VALUES (?, ?, ?, ?)";
		
				PreparedStatement preparedStatement = conexao.prepareStatement(sql);
				

	            preparedStatement.setString(1, modelo);
	            


	            preparedStatement.setString(2, marca);
	            


	            preparedStatement.setString(3, numeroMotor );
	            


	            preparedStatement.setInt(4, potencia);

				
	            preparedStatement.executeUpdate();
	            
	            preparedStatement.close();
	            conexao.close();
	            
	            System.out.println("Dados inseridos com sucesso na tabela motores.");
		}
			catch(SQLException e) {
				System.err.println("Erro oaconectar com data base");
				e.printStackTrace();
				
			}
		}
	}



