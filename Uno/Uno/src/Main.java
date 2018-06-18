import java.io.IOException;

/**
 * Felipe Bach
 * 10/06/2018
 * Jogo Uno Simples, para dois jogadores
 */
public class Main
{
    /**
     * Main apenas roda o jogo chamando o método game.
     * Metodo game esta na classe Uno.
     */
	public static void main(String[] args) throws IOException, InterruptedException
	{
		Uno game = new Uno();
		game.game();
	}
}
