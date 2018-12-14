package Tela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import Classe.Cadastro;
import Classe.Caminhao;
import Classe.CaminhaoLog;
import Classe.Capitao;
import Classe.Containers;
import Classe.ContainersLog;
import Classe.Motorista;
import Classe.Navio;
import Classe.NavioLog;

import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.Panel;
import javax.swing.JTable;

public class TelaPricipal {

	LinkedList<Caminhao> frota = new LinkedList<Caminhao>();
	LinkedList<Navio> esquadra = new LinkedList<Navio>();
	ArrayList<Containers> patio = new ArrayList<Containers>();
	
	ArrayList<ContainersLog> patioRegistro = new ArrayList<ContainersLog>();
	LinkedList<CaminhaoLog> frotaRegistro = new LinkedList<CaminhaoLog>();
	LinkedList<NavioLog>esquadraRegistro = new LinkedList<NavioLog>();

	Containers apagaContainer = new Containers(null,null,null,null,null);
	JButton btnProcurar = new JButton("Processar");
	int seletor = 0;
	private JFrame frame;
	private JTextField TFcodigoCaminhao;
	private JTextField TTnomeMotorista;
	private JTextField TTempresa;
	private JTextField TTnumeroRegistro;
	private JTable table;
	private JTextField TFCodigoNavio;
	private JTextField TFTransportadora;
	private JTextField TFnumeroRegistro;
	private JTextField TFNomeDoCapitao;
	private JTextField TFidContainer;
	private JTextField TForigemContainer;
	private JScrollPane scrollPane;
	private JTable table_1;
	private JTextField TFdestinoContainer;
	private JTextField TFmercadoria;
	private JTable table_2;
	private JTable table_3;
	private JTextField TFprocuraContainer;
	private JTable table_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPricipal window = new TelaPricipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPricipal() {
		
		// importar Container
		
		try {
			FileReader fr = new FileReader("ARQUIVO/Patio.txt");
			BufferedReader br = new BufferedReader(fr);
			
			String impCCodigo = null;
			String impCOrigem = null;
			String impCDestino = null;
			String impCMercadoria = null;
			String impTransportadora = null;

			while((impCCodigo = br.readLine()) != null) {
					impCOrigem = br.readLine();
					impCDestino = br.readLine();
					impCMercadoria = br.readLine();
					impTransportadora = br.readLine();
					Cadastro.cadastrarContainer(impCCodigo,impCOrigem,impCDestino,impCMercadoria,impTransportadora,patio);
	
			}

			br.close();
			fr.close();
		} catch (IOException e4) {
			// TODO Auto-generated catch block
			
			//e4.printStackTrace();
			}
		
		// importa Frota
		try {
			FileReader fr = new FileReader("ARQUIVO/Frota.txt");
			BufferedReader br = new BufferedReader(fr);
			
				
			
			
			String impCCodigoCam = null;
			String impCNomeMot = null;
			String impCEmpresaCam = null;
			String impCNumeroReg = null;
			
			while((impCCodigoCam = br.readLine()) != null) {
					impCNomeMot = br.readLine();
					impCEmpresaCam = br.readLine();
					impCNumeroReg = br.readLine();
					
					Motorista Mimporta = new Motorista(impCNomeMot,impCEmpresaCam,impCNumeroReg);
					Caminhao Cimporta = new Caminhao(impCCodigoCam,Mimporta);

					frota.add(Cimporta);
					
					
				
	
			}

			br.close();
			fr.close();
		} catch (IOException e5) {
			// TODO Auto-generated catch block
			
			//e4.printStackTrace();
			}
		
		// importa Esquadra
				try {
					FileReader fr = new FileReader("ARQUIVO/Esquadra.txt");
					BufferedReader br = new BufferedReader(fr);
					
									
					 
					String impNcod = null;
					String impNcap = null;
					String impNtransp = null;
					String impNregis = null;


					while((impNcod = br.readLine()) != null) {
							impNcap = br.readLine();
							impNtransp = br.readLine();
							impNregis = br.readLine();
													
							Capitao Capitaoimporta = new Capitao(impNcap,impNtransp,impNregis);
							Navio NavImporta = new Navio(impNcod,Capitaoimporta);
							
							esquadra.add(NavImporta);
							
			
					}

					br.close();
					fr.close();
				} catch (IOException e5) {
					// TODO Auto-generated catch block
					
					//e4.printStackTrace();
					}
		
				// importa LogCaminhão
							
				try {
					FileReader fr = new FileReader("ARQUIVO/LogFrota.txt");
					BufferedReader br = new BufferedReader(fr);
					
						
					
					
					String impLCCodigoCam = null;
					String impLCNomeMot = null;
					String impLCEmpresaCam = null;
					String impLCNumeroReg = null;
					String impLogMotorista = null;
					String impLogRegCaminhao = null;
					
					while((impLCCodigoCam = br.readLine()) != null) {
							impLCNomeMot = br.readLine();
							impLCEmpresaCam = br.readLine();
							impLCNumeroReg = br.readLine();
							impLogMotorista = br.readLine();
							impLogRegCaminhao = br.readLine();
							
							Motorista mLimporta = new Motorista(impLCNomeMot,impLCEmpresaCam,impLCNumeroReg);
							CaminhaoLog CLimporta = new CaminhaoLog(impLCCodigoCam,mLimporta,impLogMotorista,impLogRegCaminhao);

							frotaRegistro.add(CLimporta);
							
							
						
			
					}

					br.close();
					fr.close();
				} catch (IOException e5) {
					// TODO Auto-generated catch block
					
					//e5.printStackTrace();
					}
		
				try {
					FileReader fr = new FileReader("ARQUIVO/LogEsquadra.txt");
					BufferedReader br = new BufferedReader(fr);

					String impLCCodigoNavi = null;
					String impLCNomeCap = null;
					String impLCEmpresaNav = null;
					String impLCNumeroRegCap = null;
					String impLogNavio = null;
					String impLogRegNav = null;
					
					while((impLCCodigoNavi = br.readLine()) != null) {
							impLCNomeCap = br.readLine();
							impLCEmpresaNav = br.readLine();
							impLCNumeroRegCap = br.readLine();
							impLogNavio = br.readLine();
							impLogRegNav = br.readLine();
							
							Capitao cLimporta = new Capitao(impLCNomeCap,impLCEmpresaNav,impLCNumeroRegCap);
							NavioLog nLimporta = new NavioLog(impLCCodigoNavi,cLimporta,impLogNavio,impLogRegNav);

							esquadraRegistro.add(nLimporta);

					}

					br.close();
					fr.close();
				} catch (IOException e5) {
					// TODO Auto-generated catch block
					
					//e5.printStackTrace();
					}
				
				
				// importa log Patio
				try {
					FileReader fr = new FileReader("ARQUIVO/LogPatio.txt");
					BufferedReader br = new BufferedReader(fr);

					String impLCodigoC = null;
					String impLOrigem = null;
					String impLDestino = null;
					String impLMercadoria = null;
					String impLTranspor = null;
					String impLData = null;
					String impLMovime = null;
					String impLMeio = null;
					String impLPlacaMeio = null;
			
					while((impLCodigoC = br.readLine()) != null) {
						impLOrigem = br.readLine();
						impLDestino = br.readLine();
						impLMercadoria = br.readLine();
						impLTranspor = br.readLine();
						impLData = br.readLine();
						impLMovime = br.readLine();
						impLMeio = br.readLine();
						impLPlacaMeio = br.readLine();
							
						ContainersLog Patioimporta = new ContainersLog(impLCodigoC,impLOrigem,impLDestino,impLMercadoria,impLTranspor,impLData,impLMovime,impLMeio,impLPlacaMeio);

							patioRegistro.add(Patioimporta);

					}

					br.close();
					fr.close();
				} catch (IOException e5) {
					// TODO Auto-generated catch block
					
					//e5.printStackTrace();
					}
		
		
		initialize();
	
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 518, 307);
		frame.setDefaultCloseOperation(0);
		
		JPanel Principal = new JPanel();
		frame.getContentPane().add(Principal, BorderLayout.CENTER);
		Principal.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		Principal.add(panel, "name_519643691024578");
		panel.setLayout(null);
		
