package battleship;
/**
 * Classe de teste que implementa os testes dos m�todos da classe Jogo.
 * @author Rodrigo Lima
 */

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class JogoTest {
	
	Jogo jogo;
	int[][] vetor = new int[10][10];	
	
	/**
	 * M�todo de configura��o que lan�a exce��o para poss�veis erros e instancia a classe Jogo.
	 * @throws Exception Lan�a exce��o de erro durante a execu��o dos testes.
	 */
	@Before
	public void setUp() throws Exception{
		jogo = new Jogo();
	}
	
	/**
	 * M�todo de teste que testa se o retorno do m�todo cabeNavio � falso.
	 * <p> Foi passado como par�metro valores que estouram o limite da matriz, retornando falso.
	 */
	@Test
	public void testCabeNavioFalse(){
		for (int i = 0; i < 10; i++){
			for (int j = 0; j < 10; j++){
				vetor[i][j] = 0;
			}
		}
		assertEquals(false, jogo.cabeNavio(3, 7, 1, 5, vetor));
	}
	
	/**
	 * M�todo de teste que testa se o retorno do m�todo cabeNavio � verdadeiro.
	 * <p> Nesse caso � testado se o funcionamento est� consistente, passando um vetor vazio e as posi��es
	 * dentro do limites da matriz.
	 */
	@Test
	public void testCabeNavioTrue(){
		for (int i = 0; i < 10; i++){
			for (int j = 0; j < 10; j++){
				vetor[i][j] = 0;
			}
		}
		assertEquals(true, jogo.cabeNavio(3, 2, 1, 3, vetor));
		
	}
}
