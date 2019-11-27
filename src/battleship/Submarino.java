package battleship;

public class Submarino implements Navio{
	
	private /*@ spec_public @*/ int qtdDeNavios;
	private /*@ spec_public @*/ int tamanhoNavio;
	private /*@ spec_public @*/ String nomeNavio;
	//@ public invariant 0 <= qtdDeNavios && 0 <= tamanhoNavio;
	
	/*@
	@	requires q == 5; 
	@ 	requires t == 1;
	@ 	ensures qtdDeNavios == q;
	@ 	ensures tamanhoNavio == t;
	@	ensures nomeNavio == "Submarino"; 
	@*/
	public Submarino(int q, int t){
		this.qtdDeNavios = q;
		this.tamanhoNavio = t;
		this.nomeNavio = "Submarino";
	}
	/*@ also
	@ensures \result == 5;
	@*/
	@Override
	public /*@ pure @*/ int getQtdDeNavios() {
		return qtdDeNavios;
	}
	/*@ also
	@ensures \result == 1;
	@*/
	@Override
	public /*@ pure @*/ int getTamanhoNavio() {
		return tamanhoNavio;
	}
	/*@ also
	@ensures \result == "Submarino";
	@*/
	@Override
	public /*@ pure @*/ String getNomeNavio(){
		return nomeNavio;
	}
}