		JTextPane txtpnMenuCaminho = new JTextPane();
		txtpnMenuCaminho.setEditable(false);
		txtpnMenuCaminho.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnMenuCaminho.setText("Menu Caminh\u00E3o");
		txtpnMenuCaminho.setBounds(70, 39, 112, 25);
		panel.add(txtpnMenuCaminho);
		
		
		
		JTextPane txtpnMenuNavio = new JTextPane();
		txtpnMenuNavio.setEditable(false);
		txtpnMenuNavio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnMenuNavio.setText("Menu Navio");
		txtpnMenuNavio.setBounds(314, 31, 94, 33);
		panel.add(txtpnMenuNavio);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		Principal.add(panel_1, "name_523769321044889");
		panel_1.setLayout(null);
		
		JTextPane txtpnMenuDeCadastro = new JTextPane();
		txtpnMenuDeCadastro.setEditable(false);
		txtpnMenuDeCadastro.setBackground(Color.WHITE);
		txtpnMenuDeCadastro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnMenuDeCadastro.setText("Menu de Cadastro de Caminh\u00E3o");
		txtpnMenuDeCadastro.setBounds(111, 11, 267, 28);
		panel_1.add(txtpnMenuDeCadastro);
		
		TFcodigoCaminhao = new JTextField();
		TFcodigoCaminhao.setBounds(13, 88, 133, 20);
		panel_1.add(TFcodigoCaminhao);
		TFcodigoCaminhao.setColumns(10);
		
		
		JTextPane txtpnPlacaDoCaminho = new JTextPane();
		txtpnPlacaDoCaminho.setEditable(false);
		txtpnPlacaDoCaminho.setText("Placa do caminh\u00E3o");
		txtpnPlacaDoCaminho.setBounds(13, 67, 120, 20);
		panel_1.add(txtpnPlacaDoCaminho);
		
		JTextPane txtpnNomeDoMotorista = new JTextPane();
		txtpnNomeDoMotorista.setEditable(false);
		txtpnNomeDoMotorista.setText("Nome do motorista");
		txtpnNomeDoMotorista.setBounds(179, 67, 154, 20);
		panel_1.add(txtpnNomeDoMotorista);
		
		TTnomeMotorista = new JTextField();
		TTnomeMotorista.setBounds(179, 88, 282, 20);
		panel_1.add(TTnomeMotorista);
		TTnomeMotorista.setColumns(10);
		
		JTextPane txtpnTransportadora = new JTextPane();
		txtpnTransportadora.setEditable(false);
		txtpnTransportadora.setText("Transportadora");
		txtpnTransportadora.setBounds(178, 130, 270, 20);
		panel_1.add(txtpnTransportadora);
		
		TTempresa = new JTextField();
		TTempresa.setBounds(179, 150, 282, 20);
		panel_1.add(TTempresa);
		TTempresa.setColumns(10);
		
		TTnumeroRegistro = new JTextField();
		TTnumeroRegistro.setBounds(13, 150, 133, 20);
		panel_1.add(TTnumeroRegistro);
		TTnumeroRegistro.setColumns(10);
		
		JTextPane txtpnNmeroDeRegistro = new JTextPane();
		txtpnNmeroDeRegistro.setEditable(false);
		txtpnNmeroDeRegistro.setText("N\u00FAmero de registro");
		txtpnNmeroDeRegistro.setBounds(13, 130, 146, 20);
		panel_1.add(txtpnNmeroDeRegistro);
		
		
		JTextPane txtpnFilaDeCaminhes = new JTextPane();
		txtpnFilaDeCaminhes.setEditable(false);
		txtpnFilaDeCaminhes.setText("Fila de Caminh\u00F5es");
		txtpnFilaDeCaminhes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnFilaDeCaminhes.setBackground(Color.WHITE);
		txtpnFilaDeCaminhes.setBounds(173, 11, 150, 28);
		Panel panel_2 = new Panel();
		panel_2.setBackground(Color.WHITE);
		Principal.add(panel_2, "name_75952846073353");
		panel_2.setLayout(null);
		
