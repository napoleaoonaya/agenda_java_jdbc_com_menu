package br.com.agenda.model;

public class UsuarioTelefone {

	private String nome;
	private String numero;
	private String texto;
	private Long usuario_telefone_id;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Long getUsuario_telefone_id() {
		return usuario_telefone_id;
	}

	public void setUsuario_telefone_id(Long usuario_telefone_id) {
		this.usuario_telefone_id = usuario_telefone_id;
	}
}
