package battleship;

import java.io.Serializable;

public class Jogador implements Serializable, Comparable<Jogador> {
	
	private static final long serialVersionUID = 1L;
	
	private /*@ spec_public @*/ String nome;
	private /*@ spec_public @*/ int pontuacao;
	
	public /*@ pure @*/ String getNome() {
		return nome;
	}
	
	/*@ assignable nome;
	@	ensures this.nome.equals(nome); 
	@*/
	public void setNome(String nome) {
		this.nome = nome;
	}
	public /*@ pure @*/ int getPontuacao() {
		return pontuacao;
	}
	/*@ assignable pontuacao;
	@	ensures this.pontuacao == pontuacao;
	@	ensures this.pontuacao >= 0; 
	@*/
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	@Override
	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append("Nome: " + this.nome + " Pontuacao: " + this.pontuacao);
		return str.toString();
	}

	@Override
	public int compareTo(Jogador jog) {
		int compararPontos = ((Jogador) jog).getPontuacao();		
		return compararPontos - this.pontuacao;
	}
}