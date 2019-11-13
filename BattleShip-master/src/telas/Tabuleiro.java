package telas;
/**
 * Classe que implementa o Tabuleiro do jogo em uma interface gr�fica.
 * <p> A classe extende o utilit�rio de interface swing JFrame e implementa a interface ActionListener,
 * que configura as a��es de intera��o com o usu�rio.
 * <p> Instancia os objetos das classes Jogo, para iniciar o jogo e distribuir os navios no tabuleiro,
 * da classe Jogador, para setar no objeto o nome recebido por par�metro, e da classe Pontuacao que 
 * � verificada com o padr�o Singleton, e quando instanciada, seta as pontua��es do jogador para cada
 * novo jogo realizado.
 * @author Rodrigo Lima
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import battleship.Jogador;
import battleship.Jogo;
import battleship.Pontuacao;

public class Tabuleiro extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	// Adicionando os Pain�is
	JPanel grid = new JPanel();
	JPanel jContentPane = new JPanel();
	Container cp;

	// Adicionando os Bot�es
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

	// Vetor que fica por tr�s dos Bot�es e guarda �gua ou navios
	int vetor[][] = new int[10][10];
	int pontuacao = 0;
	String nomeJogador;

	// Instanciando classe jogo que preenche o vetor e distribui os navios
	Jogo jogo = new Jogo();
	Jogador jogador = new Jogador();
	Pontuacao pontos = Pontuacao.getInstance();

	/**
	 * Construtor da classe Tabuleiro que cria os elementos gr�ficos da janela.
	 * @param nomeJogador Recebe o nome do jogador como par�metro e seta no objeto Jogador.
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

		// Configura o Grid de Bot�es
		grid.setBounds(3, 58, 497, 325);
		grid.setLayout(new GridLayout(10, 10, 2, 2));

		// Adiciona os Bot�es no Grid
		for (int linha = 0; linha < 10; linha++){
			for (int coluna = 0; coluna < 10; coluna++){
				Botoes[linha][coluna] = new JButton("");
				Botoes[linha][coluna].addActionListener(this);
				Botoes[linha][coluna].setFocusable(false);
				grid.add(Botoes[linha][coluna]);
			}
		}

		// Bot�o Novo Jogo
		novo.setBounds(7, 14, 96, 35);
		novo.setFocusable(false);
		novo.addActionListener(this);

		// Bot�o Voltar
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

		// Chamando o m�todo que inicia o jogo e distribui os navios
		jogo.iniciaJogo(vetor);
		// Passando o nome do jogador que est� jogando para o objeto Jogador
		jogador.setNome(nomeJogador);
	}
	
	/**
	 * M�todo que configura as a��es do bot�es da interface gr�fica.
	 * <p> O bot�o Voltar fecha a janela do tabuleiro e invoca o m�todo salvaLista, que persiste
	 * a lista de jogadores no arquivo.
	 * <p> Os bot�es do tabuleiro disparam contadores de tiros e navios restantes, al�m de mostrar 
	 * ao usu�rio quando acertou um navio ou quando acertou apenas �gua. Tamb�m incrementam a 
	 * pontua��o do jogador, que � mostrada apenas no fim do jogo.
	 * <p> O fim do jogo � um evento disparado quando os 30 tiros do jogador s�o efetuados, ent�o uma
	 * mensagem � mostrada na tela, a pontua��o do jogador � adicionada no objeto Jogador, o objeto �
	 * adicionado numa lista e um novo jogo � iniciado automaticamente.
	 * <p> O bot�o Novo Jogo cria um novo tabuleiro ignorando o jogador e a pontua��o anterior e informa
	 * ao usu�rio que um novo jogo foi iniciado com uma mensagem na tela.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		// Fun��o do bot�o Voltar
		if (e.getSource() == voltar){
			this.dispose();
			// Quando voltar para tela inicial, a lista com os jogadores � gravada no arquivo
			pontos.salvaLista();
		}

		// Fun��o dos Bot�es do Tabuleiro
		for (int linha = 0; linha < 10; linha++){
			for (int coluna = 0; coluna < 10; coluna++) {

				// Quando um Bot�o � clicado
				if (e.getSource() == Botoes[linha][coluna]) {

					// Decrementando o n�mero de tiros restantes
					--contadorTiro;
					contTiros.setText("" + contadorTiro);

					// Se for 0, acerta a �gua e mostra vazio
					if (vetor[linha][coluna] == 0) {
						Botoes[linha][coluna].setEnabled(false);
					}
					// Se n�o for 0, mostra a imagem de navio destru�do
					else if (vetor[linha][coluna] != 0) {

						// Configura a imagem de navio destru�do
						Botoes[linha][coluna]
								.setIcon(new ImageIcon(Tabuleiro.class.getResource("/telas/explosao.png")));

						// Configura a imagem para o Bot�o desabilitado
						Botoes[linha][coluna]
								.setDisabledIcon(new ImageIcon(Tabuleiro.class.getResource("/telas/explosao.png")));

						// Desabilita o bot�o j� clicado para n�o continuar
						// pontuando
						Botoes[linha][coluna].setEnabled(false);

						// Decrementa o contador de navios restantes e
						// incrementa a pontua��o
						contNavios.setText("" + --contadorNavio);
						pontuacao++;
					}

					// Finaliza o jogo depois de 30 tiros
					if (contadorTiro == 0) {
						// Mostra mensagem de fim de jogo
						JOptionPane.showMessageDialog(this, "Fim de Jogo. Sua pontua��o: " + pontuacao, "Fim de Jogo",
								JOptionPane.INFORMATION_MESSAGE);

						// Grava a pontua��o no objeto Jogador
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

		// Fun��o do Bot�o Novo Jogo
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
