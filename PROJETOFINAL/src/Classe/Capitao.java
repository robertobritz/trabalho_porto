package Classe;

public class Capitao {
	private String nome;
	private String empresa;
	private String numeroRegistro;
	public Capitao(String nome, String empresa, String numeroRegistro) {
		super();
		this.nome = nome;
		this.empresa = empresa;
		this.numeroRegistro = numeroRegistro;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getNumeroRegistro() {
		return numeroRegistro;
	}
	public void setNumeroRegistro(String numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}
	

}
