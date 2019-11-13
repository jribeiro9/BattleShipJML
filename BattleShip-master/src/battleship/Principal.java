package battleship;
/**
 * Classe Prinicpal da aplica��o, cont�m o m�todo main e inicializa a Tela Inicial
 * <p> O m�todo <b>run</> cria uma Thread que inicializa a tela inicial e configura
 *  a visibilidade do frame.
 *  @see TelaInicial
 *  @author Rodrigo Lima
 */
import javax.swing.SwingUtilities;
import telas.TelaInicial;

public class Principal {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				TelaInicial telaInicial = new TelaInicial();
				telaInicial.setVisible(true);
			}
		});		
	}

}