		scrollPane = new JScrollPane();
		panel_2.add(scrollPane);
		scrollPane.setBounds(0, 70, 502, 198);
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Placa do Caminhão", "Motorista", "Transportadora", "Registro"
			}
		));
		scrollPane.setViewportView(table);
		panel_2.add(txtpnFilaDeCaminhes);
		
		
		
		
			
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
					btnCadastrar.setEnabled(false);
				
					String ccodigoCaminhao = TFcodigoCaminhao.getText();
					String cnomeMotorista = TTnomeMotorista.getText();
					String cempresa = TTempresa.getText();
					String cnumeroRegistro = TTnumeroRegistro.getText();
					Motorista cmotorista = new Motorista(cnomeMotorista,cempresa,cnumeroRegistro);
					
					Cadastro.cadastrarCaminhao(ccodigoCaminhao,cmotorista,frota);
				
					String dateLogCaminhao = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
					String entradalog = "Entrada";		
							
					Cadastro.logCadastrarCaminhao(ccodigoCaminhao,cmotorista,dateLogCaminhao,entradalog,frotaRegistro);
					
					
					
					TFcodigoCaminhao.setText("");
					TTnomeMotorista.setText("");
					TTempresa.setText("");
					TTnumeroRegistro.setText("");
				
				
				
				
				
			}
		});
		btnCadastrar.setBounds(243, 234, 110, 23);
		panel_1.add(btnCadastrar);
		
		JButton btnInicio = new JButton("INICIO");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				panel_1.setVisible(false);
				panel.setVisible(true);
				
				TFcodigoCaminhao.setText("");
				TTnomeMotorista.setText("");
				TTempresa.setText("");
				TTnumeroRegistro.setText("");
				
			}
		});
		btnInicio.setBounds(356, 234, 105, 23);
		panel_1.add(btnInicio);
		
		JButton btnNewButton_2 = new JButton("VALIDAR");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String vCodigoCaminhao = TFcodigoCaminhao.getText();
				String vNomeMortorista = TTnomeMotorista.getText();
				String vEmpresa = TTempresa.getText();
				String vNumeroRegistro = TTnumeroRegistro.getText();
				
				vCodigoCaminhao = vCodigoCaminhao.trim();
				vNomeMortorista = vNomeMortorista.trim();
				vEmpresa = vEmpresa.trim();
				vNumeroRegistro = vNumeroRegistro.trim();

				if (!vCodigoCaminhao.equals("") && !vNomeMortorista.equals("")  && !vEmpresa.equals("") && !vNumeroRegistro.equals(""))
				{
					btnCadastrar.setEnabled(true);
				}
			}
		});

		btnNewButton_2.setBounds(144, 234, 89, 23);
		panel_1.add(btnNewButton_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.WHITE);
		Principal.add(panel_3, "name_79298645260232");
		
		JTextPane txtpnMenuDeCadastro_1 = new JTextPane();
		txtpnMenuDeCadastro_1.setEditable(false);
		txtpnMenuDeCadastro_1.setText("Menu de Cadastro de Navio");
		txtpnMenuDeCadastro_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnMenuDeCadastro_1.setBackground(Color.WHITE);
		txtpnMenuDeCadastro_1.setBounds(111, 11, 267, 28);
		panel_3.add(txtpnMenuDeCadastro_1);
		
		TFCodigoNavio = new JTextField();
		TFCodigoNavio.setColumns(10);
		TFCodigoNavio.setBounds(53, 88, 146, 20);
		panel_3.add(TFCodigoNavio);
		JTextPane txtpnIdDoNavio = new JTextPane();
		txtpnIdDoNavio.setEditable(false);
		txtpnIdDoNavio.setText("ID do Navio");
		txtpnIdDoNavio.setBounds(53, 67, 120, 20);
		panel_3.add(txtpnIdDoNavio);
		
		JTextPane txtpnNomeDoCapitao = new JTextPane();
		txtpnNomeDoCapitao.setEditable(false);
		txtpnNomeDoCapitao.setText("Nome do capitao");
		txtpnNomeDoCapitao.setBounds(234, 67, 144, 20);
		panel_3.add(txtpnNomeDoCapitao);
		
		
		
		
		
	
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setEditable(false);
		textPane_3.setText("Transportadora");
		textPane_3.setBounds(244, 130, 146, 20);
		panel_3.add(textPane_3);
		
		JTextPane textPane_4 = new JTextPane();
		textPane_4.setEditable(false);
		textPane_4.setText("N\u00FAmero de registro");
		textPane_4.setBounds(53, 130, 181, 20);
		panel_3.add(textPane_4);
		
		
		
		JButton button_2 = new JButton("INICIO");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_3.setVisible(false);
				panel.setVisible(true);
				
				TFCodigoNavio.setText("");
				TFNomeDoCapitao.setText("");
				TFTransportadora.setText("");
				TFnumeroRegistro.setText("");
			}
		});
		button_2.setBounds(360, 234, 101, 23);
		panel_3.add(button_2);
		
		TFTransportadora = new JTextField();
		TFTransportadora.setBounds(53, 150, 146, 20);
		panel_3.add(TFTransportadora);
		TFTransportadora.setColumns(10);
		
		TFnumeroRegistro = new JTextField();
		TFnumeroRegistro.setBounds(234, 150, 212, 20);
		panel_3.add(TFnumeroRegistro);
		TFnumeroRegistro.setColumns(10);
		
		TFNomeDoCapitao = new JTextField();
		TFNomeDoCapitao.setBounds(234, 88, 212, 20);
		panel_3.add(TFNomeDoCapitao);
		TFNomeDoCapitao.setColumns(10);
		
		
		
		
		
		
		JButton BTCadastrarNavio = new JButton("CADASTRAR");
		BTCadastrarNavio.addActionListener(new ActionListener() {
				
			public void actionPerformed(ActionEvent arg0) {
				

				

				String ncodigoNavio = TFCodigoNavio.getText();
				String nnomeDoCapitao = TFNomeDoCapitao.getText();
				String  ntrasportadora= TFTransportadora.getText();
				String nnumeroRegistro = TFnumeroRegistro.getText();	
				
				
				Capitao c = new Capitao(nnomeDoCapitao,ntrasportadora,nnumeroRegistro);
				
				Cadastro.cadastrarNavio(ncodigoNavio,c,esquadra);
				String entradalog = "Entrada";	
				String dateLogNavio = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
				Cadastro.logCadastrarNavio(ncodigoNavio,c,entradalog,dateLogNavio,esquadraRegistro);
						
				TFCodigoNavio.setText("");
				TFNomeDoCapitao.setText("");
				TFTransportadora.setText("");
				TFnumeroRegistro.setText("");
			
									
				BTCadastrarNavio.setEnabled(false);
	
					
				

		
				
				}

				
				
			
			
		});
		BTCadastrarNavio.setBounds(244, 234, 112, 23);
		panel_3.add(BTCadastrarNavio);
		
		JButton btnValidar = new JButton("VALIDAR");
		btnValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String vCodigoNavio = TFCodigoNavio.getText() ;
				String vNomeCapitao = TFNomeDoCapitao.getText();
				String vEmpresaNavio = TFTransportadora.getText() ;
				String vNumeroRegistroNav = TFnumeroRegistro.getText() ;
				
				vCodigoNavio = vCodigoNavio.trim();
				vNomeCapitao = vNomeCapitao.trim();
				vEmpresaNavio = vEmpresaNavio.trim();
				vNumeroRegistroNav = vNumeroRegistroNav.trim();
				
				
				if (!vCodigoNavio.equals("") && !vNomeCapitao.equals("")  && !vEmpresaNavio.equals("") && !vNumeroRegistroNav.equals(""))
				
				{
					BTCadastrarNavio.setEnabled(true);
	
				}
			}
		});

		btnValidar.setBounds(126, 234, 101, 23);
		panel_3.add(btnValidar);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		Principal.add(panel_4, "name_291191265614299");
		panel_4.setLayout(null);
		
		JTextPane txtpnMenuDeCarregamento = new JTextPane();
		txtpnMenuDeCarregamento.setEditable(false);
		txtpnMenuDeCarregamento.setText("Menu de Descarregamento de Containers");
		txtpnMenuDeCarregamento.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnMenuDeCarregamento.setBackground(Color.WHITE);
		txtpnMenuDeCarregamento.setBounds(83, 25, 370, 28);
		panel_4.add(txtpnMenuDeCarregamento);
		
		TFidContainer = new JTextField();
		TFidContainer.setBounds(34, 114, 135, 20);
		panel_4.add(TFidContainer);
		TFidContainer.setColumns(10);
		
		TForigemContainer = new JTextField();
		TForigemContainer.setBounds(190, 114, 135, 20);
		panel_4.add(TForigemContainer);
		TForigemContainer.setColumns(10);
		
		JTextPane txtpnIdDoContainer = new JTextPane();
		txtpnIdDoContainer.setText("ID do Container");
		txtpnIdDoContainer.setEditable(false);
		txtpnIdDoContainer.setBounds(34, 92, 120, 20);
		panel_4.add(txtpnIdDoContainer);
		
		JTextPane txtpnDestinoDoContainer = new JTextPane();
		txtpnDestinoDoContainer.setText("Origem do Container");
		txtpnDestinoDoContainer.setEditable(false);
		txtpnDestinoDoContainer.setBounds(190, 92, 135, 20);
		panel_4.add(txtpnDestinoDoContainer);
		
		JButton btnCarregar_1 = new JButton("Descarregar Container");
		btnCarregar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (seletor == 0) {
					
					btnCarregar_1.setEnabled(false);
	
				String ccodigoContainer = TFidContainer.getText();
				String corigem = TForigemContainer.getText();
				String cdestino= TFdestinoContainer.getText();
				String cmercadoria = TFmercadoria.getText();	
				
				String ctransportadora = frota.getFirst().getMotorista().getEmpresa();				
				Cadastro.cadastrarContainer(ccodigoContainer,corigem,cdestino,cmercadoria,ctransportadora,patio);
					

				String dateLogContainer = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
				String entradaLogContainer = "Entrada";	
		
				Cadastro.logCadastrarContainer(ccodigoContainer,corigem,cdestino,cmercadoria,ctransportadora,dateLogContainer,
				entradaLogContainer,"Caminhão",frota.getFirst().getCodigoCaminhao(),patioRegistro);
		
				
				TFidContainer.setText("");
				TForigemContainer.setText("");
				TFdestinoContainer.setText("");
				TFmercadoria.setText("");
				
				}
				if (seletor == 1) {
					
					btnCarregar_1.setEnabled(false);
					
					String ccodigoContainer = TFidContainer.getText();
					String corigem = TForigemContainer.getText();
					String cdestino= TFdestinoContainer.getText();
					String cmercadoria = TFmercadoria.getText();	
					
					String vTransportadora = esquadra.getFirst().getCapitao().getEmpresa();				
					Cadastro.cadastrarContainer(ccodigoContainer,corigem,cdestino,cmercadoria,vTransportadora,patio);
						
					String dateLogContainer = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
					String entradaLogContainer = "Entrada";	
					
					
					Cadastro.logCadastrarContainer(ccodigoContainer,corigem,cdestino,cmercadoria,vTransportadora,dateLogContainer,
					entradaLogContainer,"Navio",esquadra.getFirst().getCodigoNavio(),patioRegistro);
					
					TFidContainer.setText("");
					TForigemContainer.setText("");
					TFdestinoContainer.setText("");
					TFmercadoria.setText("");
					
					}
				
				
			}
		});
		btnCarregar_1.setBounds(287, 192, 183, 28);
		panel_4.add(btnCarregar_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("Destino do Container");
		textPane.setEditable(false);
		textPane.setBounds(335, 92, 135, 20);
		panel_4.add(textPane);
		
		TFdestinoContainer = new JTextField();
		TFdestinoContainer.setColumns(10);
		TFdestinoContainer.setBounds(335, 114, 135, 20);
		panel_4.add(TFdestinoContainer);
		
		JTextPane txtpnContedoDoContainer = new JTextPane();
		txtpnContedoDoContainer.setText("Conte\u00FAdo do Container");
		txtpnContedoDoContainer.setEditable(false);
		txtpnContedoDoContainer.setBounds(34, 141, 208, 20);
		panel_4.add(txtpnContedoDoContainer);
		
		TFmercadoria = new JTextField();
		TFmercadoria.setColumns(10);
		TFmercadoria.setBounds(34, 161, 436, 20);
		panel_4.add(TFmercadoria);
		
		
		
		
		
		Panel panel_5 = new Panel();
		panel_5.setLayout(null);
		panel_5.setBackground(Color.WHITE);
		Principal.add(panel_5, "name_292296819043714");
		
		JTextPane txtpnFilaDeNavios = new JTextPane();
		txtpnFilaDeNavios.setText("Fila de Navios");
		txtpnFilaDeNavios.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnFilaDeNavios.setEditable(false);
		txtpnFilaDeNavios.setBackground(Color.WHITE);
		txtpnFilaDeNavios.setBounds(173, 11, 150, 28);
		panel_5.add(txtpnFilaDeNavios);
		
		JButton button_1 = new JButton("INICIO");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_5.setVisible(false);
				panel.setVisible(true);
			}
		});
		button_1.setBounds(0, 0, 89, 23);
		panel_5.add(button_1);
		
		
			
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 70, 502, 198);
		panel_5.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setRowSelectionAllowed(false);
		table_1.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID do Navio", "Capitao", "Transportadora", "Registro"
				}
			));
		scrollPane_1.setViewportView(table_1);
		
		
		
		
		JButton btnDescarregar = new JButton("DESCARREGAR");
		btnDescarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCarregar_1.setEnabled(false);
				panel_2.setVisible(false);
				panel_4.setVisible(true);
				
				seletor = 0;
				 
			}
		});
		btnDescarregar.setBounds(0, 48, 130, 23);
		panel_2.add(btnDescarregar);
		
		Panel panel_6 = new Panel();
		panel_6.setLayout(null);
		panel_6.setBackground(Color.WHITE);
		Principal.add(panel_6, "name_297948003670518");
		
		JTextPane txtpnListaDeContainers = new JTextPane();
		txtpnListaDeContainers.setText("Lista de Containers");
		txtpnListaDeContainers.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnListaDeContainers.setEditable(false);
		txtpnListaDeContainers.setBackground(Color.WHITE);
		txtpnListaDeContainers.setBounds(160, 11, 231, 28);
		panel_6.add(txtpnListaDeContainers);
		
		JButton button_6 = new JButton("INICIO");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_6.setVisible(false);
				panel.setVisible(true);
			}
		});
		button_6.setBounds(0, 0, 89, 23);
		panel_6.add(button_6);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 70, 502, 198);
		panel_6.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.setRowSelectionAllowed(false);
		table_2.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID do Container", "Origem", "Destinatário", "Mercadoria", "Transportadora"
				}
			));
		
		scrollPane_2.setViewportView(table_2);
		JButton btnContainers = new JButton("Containers");
		btnContainers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel.setVisible(false);
				panel_6.setVisible(true);
				
				table_2.setModel(new DefaultTableModel(
						new Object[][] { // cria o objeto 
						},
						new String[] {
								"ID do Container", "Origem", "Destinatário", "Mercadoria", "Transportadora"
						}
					));
				
				DefaultTableModel dt2 = (DefaultTableModel) table_2.getModel();
				
				for (int i = 0; i < patio.size(); i++) {
					
				
				String cIdContainer = patio.get(i).getCodigoContainer();
				String ccorigem = patio.get(i).getOrigem();
				String ccdestino = patio.get(i).getDestino();
				String ccmercadoria = patio.get(i).getMercadoria();
				String ctransportador = patio.get(i).getTransportadora();
				
				
				
				
				if((cIdContainer.length() > 0) && (ccorigem.length() > 0) && 
						(ccdestino.length() > 0) && (ccmercadoria.length() > 0)) {
					dt2.addRow(new String[] {cIdContainer,ccorigem,ccdestino,ccmercadoria,ctransportador});
				 
				} 
				
				}
			}
		});
		btnContainers.setBounds(70, 169, 112, 33);
		panel.add(btnContainers);
		
		
		JButton button_4 = new JButton("DESCARREGAR");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnCarregar_1.setEnabled(false);
				panel_5.setVisible(false);
				panel_4.setVisible(true);
				seletor = 1;
			}
		});
		button_4.setBounds(0, 48, 130, 23);
		panel_5.add(button_4);
		
		Panel panel_7 = new Panel();
		panel_7.setLayout(null);
		panel_7.setBackground(Color.WHITE);
		Principal.add(panel_7, "name_139791859971523");
		
		JTextPane txtpnCarregamentoDeContainers = new JTextPane();
		txtpnCarregamentoDeContainers.setText("Carregamento de Containers");
		txtpnCarregamentoDeContainers.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnCarregamentoDeContainers.setEditable(false);
		txtpnCarregamentoDeContainers.setBackground(Color.WHITE);
		txtpnCarregamentoDeContainers.setBounds(114, 11, 276, 28);
		panel_7.add(txtpnCarregamentoDeContainers);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(0, 117, 502, 151);
		panel_7.add(scrollPane_3);
		
		table_3 = new JTable();
		table_3.setRowSelectionAllowed(false);
		table_3.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID do Container", "Origem", "Destinatario", "Mercadoria", "Transportadora"
				}
			));
		
		scrollPane_3.setViewportView(table_3);
		
		TFprocuraContainer = new JTextField();
		TFprocuraContainer.setBounds(98, 60, 97, 20);
		panel_7.add(TFprocuraContainer);
		TFprocuraContainer.setColumns(10);
		
		JTextPane txtpnIdDoContainer_1 = new JTextPane();
		txtpnIdDoContainer_1.setText("ID do Container:");
		txtpnIdDoContainer_1.setBounds(0, 60, 104, 20);
		panel_7.add(txtpnIdDoContainer_1);
		
		
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if (seletor == 0) {
				
				table_3.setModel(new DefaultTableModel(
						new Object[][] { // cria o objeto 
						},
						new String[] {
								"ID do Container", "Origem", "Destinatario", "Mercadoria", "Transportadora"
						}
					));
				DefaultTableModel dt3 = (DefaultTableModel) table_3.getModel();
		
				
				for (int i = 0; i < patio.size(); i++) {

					if(frota.getFirst().getMotorista().getNome().equals( patio.get(i).getDestino()) && TFprocuraContainer.getText().equals(patio.get(i).getCodigoContainer())) {
				
					String cIdContainer = patio.get(i).getCodigoContainer();
					String cCorigem = patio.get(i).getOrigem();
					String cCdestino = patio.get(i).getDestino();
					String cCmercadoria = patio.get(i).getMercadoria();
					String cCtransportador = patio.get(i).getTransportadora();
					

					dt3.addRow(new String[] {cIdContainer,cCorigem,cCdestino,cCmercadoria,cCtransportador});		
					
					apagaContainer.setCodigoContainer(cIdContainer);
					apagaContainer.setDestino(cCdestino);
					apagaContainer.setOrigem(cCorigem);
					apagaContainer.setMercadoria(cCmercadoria);
					apagaContainer.setTransportadora(cCtransportador);
				
						
					
					
					}//}
				}
				}
				if (seletor == 1) {
				table_3.setModel(new DefaultTableModel(
						new Object[][] { // cria o objeto 
						},
						new String[] {
								"ID do Container", "Origem", "Destinatario", "Mercadoria", "Transportadora"
						}
					));
				DefaultTableModel dt3 = (DefaultTableModel) table_3.getModel();
		
				
				for (int i = 0; i < patio.size(); i++) {
					
					if(esquadra.getFirst().getCapitao().getNome().equals( patio.get(i).getDestino()) 
							&& TFprocuraContainer.getText().equals(patio.get(i).getCodigoContainer())) {
				
					String cIdContainer = patio.get(i).getCodigoContainer();
					String cCorigem = patio.get(i).getOrigem();
					String cCdestino = patio.get(i).getDestino();
					String cCmercadoria = patio.get(i).getMercadoria();
					String cCtransportador = patio.get(i).getTransportadora();
					 

					dt3.addRow(new String[] {cIdContainer,cCorigem,cCdestino,cCmercadoria,cCtransportador});		
					
					apagaContainer.setCodigoContainer(cIdContainer);
					apagaContainer.setDestino(cCdestino);
					apagaContainer.setOrigem(cCorigem);
					apagaContainer.setMercadoria(cCmercadoria);
					apagaContainer.setTransportadora(cCtransportador);
					
									
				
				
					}
			}
			}
				}}
	);
				


		btnProcurar.setBounds(205, 59, 112, 23);
		panel_7.add(btnProcurar);
		
		JButton btnNewButton = new JButton("Carregar Container");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if (seletor == 0) {
				
				String codigoParaExcluir = TFprocuraContainer.getText();
				
				Containers containerExcluir = null;
				
				for (int i = 0; i < patio.size(); i++) {
					
					if((patio.get(i).getCodigoContainer().equals(TFprocuraContainer.getText()))) {
						
						containerExcluir = patio.get(i);
					}
					
					if(containerExcluir != null) {
						
												
						String ccodigoContainer = containerExcluir.getCodigoContainer();
						String corigem = containerExcluir.getOrigem();
						String cdestino= containerExcluir.getDestino();
						String cmercadoria = containerExcluir.getMercadoria();	
						String ctransportadora = frota.getFirst().getMotorista().getEmpresa();				
						String dateLogContainer = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
						String entradaLogContainer = "Saída";	

						Cadastro.logCadastrarContainer(ccodigoContainer,corigem,cdestino,cmercadoria,ctransportadora,dateLogContainer,
						entradaLogContainer,"Caminhão",frota.getFirst().getCodigoCaminhao(),patioRegistro);

						patio.remove(containerExcluir);
						containerExcluir = null;
				}
			
					 
				}
				
				TFprocuraContainer.setText("");	
				
				table_3.setModel(new DefaultTableModel(
						new Object[][] { // cria o objeto 
						},
						new String[] {
								"ID do Container", "Origem", "Destinatario", "Mercadoria", "Transportadora"
						}
					));
				DefaultTableModel dt3 = (DefaultTableModel) table_3.getModel();
		
				
				for (int i = 0; i < patio.size(); i++) {
					if(frota.getFirst().getMotorista().getNome().equals( patio.get(i).getDestino()) && TFprocuraContainer.getText().equals(patio.get(i).getCodigoContainer())) {
				
					String cIdContainer = patio.get(i).getCodigoContainer();
					String cCorigem = patio.get(i).getOrigem();
					String cCdestino = patio.get(i).getDestino();
					String cCmercadoria = patio.get(i).getMercadoria();
					

					dt3.addRow(new String[] {cIdContainer,cCorigem,cCdestino,cCmercadoria});
						
					
					
					
					}
				};
			}
				if (seletor == 1) {
					
					String codigoParaExcluir = TFprocuraContainer.getText();
					
					Containers containerExcluir = null;
					
					for (int i = 0; i < patio.size(); i++) {
						
						if((patio.get(i).getCodigoContainer().equals(TFprocuraContainer.getText()))) {
							
							containerExcluir = patio.get(i);
						}
						
						if(containerExcluir != null) {
							
							String ccodigoContainer = containerExcluir.getCodigoContainer();
							String corigem = containerExcluir.getOrigem();
							String cdestino= containerExcluir.getDestino();
							String cmercadoria = containerExcluir.getMercadoria();					
							String vTransportadora = esquadra.getFirst().getCapitao().getEmpresa();				
							String dateLogContainer = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
							String entradaLogContainer = "Saída";	

							Cadastro.logCadastrarContainer(ccodigoContainer,corigem,cdestino,cmercadoria,vTransportadora,dateLogContainer,
							entradaLogContainer,"Navio",esquadra.getFirst().getCodigoNavio(),patioRegistro);
							
							patio.remove(containerExcluir);
							containerExcluir = null;
							
						}
						
						}

			
					
					TFprocuraContainer.setText("");	
					
					table_3.setModel(new DefaultTableModel(
							new Object[][] { // cria o objeto 
							},
							new String[] {
									"ID do Container", "Origem", "Destinatario", "Mercadoria", "Transportadora"
							}
						));
					DefaultTableModel dt3 = (DefaultTableModel) table_3.getModel();
			
					
					for (int i = 0; i < patio.size(); i++) {
						if(esquadra.getFirst().getCapitao().getNome().equals( patio.get(i).getDestino()) && TFprocuraContainer.getText().equals(patio.get(i).getCodigoContainer())) {
					
						String cIdContainer = patio.get(i).getCodigoContainer();
						String cCorigem = patio.get(i).getOrigem();
						String cCdestino = patio.get(i).getDestino();
						String cCmercadoria = patio.get(i).getMercadoria();
						

						dt3.addRow(new String[] {cIdContainer,cCorigem,cCdestino,cCmercadoria});

						}
					};
				}

			
			}}
	);
		btnNewButton.setBounds(348, 57, 144, 28);
		panel_7.add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_7.setVisible(false);
				panel.setVisible(true);
				TFprocuraContainer.setText("");
			}
		});
		btnCancelar.setBounds(395, 12, 97, 35);
		panel_7.add(btnCancelar);
		
		JButton btnNewButton_4 = new JButton("Listar Cargas p/ Destinat\u00E1rio");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				table_3.setModel(new DefaultTableModel(
						new Object[][] { // cria o objeto 
						},
						new String[] {
								"ID do Container", "Origem", "Destinatario", "Mercadoria", "Transportadora"
						}
					));
				DefaultTableModel dt3 = (DefaultTableModel) table_3.getModel();
		
				if (seletor == 0) { 
				
				for (int i = 0; i < patio.size(); i++) {

					if(frota.getFirst().getMotorista().getNome().equals( patio.get(i).getDestino())) {
				
					String cIDContainer = patio.get(i).getCodigoContainer();
					String cCorigem = patio.get(i).getOrigem();
					String cCdestino = patio.get(i).getDestino();
					String cCmercadoria = patio.get(i).getMercadoria();
					String cCtransportador = patio.get(i).getTransportadora();
					
 
					dt3.addRow(new String[] {cIDContainer,cCorigem,cCdestino,cCmercadoria,cCtransportador});
				
			}}
		}
					for (int i = 0; i < patio.size(); i++) {
					
					if(esquadra.getFirst().getCapitao().getNome().equals( patio.get(i).getDestino())) {
				
					String cIdContainer = patio.get(i).getCodigoContainer();
					String cCorigem = patio.get(i).getOrigem();
					String cCdestino = patio.get(i).getDestino();
					String cCmercadoria = patio.get(i).getMercadoria();
					String cCtransportador = patio.get(i).getTransportadora();
					

					dt3.addRow(new String[] {cIdContainer,cCorigem,cCdestino,cCmercadoria,cCtransportador});
				}}}}
		);
		btnNewButton_4.setBounds(0, 91, 217, 23);
		panel_7.add(btnNewButton_4);
		JButton btnCarregarContainer = new JButton("Carregar Container");
		btnCarregarContainer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_4.setVisible(false);
				panel_7.setVisible(true);

			}}
		);
		btnCarregarContainer.setBounds(220, 229, 144, 28);
		panel_4.add(btnCarregarContainer);
		
		JButton btnNewButton_1 = new JButton("Cancelar Opera\u00E7\u00E3o");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				panel_4.setVisible(false);
				panel.setVisible(true);
				
				TFidContainer.setText("") ;
				TForigemContainer.setText("") ;
				TFdestinoContainer.setText("") ;
				TFmercadoria.setText("") ;
			}
		});
		btnNewButton_1.setBounds(10, 229, 144, 26);
		panel_4.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Validar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String vCodigoContainer = TFidContainer.getText() ;
				String vOrigem = TForigemContainer.getText();
				String vDestino = TFdestinoContainer.getText() ;
				String vMercadoria = TFmercadoria.getText() ;
				
				vCodigoContainer = vCodigoContainer.trim();
				vOrigem = vOrigem.trim();
				vDestino = vDestino.trim();
				vMercadoria = vMercadoria.trim();
				
				if (!vCodigoContainer.equals("") && !vOrigem.equals("")  && !vDestino.equals("") && !vMercadoria.equals(""))	
				{
					btnCarregar_1.setEnabled(true);
	
				}
			}
		});
		btnNewButton_3.setBounds(171, 192, 106, 28);
		panel_4.add(btnNewButton_3);
		JButton btnCarregar = new JButton("CARREGAR");
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel_2.setVisible(false);
				panel_7.setVisible(true);
				
				seletor = 0;
				
				table_3.setModel(new DefaultTableModel(
						new Object[][] { // cria o objeto 
						},
						new String[] {
								"ID do Container", "Origem", "Destinatário", "Mercadoria", "Transportadora"
						}
					));
				
			}}
		);
		btnCarregar.setBounds(129, 48, 130, 23);
		panel_2.add(btnCarregar);
		JButton button_3 = new JButton("CARREGAR");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel_5.setVisible(false);
				panel_7.setVisible(true);
				
				seletor = 1;
			}
		});
		button_3.setBounds(131, 48, 130, 23);
		panel_5.add(button_3);
		JButton btnSalvarDados = new JButton("SAIR E SALVAR DADOS ");
		btnSalvarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//exportar patio
				
				File dir = new File("ARQUIVO");
				dir.mkdirs();
				
				File arquivoSaida = new File("ARQUIVO/Patio.txt");
				
				
				try {
					arquivoSaida.createNewFile();
					FileWriter fr = new FileWriter(arquivoSaida,false);
					BufferedWriter br = new BufferedWriter(fr);
					
					
					
					for (int i = 0; i < patio.size(); i++) {
						br.write(patio.get(i).getCodigoContainer()+ "\n");
						br.write(patio.get(i).getOrigem()+ "\n");
						br.write(patio.get(i).getDestino() + "\n");
						br.write(patio.get(i).getMercadoria() + "\n");
						br.write(patio.get(i).getTransportadora() + "\n");
						
					}
					
					
					br.close();
					fr.close();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				// exportar frota
				
				
				
				File arquivoSaida1 = new File("ARQUIVO/Frota.txt");
				
				
				try {
					arquivoSaida1.createNewFile();
					FileWriter fr = new FileWriter(arquivoSaida1,false);
					BufferedWriter br = new BufferedWriter(fr);
										
					for (int i = 0; i < frota.size(); i++) {
						br.write(frota.get(i).getCodigoCaminhao() + "\n");
						br.write(frota.get(i).getMotorista().getNome() + "\n");
						br.write(frota.get(i).getMotorista().getEmpresa()  + "\n");
						br.write(frota.get(i).getMotorista().getNumeroRegistro() + "\n");										
					}
	
					br.close();
					fr.close();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				// exportar frota
				
				
				File arquivoSaida2 = new File("ARQUIVO/Esquadra.txt");
				
				
				try {
					arquivoSaida2.createNewFile();
					FileWriter fr = new FileWriter(arquivoSaida2,false);
					BufferedWriter br = new BufferedWriter(fr);
						
					
					for (int i = 0; i < esquadra.size(); i++) {
						br.write(esquadra.get(i).getCodigoNavio() + "\n");
						br.write(esquadra.get(i).getCapitao().getNome() + "\n");
						br.write(esquadra.get(i).getCapitao().getEmpresa()  + "\n");
						br.write(esquadra.get(i).getCapitao().getNumeroRegistro() + "\n");										
					}
	
					br.close();
					fr.close();
				
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}

			
				// exporta log caminhão
				
				File arquivoSaida3 = new File("ARQUIVO/LogFrota.txt");
				
				
				try {
					arquivoSaida3.createNewFile();
					FileWriter fr = new FileWriter(arquivoSaida3,false);
					BufferedWriter br = new BufferedWriter(fr);
					
					
					//String codigoCaminhao, Motorista motorista, String logMotorista, String logRegCaminhao) 
					for (int i = 0; i < frotaRegistro.size(); i++) {
						br.write(frotaRegistro.get(i).getCodigoCaminhao() + "\n");
						br.write(frotaRegistro.get(i).getMotorista().getNome() + "\n");
						br.write(frotaRegistro.get(i).getMotorista().getEmpresa() + "\n");
						br.write(frotaRegistro.get(i).getMotorista().getNumeroRegistro() + "\n");
						br.write(frotaRegistro.get(i).getLogMotorista() + "\n");		
						br.write(frotaRegistro.get(i).getLogRegCaminhao() + "\n");
					}
	
					br.close();
					fr.close();
				
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				
				// exporta log esquadra
				
				File arquivoSaida4 = new File("ARQUIVO/LogEsquadra.txt");
				
				
				try {
					arquivoSaida4.createNewFile();
					FileWriter fr = new FileWriter(arquivoSaida4,false);
					BufferedWriter br = new BufferedWriter(fr);
					
		
					for (int i = 0; i < esquadraRegistro.size(); i++) {
						br.write(esquadraRegistro.get(i).getCodigoNavio() + "\n");
						br.write(esquadraRegistro.get(i).getCapitao().getNome() + "\n");
						br.write(esquadraRegistro.get(i).getCapitao().getEmpresa() + "\n");
						br.write(esquadraRegistro.get(i).getCapitao().getNumeroRegistro() + "\n");
						br.write(esquadraRegistro.get(i).getLogNavio() + "\n");		
						br.write(esquadraRegistro.get(i).getLogRegNavio() + "\n");
					}
	
					br.close();
					fr.close();
				
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				
				
				// exporta log patio
				
				File arquivoSaida5 = new File("ARQUIVO/LogPatio.txt");
				
				
				try {
					arquivoSaida5.createNewFile();
					FileWriter fr = new FileWriter(arquivoSaida5,false);
					BufferedWriter br = new BufferedWriter(fr);
					
				
					for (int i = 0; i < patioRegistro.size(); i++) {
						br.write(patioRegistro.get(i).getCodigoContainer() + "\n");
						br.write(patioRegistro.get(i).getOrigem() + "\n");
						br.write(patioRegistro.get(i).getDestino() + "\n");
						br.write(patioRegistro.get(i).getMercadoria() + "\n");
						br.write(patioRegistro.get(i).getTransportadora() + "\n");		
						br.write(patioRegistro.get(i).getLogContainers() + "\n");
						br.write(patioRegistro.get(i).getLogRegContainrs() + "\n");
						br.write(patioRegistro.get(i).getNavioOuCaminhao() + "\n");
						br.write(patioRegistro.get(i).getPlacaTranposte()+ "\n");
						
					}
	
					br.close();
					fr.close();
				
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				System.exit(0);

	}	
		});
		btnSalvarDados.setBounds(161, 210, 169, 47);
		panel.add(btnSalvarDados);
		
	
		
		Panel panel_8 = new Panel();
		Principal.add(panel_8, "name_251449621040972");
		panel_8.setLayout(null);
		panel_8.setBackground(Color.WHITE);
		
		JTextPane txtpnMenuDeRegistro = new JTextPane();
		txtpnMenuDeRegistro.setText("Menu de Registro");
		txtpnMenuDeRegistro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnMenuDeRegistro.setEditable(false);
		txtpnMenuDeRegistro.setBackground(Color.WHITE);
		txtpnMenuDeRegistro.setBounds(160, 11, 231, 28);
		panel_8.add(txtpnMenuDeRegistro);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(0, 70, 502, 198);
		panel_8.add(scrollPane_4);
		
		
		table_4 = new JTable();
		scrollPane_4.setViewportView(table_4);
		
		JButton btnLogCaminho = new JButton("Log Caminh\u00E3o");
		btnLogCaminho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				table_4.setModel(new DefaultTableModel(
						new Object[][] { // cria o objeto 
						},
						new String[] {
							"Placa do Caminhão", "Motorista", "Transportadora", "Registro", "Data", "Movimentação"
						}
					));
				DefaultTableModel dt4 = (DefaultTableModel) table_4.getModel();
				
				for (int i = 0; i < frotaRegistro.size(); i++) {
					
				
				String rtcPlacaDoCaminhao = frotaRegistro.get(i).getCodigoCaminhao();
				String rtcMotorista = frotaRegistro.get(i).getMotorista().getNome();
				String rtcTransportadora = frotaRegistro.get(i).getMotorista().getEmpresa();
				String rtcRegistro = frotaRegistro.get(i).getMotorista().getNumeroRegistro();
				String rdata = frotaRegistro.get(i).getLogMotorista();
				String rmovimentacao = frotaRegistro.get(i).getLogRegCaminhao();
				
					dt4.addRow(new String[] {rtcPlacaDoCaminhao,rtcMotorista,rtcTransportadora,rtcRegistro,rdata,rmovimentacao});
			
				
				}
			}
		});
		
		btnLogCaminho.setBounds(0, 46, 122, 23);
		panel_8.add(btnLogCaminho);
		
		JButton btnInicio_1 = new JButton("Inicio");
		btnInicio_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_8.setVisible(false);
				panel.setVisible(true);
			}
		});
		btnInicio_1.setBounds(0, 0, 89, 23);
		panel_8.add(btnInicio_1);
		
		JButton btnLogNavio = new JButton("Log Navio");
		btnLogNavio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				table_4.setModel(new DefaultTableModel(
						new Object[][] { // cria o objeto 
						},
						new String[] {
								"ID do Navio", "Capitao", "Transportadora", "Registro", "Data", "Movimentação"
						}
					));
				
				DefaultTableModel dt1 = (DefaultTableModel) table_4.getModel();
				
				for (int i = 0; i < esquadraRegistro.size(); i++) {
					
				 
				String lIDDoNavio = esquadraRegistro.get(i).getCodigoNavio();
				String lTcCapitao = esquadraRegistro.get(i).getCapitao().getNome();
				String lNavTransportadora = esquadraRegistro.get(i).getCapitao().getEmpresa();
				String lNavtcRegistro = esquadraRegistro.get(i).getCapitao().getNumeroRegistro();
				String lNavData = esquadraRegistro.get(i).getLogNavio();
				String lNavMov = esquadraRegistro.get(i).getLogRegNavio();
				
				
					dt1.addRow(new String[] {lIDDoNavio,lTcCapitao,lNavtcRegistro,lNavTransportadora,lNavMov,lNavData});
				 
				
				
				}
			}
		});

		btnLogNavio.setBounds(132, 46, 122, 23);
		panel_8.add(btnLogNavio);
		
		JButton button_5 = new JButton("Log Containers");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				table_4.setModel(new DefaultTableModel(
						new Object[][] { // cria o objeto 
						},
						new String[] {
								"ID do Container", "Origem", "Destinatário", "Mercadoria", "Transportadora","Data","Movi.","Meio","Placa"
						}
					));
				
				DefaultTableModel dt2 = (DefaultTableModel) table_4.getModel();
			
				for (int i = 0; i < patioRegistro.size(); i++) {
				String lCIDContainer = patioRegistro.get(i).getCodigoContainer();
				String lCCorigem = patioRegistro.get(i).getOrigem();
				String lCCdestino = patioRegistro.get(i).getDestino();
				String lCCmercadoria = patioRegistro.get(i).getMercadoria();
				String lCtransportador = patioRegistro.get(i).getTransportadora();
				String lCData = patioRegistro.get(i).getLogContainers();
				String lCMov = patioRegistro.get(i).getLogRegContainrs();
				String lCMeio = patioRegistro.get(i).getNavioOuCaminhao();
				String lCNaviCam = patioRegistro.get(i).getPlacaTranposte();
		
				dt2.addRow(new String[] {lCIDContainer,lCCorigem,lCCdestino,lCCmercadoria,lCtransportador,lCData,lCMov,lCMeio,lCNaviCam});
			
				}
			}
		});
	
		button_5.setBounds(269, 46, 122, 23);
		panel_8.add(button_5);
		
		
		
		JButton btnRegistros = new JButton("Registros");
		btnRegistros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				panel.setVisible(false);
				panel_8.setVisible(true);
				table_4.setModel(new DefaultTableModel(
						new Object[][] { // cria o objeto 
						},
						new String[] {
							
						}
					));
				
			}
		});
		btnRegistros.setBounds(296, 170, 112, 31);
		panel.add(btnRegistros);
		
		JButton btnCadastrarNavio = new JButton("Cadastrar Navio");
		btnCadastrarNavio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BTCadastrarNavio.setEnabled(false);
				panel.setVisible(false);
				panel_3.setVisible(true);
			}
		});
		btnCadastrarNavio.setBounds(284, 75, 160, 23);
		panel.add(btnCadastrarNavio);
	
		JButton btnCadastrarCaminho = new JButton("Cadastrar Caminh\u00E3o");
		btnCadastrarCaminho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnCadastrar.setEnabled(false);
				panel.setVisible(false);
				panel_1.setVisible(true);
				
			}
		});
		btnCadastrarCaminho.setBounds(45, 75, 160, 23);
		panel.add(btnCadastrarCaminho);
		
		JTextPane txtpnListaDeContainers_1 = new JTextPane();
		txtpnListaDeContainers_1.setText("Lista de Containers");
		txtpnListaDeContainers_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnListaDeContainers_1.setEditable(false);
		txtpnListaDeContainers_1.setBounds(69, 145, 136, 25);
		panel.add(txtpnListaDeContainers_1);
		
		JTextPane txtpnRegistrosGeral = new JTextPane();
		txtpnRegistrosGeral.setText("Registros Gerais");
		txtpnRegistrosGeral.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnRegistrosGeral.setEditable(false);
		txtpnRegistrosGeral.setBounds(308, 145, 136, 25);
		panel.add(txtpnRegistrosGeral);
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TFidContainer.setText("") ;
				TForigemContainer.setText("") ;
				TFdestinoContainer.setText("") ;
				TFmercadoria.setText("") ;
				
				
				if(seletor == 0) {
				panel_4.setVisible(false);
				panel_2.setVisible(true);

				Motorista cmotorista2 = new Motorista(frota.getFirst().getMotorista().getNome(),frota.getFirst().getMotorista().getEmpresa(),frota.getFirst().getMotorista().getNumeroRegistro());
				
				String dateLogCaminhao = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
				String entradalog = "Saída";		
						
				Cadastro.logCadastrarCaminhao(frota.getFirst().getCodigoCaminhao(),cmotorista2,dateLogCaminhao,entradalog,frotaRegistro);
				
				frota.removeFirst();
				if (frota.isEmpty()) {
					btnDescarregar.setEnabled(false);
					btnCarregar.setEnabled(false);
					button_4.setEnabled(false);
					button_3.setEnabled(false);
					
				}
				
				if (!frota.isEmpty()) {
					btnDescarregar.setEnabled(true);
					btnCarregar.setEnabled(true);
					button_4.setEnabled(true);
					button_3.setEnabled(true);
				}

				table.setModel(new DefaultTableModel(
						new Object[][] { // cria o objeto 
						},
						new String[] {
							"Placa do Caminhão", "Motorista", "Transportadora", "Registro"
						}
					));
				DefaultTableModel dt = (DefaultTableModel) table.getModel();
				
				for (int i = 0; i < frota.size(); i++) {
					String tcPlacaDoCaminhao = frota.get(i).getCodigoCaminhao();
					String tcMotorista = frota.get(i).getMotorista().getNome();
					String tcTransportadora = frota.get(i).getMotorista().getEmpresa();
					String tcRegistro = frota.get(i).getMotorista().getNumeroRegistro();
				
				
				
				
				if((tcPlacaDoCaminhao.length() > 0) && (tcMotorista.length() > 0) && 
						(tcTransportadora.length() > 0) && (tcRegistro.length() > 0)) {
					dt.addRow(new String[] {tcPlacaDoCaminhao,tcMotorista,tcTransportadora,tcRegistro,});
				 
				}
				
				}	}
				
				if(seletor == 1) {

					panel_4.setVisible(false);
					panel_5.setVisible(true);

					Capitao c2 = new Capitao(esquadra.getFirst().getCapitao().getNome(),esquadra.getFirst().getCapitao().getEmpresa(),
							esquadra.getFirst().getCapitao().getNumeroRegistro());

					String entradalog = "Saída";	
					String dateLogNavio = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
					Cadastro.logCadastrarNavio(esquadra.getFirst().getCodigoNavio(),c2,entradalog,dateLogNavio, esquadraRegistro);

					esquadra.removeFirst();
					
					if (esquadra.isEmpty()) {
						btnDescarregar.setEnabled(false);
						btnCarregar.setEnabled(false);
						button_4.setEnabled(false);
						button_3.setEnabled(false);
						
					}
					
					if (!esquadra.isEmpty()) {
						btnDescarregar.setEnabled(true);
						btnCarregar.setEnabled(true);
						button_4.setEnabled(true);
						button_3.setEnabled(true);
					}
					
					table_1.setModel(new DefaultTableModel(
							new Object[][] { // cria o objeto 
							},
							new String[] {
									"ID do Navio", "Capitao", "Transportadora", "Registro"
							}
						));
					DefaultTableModel dt = (DefaultTableModel) table_1.getModel();
					
					for (int i = 0; i < esquadra.size(); i++) {
						
						
						String tcIDNavio = esquadra.get(i).getCodigoNavio();
						String tcCapitao = esquadra.get(i).getCapitao().getNome();
						String tcEmpresaNa = esquadra.get(i).getCapitao().getEmpresa();
						String tcRegistro = esquadra.get(i).getCapitao().getNumeroRegistro();

						
							dt.addRow(new String[] {tcIDNavio,tcCapitao,tcEmpresaNa,tcRegistro,});
			
					}	}
			}	
		});
		btnFinalizar.setBounds(374, 229, 96, 28);
		panel_4.add(btnFinalizar);
		JButton btnCarregaCaminho = new JButton("Listar Caminh\u00E3o");
		btnCarregaCaminho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (frota.isEmpty()) {
					btnDescarregar.setEnabled(false);
					btnCarregar.setEnabled(false);
					button_4.setEnabled(false);
					button_3.setEnabled(false);
					
				}
				
				if (!frota.isEmpty()) {
					btnDescarregar.setEnabled(true);
					btnCarregar.setEnabled(true);
					button_4.setEnabled(true);
					button_3.setEnabled(true);
				}
				panel.setVisible(false);
				panel_2.setVisible(true);
				
				table.setModel(new DefaultTableModel(
						new Object[][] { // cria o objeto 
						},
						new String[] {
							"Placa do Caminhão", "Motorista", "Transportadora", "Registro"
						}
					));
				DefaultTableModel dt = (DefaultTableModel) table.getModel();
				
				for (int i = 0; i < frota.size(); i++) {
					
				
				String tcPlacaDoCaminhao = frota.get(i).getCodigoCaminhao();
				String tcMotorista = frota.get(i).getMotorista().getNome();
				String tcTransportadora = frota.get(i).getMotorista().getEmpresa();
				String tcRegistro = frota.get(i).getMotorista().getNumeroRegistro();
				
				
				
				if((tcPlacaDoCaminhao.length() > 0) && (tcMotorista.length() > 0) && 
						(tcTransportadora.length() > 0) && (tcRegistro.length() > 0)) {
					dt.addRow(new String[] {tcPlacaDoCaminhao,tcMotorista,tcTransportadora,tcRegistro,});
				 
				}
				
				}
			}	
		});
		JButton button = new JButton("INICIO");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				panel_2.setVisible(false);
				panel.setVisible(true);
				
			}
		});
		button.setBounds(0, 0, 89, 23);
		panel_2.add(button);
		
		btnCarregaCaminho.setBounds(45, 109, 160, 25);
		panel.add(btnCarregaCaminho);
		JButton btnFinalizar_1 = new JButton("FINALIZAR");
		btnFinalizar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table_3.setModel(new DefaultTableModel(
						new Object[][] { // cria o objeto 
						},
						new String[] {
							
						}
					));
				
				
				if (seletor == 1) {
				
										
					panel_7.setVisible(false);
					panel_5.setVisible(true);
					
				
				TFprocuraContainer.setText("");
				
				Capitao c3 = new Capitao(esquadra.getFirst().getCapitao().getNome(),esquadra.getFirst().getCapitao().getEmpresa(),
						esquadra.getFirst().getCapitao().getNumeroRegistro());

				String entradalog = "Saída";	
				String dateLogNavio = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
				Cadastro.logCadastrarNavio(esquadra.getFirst().getCodigoNavio(),c3,entradalog,dateLogNavio, esquadraRegistro);
				
				
				esquadra.removeFirst();
				
				
				if (esquadra.isEmpty()) {
					btnDescarregar.setEnabled(false);
					btnCarregar.setEnabled(false);
					button_4.setEnabled(false);
					button_3.setEnabled(false);
					
				}
				
				if (!esquadra.isEmpty()) {
					btnDescarregar.setEnabled(true);
					btnCarregar.setEnabled(true);
					button_4.setEnabled(true);
					button_3.setEnabled(true);
				}
				table_1.setModel(new DefaultTableModel(
						new Object[][] { // cria o objeto 
						},
						new String[] {
								"ID do Navio", "Capitao", "Transportadora", "Registro"
						}
					));
				DefaultTableModel dt = (DefaultTableModel) table_1.getModel();
				
				for (int i = 0; i < esquadra.size(); i++) {
					
					
					String tcIDNavio = esquadra.get(i).getCodigoNavio();
					String tcCapitao = esquadra.get(i).getCapitao().getNome();
					String tcEmpresaNa = esquadra.get(i).getCapitao().getEmpresa();
					String tcRegistro = esquadra.get(i).getCapitao().getNumeroRegistro();

					
						dt.addRow(new String[] {tcIDNavio,tcCapitao,tcEmpresaNa,tcRegistro,});
				
					}
				
				}
				if (seletor == 0) {
										
					panel_7.setVisible(false);
					panel_2.setVisible(true);
					Motorista cmotorista3 = new Motorista(frota.getFirst().getMotorista().getNome(),frota.getFirst().getMotorista().getEmpresa(),frota.getFirst().getMotorista().getNumeroRegistro());
					
					String dateLogCaminhao = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
					String entradalog = "Saída";		
							
					Cadastro.logCadastrarCaminhao(frota.getFirst().getCodigoCaminhao(),cmotorista3,dateLogCaminhao,entradalog,frotaRegistro);
					
					
					
					TFprocuraContainer.setText("");
					
					frota.removeFirst();

					if (frota.isEmpty()) {
						btnDescarregar.setEnabled(false);
						btnCarregar.setEnabled(false);
						button_4.setEnabled(false);
						button_3.setEnabled(false);
						
					}
					
					if (!frota.isEmpty()) {
						btnDescarregar.setEnabled(true);
						btnCarregar.setEnabled(true);
						button_4.setEnabled(true);
						button_3.setEnabled(true);
					}
					table.setModel(new DefaultTableModel(
							new Object[][] { // cria o objeto 
							},
							new String[] {
								"Placa do Caminhão", "Motorista", "Transportadora", "Registro"
							}
						));
					DefaultTableModel dt = (DefaultTableModel) table.getModel();
					
					for (int i = 0; i < frota.size(); i++) {
						
					
					String tcPlacaDoCaminhao = frota.get(i).getCodigoCaminhao();
					String tcMotorista = frota.get(i).getMotorista().getNome();
					String tcTransportadora = frota.get(i).getMotorista().getEmpresa();
					String tcRegistro = frota.get(i).getMotorista().getNumeroRegistro();
					
					
					
					if((tcPlacaDoCaminhao.length() > 0) && (tcMotorista.length() > 0) && 
							(tcTransportadora.length() > 0) && (tcRegistro.length() > 0)) {
						dt.addRow(new String[] {tcPlacaDoCaminhao,tcMotorista,tcTransportadora,tcRegistro,});
					 
					}
					
					}
					
				}
				
				
			}	
		});
		btnFinalizar_1.setBounds(0, 11, 104, 28);
		panel_7.add(btnFinalizar_1);
		JButton btnCarregarNavio = new JButton("Listar Navio");
		btnCarregarNavio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (esquadra.isEmpty()) {
					btnDescarregar.setEnabled(false);
					btnCarregar.setEnabled(false);
					button_4.setEnabled(false);
					button_3.setEnabled(false);
					
				}
				
				if (!esquadra.isEmpty()) {
					btnDescarregar.setEnabled(true);
					btnCarregar.setEnabled(true);
					button_4.setEnabled(true);
					button_3.setEnabled(true);
				}
				panel.setVisible(false);
				panel_5.setVisible(true);
				
				seletor = 1;
				
				table_1.setModel(new DefaultTableModel(
						new Object[][] { // cria o objeto 
						},
						new String[] {
								"ID do Navio", "Capitao", "Transportadora", "Registro"
						}
					));
				
				DefaultTableModel dt1 = (DefaultTableModel) table_1.getModel();
				
				for (int i = 0; i < esquadra.size(); i++) {
					
				
				String idDoNavio = esquadra.get(i).getCodigoNavio();
				String tcCapitao = esquadra.get(i).getCapitao().getNome();
				String navTransportadora = esquadra.get(i).getCapitao().getEmpresa();
				String navtcRegistro = esquadra.get(i).getCapitao().getNumeroRegistro();
				
				
				
				if((idDoNavio.length() > 0) && (tcCapitao.length() > 0) && 
						(navTransportadora.length() > 0) && (navtcRegistro.length() > 0)) {
					dt1.addRow(new String[] {idDoNavio,tcCapitao,navtcRegistro,navTransportadora});
				 
				}
				
				}
			}
		});
		btnCarregarNavio.setBounds(284, 109, 160, 25);
		panel.add(btnCarregarNavio);
	}
}
