package Classe;

import java.util.ArrayList;
import java.util.LinkedList;

public class Cadastro {
	
	public static void cadastrarCaminhao(String codigoCaminhao, Motorista motorista,LinkedList frota){
		 Caminhao c = new Caminhao(codigoCaminhao, motorista);
		 frota.add(c); 
	}
	
	public static void cadastrarNavio(String codigoNavio, Capitao capitao,LinkedList esquadra){
		 Navio n = new Navio(codigoNavio, capitao );	
		 esquadra.add(n);
		 
	}
	public static void cadastrarContainer(String codigoContainer, String origem, String destino, String mercadoria, String transportadora, ArrayList patio){
		 Containers c = new Containers(codigoContainer, origem, destino, mercadoria,transportadora );
		
		 patio.add(c);
		 
	}
	
	public static void logCadastrarCaminhao(String codigoCaminhao, Motorista motorista, String logMotorista, String logRegCaminhao, LinkedList frotaRegistro){
		 CaminhaoLog camlog = new CaminhaoLog(codigoCaminhao, motorista, logMotorista,logRegCaminhao);
		 frotaRegistro.add(camlog); 
		 
	}
	
	public static void logCadastrarNavio(String codigoNavio, Capitao capitao, String logNavio, String logRegNavio, LinkedList esquadraRegistro){
		 NavioLog navlog = new NavioLog(codigoNavio, capitao, logNavio,logRegNavio );	
		 esquadraRegistro.add(navlog);
		 
	}
	
	
	public static void logCadastrarContainer(String codigoContainer, String origem, String destino, String mercadoria, 
			String transportadora, String logContainers, String logRegContainrs,String navioOuCaminhao,String placaTranposte,  ArrayList patioRegistro){
		
		 ContainersLog contlog = new ContainersLog(codigoContainer, origem, destino, mercadoria,transportadora,logContainers,logRegContainrs,navioOuCaminhao,placaTranposte );
		
		 patioRegistro.add(contlog);
		 
	}
	

}
