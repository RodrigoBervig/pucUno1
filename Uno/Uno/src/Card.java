/**
 * Essa classe implementa uma carta de UNO.
 */
public class Card
{
    private int cor;
	private int valor;

	/*
	    Cores:
	        0 - No color (specials)
	        1 - Red
	        2 - Green
	        3 - Blue
	        4 - Yellow

	    Valor especial:
	        10 - Pula
	        11 - Retorno
	        12 - Compra 2
	        13 - Coringa (sem cor a priori)
	        14 - Compra 4 (sem cor a priori)

	 */

    /**
     * Construtor padrão de carta.
     * @param valor valor (inteiro) da carta
     * @param cor   a cor da carta (inteiro).
     */
	public Card(int valor, int cor) {
		setCor(cor);
		setValor(valor);
	}

    private void setCor(int cor) {
        if(cor >= 0 && cor <= 4)
            this.cor = cor;
    }

    private void setValor(int valor){
        if(valor >= 0 && valor <=14) this.valor = valor;
    }

    /** Retorna a cor da carta*/
    public int getColor(){
	    return this.cor;
	}

	public String getColorString()
    {
        switch(this.cor)
        {
            case 1: return "red";
            case 2: return "gre";
            case 3: return "blu";
            case 4: return "yel";
            default: return "   ";
        }
    }

	/** Retorna o valor da Carta*/
	public int getValue(){
        return this.valor;
	}

	public String getValueString()
    {
        switch(valor)
        {
            case 10: return "pul";
            case 11: return "inv";
            case 12: return "+2 ";
            case 13: return "cur";
            case 14: return "+4 ";
            default: return " " + valor + " ";
        }
    }

    /** Método que checa se a carta é especial. True se for; False se não for. */
    public boolean isSpecial() { //Como se fosse getSpecial()
        return valor >= 10;
    }

    public boolean isCoringa() {
        return valor >= 13;
    }

    public String toString() {
        return " ----- \n| " + this.getColorString() + " \n| " +
                this.getValueString() + " | \n ----- \n";
	}

	public boolean canPutThisAbove (Card below)
    {
        if (this.isCoringa()) return true;
        return below.getColor() == this.getColor() || below.getValue() == below.getValue();
    }

    public int getPenalty ()
    {
        if (valor == 12 || valor == 14) return valor - 10;
        return 0;
    }
}
