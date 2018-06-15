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
            deck = new ArrayList<>();
			preenche(deck);
		}

		public void preenche(ArrayList<Card> deck) {
            // cartas normais
            for (int i = 1; i <= 4; i++) {
                    deck.add(new Card(0, i, false));
                for (int j = 1; j <= 9; j++) {
                    deck.add(new Card(j, i, false));
                    deck.add(new Card(j, i, false));
                }
            }

            // cartas especiais com cores
		    for (int i = 0; i <= 4; i++) {
                for (int j = 0; j <= 3; j++) {
                    deck.add(new Card(j, i, true));
                    deck.add(new Card(j, i, true));
                }
            }

            //cartas especiais sem cores
            for (int i = 0; i < 4; i++) deck.add(new Card(3, 0,true));
            for (int i = 0; i < 4; i++) deck.add(new Card(4, 0,true));
        }



		
		public Deck(ArrayList<Card> c){ //construtor overloaded
			/*Em caso de o deck atual ficar vazio, todas as cartas jogadas são coletadas e se tornam o novo deck;*/
			deck = c;
		}

		/** Checa o tamanho do deck, se for maior que zero, retorna false, se não, retorna true.*/
		public boolean isEmpty() { //
		    return (deck.size()>0);
		}

		/** Embaralha o deck*/
		public void shuffle(){
		    Collections.shuffle(deck);
		}
        /**Recebe a carta mais alta de um baralho invertido*/
		public Card getTopCard(){
			return deck.remove(deck.size()-1);
		}
		
		public Card peek() {
			return deck.get(deck.size()-1);
		}
		
		
		public String toString() {
			StringBuilder sb = new StringBuilder();
			String deck="";
			
			for(Card c:this.deck){ //igual a for(int i = 0; i<deck.length; i++)
				sb.append(deck).append(c);
			    //deck = deck +c+ " ";
			}

			return sb.toString();
			
		}
		
		
		
			
		
		
		
		
		
		
}
