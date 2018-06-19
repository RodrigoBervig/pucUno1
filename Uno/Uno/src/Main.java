import java.io.IOException;
import java.io.Serializable;

/**
 * Felipe Bach
 * 10/06/2018
 * Jogo Uno Simples, para dois jogadores
 */
public class Main implements Serializable
{
    /**
     * Main apenas roda o jogo chamando o método game.
     * Metodo game esta na classe Uno.
     */
	public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException
	{
		Uno game = new Uno(args);
		game.game();
	}
}
