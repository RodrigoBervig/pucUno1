import java.util.Random;
import java.io.Serializable;

/**
 * Implementa um deck de cartas.
 */
public class Deck implements Serializable
{
	private Card[] deck;
	private int numCards;
	    /**
         * O construtor cria um novo deck
         * Existem 4 cores: vermelho, azul, verde e amarelo
         * cada cor tem 2 cópias da mesma carta, exceto pelo 0 (aparece apenas um vez por cor)
         * Por exemplo: Verde tem duas cartas de numero 1, mas apenas uma de numero 0
         */
		public Deck() {
            deck = new Card[108];
            numCards = 0;
		}

		public void inicializa()
        {
            preenche();
            shuffle();
        }

		public void addToDeck(Card card)
        {
            this.deck[numCards] = card;
            numCards++;
        }

		private void preenche() {
            // cartas normais
            for (int cor = 1; cor <= 4; cor++)
            {
                addToDeck(new Card(0, cor));
                addToDeck(new Card(13, 0));
                addToDeck(new Card(14, 0));
                for (int numero = 1; numero <= 12; numero++)
                {
                    addToDeck(new Card(numero, cor));
                    addToDeck(new Card(numero, cor));
                }
            }
        }

		/** Checa o tamanho do deck, se for maior que zero, retorna false,
         *  se não, retorna true.
         */
		public boolean isEmpty() { //
		    return numCards==0;
		}

		/** Embaralha o deck*/
		public void shuffle(){
		    Random rd = new Random();
		    int i, j;

		    for (int k = 0; k < 1000; k++)
            {
                i = rd.nextInt(108);
                j = rd.nextInt(108);
                swap(i, j);
            }
		}

		private void swap (int i, int j)
        {
            Card aux = deck[i];
            deck[i] = deck[j];
            deck[j] = aux;
        }

        /**Recebe a carta mais alta de um baralho invertido*/
		public Card getTopCard()
        {
            if (numCards <= 0) return null;

            Card c = deck[numCards - 1];
            deck[numCards - 1] = null;
            numCards --;

            return c;
		}
		
		public Card peek() {
		    if (numCards <= 0) return null;
			return deck[numCards-1];
		}

		public String toString() {
			StringBuilder sb = new StringBuilder();

			for(Card c:this.deck)
            {
				sb.append(c);
			}

			return sb.toString();
		}
		
		
		
			
		
		
		
		
		
		
}
