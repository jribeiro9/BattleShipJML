package battleship;
/**
 * Classe que implementa a embarca��o do tipo Submarino.
 * <p> O submarino ocupa apenas 1 bloco e existem 5 no tabuleiro.
 * 
 * <p> Apenas os m�todos Getters s�o implementados, j� que as vari�veis s�o definitivas.
 * 
 * @author Rodrigo Lima
 * @see Navio
 */

public class Submarino implements Navio{
	
	private int qtdDeNavios = 5;
	private int tamanhoNavio = 1;	
	private String nomeNavio = "Submarino";
	
	@Override
	public int getTamanhoNavio() {
		return tamanhoNavio;
	}
	@Override
	public int getQtdDeNavios() {
		return qtdDeNavios;
	}
	@Override
	public String getNomeNavio(){
		return nomeNavio;
	}
}
