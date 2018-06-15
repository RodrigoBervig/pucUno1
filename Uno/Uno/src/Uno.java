import java.util.Scanner;

public class Uno
{
	private Card current; //a carta atual ou carta anterior do jogador ou carta inicial
	private Deck deck; // o deck do jogo
	private Deck cardpile; //quando os jogadores jogam uma carta, ela é empilhada aqui, também, cria um novo deck quando o deck atual estiver vazio
	private int penalty; // quando cartas especiais são acumuladas  a penalidade acumula, se um jogador não tiver como counterar a carta especial atual, o jogador é penalizado
	private Scanner choice;
	private Player p1, p2; //player 1 and 2
	private int pick; // players pick

    /**
     * construtor
     * constroi o jogo
     * prepara o jogo para jogar
     */
	public Uno() {

		deck = new Deck();
		deck.inicializa();

		penalty = 0;
		current = getStartingCard();

		cardpile = new Deck();
		cardpile.addToDeck(current);
		choice = new Scanner(System.in);
		p1 = new Player("Jogador 1");
		p2 = new Player("Jogador 2");
		distributecards();
		
	
	}


	/**
	 *  esse método simula turnos entre os dois jogadores. quando o turno é par, jogar 1 joga, quando o turno é impar jogador 2 joga.
	 *  this method simulates turns between the two players. when turn is even, player 1 plays and when
     */
	public void game() {
		int turn=0;
		while(!gameOver(p1,p2)) {
			if(turn%2==0) {
			playGame(p1);}
			else {
			playGame(p2);}
			turn++;
		}
		
	}
	
	
	private void distributecards() {
		//este método distribui cartas entre os jogadores
		for(int i=0;i<10;i++) {
			
			if(i%2==0) {
				p1.pickCards(deck.getTopCard());
			}
			
			else {
				p2.pickCards(deck.getTopCard());
			}
			
			
		}
	}


    /**
     *  este metodo pega o jogador atual como parametro
     *  esse método contem o processo do jogo
     */
	public void playGame(Player p) {
		decorate();
		System.out.println(p+", É seu turno\nA carta atual na mesa é:\n"+current);
		decorate();
		showBoard(p);
		decorate();
		
		if(current.isSpecial()) {
			penalty += current.getValue();
			Card pick;
			if(!canOverride(p)) {
				System.out.println("Você não tem nenhuma carta para jogar contra a carta especial atual, sendo assim você sofrerá a penalização");
				for(int i=0;i<penalty;i++) {

					if(deck.isEmpty()) {
						deck = cardpile;
						deck.shuffle();
						cardpile = new Deck();
					}
					pick = deck.getTopCard();
					p.pickCards(pick);
					System.out.println("Você escolheu: \n"+pick);
					pause();
					
				}
				penalty = 0;
				current = deck.getTopCard();
				System.out.println("A nova carta na mesa é: \n"+current);
			}
		}

        if(!hasColor(p) && !hasValue(p) && !hasSpecial(p))
        {
            Card pick;
		    System.out.println("Você não possui nenhuma carta valida para jogar, então tera de comprar cartas.");
		    while(!hasColor(p) && !hasValue(p) && !hasSpecial(p))
            {
				pause();
				pick = deck.getTopCard();
				p.pickCards(pick);
				System.out.println("Você comprou:\n"+pick);
            }
				
            System.out.println("Você comprou uma carta valida!");
			pause();
			System.out.println("Você possui as seguintes cartas: ");
			p.showCards();
        }

		System.out.println("Por favor, escolha uma carta:");
		pick = choice.nextInt()-1;
		//System.out.println(pick);
		
		while(!isValidChoice(p,pick)) {
			
			System.out.println("Escolha invalida, por favor, selecione uma carta valida.");
			pick = choice.nextInt()-1;
			
		}
		
		Card play = p.throwCard(pick);
		
		p.sayUno();
		current = play;
		cardpile.addToDeck(current);
	}
	
	
	private boolean hasSpecial(Player p) {
		for(Card c:p.PlayerCards()) {
			
			if(c.isSpecial()) {
				return true;
			}
			
		}
		
		
		return false;
	}

	private boolean isValidChoice(Player p,int choice) {
		
		/*
		 * Verifica se a escolha do jogador foi valida ou não		 
		 * para ser uma escolha valida: o jogador deve possuir a carta, a carta deve possuir o mesmo valor ou cor que a carta atual.		 
		 */
		
		if(choice <= p.PlayerCards().size()) {
			//add for special
			
			if(p.PlayerCards().get(choice).getColor() == current.getColor() || p.PlayerCards().get(choice).getValue()==current.getValue() || p.PlayerCards().get(choice).isSpecial()) {
				return true;
			}
			
			
		}
		
		return false;
	}
	
	
	private void pause() {
		/*
		 *Cria uma pausa
		 * pergunta ao usuario se deseja continuar
		 * feito apenas para aumentar a interatividade com o usuário
		 */
		System.out.println("Pressione enter para continuar......");
		choice.nextLine();
		
	}
	
		
	private boolean hasColor(Player p) {
		/*
		 * Verifica se o jogador possuir alguma carta com a mesma cor da carta atual na mesa		 
		 */
		for(Card c:p.PlayerCards()) {
			
			if(c.getColor() == current.getColor()) {
				return true;
			}
			
			
		}
		
		return false;
	}
	
	private boolean hasValue(Player p) {  
		/*
		 * Verifica se o jogador possuir alguma carta com o mesmo valor da carta atual na mesa
		 */
		
		for(Card c:p.PlayerCards()) {
			
			if(c.getValue()==current.getValue()) {
				
				return true;
				
			}
		}
		
		return false;
	}
	
	
	private boolean canOverride(Player p) {
		
		/*
		 * Verifica se o jogador possuir alguma carta especial
		 * Cartas especiais podem ser jogadas quando você não possuir uma carta da mesmo cor ou mesmo valor da carta atual na mesa.		 
		 		 
		 */
		for(Card c:p.PlayerCards()) {
			
			if(c.isSpecial()) {
				if(c.getValue() >= current.getValue()) {
					return true;
				}
			}
		}
		
		
		return false;
	}
	
	private void decorate() {
		/*
		 * Desenha linha de asteriscos
		 */
		
		
		System.out.println("***********************************************************************************");
	}
	
	
	
	
	private Card getStartingCard() {
		

		
		Card temp = deck.peek();
		while(temp.isSpecial()) {
			deck.shuffle();
			temp = deck.peek();
		}
		
		temp = deck.getTopCard();
		return temp;
	}
	
	
	


public boolean gameOver(Player p1,Player p2) {
	
	if(p1.hasWon()) {
		System.out.println("**************************************************");
		System.out.println("Jogador 1 venceu");
		System.out.println("**************************************************");
		return true;
	}
	
	else if(p2.hasWon()) {
		System.out.println("**************************************************");
		System.out.println("Jogador 1 venceu");
		System.out.println("**************************************************");
		return true;
	}
	
	return false;
}

public void showBoard(Player p) {
	
	if(p.toString().equals("Jogador 1")) {
		System.out.println("                Jogador 1");
		p1.showCards();
		p2.hideCards();
		System.out.println("                Jogador 2");
		System.out.println("");
	}
	else {
		
		System.out.println("                Jogador 1");
		p1.hideCards();
		p2.showCards();
		System.out.println("                Jogador 2");
		System.out.println("");
		
	}
	
}



}
