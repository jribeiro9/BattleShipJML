package telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import battleship.Jogador;
import battleship.ListaInvalidaException;
import battleship.Pontuacao;
import java.awt.Font;
import java.awt.TextArea;

public class Ranking extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	// Criando painel para receber elementos
	private JPanel contentPane = new JPanel();
	// Criao do boto voltar
	private JButton voltar = new JButton("Voltar");
	// Criao da label Ttulo
	private JLabel labelTitulo = new JLabel("Ranking Pontua\u00E7\u00E3o");
	// JScrollPane texto = new JScrollPane(caixaDeTexto);
	TextArea textArea = new TextArea();
	
	/**
	 * Construtor da classe Ranking que cria os elementos grficos da janela.
	 */
	public Ranking() {
		
		// Configura o nome da Janela
		setTitle("Ranking");
		// Retira a opo de redimensionar a janela		
		setResizable(false);
		// Configura o fechamento da janela
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// Configura o tamanho da janela
		setBounds(100, 100, 507, 409);
		// Centralizando a tela quando iniciada
		setLocationRelativeTo(null);
		// Retira o layout do painel
		contentPane.setLayout(null);
		// Seta o painel como painel do frame
		setContentPane(contentPane);
		
		// Boto voltar
		voltar.setBounds(396, 332, 95, 31);
		voltar.addActionListener(this);
		contentPane.add(voltar);
		
		// Label ttulo
		labelTitulo.setFont(new Font("Verdana", Font.BOLD, 16));
		labelTitulo.setBounds(172, 11, 170, 29);
		contentPane.add(labelTitulo);		
		
		// Configurando o tamnho da rea de texto e adicionando no painel
		textArea.setBounds(10, 46, 481, 269);
		contentPane.add(textArea);
		
		// Criao da lista com o ranking, buscando direto do arquivo
		ArrayList<Jogador> jogadores = new Pontuacao().getJogadores();
		
		try {
			verificaLista(jogadores);
			
			// Ordenando os jogadores por maior pontuao com o metdo compareTo()
			Collections.sort(jogadores);
			
			// Criao de uma StringBuilder para concatenar todos os jogadores em uma String
			StringBuilder ranking = new StringBuilder();
			
			// Montagem da StringBuilder
			for (Jogador jog : jogadores){
				ranking.append(jog.getNome() + " 		" + jog.getPontuacao() + "\n");		
			}
			
			// Criao da String final que recebe o raning completo e mostra na TextArea
			String rankingFinal = ranking.toString();
			textArea.setText(rankingFinal);	
			
		} catch (ListaInvalidaException e){
			System.out.println(e.getMessage());
		}			
	}
	
	/**
	 * Mtodo que verifica se a lista est vazia ou nula e lana exceo personalizada.
	 * 
	 */
	public void verificaLista(ArrayList<Jogador> jogadores) throws ListaInvalidaException{
		if (jogadores == null || jogadores.isEmpty()){
			throw new ListaInvalidaException("O arquivo est vazio!");
		}
	}
	
	/**
	 * Mtodo que configura as aes dos botes da interface grfica.
	 * <p> O boto Voltar fecha a janela do ranking e retorna para a Tela Inicial
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == voltar){
			this.dispose();
		}
	}
}