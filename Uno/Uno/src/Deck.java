import java.util.Random;

/**
 * Implementa um deck de cartas.
 */
public class Deck
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
            for (int i = 1; i <= 4; i++)
            {
                addToDeck(new Card(0, i, false));
                for (int j = 1; j <= 9; j++)
                {
                    addToDeck(new Card(j, i, false));
                    addToDeck(new Card(j, i, false));
                }
            }

            // cartas especiais com cores
		    for (int i = 0; i <= 4; i++) {
                for (int j = 0; j <= 3; j++) {
                    addToDeck(new Card(j, i, true));
                    addToDeck(new Card(j, i, true));
                }
            }

            //cartas especiais sem cores
            for (int i = 0; i < 4; i++) addToDeck(new Card(3, 0,true));
            for (int i = 0; i < 4; i++) addToDeck(new Card(4, 0,true));
        }

		/** Checa o tamanho do deck, se for maior que zero, retorna false,
         *  se não, retorna true.
         */
		public boolean isEmpty() { //
		    return numCards>0;
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
