import java.util.ArrayList;
import java.util.Scanner;


public class Player {

	
	
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
		
		if (playercards.size()==1){
			
			System.out.println("Uno");
			System.out.println("Pressione Enter...");
			s.nextLine();
		}
	}
	
	
	public void showCards() {
		/*
		 * Isso é uma representação gráfica de uma carta		 
		 * apenas para fazer as cartas ficarem um pouco mais parecidas com cartas hahaha		 
		 * usado no método showboard() na classe Uno 
		 */
		
		String[] card = {" ----- ","|     |","|     |"," ----- "};
		String c = "";
		
		
		for(int i=0;i<card.length;i++) {
				
			for(int j=0;j<playercards.size();j++) {
					
				if(!playercards.get(j).isSpecial()) {
					if(i==1) {
						
						c = c +"| "+playercards.get(j).getColor()+" |"+" ";
						
					}
					
					else if(i==2) {
						
						c = c + "|  "+playercards.get(j).getValue()+"  |"+" ";
					}
					
					else {
						c = c + card[i]+" "; 
					}
					
					}
				
				else if(playercards.get(j).isSpecial()) {
					
					if(i==1) {
						
						c = c +"| "+"+"+playercards.get(j).getValue()+"  |"+" ";
						
					}
					else {
						c = c + card[i]+" ";
					}
					
				}
				
					}
				
				c +="\n";
				
			}
				
		
		
		
		System.out.print(c);
	}
	
	public void hideCards() {
		
		/*
		 * esconde cartas do jogador		 
		 * usado no método showboard() na classe Uno 
		 */
		
		String[] card = {" ----- ","|     |","|     |"," ----- "};
		String c = "";
		
		
		for(int i=0;i<card.length;i++) {
				
			for(int j=0;j<playercards.size();j++) {
		
				c = c + card[i]+" ";
		
			}
		c+="\n";
		}
		
		System.out.print(c);
	}
	
	public boolean hasWon() {
		/*
		 * verifica se o jogador venceu ou não
		 */
		if(playercards.size()==0) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		/*
		 * representação do jogador em texto
		 */
		return this.nome;
	}
	
	
	
	
}
