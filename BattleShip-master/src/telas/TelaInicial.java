package telas;
/**
 * Classe que implementa a Tela Inicial do jogo fornecendo uma interface para intera��o com o usu�rio.
 * <p> A classe extende o utilit�rio de interface swing JFrame e implementa a interface ActionListener,
 * que configura as a��es de intera��o com o usu�rio.
 * @author Rodrigo Lima
 */

import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicial extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	// Criando Painel para receber elementos
	private JPanel contentPane = new JPanel();
		
	// Criando Campo de texto para o Nome do Jogador
	private JTextField caixaDeTexto = new JTextField(20);
	
	// Criando Bot�es
	private JButton iniciarJogo = new JButton("Iniciar Jogo");
	private JButton fecharJogo = new JButton("Fechar Jogo");
	private JButton ranking = new JButton("Ranking");
	
	// Criando Labels
	private JLabel labelBatalhaNaval = new JLabel("Batalha Naval");
	private JLabel labelUsuario = new JLabel("Insira o usu\u00E1rio:");

	/**
	 * Construtor da classe TelaInicial que cria os elementos gr�ficos da janela.
	 */
	public TelaInicial() {
		
		// Titulo da janela
		setTitle("Batalha Naval");
		// Retira a op��o de redimensionar a janela
		setResizable(false);
		// Configura o t�rmino do programa quando fechado
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Configura o tamanho da janela
		setBounds(100, 100, 507, 409);		
		
		// Retira a borda do painel
		contentPane.setBorder(null);
		// Retira o Layout do Painel
		contentPane.setLayout(null);
		// Seta o painel como painel do frame
		setContentPane(contentPane);
		
		// Campo de entrada Nome do jogador
		caixaDeTexto.setBounds(133, 141, 223, 29);		
		contentPane.add(caixaDeTexto);	
		
		// Label Batalha Naval
		labelBatalhaNaval.setFont(new Font("Roboto", Font.BOLD, 18));
		labelBatalhaNaval.setBounds(182, 11, 120, 29);
		contentPane.add(labelBatalhaNaval);
		
		// Label Inserir usu�rio
		labelUsuario.setFont(new Font("Roboto", Font.PLAIN, 14));
		labelUsuario.setBounds(135, 116, 105, 14);
		contentPane.add(labelUsuario);
		
		// Bot�o Iniciar Jogo		
		iniciarJogo.setBounds(182, 238, 111, 36);
		iniciarJogo.setFont(new Font("Verdana", Font.PLAIN, 12));		
		iniciarJogo.addActionListener(this);		
		contentPane.add(iniciarJogo);
		
		// Bot�o Ranking
		ranking.setFont(new Font("Verdana", Font.PLAIN, 12));
		ranking.setBounds(30, 238, 111, 36);
		ranking.setFocusable(false);
		ranking.addActionListener(this);
		contentPane.add(ranking);
		
		// Bot�o Fechar jogo
		fecharJogo.setBounds(327, 238, 120, 36);
		fecharJogo.setFont(new Font("Verdana", Font.PLAIN, 12));
		fecharJogo.setFocusable(false);		
		fecharJogo.addActionListener(this);		
		contentPane.add(fecharJogo);
		
		// Centralizando a tela quando iniciada
		setLocationRelativeTo(null);
		
		// Ativando a tecla Enter para Iniciar o Jogo
		getRootPane().setDefaultButton(iniciarJogo);
		
	}
	/**
	 * M�todo que configura as a��es dos bot�es da interface gr�fica.
	 * <p> O bot�o Iniciar Jogo captura o nome do jogador informado pelo usu�rio e inicia uma Thread que 
	 * executa a classe Tabuleiro, passando o nome do jogador como par�metro.
	 * <p> O bot�o Fechar Jogo fecha o jogo, finalizando todas as threads em execu��o.
	 * <p> O bot�o Ranking inicia uma Thread que executa a classe Ranking.
	 * @see Tabuleiro
	 * @see Ranking
	 */
	public void actionPerformed(ActionEvent e) {
		
		// Evento quando pressionado o bot�o Iniciar Jogo
		if (e.getSource() == iniciarJogo){
			
			// Criando String para guardar o nome do jogador
			String nomeJogador = caixaDeTexto.getText();
			
			// Se o campo de nome estiver vazio, pede um usu�rio v�lido
			if (nomeJogador.equals("")){
				JOptionPane.showMessageDialog(null, "Insira um usu�rio v�lido");
			}
			
			// Se o campo n�o estiver vazio, inicia um novo jogo
			if (!(nomeJogador.equals(""))){
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {						
						Tabuleiro tabuleiro = new Tabuleiro(nomeJogador);
						tabuleiro.setVisible(true);						
					}
				});				
				// Limpa a caixa de texto
				caixaDeTexto.setText("");
			}			
		}
		
		// Evento quando pressionado o bot�o Fechar Jogo
		if (e.getSource() == fecharJogo){
			System.exit(0);
		}
		
		// Evento quando pressionado o bot�o Ranking
		if (e.getSource() == ranking){
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					Ranking ranking = new Ranking();
					ranking.setVisible(true);					
				}
			});
		}
	}
}
