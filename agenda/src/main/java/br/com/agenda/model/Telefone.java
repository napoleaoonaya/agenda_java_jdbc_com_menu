package br.com.agenda.model;

public class Telefone {

	private Long idTelefone;
	private String numero;
	private String texto;
	private Long usuario_telefone_id;

	public Long getIdTelefone() {
		return idTelefone;
	}

	public void setIdTelefone(Long idTelefone) {
		this.idTelefone = idTelefone;
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

	@Override
	public String toString() {
		return "Telefone [idTelefone=" + idTelefone + ", numero=" + numero + ", texto=" + texto
				+ ", usuario_telefone_id=" + usuario_telefone_id + "]";
	}

}
