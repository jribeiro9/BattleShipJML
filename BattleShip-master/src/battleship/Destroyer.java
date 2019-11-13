package battleship;
/**
 * Classe que implementa a embarca��o do tipo Destroyer.
 * <p> O Destroyer ocupa 5 blocos e s� existe 1 no tabuleiro.
 * 
 * <p> Apenas os m�todos Getters s�o implementados, j� que as vari�veis s�o definitivas.
 *
 * @author Rodrigo Lima
 * @see Navio
 */
public class Destroyer implements Navio {
	
	private int qtdDeNavios = 1;
	private int tamanhoNavio = 5;
	private String nomeNavio = "Destroyer";
	
	@Override
	public int getQtdDeNavios() {
		return qtdDeNavios;
	}
	@Override
	public int getTamanhoNavio() {
		return tamanhoNavio;
	}
	@Override
	public String getNomeNavio(){
		return nomeNavio;
	}
}
