package battleship;



public class Destroyer{
		
		private /*@ spec_public @*/ int qtdDeNavios;
		private /*@ spec_public @*/ int tamanhoNavio;
		private /*@ spec_public @*/ String nomeNavio;
		//@ public invariant 0 <= qtdDeNavios && 0 <= tamanhoNavio;
		
		/*@
		@	requires q == 1; 
		@ 	requires t == 5;
		@ 	ensures qtdDeNavios == q;
		@ 	ensures tamanhoNavio == t;
		@	ensures nomeNavio == "Destroyer"; 
		@*/
		public Destroyer(int q, int t){
			this.qtdDeNavios = q;
			this.tamanhoNavio = t;
			this.nomeNavio = "Destroyer";
		}

		public int getQtdDeNavios() {
			return qtdDeNavios;
		}

		public int getTamanhoNavio() {
			return tamanhoNavio;
		}

		public String getNomeNavio(){
			return nomeNavio;
		}
	}
