package Classe;

public class Caminhao {
	private String codigoCaminhao;
	private Motorista motorista;
	public Caminhao(String codigoCaminhao, Motorista motorista) {
		super();
		this.codigoCaminhao = codigoCaminhao;
		this.motorista = motorista;
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
	
	
	
	
}