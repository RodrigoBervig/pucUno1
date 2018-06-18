import java.util.Scanner;
import java.io.IOException;

public class Uno
{
	private Card current; //a carta atual ou carta anterior do jogador ou carta inicial
	private Deck deck; // o deck do jogo
	private Deck cardpile; //quando os jogadores jogam uma carta, ela é empilhada aqui, também, cria um novo deck quando o deck atual estiver vazio
	private int penalty; // quando cartas especiais são acumuladas  a penalidade acumula, se um jogador não tiver como counterar a carta especial atual, o jogador é penalizado
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

		p1 = new Player("Jogador 1");
		p2 = new Player("Jogador 2");
		distributecards();
	}


	/**
	 *  esse método simula turnos entre os dois jogadores. quando o turno é par, jogar 1 joga, quando o turno é impar jogador 2 joga.
	 *  this method simulates turns between the two players. when turn is even, player 1 plays and when
     */
	public void game() throws IOException, InterruptedException
    {
		int turn = 0;
		Player currentPlayer;
		do
        {
            if(turn%2==0) currentPlayer = p1;
            else currentPlayer = p2;

            cls();
            System.out.println("Proximo jogador: \n\n\n\n\n\n" + currentPlayer.getName());
            pause();

            playGame(currentPlayer);
			turn++;
		} while(!gameOver(p1,p2));
	}
	
	
	private void distributecards()
    {
		for(int i=0;i<7;i++)
		{
            p1.add(deck.getTopCard());
            p2.add(deck.getTopCard());
		}
	}


    /**
     *  este metodo pega o jogador atual como parametro
     *  esse método contem o processo do jogo
     */
	public void playGame(Player p) throws IOException, InterruptedException
    {
        Scanner choice = new Scanner(System.in);

        showBoard(p);
		int pickchoice;

		if(current.getPenalty() > 0)
		{
            penalty += current.getPenalty();

			if(!canOverride(p))
			{
				System.out.println("Você não tem nenhuma carta para jogar contra a carta especial atual, sendo assim você sofrerá a penalização");
				System.out.println("Penalização: " + penalty);
				compra(p, penalty);
				penalty = 0;
				current = deck.getTopCard();
				showBoard(p);
				return;
			}
		}

        if (!p.hasCardToPutAbove(current))
            System.out.println("Você não possui nenhuma carta valida para jogar, então tera de comprar cartas.");
        System.out.println("Por favor, escolha uma carta (digite zero para comprar): ");

        pickchoice = choice.nextInt()-1;
        while(!isValidChoice(p,pickchoice))
        {
            System.out.println("Escolha invalida! Por favor, tente novamente: ");
            pickchoice = choice.nextInt()-1;
        }

        if (pickchoice == -1)
        {
            compra(p, 1);
            showBoard(p);
            pause();
        }
        else
        {
            Card play = p.remove(pickchoice);
            p.sayUno();
            current = play;
            cardpile.addToDeck(current);
            if (play.isCoringa())
            {
                System.out.println("Carta jogada é um curinga. Escolha uma cor (1 - red, 2 - green, 3 - blue, 4 - yellow): ");
                int cor = choice.nextInt();

                if (cor < 1 || cor > 4)
                {
                    System.out.println("Opcao invalida! Tente novamente.");
                    cor = choice.nextInt();
                }

                play.setCor(cor);
            }
        }
	}

    /**
     * Verifica se a escolha do jogador foi valida ou não
     * para ser uma escolha valida: o jogador deve possuir a carta, a carta deve possuir o mesmo valor ou cor que a carta atual.
     */
	private boolean isValidChoice(Player p,int choice)
    {
        if (choice == -1) return true;
        if (choice < 0 || choice >= p.getNumCards()) return false;
        return p.cardAt(choice).canPutThisAbove(current);
	}

    /**
     *Cria uma pausa
     * pergunta ao usuario se deseja continuar
     * feito apenas para aumentar a interatividade com o usuário
     */
	private void pause()
    {
	    Scanner in = new Scanner(System.in);
	    String opcao;

		System.out.println("Digite s para salvar o jogo ou qualquer outra coisa para continuar......");
		opcao = in.nextLine();

		System.out.print(opcao); // so pro compilador nao reclamar

		//TODO if (opcao.equals("s")) savegame();
	}

	private boolean savegame()
    {
        //TODO

        return true;
    }

	private boolean compra (Player p, int penalty)
    {
        Card pick;
        for(int i=0;i<penalty;i++)
        {
            if(deck.isEmpty()) {
                if (cardpile.isEmpty()) return false;
                deck = cardpile;
                deck.shuffle();
                cardpile = new Deck();
            }
            pick = deck.getTopCard();
            p.add(pick);
        }

        return true;
    }

    /**
     * Verifica se o jogador possuir alguma carta especial de compra.
     */
	private boolean canOverride(Player p) {
		for(int i = 0; i < p.getNumCards(); i++) {
			if(p.cardAt(i).getPenalty() != 0) {
				if(p.cardAt(i).getValue() >= current.getValue()) {
					return true;
				}
			}
		}
		
		
		return false;
	}

    /**
     * Desenha linha de asteriscos.
     */
	private void decorate() {
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

    public void showBoard(Player p) throws IOException, InterruptedException
    {
        cls();
        decorate();
        System.out.println(p.getName() + ", É seu turno\nA carta atual na mesa é:\n"+current);
        decorate();
        showCards(p);
	    decorate();
    }

    private void showCards (Player p) throws IOException, InterruptedException
    {
        if(p == p1) {
            System.out.println("                Jogador 1");
            p1.showCards();
            p2.hideCards();
            System.out.println("                Jogador 2\n");
        }
        else
        {
            System.out.println("                Jogador 1");
            p1.hideCards();
            p2.showCards();
            System.out.println("                Jogador 2\n");
        }
    }

    private void cls() throws IOException, InterruptedException
    {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}
