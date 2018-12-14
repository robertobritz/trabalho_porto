package Classe;

public class Navio {
	
	private String codigoNavio;
	private Capitao capitao;
	public Navio(String codigoNavio, Capitao capitao) {
		super();
		this.codigoNavio = codigoNavio;
		this.capitao = capitao;
	}
	public String getCodigoNavio() {
		return codigoNavio;
	}
	public void setCodigoNavio(String codigoNavio) {
		this.codigoNavio = codigoNavio;
	}
	public Capitao getCapitao() {
		return capitao;
	}
	public void setCapitao(Capitao capitao) {
		this.capitao = capitao;
	}

	
	
}
