package telas;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import battleship.Jogador;
import battleship.Jogo;
import battleship.Pontuacao;

public class Tabuleiro extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	// Adicionando os Painis
	JPanel grid = new JPanel();
	JPanel jContentPane = new JPanel();
	Container cp;

	// Adicionando os Botes
	JButton[][] Botoes = new JButton[10][10];
	JButton novo = new JButton("Novo Jogo");
	JButton voltar = new JButton("Voltar");

	// Adicionando as Labels
	JLabel naviosRestantes = new JLabel("Navios Restantes");
	JLabel tirosRestantes = new JLabel("Tiros Restantes");
	JLabel contNavios = new JLabel("");
	JLabel contTiros = new JLabel("");
	int contadorNavio = 19;
	int contadorTiro = 30;

	// Vetor que fica por trs dos Botes e guarda gua ou navios
	int vetor[][] = new int[10][10];
	int pontuacao = 0;
	String nomeJogador;

	// Instanciando classe jogo que preenche o vetor e distribui os navios
	Jogo jogo = new Jogo();
	Jogador jogador = new Jogador();
	Pontuacao pontos = Pontuacao.getInstance();

	/**
	 * Construtor da classe Tabuleiro que cria os elementos grficos da janela.
	 * @param nomeJogador Recebe o nome do jogador como parmetro e seta no objeto Jogador.
	 */
	public Tabuleiro(String nomeJogador){

		// Titulo da janela
		setTitle("Batalha Naval");
		// Define o tamanho da janela. Pode ser usado o janela.pack() para auto ajuste
		setSize(507, 415);
		// Centraliza a janela. Pode ser usado o janela.setLocation() para colocar onde quiser
		setLocationRelativeTo(null);
		// Configura o maximizar e fixa o tamanho da janela
		setResizable(false);
		// Configura o fechamento da janela
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		// Configura o Container
		setContentPane(jContentPane);
		cp = getContentPane();
		cp.setLayout(null);

		// Configura o Grid de Botes
		grid.setBounds(3, 58, 497, 325);
		grid.setLayout(new GridLayout(10, 10, 2, 2));

		// Adiciona os Botes no Grid
		for (int linha = 0; linha < 10; linha++){
			for (int coluna = 0; coluna < 10; coluna++){
				Botoes[linha][coluna] = new JButton("");
				Botoes[linha][coluna].addActionListener(this);
				Botoes[linha][coluna].setFocusable(false);
				grid.add(Botoes[linha][coluna]);
			}
		}

		// Boto Novo Jogo
		novo.setBounds(7, 14, 96, 35);
		novo.setFocusable(false);
		novo.addActionListener(this);

		// Boto Voltar
		voltar.setBounds(398, 14, 96, 35);
		voltar.setFocusable(false);
		voltar.addActionListener(this);

		// Label Navios Restantes
		naviosRestantes.setFont(new Font("Roboto", Font.PLAIN, 15));
		naviosRestantes.setBounds(120, 10, 120, 18);

		// Label Tiros Restantes
		tirosRestantes.setFont(new Font("Roboto", Font.PLAIN, 15));
		tirosRestantes.setBounds(272, 10, 118, 18);

		// Contador Navios Restantes
		contNavios.setFont(new Font("Roboto", Font.BOLD, 18));
		contNavios.setBounds(170, 28, 20, 26);
		contNavios.setText("" + contadorNavio);

		// Contaddor Tiros Restantes
		contTiros.setFont(new Font("Roboto", Font.BOLD, 18));
		contTiros.setBounds(320, 28, 20, 26);
		contTiros.setText("" + contadorTiro);

		// Adicionando os elementos no Container
		cp.add(grid);
		cp.add(novo);
		cp.add(voltar);
		cp.add(naviosRestantes);
		cp.add(tirosRestantes);
		cp.add(contNavios);
		cp.add(contTiros);

		// Chamando o mtodo que inicia o jogo e distribui os navios
		jogo.iniciaJogo(vetor);
		// Passando o nome do jogador que est jogando para o objeto Jogador
		jogador.setNome(nomeJogador);
	}
	
	/**
	 * Mtodo que configura as aes do bots da interface grfica.
	 * <p> O boto Voltar fecha a janela do tabuleiro e invoca o mtodo salvaLista, que persiste
	 * a lista de jogadores no arquivo.
	 * <p> Os botes do tabuleiro disparam contadores de tiros e navios restantes, alm de mostrar 
	 * ao usurio quando acertou um navio ou quando acertou apenas gua. Tambm incrementam a 
	 * pontuao do jogador, que  mostrada apenas no fim do jogo.
	 * <p> O fim do jogo  um evento disparado quando os 30 tiros do jogador so efetuados, ento uma
	 * mensagem  mostrada na tela, a pontuao do jogador  adicionada no objeto Jogador, o objeto 
	 * adicionado numa lista e um novo jogo  iniciado automaticamente.
	 * <p> O boto Novo Jogo cria um novo tabuleiro ignorando o jogador e a pontuao anterior e informa
	 * ao usurio que um novo jogo foi iniciado com uma mensagem na tela.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		// Funo do boto Voltar
		if (e.getSource() == voltar){
			this.dispose();
			// Quando voltar para tela inicial, a lista com os jogadores  gravada no arquivo
			pontos.salvaLista();
		}

		// Funo dos Botes do Tabuleiro
		for (int linha = 0; linha < 10; linha++){
			for (int coluna = 0; coluna < 10; coluna++) {

				// Quando um Boto  clicado
				if (e.getSource() == Botoes[linha][coluna]) {

					// Decrementando o nmero de tiros restantes
					--contadorTiro;
					contTiros.setText("" + contadorTiro);

					// Se for 0, acerta a gua e mostra vazio
					if (vetor[linha][coluna] == 0) {
						Botoes[linha][coluna].setEnabled(false);
					}
					// Se no for 0, mostra a imagem de navio destrudo
					else if (vetor[linha][coluna] != 0) {

						// Configura a imagem de navio destrudo
						Botoes[linha][coluna]
								.setIcon(new ImageIcon(Tabuleiro.class.getResource("/telas/explosao.png")));

						// Configura a imagem para o Boto desabilitado
						Botoes[linha][coluna]
								.setDisabledIcon(new ImageIcon(Tabuleiro.class.getResource("/telas/explosao.png")));

						// Desabilita o boto j clicado para no continuar
						// pontuando
						Botoes[linha][coluna].setEnabled(false);

						// Decrementa o contador de navios restantes e
						// incrementa a pontuao
						contNavios.setText("" + --contadorNavio);
						pontuacao++;
					}

					// Finaliza o jogo depois de 30 tiros
					if (contadorTiro == 0) {
						// Mostra mensagem de fim de jogo
						JOptionPane.showMessageDialog(this, "Fim de Jogo. Sua pontuao: " + pontuacao, "Fim de Jogo",
								JOptionPane.INFORMATION_MESSAGE);

						// Grava a pontuao no objeto Jogador
						jogador.setPontuacao(pontuacao);

						// Salva jogador no Arraylist
						pontos.adicionaJogador(jogador);

						// Reinicia o jogo
						this.dispose();
						// Cria um novo tabuleiro e seta a visibilidade
						Tabuleiro tabuleiro = new Tabuleiro(jogador.getNome());
						tabuleiro.setVisible(true);
					}
				}
			}
		}

		// Funo do Boto Novo Jogo
		if (e.getSource() == novo) {
			// Fecha a janela
			this.dispose();

			// Cria um novo tabuleiro e seta a visibilidade
			Tabuleiro tabuleiro = new Tabuleiro(jogador.getNome());
			tabuleiro.setVisible(true);

			// Mostra mensagem de Jogo Reiniciado
			JOptionPane.showMessageDialog(this, "Jogo reiniciado!", "Novo Jogo", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
