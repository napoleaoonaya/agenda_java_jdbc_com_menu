package br.com.agenda.teste;

import java.util.List;
import java.util.Scanner;

import br.com.agenda.dao.TelefoneDAO;
import br.com.agenda.dao.UsuarioDAO;
import br.com.agenda.model.Telefone;
import br.com.agenda.model.Usuario;

public class Menu {

	private static Scanner teclado;

	private static boolean retorno;

	public static boolean isRetorno() {
		return retorno;
	}

	public static void setRetorno(boolean retorno) {
		Menu.retorno = retorno;
	}

	public static void main(String[] args) {

		menu();

	}

	public static void menu() {

		teclado = new Scanner(System.in);

		System.out.println("===============================================");
		System.out.println("Selecione uma opção para o usuário: ");
		System.out.println("1-Inserir um usuário");
		System.out.println("2-Remover um usuário");
		System.out.println("3-Atualizar um usuário");
		System.out.println("4-Listar todos os usuarios");
		System.out.println("0-Sair");
		System.out.println("===============================================");
		System.out.println("Selecione uma opção para o telefone: ");
		System.out.println("5-Inserir um telefone");
		System.out.println("6-Remover um telefone");
		System.out.println("7-Atualizar um telefone");
		System.out.println("8-Listar todos os telefones");
		System.out.println("0-Sair");
		System.out.println("===============================================");
		System.out.println("Digite sua opção:");
		int escolha = teclado.nextInt();

		teclado.nextLine();

		switch (escolha) {

		case 1:
			inserirUsuario();
			retornaMenu();
			break;

		case 2:
			excluirUsuario();
			retornaMenu();
			break;

		case 3:
			atualizarUsuario();
			retornaMenu();
			break;

		case 4:
			selecionaUsuarios();
			retornaMenu();
			break;

		case 5:
			insereTelefone();
			retornaMenu();
			break;

		case 6:
			excluiTelefone();
			retornaMenu();
			break;

		case 7:
			atualizaTelefone();
			retornaMenu();
			break;

		case 8:
			selecionaTelefones();
			retornaMenu();
			break;

		default:
			System.out.println("Até mais!");
			break;
		}

	}

	public static void retornaMenu() {

		System.out.println("Deseja retornar ao menu responda [true] para sim e [false] para não!");
		boolean resposta = teclado.nextBoolean();

		retorno = resposta;

		if (retorno == true) {

			for (int i = 0; i <= 10; i++) {

				System.out.println();

			}

			menu();

		} else {
			System.out.println("Até mais!");
		}

	}

	public static void inserirUsuario() {

		System.out.println("Inserido um contato:");

		Usuario usuario = new Usuario();

		teclado = new Scanner(System.in);

		System.out.println("Informe o nome do usuário: ");
		usuario.setNome(teclado.nextLine());

		System.out.println("Informe o email do usuário: ");
		usuario.setEmail(teclado.nextLine());

		UsuarioDAO usuarioDAO = new UsuarioDAO();

		usuarioDAO.inserir(usuario);
	}

	public static void excluirUsuario() {

		System.out.println("Removendo um contato!");

		Usuario usuario = new Usuario();

		teclado = new Scanner(System.in);

		System.out.println("Informe o id do usuário: ");
		usuario.setIdUsuario(teclado.nextLong());

		UsuarioDAO usuarioDAO = new UsuarioDAO();

		usuarioDAO.deletar(usuario);
	}

	public static void atualizarUsuario() {

		System.out.println("Atualizando um contato!");

		Usuario usuario = new Usuario();

		teclado = new Scanner(System.in);

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

	public static void selecionaUsuarios() {

		System.out.println("Agenda de usuários.");

		UsuarioDAO usuarioDAO = new UsuarioDAO();

		List<Usuario> usuarios = usuarioDAO.getUsuarios();

		for (Usuario usuario : usuarios) {
			System.out.println(usuario.toString());
		}

	}

	public static void insereTelefone() {

		System.out.println("Inserindo celular");

		teclado = new Scanner(System.in);

		Telefone telefone = new Telefone();

		System.out.println("Insira o número de telefone: ");
		telefone.setNumero(teclado.nextLine());

		System.out.println("Insira o texto do telefone: ");
		telefone.setTexto(teclado.nextLine());

		System.out.println("Insira o usuario telefone id: ");
		telefone.setUsuario_telefone_id(teclado.nextLong());

		TelefoneDAO telefoneDAO = new TelefoneDAO();

		telefoneDAO.inserirTelefone(telefone);

	}

	public static void excluiTelefone() {

		System.out.println("Removendo celular");

		teclado = new Scanner(System.in);

		Telefone telefone = new Telefone();

		System.out.println("Insira o usuario telefone id: ");
		telefone.setUsuario_telefone_id(teclado.nextLong());

		TelefoneDAO telefoneDAO = new TelefoneDAO();

		telefoneDAO.removerTelefone(telefone);

	}

	public static void atualizaTelefone() {

		System.out.println("Atualizando celular");

		teclado = new Scanner(System.in);

		Telefone telefone = new Telefone();

		System.out.println("Insira o usuario telefone id: ");
		telefone.setUsuario_telefone_id(teclado.nextLong());

		teclado.nextLine();

		System.out.println("Insira o número de telefone: ");
		telefone.setNumero(teclado.nextLine());

		System.out.println("Insira o texto do telefone: ");
		telefone.setTexto(teclado.nextLine());

		TelefoneDAO telefoneDAO = new TelefoneDAO();

		telefoneDAO.atualizarTelefone(telefone);
	}

	public static void selecionaTelefones() {

		System.out.println("Agenda de telefones");

		TelefoneDAO telefoneDAO = new TelefoneDAO();

		List<Telefone> telefones = telefoneDAO.getTelefones();

		for (Telefone telefone : telefones) {
			System.out.println(telefone.toString());
		}

	}

}
