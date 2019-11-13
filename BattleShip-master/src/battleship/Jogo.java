package battleship;
/**
 * Classe que implementa m�todos para distribui��o das embarca��es e que inicia o Jogo.
 * @see Navio
 * @see Tabuleiro
 * @author Rodrigo Lima
 */

import java.util.ArrayList;
import java.util.Random;

public class Jogo {
	
	private Random generate = new Random();
	
	/**
	 * M�todo que distribui as embarca��es no tabuleiro.
	 * <p> A posi��o de cada navio no tabuleiro � gerada randomicamente e armazenada nas vari�veis 
	 * linha e coluna.
	 * <p> Uma lista com os navios � criada e todas as posi��es do tabuleiro s�o preenchidas com 0 (�gua).
	 * <p> A orienta��o dos navios � gerada randomicamente e o m�todo cabeNavio verifica se existe espa�o,
	 * se existir os navios s�o distribu�dos, se n�o, novas posi��es s�o geradas.
	 * @param vetor Vetor criado pela classe Tabuleiro que receber� os Navios ou �gua.
	 */
	public void iniciaJogo(int[][] vetor){		
		
		// Cria a posi��o do navio no tabuleiro
		int linha = generate.nextInt(10); // Linha
		int coluna = generate.nextInt(10); // Coluna
		boolean cabe = false;
		
		// Criando ArrayList com navios
		ArrayList<Navio> navios = new ArrayList<>();
		
		// Adicionando navios na Lista
		navios.add(new Destroyer());
		navios.add(new Fragata());
		navios.add(new Submarino());
		
		// Preenche o vetor com Zeros (0)
		for (int i = 0; i < 10; i++){
			for (int j = 0; j < 10; j++){
				vetor[i][j] = 0;
			}
		}
		
		for(int cont = 0; cont < navios.size(); cont++){
			int contador = 0;
			while(navios.get(cont).getQtdDeNavios() > contador) {				
				
				// Cria a orienta��o do Navio. 0 Vertical. 1 Horizontal
				int orientacao = generate.nextInt(2);
				
				// Verifica se o navio cabe na posi��o do tabuleiro criada
				cabe = cabeNavio(linha, coluna, orientacao, navios.get(cont).getTamanhoNavio(), vetor);
				
				// Se o Navio n�o couber, gera outra posi��o
				if(cabe == false){
					while(cabe == false){
						linha = generate.nextInt(10); // Linha
						coluna = generate.nextInt(10); // Coluna
						cabe = cabeNavio(linha, coluna, orientacao, navios.get(cont).getTamanhoNavio(), vetor);
					}
				}
				
				// Se o Navio couber, distribui os navios 
				if (orientacao == 0){
					for (int i = 0; i < navios.get(cont).getTamanhoNavio(); i++){
						vetor[linha][coluna] = 1;
						linha++;
					}
				}
				
				else if (orientacao == 1){
					for (int i = 0; i < navios.get(cont).getTamanhoNavio(); i++){
						vetor[linha][coluna] = 1;
						coluna++;
					}
				}
				contador++;
			}
		}
	}
	/**
	 * M�todo que verifica se o navio pode ser distribu�do na posi��o gerada randomicamente.
	 * <p> O tabuleiro � distribu�do como uma matriz, com linhas e colunas, os navios maiores precisam
	 * estar distribu�dos dentro dos limites do tabuleiro e em posi��es vazias, onde n�o existam navios
	 * j� distribu�dos.
	 * @return Retorna true se o navio couber na posi��o, se n�o, retorna false.
	 * @param linha Linha gerada randomicamente.
	 * @param coluna Coluna gerada randomicamente.
	 * @param orientacao Orienta��o do navio.
	 * @param tamanho Tamanho de blocos que o navio ocupa.
	 * @param vetor Vetor com as posi��es que podem ou n�o conter os navios.
	 * @return Retorna true se o navio couber na posi��o, se n�o retorna false.
	 */
	public boolean cabeNavio(int linha, int coluna, int orientacao, int tamanho, int vetor[][]){
		// Se a orienta��o for Vertical, trava a coluna e incrementa a linha
		if (orientacao == 0){
			if (linha > (9 - tamanho)){
				return false;
			}
			for (int row = 0; row < tamanho; row++){
				if (vetor[linha][coluna] == 0){
					linha++;
				}
				else {
					return false;
				}
			}
			return true;
		}
		
		// Se a orienta��o for Horizontal, trava a linha e incrementa a coluna
		if (orientacao == 1){
			if (coluna > (9 - tamanho)){
				return false;
			}
			for (int col = 0; col < tamanho; col++){
				if (vetor[linha][coluna] == 0){
					coluna++;
				}
				else {
					return false;
				}
			}
			return true;
		}
		return false;
	}
}
