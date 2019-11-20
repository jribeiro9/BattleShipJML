package battleship;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Destroyer one = new Destroyer(1,5);
		System.out.println(one.getQtdDeNavios());
		System.out.println(one.getTamanhoNavio());
		System.out.println(one.getNomeNavio());
	}

}
