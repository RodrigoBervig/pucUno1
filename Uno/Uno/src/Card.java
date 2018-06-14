public class Card {
    private String cor;
	private int valor;
	private int valorEsp;
	private boolean special;

	public Card(int valor,String cor) {
		setCor(cor);
		setValor(valor);
		this.valorEsp = 0;
		//this.special = false; Java já starta valores booleanos com False
	}

	/** Método construtor para cartas especiais(+2 e +4)*/
	public Card(int valorEsp) {
	    this.cor="";
		setValorEsp(valorEsp);
		this.valor = 0;
		setSpecial(); //Seta a Carta na categoria especiais.
	}

    public void setCor(String cor) {
        if(cor.equalsIgnoreCase("vermelho") || cor.equalsIgnoreCase("azul") ||
           cor.equalsIgnoreCase("verde") || cor.equalsIgnoreCase("amarelo" ))
            this.cor = cor;
    }
    public void setValor(int valor){
        if(valor >= 0 && valor <=9) this.valor = valor;
    }
    public void setValorEsp(int valorEsp) {
        if(valorEsp == 2 || valorEsp == 4)this.valorEsp = valorEsp;
    }
    /** Troca o valor booleano de special*/
    public void setSpecial(){
	    this.special = !special;
    }

    /** Retorna a cor da carta*/
    public String getColor(){
	    return this.cor;
	}
	/** Retorna o valor da Carta*/
	public int getValue(){
	    if(!this.special) {
		return this.valor;}
		else {
			return this.valorEsp;
		}
	}
    public int getValorEsp() {
        return valorEsp;
    }
    /** Método que checa se a carta é especial. True se for; False se não for. */
    public boolean isSpecial() { //Como se fosse GetSpecial()
        return special;
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
//		else if(special){
//			return "[ "+"+"+this.specialValue+" ]"; 
//		}
//		return null;
        StringBuilder sb = new StringBuilder();
		String[] card = {" ----- ", "|     |", "|     |", " ----- "};
		String c = "";
		for(int i=0; i<card.length; i++) {
		    for(int j=0;j<1;j++) {
		        if(!this.isSpecial()) {
					if(i==1){
						sb.append(c).append("| ").append(this.getColor()).append(" |").append(" ");
                       //  c = c +"| "+this.getColor()+" |"+" ";
					}
					else if(i==2){
                        sb.append(c).append("| ").append(this.getValue()).append(" |").append(" ");
                        //c = c + "|  "+this.getValue()+"  |"+" ";
					}
					else{
					    sb.append(c).append(card[i]).append(" ");
                        //c = c + card[i]+" ";
					}
		        }
				else if(this.isSpecial()){
					if(i==1){
                        sb.append(c).append("| ").append(this.getValue()).append(" |").append(" ");
                        //c = c +"| "+"+"+this.getValue()+"  |"+" ";
					}
					else{
                        sb.append(c).append(card[i]).append(" ");
                        //c = c + card[i]+" ";
					}
		        }
		    }
		    sb.append(c).append("\n");
            //c +="\n";
		}
		return sb.toString();
	}
}
