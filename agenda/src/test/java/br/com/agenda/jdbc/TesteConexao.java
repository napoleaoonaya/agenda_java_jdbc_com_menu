package br.com.agenda.jdbc;

import java.sql.Connection;

import br.com.agenda.sigleconnection.SingleConnection;
import junit.framework.TestCase;

public class TesteConexao extends TestCase {

	public void testConectar() {
		
		Connection connection = null;
		
		SingleConnection singleConnection = new SingleConnection();
		
		connection = singleConnection.getConnection();
	}
}
