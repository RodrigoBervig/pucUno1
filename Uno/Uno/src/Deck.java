import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	private ArrayList<Card> deck;
	
		public Deck() {
			
			/*
			 * O construtor cria um novo deck 			
			 * Existem 4 cores: vermelho, azul, verde e amarelo			 
			 * cada cor tem 2 cópias da mesma carta, exceto pelo 0 (aparece apenas um vez por cor)			 
			 * Por exemplo: Verde tem duas cartas de numero 1, mas apenas uma de numero 0			 
			 */
			
			
			deck = new ArrayList<Card>();
			String[] cores = {"vermelho","azul","verde","amarelo"};
			int[] nums = {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,0}; //cartas normais
			int[] specialnums = {2,2,4,4}; //Cartas especiais +2, +2, +4 e +4
			
			
			for(String c:cores) { //adicionando cartas normais ao deck
				for(int i:nums) {
					deck.add(new Card(i,c)); //adicionando novas cartas ao deck
				}
			}
			
			
			for(int i:specialnums) { //Adicionando cartas especiais ao deck
				deck.add(new Card(i));
			}
			
			
			
		}
		
		
		public Deck(ArrayList<Card> c) { //construtor overloaded
			/*
			 * Em caso de o deck atual ficar vazio, todas as cartas jogadas são coletadas e se tornam o novo dedck; 			 
			 * 
			 */
			deck = c;
		}
	
			
		public boolean isEmpty() { //
			/* Checa o tamanho dodeck, se for maior que zero, retorna false, se não, retorna true;			 
			 */
			
			if(deck.size()>0) {
				return false;
			}
			return true;
		}
		
		public void shuffle() {
			
			/*
			 *  Embaralha o deck
			 */
			
			Collections.shuffle(deck);
					
		}
		
		public Card getTopCard() {
			/* Recebe a carta mais alte de um baralho invertido
			 
			 */
			return deck.remove(deck.size()-1);
		}
		
		public Card peek() {
			
			return deck.get(deck.size()-1);
		}
		
		
		public String toString() {
			
			String deck="";
			
			for(Card c:this.deck) {
				
				deck = deck +c+ " ";
			}
			
			return deck;
			
		}
		
		
		
			
		
		
		
		
		
		
}
