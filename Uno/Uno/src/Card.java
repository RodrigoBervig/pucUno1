
public class Card {
	
	private String cor;
	private int valor;
	private int valorEsp;
	private boolean special;

	public Card(int valor,String cor) {
		
		/*
		 * constroi uma carta não especial 
		 * seta a cor e valor numérico
		 * seta a carta na categoria normal
		 */
		
		
		this.cor = cor;
		this.valor = valor;
		this.valorEsp = 0;
		this.special = false;
	}
	
	
	public Card(int valorEsp) { // Construtor para cartas especiais como +4 e +2	
		
		/*
		 * designa o valor especial para a a carta
		 * seta a carta na categoria especiais
		 */
		
		this.cor="";
		this.valorEsp = valorEsp;
		this.valor = 0;
		this.special = true;
	}
	
	public String getColor() {
		/*
		 * Retorna a cor da carta
		 */
		
		return this.cor;
	}
	
	public int getValue() {
		
		/*
		 * retorna o valor numérico da carta
		 */
		
		if(!this.special) {
		return this.valor;}
		
		else {
			return this.valorEsp;
		}
	}
	
	public String toString() {
		
		/*
		 * Printa a Carta.
		 * printa [ cor - card value ] se a carta não for especial
		 * printa [ + value ] se a carta for especial
		 */
		
//		if(!special) {
//			return "[ "+this.color+"-"+this.value+" ]";
//		}
//		
//		else if(special){
//			
//			return "[ "+"+"+this.specialValue+" ]"; 
//		}
//		return null;
		
		String[] card = {" ----- ","|     |","|     |"," ----- "};
		String c = "";
		
		
		for(int i=0;i<card.length;i++) {
				
			for(int j=0;j<1;j++) {
					
				if(!this.isSpecial()) {
					if(i==1) {
						
						c = c +"| "+this.getColor()+" |"+" ";
						
					}
					
					else if(i==2) {
						
						c = c + "|  "+this.getValue()+"  |"+" ";
					}
					
					else {
						c = c + card[i]+" "; 
					}
					
					}
				
				else if(this.isSpecial()) {
					
					if(i==1) {
						
						c = c +"| "+"+"+this.getValue()+"  |"+" ";
						
					}
					else {
						c = c + card[i]+" ";
					}
					
				}
				
					}
				
				c +="\n";
				
			}
				
		
		
		
		return c;
		
		
		
		
	}
	
	public boolean isSpecial() {
		
		/*
		 * retorna true se a carta for especial
		 * retorna true se a carta não for especial
		 */
		
		
		if(special) {
			return true;
		}
		
		return false;
	}
	
	
	
	
	
}
