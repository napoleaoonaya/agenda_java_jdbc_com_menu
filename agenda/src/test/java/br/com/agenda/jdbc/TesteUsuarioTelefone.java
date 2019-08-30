package br.com.agenda.jdbc;

import java.util.List;
import java.util.Scanner;

import br.com.agenda.dao.UsuarioTelefoneDAO;
import br.com.agenda.model.Telefone;
import br.com.agenda.model.Usuario;
import br.com.agenda.model.UsuarioTelefone;
import junit.framework.TestCase;


public class TesteUsuarioTelefone extends TestCase{

	public void testSelecionarInnerJoin() {
		
		UsuarioTelefoneDAO usuarioTelefoneDAO = new UsuarioTelefoneDAO();
		
		List<UsuarioTelefone> usuarioTelefones = usuarioTelefoneDAO.getUsuarioTelefones();
		
		for (UsuarioTelefone usuarioTelefone : usuarioTelefones) {
			System.out.println("Usuário: "+usuarioTelefone.getNome()+"-"+
					"Telefone: "+usuarioTelefone.getNumero()+"-"+
					"Observação: "+usuarioTelefone.getTexto());
		}
	}
	
	public void testExcluirTelefoneUsuario(Telefone telefone, Usuario usuario) {
		
		UsuarioTelefoneDAO usuarioTelefoneDAO = new UsuarioTelefoneDAO();
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Insira o id do telefone: ");
		telefone.setIdTelefone(teclado.nextLong());
		
		teclado.nextLine();
		
		System.out.println("Insira o id do usuario: ");
		usuario.setIdUsuario(teclado.nextLong());
		
		usuarioTelefoneDAO.removerUsuarioTelefone(telefone, usuario);
		
		
	}
	
}

