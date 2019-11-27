package battleship;

public class Fragata implements Navio{
	
	private /*@ spec_public @*/ int qtdDeNavios;
	private /*@ spec_public @*/ int tamanhoNavio;
	private /*@ spec_public @*/ String nomeNavio;
	//@ public invariant 0 <= qtdDeNavios && 0 <= tamanhoNavio;
	
	/*@
	@	requires q == 3; 
	@ 	requires t == 3;
	@ 	ensures qtdDeNavios == q;
	@ 	ensures tamanhoNavio == t;
	@	ensures nomeNavio == "Fragata"; 
	@*/
	public Fragata(int q, int t){
		this.qtdDeNavios = q;
		this.tamanhoNavio = t;
		this.nomeNavio = "Fragata";
	}
	/*@ also
	@ensures \result == 3;
	@*/
	@Override
	public /*@ pure @*/ int getTamanhoNavio() {
		return tamanhoNavio;
	}
	/*@ also
	@ensures \result == 3;
	@*/
	@Override
	public /*@ pure @*/ int getQtdDeNavios() {
		return qtdDeNavios;
	}
	/*@ also
	@ensures \result == "Fragata";
	@*/
	@Override
	public /*@ pure @*/ String getNomeNavio(){
		return nomeNavio;
	}
}
