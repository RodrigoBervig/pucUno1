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
		public Deck(ArrayList<Card> c){ //construtor overloaded
			/*Em caso de o deck atual ficar vazio, todas as cartas jogadas são coletadas e se tornam o novo deck;*/
			deck = c;
		}

        public void preenche(ArrayList<Card> deck){
            String[] cores = {"vermelho", "azul", "verde", "amarelo"};
            int[] numeros = {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,0};
            int[] numeroEspeciais = {2,2,4,4};

            for(String cor: cores){ //Igual a for(int i = 0; i<cores.length; i++)
                for(int numero: numeros){
                    deck.add(new Card(numero, cor));
                }
         }
            for(int especial: numeroEspeciais){
                deck.add(new Card(especial));
            }
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
