package battleship;
/**
 * Classe que implementa as caracter�sticas do jogador da aplica��o.
 * <p> Implementa a interface Seriarizable que permite que o objeto jogador seja persistido em arquivo.
 * Implementa a interface Comparable que permite que uma lista com objetos do tipo jogador seja ordenada
 * pelos valores de suas vari�veis.
 * @param nome Nome do jogador ativo na aplica��o.
 * @param pontuacao Pontua��o do jogador no jogo.
 * @author Rodrigo Lima
 */

import java.io.Serializable;

public class Jogador implements Serializable, Comparable<Jogador> {
	
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private int pontuacao;
	
	/**
	 * M�todo que retorna o nome do jogador.
	 * @return String nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * M�todo que seta o nome do jogador.
	 * @param nome Recebe o nome informado na Tela Inicial.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * M�todo que retorna a pontua��o do jogador.
	 * @return int pontuacao
	 */
	public int getPontuacao() {
		return pontuacao;
	}
	/**
	 * M�todo que seta a pontua��o do jogador.
	 * @param pontuacao Recebe a pontua��o alcan�ada no jogo.
	 */
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	/**
	 * M�todo que monta uma String com os atributos do jogador e retorna a String anterior com a nova String.
	 * <p> O mesmo jogador pode fazer diversos jogos e com diversas pontua��es distintas, a classe StringBuilder
	 * permite que a cria��o de fluxos de String com o mesmo nome e com as pontua��es diferentes, uma 
	 * concatenada � outra para grava��o no arquivo com as pontua��es corretas.
	 */
	@Override
	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append("Nome: " + this.nome + " Pontuacao: " + this.pontuacao);
		return str.toString();
	}
	/**
	 * M�todo que ordena a lista com objetos do tipo Jogador de acordo com sua pontua��o.
	 * <p> A interface Comparable permite a ordena��o do objeto jogador, o m�todo compareTo implementa 
	 * essa ordena��o. O inteiro menos o valor a ser ordenado, retorna a lista de maneira descendente,
	 * para uma ordem ascendente a implementa��o deve ser valor menos o inteiro compararPontos.
	 */
	@Override
	public int compareTo(Jogador jog) {
		int compararPontos = ((Jogador) jog).getPontuacao();		
		return compararPontos - this.pontuacao;
	}
}
