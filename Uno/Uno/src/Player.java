import java.util.Scanner;

public class Player
{
	private Card[] playercards;
	private int numCards;
	private String name; //nome do jogador

    /**
     * cria um array list que armazena as cartas do jogador
     * atribui nome ao jogador.
     * Esse objeto é criado na classe UNO.
     */
	public Player(String nome) {
		playercards = new Card[108];
		int numCards = 0;
		this.name = nome;
	}

    /**
     * retorna o numero de cartas que o jogador possui na mão
     */
	public int getNumCards() {
		return numCards;
	}

	public boolean add (Card c)
    {
        if (numCards < 0 || c == null) return false;

        playercards[numCards] = c;
        numCards++;
        return true;
    }

    public Card remove (int i)
    {
        if (numCards < 0 || i < 0 || i >= numCards) return null;

        Card c = playercards[i];
        playercards[i] = null;

        for (int k = i; k < numCards - 1; k++)
        {
            playercards[k] = playercards[k+1];
        }

        numCards--;
        playercards[numCards] = null;

        return c;
    }

    /**
     * Retorna todas as cartas que o jogador possui na mão como um ArrayList
     * Isso é usado para chegar se o jogador tem alguma carta valida para jogar
     */
	public Card[] PlayerCards(){
		return playercards;
	}

	public void sayUno() {
		/*
		 * jogador diz Uno quando tiver apenas uma carta na mão 
		 */
		Scanner s = new Scanner(System.in);
		
		if (numCards==1)
		{
			System.out.println("Uno");
			System.out.println("Pressione Enter...");
			s.nextLine();
		}
	}

	/**
	  * Isso é uma representação gráfica de uma carta
	  * apenas para fazer as cartas ficarem um pouco mais parecidas com cartas hahaha
	  * usado no método showboard() na classe Uno
	  **/
	public void showCards() {
        System.out.println("player cards size: " + numCards);

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < numCards; i++)
			sb.append(" -----  ");
		sb.append("\n");

		for (int i = 0; i < numCards; i++) {
            sb.append("| ");
            sb.append(playercards[i].getColorString());
            sb.append(" | ");
        }
		sb.append("\n");

		for (int i = 0; i < numCards; i++)
			sb.append("| ").append(playercards[i].getValueString()).append(" | ");
		sb.append("\n");

		for (int i = 0; i < numCards; i++)
			sb.append(" -----  ");
		sb.append("\n");
		
		System.out.print(sb.toString());
	}

	/**
	  * esconde cartas do jogador
	  * usado no método showboard() na classe Uno
	  **/
	public void hideCards() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < numCards; i++)
			sb.append(" -----  ");
		sb.append("\n");

		for (int i = 0; i < numCards; i++)
			sb.append("|     | ");
		sb.append("\n");

		for (int i = 0; i < numCards; i++)
			sb.append("|     | ");
		sb.append("\n");

		for (int i = 0; i < numCards; i++)
			sb.append(" -----  ");
		sb.append("\n");

		System.out.print(sb.toString());
	}

	/**
	 * verifica se o jogador venceu ou não
	 */
	public boolean hasWon() {
		return numCards==0;
	}

	/**
	 * Representação do jogador em texto
	 */
	public String getName() {
		return this.name;
	}
	
	public Card cardAt(int i)
    {
        if (i < 0 || i >= numCards) return null;

        return playercards[i];
    }

    public boolean hasCardToPutAbove (Card current)
    {
        for (int i = 0; i < getNumCards(); i++)
        {
            if (playercards[i].canPutThisAbove(current)) return true;
        }
        return false;
    }
}
