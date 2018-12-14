package Classe;

public class Containers {
	
	private String codigoContainer;
	private String origem;
	private String destino;
	private String mercadoria;
	private String transportadora;
	public Containers(String codigoContainer, String origem, String destino, String mercadoria, String transportadora) {
		super();
		this.codigoContainer = codigoContainer;
		this.origem = origem;
		this.destino = destino;
		this.mercadoria = mercadoria;
		this.transportadora = transportadora;
	}
	public String getCodigoContainer() {
		return codigoContainer;
	}
	public void setCodigoContainer(String codigoContainer) {
		this.codigoContainer = codigoContainer;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getMercadoria() {
		return mercadoria;
	}
	public void setMercadoria(String mercadoria) {
		this.mercadoria = mercadoria;
	}
	public String getTransportadora() {
		return transportadora;
	}
	public void setTransportadora(String transportadora) {
		this.transportadora = transportadora;
	}
	
	
	
	
	

	
}
