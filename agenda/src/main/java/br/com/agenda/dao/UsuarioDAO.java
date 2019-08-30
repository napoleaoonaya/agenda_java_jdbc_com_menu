package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.agenda.model.Usuario;
import br.com.agenda.sigleconnection.SingleConnection;

public class UsuarioDAO {

	public static Connection connection;

	public UsuarioDAO() {
		connection = SingleConnection.getConnection();
	}

	public void inserir(Usuario usuario) {

		String sql = "insert into usuario (nome,email) values(?,?)";

		try {

			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, usuario.getNome());
			pstmt.setString(2, usuario.getEmail());
			pstmt.execute();
			connection.setAutoCommit(true);

			System.out.println("Dado inserido com sucesso!");

		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

	}

	public void deletar(Usuario usuario) {

		String sql = "delete from usuario where id=" + usuario.getIdUsuario();

		try {

			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, usuario.getIdUsuario());
			pstmt.execute();
			connection.setAutoCommit(true);

			System.out.println("Dado removido com sucesso!");

		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

	}

	public void atualizar(Usuario usuario) {

		String sql = "update usuario set nome=?, email=? where id=" + usuario.getIdUsuario();

		try {

			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, usuario.getNome());
			pstmt.setString(2, usuario.getEmail());
			pstmt.execute();
			connection.setAutoCommit(true);

			System.out.println("Dado atualizado com sucesso!");

		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

	}

	public List<Usuario> getUsuarios() {

		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		String sql = "select *from usuario";

		try {

			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rst = pstmt.executeQuery(sql);

			while (rst.next()) {

				Usuario usuario = new Usuario();

				usuario.setIdUsuario(rst.getLong("id"));
				usuario.setNome(rst.getString("nome"));
				usuario.setEmail(rst.getString("email"));
				usuarios.add(usuario);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return usuarios;
	}

}
