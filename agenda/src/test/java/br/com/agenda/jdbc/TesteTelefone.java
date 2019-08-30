package br.com.agenda.jdbc;

import java.util.List;

import junit.framework.TestCase;

import java.util.Scanner;

import br.com.agenda.dao.TelefoneDAO;
import br.com.agenda.model.Telefone;

public class TesteTelefone extends TestCase {

	public void testInsereTelefone() {

		System.out.println("Inserindo celular");

		Scanner teclado = new Scanner(System.in);

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

	public void testRemoverTelefone() {

		System.out.println("Removendo celular");

		Scanner teclado = new Scanner(System.in);

		Telefone telefone = new Telefone();

		System.out.println("Insira o usuario telefone id: ");
		telefone.setUsuario_telefone_id(teclado.nextLong());

		TelefoneDAO telefoneDAO = new TelefoneDAO();

		telefoneDAO.removerTelefone(telefone);

	}

	public void testAtualizaTelefone() {

		System.out.println("Atualizando celular");

		Scanner teclado = new Scanner(System.in);

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

	public void testSelecionaTelefone() {
		
		System.out.println("Agenda de telefones");

		TelefoneDAO telefoneDAO = new TelefoneDAO();

		List<Telefone> telefones = telefoneDAO.getTelefones();

		for (Telefone telefone : telefones) {
			System.out.println(telefone.toString());
		}

	}
}
