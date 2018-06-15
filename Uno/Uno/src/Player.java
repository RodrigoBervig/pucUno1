import java.util.ArrayList;
import java.util.Scanner;


public class Player
{
	private ArrayList<Card> playercards; 
	private String nome; //nome do jogador
	
	public Player(String nome) {
		/*
		 * cria um array list que armazena as cartas do jogador		
		 * atribui nome ao jogador 
		 */
		
		//objeto jogador é criado na classe Uno
		
		playercards = new ArrayList<Card>();
		this.nome = nome;
		
	}
	
	public int numberOfCards() {
		/*
		 * retorna o numero de cartas que o jogador possui na mão
		 */
		return playercards.size();
	}
	
	public ArrayList<Card> PlayerCards(){
		/*
		 * Retorna todas as cartas que o jogador possui na mão como um ArrayList		 
		 * Isso é usado para chegar se o jogador tem alguma carta valida para jogar		 
		 */
		
		return playercards;
	}
	
	
	public void pickCards(Card c) {
		/*
		 * 
		 */
		playercards.add(c);
		
	}
	
	public Card throwCard(int c) {
		/*
		 * O jogador joga uma carta de sua mão que esta na posição 'c'. c é um valor integer e é passado como parametro		 
		 */
		
		
		return playercards.remove(c);
	}
	
	public void sayUno() {
		/*
		 * jogador diz Uno quando tiver apenas uma carta na mão 
		 */
		Scanner s = new Scanner(System.in);
		
		if (playercards.size()==1)
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
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < playercards.size(); i++)
			sb.append(" -----  ");
		sb.append("\n");

		for (int i = 0; i < playercards.size(); i++)
			sb.append("| ").append(this.playercards.get(i).getColorString()).append(" | ");
		sb.append("\n");

		for (int i = 0; i < playercards.size(); i++)
			sb.append("| ").append(this.playercards.get(i).getValueString()).append(" | ");
		sb.append("\n");

		for (int i = 0; i < playercards.size(); i++)
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

		for (int i = 0; i < playercards.size(); i++)
			sb.append(" -----  ");
		sb.append("\n");

		for (int i = 0; i < playercards.size(); i++)
			sb.append("|     | ");
		sb.append("\n");

		for (int i = 0; i < playercards.size(); i++)
			sb.append("|     | ");
		sb.append("\n");

		for (int i = 0; i < playercards.size(); i++)
			sb.append(" -----  ");
		sb.append("\n");

		System.out.print(sb.toString());
	}

	/**
	 * verifica se o jogador venceu ou não
	 */
	public boolean hasWon() {

		return playercards.size()==0;

	}



	/**
	 * Representação do jogador em texto
	 */
	public String toString() {

		return this.nome;
	}
	
	
	
	
}
