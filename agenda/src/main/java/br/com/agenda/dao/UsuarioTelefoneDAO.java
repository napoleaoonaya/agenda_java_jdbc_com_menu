package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.agenda.model.Telefone;
import br.com.agenda.model.Usuario;
import br.com.agenda.model.UsuarioTelefone;
import br.com.agenda.sigleconnection.SingleConnection;

public class UsuarioTelefoneDAO {
	
	public static Connection connection;
	
	public UsuarioTelefoneDAO() {
		connection = SingleConnection.getConnection();
	}
	
	public void removerUsuarioTelefone(Telefone telefone, Usuario usuario) {
		
		String sql1 = "delete from telefone where id="+telefone.getIdTelefone();
		String sql2 = "delete from usuario where id="+usuario.getIdUsuario();
		
		
		
		try {
			
			PreparedStatement pstmt1 = connection.prepareStatement(sql1);
			pstmt1.setLong(1,telefone.getIdTelefone());
			pstmt1.execute();
			connection.commit();
			
			pstmt1.close();
			
			PreparedStatement pstmt2 = connection.prepareStatement(sql2);
			pstmt2.setLong(1,usuario.getIdUsuario());
			pstmt2.execute();
			connection.commit();
			
			pstmt2.close();
			
			connection.close();
			
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	
	public List<UsuarioTelefone> getUsuarioTelefones() {
		
		Telefone telefone = new Telefone(); 
		Usuario usuario = new Usuario();
		
		ArrayList<UsuarioTelefone> usuarioTelefones = new ArrayList<UsuarioTelefone>();
		
		String sql ="select nome,numero,texto from usuario as u inner join telefone as t on "
				+usuario.getIdUsuario()+"="+telefone.getIdTelefone();
		
		try {
			
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rst = pstmt.executeQuery(sql);
			
			while(rst.next()) {
				
				UsuarioTelefone usuarioTelefone = new UsuarioTelefone();
				
				usuarioTelefone.setNome(rst.getString("nome"));
				usuarioTelefone.setNumero(rst.getString("numero"));
				usuarioTelefone.setTexto(rst.getString("texto"));
				
				usuarioTelefones.add(usuarioTelefone);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return usuarioTelefones;
	}

}
