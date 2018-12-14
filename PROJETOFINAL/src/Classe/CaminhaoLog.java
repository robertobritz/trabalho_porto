package Classe;

public class CaminhaoLog {
	private String codigoCaminhao;
	private Motorista motorista;
	private String logMotorista; //data
	private String logRegCaminhao;//entrada saída
	public CaminhaoLog(String codigoCaminhao, Motorista motorista, String logMotorista, String logRegCaminhao) {
		super();
		this.codigoCaminhao = codigoCaminhao;
		this.motorista = motorista;
		this.logMotorista = logMotorista;
		this.logRegCaminhao = logRegCaminhao;
	}
	public String getCodigoCaminhao() {
		return codigoCaminhao;
	}
	public void setCodigoCaminhao(String codigoCaminhao) {
		this.codigoCaminhao = codigoCaminhao;
	}
	public Motorista getMotorista() {
		return motorista;
	}
	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}
	public String getLogMotorista() {
		return logMotorista;
	}
	public void setLogMotorista(String logMotorista) {
		this.logMotorista = logMotorista;
	}
	public String getLogRegCaminhao() {
		return logRegCaminhao;
	}
	public void setLogRegCaminhao(String logRegCaminhao) {
		this.logRegCaminhao = logRegCaminhao;
	}
	
	
	
	
}