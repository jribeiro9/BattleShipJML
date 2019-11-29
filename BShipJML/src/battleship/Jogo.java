package battleship;

import java.util.ArrayList;
import java.util.Random;

public class Jogo {
	

	private /*@ spec_public @*/ Random generate = new Random();
	private /*@ spec_public @*/ int linha = 0;
	private /*@ spec_public @*/ int coluna = 0;
	
	//@ public invariant linha >= 0;
	//@ public invariant coluna >= 0;
	
	//@ initially linha == 0;
	//@ initially coluna == 0;
	
	/*@ requires vetor.length > 0;
	 @ assignable linha, coluna, vetor;
	 @ ensures \old(vetor.length) <= vetor.length;
	 @ ensures (\forall int i; i>=0 && i < vetor.length; 
	 @			(\forall int j; j>=0 && j < vetor[i].length; 
	 @ 			vetor[i][j] == 0 || vetor[i][j] == 1));
	 @*/
	public void iniciaJogo(int[][] vetor){		
		
		// Cria a posi��o do navio no tabuleiro
		this.linha = generate.nextInt(10); // Linha
		this.coluna = generate.nextInt(10); // Coluna
		boolean cabe = false;
		
		// Criando ArrayList com navios
		ArrayList<Navio> navios = new ArrayList<>();
		
		// Adicionando navios na Lista
		navios.add(new Destroyer(1,5));
		navios.add(new Fragata(3,3));
		navios.add(new Submarino(5,1));
		
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

	/*@ requires linha >=0; 
	@	requires coluna >=0; 
	@	requires orientacao >=0;
	@	requires tamanho >=0;
	@	requires vetor.length >0;
	@ 	ensures \result == true || \result == false;
	@*/
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