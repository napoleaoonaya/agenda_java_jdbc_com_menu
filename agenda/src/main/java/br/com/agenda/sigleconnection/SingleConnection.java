package br.com.agenda.sigleconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {

	public static Connection connection = null;

	public static String url = "jdbc:mysql://localhost:3306/agenda";
	public static String user = "root";
	public static String password = "162130";

	static {
		conectar();
	}

	public SingleConnection() {
		conectar();
	}

	public static void conectar() {

		try {

			if (connection == null) {

				System.out.println("Conexão efetuada com sucesso!");
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connection;
	}

}
