package Classe;

public class NavioLog {
	
	private String codigoNavio;
	private Capitao capitao;
	private String logNavio; // data
	private String logRegNavio; // entrada saida
	public NavioLog(String codigoNavio, Capitao capitao, String logNavio, String logRegNavio) {
		super();
		this.codigoNavio = codigoNavio;
		this.capitao = capitao;
		this.logNavio = logNavio;
		this.logRegNavio = logRegNavio;
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
	public String getLogNavio() {
		return logNavio;
	}
	public void setLogNavio(String logNavio) {
		this.logNavio = logNavio;
	}
	public String getLogRegNavio() {
		return logRegNavio;
	}
	public void setLogRegNavio(String logRegNavio) {
		this.logRegNavio = logRegNavio;
	}
	

	
	
	
}
