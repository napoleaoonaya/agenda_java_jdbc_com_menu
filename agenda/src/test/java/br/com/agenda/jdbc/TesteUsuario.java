package br.com.agenda.jdbc;

import java.util.List;
import java.util.Scanner;

import br.com.agenda.dao.UsuarioDAO;
import br.com.agenda.model.Usuario;
import junit.framework.TestCase;

public class TesteUsuario extends TestCase {

	public void testInserir() {

		System.out.println("Inserido um contato:");

		Usuario usuario = new Usuario();

		Scanner teclado = new Scanner(System.in);

		System.out.println("Informe o nome do usuário: ");
		usuario.setNome(teclado.nextLine());

		System.out.println("Informe o email do usuário: ");
		usuario.setEmail(teclado.nextLine());

		UsuarioDAO usuarioDAO = new UsuarioDAO();

		usuarioDAO.inserir(usuario);
	}

	public void testExcluir() {

		System.out.println("Removendo um contato!");

		Usuario usuario = new Usuario();

		Scanner teclado = new Scanner(System.in);

		System.out.println("Informe o id do usuário: ");
		usuario.setIdUsuario(teclado.nextLong());

		UsuarioDAO usuarioDAO = new UsuarioDAO();

		usuarioDAO.deletar(usuario);
	}

	public void testAtualizar() {

		System.out.println("Atualizando um contato!");

		Usuario usuario = new Usuario();

		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Informe o id do usuário a ser alterado: ");
		usuario.setIdUsuario(teclado.nextLong());
		
		teclado.nextLine();
		
		System.out.println("Informe o nome do usuário: ");
		usuario.setNome(teclado.nextLine());

		System.out.println("Informe o email do usuário: ");
		usuario.setEmail(teclado.nextLine());

		UsuarioDAO usuarioDAO = new UsuarioDAO();

		usuarioDAO.atualizar(usuario);
	}
	
	public void testSelecionaUsuarios() {
		
		System.out.println("Agenda de usuários.");
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		List<Usuario> usuarios = usuarioDAO.getUsuarios();
		
		for (Usuario usuario : usuarios) {
			System.out.println(usuario.toString());
		}
		
	}
}
