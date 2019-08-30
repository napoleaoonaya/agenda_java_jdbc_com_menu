package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.agenda.model.Telefone;
import br.com.agenda.sigleconnection.SingleConnection;

public class TelefoneDAO {

	public static Connection connection;

	public TelefoneDAO() {
		connection = SingleConnection.getConnection();
	}

	public void inserirTelefone(Telefone telefone) {
		
		String sql = "insert into telefone(numero,texto,usuario_telefone_id)"
				+ "values(?,?,?)";
		
		try {
			
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1,telefone.getNumero());
			pstmt.setString(2,telefone.getTexto());
			pstmt.setLong(3,telefone.getUsuario_telefone_id());
			pstmt.execute();
			connection.setAutoCommit(true);
			
			System.out.println("Telefone inserido com sucesso!");

		} catch (Exception e) {
			
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void removerTelefone(Telefone telefone) {
		
		String sql = "delete from telefone where id="+telefone.getIdTelefone();
		
		try {
			
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1,telefone.getIdTelefone());
			pstmt.execute();
			connection.setAutoCommit(true);
			
			System.out.println("Telefone removido com sucesso!");

		} catch (Exception e) {
			
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void atualizarTelefone(Telefone telefone) {
		
		String sql = "update telefone set numero=?,texto=?,usuario_telefone_id=?"
				+ "where id="+telefone.getIdTelefone();
		
		try {
			
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1,telefone.getNumero());
			pstmt.setString(2,telefone.getTexto());
			pstmt.setLong(3,telefone.getUsuario_telefone_id());
			pstmt.execute();
			connection.setAutoCommit(true);
			
			System.out.println("Telefone atualizado com sucesso!");

		} catch (Exception e) {
			
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public List<Telefone> getTelefones() {

		ArrayList<Telefone> telefones = new ArrayList<Telefone>();

		String sql = "select *from telefone";

		try {

			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rst = pstmt.executeQuery(sql);

			while (rst.next()) {

				Telefone telefone = new Telefone();

				telefone.setIdTelefone(rst.getLong("id"));
				telefone.setNumero(rst.getString("numero"));
				telefone.setTexto(rst.getString("texto"));
				telefone.setUsuario_telefone_id(rst.getLong("usuario_telefone_id"));

				telefones.add(telefone);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return telefones;
	}
}
