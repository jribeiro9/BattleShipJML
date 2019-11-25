package battleship;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Destroyer one = new Destroyer(1,5);
		Navio two = new Submarino(5,1);
		
		System.out.println(one.getQtdDeNavios());
		System.out.println(one.getTamanhoNavio());
		System.out.println(one.getNomeNavio());
		System.out.println(two.getQtdDeNavios());
		System.out.println(two.getTamanhoNavio());
		System.out.println(two.getNomeNavio());

	}

}
