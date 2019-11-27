package telas;

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
	
	// Criando Botes
	private JButton iniciarJogo = new JButton("Iniciar Jogo");
	private JButton fecharJogo = new JButton("Fechar Jogo");
	private JButton ranking = new JButton("Ranking");
	
	// Criando Labels
	private JLabel labelBatalhaNaval = new JLabel("Batalha Naval");
	private JLabel labelUsuario = new JLabel("Insira o usu\u00E1rio:");

	/**
	 * Construtor da classe TelaInicial que cria os elementos grficos da janela.
	 */
	public TelaInicial() {
		
		// Titulo da janela
		setTitle("Batalha Naval");
		// Retira a opo de redimensionar a janela
		setResizable(false);
		// Configura o trmino do programa quando fechado
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
		
		// Label Inserir usurio
		labelUsuario.setFont(new Font("Roboto", Font.PLAIN, 14));
		labelUsuario.setBounds(135, 116, 105, 14);
		contentPane.add(labelUsuario);
		
		// Boto Iniciar Jogo		
		iniciarJogo.setBounds(182, 238, 111, 36);
		iniciarJogo.setFont(new Font("Verdana", Font.PLAIN, 12));		
		iniciarJogo.addActionListener(this);		
		contentPane.add(iniciarJogo);
		
		// Boto Ranking
		ranking.setFont(new Font("Verdana", Font.PLAIN, 12));
		ranking.setBounds(30, 238, 111, 36);
		ranking.setFocusable(false);
		ranking.addActionListener(this);
		contentPane.add(ranking);
		
		// Boto Fechar jogo
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

	public void actionPerformed(ActionEvent e) {
		
		// Evento quando pressionado o boto Iniciar Jogo
		if (e.getSource() == iniciarJogo){
			
			// Criando String para guardar o nome do jogador
			String nomeJogador = caixaDeTexto.getText();
			
			// Se o campo de nome estiver vazio, pede um usurio vlido
			if (nomeJogador.equals("")){
				JOptionPane.showMessageDialog(null, "Insira um usurio vlido");
			}
			
			// Se o campo no estiver vazio, inicia um novo jogo
			if (!(nomeJogador.equals(""))){
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {						
						Tabuleiro tabuleiro = new Tabuleiro("nomeJogador");
						tabuleiro.setVisible(true);						
					}
				});				
				// Limpa a caixa de texto
				caixaDeTexto.setText("");
			}			
		}
		
		// Evento quando pressionado o boto Fechar Jogo
		if (e.getSource() == fecharJogo){
			System.exit(0);
		}
		
		// Evento quando pressionado o boto Ranking
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