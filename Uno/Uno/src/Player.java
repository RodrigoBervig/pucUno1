import java.util.ArrayList;
import java.util.Scanner;
public class Player {
    private ArrayList<Card> playercards;
	private String nome; //nome do jogador

    /**cria um array list que armazena as cartas do jogador, atribui nome ao jogador**/
	public Player(String nome) {
		playercards = new ArrayList<>(); //objeto jogador é criado na classe Uno
        this.nome = "Convidado";
        setNome(nome);
	}

	public void setNome(String nome){
	    if(!(nome == null)) this.nome = nome;
    }
    /**retorna o numero de cartas que o jogador possui na mão**/

    public int numberOfCards(){
		return playercards.size();
	}

	/**Retorna todas as cartas que o jogador possui na mão como um ArrayList
     * Isso é usado para chegar se o jogador tem alguma carta valida para jogar
     **/
	public ArrayList<Card> PlayerCards(){
		return playercards;
	}

	public void pickCards(Card c) {
	    playercards.add(c);
	}
	/** O jogador joga uma carta de sua mão que esta na posição 'c'. c é um valor integer e é passado como parametro**/
    public Card throwCard(int c) {
		return playercards.remove(c);
	}

    /** jogador diz Uno quando tiver apenas uma carta na mão */
	public void sayUno() {
        Scanner s = new Scanner(System.in);
        if (playercards.size()==1){
            System.out.println("Uno");
			System.out.println("Pressione Enter...");
			s.nextLine();
		}
	}
    /** Isso é uma representação gráfica de uma carta
       apenas para fazer as cartas ficarem um pouco mais parecidas com cartas hahaha
       usado no método showboard() na classe Uno
     **/
    public void showCards() {
		StringBuilder sb = new StringBuilder();
		String[] card = {" ----- ","|     |","|     |"," ----- "};
		String c = "";
    for(int i=0;i<card.length;i++) {
        for(int j=0;j<playercards.size();j++){
            if(!playercards.get(j).isSpecial()) {
                if(i==1) {
                        sb.append("| ").append(playercards.get(j).getColor()).append(" |").append(" ");
					    //c = c +"| "+playercards.get(j).getColor()+" |"+" ";
					}
					else if(i==2) {
                    sb.append("| ").append(playercards.get(j).getValue()).append(" |").append(" ");
					    //c = c + "|  "+playercards.get(j).getValue()+"  |"+" ";
					}
					else {
                        sb.append(card[i]).append(" ");
						//c = c + card[i]+" ";
					}
            }
            else if(playercards.get(j).isSpecial()) {
                if(i==1) {
                    sb.append("| ").append(playercards.get(j).getValue()).append(" |").append(" ");
                    //c = c +"| "+"+"+playercards.get(j).getValue()+"  |"+" ";
                }
					else {
                        sb.append(card[i]).append(" ");
						//c = c + card[i]+" ";
					}
            }
        }
        sb.append("\n");
        //c +="\n";
        }
        System.out.print(sb.toString());
    }
	
	public void hideCards() {
        StringBuilder sb = new StringBuilder();
		/*
		 * esconde cartas do jogador		 
		 * usado no método showboard() na classe Uno 
		 */
		
		String[] card = {" ----- ","|     |","|     |"," ----- "};
		String c = "";
		
		
		for(int i=0;i<card.length;i++) {
				
			for(int j=0;j<playercards.size();j++){
			    sb.append(c).append(card[i]);
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
