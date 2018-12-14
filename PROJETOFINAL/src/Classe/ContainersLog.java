package Classe;

public class ContainersLog {
	
	private String codigoContainer;
	private String origem;
	private String destino;
	private String mercadoria;
	private String transportadora;
	private String logContainers; //data
	private String logRegContainrs; //entrada saida
	private String navioOuCaminhao; // caminhão ou Navio
	private String placaTranposte;
	public ContainersLog(String codigoContainer, String origem, String destino, String mercadoria,
			String transportadora, String logContainers, String logRegContainrs, String navioOuCaminhao,
			String placaTranposte) {
		super();
		this.codigoContainer = codigoContainer;
		this.origem = origem;
		this.destino = destino;
		this.mercadoria = mercadoria;
		this.transportadora = transportadora;
		this.logContainers = logContainers;
		this.logRegContainrs = logRegContainrs;
		this.navioOuCaminhao = navioOuCaminhao;
		this.placaTranposte = placaTranposte;
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
	public String getLogContainers() {
		return logContainers;
	}
	public void setLogContainers(String logContainers) {
		this.logContainers = logContainers;
	}
	public String getLogRegContainrs() {
		return logRegContainrs;
	}
	public void setLogRegContainrs(String logRegContainrs) {
		this.logRegContainrs = logRegContainrs;
	}
	public String getNavioOuCaminhao() {
		return navioOuCaminhao;
	}
	public void setNavioOuCaminhao(String navioOuCaminhao) {
		this.navioOuCaminhao = navioOuCaminhao;
	}
	public String getPlacaTranposte() {
		return placaTranposte;
	}
	public void setPlacaTranposte(String placaTranposte) {
		this.placaTranposte = placaTranposte;
	}
	
	

	
}
